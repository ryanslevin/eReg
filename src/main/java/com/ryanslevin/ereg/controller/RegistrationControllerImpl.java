package com.ryanslevin.ereg.controller;

import java.util.List;

import com.ryanslevin.ereg.entity.Registration;
import com.ryanslevin.ereg.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationControllerImpl implements RegistrationController {

    @Autowired
    RegistrationService registrationService;

    // API endpoint that takes two int params (courseId, userId) and creates a registration
    // Endpoint: http://localhost:8080/api/registration/register?courseId=n&userId=n
    @Override
    @PostMapping("/register")
    public void register(@RequestParam int courseId, @RequestParam int userId) {

        registrationService.register(courseId, userId);

    }

    // API endpoint that cancels a course, takes a Registration object as RequestBody
    // Endpoint: http://localhost:8080/api/registration/cancel
    @Override
    @PutMapping("/cancel")
    public void cancel(@RequestBody Registration registration) {

        registrationService.cancel(registration);

    }

    // API endpoint that returns all registrations
    // Endpoint: http://localhost:8080/api/registration/registrations
    @Override
    @GetMapping("/registrations")
    public List<Registration> getRegistrations() {
        
        return registrationService.getRegistrations();
    }

    // API endpoint that returns registration where id = n
    // Endpoint: http://localhost:8080/api/registration/registration?id=n
    @Override
    @GetMapping("/registration")
    public Registration getRegistration(@RequestParam int id) {

        return registrationService.getRegistration(id);

    }

}