package com.mywork.pet_adopter.runner;

import com.mywork.pet_adopter.entity.AdopterEntity;
import com.mywork.pet_adopter.entity.PetEntity;

import javax.persistence.*;

public class PetSaveRunner {
    public static void main(String[] args) {

        AdopterEntity adopter = new AdopterEntity();
        adopter.setAdopterName("Tarun H");
        adopter.setAdopterContact("tarun56h@gmail.com");

        PetEntity pet = new PetEntity();
        pet.setPetName("Teepu");
        pet.setPetType("Dog");
        pet.setAge(3);
        pet.setAdopter(adopter);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("my-work");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(adopter); // Save adopter first
            em.persist(pet);     // Then pet
            et.commit();

            System.out.println("Pet and Adopter saved successfully!");

        } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null) et.rollback();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
