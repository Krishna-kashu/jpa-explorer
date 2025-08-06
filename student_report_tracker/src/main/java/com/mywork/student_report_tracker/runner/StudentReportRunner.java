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

        service.validStudent(entity);
        System.out.println("\n saved.... validStudent");

        System.out.println("\n getByStudentName");
        StudentEntity found = service.getByStudentName("Ananya");
        System.out.println("Found: " + (found != null ? found.getStudentName() : "Not found"));

        System.out.println("\n get By Grade");
        StudentEntity entity1 = service.getByGrade("A");
        System.out.println(entity1);


        System.out.println("\n deleteById");
        boolean deleted = service.deleteById(1);
        System.out.println("Deleted: " + deleted);

        System.out.println("\n getAll");
        service.getAll().forEach(System.out::println);

        System.out.println("\n getBySubject");
        service.getBySubject("Mathematics").forEach(System.out::println);

        System.out.println("\n find by marks");
        service.getByMarks(98).forEach(System.out::println);

        StudentEntity studentEntity = service.updateMarksBySubject(97,"English",5);
        System.out.println(studentEntity);

        StudentEntity entity2 = service.updateNameByGrade("Bharat","O",5);
        System.out.println(entity2);

        StudentEntity entity3 = service.updateSubjectByName("Social Science", "Lasya",4);
        System.out.println(entity3);
    }
}
