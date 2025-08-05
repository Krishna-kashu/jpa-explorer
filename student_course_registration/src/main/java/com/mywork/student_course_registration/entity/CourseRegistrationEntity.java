package com.mywork.student_course_registration.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student_course_registration")
@NamedQueries({
        @NamedQuery(name = "findByStudentName", query = "select r from CourseRegistrationEntity r where r.studentName = :name"),
        @NamedQuery(name = "findByCourseName", query = "select r from CourseRegistrationEntity r where r.courseName = :courseName"),
        @NamedQuery(name = "findAll", query = "select r from CourseRegistrationEntity r")
})
public class CourseRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Integer registrationId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "course_duration_months")
    private Integer courseDurationMonths;

    @Column(name = "course_fee")
    private Integer courseFee;
}
