package com.onlineshopping.trial.service.impl;

import com.onlineshopping.trial.model.Cart;
import com.onlineshopping.trial.model.CartItem;
import com.onlineshopping.trial.products.model.Products;
import com.onlineshopping.trial.products.repository.ProductsRepository;
import com.onlineshopping.trial.repositories.CartRepository;
import com.onlineshopping.trial.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductsRepository productsRepository;


    @Override
    public Cart addProductToCart(UUID cartId,UUID productId, Integer quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Products product = productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Check if the product is already in the cart
        CartItem existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem();
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            newItem.setCart(cart);
            cart.getItems().add(newItem);
        }
        double totalPrice = cart.getItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(totalPrice);

        return cartRepository.save(cart);
    }
    }

   