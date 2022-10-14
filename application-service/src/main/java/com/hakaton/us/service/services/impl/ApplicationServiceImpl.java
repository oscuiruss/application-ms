package com.hakaton.us.service.services.impl;

import com.hakaton.us.dto.ApplicationDto;
import com.hakaton.us.repo.entity.Application;
import com.hakaton.us.repo.repository.ApplicationRepository;
import com.hakaton.us.service.services.ApplicationService;
import com.hakaton.us.service.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    @Transactional
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = Mapper.mapToApplication(applicationDto);
        applicationRepository.save(application);
        return applicationDto;
    }

    @Override
    @Transactional
    public void removeApplication(Long id) {
        Optional<Application> application = applicationRepository.findById(id);
        application.ifPresent(applicationRepository::delete);
    }

    @Override
    @Transactional
    public void updateApplication(ApplicationDto applicationOld) {
        Optional<Application> applicationOpt = applicationRepository.findById(applicationOld.getId());
        if (applicationOpt.isPresent()){
            Application application = applicationOpt.get();
            application.setId(applicationOld.getId());
            application.setStartDate(applicationOld.getStartDate());
            application.setEndDate(applicationOld.getEndDate());
            application.setVehicle(applicationOld.getVehicle());
        }
    }

    @Override
    public ApplicationDto findApplication(Long id) {
        Optional<Application> applicationOpt = applicationRepository.findById(id);
        return applicationOpt.map(Mapper::mapToApplicationDto).orElse(null);
    }
}
