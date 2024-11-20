package com.onlineshopping.trial.products.service;

import com.onlineshopping.trial.dto.ProductDto;
import com.onlineshopping.trial.enums.EProductCategory;
import com.onlineshopping.trial.products.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    Products createProduct(ProductDto products);
    Products updateProduct(UUID productId,ProductDto productDto);
    List<Products> getAllProducts();
    Products getProductById(UUID productId);

    Page<Products> searchProducts(String searchParam, EProductCategory productCategory,Pageable pageable);


}
