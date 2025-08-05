package com.mywork.grocery_shop.service;

import com.mywork.grocery_shop.entity.ItemEntity;

import java.util.List;

public interface ItemService {
    boolean save(ItemEntity itemEntity);
    void updateById(int id, String name);
    void removeById(int id);
    ItemEntity getByCategory(String category);
    ItemEntity getByItemName(String name);
    List<ItemEntity> getAll();
    ItemEntity getByQuantityAvailable(Integer quantityAvailable);
}
