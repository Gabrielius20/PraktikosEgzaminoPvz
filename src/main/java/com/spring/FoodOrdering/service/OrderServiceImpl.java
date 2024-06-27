package com.spring.FoodOrdering.service;

import com.spring.FoodOrdering.model.Order;
import com.spring.FoodOrdering.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public boolean existsByMealIdAndUserId(int mealId, int userId) {
        return orderRepository.existsByMealIdAndUserId(mealId,userId);
    }
}
