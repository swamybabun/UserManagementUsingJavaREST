package com.fbk.usermanagement.application.rest.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response object for Single User GET call.
 * 
 * @author Swamy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserResponse {

	@JsonProperty("data")
	private UserObject user;

	public UserObject getUser() {
		return user;
	}

	public void setUser(UserObject user) {
		this.user = user;
	}
}
