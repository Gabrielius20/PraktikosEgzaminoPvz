package com.spring.FoodOrdering.repository;

import com.spring.FoodOrdering.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
    List<Meal> findByTitleContainingIgnoreCase(String query);
    List<Meal> findByOrderId(int id);
}