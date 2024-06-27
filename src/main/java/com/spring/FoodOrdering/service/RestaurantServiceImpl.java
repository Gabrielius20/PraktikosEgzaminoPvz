package com.spring.FoodOrdering.service;

import com.spring.FoodOrdering.model.Restaurant;
import com.spring.FoodOrdering.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
    @Override
    public List<String> findAllRestaurantNames() {
        return restaurantRepository.findAllRestaurantNames();
    }
    @Override
    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Optional<Restaurant> findById(int id) {
        return restaurantRepository.findById(id);
    }

}
