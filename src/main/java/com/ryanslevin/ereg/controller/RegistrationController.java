package com.ryanslevin.ereg.controller;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.Registration;
import com.ryanslevin.ereg.entity.User;

public interface RegistrationController {

    public void register(Registration regsitration);

    public void cancel(Registration registration);

    public void transfer(Registration registration, Course course);

}