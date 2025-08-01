package com.mywork.summer_holiday.entity;

import com.mywork.summer_holiday.repo.ApplicationRepoImpl;
import com.mywork.summer_holiday.service.ApplicationService;
import com.mywork.summer_holiday.service.ApplicationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application_details")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "application_size")
    private String applicationSize;

    @Column(name = "company")
    private String company;

    @Column(name = "no_of_users")
    private Integer noOfUsers;

    @Column(name = "ratings")
    private Float ratings;

    @Column(name = "launch_date")
    private LocalDate launchDate;
}

