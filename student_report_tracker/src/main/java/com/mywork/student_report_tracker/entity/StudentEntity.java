package com.mywork.student_report_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="student_details")
@NamedQueries({
        @NamedQuery(name = "findByStudentName", query = "select s from StudentEntity s where s.studentName =:name"),
        @NamedQuery(name = "findBySubject", query = "select s from StudentEntity s where s.subject =:subject"),
        @NamedQuery(name = "findByGrade", query = "select s from StudentEntity s where s.grade =:grade"),
        @NamedQuery(name = "findByMarks", query = "select s from StudentEntity s where s.marks =:marks"),
        @NamedQuery(name = "readAll", query = "select s from StudentEntity s"),
        @NamedQuery(name="updateSubjectByName", query = "update StudentEntity s set s.subject=:sub where s.studentName=:name and s.studentId=:id"),
        @NamedQuery(name="updateMarksBySubject", query = "update StudentEntity s set s.marks=:marks where s.subject=:sub and s.studentId=:id"),
        @NamedQuery(name="updateNameByGrade", query = "update StudentEntity s set s.studentName=:name where s.grade=:grade and s.studentId=:id")
})
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_name")
    @NotBlank
    @Size(min = 2, max = 50, message = "student name should between 2 to 50 characters")
    private String studentName;

    @Column(name = "subject")
    @Size(min = 2, max = 50, message = "subject should between 2 to 50 characters")
    private String subject;

    @Column(name = "marks")
    @Max(value = 100, message = "maximum mark is 100")
    private Integer marks;

    @Column(name = "grade")
    @NotBlank
    private String grade;

    @Column(name = "reportDate")
    private LocalDateTime reportDate;

    @PrePersist
    public void onCreate(){
        this.reportDate= LocalDateTime.now();
    }
}
