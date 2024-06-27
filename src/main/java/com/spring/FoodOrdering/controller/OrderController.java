package com.spring.FoodOrdering.controller;

import com.spring.FoodOrdering.model.Order;
import com.spring.FoodOrdering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/meal/reserve/{mealId}/{userId}")
    public String orderMeal(@PathVariable("mealId") int mealId, @PathVariable("userId") int userId){
        if (!orderService.existsByMealIdAndUserId(mealId, userId)) {
            orderService.save(new Order(mealId, userId));
        }
        return "redirect:/dashboard";
    }
}
