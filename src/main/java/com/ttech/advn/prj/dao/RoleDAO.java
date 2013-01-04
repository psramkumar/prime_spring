/**
 * 
 */
package com.ttech.advn.prj.dao;

import org.springframework.stereotype.Repository;

import com.ttec.advn.prj.support.AbstractSupportDAO;
import com.ttech.advn.prj.dao.entity.Role;
/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 3, 2013 
 */
@Repository
public class RoleDAO extends AbstractSupportDAO<Role> implements RoleDAOIFace<Role> {
	
	public RoleDAO(){
		super(Role.class);
	}
}
