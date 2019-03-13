package com.fbk.usermanagement.application.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbk.usermanagement.application.rest.dtos.LoginObject;
import com.fbk.usermanagement.application.rest.services.WebClient;
import com.fbk.usermanagement.application.services.UserManager;
import com.fbk.usermanagement.application.viewobjects.User;

/**
 * Implementation for the given user manager operations.
 * 
 * @author Swamy
 *
 */
@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private WebClient webClient;

	@Override
	public boolean addUserInfo(String userName, String job) {
		return webClient.addUser(userName, job);
	}

	@Override
	public boolean updateUserInfo(String userName, String job, int id) {
		return webClient.updateUser(userName, job, id);
	}

	@Override
	public boolean deleteUserInfo(int id) {
		return webClient.deleteUser(id);
	}

	@Override
	public List<User> getUsers() {
		return webClient.getUsers();
	}

	@Override
	public User getUser(int id) {
		return webClient.getUser(id);
	}

	@Override
	public boolean validateLogin(LoginObject loginObject) {
		return webClient.validateLogin(loginObject);
	}
}
