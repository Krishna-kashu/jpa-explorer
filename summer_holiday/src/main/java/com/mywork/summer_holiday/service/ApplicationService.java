package com.mywork.summer_holiday.service;

import com.mywork.summer_holiday.entity.ApplicationEntity;

public interface ApplicationService {
    boolean validApplication(ApplicationEntity applicationEntity);
    ApplicationEntity getApplicationById(int id);
    void updateCompanyById(int id, String newCompany);
    void removeById(int id);
    ApplicationEntity getApplicationName(String name);
    ApplicationEntity getApplicationBySize(String size);
}