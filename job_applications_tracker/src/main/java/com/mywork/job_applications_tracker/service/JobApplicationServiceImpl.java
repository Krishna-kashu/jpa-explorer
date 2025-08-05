package com.mywork.job_applications_tracker.service;

import com.mywork.job_applications_tracker.entity.JobApplicationEntity;
import com.mywork.job_applications_tracker.repo.JobApplicationRepo;
import com.mywork.job_applications_tracker.repo.JobApplicationRepoImpl;

import java.util.List;

public class JobApplicationServiceImpl implements JobApplicationService{

    JobApplicationRepo repo = new JobApplicationRepoImpl();
    @Override
    public boolean save(JobApplicationEntity jobApplicationEntity) {
        System.out.println("running save method");
        if(jobApplicationEntity!=null){
            System.out.println("Valid");
        }else {
            System.out.println(" not save");
            return false;
        }
        repo.save(jobApplicationEntity);
        return true;
    }

    @Override
    public void updateById(int id, String roleApplied) {

       repo.updateById(id,roleApplied);
    }

    @Override
    public void deleteById(int id) {

        repo.deleteById(id);
    }

    @Override
    public JobApplicationEntity getByCompanyName(String companyName) {
        return repo.findByCompanyName(companyName);
    }

    @Override
    public List<JobApplicationEntity> getAll() {
        return repo.readAll();
    }
}
