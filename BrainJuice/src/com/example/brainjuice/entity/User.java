package com.example.brainjuice.entity;

public class User {
	private String username;
	private String password;
	private String userType;
	private String email;
	private String profile;
	
	public User(String username, String password, String userType,
			String email, String profile) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.profile = profile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
