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
        @NamedQuery(name = "findActiveMembers", query = "select g from GymMemberEntity g where g.membershipStatus='ACTIVE'"),
        @NamedQuery(name = "findByMembershipType", query = "select g from GymMemberEntity g where g.membershipType=:type")
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
