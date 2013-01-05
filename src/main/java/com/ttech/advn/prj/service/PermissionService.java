/**
 * 
 */
package com.ttech.advn.prj.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttec.advn.prj.support.AbstractSupportService;
import com.ttech.advn.prj.dao.PermissionDAO;
import com.ttech.advn.prj.dao.entity.Permission;

/**
 * @author Ramkumar Pillai
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 4, 2013 
 *
 */
@Service
@Transactional
public class PermissionService extends AbstractSupportService<Permission> implements PermissionServiceIFace {

	@Autowired
	PermissionDAO permissionDao;
	
	@Override @PostConstruct
	public void setDependants() {
		setAbstractDAO(permissionDao);
	}

}
