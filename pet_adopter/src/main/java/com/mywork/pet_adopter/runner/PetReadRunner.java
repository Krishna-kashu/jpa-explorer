package com.mywork.pet_adopter.runner;

import com.mywork.pet_adopter.entity.PetEntity;

import javax.persistence.*;

public class PetReadRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("my-work");
            em = emf.createEntityManager();

            PetEntity pet = em.find(PetEntity.class, 1);

            if (pet != null) {
                System.out.println("Pet Name " + pet.getPetName());
                System.out.println("Pet Type " + pet.getPetType());
                System.out.println("Pet Age " + pet.getAge());

                if (pet.getAdopter() != null) {
                    System.out.println("Adopter Name  : " + pet.getAdopter().getAdopterName());
                    System.out.println("Adopter Contact: " + pet.getAdopter().getAdopterContact());
                } else {
                    System.out.println("No adopter assigned for this pet.");
                }
            } else {
                System.out.println("Pet not found!");
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
