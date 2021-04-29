package com.revature.models;

public class User {
	protected int id;
	protected String userName;
	protected String password;
	protected boolean isLoggedIn;
	
	public User() {
		super();
		
	}

	public User(int id, String userName, String password, boolean isLoggedIn) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	public boolean logIn(String password) {
		if(password.compareTo(this.password) == 0) {
			isLoggedIn = true;
			return isLoggedIn;
		}
		else {
			return false;
		}
	}
	
	public void logOut() {
		isLoggedIn = false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", isLoggedIn=" + isLoggedIn
				+ "]";
	}
	
}
