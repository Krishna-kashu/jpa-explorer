package com.mywork.food_delivery.service;

import com.mywork.food_delivery.entity.FoodOrderEntity;
import com.mywork.food_delivery.repo.FoodOrderRepo;
import com.mywork.food_delivery.repo.FoodOrderRepoImpl;

import java.util.Collections;
import java.util.List;

public class FoodOrderServiceImpl implements FoodOrderService {

    private FoodOrderRepo repo = new FoodOrderRepoImpl();

    @Override
    public boolean validateAndSave(FoodOrderEntity entity) {

        return repo.save(entity);
    }

    @Override
    public FoodOrderEntity getByRestaurant(String restaurantName) {
        if (restaurantName != null && restaurantName.length() >= 3) {
            return repo.findByRestaurant(restaurantName);
        }
        System.out.println("Invalid restaurant name");
        return null;
    }

    @Override
    public FoodOrderEntity getByItem(String foodItem) {
        return repo.findByItem(foodItem);
    }

    @Override
    public boolean deleteById(int id) {
        if (id > 0) {
            return repo.deleteById(id);
        }
        System.out.println("Invalid ID");
        return false;
    }

    @Override
    public List<FoodOrderEntity> getByItemAndRestaurant(String item, String restaurant) {
        if (item != null && restaurant != null && item.length() > 1 && restaurant.length() > 2) {
            return repo.findByItemAndRestaurant(item, restaurant);
        }
        System.out.println("Invalid item or restaurant");
        return null;
    }

    @Override
    public List<FoodOrderEntity> getByPriceGreaterThan(double amount) {
        if (amount > 0) {
            return repo.findByPriceGreaterThan(amount);
        }
        System.out.println("Invalid price");
        return null;
    }

    @Override
    public FoodOrderEntity updatePriceByFoodItem( double price, String item,int id) {
        return repo.updatePriceByFoodItem(price,item,id);
    }

    @Override
    public FoodOrderEntity updateFoodItemByRestaurantName(String foodItem, String restaurantName, int id) {
        return repo.updateFoodItemByRestaurantName(foodItem,restaurantName,id);
    }

    @Override
    public FoodOrderEntity updateQuantityByFoodItem(int quantity, String foodItem, int id) {
        return repo.updateQuantityByFoodItem(quantity,foodItem,id);
    }

    @Override
    public List<String> getAllName() {
        return repo.findAllName();
    }

    @Override
    public List<Object[]> getAllFoodItemAndPrice() {
        return repo.findAllFoodItemAndPrice();
    }

    @Override
    public List<Object[]> getAllFoodItemQuantityAndDeliveryAddress() {
        return repo.findAllFoodItemQuantityAndDeliveryAddress();
    }
}
