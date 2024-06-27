package com.spring.FoodOrdering.controller;

import com.spring.FoodOrdering.model.Meal;
import com.spring.FoodOrdering.service.MealService;
import com.spring.FoodOrdering.service.CustomUserDetails;
import com.spring.FoodOrdering.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MealController {

    @Autowired
    MealService mealService;

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Meal> mealList = mealService.getAll();
        model.addAttribute("mealList", mealList);
        return "dashboard";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> restaurants = restaurantService.findAllRestaurantNames();
        model.addAttribute("restaurants", restaurants);
        model.addAttribute("meal", new Meal());
        return "create";
    }

    @PostMapping("/create")
    public String createSubmit(@ModelAttribute Meal meal, Model model) {
        mealService.save(meal);
        return "redirect:/dashboard";
    }
    @GetMapping("/meal/edit/{id}")
    public String editMeal(@PathVariable("id") int id, Model model) {
        Optional<Meal> meal = mealService.findById(id);
        List<String> restaurants = restaurantService.findAllRestaurantNames();
        model.addAttribute("restaurants", restaurants);
        model.addAttribute("meal", meal);
        return "edit-meal";
    }
    @PostMapping("/meal/edit")
    public String editMealSubmit(@ModelAttribute Meal meal) {
        mealService.save(meal);
        return "redirect:/dashboard";
    }
    @GetMapping("/meal/delete/{id}")
    public String deleteMeal(@PathVariable("id") int id, Model model){
        mealService.deleteById(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/dashboard/search")
    public String searchMeals(@RequestParam("query") String query, Model model) {
        List<Meal> filteredMeals = mealService.findMealsByTitle(query);
        model.addAttribute("mealList", filteredMeals);
        return "dashboard";
    }
    @GetMapping("/meal/order/{mealId}/{userId}")
    public String deleteMeal(@PathVariable("mealId") int mealId, @PathVariable("userId") int userId){
        Optional<Meal> optionalMeal = mealService.findById(mealId);
        if (optionalMeal.isPresent() && !optionalMeal.get().ordered()) {
            Meal meal = optionalMeal.get();
            meal.setOrderId(userId);
            meal.setOrdered(true);
            mealService.save(meal);
        }
        return "redirect:/dashboard";
    }
    @GetMapping("/account")
    public String account(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        int userId = customUserDetails.getId();
        List<Meal> reservedMeals = mealService.findMealsByOrderId(userId);
        model.addAttribute("reservedMeals", reservedMeals);
        return "account";
    }
    @GetMapping("/account/unorder/{id}")
    public String removeOrder(@PathVariable("id") int id){
        Optional<Meal> optionalMeal = mealService.findById(id);
        if (optionalMeal.isPresent()) {
            Meal meal = optionalMeal.get();
            meal.setOrderId(0);
            meal.setOrdered(false);
            mealService.save(meal);
        }
        return "redirect:/account";
    }

}
