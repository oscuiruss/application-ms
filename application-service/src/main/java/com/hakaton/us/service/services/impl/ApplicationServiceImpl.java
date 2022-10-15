package com.hakaton.us.service.services.impl;

import com.hakaton.us.dto.ApplicationDto;
import com.hakaton.us.repo.entity.Application;
import com.hakaton.us.repo.repository.ApplicationRepository;
import com.hakaton.us.service.services.ApplicationService;
import com.hakaton.us.service.utils.Mapper;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
//@Slf4j
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
    public void updateApplication(ApplicationDto applicationNew) {
        Optional<Application> applicationOldOpt = applicationRepository.findById(applicationNew.getId());
        if (applicationOldOpt.isPresent()) {
            Application application = applicationOldOpt.get();
            application.setId(applicationNew.getId());
            application.setStartDate(applicationNew.getStartDate());
            application.setEndDate(applicationNew.getEndDate());
            application.setVehicle(applicationNew.getVehicle());
            application.setUserName(applicationNew.getUserName());
            application.setUserSurname(applicationNew.getUserSurname());
            applicationRepository.save(application);
        }
    }

    @Override
    public ApplicationDto findApplication(Long id) {
        Optional<Application> applicationOpt = applicationRepository.findById(id);
        return applicationOpt.map(Mapper::mapToApplicationDto).orElse(null);
    }

    @Override
    public ApplicationDto createOrUpdate(ApplicationDto applicationDto) {
        if (applicationDto.getId() == null) {
            return createApplication(applicationDto);
        }
        updateApplication(applicationDto);
        return applicationDto;
    }
}
