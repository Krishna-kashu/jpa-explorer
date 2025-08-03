package com.mywork.summer_holiday.repo;

import com.mywork.summer_holiday.entity.ApplicationEntity;

import javax.persistence.*;

public class ApplicationRepoImpl implements ApplicationRepo {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-work");

    @Override
    public void savedApplication(ApplicationEntity entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entity);
            tx.commit();
            System.out.println("Saved: " + entity);
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public ApplicationEntity findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(ApplicationEntity.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void updateApplication(int id, String newCompany) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ApplicationEntity entity = em.find(ApplicationEntity.class, id);
            if (entity != null) {
                entity.setCompany(newCompany);
                em.merge(entity);
                System.out.println("Updated company for ID " + id);
            } else {
                System.out.println("Entity not found for ID " + id);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ApplicationEntity entity = em.find(ApplicationEntity.class, id);
            if (entity != null) {
                em.remove(entity);
                System.out.println("Deleted entity with ID " + id);
            } else {
                System.out.println("Entity not found for ID " + id);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public ApplicationEntity findApplicationName(String name) {
        EntityManager em = null;
        ApplicationEntity entity = null;

        try{
            em = this.emf.createEntityManager();
            entity = (ApplicationEntity) em.createNamedQuery("findApplicationName").setParameter("name", name).getSingleResult();
            System.out.println("findApplicationName: "+entity);
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally {
            if(em !=null) em.close();
        }
        return entity;
    }

    @Override
    public ApplicationEntity findApplicationBySize(String appSize) {
        EntityManager em = null;
        ApplicationEntity entity = null;
        try{
            em = this.emf.createEntityManager();
            entity = (ApplicationEntity) em.createNamedQuery("findApplicationBySize").setParameter("size", appSize).getSingleResult();
            System.out.println("findApplicationBySize: "+entity);
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally {
            if(em !=null) em.close();
        }
        return entity;
    }
}
