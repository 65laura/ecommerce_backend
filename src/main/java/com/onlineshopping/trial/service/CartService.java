package com.onlineshopping.trial.service;
import com.onlineshopping.trial.model.Cart;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface CartService {

    Cart addProductToCart (UUID cartId,UUID productId,Integer quantity);
    List<Cart> getAllCartItems();


}
