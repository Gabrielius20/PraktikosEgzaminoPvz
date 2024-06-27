package com.spring.FoodOrdering.controller;

import com.spring.FoodOrdering.model.Restaurant;
import com.spring.FoodOrdering.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @GetMapping("/restaurant")
    public String restaurant(Model model) {
        List<Restaurant> restaurantList = restaurantService.findAll();
        model.addAttribute("restaurantList", restaurantList);
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant";
    }

    @PostMapping("/restaurant")
    public String restaurantSubmit(@ModelAttribute Restaurant restaurant, Model model) {
        restaurantService.save(restaurant);
        return "redirect:/restaurant";
    }
    @GetMapping("/restaurant/delete/{id}")
    public String deleteRestaurant(@PathVariable("id") int id, Model model){
        restaurantService.deleteById(id);
        return "redirect:/restaurant";
    }
    @GetMapping("/restaurant/edit/{id}")
    public String editRestaurant(@PathVariable("id") int id, Model model) {
        Optional<Restaurant> restaurant = restaurantService.findById(id);
        model.addAttribute("restaurant", restaurant);
        return "edit-restaurant";
    }
    @PostMapping("/restaurant/edit")
    public String editRestaurantSubmit(@ModelAttribute Restaurant restaurant) {
        restaurantService.save(restaurant);
        return "redirect:/restaurant";
    }
}
