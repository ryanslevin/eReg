package com.ryanslevin.ereg.service;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.Registration;

public interface RegistrationService {

	void register(Registration registration);

	void cancel(Registration registration);

	void transfer(Registration registration, Course course);

}