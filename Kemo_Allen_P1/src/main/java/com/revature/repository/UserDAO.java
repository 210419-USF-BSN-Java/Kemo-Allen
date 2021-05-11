package com.revature.repository;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {

	User selectUser();
	List<User> selectAllUsers();
	
	boolean insertUser();
	
	boolean updateUser();
	
	boolean deleteUser();
}
