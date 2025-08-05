package com.mywork.job_applications_tracker.runner;

import com.mywork.job_applications_tracker.entity.JobApplicationEntity;
import com.mywork.job_applications_tracker.service.JobApplicationService;
import com.mywork.job_applications_tracker.service.JobApplicationServiceImpl;

import java.time.LocalDate;

public class JobApplicationRunner {
    public static void main(String[] args) {
        JobApplicationService jobApplicationService = new JobApplicationServiceImpl();

        JobApplicationEntity entity = new JobApplicationEntity(null, "Google", "Software Developer","Applied", LocalDate.of(2025, 7, 24), 50000);
        //jobApplicationService.save(entity);

        jobApplicationService.updateById(1, "FullStack developer");

        jobApplicationService.deleteById(2);

        jobApplicationService.getByCompanyName("Wipro");
        jobApplicationService.getAll();
    }
}
