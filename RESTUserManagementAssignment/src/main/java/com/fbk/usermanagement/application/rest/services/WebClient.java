package com.fbk.usermanagement.application.rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.fbk.usermanagement.application.rest.constants.EmpRestURIConstants;
import com.fbk.usermanagement.application.rest.dtos.CreateUpdateUserResponse;
import com.fbk.usermanagement.application.rest.dtos.CreateUserObject;
import com.fbk.usermanagement.application.rest.dtos.GetUserResponse;
import com.fbk.usermanagement.application.rest.dtos.LoginObject;
import com.fbk.usermanagement.application.rest.dtos.UserObject;
import com.fbk.usermanagement.application.rest.dtos.UsersResponse;
import com.fbk.usermanagement.application.viewobjects.User;

/**
 * Web Client for making REST calls.
 * 
 * @author Swamy
 */
@Service
public class WebClient {

	private static Logger log = Logger.getLogger(WebClient.class);

	Client client = null;

	public WebClient() {
		client = ClientBuilder.newClient();
	}

	public boolean validateLogin(LoginObject loginObject) {
		WebTarget webTarget = client.target(EmpRestURIConstants.BASE_URL).path(EmpRestURIConstants.USER_LOGIN);

		int requestResult = webTarget.request()
		        .accept(MediaType.APPLICATION_JSON_VALUE)
		        .buildPost(Entity.entity(loginObject, javax.ws.rs.core.MediaType.APPLICATION_JSON))
		        .invoke()
		        .getStatus();

		log.debug("the response of validate login is " + requestResult);

		if (requestResult == 200) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> getUsers() {
		Response response =
		        client.target(EmpRestURIConstants.BASE_URL).path(EmpRestURIConstants.GET_ALL_USERS).request().get();
		UsersResponse users = response.readEntity(UsersResponse.class);
		List<UserObject> data = users.getUsers();

		List<User> userViewObjs = new ArrayList<>();
		for (UserObject userResponse : data) {
			User user = new User();
			user.setName(userResponse.getFirstName() + " " + userResponse.getLastName());
			user.setId(String.valueOf(userResponse.getId()));
			userViewObjs.add(user);
		}
		return userViewObjs;
	}

	public boolean addUser(String username, String job) {
		CreateUserObject reqResUser = new CreateUserObject(username, job);

		Response response = client.target(EmpRestURIConstants.BASE_URL)
		        .path(EmpRestURIConstants.CREATE_USER)
		        .request()
		        .post(Entity.json(reqResUser));

		CreateUpdateUserResponse createUserReponse = response.readEntity(CreateUpdateUserResponse.class);
		log.debug("create user response ..{}" + createUserReponse);
		return true;
	}

	public boolean updateUser(String username, String job, int id) {
		CreateUserObject reqResUser = new CreateUserObject(username, job);

		Response response = client.target(EmpRestURIConstants.BASE_URL)
		        .path(EmpRestURIConstants.COMMON_USER + "/" + id)
		        .request()
		        .put(Entity.json(reqResUser));

		CreateUpdateUserResponse updateUserResponse = response.readEntity(CreateUpdateUserResponse.class);
		log.debug("update user response ..{}" + updateUserResponse);
		return true;
	}

	public boolean deleteUser(int id) {
		Response response = client.target(EmpRestURIConstants.BASE_URL)
		        .path(EmpRestURIConstants.COMMON_USER + "/" + id)
		        .request()
		        .delete();

		int deleteUserStatus = response.getStatus();
		log.debug("delete user response ..{}" + deleteUserStatus);

		if (deleteUserStatus == 204) {
			return true;
		} else {
			return false;
		}
	}

	public User getUser(int id) {
		Response response = client.target(EmpRestURIConstants.BASE_URL)
		        .path(EmpRestURIConstants.COMMON_USER + "/" + id)
		        .request()
		        .get();
		GetUserResponse users = response.readEntity(GetUserResponse.class);

		UserObject user = users.getUser();

		// Converting object to view object type
		User userViewObj = new User();
		userViewObj.setId(String.valueOf(user.getId()));
		userViewObj.setName(user.getFirstName() + " " + user.getLastName());
		userViewObj.setJob(user.getAvatar());
		return userViewObj;
	}
}
