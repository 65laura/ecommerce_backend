package com.onlineshopping.trial.products.service;

import com.onlineshopping.trial.dto.ProductDto;
import com.onlineshopping.trial.products.model.Products;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(value = "org.mapstruct.ap.MappingProcessor",
        date = "2024-10-03T21:17:15+0200",
        comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)")
@Component
public class ProductServiceMapper implements IProductServiceMapper{

    @Override
    public Products toProductServiceEntity(ProductDto productDto) {
   if (productDto == null){
     return null;
   }
   Products product = new Products();
   product.setProductName(productDto.getProductName());
   product.setPrice(productDto.getPrice());
   product.setDiscountedPrice(productDto.getDiscountedPrice());
   product.setDescription(productDto.getDescription());
   return product;
    }
}
