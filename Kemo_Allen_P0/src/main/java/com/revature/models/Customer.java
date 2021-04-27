package com.revature.models;

public class Customer extends User{

	public Customer() {
		super();
	}

	public Customer(int id, String userName, String password, boolean isLoggedIn) {
		super(id, userName, password, isLoggedIn);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", password=" + password + ", isLoggedIn=" + isLoggedIn
				+ "]";
	}	
	
}
