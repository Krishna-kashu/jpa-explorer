package com.mywork.gym_membership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "gym_member")
@NamedQueries({
        @NamedQuery(name = "findByMemberName", query = "select g from GymMemberEntity g where g.memberName=:name"),
        @NamedQuery(name = "readAll", query = "select g from GymMemberEntity g "),
        @NamedQuery(name = "findActiveMembers", query = "select g from GymMemberEntity g where g.membershipStatus='ACTIVE'"),
        @NamedQuery(name = "findByMembershipType", query = "select g from GymMemberEntity g where g.membershipType=:type"),
        @NamedQuery(name = "findByStartDate", query = "select g from GymMemberEntity g where g.startDate=:startDate"),
        @NamedQuery(name = "updateMemberNameByType", query = "update GymMemberEntity g set g.memberName=:name where g.membershipType=:type and g.id=:id"),
        @NamedQuery(name = "updateTypeByStatus", query = "update GymMemberEntity g set g.membershipType =:type where g.membershipStatus=:status and g.id=:id"),
        @NamedQuery(name = "updateStatusByName", query = "update GymMemberEntity g set g.membershipStatus =:status where g.memberName=:name and g.id=:id"),
        @NamedQuery(name = "findAllStatus", query = "select a.membershipStatus from GymMemberEntity a"),
        @NamedQuery(name = "findAllNameAndType", query = "select a.memberName, a.membershipType from GymMemberEntity a"),
        @NamedQuery(name = "findAllStartAndEndDate", query = "select a.startDate, a.endDate from GymMemberEntity a")
})
public class GymMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer id;

    @Column(name = "member_name")
    @NotBlank
    @Size(min = 3, max = 50)
    private String memberName;

    @Column(name = "membership_type")
    @NotBlank
    private String membershipType;

    @Column(name = "membership_status")
    @NotBlank
    private String membershipStatus;

    @Column(name = "start_date")
    @NotNull
    private LocalDate startDate;

    @Column(name = "end_date")
    @NotNull
    private LocalDate endDate;
}
