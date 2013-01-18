package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 17, 2013 
 *
 */

@Data
@Entity
@Table(name="facility_table")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int facility_ID;
	private String type_of_Facility;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date_Facility_Entered;

	private String facility_Telephone_Number;
	private String facility_Fax_Number;
	private String facility_Line2;

	private String name_of_Facility;
	private String owner_of_Facility;
	private String paying_Office;
	private String permit_Number;
	
	private String contact;
	private String street_Address;
	private String city;
	private String state;
	private String zip;
	
	@Lob
	private String facility_Notes;

}