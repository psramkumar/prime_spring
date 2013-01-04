package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;

import lombok.Data;


@Data
@Entity
@Table(name="permissions")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	private String name;
	@Column(name="perm_name")
	private String permissionName;
	@ManyToMany(mappedBy="permissions")
	private Set<Role> roles;
}