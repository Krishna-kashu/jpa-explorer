package com.mywork.pet_adopter.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "adopter_details")
public class AdopterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adopter_id")
    private Integer adopterId;

    @Column(name = "adopter_name")
    private String adopterName;

    @Column(name = "adopter_contact")
    private String adopterContact;

    @OneToMany(mappedBy = "adopter", cascade = CascadeType.ALL)
    private List<com.mywork.pet_adopter.entity.PetEntity> pets;
}
