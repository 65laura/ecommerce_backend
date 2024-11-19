package com.onlineshopping.trial.products.service;
import com.onlineshopping.trial.dto.ProductDto;
import com.onlineshopping.trial.enums.EProductCategory;
import com.onlineshopping.trial.products.model.Products;
import com.onlineshopping.trial.products.repository.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductsServiceImpl implements IProductService {

    public final ProductsRepository productsRepository;
    public final IProductServiceMapper productServiceMapper;


    @Override
    @SneakyThrows
    public Products createProduct(ProductDto productDto) {
        Optional<Products> existingProduct = productsRepository.findProductsByproductName(productDto.getProductName());
        if (existingProduct.isPresent()) {
            throw new RuntimeException("Product already exists");
        }
        Products products = new Products();
        products.setProductCategory(productDto.getProductCategory());
        products.setProductName(productDto.getProductName());
        products.setDescription(productDto.getDescription());
        products.setPrice(productDto.getPrice());
        products.setDiscountedPrice(productDto.getDiscountedPrice());

    return productsRepository.save(products);
    }

    @Override
    public Products updateProduct(UUID productId, ProductDto productDto) {
        Optional<Products> existingProduct = productsRepository.findById(productId);
        if (existingProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        Products products = existingProduct.get();
        products.setProductCategory(productDto.getProductCategory());
        products.setProductName(productDto.getProductName());
        products.setDescription(productDto.getDescription());
        products.setPrice(productDto.getPrice());
        products.setDiscountedPrice(productDto.getDiscountedPrice());
        return productsRepository.save(products);
    }


    @Override
    public Page<Products> getAllProducts(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public Products getProductById(UUID productId) {
        return productsRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    @Override
    public Page<Products> searchProducts(String searchParam, EProductCategory productCategory, Pageable pageable) {
        return productsRepository.searchProducts(searchParam,productCategory,pageable);
    }


}
