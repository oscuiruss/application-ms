package com.hakaton.us.web.controllers.controllers;


import com.hakaton.us.service.services.ApplicationService;

public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
}
