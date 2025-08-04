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
        entity.setStartDate(LocalDate.of(2023, 8, 1));
        entity.setEndDate( LocalDate.of(2026, 4, 1));

        GymMemberService service = new GymMemberServiceImpl();

        // Save
        service.validMember(entity);

        // By name
        GymMemberEntity found = service.getByMemberName("Ravi Kumar");
        System.out.println("Found: " + (found != null ? found.getMemberName() : "Not found"));

        // Delete
        boolean deleted = service.deleteById(1);
        System.out.println("Deleted: " + deleted);

        // All members
        service.getAll().forEach(System.out::println);

        // Active members
        service.getActiveMembers().forEach(System.out::println);

        // By membership type
        service.getByMembershipType("Premium").forEach(System.out::println);
    }
}
