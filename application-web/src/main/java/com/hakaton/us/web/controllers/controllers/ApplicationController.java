package com.hakaton.us.web.controllers.controllers;


import com.hakaton.us.dto.ApplicationDto;
import com.hakaton.us.service.services.ApplicationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/app")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/application")
    public ResponseEntity<ApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto){
        ApplicationDto response = applicationService.createOrUpdate(applicationDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<ApplicationDto> findApplication(@RequestParam("id") Long id){
        ApplicationDto response = applicationService.findApplication(id);
        return ResponseEntity.ok(response);
    }

}
