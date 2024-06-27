package com.spring.FoodOrdering.service;

import com.spring.FoodOrdering.model.Meal;
import com.spring.FoodOrdering.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private MealRepository mealRepository;
    @Override
    public void save(Meal meal) {
        mealRepository.save(meal);
    }

    @Override
    public List<Meal> getAll(){
        return mealRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        mealRepository.deleteById(id);
    }
    @Override
    public Optional<Meal> findById(int id) {
        return mealRepository.findById(id);
    }

    @Override
    public List<Meal> findMealsByTitle(String query) {
        return mealRepository.findByTitleContainingIgnoreCase(query);
    }

    @Override
    public List<Meal> findMealsByOrderId(int id) {
        return mealRepository.findByOrderId(id);
    }
}
