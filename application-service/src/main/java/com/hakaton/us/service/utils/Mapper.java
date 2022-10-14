package com.hakaton.us.service.utils;


import com.hakaton.us.dto.ApplicationDto;
import com.hakaton.us.repo.entity.Application;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public static Application mapToApplication(ApplicationDto applicationDto){
        return new Application(applicationDto.getId(), applicationDto.getStartDate(),
                applicationDto.getEndDate(), applicationDto.getVehicle(), applicationDto.getUserName(), applicationDto.getUserSurname());
    }

    public static ApplicationDto mapToApplicationDto(Application application){
        return new ApplicationDto(application.getId(), application.getStartDate(),
                application.getEndDate(), application.getVehicle(), application.getUserName(), application.getUserSurname());
    }

}
