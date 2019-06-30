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

        Session session = entityManager.unwrap(Session.class);

        Query getUsers = session.createQuery("from User", User.class);

        List<User> users = getUsers.getResultList();

        return users;

    }

    public void saveUser(User user) {

    }

}