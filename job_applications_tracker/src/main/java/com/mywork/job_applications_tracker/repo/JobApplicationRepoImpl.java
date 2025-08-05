package com.mywork.job_applications_tracker.repo;

import com.mywork.job_applications_tracker.entity.JobApplicationEntity;

import javax.persistence.*;
import java.util.List;

public class JobApplicationRepoImpl implements JobApplicationRepo{

    private  static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-work");
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;
    @Override
    public void save(JobApplicationEntity entity) {
        entityManager = emf.createEntityManager();
        entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
            System.out.println("saved: "+entity);
        }catch (PersistenceException e){
            if(entityTransaction.isActive()) entityTransaction.rollback();
            System.out.println("error in save "+e.getMessage());
        }finally {
            if(entityManager!=null) entityManager.close();
        }
    }

    @Override
    public void updateById(int id, String newRoleApplied) {
        entityManager = emf.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            JobApplicationEntity jobApplicationEntity = entityManager.find(JobApplicationEntity.class, id);
            if(jobApplicationEntity!=null){
                jobApplicationEntity.setRoleApplied(newRoleApplied);
                entityManager.merge(jobApplicationEntity);
                System.out.println("Updated company for ID " + id);
            }else {
                System.out.println("Entity not found for ID " + id);
            }
            entityTransaction.commit();
        }catch (PersistenceException e){
            if (entityTransaction.isActive()) entityTransaction.rollback();
        }finally {
            if(entityManager!=null) entityManager.close();
        }
    }

    @Override
    public void deleteById(int id) {
        entityManager = emf.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            JobApplicationEntity jobApplicationEntity = entityManager.find(JobApplicationEntity.class, id);
            if(jobApplicationEntity!=null){
                entityManager.remove(jobApplicationEntity);
                System.out.println("Deleted entity with ID " + id);
            }else {
                System.out.println(" entity not found for ID " + id);
            }
            entityTransaction.commit();
        }catch (PersistenceException ex){
            System.out.println("error in update by id"+ex.getMessage());
        }finally {
            if (entityTransaction.isActive()) entityTransaction.rollback();
        }
    }

    @Override
    public JobApplicationEntity findByCompanyName(String companyName) {
        entityManager = emf.createEntityManager();
        JobApplicationEntity jobApplicationEntity = null;

        try {
            Query query = entityManager.createNamedQuery("findByCompanyName").setParameter("name", companyName);
            jobApplicationEntity = (JobApplicationEntity) query.getSingleResult();
            System.out.println("entity is:"+jobApplicationEntity);
        }catch (PersistenceException e){
            System.out.println("error in findByCompanyName"+e.getMessage());
        }finally {
            if (entityManager!=null) entityManager.close();
        }

        return jobApplicationEntity;
    }

    @Override
    public List<JobApplicationEntity> readAll() {
        entityManager = emf.createEntityManager();
       List< JobApplicationEntity> entityList = null;
       try {
           Query query = entityManager.createNamedQuery("readAll");
           entityList = query.getResultList();
           System.out.println("all entity: "+entityList);
       }catch (PersistenceException e){
           System.out.println("error in readAll: "+e.getMessage());
       }finally {
           if (entityManager!=null) entityManager.close();
       }
        return entityList;
    }
}
