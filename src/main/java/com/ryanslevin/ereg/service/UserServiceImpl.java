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

    public List<User> getUsers() {

        return userDao.getUsers();

    }



    
}