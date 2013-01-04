package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

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