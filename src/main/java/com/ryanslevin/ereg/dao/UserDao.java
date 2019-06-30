package com.ryanslevin.ereg.dao;

import com.ryanslevin.ereg.entity.User;

public interface UserDao {

    public User getUser();
    
    public void saveUser(User user);


}