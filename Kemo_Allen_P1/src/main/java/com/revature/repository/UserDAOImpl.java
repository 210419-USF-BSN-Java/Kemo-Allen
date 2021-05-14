package com.revature.repository;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ERSConnection;

public class UserDAOImpl implements UserDAO{
	
	private final Logger LOG = Logger.getLogger(UserDAOImpl.class);
	//private static Connection conn = ERSConnection.getConnection();
	
	public UserDAOImpl() {
		super();
	}

	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUserByUserName(String uName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAllManagers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLoggedIn(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
