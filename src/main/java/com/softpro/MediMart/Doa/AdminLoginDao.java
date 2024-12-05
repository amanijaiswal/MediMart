package com.softpro.MediMart.Doa;

import jakarta.validation.constraints.NotEmpty;

public class AdminLoginDao {

	
	private String name;
	
	@NotEmpty(message = "user id can't be null")
	private String userid;
	
	@NotEmpty(message = "please enter your password")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
