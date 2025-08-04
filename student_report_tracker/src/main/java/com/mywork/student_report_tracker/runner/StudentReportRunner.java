package com.mywork.student_report_tracker.runner;

import com.mywork.student_report_tracker.entity.StudentEntity;
import com.mywork.student_report_tracker.service.StudentRecordService;
import com.mywork.student_report_tracker.service.StudentRecordServiceImpl;

public class StudentReportRunner {
    public static void main(String[] args) {

        StudentEntity entity = new StudentEntity();
        entity.setStudentName("Lasya");
        entity.setSubject("English");
        entity.setMarks(98);
        entity.setGrade("O");
        StudentRecordService service = new StudentRecordServiceImpl();

        // Save
        service.validStudent(entity);

        // Find by name
        StudentEntity found = service.getByStudentName("Ananya");
        System.out.println("Found: " + (found != null ? found.getStudentName() : "Not found"));

        // Delete
        boolean deleted = service.deleteById(1);
        System.out.println("Deleted: " + deleted);

        // Read all
        service.getAll().forEach(System.out::println);

        // By subject
        service.getBySubject("Mathematics").forEach(System.out::println);

        // Above marks
        service.getAboveMarks(85).forEach(System.out::println);
    }
}
