package com.ryanslevin.ereg.dao;

import java.util.List;

import com.ryanslevin.ereg.entity.User;

public interface UserDao {

    public List<User> getUsers();
    
    public void saveUser(User user);


}