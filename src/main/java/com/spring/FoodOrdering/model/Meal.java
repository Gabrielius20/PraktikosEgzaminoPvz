package com.spring.FoodOrdering.model;

import jakarta.persistence.*;

@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "portions")
    private int portionCount;
    @Column(name = "restaurant")
    private String restaurant;
    @Column(name = "ordered")
    private boolean ordered;
    @Column(name = "order_id")
    private int orderId;

    public Meal() {
    }
    public Meal(String title, int portionCount, String restaurant, boolean ordered, int orderId) {
        this.title = title;
        this.portionCount = portionCount;
        this.restaurant = restaurant;
        this.ordered = ordered;
        this.orderId = orderId;
    }
    public Meal(int id, String title, int portionCount, String restaurant, boolean ordered, int orderId) {
        this.id = id;
        this.title = title;
        this.portionCount = portionCount;
        this.restaurant = restaurant;
        this.ordered = ordered;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPortionCount() {
        return portionCount;
    }

    public void setPortionCount(int portionCount) {
        this.portionCount = portionCount;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public boolean ordered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pageCount=" + portionCount +
                ", genre='" + restaurant + '\'' +
                ", reserved=" + ordered +
                ", reservationId=" + orderId +
                '}';
    }
}
