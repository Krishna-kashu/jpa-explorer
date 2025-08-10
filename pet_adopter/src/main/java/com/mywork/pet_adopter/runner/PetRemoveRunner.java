package com.mywork.pet_adopter.runner;

import com.mywork.pet_adopter.entity.PetEntity;
import javax.persistence.*;

public class PetRemoveRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("my-work");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            PetEntity pet = em.find(PetEntity.class, 1);

            if (pet != null) {
                System.out.println("Deleting pet: " + pet.getPetName());

                em.remove(pet);

                et.commit();

                System.out.println("Pet deleted successfully!");
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
