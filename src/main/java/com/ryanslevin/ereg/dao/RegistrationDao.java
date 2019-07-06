package com.ryanslevin.ereg.dao;

import com.ryanslevin.ereg.entity.Registration;

public interface RegistrationDao {

	void register(Registration registration);

	void cancel(Registration registration);

	void transfer(Registration registration);

}