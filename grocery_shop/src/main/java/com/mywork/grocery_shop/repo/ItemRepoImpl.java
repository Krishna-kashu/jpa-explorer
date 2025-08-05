package com.mywork.grocery_shop.repo;

import com.mywork.grocery_shop.entity.ItemEntity;

import javax.persistence.*;
import java.util.List;

public class ItemRepoImpl implements ItemRepo{

    private  static  final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-work");

    @Override
    public void save(ItemEntity itemEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.merge(itemEntity);
            transaction.commit();
            System.out.println("saved entity: "+itemEntity);

        }catch (PersistenceException e){
            if(transaction.isActive()) transaction.rollback();
            System.out.println("error in save :"+e.getMessage());
        }finally {
           entityManager.close();
        }
    }

    @Override
    public void update(int id, String newName) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            ItemEntity itemEntity = entityManager.find(ItemEntity.class, id);

            if(itemEntity!=null){
                itemEntity.setItemName(newName);
                entityManager.merge(itemEntity);
                System.out.println("Updated name for id "+id);
            }else {
                System.out.println("Entity not found for id"+id);
            }

        }catch (PersistenceException e){

            if(entityTransaction.isActive()) entityTransaction.rollback();
            System.out.println("error in update "+e.getMessage());

        }finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ItemEntity entity = em.find(ItemEntity.class, id);
            if(entity!=null){
                em.remove(entity);
                System.out.println("Deleted entity with ID " + id);
            }else {
                System.out.println("Entity not found for ID " + id);
            }
            tx.commit();
        }catch (PersistenceException e){
            if(tx.isActive()) tx.rollback();
            System.out.println("error in deleteById: "+e.getMessage());
        }finally {
            em.close();
        }
    }

    @Override
    public ItemEntity findByCategory(String category) {
        EntityManager em = entityManagerFactory.createEntityManager();
        ItemEntity entity = null;

        try{
            Query query = em.createNamedQuery("findByCategory");
             query.setParameter("category", category);
            entity= (ItemEntity) query.getSingleResult();
            System.out.println("finding by category..."+entity);
        }catch (PersistenceException e){
            System.out.println("error in findByCategory"+e.getMessage());
        }finally {
            if (em!=null) em.close();
        }
        return entity;
    }

    @Override
    public ItemEntity findByItemName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        ItemEntity entity = null;
        try{
            Query  query = em.createNamedQuery("findByItemName")
                    .setParameter("name", name);
            entity = (ItemEntity) query.getSingleResult();

        }catch (PersistenceException e){
            System.out.println("error in findById: "+e.getMessage());
        }finally {
            em.close();
        }
        return entity;
    }

    @Override
    public List<ItemEntity> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<ItemEntity> list = null;
        try {
            Query query = em.createNamedQuery("findAll");
            list = query.getResultList();
        }catch (PersistenceException e){
            System.out.println("error in findAll: "+e.getMessage());
        }finally {
            em.close();
        }
        return list;
    }

    @Override
    public ItemEntity findByQuantityAvailable(Integer quantityAvailable) {
        EntityManager em = entityManagerFactory.createEntityManager();
        ItemEntity entity = null;

        try{
            TypedQuery<ItemEntity> typedQuery = em.createQuery("select a from ItemEntity a where a.quantityAvailable=:quantityAvailable", ItemEntity.class)
                    .setParameter("quantityAvailable",quantityAvailable);
            entity = typedQuery.getSingleResult();
            //System.out.println("entity: "+entity);
        }catch (PersistenceException e){
            System.out.println("error in findByQuantityAvailable"+e.getMessage());
        }finally {
            if(em!=null) em.close();
        }
        return entity;
    }
}
