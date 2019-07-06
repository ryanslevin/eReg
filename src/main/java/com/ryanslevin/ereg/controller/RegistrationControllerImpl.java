package com.ryanslevin.ereg.controller;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.Registration;
import com.ryanslevin.ereg.entity.User;
import com.ryanslevin.ereg.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationControllerImpl implements RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Override
    @PutMapping("/register")
    public void register(@RequestBody Registration registration) {

        registrationService.register(registration);

    }

    @Override
    @PostMapping("/cancel")
    public void cancel(@RequestBody Registration registration) {

        registrationService.cancel(registration);

    }

    @Override
    @PostMapping("/transfer")
    public void transfer(@RequestBody Registration registration, Course course) {

        registrationService.transfer(registration, course);

    }
    




}