package com.onlineshopping.trial.controller;

import com.onlineshopping.trial.model.Cart;
import com.onlineshopping.trial.service.CartService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CartController {
    private  final CartService cartService;
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cart creation", content = @Content(schema = @Schema(implementation = Cart.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })

    @PostMapping("Cart/create")
    public Cart createProduct(UUID cartId,UUID productId,Integer quantity){
        return cartService.addProductToCart(cartId,productId,quantity);
    }

}
