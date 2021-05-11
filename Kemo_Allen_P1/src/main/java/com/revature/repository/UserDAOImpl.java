package com.revature.repository;

import org.apache.log4j.Logger;

import com.revature.util.ERSConnection;

public class UserDAOImpl {
	
	private final Logger LOG = Logger.getLogger(UserDAOImpl.class);
	private static ERSConnection conn = new ERSConnection();
	
	public UserDAOImpl() {
		super();
	}
	
}
