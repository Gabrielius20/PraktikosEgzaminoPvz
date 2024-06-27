package com.spring.FoodOrdering.service;

import com.spring.FoodOrdering.model.Meal;

import java.util.List;
import java.util.Optional;

public interface MealService {
    void save(Meal meal);
    List<Meal> getAll();
    void deleteById(int id);
    Optional<Meal> findById(int id);
    List<Meal> findMealsByTitle(String query);
    List<Meal> findMealsByOrderId(int id);
}
