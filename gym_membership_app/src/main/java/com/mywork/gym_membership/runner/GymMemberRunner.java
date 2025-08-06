package com.mywork.gym_membership.runner;

import com.mywork.gym_membership.entity.GymMemberEntity;
import com.mywork.gym_membership.service.GymMemberService;
import com.mywork.gym_membership.service.GymMemberServiceImpl;

import java.time.LocalDate;

public class GymMemberRunner {
    public static void main(String[] args) {

        GymMemberEntity entity = new GymMemberEntity();

        entity.setMemberName("Shree Shetty");
        entity.setMembershipType("Premium");
        entity.setMembershipStatus("ACTIVE");
        entity.setStartDate(LocalDate.of(2023, 7, 1));
        entity.setEndDate( LocalDate.of(2026, 4, 1));

        GymMemberService service = new GymMemberServiceImpl();

//        System.out.println("\n1.Save");
//        service.validMember(entity);

//        System.out.println("\n2. By name");
//        GymMemberEntity found = service.getByMemberName("Ravi Kumar");
//        System.out.println("Found: " + (found != null ? found.getMemberName() : "Not found"));
//
//        System.out.println("\nDelete");
//        boolean deleted = service.deleteById(2);
//        System.out.println("3.Deleted: " + deleted);
//
//        System.out.println("\n4.All members");
//        service.getAll().forEach(System.out::println);
//
//        System.out.println("\n5.Active members");
//        service.getActiveMembers().forEach(System.out::println);
//
//        System.out.println("\n6.By membership type");
//        service.getByMembershipType("Premium").forEach(System.out::println);
//
//        System.out.println("\n 7. By start date");
//        service.getByStartDate(LocalDate.of(2024, 4, 1));
//
//        System.out.println("\n\n Update operations");

        GymMemberEntity entity1 = service.updateMemberNameByType("Deeraj Patel", "Premium",5);
        System.out.println(entity1);

        GymMemberEntity entity2 = service.updateStatusByName("INACTIVE", "Suresh Yadav",3);
        System.out.println(entity2);

        GymMemberEntity entity3 = service.updateTypeByStatus("Basic", "ACTIVE",7);
        System.out.println(entity3);
    }
}
