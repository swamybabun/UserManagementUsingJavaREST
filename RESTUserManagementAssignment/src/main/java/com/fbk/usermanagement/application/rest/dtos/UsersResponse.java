package com.fbk.usermanagement.application.rest.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response object for GET ALL Users.
 * 
 * @author Swamy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponse {

	@JsonProperty("page")
	private int page;

	@JsonProperty("per_page")
	private int per_page;

	@JsonProperty("total")
	private int total;

	@JsonProperty("total_pages")
	private int total_pages;

	@JsonProperty("data")
	private List<UserObject> users;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<UserObject> getUsers() {
		return users;
	}

	public void setUsers(List<UserObject> users) {
		this.users = users;
	}

}
