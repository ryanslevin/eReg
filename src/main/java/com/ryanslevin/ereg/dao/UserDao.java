package com.ryanslevin.ereg.dao;

import java.util.List;

import com.ryanslevin.ereg.entity.User;

public interface UserDao {

    public List<User> getUsers();

	public void addUser(User user);

	public User getUser(int id);

	public void updateUser(User user);


}