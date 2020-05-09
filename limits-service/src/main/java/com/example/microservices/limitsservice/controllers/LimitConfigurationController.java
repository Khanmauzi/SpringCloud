package com.example.microservices.limitsservice.controllers;

import com.example.microservices.limitsservice.models.LimitConfiguration;
import com.example.microservices.limitsservice.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class LimitConfigurationController {

    @Autowired
    LimitConfiguration limitConfiguration;

    @Autowired
    TestService testService;

    @GetMapping("/limits")
    public LimitConfiguration getLimitConfiguration() {
        testService.testScheduler();
        return limitConfiguration;
    }
}
