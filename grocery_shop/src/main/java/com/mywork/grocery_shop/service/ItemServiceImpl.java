package com.mywork.grocery_shop.service;

import com.mywork.grocery_shop.entity.ItemEntity;
import com.mywork.grocery_shop.repo.ItemRepo;
import com.mywork.grocery_shop.repo.ItemRepoImpl;

import java.util.List;

public class ItemServiceImpl implements ItemService{

    private  final ItemRepo repo = new ItemRepoImpl();
    @Override
    public boolean save(ItemEntity itemEntity) {
        System.out.println("running save method");
        if(itemEntity!=null){
            System.out.println("Valid");
        }else {
            System.out.println(" not save");
            return false;
        }
        repo.save(itemEntity);
        return true;
    }

    @Override
    public void updateById(int id, String name) {

        repo.update(id, name);
    }

    @Override
    public void removeById(int id) {
        repo.deleteById(id);
    }

    @Override
    public ItemEntity getByCategory(String category) {
        return repo.findByCategory(category);
    }

    @Override
    public ItemEntity getByItemName(String name) {
        return repo.findByItemName(name);
    }

    @Override
    public List<ItemEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public ItemEntity getByQuantityAvailable(Integer quantityAvailable) {
        return repo.findByQuantityAvailable(quantityAvailable);
    }
}
