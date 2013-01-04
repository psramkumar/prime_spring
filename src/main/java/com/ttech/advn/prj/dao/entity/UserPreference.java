package com.ttech.advn.prj.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="users_preferences")
public class UserPreference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="prefferd_key")
	private String prefferdKey;
	@Column(name="preffered_value")
	private String prefferedValue;
	@Lob @Column(name="text_value")
	private String textValue;
	@Lob @Column(name="binary_value")
	private byte[] binaryValue;
	@ManyToOne
	private User user;
	
}