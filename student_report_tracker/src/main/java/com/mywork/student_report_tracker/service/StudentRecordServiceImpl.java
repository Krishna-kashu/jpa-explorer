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
    public StudentEntity getByGrade(String grade) {
        return repo.findByGrade(grade);
    }

    @Override
    public List<StudentEntity> getBySubject(String subject) {
        return repo.findBySubject(subject);
    }

    @Override
    public List<StudentEntity> getByMarks(int marks) {
        return repo.findByMarks(marks);
    }

    @Override
    public List<StudentEntity> getAll() {
        return repo.readAll();
    }

    @Override
    public StudentEntity updateSubjectByName(String subject, String studentName, int id) {
        return repo.updateSubjectByName(subject,studentName,id);
    }

    @Override
    public StudentEntity updateMarksBySubject(int marks, String subject, int id) {
        return repo.updateMarksBySubject(marks,subject,id);
    }

    @Override
    public StudentEntity updateNameByGrade(String studentName, String grade, int id) {
        return repo.updateNameByGrade(studentName,grade,id);
    }

    @Override
    public List<String> getAllNames() {
        return repo.findAllName();
    }

    @Override
    public List<Object[]> getAllNameAndMarks() {
        return repo.findAllNameAndMarks();
    }

    @Override
    public List<Object[]> getAllNameSubjectGrade() {
        return repo.findAllNameSubjectGrade();
    }
}
