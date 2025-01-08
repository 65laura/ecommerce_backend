package com.onlineshopping.trial.controller;

import com.onlineshopping.trial.model.Categories;
import com.onlineshopping.trial.service.ICategoryService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category creation", content = @Content(schema = @Schema(implementation = Categories.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/create")
    public Categories createCategory(String categoryName){
        return categoryService.createCategory(categoryName);
    }
}
