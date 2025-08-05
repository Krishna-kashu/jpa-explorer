package com.mywork.student_course_registration.service;

import com.mywork.student_course_registration.entity.CourseRegistrationEntity;
import com.mywork.student_course_registration.repo.CourseRegistrationRepo;
import com.mywork.student_course_registration.repo.CourseRegistrationRepoImpl;

import java.util.Collections;
import java.util.List;

public class CourseRegistrationServiceImpl implements CourseRegistrationService{

    private  final CourseRegistrationRepo repo = new CourseRegistrationRepoImpl();

    @Override
    public boolean save(CourseRegistrationEntity entity) {
        System.out.println("running save method");
        if(entity!=null){
            System.out.println("Valid");
        }else {
            System.out.println(" not save");
            return false;
        }
        repo.save(entity);
        return true;
    }

    @Override
    public void updateById(int id, String courseName) {
        repo.update(id, courseName);
    }

    @Override
    public void removeById(int id) {
        repo.deleteById(id);
    }

    @Override
    public CourseRegistrationEntity getByStudentName(String studentName) {
        return repo.findByStudentName(studentName);
    }

    @Override
    public CourseRegistrationEntity getByCourseName(String courseName) {
        return repo.findByCourseName(courseName);
    }

    @Override
    public List<CourseRegistrationEntity> getAll() {
        return repo.findAll();
    }
}
