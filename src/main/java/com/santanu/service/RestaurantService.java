package com.santanu.service;

import com.santanu.Exception.RestaurantException;
import com.santanu.dto.RestaurantDto;
import com.santanu.model.Restaurant;
import com.santanu.model.User;
import com.santanu.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user);

    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws RestaurantException;

    public void deleteRestaurant(Long restaurantId) throws RestaurantException;

    public List<Restaurant> getAllRestaurant();

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws RestaurantException;

    public Restaurant getRestaurantsByUserId(Long userId) throws RestaurantException;

    public RestaurantDto addToFavorites(Long restaurantId, User user) throws RestaurantException;

    public Restaurant updateRestaurantStatus(Long id) throws RestaurantException;
}
