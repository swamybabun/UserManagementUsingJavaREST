package com.fbk.usermanagement.application.services;

import java.util.List;

import com.fbk.usermanagement.application.rest.dtos.LoginObject;
import com.fbk.usermanagement.application.viewobjects.User;

/**
 * Interface responsible for managing the list of users maintained by the application. It should provide he following
 * functionalities: - add new users to the list of users - update information of a user already in the list - delete
 * information of a user already in the list To fulfil the operations, the methods should consume the REST APIs
 * available at: https://reqres.in
 */

public interface UserManager {

	/**
	 * Adds the user into the list of users by consuming the REST API: CREATE/POST (https://reqres.in)
	 * 
	 * @param userName Name of the user to be added
	 * @param job title of the user's job
	 * @return True if user is successfully added, false otherwise
	 */
	public boolean addUserInfo(String userName, String job);

	/**
	 * Update the job title of a user currently in the list by consuming the REST API: UPDATE/PUT or PATCH
	 * (https://reqres.in)
	 * 
	 * @param userName Name of the user whose info is to be updated
	 * @param job title of new job of the user
	 * @param id ID if the user whose info is to be updated
	 * @return True if user info is successfully updated, false otherwise
	 */
	public boolean updateUserInfo(String userName, String job, int id);

	/**
	 * Delete the the user from the list by consuming the REST API: DELETE/DELETE (https://reqres.in)
	 * 
	 * @param id ID of the user whose info is to be deleted
	 * @return True is user info is successfully deleted, false otherwise
	 */
	public boolean deleteUserInfo(int id);

	/**
	 * Gets all the users from the list by consuming the REST API: GET/GET (https://reqres.in)
	 * 
	 * @return the users information
	 */
	public List<User> getUsers();

	/**
	 * Gets the requested user from the list by consuming the REST API: GET/GET (https://reqres.in)
	 * 
	 * @return the user information
	 */
	public User getUser(int id);

	/**
	 * Validates the login.
	 * 
	 * @param loginObject
	 * @return
	 */
	boolean validateLogin(LoginObject loginObject);
}
