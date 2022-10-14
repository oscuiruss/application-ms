package com.hakaton.us.service.services;


import com.hakaton.us.dto.ApplicationDto;

public interface ApplicationService {
    ApplicationDto createApplication(ApplicationDto applicationDto);

    void removeApplication(Long id);

    void updateApplication(ApplicationDto applicationDto);

    ApplicationDto findApplication(Long id);
}
