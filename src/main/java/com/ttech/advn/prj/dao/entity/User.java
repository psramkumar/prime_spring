package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import lombok.Data;


@Data
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	private int createdby;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deactivateddate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiredate;
	private Timestamp lastlogin;
	private String password;
	private short status;
	private String username;
	private String usertype;
	@OneToMany(mappedBy="user")
	private Set<UserPreference> userPreference;
	@ManyToMany
	@JoinTable(name="users_roles", 
	joinColumns={@JoinColumn(name="users_id")}, 
	inverseJoinColumns={@JoinColumn(name="roles_id")})
	private Set<Role> roles;
	
}