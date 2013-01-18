package com.ttech.advn.prj.dao;

import org.springframework.stereotype.Repository;

import com.ttec.advn.prj.support.AbstractSupportDAO;
import com.ttech.advn.prj.dao.entity.Facility;
/**
 * 
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 17, 2013 
 *
 */
@Repository
public class FacilityDAO extends AbstractSupportDAO<Facility> implements FacilityDAOIFace<Facility>{

	public FacilityDAO(){
		super(Facility.class);
	}
}
