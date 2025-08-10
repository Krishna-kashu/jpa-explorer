package com.mywork.event_management.runner;

import com.mywork.event_management.entity.EventEntity;

import javax.persistence.*;

public class EventReadRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("my-work");
            em = emf.createEntityManager();

            EventEntity event = em.find(EventEntity.class, 1); // Fetch by id
            if (event != null) {
                System.out.println("Event Name: " + event.getEventName());
                System.out.println("Event Date: " + event.getEventDate());
                System.out.println("Location: " + event.getEventLocation());
                System.out.println("Organizer: " + event.getOrganizer().getOrganizerName());
            } else {
                System.out.println("Event not found!");
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
