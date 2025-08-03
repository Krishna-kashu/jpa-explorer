package com.mywork.summer_holiday.service;

import com.mywork.summer_holiday.entity.ApplicationEntity;
import com.mywork.summer_holiday.repo.ApplicationRepo;
import com.mywork.summer_holiday.repo.ApplicationRepoImpl;

public class ApplicationServiceImpl implements ApplicationService{

    private ApplicationRepo applicationRepo = new ApplicationRepoImpl();

    @Override
    public boolean validApplication(ApplicationEntity applicationEntity) {
        System.out.println("running validApplication method");

        if(applicationEntity!=null){
            System.out.println("Valid ApplicationEntity");
            if(applicationEntity.getApplicationName()!=null){
                System.out.println("valid name");

            }else {
                System.out.println("invalid name");
                return false;
            }
            if(applicationEntity.getApplicationSize()!=null){
                System.out.println("valid size");

            }else {
                System.out.println("invalid size");
                return false;
            }
            if(applicationEntity.getCompany()!=null){
                System.out.println("valid Company name");

            }else {
                System.out.println("invalid company name");
                return false;
            }
            if(applicationEntity.getRatings()!=null && applicationEntity.getRatings()<=5.0f){
                System.out.println("valid ratings");

            }else {
                System.out.println("invalid ratings");
                return false;
            }
            if(applicationEntity.getLaunchDate()!=null){
                System.out.println("valid launchDate");

            }else {
                System.out.println("invalid launchDate");
                return false;
            }

        }else{
            System.out.println("ApplicationEntity is not valid");
            return false;
        }

        applicationRepo.savedApplication(applicationEntity);
        return true;
    }

    @Override
    public ApplicationEntity getApplicationById(int id) {
        return applicationRepo.findById(id);
    }

    @Override
    public void updateCompanyById(int id, String newCompany) {
        applicationRepo.updateApplication(id, newCompany);
    }

    @Override
    public void removeById(int id) {
        applicationRepo.deleteById(id);
    }

    @Override
    public ApplicationEntity getApplicationName(String name) {
        return applicationRepo.findApplicationName(name);
    }

    @Override
    public ApplicationEntity getApplicationBySize(String appSize) {
        return applicationRepo.findApplicationBySize(appSize);
    }

}