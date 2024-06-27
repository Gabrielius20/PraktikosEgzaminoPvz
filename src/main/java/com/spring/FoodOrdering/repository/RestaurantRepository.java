package com.spring.FoodOrdering.repository;

import com.spring.FoodOrdering.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("SELECT r.name FROM Restaurant r")
    List<String> findAllRestaurantNames();
}
