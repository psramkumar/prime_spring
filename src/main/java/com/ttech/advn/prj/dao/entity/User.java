package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

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
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private int createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deactivatedDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date expireDate;
	private Timestamp lastLogin;
	private String password;
	private short status;
	private String userName;
	private String firstName;
	private String lastName;
	private String userType;
	@OneToMany(mappedBy="user")
	private Set<UserPreference> userPreference;
	@ManyToMany
	@JoinTable(name="users_roles", 
	joinColumns={@JoinColumn(name="users_id")}, 
	inverseJoinColumns={@JoinColumn(name="roles_id")})
	private Set<Role> roles;
	
}