package com.ttech.advn.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttec.advn.prj.support.AbstractSupportService;
import com.ttech.advn.prj.dao.UserDAOIFace;
import com.ttech.advn.prj.dao.entity.User;

@Service
@Transactional
public class UserService extends AbstractSupportService<User> implements IUserService {

	@Autowired
	UserDAOIFace<User> userDAO;

	@Override
	public void setDependants() {
		setAbstractDAO(userDAO);
	}
	
}
