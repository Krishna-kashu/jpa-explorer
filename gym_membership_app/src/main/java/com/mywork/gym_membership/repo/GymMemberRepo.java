package com.mywork.gym_membership.repo;

import com.mywork.gym_membership.entity.GymMemberEntity;

import java.util.List;

public interface GymMemberRepo {
    boolean save(GymMemberEntity entity);

    boolean deleteById(int id);

    List<GymMemberEntity> readAll();

    GymMemberEntity findByMemberName(String name);

    List<GymMemberEntity> findActiveMembers();

    List<GymMemberEntity> findByMembershipType(String type);
}
