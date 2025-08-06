package com.mywork.food_delivery.repo;

import com.mywork.food_delivery.entity.FoodOrderEntity;

import java.util.List;

public interface FoodOrderRepo {
    boolean save(FoodOrderEntity entity);

    boolean deleteById(int id);

    FoodOrderEntity findByRestaurant(String restaurantName);

    FoodOrderEntity findByItem(String foodItem);

    List<FoodOrderEntity> findByItemAndRestaurant(String item, String restaurantName);

    List<FoodOrderEntity> findByPriceGreaterThan(double amount);

    FoodOrderEntity updateFoodItemByRestaurantName(String foodItem, String restaurantName, int id);

    FoodOrderEntity updatePriceByFoodItem(double price, String item, int id);

    FoodOrderEntity updateQuantityByFoodItem(int quantity, String foodItem, int id);
}