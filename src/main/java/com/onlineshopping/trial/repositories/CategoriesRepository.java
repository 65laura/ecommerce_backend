package com.onlineshopping.trial.repositories;
import com.onlineshopping.trial.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CategoriesRepository extends JpaRepository<Categories, UUID> {
    @Query("SELECT c FROM Categories c WHERE c.categoryName = :categoryName")
    Optional<Categories> findCategoriesByName(@Param("categoryName") String categoryName);
}
