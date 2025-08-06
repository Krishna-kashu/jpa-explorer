package com.mywork.gym_membership.service;

import com.mywork.gym_membership.entity.GymMemberEntity;
import com.mywork.gym_membership.repo.GymMemberRepo;
import com.mywork.gym_membership.repo.GymMemberRepoImpl;

import java.time.LocalDate;
import java.util.List;

public class GymMemberServiceImpl implements GymMemberService {

    private GymMemberRepo repo = new GymMemberRepoImpl();

    @Override
    public boolean validMember(GymMemberEntity entity) {
        System.out.println("Running validMember");

        if (entity != null) {
            if (entity.getMemberName() == null || entity.getMemberName().isEmpty()) {
                System.out.println("Invalid name");
                return false;
            }
            if (entity.getMembershipType() == null || entity.getMembershipType().isEmpty()) {
                System.out.println("Invalid type");
                return false;
            }
            if (entity.getStartDate() == null || entity.getEndDate() == null) {
                System.out.println("Invalid dates");
                return false;
            }
            if (entity.getMembershipStatus() == null) {
                System.out.println("Invalid status");
                return false;
            }
            return repo.save(entity);
        }
        System.out.println("Entity is null");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return repo.deleteById(id);
    }

    @Override
    public List<GymMemberEntity> getAll() {
        return repo.readAll();
    }

    @Override
    public GymMemberEntity getByMemberName(String name) {
        return repo.findByMemberName(name);
    }

    @Override
    public GymMemberEntity getByStartDate(LocalDate startDate) {
        return repo.findByDate(startDate);
    }

    @Override
    public List<GymMemberEntity> getActiveMembers() {
        return repo.findActiveMembers();
    }

    @Override
    public List<GymMemberEntity> getByMembershipType(String type) {
        return repo.findByMembershipType(type);
    }

    @Override
    public GymMemberEntity updateMemberNameByType(String memberName, String membershipType, int id) {
        return repo.updateMemberNameByType(memberName,membershipType,id);
    }

    @Override
    public GymMemberEntity updateTypeByStatus(String membershipType, String membershipStatus, int id) {
        return repo.updateTypeByStatus(membershipType, membershipStatus, id);
    }

    @Override
    public GymMemberEntity updateStatusByName(String membershipStatus, String memberName, int id) {
        return repo.updateStatusByName(membershipStatus,memberName,id);
    }
}
