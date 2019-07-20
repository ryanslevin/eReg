package com.ryanslevin.ereg.service;

import java.util.Date;
import java.util.List;

import com.ryanslevin.ereg.dao.CourseDao;
import com.ryanslevin.ereg.dao.RegistrationDao;
import com.ryanslevin.ereg.dao.UserDao;
import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.Registration;
import com.ryanslevin.ereg.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationDao registrationDao;

    @Autowired
    CourseDao courseDao;
    
    @Autowired
    UserDao userDao;

    @Override
    public void register(int courseId, int userId) {

        //Get course from dao
        Course course = courseDao.getCourse(courseId);

        //Get user from dao
        User user = userDao.getUser(userId);

        //Create new registration object, passing in the user and course
        Registration registration = new Registration(user, course);

        // Save reg to db
        registrationDao.register(registration);

    }

    @Override
    public void cancel(Registration registration) {

        // Set cancellation status of registration to true
        registration.setCancelled(true);

        // Set cancelled date to now
        registration.setCancelledDateTime(new Date());

        // Update registration in db
        registrationDao.cancel(registration);

    }

    @Override
    public List<Registration> getRegistrations() {

        return registrationDao.getRegistrations();

    }

}