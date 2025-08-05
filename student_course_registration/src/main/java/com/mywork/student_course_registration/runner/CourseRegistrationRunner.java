package com.mywork.student_course_registration.runner;

import com.mywork.student_course_registration.entity.CourseRegistrationEntity;
import com.mywork.student_course_registration.service.CourseRegistrationService;
import com.mywork.student_course_registration.service.CourseRegistrationServiceImpl;

import java.time.LocalDate;

public class CourseRegistrationRunner {
    public static void main(String[] args) {
        CourseRegistrationEntity entity = new CourseRegistrationEntity(null, "Mokshith S", "Data Analyst", LocalDate.of(2025,6,23), 6, 30000);
        CourseRegistrationService service = new CourseRegistrationServiceImpl();

       // service.save(entity);

        service.getByStudentName("Shree Raksha");

        service.updateById(6, "Fullstack");

        service.getByCourseName("Fullstack");

        service.getAll();

        service.removeById(1);
    }
}
