package com.ryanslevin.ereg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ryanslevin.ereg.entity.User;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUsers() {

        // Create session by unwrapping autowired entityManager
        Session session = entityManager.unwrap(Session.class);

        // Query to request all rows from User table
        Query getUsers = session.createQuery("from User", User.class);

        // Execute the query and assign users to List of users
        List<User> users = getUsers.getResultList();

        // Return list of users back to service layer
        return users;

    }

    @Override
    @Transactional
    public User getUser(int id) {

            // Create session by unwrapping autowired entityManager
            Session session = entityManager.unwrap(Session.class);

            // Query to request row from User table where the id = param
            Query getUser = session.createQuery("from User where id = "+id, User.class);

            // Populate user with the data from query
            User user = (User) getUser.getSingleResult();

            return user;

    }

    @Override
    @Transactional   
    public void addUser(User user) {

        // Create session by unwrapping autowired entityManager
        Session session = entityManager.unwrap(Session.class);

        // Save the user in the database
        session.save(user);

    }

    @Override
    @Transactional
    public void updateUser(User user) {

        // Create session by unwrapping autowired entityManager
        Session session = entityManager.unwrap(Session.class);

        // Update the user in the db
        session.update(user);

    }

    @Override
    @Transactional
    public void deleteUser(int id) {

        // Create session by unwrapping autowired entityManager
        Session session = entityManager.unwrap(Session.class);

        // Query to request row from User table where the id = param
        Query getUser = session.createQuery("from User where id = "+id, User.class);

        // Populate user object with result from query
        User user = (User) getUser.getSingleResult();

        // Execute delete on user
        session.delete(user);

    }

}