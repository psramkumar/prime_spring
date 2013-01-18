/**
 * 
 */
package com.ttech.advn.prj.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ttec.advn.prj.support.AbstractSupportController;
import com.ttech.advn.prj.dao.entity.Permission;
import com.ttech.advn.prj.dao.entity.Role;
import com.ttech.advn.prj.service.PermissionServiceIFace;
import com.ttech.advn.prj.service.RoleServiceIFace;

/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 18, 2013 
 *
 */
@Controller("roleHome")
public class RoleAnPermHome  extends AbstractSupportController<Role>{

	@Autowired
	RoleServiceIFace roleService;
	
	@Autowired
	PermissionServiceIFace permService;
	

	public List<Role> getRoleSet() {
		return roleService.getResultSet();
	}
	
	public List<Permission> getAllPermissions(){
		return permService.getResultSet();
	}
	
	public void addRole(){
		roleService.save(getInstance());
		//return "roleHome";
	}
}
