package com.mywork.student_report_tracker.repo;

import com.mywork.student_report_tracker.entity.StudentEntity;

import java.util.List;

public interface StudentRecordRepo {
    boolean save(StudentEntity studentEntity);

    boolean deleteById(int id);

    StudentEntity findByStudentName(String studentName);

    StudentEntity findByGrade(String grade);

    List<StudentEntity> findBySubject(String subject);

    List<StudentEntity> findByMarks(int marks);

    List<StudentEntity> readAll();

    StudentEntity updateSubjectByName(String subject, String studentName, int id);

    StudentEntity updateMarksBySubject(int marks, String subject, int id);

    StudentEntity updateNameByGrade(String studentName, String grade, int id);

    List<String> findAllName();

    List<Object[]> findAllNameAndMarks();

    List<Object[]> findAllNameSubjectGrade();

}