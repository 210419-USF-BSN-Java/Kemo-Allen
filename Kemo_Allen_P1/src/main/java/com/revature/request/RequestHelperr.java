package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.revature.controller.LoginController;

public class RequestHelperr {
	private RequestHelperr() {}
	
	public static LoginController lc = new LoginController();
	
	public static Object process(HttpServletRequest request) throws IOException, ServletException{
		switch(request.getRequestURI()) {
		case "/ERS/login":
			return lc.login(request);
		default:
			return "";
		
		}
		
	}
	
}
