package com.mywork.grocery_shop.repo;

import com.mywork.grocery_shop.entity.ItemEntity;

import java.util.List;

public interface ItemRepo {
    void save(ItemEntity itemEntity);
    void update(int id, String itemName);
    void deleteById(int id);
    ItemEntity findByItemName(String name);
    ItemEntity findByCategory(String category);
    List<ItemEntity> findAll();
    ItemEntity findByQuantityAvailable(Integer quantityAvailable);
}
