package com.mywork.summer_holiday.runner;

import com.mywork.summer_holiday.entity.ApplicationEntity;
import com.mywork.summer_holiday.service.ApplicationService;
import com.mywork.summer_holiday.service.ApplicationServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) {

        ApplicationEntity entity = new ApplicationEntity(null,"Instagram", "46Gb", "Meta", 500000, 4.5f, LocalDate.of(2002, 5, 23));
        ApplicationService applicationService = new ApplicationServiceImpl();

        applicationService.validApplication(entity);

        ApplicationEntity found = applicationService.getApplicationById(1);
        System.out.println("Found: "+ (found !=null ? found.getApplicationName(): "not found"));

        applicationService.updateCompanyById(1, "Meta");

        applicationService.removeById(4);

        System.out.println("\n getting application Instagram");
        applicationService.getApplicationName("Instagram");

        System.out.println("\ngetApplicationBySize : 28gb");
        applicationService.getApplicationBySize("28gb");

        System.out.println("\n all applications");
        List<ApplicationEntity> allApps = applicationService.getAll();
        System.out.println(allApps);

        System.out.println("\n\nMeta");
        List<ApplicationEntity> apps = applicationService.getApplicationByCompany("Meta");
        System.out.println(apps);
    }
}