package com.mywork.summer_holiday.repo;

import com.mywork.summer_holiday.entity.ApplicationEntity;

import java.util.List;

public interface ApplicationRepo {
    void savedApplication(ApplicationEntity entity);
    ApplicationEntity findById(int id);
    void updateApplication(int id, String newCompany);
    void deleteById(int id);
    ApplicationEntity findApplicationName(String name);
    ApplicationEntity findApplicationBySize(String size);
    List<ApplicationEntity> findAll();
    List<ApplicationEntity> findApplicationByCompany(String company);
    int updateApplicationNameByCompany(String applicationName, String company);
    List<String> findAllAppName ();
    List<Integer> findAllNoOfUsers();
    List<Float> findAllRatings();

    List<Object> findAllAppSize();

    List<Object[] > findAppNameAndRatings();
}