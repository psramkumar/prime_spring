/**
 * 
 */
package com.ttech.advn.prj.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttec.advn.prj.support.AbstractSupportService;
import com.ttech.advn.prj.dao.FacilityDAOIFace;
import com.ttech.advn.prj.dao.entity.Facility;

/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 17, 2013 
 *
 */
@Service
@Transactional
public class FacilityService extends AbstractSupportService<Facility> implements FacilityServiceIFace{
	
	@Autowired
	private FacilityDAOIFace<Facility> facilityDao;
	
	@Override @PostConstruct
	public void setDependants() {
		setAbstractDAO(facilityDao);
	}
}
