package com.mywork.student_report_tracker.service;

import com.mywork.student_report_tracker.entity.StudentEntity;

import java.util.List;

public interface StudentRecordService {
    boolean validStudent(StudentEntity entity);

    boolean deleteById(int id);

    StudentEntity getByStudentName(String studentName);

    StudentEntity getByGrade(String grade);

    List<StudentEntity> getBySubject(String subject);

    List<StudentEntity> getByMarks(int marks);

    List<StudentEntity> getAll();
}
