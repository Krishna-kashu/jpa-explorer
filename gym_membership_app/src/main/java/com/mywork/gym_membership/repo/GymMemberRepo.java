package com.mywork.gym_membership.repo;

import com.mywork.gym_membership.entity.GymMemberEntity;

import java.time.LocalDate;
import java.util.List;

public interface GymMemberRepo {
    boolean save(GymMemberEntity entity);

    boolean deleteById(int id);

    GymMemberEntity findByMemberName(String name);

    GymMemberEntity findByDate(LocalDate startDate);

    List<GymMemberEntity> readAll();

    List<GymMemberEntity> findActiveMembers();

    List<GymMemberEntity> findByMembershipType(String type);

    GymMemberEntity  updateMemberNameByType(String memberName, String membershipType, int id);

    GymMemberEntity updateTypeByStatus(String membershipType, String membershipStatus, int id);

    GymMemberEntity updateStatusByName(String membershipStatus, String memberName, int id);

    List<String> findAllStatus();

    List<Object[]> findAllNameAndType();

    List<Object[]> findAllStartAndEndDate();
}
