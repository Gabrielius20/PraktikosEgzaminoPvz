package com.spring.FoodOrdering.repository;

import com.spring.FoodOrdering.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    boolean existsByMealIdAndUserId(int mealId, int userId);
}
