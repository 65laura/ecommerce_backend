package com.onlineshopping.trial.products.controller;

import com.onlineshopping.trial.dto.ProductDto;
import com.onlineshopping.trial.products.service.IProductService;
import com.onlineshopping.trial.products.model.Products;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
@RequiredArgsConstructor
public class ProductsController {

    private final IProductService productService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product creation", content = @Content(schema = @Schema(implementation = Products.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
//    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("product/create")
    public Products createProduct(ProductDto productDto){
        return productService.createProduct(productDto);
    }
  }
