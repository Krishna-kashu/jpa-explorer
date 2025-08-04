package com.mywork.gym_membership.repo;

import com.mywork.gym_membership.entity.GymMemberEntity;

import javax.persistence.*;
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
        EntityManager em = emf.createEntityManager();
        List<GymMemberEntity> list = Collections.emptyList();
        try {
            list = em.createQuery("from GymMemberEntity", GymMemberEntity.class).getResultList();
            System.out.println("Total members: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public GymMemberEntity findByMemberName(String name) {
        EntityManager em = emf.createEntityManager();
        GymMemberEntity entity = null;
        try {
            entity = em.createNamedQuery("findByMemberName", GymMemberEntity.class)
                    .setParameter("name", name)
                    .getSingleResult();
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
    public List<GymMemberEntity> findActiveMembers() {
        EntityManager em = emf.createEntityManager();
        List<GymMemberEntity> list = Collections.emptyList();
        try {
            list = em.createNamedQuery("findActiveMembers", GymMemberEntity.class).getResultList();
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
            list = em.createNamedQuery("findByMembershipType", GymMemberEntity.class)
                    .setParameter("type", type)
                    .getResultList();
            System.out.println("Members by type: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }
}
