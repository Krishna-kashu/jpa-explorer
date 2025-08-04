package com.mywork.student_report_tracker.repo;

import com.mywork.student_report_tracker.entity.StudentEntity;

import javax.persistence.NamedQuery;
import java.util.List;

public interface StudentRecordRepo {
    boolean save(StudentEntity studentEntity);

    boolean deleteById(int id);

    StudentEntity findByStudentName(String studentName);

    List<StudentEntity> findBySubject(String subject);

    List<StudentEntity> findAboveMarks(int minMarks);

    List<StudentEntity> readAll();
}