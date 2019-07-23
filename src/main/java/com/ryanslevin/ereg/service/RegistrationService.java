package com.ryanslevin.ereg.service;

import java.util.List;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.Registration;
import com.ryanslevin.ereg.entity.User;

public interface RegistrationService {

	public void register(int courseId, int userId);

	public void cancel(Registration registration);

	public List<Registration> getRegistrations();

	public Registration getRegistration(int id);

}