package com.softpro.MediMart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Registration {
	
	@Column(nullable = false, length = 60)
	private String name;
	
	@Column(nullable = false, length = 12)
	private String gender;
	
	@Column(nullable = false, length = 16)
	private String birthdate;
	
	@Column(nullable = false, length = 13)
	private String contactno;
	
	@Id
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 200)
	private String address;
	
	@Column(nullable = false, length = 1000)
	private String profile;
	
	@Column(nullable = false, length = 200)
	private String regdate;

	//getter and setter start

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getregdate() {
		return regdate;
	}

	public void setregdate(String regdate) {
		this.regdate = regdate;
	}
	
	

}
