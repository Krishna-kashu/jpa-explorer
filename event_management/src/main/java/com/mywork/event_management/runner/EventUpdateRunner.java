package com.mywork.event_management.runner;

import com.mywork.event_management.entity.EventEntity;

import javax.persistence.*;

public class EventUpdateRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("my-work");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            EventEntity event = em.find(EventEntity.class, 1);
            if (event != null) {
                event.setEventLocation("Mumbai");
                em.merge(event);
                System.out.println("Event updated successfully.");
            } else {
                System.out.println("Event not found!");
                et.commit();
            }

           // et.commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null) et.rollback();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
