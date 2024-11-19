package com.onlineshopping.trial.dto;

import com.onlineshopping.trial.enums.EProductCategory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductDto {

    @NotNull(message = "productName can not be null")
    private String productName;
    private EProductCategory productCategory;
    @NotNull(message = "price can not be null")
    private double price;
    private double discountedPrice;
    @NotNull(message = "description can not be null")
    private String description;


}
