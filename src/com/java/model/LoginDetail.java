package com.java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="loginDetail")
public class LoginDetail implements Serializable {
	
	private static final long serialVersionUID = -4428886433006938467L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "isActive")
	private Boolean isActive;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginDetail")
	private List<Post> post = new ArrayList<Post>(0);

	public LoginDetail() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
