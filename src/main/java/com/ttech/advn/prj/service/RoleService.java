/**
 * 
 */
package com.ttech.advn.prj.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttec.advn.prj.support.AbstractSupportService;
import com.ttech.advn.prj.dao.PermissionDAOIFace;
import com.ttech.advn.prj.dao.RoleDAOIFace;
import com.ttech.advn.prj.dao.entity.Permission;
import com.ttech.advn.prj.dao.entity.Role;

/**
 * @author Ramkumar Pillai
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 4, 2013 
 *
 */
@Service
@Transactional
public class RoleService extends AbstractSupportService<Role> implements RoleServiceIFace{

	@Autowired
	private RoleDAOIFace<Role> roleDao;
	
	@Autowired
	private PermissionDAOIFace<Permission> permDao;
	
	
	@Override @PostConstruct
	public void setDependants() {
		setAbstractDAO(roleDao);
	}
	
	public List<Permission> getPermissionSet(){
		return permDao.resultSet();
	}

}
