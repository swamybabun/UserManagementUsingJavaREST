package com.fbk.usermanagement.application.rest.dtos;

import java.io.Serializable;

public class LoginObject implements Serializable {

	private static final long serialVersionUID = 1346019264679517137L;

	private String email;

	private String password;

	public LoginObject(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

}
