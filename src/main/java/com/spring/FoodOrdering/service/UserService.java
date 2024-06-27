package com.spring.FoodOrdering.service;

import com.spring.FoodOrdering.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
