package com.onlineshopping.trial.dto;

import com.onlineshopping.trial.enums.EProductCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String productName;
    private EProductCategory productCategory;
    private double price;
    private double discountedPrice;
    private String description;


}
