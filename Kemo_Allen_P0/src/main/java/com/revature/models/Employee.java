package com.revature.models;

public class Employee extends User{

	public Employee() {
		super();
		
	}

	public Employee(int id, String userName, String password, boolean isLoggedIn) {
		super(id, userName, password, isLoggedIn);
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", password=" + password + ", isLoggedIn=" + isLoggedIn
				+ "]";
	}
	
}
