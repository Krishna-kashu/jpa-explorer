package com.mywork.grocery_shop.runner;

import com.mywork.grocery_shop.entity.ItemEntity;
import com.mywork.grocery_shop.service.ItemService;
import com.mywork.grocery_shop.service.ItemServiceImpl;

import java.time.LocalDate;

public class ItemRunner {
    public static void main(String[] args) {

        ItemEntity itemEntity = new ItemEntity(null, "Capsicum", "Vegetable", 1000, 3.6, LocalDate.of(2025, 8, 25));
        ItemService itemService = new ItemServiceImpl();

//        itemService.save(itemEntity);

//        itemService.getByItemName("Capsicum");
//
//        itemService.getByCategory("Vegetable");
//
//        itemService.updateById(1, "Carrot");
//
//        itemService.getAll();
//
//        itemService.removeById(1);

        System.out.println(itemService.getByQuantityAvailable(1000));
    }
}
