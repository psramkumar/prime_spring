package com.ttech.advn.prj.service;

import java.util.List;

import com.ttech.advn.prj.dao.entity.User;

public interface IUserService {
	
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUserById(int id);
	public List<User> getUsers();
}
