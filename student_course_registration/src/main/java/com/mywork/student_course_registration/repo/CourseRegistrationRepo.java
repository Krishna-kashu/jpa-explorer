package com.mywork.student_course_registration.repo;

import com.mywork.student_course_registration.entity.CourseRegistrationEntity;

import java.util.List;

public interface CourseRegistrationRepo {
    void save(CourseRegistrationEntity entity);
    void update(int id, String courseName);
    void deleteById(int id);

    CourseRegistrationEntity findByStudentName(String studentName);

    CourseRegistrationEntity findByCourseName(String courseName);

    List<CourseRegistrationEntity> findAll();

}
