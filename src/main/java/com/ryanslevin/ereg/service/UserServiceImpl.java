package com.ryanslevin.ereg.service;

import java.util.List;

import com.ryanslevin.ereg.dao.UserDao;
import com.ryanslevin.ereg.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

@Autowired
UserDao userDao;

    @Override
    public List<User> getUsers() {

        return userDao.getUsers();

    }

    @Override
    public User getUser(int id) {

        return userDao.getUser(id);

    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    



    
}