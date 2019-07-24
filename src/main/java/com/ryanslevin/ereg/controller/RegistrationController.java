package com.ryanslevin.ereg.controller;

import java.util.List;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.Registration;
import com.ryanslevin.ereg.entity.User;

public interface RegistrationController {

    public List<Registration> getRegistrations();

    public void register(int courseId, int userId);

    public void cancel(Registration registration);

    public Registration getRegistration(int registrationId);

}