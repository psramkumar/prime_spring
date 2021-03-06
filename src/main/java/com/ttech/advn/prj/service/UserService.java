package com.ttech.advn.prj.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttec.advn.prj.support.AbstractSupportService;
import com.ttech.advn.prj.dao.UserDAOIFace;
import com.ttech.advn.prj.dao.entity.User;

/**
 * 
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 17, 2013 
 *
 */
@Service
@Transactional
public class UserService extends AbstractSupportService<User> implements UserServiceIFace {

	@Autowired
	UserDAOIFace<User> userDAO;

	@Override @PostConstruct
	public void setDependants() {
		setAbstractDAO(userDAO);
	}
	
}
