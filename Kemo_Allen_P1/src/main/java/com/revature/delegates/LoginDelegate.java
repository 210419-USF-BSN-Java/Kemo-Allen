package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;

public class LoginDelegate implements Delegateable{
	
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User tUser = new User(0, "Tester", "123", "Test", "Best", "test@rev.com", 1);
		PrintWriter pw = response.getWriter();
		
		switch(request.getMethod()) {
		case "GET":
			
			pw.write(om.writeValueAsString(tUser));
			
			break;
		case "POST":
			String userName = request.getParameter("username");
			String password = request.getParameter("password");				
			
			String htmlRespone = "<html>";
			htmlRespone += "<h2>Your username is: " + userName + "</h2>";
			htmlRespone += "</html>";
			 
			pw.println(htmlRespone);
			
//			response.setStatus(201);
//			response.sendRedirect("login");
			break;
		default:
			response.sendError(400, "Request not supported.");
			break;
		}
		
	}

	
}
