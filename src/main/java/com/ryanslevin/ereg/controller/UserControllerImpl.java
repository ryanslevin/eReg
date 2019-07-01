package com.ryanslevin.ereg.controller;

import java.util.List;

import com.ryanslevin.ereg.entity.User;
import com.ryanslevin.ereg.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserControllerImpl implements UserController {


    // Autowire the UserService layer that will be used in User based API calls
    @Autowired
    UserService userService;

    // API endpoint that returns all users
    // Endpoint: http://localhost:8080/users
    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers(); 

    }

    // API endpoint that returns a single user
    // Example endpoint: http://localhost:8080/api/user?id=1
    @GetMapping("/user")
    public User getUser(@RequestParam int id) {
        
        return userService.getUser(id);

    }

    // API endpoint that creates a user
    // Example endpoint: http://localhost:8080/user
    @PostMapping("/user")
    public void addUser(@RequestBody User user) {

        userService.addUser(user);

    }

    // API endpoint to update a user
    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {

        userService.updateUser(user);

    }


}