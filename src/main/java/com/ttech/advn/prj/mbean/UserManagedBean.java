package com.ttech.advn.prj.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.ttech.advn.prj.dao.entity.User;
import com.ttech.advn.prj.service.IUserService;

@Data
@Controller("userMB")
@RequestScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@Autowired
	IUserService userService;

	List<User> userList;

	private int id;
	private String name;
	private String surname;

	public String addUser() {
		try {
			User user = new User();
			user.setId(getId());
			user.setName(getName());
			user.setSurname(getSurname());
			userService.addUser(user);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public void reset() {
		this.setId(0);
		this.setName("");
		this.setSurname("");
	}

	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(userService.getUsers());
		return userList;
	}
}