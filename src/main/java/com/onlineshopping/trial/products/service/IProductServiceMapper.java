package com.onlineshopping.trial.products.service;

import com.onlineshopping.trial.dto.ProductDto;
import com.onlineshopping.trial.products.model.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = IgnoreNullMappingConfig.class,componentModel = "Spring")
public interface IProductServiceMapper {
    @Mapping(target = "productName", ignore = true)
    @Mapping(target = "productCategory", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "discountedPrice", ignore = true)
    @Mapping(target = "description", ignore = true)
    Products toProductServiceEntity(ProductDto productDto);
}
