package com.revature.models;

public class Employee extends User{

	Integer managerId;
	
	public Employee() {
		super();
		
	}

	public Employee(int id, String userName, String password, Integer managerId, boolean isLoggedIn) {
		super(id, userName, password, isLoggedIn);
		this.managerId = managerId;
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", password=" + password + ", isLoggedIn=" + isLoggedIn
				+ ", managerId=" + managerId + "]";
	}

	
	
}
