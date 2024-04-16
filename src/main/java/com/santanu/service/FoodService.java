package com.santanu.service;

import com.santanu.Exception.FoodException;
import com.santanu.Exception.RestaurantException;
import com.santanu.model.Category;
import com.santanu.model.Food;
import com.santanu.model.Restaurant;
import com.santanu.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) throws FoodException, RestaurantException;

    void deleteFood(Long foodId) throws FoodException;

    public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegetarian, boolean isNonVeg, boolean isSeasonal, String foodCategory) throws FoodException;

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long foodId) throws FoodException;

    public Food updateAvailabilityStatus(Long foodId) throws FoodException;
}
