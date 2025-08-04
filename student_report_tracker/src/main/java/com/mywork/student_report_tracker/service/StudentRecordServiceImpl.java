package com.mywork.student_report_tracker.service;

import com.mywork.student_report_tracker.entity.StudentEntity;
import com.mywork.student_report_tracker.repo.StudentRecordRepo;
import com.mywork.student_report_tracker.repo.StudentRecordRepoImpl;

import java.util.List;

public class StudentRecordServiceImpl implements StudentRecordService {

    private StudentRecordRepo repo = new StudentRecordRepoImpl();

    @Override
    public boolean validStudent(StudentEntity entity) {
        System.out.println("Running validStudent");

        if (entity != null) {
            if (entity.getStudentName() == null || entity.getStudentName().isEmpty()) {
                System.out.println("Invalid name");
                return false;
            }
            if (entity.getSubject() == null || entity.getSubject().isEmpty()) {
                System.out.println("Invalid subject");
                return false;
            }
            if (entity.getMarks() == null || entity.getMarks() < 0) {
                System.out.println("Invalid marks");
                return false;
            }
            return repo.save(entity);
        }
        System.out.println("Entity is null");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return repo.deleteById(id);
    }

    @Override
    public StudentEntity getByStudentName(String studentName) {
        return repo.findByStudentName(studentName);
    }

    @Override
    public List<StudentEntity> getBySubject(String subject) {
        return repo.findBySubject(subject);
    }

    @Override
    public List<StudentEntity> getAboveMarks(int minMarks) {
        return repo.findAboveMarks(minMarks);
    }

    @Override
    public List<StudentEntity> getAll() {
        return repo.readAll();
    }
}
