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
    public StudentEntity findByGrade(String grade) {
        EntityManager entityManager = emf.createEntityManager();
        StudentEntity entity = null;

        try{
            Query query = entityManager.createNamedQuery("findByGrade");
            entity = (StudentEntity) query.setParameter("grade", grade).getSingleResult();
        }catch (PersistenceException ex){
            System.out.println("error in findByGrade: "+ex.getMessage());
        }finally {
            if(entityManager != null) entityManager.close();
        }
        return entity;
    }

    @Override
    public StudentEntity findByStudentName(String studentName) {
        EntityManager em = emf.createEntityManager();
        StudentEntity entity = null;
        try {
            Query query = em.createNamedQuery("findByStudentName")
                    .setParameter("name", studentName);
            entity = (StudentEntity) query.getSingleResult();
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
        List<StudentEntity> list = null;
        try {
            Query query = em.createNamedQuery("findBySubject");
            query.setParameter("subject", subject);
           list = query.getResultList();
            System.out.println("Students by subject: " + list.size());
        } catch (Exception e) {
            System.out.println("error in findBySubject "+e.getMessage());
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public List<StudentEntity> findByMarks(int marks) {
        EntityManager em = emf.createEntityManager();
        List<StudentEntity> list = null;
        try {
            Query query = em.createNamedQuery("findByMarks")
                    .setParameter("marks", marks);
            list = query.getResultList();
            System.out.println("Students by marks: " + list.size());
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
            Query query = em.createNamedQuery("readAll");
            list =query.getResultList();
            System.out.println("Total students: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public StudentEntity updateSubjectByName(String subject, String studentName, int id) {
        System.out.println("updateSubjectByName in repoImpl");

        EntityManager em = null;
        EntityTransaction tx = null;
        StudentEntity entity = null;
        try{
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            int updatedRows = em.createNamedQuery("updateSubjectByName")
                    .setParameter("id",id)
                    .setParameter("name",studentName)
                    .setParameter("sub",subject).executeUpdate();
            System.out.println("rows affected: "+ updatedRows);
            tx.commit();
            entity=em.find(StudentEntity.class, id);
            return entity;
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
            if (tx != null) tx.rollback();
        }finally {
            if (em!=null && em.isOpen()) em.close();
        }
        return entity;
    }

    @Override
    public StudentEntity updateMarksBySubject(int marks, String subject, int id) {
        System.out.println("updateMarksBySubject in repoImpl");

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        StudentEntity entity = null;
        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            int row = entityManager.createNamedQuery("updateMarksBySubject")
                    .setParameter("id",id)
                    .setParameter("marks",marks)
                    .setParameter("sub",subject).executeUpdate();
            System.out.println("rows affected: "+ row);
            entityTransaction.commit();
            entity= entityManager.find(StudentEntity.class, id);
            return entity;
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
            if (entityTransaction != null) entityTransaction.rollback();
        }finally {
            if (entityManager !=null && entityManager.isOpen()) entityManager.close();
        }
        return entity;
    }

    @Override
    public StudentEntity updateNameByGrade(String studentName, String grade, int id) {
        System.out.println("updateNameByGrade in repoImpl");

        EntityManager em = null;
        EntityTransaction transaction = null;
        StudentEntity entity = null;
        try{
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            int row = em.createNamedQuery("updateNameByGrade")
                    .setParameter("id",id)
                    .setParameter("grade",grade)
                    .setParameter("name",studentName).executeUpdate();
            System.out.println("rows affected: "+ row);
            transaction.commit();
            entity= em.find(StudentEntity.class, id);
            return entity;
        }catch (PersistenceException e){
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        }finally {
            if (em !=null && em.isOpen()) em.close();
        }
        return entity;
    }

    @Override
    public List<String> findAllName() {
        EntityManager entityManager = null;
        List<String> list = Collections.emptyList();

        try {
            list =emf.createEntityManager().createNamedQuery("findAllName").getResultList();
        }catch (PersistenceException e){
            System.out.println("error in findAllName: "+e.getMessage());
        }finally {
            if(entityManager!=null && entityManager.isOpen()) entityManager.close();
        }
        return list;
    }

    @Override
    public List<Object[]> findAllNameAndMarks() {
        List<Object[]> list = Collections.emptyList();
        EntityManager manager = null;
        try {
            list = emf.createEntityManager().createNamedQuery("findAllNameAndMarks").getResultList();

        }catch (PersistenceException e){
            System.out.println("error in findAllNameAndMarks: "+ e.getMessage());
        }finally {
            if(manager!=null && manager.isOpen()) manager.isOpen();
        }
        return list;
    }

    @Override
    public List<Object[]> findAllNameSubjectGrade() {
        List<Object[]> objectList = Collections.emptyList();
        EntityManager manager = null;
        try {
            objectList = emf.createEntityManager().createNamedQuery("findAllNameSubjectGrade").getResultList();

        }catch (PersistenceException e){
            System.out.println("error in findAllNameSubjectGrade: "+ e.getMessage());
        }finally {
            if(manager!=null && manager.isOpen()) manager.isOpen();
        }
        return objectList;
    }
}
