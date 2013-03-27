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
@Entity
@Table(name="switchboard_items")
public class SwitchboardItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwitchboardItemPK id = new SwitchboardItemPK();

	private String argument;

	private short command;

	private String itemText;

	}