package com.ryanslevin.ereg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

        System.out.println(registration);

        session.save(registration);

    }

    @Override
    public void cancel(Registration registration) {

        //Get session
        Session session = entityManager.unwrap(Session.class);

        session.update(registration);

    }

    @Override
    public List<Registration> getRegistrations() {
        
        // Get session
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from Registration", Registration.class);

        List<Registration> registrations = query.getResultList();

        return registrations;
    }

    @Override
    public Registration getRegistration(int id) {
        
        //Get session
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from Registration where id = "+id, Registration.class);

        Registration registration = (Registration) query.getSingleResult();

        return registration;

    }
    
}