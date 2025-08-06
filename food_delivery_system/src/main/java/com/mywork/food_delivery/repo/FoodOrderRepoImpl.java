package com.mywork.food_delivery.repo;

import com.mywork.food_delivery.entity.FoodOrderEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class FoodOrderRepoImpl implements FoodOrderRepo {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-work");

    @Override
    public boolean save(FoodOrderEntity entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        } finally {
            em.close();
        }

    }

    @Override
    public FoodOrderEntity findByRestaurant(String restaurantName) {
        EntityManager em = null;
        FoodOrderEntity entity = null;
        try {
            em = emf.createEntityManager();
            entity = (FoodOrderEntity) em.createNamedQuery("findByRestaurant").
                    setParameter("rest", restaurantName).
                    getSingleResult();
            System.out.println("findByRestaurant" + entity);
        } catch (NoResultException e) {
            System.out.println("No order found for restaurant: " + restaurantName);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public FoodOrderEntity findByItem(String foodItem) {
        EntityManager entityManager = null;
        FoodOrderEntity entity = null;
        try{
            entityManager = emf.createEntityManager();
            entity = (FoodOrderEntity) entityManager.createNamedQuery("findByItem").
                    setParameter("item", foodItem ).
                    getSingleResult();
            System.out.println("findByItem" + entity);
        }catch (PersistenceException ex){
            System.out.println("error in findByItem: "+ex.getMessage());
        }finally {
           if (entityManager != null) entityManager.close();
        }
        return entity;
    }

    @Override
    public boolean deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            FoodOrderEntity entity = em.find(FoodOrderEntity.class, id);
            if (entity != null) {
                tx.begin();
                em.remove(entity);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public List<FoodOrderEntity> findByItemAndRestaurant(String item, String restaurantName) {
        EntityManager entityManager = emf.createEntityManager();
        List entityList = null;

        try {
           Query query = entityManager.createNamedQuery("findByItemAndRestaurant");
             query.setParameter("item", item).setParameter("rest", restaurantName);
            entityList = query.getResultList();

        } catch (Exception ex) {
            System.out.println("error in findByItemAndRestaurant: "+ex.getMessage());
        } finally {
            entityManager.close();
        }
        return entityList;
    }

    @Override
    public List<FoodOrderEntity> findByPriceGreaterThan(double amount) {
        EntityManager em = emf.createEntityManager();
        List<FoodOrderEntity> entity  = null;
        try {
            Query query = em.createNamedQuery("findByPriceGreaterThan");
             query.setParameter("amount", amount);
             entity =query.getResultList();
        } catch (PersistenceException ex) {
            System.out.println("error in findByPriceGreaterThan: "+ex.getMessage());
            return null;
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public FoodOrderEntity updateFoodItemByRestaurantName(String foodItem, String restaurantName, int id) {
        System.out.println("UpdateFoodItemByRestaurantName in repoImpl");
        EntityManager manager = null;
        EntityTransaction entityTransaction = null;
        FoodOrderEntity entity = null;
        try {
            manager = emf.createEntityManager();
            entityTransaction = manager.getTransaction();
            entityTransaction.begin();

            int rows = manager.createNamedQuery("UpdateFoodItemByRestaurantName")
                    .setParameter("id", id)
                    .setParameter("name", restaurantName)
                    .setParameter("item", foodItem).executeUpdate();
            System.out.println("rows affected: "+rows);
            entityTransaction.commit();
            entity=manager.find(FoodOrderEntity.class, id);
            return entity;
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        }finally {
            if (manager!=null && manager.isOpen()) manager.close();
        }
        return entity;
    }

    @Override
    public FoodOrderEntity updatePriceByFoodItem(double price, String item, int id) {
        System.out.println("UpdatePriceByFoodItem in repoImpl");
        EntityManager manager = null;
        EntityTransaction transaction = null;
        FoodOrderEntity entity = null;
        try {
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();

            int isUpdated = manager.createNamedQuery("UpdatePriceByFoodItem")
                    .setParameter("id", id)
                    .setParameter("price", price)
                    .setParameter("item", item).executeUpdate();
            System.out.println("rows affected: "+ isUpdated);
            transaction.commit();
            entity=manager.find(FoodOrderEntity.class, id);
            return entity;
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        }finally {
            if (manager!=null && manager.isOpen()) manager.close();
        }
        return entity;
    }

    @Override
    public FoodOrderEntity updateQuantityByFoodItem(int quantity, String foodItem, int id) {
        System.out.println("updateQuantityByFoodItem in repoImpl");

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        FoodOrderEntity entity = null;
        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            int row = entityManager.createNamedQuery("updateQuantityByFoodItem")
                    .setParameter("id",id)
                    .setParameter("item",foodItem)
                    .setParameter("quantity",quantity).executeUpdate();
            System.out.println("rows affected: "+row);
            entityTransaction.commit();
            entity=entityManager.find(FoodOrderEntity.class, id);
            return entity;
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        }finally {
            if (entityManager!=null && entityManager.isOpen()) entityManager.close();
        }
        return entity;
    }

    @Override
    public List<String> findAllName() {
        EntityManager manager = null;
        List<String> list = Collections.emptyList();
        try {
            list = emf.createEntityManager().createNamedQuery("findAllName").getResultList();
        }catch (PersistenceException e){
            System.out.println("error in findAllName: "+e.getMessage());
        }finally {
            if(manager!=null) manager.close();
        }
        return list;
    }

    @Override
    public List<Object[]> findAllFoodItemAndPrice() {
        EntityManager manager = null;
        List<Object[]> list = Collections.emptyList();
        try {
            list = emf.createEntityManager().createNamedQuery("findAllFoodItemAndPrice").getResultList();
        }catch (PersistenceException e){
            System.out.println("error in findAllFoodItemAndPrice: "+e.getMessage());
        }finally {
            if(manager!=null) manager.close();
        }
        return list;
    }

    @Override
    public List<Object[]> findAllFoodItemQuantityAndDeliveryAddress() {
        EntityManager manager = null;
        List<Object[]> itemList = Collections.emptyList();
        try {
            itemList = emf.createEntityManager().createNamedQuery("findAllFoodItemQuantityAndDeliveryAddress").getResultList();
        }catch (PersistenceException e){
            System.out.println("error in findAllFoodItemQuantityAndDeliveryAddress: "+e.getMessage());
        }finally {
            if(manager!=null) manager.close();
        }
        return itemList;
    }
}
