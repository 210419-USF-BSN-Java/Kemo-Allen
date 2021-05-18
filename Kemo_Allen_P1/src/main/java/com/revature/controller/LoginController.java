package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.models.User;

public class LoginController {

	public Object login(HttpServletRequest request) throws IOException, ServletException{
	
		if(request.getMethod().equals("GET")) {
			return "login.html";
		}
		
		//Create object
		User tUser = new User(0, "Tester", "123", "Test", "Best", "test@rev.com", 1);

		//Check authentication
		
		//Save session id
		request.getSession().setAttribute("tUser", tUser);
		
		return tUser;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		request.getSession().invalidate(); 
		return "login.html";
	}
}
