package com.mywork.student_report_tracker.repo;

import com.mywork.student_report_tracker.entity.StudentEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class StudentRecordRepoImpl implements StudentRecordRepo {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-work");

    @Override
    public boolean save(StudentEntity studentEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean success = false;
        try {
            tx.begin();
            em.persist(studentEntity);
            tx.commit();
            success = true;
            System.out.println("Saved: " + studentEntity);
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return success;
    }

    @Override
    public boolean deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean deleted = false;
        try {
            tx.begin();
            StudentEntity student = em.find(StudentEntity.class, id);
            if (student != null) {
                em.remove(student);
                deleted = true;
                System.out.println("Deleted student with ID: " + id);
            } else {
                System.out.println("Student not found for ID: " + id);
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
    public StudentEntity findByStudentName(String studentName) {
        EntityManager em = emf.createEntityManager();
        StudentEntity entity = null;
        try {
            entity = em.createNamedQuery("findByStudentName", StudentEntity.class)
                    .setParameter("name", studentName)
                    .getSingleResult();
            System.out.println("Found by name: " + entity);
        } catch (NoResultException e) {
            System.out.println("No student found with name: " + studentName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public List<StudentEntity> findBySubject(String subject) {
        EntityManager em = emf.createEntityManager();
        List<StudentEntity> list = Collections.emptyList();
        try {
            list = em.createNamedQuery("findBySubject", StudentEntity.class)
                    .setParameter("subject", subject)
                    .getResultList();
            System.out.println("Students by subject: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public List<StudentEntity> findAboveMarks(int minMarks) {
        EntityManager em = emf.createEntityManager();
        List<StudentEntity> list = Collections.emptyList();
        try {
            list = em.createNamedQuery("findAboveMarks", StudentEntity.class)
                    .setParameter("minMarks", minMarks)
                    .getResultList();
            System.out.println("Students above marks: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public List<StudentEntity> readAll() {
        EntityManager em = emf.createEntityManager();
        List<StudentEntity> list = Collections.emptyList();
        try {
            list = em.createQuery("from StudentEntity", StudentEntity.class).getResultList();
            System.out.println("Total students: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }
}
