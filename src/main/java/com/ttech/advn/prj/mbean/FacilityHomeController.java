/**
 * 
 */
package com.ttech.advn.prj.mbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ttec.advn.prj.support.AbstractSupportController;
import com.ttech.advn.prj.dao.entity.Facility;
import com.ttech.advn.prj.service.FacilityServiceIFace;

/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 17, 2013 
 *
 */

@Controller("facilityHome")
public class FacilityHomeController extends AbstractSupportController<Facility> {

	@Autowired
	FacilityServiceIFace facilityService;

	public List<Facility> getResultSet() {
		return facilityService.getResultSet();
	}
	
	public void addFacility(){
		facilityService.save(getInstance());
		//return "facilityHome";
	}
}
