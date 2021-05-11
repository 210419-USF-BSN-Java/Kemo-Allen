package com.revature.service;

import com.revature.repository.UserDAO;

public class UserServiceImpl {
	
	private UserDAO ud;

	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserDAO ud) {
		this.ud = ud;
	}
}
