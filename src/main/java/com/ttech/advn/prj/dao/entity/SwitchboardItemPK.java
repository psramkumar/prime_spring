package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * 
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 17, 2013 
 *
 */
@Data
@Embeddable
public class SwitchboardItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int switchboardID;

	private short itemNumber;

}