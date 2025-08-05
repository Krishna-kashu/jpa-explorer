package com.mywork.job_applications_tracker.service;

import com.mywork.job_applications_tracker.entity.JobApplicationEntity;

import java.util.List;

public interface JobApplicationService {
    boolean save(JobApplicationEntity jobApplicationEntity);
    void updateById(int id, String roleApplied);
    void deleteById(int id);

    JobApplicationEntity getByCompanyName(String companyName);

    List<JobApplicationEntity> getAll();
}
