package com.ryanslevin.ereg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ryanslevin.ereg.entity.User;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    EntityManager entityManager;

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

    public User getUser(int id) {

            // Create session by unwrapping autowired entityManager
            Session session = entityManager.unwrap(Session.class);

            // Query to request row from User table where the id = param
            Query getUser = session.createQuery("from User where id = "+id, User.class);

            User user = (User) getUser.getSingleResult();

            return user;


    }


    public void addUser(User user) {

        // Create session by unwrapping autowired entityManager
        Session session = entityManager.unwrap(Session.class);

        /* Save the user in the database, or update if they already exist.

        This should potentially just be update, as users should not be
        overwritten using this method.

        */

        session.saveOrUpdate(user);



    }

}