package com.mywork.student_course_registration.repo;

import com.mywork.student_course_registration.entity.CourseRegistrationEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class CourseRegistrationRepoImpl implements CourseRegistrationRepo{

    private  static  final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-work");

    @Override
    public void save(CourseRegistrationEntity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction =  entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            System.out.println("saved entity: "+entity);

        }catch (PersistenceException e){
            if(transaction.isActive()) transaction.rollback();
            System.out.println("error in save :"+e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void update(int id, String nweCourseName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            CourseRegistrationEntity entity = entityManager.find(CourseRegistrationEntity.class, id);

            if(entity!=null){
                entity.setCourseName(nweCourseName);
                entityManager.merge(entity);
                System.out.println("Updated name for id "+id);
            }else {
                System.out.println("Entity not found for id"+id);
            }
            entityTransaction.commit();
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
            CourseRegistrationEntity entity = em.find(CourseRegistrationEntity.class, id);
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
    public CourseRegistrationEntity findByStudentName(String studentName) {
        EntityManager em = entityManagerFactory.createEntityManager();
        CourseRegistrationEntity entity = null;
        try{
            Query  query = em.createNamedQuery("findByStudentName")
                    .setParameter("name", studentName);
            entity = (CourseRegistrationEntity) query.getSingleResult();
            System.out.println(entity);

        }catch (PersistenceException e){
            System.out.println("error in findByStudentName: "+e.getMessage());
        }finally {
            em.close();
        }
        return entity;
    }

    @Override
    public CourseRegistrationEntity findByCourseName(String courseName) {
        EntityManager em = entityManagerFactory.createEntityManager();
        CourseRegistrationEntity entity = null;
        try{
            Query  query = em.createNamedQuery("findByCourseName")
                    .setParameter("courseName", courseName);
            entity = (CourseRegistrationEntity) query.getSingleResult();
            System.out.println(entity);

        }catch (PersistenceException e){
            System.out.println("error in findByCourseName: "+e.getMessage());
        }finally {
            em.close();
        }
        return entity;
    }

    @Override
    public List<CourseRegistrationEntity> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<CourseRegistrationEntity> list = null;
        try {
            Query query = em.createNamedQuery("findAll");
            list = query.getResultList();
            System.out.println(list);
        }catch (PersistenceException e){
            System.out.println("error in findAll: "+e.getMessage());
        }finally {
            em.close();
        }
        return list;
    }
}
