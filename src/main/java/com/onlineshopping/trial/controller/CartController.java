package com.onlineshopping.trial.controller;

import com.onlineshopping.trial.model.Cart;
import com.onlineshopping.trial.service.CartService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {
    private  final CartService cartService;
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cart creation", content = @Content(schema = @Schema(implementation = Cart.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })

    @PostMapping("create")
    public Cart addToCart (UUID cartId,UUID productId,Integer quantity){
        return cartService.addProductToCart(cartId,productId,quantity);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "get all cart items", content = @Content(schema = @Schema(implementation = Cart.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })

    @GetMapping("all")
    public List<Cart> getAllCartItems (){
        return cartService.getAllCartItems();
}}
