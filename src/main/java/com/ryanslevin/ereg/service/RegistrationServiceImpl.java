package com.ryanslevin.ereg.service;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationDao registrationDao;

    @Override
    public void register(Registration registration) {

        registrationDao.register(registration);

    }

    @Override
    public void cancel(Registration registration) {

        registration.setCancelled(true);

        registrationDao.cancel(registration);

    }

    @Override
    public void transfer(Registration registration, Course course) {

        registration.setCourse(course);

        registrationDao.transfer(registration);

    }

}