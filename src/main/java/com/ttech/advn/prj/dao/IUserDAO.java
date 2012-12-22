package com.ttech.advn.prj.dao;

import java.util.List;

import com.ttech.advn.prj.dao.entity.User;

public interface IUserDAO {

	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUserById(int id);
	public List<User> getUsers();
}
