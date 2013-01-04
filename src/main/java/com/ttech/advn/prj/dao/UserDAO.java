package com.ttech.advn.prj.dao;

import org.springframework.stereotype.Repository;

import com.ttec.advn.prj.support.AbstractSupportDAO;
import com.ttech.advn.prj.dao.entity.User;

@Repository
public class UserDAO  extends AbstractSupportDAO<User> implements  UserDAOIFace<User>{
	
	public UserDAO(){
		super(User.class);
	}

}
