package com.mywork.summer_holiday.runner;

import com.mywork.summer_holiday.entity.ApplicationEntity;
import com.mywork.summer_holiday.service.ApplicationService;
import com.mywork.summer_holiday.service.ApplicationServiceImpl;

import java.time.LocalDate;

public class ApplicationRunner {
    public static void main(String[] args) {

        ApplicationEntity entity = new ApplicationEntity(null,"Instagram", "24Gb", "Meta", 300000, 4.3f, LocalDate.of(2007, 3, 25));
        ApplicationService applicationService = new ApplicationServiceImpl();

        applicationService.validApplication(entity);

        ApplicationEntity found = applicationService.getApplicationById(1);
        System.out.println("Found: "+ (found !=null ? found.getApplicationName(): "not found"));

        applicationService.updateCompanyById(1, "Meta platforms");

        applicationService.removeById(1);
    }
}