package com.mywork.event_management.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "event_details")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date")
    private String eventDate;

    @Column(name = "event_location")
    private String eventLocation;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private OrganizerEntity organizer;
}
