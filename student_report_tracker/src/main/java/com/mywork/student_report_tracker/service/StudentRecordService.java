package com.mywork.student_report_tracker.service;

import com.mywork.student_report_tracker.entity.StudentEntity;

import java.util.List;

public interface StudentRecordService {
    boolean validStudent(StudentEntity entity);

    boolean deleteById(int id);

    StudentEntity getByStudentName(String studentName);

    List<StudentEntity> getBySubject(String subject);

    List<StudentEntity> getAboveMarks(int minMarks);

    List<StudentEntity> getAll();
}
