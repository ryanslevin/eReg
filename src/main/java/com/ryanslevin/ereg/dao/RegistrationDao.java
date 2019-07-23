package com.ryanslevin.ereg.dao;

import java.util.List;

import com.ryanslevin.ereg.entity.Registration;

public interface RegistrationDao {

	public void register(Registration registration);

	public void cancel(Registration registration);

	public List<Registration> getRegistrations();

	public Registration getRegistration(int id);

}