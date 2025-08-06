package com.mywork.food_delivery.service;

import com.mywork.food_delivery.entity.FoodOrderEntity;

import java.util.List;

public interface FoodOrderService {

    boolean validateAndSave(FoodOrderEntity entity);

    boolean deleteById(int id);

    FoodOrderEntity getByRestaurant(String restaurantName);

    FoodOrderEntity getByItem(String foodItem);

    List<FoodOrderEntity> getByItemAndRestaurant(String item, String restaurant);

    List<FoodOrderEntity> getByPriceGreaterThan(double amount);

    FoodOrderEntity updateFoodItemByRestaurantName(String foodItem, String restaurantName, int id);

    FoodOrderEntity updatePriceByFoodItem(double price, String item, int id);

    FoodOrderEntity updateQuantityByFoodItem(int quantity, String foodItem, int id);

}
