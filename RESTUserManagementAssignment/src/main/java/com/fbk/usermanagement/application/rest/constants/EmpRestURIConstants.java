package com.fbk.usermanagement.application.rest.constants;

public interface EmpRestURIConstants {

	public static final String BASE_URL = "https://reqres.in";

	// LOGIN
	public static final String USER_LOGIN = "/api/login";

	// REST
	public static final String COMMON_USER = "/api/users";
	public static final String GET_ALL_USERS = COMMON_USER;
	public static final String GET_USER = COMMON_USER + "/{id}";
	public static final String CREATE_USER = COMMON_USER;
	public static final String DELETE_USER = COMMON_USER + "/{id}";
}
