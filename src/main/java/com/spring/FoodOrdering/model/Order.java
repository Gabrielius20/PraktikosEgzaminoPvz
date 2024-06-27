package com.spring.FoodOrdering.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "meal_id")
    private int mealId;
    @Column(name = "user_id")
    private int userId;

    public Order() {
    }

    public Order(int id, int mealId, int userId) {
        this.id = id;
        this.userId = userId;
        this.mealId = mealId;
    }

    public Order(int mealId, int userId) {
        this.userId = userId;
        this.mealId = mealId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setOrder_id(int orderId) {
        this.mealId = orderId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", orderId='" + mealId + '\'' +
                '}';
    }
}
