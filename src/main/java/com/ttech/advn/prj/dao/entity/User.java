package com.ttech.advn.prj.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER")
public class User {

	@Id
	@Column(name="ID", unique = true, nullable = false) 
	private int id;
	@Column(name="NAME", unique = true, nullable = false)
	private String name;
	@Column(name="SURNAME", unique = true, nullable = false)
	private String surname;
}
