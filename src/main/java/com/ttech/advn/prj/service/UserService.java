package com.ttech.advn.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttech.advn.prj.dao.IUserDAO;
import com.ttech.advn.prj.dao.entity.User;

@Service
@Transactional
public class UserService implements IUserService {

	// UserDAO is injected...
	@Autowired
	IUserDAO userDAO;
	
	//@Transactional(readOnly = false)
	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	//@Transactional(readOnly = false)
	@Override
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}
	
	//@Transactional(readOnly = false)
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	@Override
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	@Override
	public List<User> getUsers() {	
		return userDAO.getUsers();
	}
}
