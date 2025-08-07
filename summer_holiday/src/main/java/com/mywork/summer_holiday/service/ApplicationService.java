package com.mywork.summer_holiday.service;

import com.mywork.summer_holiday.entity.ApplicationEntity;

import java.util.List;

public interface ApplicationService {
    boolean validApplication(ApplicationEntity applicationEntity);
    ApplicationEntity getApplicationById(int id);
    void updateCompanyById(int id, String newCompany);
    void removeById(int id);
    ApplicationEntity getApplicationName(String name);
    ApplicationEntity getApplicationBySize(String size);
    List<ApplicationEntity> getAll();
    List<ApplicationEntity> getApplicationByCompany(String company);
    int updateApplicationNameByCompany(String applicationName, String company);
    List<String> getAllAppName();
    List<Integer> getAllNoOfUsers();
    List<Float> getAllRatings();

    List<Object> getAllAppSize();
    List<Object[]> getAppNameAndRatings();

}