package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Data
@Embeddable
public class SwitchboardItemPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int switchboardID;

	private short itemNumber;

}