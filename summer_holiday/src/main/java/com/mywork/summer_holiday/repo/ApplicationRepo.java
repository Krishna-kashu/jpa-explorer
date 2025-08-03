package com.mywork.summer_holiday.repo;

import com.mywork.summer_holiday.entity.ApplicationEntity;

public interface ApplicationRepo {
    void savedApplication(ApplicationEntity entity);
    ApplicationEntity findById(int id);
    void updateApplication(int id, String newCompany);
    void deleteById(int id);
    ApplicationEntity findApplicationName(String name);
    ApplicationEntity findApplicationBySize(String size);
}