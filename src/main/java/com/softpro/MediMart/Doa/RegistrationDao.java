package com.softpro.MediMart.Doa;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class RegistrationDao {
	
	@NotEmpty(message = "name can't be null")
	private String name;
	
	@NotEmpty(message = "gender can't be null")
	private String gender;
	
	@NotEmpty(message = "DOB can't be null")
	private String birthdate;
	
	@NotEmpty(message = "contact can't be null")
	private String contactno;
	
	@NotEmpty(message = "email can't be null")
	private String email;
	
	@NotEmpty(message = "password can't be null")
	private String password;
	
	@NotEmpty(message = "address can't be null")
	private String address;
	
	private MultipartFile profile;
	
	
	private String regdate;
	
	//getter and setter started 


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


	public MultipartFile getProfile() {
		return profile;
	}


	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}


	public String getregdate() {
		return regdate;
	}


	public void setregdate(String regdate) {
		this.regdate = regdate;
	}
	
	






}
