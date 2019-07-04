package com.ryanslevin.ereg.controller;

import java.util.List;

import com.ryanslevin.ereg.entity.User;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserController {
    
    public List<User> getUsers();

    public User getUser(int id);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);


}