package com.revature.models;

public class Manager extends User{

	public Manager() {
		super();
		
	}

	public Manager(int id, String userName, String password, boolean isLoggedIn) {
		super(id, userName, password, isLoggedIn);
		
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", userName=" + userName + ", password=" + password + ", isLoggedIn=" + isLoggedIn
				+ "]";
	}

}
