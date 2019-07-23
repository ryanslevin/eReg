package com.ryanslevin.ereg.controller;

import java.util.List;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.Registration;
import com.ryanslevin.ereg.entity.User;
import com.ryanslevin.ereg.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationControllerImpl implements RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Override
    @PostMapping("/register")
    public void register(@RequestParam int courseId, @RequestParam int userId) {

        registrationService.register(courseId, userId);

    }

    @Override
    @PutMapping("/cancel")
    public void cancel(@RequestBody Registration registration) {

        registrationService.cancel(registration);

    }

    @Override
    @GetMapping("/registrations")
    public List<Registration> getRegistrations() {
        
        return registrationService.getRegistrations();
    }

    @Override
    @GetMapping("/registration")
    public void getRegistration(@RequestParam int id) {

        return registrationService.getRegistration(id);

    }
    




}