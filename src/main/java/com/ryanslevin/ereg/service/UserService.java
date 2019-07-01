package com.ryanslevin.ereg.service;

import java.util.List;

import com.ryanslevin.ereg.entity.User;

public interface UserService {

    public List<User> getUsers();

	public void addUser(User user);

	public User getUser(int id);

}