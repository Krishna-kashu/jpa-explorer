package com.mywork.gym_membership.service;

import com.mywork.gym_membership.entity.GymMemberEntity;

import java.util.List;

public interface GymMemberService {
    boolean validMember(GymMemberEntity entity);

    boolean deleteById(int id);

    List<GymMemberEntity> getAll();

    GymMemberEntity getByMemberName(String name);

    List<GymMemberEntity> getActiveMembers();

    List<GymMemberEntity> getByMembershipType(String type);
}
