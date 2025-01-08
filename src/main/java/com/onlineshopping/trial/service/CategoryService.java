package com.onlineshopping.trial.service;

import com.onlineshopping.trial.model.Categories;
import com.onlineshopping.trial.repositories.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoriesRepository categoriesRepository;
    @Override
    public Categories createCategory(String categoryName) {
        Optional<Categories> existingCategory = categoriesRepository.findCategoriesByName(categoryName);
        if (existingCategory.isPresent()){
            throw new RuntimeException("category already exists");
        }
        Categories categories = new Categories();
        categories.setCategoryName(categoryName);
        return categoriesRepository.save(categories);
    }}
