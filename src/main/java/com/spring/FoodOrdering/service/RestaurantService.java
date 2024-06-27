package com.spring.FoodOrdering.service;

import com.spring.FoodOrdering.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    void save(Restaurant restaurant);

    List<String> findAllRestaurantNames();
    List<Restaurant> findAll();
    void deleteById(int id);
    Optional<Restaurant> findById(int id);
}
