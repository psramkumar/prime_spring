package com.ttech.advn.prj.dao;

import org.springframework.stereotype.Repository;

import com.ttech.advn.prj.dao.entity.User;

@Repository
public class UserDAO  extends AbstractSupportDAO<User> implements  IUserDAO<User>{
	
	public UserDAO(){
		super(User.class);
	}

}
