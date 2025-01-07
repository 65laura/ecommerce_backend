package com.onlineshopping.trial.dto;

import com.onlineshopping.trial.enums.EProductCategory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductDto {

    @NotNull(message = "product name can't be null")
    private String productName;
    @NotNull(message = "product category can't be null")
    private EProductCategory productCategory;
    @NotNull(message = "price can't be null")
    private double price;
    private double discountedPrice;
    @NotNull(message = "description can't be null")
    private String description;


}
