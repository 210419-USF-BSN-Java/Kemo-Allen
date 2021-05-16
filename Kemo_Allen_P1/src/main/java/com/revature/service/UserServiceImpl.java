package com.revature.service;

import java.util.List;

import com.revature.models.User;
import com.revature.repository.UserDAO;

public class UserServiceImpl implements UserService{
	
	private UserDAO ud;

	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserDAO ud) {
		this.ud = ud;
	}

	@Override
	public User getUserById(int id) {
		return ud.selectUserById(id);
	}

	@Override
	public User getUserByUserName(String uName) {
		return ud.selectUserByUserName(uName);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> uList = ud.selectAllUsers();
		
		return uList;
	}

	@Override
	public List<User> getAllEmployees() {
		List<User> empList = ud.selectAllEmployees();
		return empList;
	}

	@Override
	public List<User> getAllManagers() {
		List<User> manaList = ud.selectAllManagers();
		return manaList;
	}

	@Override
	public boolean addUser(User user) {
		return ud.insertUser(user);
	}

	@Override
	public boolean changeUserInfo(User user) {
		return ud.updateUserInfo(user);
	}

	@Override
	public boolean removeUser(int id) {
		return ud.deleteUser(id);
	}
}
