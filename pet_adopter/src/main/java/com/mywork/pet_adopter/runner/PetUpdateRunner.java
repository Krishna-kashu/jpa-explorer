package com.mywork.pet_adopter.runner;

import com.mywork.pet_adopter.entity.PetEntity;
import javax.persistence.*;

public class PetUpdateRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("my-work");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            PetEntity pet = em.find(PetEntity.class, 1);// Finding pet by ID

            if (pet != null) {
                System.out.println("Before Update" + pet.getPetName());

                // Updating
                pet.setPetName("Chintu");
                pet.setAge(4);

               // em.merge(pet);
                et.commit();

                System.out.println("after "+pet.getPetName());
                System.out.println("Pet updated successfully!");
            } else {
                System.out.println("Pet not found!");
                et.rollback();
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null) et.rollback();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
