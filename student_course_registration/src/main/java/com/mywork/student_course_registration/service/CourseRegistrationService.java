package com.mywork.student_course_registration.service;

import com.mywork.student_course_registration.entity.CourseRegistrationEntity;

import java.util.List;

public interface CourseRegistrationService {
    boolean save(CourseRegistrationEntity entity);

    void updateById(int id, String courseName);

    void removeById(int id);

    CourseRegistrationEntity getByStudentName(String studentName);

    CourseRegistrationEntity getByCourseName(String courseName);

    List<CourseRegistrationEntity> getAll();
}
