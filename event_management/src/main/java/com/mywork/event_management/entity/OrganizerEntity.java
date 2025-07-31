package com.mywork.event_management.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "organizer_details")
public class OrganizerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organizer_id")
    private Integer organizerId;

    @Column(name = "organizer_name")
    private String organizerName;

    @Column(name = "organizer_email")
    private String organizerEmail;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<EventEntity> events;
}
