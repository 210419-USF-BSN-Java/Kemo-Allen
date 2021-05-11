package com.revature.repository;

import org.apache.log4j.Logger;

import com.revature.util.ERSConnection;

public class ReimDAOImpl {

	private final Logger LOG = Logger.getLogger(ReimDAOImpl.class);
	private static ERSConnection conn = new ERSConnection();
	
	public ReimDAOImpl() {
		super();
	}
}
