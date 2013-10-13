package com.example.brainjuice.entity;

import java.util.ArrayList;

public class UserMgr {
	ArrayList<User> userList;
	
	public UserMgr(){
		userList = new ArrayList<User>();
		
		userList.add(new User("JonathanTan", "1234", "child", "jonathantan@gmail.com", "minion"));
		userList.add(new User("MelissaTan", "1234", "adult", "melissatan@gmail.com", "melissa"));
		userList.add(new User("JackyWong", "1234", "adult", "jackywong@gmail.com", "minion"));
		userList.add(new User("JudyChoo", "1234", "child", "judychoo@gmail.com", "melissa"));
	}
	
	//register for new user.
	public void add(String username, String password, String userType, String email, String profile){
		userList.add(new User(username, password, userType, email, profile));
	}
	
	//Test the username and password put in by user. if can login, return userType; if cannot login, return null.
	public String login(String testedUsername, String testedPassword){
		for(User user: userList){
			if(user.getUsername().equals(testedUsername) && user.getPassword().equals(testedPassword)){
				return user.getUserType();
			}
		}
		return null;
	}
	
	//retrieve the User object for a specific username
	public User retrieveUser(String username){
		for(User user: userList){
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		return null;
	}
	
}
