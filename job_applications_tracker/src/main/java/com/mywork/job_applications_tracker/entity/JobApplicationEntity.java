package com.mywork.job_applications_tracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@NamedQueries({
        @NamedQuery(name="findByCompanyName", query = "select a from JobApplicationEntity a where a.companyName=:name"),
        @NamedQuery(name = "readAll", query = "select a from JobApplicationEntity a")
})
@Table(name = "job_details")
public class JobApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "application_name")
    private String companyName;

    @Column(name = "role_applied")
    private String roleApplied;

    @Column(name = "application_status")
    private String status;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Column(name = "salary_expectation")
    private  Integer salaryExpectation;

}
