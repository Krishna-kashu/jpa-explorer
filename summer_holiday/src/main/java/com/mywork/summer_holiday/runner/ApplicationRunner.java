package com.mywork.summer_holiday.runner;

import com.mywork.summer_holiday.entity.ApplicationEntity;
import com.mywork.summer_holiday.service.ApplicationService;
import com.mywork.summer_holiday.service.ApplicationServiceImpl;

import java.time.LocalDate;

public class ApplicationRunner {
    public static void main(String[] args) {

        ApplicationEntity entity = new ApplicationEntity(null,"Facebook", "39Gb", "Meta", 450000, 4.7f, LocalDate.of(2001, 2, 13));
        ApplicationService applicationService = new ApplicationServiceImpl();

        //applicationService.validApplication(entity);

        ApplicationEntity found = applicationService.getApplicationById(1);
        System.out.println("Found: "+ (found !=null ? found.getApplicationName(): "not found"));

        applicationService.updateCompanyById(1, "Meta platforms");

        applicationService.removeById(1);

        applicationService.getApplicationName("Instagram");
        applicationService.getApplicationBySize("28gb");
    }
}