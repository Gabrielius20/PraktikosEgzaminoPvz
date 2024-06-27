package com.spring.FoodOrdering.config;

import com.spring.FoodOrdering.repository.UserRepository;
import com.spring.FoodOrdering.service.UserDetailsServiceImpl;
import com.spring.FoodOrdering.service.UserService;
import com.spring.FoodOrdering.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SpringConfig {

    @Autowired
    public SpringConfig(UserRepository userRepository) {
    }

    @Bean
    @Qualifier("UserDetailsService")
    public UserDetailsService getuserDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    @Qualifier("UserService")
    public UserService getUserService(){
        return new UserServiceImpl();
    }
}
