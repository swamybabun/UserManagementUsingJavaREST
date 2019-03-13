package com.fbk.usermanagement.application.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbk.usermanagement.application.rest.dtos.LoginObject;
import com.fbk.usermanagement.application.services.UserManager;
import com.fbk.usermanagement.application.viewobjects.User;

/**
 * Performs the Service operations for User.
 * 
 * @author Swamy
 *
 */
@Service("userService")
public class UserService {

	@Autowired
	private UserManager userManager;

	private static Logger log = Logger.getLogger(UserService.class);

	public List<User> getAll() {
		List<User> usersList = userManager.getUsers();
		log.debug("Total records fetched are= " + usersList.size());
		return usersList;
	}

	public Boolean add(User user) {
		log.debug("Adding a new user; Entered user_name is= " + user.getName());
		boolean addUserInfo = false;
		try {
			addUserInfo = userManager.addUserInfo(user.getName(), "Jobi");
		} catch (Exception e) {
			log.error("An error occurred while saving a new user", e);
		}
		return addUserInfo;
	}

	public Boolean edit(User user) {
		boolean output = false;
		log.debug("Updating the existing user; Entered user_id is= " + user.getId());
		try {
			// Updating the user
			output = userManager.updateUserInfo(user.getName(), "Job1", Integer.valueOf(user.getId()));
		} catch (Exception e) {
			output = false;
			log.error("An error has occurred while updating an existing user", e);
		}
		return output;
	}

	public Boolean delete(String id) {
		boolean output = false;
		log.debug("Deleting an existing user; Entered user_id is= " + id);
		try {
			// Fetching the required user
			output = userManager.deleteUserInfo(Integer.valueOf(id));
		} catch (Exception e) {
			output = false;
			log.error("An error occurred while deleting an existing user", e);
		}
		return output;
	}

	public User getById(String id) {
		User output = null;
		log.debug("Deleting an existing user; Entered user_id is= " + id);
		try {
			// Fetching the required user
			output = userManager.getUser(Integer.valueOf(id));
		} catch (Exception e) {
			log.error("An error occurred while deleting an existing user", e);
		}
		return output;
	}

	public boolean validateLogin(String email, String password) {
		boolean output = false;
		log.debug("Validating the user login; Entered user_id is= " + email);
		try {
			// Validating the user
			LoginObject loginObject = new LoginObject(email, password);
			output = userManager.validateLogin(loginObject);
		} catch (Exception e) {
			log.error("An error occurred while validating the login for the user", e);
		}
		return output;
	}
}
