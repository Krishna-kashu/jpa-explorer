package com.mywork.gym_membership.repo;

import com.mywork.gym_membership.entity.GymMemberEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class GymMemberRepoImpl implements GymMemberRepo {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-work");

    @Override
    public boolean save(GymMemberEntity entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean result = false;
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            result = true;
            System.out.println("Saved: " + entity);
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return result;
    }

    @Override
    public boolean deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean deleted = false;
        try {
            tx.begin();
            GymMemberEntity member = em.find(GymMemberEntity.class, id);
            if (member != null) {
                em.remove(member);
                deleted = true;
                System.out.println("Deleted member with ID: " + id);
            } else {
                System.out.println("Member not found with ID: " + id);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return deleted;
    }

    @Override
    public List<GymMemberEntity> readAll() {
        EntityManager em = null;
        List<GymMemberEntity> list = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("readAll");
            list = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(em!=null) em.close();
        }
        return list;
    }

    @Override
    public GymMemberEntity findByMemberName(String name) {
        EntityManager em = emf.createEntityManager();
        GymMemberEntity entity = null;
        try {
            Query query = em.createNamedQuery("findByMemberName");
            entity = (GymMemberEntity) query.setParameter("name", name).getSingleResult();
            System.out.println("Found member: " + entity);
        } catch (NoResultException e) {
            System.out.println("No member found with name: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public GymMemberEntity findByDate(LocalDate date) {
        EntityManager entityManager = null;
        GymMemberEntity entity = null;

        try{
            entityManager = emf.createEntityManager();
            entity = (GymMemberEntity) entityManager.createNamedQuery("findByStartDate")
                    .setParameter("startDate", date).getSingleResult();
            System.out.println("finding By Date"+ entity);
        }catch (PersistenceException e){
            System.out.println("error in findByStartDate: "+ e.getMessage());
        }finally{
            if(entityManager != null) entityManager.close();
        }
        return entity;
    }

    @Override
    public List<GymMemberEntity> findActiveMembers() {
        EntityManager em = emf.createEntityManager();
        List<GymMemberEntity> list = null;
        try {
            Query query = em.createNamedQuery("findActiveMembers");
            list = query.getResultList();
            System.out.println("Active members: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public List<GymMemberEntity> findByMembershipType(String type) {
        EntityManager em = emf.createEntityManager();
        List<GymMemberEntity> list = Collections.emptyList();
        try {
            Query query = em.createNamedQuery("findByMembershipType");
            query.setParameter("type", type);
                    list = query.getResultList();
            System.out.println("Members by type: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public GymMemberEntity updateMemberNameByType(String memberName, String membershipType, int id) {
        System.out.println("updateMemberNameByType in repoImpl");

        EntityManager manager = null;
        EntityTransaction transaction = null;
        GymMemberEntity entity = null;
        try{
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            int row = manager.createNamedQuery("updateMemberNameByType")
                    .setParameter("id",id)
                    .setParameter("name",memberName)
                    .setParameter("type",membershipType).executeUpdate();
            System.out.println("rows affected: "+row);
            transaction.commit();
            entity=manager.find(GymMemberEntity.class, id);
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
    public GymMemberEntity updateTypeByStatus(String membershipType, String membershipStatus, int id) {
        System.out.println("updateTypeByStatus in repoImpl");

        EntityManager manager = null;
        EntityTransaction transaction = null;
        GymMemberEntity entity = null;
        try{
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            int updated = manager.createNamedQuery("updateTypeByStatus")
                    .setParameter("id",id)
                    .setParameter("status",membershipStatus)
                    .setParameter("type",membershipType).executeUpdate();
            System.out.println("rows affected: "+ updated);
            transaction.commit();
            entity=manager.find(GymMemberEntity.class, id);
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
    public GymMemberEntity updateStatusByName(String membershipStatus, String memberName, int id) {
        System.out.println("updateStatusByName in repoImpl");

        EntityManager manager = null;
        EntityTransaction transaction = null;
        GymMemberEntity entity = null;
        try{
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            int num = manager.createNamedQuery("updateStatusByName")
                    .setParameter("id",id)
                    .setParameter("name",memberName)
                    .setParameter("status",membershipStatus).executeUpdate();
            System.out.println("rows affected: "+ num);
            transaction.commit();
            entity=manager.find(GymMemberEntity.class, id);
            return entity;
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        }finally {
            if (manager!=null && manager.isOpen()) manager.close();
        }
        return entity;
    }
}
