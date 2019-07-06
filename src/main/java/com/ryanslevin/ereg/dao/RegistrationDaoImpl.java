package com.ryanslevin.ereg.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.ryanslevin.ereg.entity.Registration;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class RegistrationDaoImpl implements RegistrationDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public void register(Registration registration) {

        //Get session
        Session session = entityManager.unwrap(Session.class);

        session.save(registration);

    }

    @Override
    public void cancel(Registration registration) {

        //Get session
        Session session = entityManager.unwrap(Session.class);

        session.update(registration);

    }

    @Override
    public void transfer(Registration registration) {

        //Get session
        Session session = entityManager.unwrap(Session.class);

        session.update(registration);

    }
    
}