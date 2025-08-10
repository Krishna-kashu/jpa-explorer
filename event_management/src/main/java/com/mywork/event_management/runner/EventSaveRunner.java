package com.mywork.event_management.runner;

import com.mywork.event_management.entity.OrganizerEntity;
import com.mywork.event_management.entity.EventEntity;

import javax.persistence.*;

public class EventSaveRunner {
    public static void main(String[] args) {

        OrganizerEntity organizer = new OrganizerEntity();
        organizer.setOrganizerName("Radha");
        organizer.setOrganizerEmail("radha09@gmail.com");

        EventEntity event = new EventEntity();
        event.setEventName("Workshop");
        event.setEventDate("15th October");
        event.setEventLocation("Bangalore");
        event.setOrganizer(organizer);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("my-work");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(organizer);
            em.persist(event);
            et.commit();

            System.out.println("Event and Organizer saved successfully!");

        } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null)
                et.rollback();
        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
