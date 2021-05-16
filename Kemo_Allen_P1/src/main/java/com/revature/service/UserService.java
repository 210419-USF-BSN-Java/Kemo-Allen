package com.revature.service;

import java.util.List;

import com.revature.models.User;

public interface UserService {

	User getUserById(int id);
	User getUserByUserName(String uName);
	List<User> getAllUsers();
	List<User> getAllEmployees();
	List<User> getAllManagers();
	
	boolean addUser(User user);
	
	boolean changeUserInfo(User user);
	
	boolean removeUser(int id);
	
	//Encrpyt password
	
}