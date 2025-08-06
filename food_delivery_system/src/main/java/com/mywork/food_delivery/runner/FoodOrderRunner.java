package com.mywork.food_delivery.runner;

import com.mywork.food_delivery.entity.FoodOrderEntity;
import com.mywork.food_delivery.service.FoodOrderService;
import com.mywork.food_delivery.service.FoodOrderServiceImpl;

import java.util.List;

public class FoodOrderRunner {
    public static void main(String[] args) {

        FoodOrderEntity entity = new FoodOrderEntity();
        entity.setRestaurantName("Pizza Hut");
        entity.setFoodItem("Pizza");
        entity.setQuantity(3);
        entity.setPrice(289.00);
        entity.setDeliveryAddress("White Field");

        FoodOrderService service = new FoodOrderServiceImpl();

//        boolean saved = service.validateAndSave(entity);
//        System.out.println("\n 1.Order saved: " + saved);


        FoodOrderEntity found = service.getByRestaurant("Pizza Hut");
        System.out.println("\n2. Found: " + (found != null ? found.getFoodItem() : "Not found"));

        boolean deleted = service.deleteById(1);
        System.out.println("\n3. Deleted: " + deleted);

        List<FoodOrderEntity> itemAndRest = service.getByItemAndRestaurant("Pizza", "Pizza Hut");
        System.out.println("\n 4.Orders with item+restaurant: " + (itemAndRest != null ? itemAndRest.size() : 0));

        List<FoodOrderEntity> expensive = service.getByPriceGreaterThan(250);
        System.out.println("\n 5. Orders > 250: " + (expensive != null ? expensive.size() : 0));

        FoodOrderEntity foundItem = service.getByItem("Pizza");
        System.out.println("\n6. foundItem: " + foundItem);

        FoodOrderEntity  entity1 = service.updatePriceByFoodItem(260,"Pizza",3);
        System.out.println(entity1);

        System.out.println(service.updateFoodItemByRestaurantName("Veg Pizza","Domino's",3));
        FoodOrderEntity updateQuantity = service.updateQuantityByFoodItem(5,"Veg Pizza",3);
        System.out.println(updateQuantity);

    }
}
