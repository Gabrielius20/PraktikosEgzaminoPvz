package com.spring.FoodOrdering.service;

import com.spring.FoodOrdering.model.Order;

public interface OrderService {
    void save(Order order);
    boolean existsByMealIdAndUserId(int mealId, int userId);
}
