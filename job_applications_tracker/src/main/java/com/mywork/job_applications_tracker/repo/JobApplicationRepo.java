package com.mywork.job_applications_tracker.repo;

import com.mywork.job_applications_tracker.entity.JobApplicationEntity;

import java.util.List;

public interface JobApplicationRepo {

    void  save(JobApplicationEntity jobApplicationEntity);
    void updateById(int id,  String roleApplied);
    void deleteById(int id);

    JobApplicationEntity findByCompanyName(String companyName);

    List<JobApplicationEntity> readAll();
}