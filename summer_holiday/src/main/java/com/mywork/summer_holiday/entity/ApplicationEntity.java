package com.mywork.summer_holiday.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@NamedQuery(name = "findApplicationName", query = "select a from ApplicationEntity a where a.applicationName=:name")
@NamedQuery(name = "findApplicationBySize", query ="select a from ApplicationEntity a where a.applicationSize=:size")
@NamedQuery(name = "findApplicationByNoOfUsers", query = "select a from ApplicationEntity a where a.noOfUsers=:users")
@NamedQuery(name = "findApplicationByRatings", query = "select a from ApplicationEntity a where a.ratings=:ratings")
@NamedQuery(name = "findAll", query = "select a from ApplicationEntity a")
@NamedQuery(name = "findByCompany", query = "select a from ApplicationEntity a where a.company=:company")


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

