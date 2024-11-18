package com.onlineshopping.trial.products.repository;
import com.onlineshopping.trial.enums.EProductCategory;
import com.onlineshopping.trial.products.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {
    @Query("SELECT p FROM Products p WHERE p.productName = :productName")
   Optional<Products> findProductsByproductName(@Param("productName") String productName);
    @Query("SELECT p FROM Products p WHERE " +
            "LOWER(p.productName) LIKE %:searchParam% OR " +
            "p.productCategory = :category")
    Page<Products> searchProducts(@Param("searchParam") String searchParam,
                                 @Param("category") EProductCategory category,
                                 Pageable pageable);



}
