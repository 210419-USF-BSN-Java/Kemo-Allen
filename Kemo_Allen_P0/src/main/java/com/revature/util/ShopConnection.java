package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ShopConnection {
	//Run -> Run Configurations -> Java Application -> <The Application> -> Environment 
	private static final String URL = System.getenv("jdbc_url"); 
	private static final String USERNAME = System.getenv("jdbc_username");
	private static final String PASSWORD = System.getenv("jdbc_password");
	
	private final static Logger LOG = Logger.getLogger(ShopConnection.class);

	private static Connection conn;
	
	public static Connection getConnection() {
		try { 
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue connecting to the data base.");
		}
		
		return conn;
	}
	
	

}
