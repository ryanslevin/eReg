package com.ryanslevin.ereg.controller;

import java.util.List;

import com.ryanslevin.ereg.entity.User;
import com.ryanslevin.ereg.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers(); 

    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {

        userService.addUser(user);

    }


}