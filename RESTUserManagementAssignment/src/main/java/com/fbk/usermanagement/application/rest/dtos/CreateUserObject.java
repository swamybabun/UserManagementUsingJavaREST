package com.fbk.usermanagement.application.rest.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object for create user operations.
 * 
 * @author Swamy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserObject implements Serializable {

	private static final long serialVersionUID = 1873381172294397430L;

	@JsonProperty("username")
	private String username;

	@JsonProperty("job")
	private String job;

	public CreateUserObject() {
		super();
	}

	public CreateUserObject(String username, String job) {
		super();
		this.username = username;
		this.job = job;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
