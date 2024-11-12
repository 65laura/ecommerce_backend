package com.onlineshopping.trial.dto;

import com.onlineshopping.trial.enums.EProductCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductDto {
    private String productName;
    private EProductCategory productCategory;
    private double price;
    private double discountedPrice;
    private String description;


}
