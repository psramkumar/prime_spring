package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

import lombok.Data;


@Data
@Entity
@Table(name="roles")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	private String name;
	@Column(name="role_name")
	private String roleName;
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
	@ManyToMany
	@JoinTable(name="roles_permissions", 
	joinColumns={@JoinColumn(name="roles_id")}, 
	inverseJoinColumns={@JoinColumn(name="permissions_id")})
	private Set<Permission> permissions;
}