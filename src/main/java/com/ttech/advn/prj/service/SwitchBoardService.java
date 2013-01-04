package com.ttech.advn.prj.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttec.advn.prj.support.AbstractSupportService;
import com.ttech.advn.prj.dao.RoleDAOIFace;
import com.ttech.advn.prj.dao.entity.Role;

@Service
@Transactional
public class SwitchBoardService extends AbstractSupportService<Role> implements ISwitchBoardService {

	@Autowired
	RoleDAOIFace<Role> RoleDao;
	
	@PostConstruct
	public void setDependants(){
		setAbstractDAO(RoleDao);
	}

}
