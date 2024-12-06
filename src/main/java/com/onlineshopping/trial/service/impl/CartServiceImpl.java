package com.onlineshopping.trial.service.impl;

import com.onlineshopping.trial.model.Cart;
import com.onlineshopping.trial.repositories.CartRepository;
import com.onlineshopping.trial.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Optional<Cart> findByCartId(UUID cartId) {
        return cartRepository.findById(cartId);
    }
    @Override

}
   