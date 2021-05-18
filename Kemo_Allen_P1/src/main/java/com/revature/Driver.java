package com.revature;
import java.sql.Connection;

import com.revature.util.ERSConnection;

public class Driver {

	public static void main(String[] args) {
		Connection conn = ERSConnection.getConnection();

		System.out.println("hello");
		
	}

}
