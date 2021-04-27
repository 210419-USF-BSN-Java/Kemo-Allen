package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ShopConnection {
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; //Might be different
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "abbyluna56";
	
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
