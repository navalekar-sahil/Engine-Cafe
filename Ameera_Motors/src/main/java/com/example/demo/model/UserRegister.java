package com.example.demo.model;

import java.util.List;

import jakarta.validation.constraints.Size;

public class UserRegister {
	private String name;
	private String email;
	
	@Size(min = 4,max = 10)
	private String password;
	
	private List<String> roles;

	public UserRegister(String name, String email, @Size(min = 4, max = 10) String password, List<String> roles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public UserRegister() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	

}
