package com.onlineshopping.trial.products.controller;

import com.onlineshopping.trial.dto.ProductDto;
import com.onlineshopping.trial.enums.EProductCategory;
import com.onlineshopping.trial.enums.PageUtil;
import com.onlineshopping.trial.products.service.IProductService;
import com.onlineshopping.trial.products.model.Products;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductsController {

    private final IProductService productService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product creation", content = @Content(schema = @Schema(implementation = Products.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) }) @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("create")
    public Products createProduct(ProductDto productDto){
        return productService.createProduct(productDto);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated", content = @Content(schema = @Schema(implementation = Products.class))),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    })
    @PutMapping("update")
    public Products updateProduct(@RequestHeader UUID productId, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productId, productDto);
  }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products retrieved", content = @Content(schema = @Schema(implementation = Products.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    })
    @GetMapping("all")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved", content = @Content(schema = @Schema(implementation = Products.class))),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    })
    @GetMapping("/productId")
    public Products getProductById(@RequestHeader UUID productId) {
        return productService.getProductById(productId);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products retrieved", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    })
    @GetMapping("/search")
    public Page<Products> searchProducts(@RequestParam String searchParam, @RequestParam(required = false) EProductCategory productCategory,@RequestHeader Integer pageNumber, @RequestHeader Integer pageSize ) {
        return productService.searchProducts(searchParam, productCategory,PageUtil.getPageable(pageNumber,pageSize));
    }

}
