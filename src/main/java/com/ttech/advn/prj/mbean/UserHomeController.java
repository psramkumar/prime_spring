package com.ttech.advn.prj.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ttec.advn.prj.support.AbstractSupportController;
import com.ttech.advn.prj.dao.entity.User;
import com.ttech.advn.prj.service.UserServiceIFace;

@Controller("userHome")
public class UserHomeController extends AbstractSupportController<User> {

	@Autowired
	UserServiceIFace userService;

	public List<User> getResultSet() {
		return userService.getResultSet();
	}
	
	public void addUser(){
		userService.save(getInstance());
		//return "userHome";
	}
}
