package com.santanu.service;

import com.santanu.Exception.RestaurantException;
import com.santanu.model.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(String name, Long userId) throws RestaurantException;

    public List<Category> findCategoryByRestaurantId(Long restaurantId) throws RestaurantException;

    public Category findCategoryById(Long id) throws RestaurantException;
}
