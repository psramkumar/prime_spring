/**
 * 
 */
package com.ttech.advn.prj.dao;

import org.springframework.stereotype.Repository;

import com.ttec.advn.prj.support.AbstractSupportDAO;
import com.ttech.advn.prj.dao.entity.Permission;

/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 3, 2013 
 */

@Repository
public class PermissionDAO extends AbstractSupportDAO<Permission> implements PermissionDAOIFace<Permission> {

	public PermissionDAO(){
		super(Permission.class);
	}
}
