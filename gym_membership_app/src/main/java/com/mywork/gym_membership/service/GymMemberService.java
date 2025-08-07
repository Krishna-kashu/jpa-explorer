package com.mywork.gym_membership.service;

import com.mywork.gym_membership.entity.GymMemberEntity;

import java.time.LocalDate;
import java.util.List;

public interface GymMemberService {
    boolean validMember(GymMemberEntity entity);

    boolean deleteById(int id);

    GymMemberEntity getByMemberName(String name);

    GymMemberEntity getByStartDate(LocalDate startDate);

    List<GymMemberEntity> getAll();

    List<GymMemberEntity> getActiveMembers();

    List<GymMemberEntity> getByMembershipType(String type);

    GymMemberEntity  updateMemberNameByType(String memberName, String membershipType, int id);

    GymMemberEntity updateTypeByStatus(String membershipType, String membershipStatus, int id);

    GymMemberEntity updateStatusByName(String membershipStatus, String memberName, int id);

    List<String> getAllStatus();

    List<Object[]> getAllNameAndType();

    List<Object[]> getAllStartAndEndDate();
}
