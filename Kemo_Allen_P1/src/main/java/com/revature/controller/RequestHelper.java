package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.LoginDelegate;

public class RequestHelper {

	public RequestHelper() {
		super();
		
	}
	//Delegates
	LoginDelegate ld = new LoginDelegate();

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		StringBuilder uriBuilder = new StringBuilder(request.getRequestURI());
		System.out.println(uriBuilder);
		
		//Replace domain with ""
		uriBuilder.replace(0, request.getContextPath().length() + 1, "");
		System.out.println(uriBuilder);
		
		if(uriBuilder.indexOf("/") != -1) {
			request.setAttribute("path", uriBuilder.substring(uriBuilder.indexOf("/") + 1));
			//places subdirectory in an attribute called path
			System.out.println(uriBuilder);
			
			uriBuilder.replace(uriBuilder.indexOf("/"), uriBuilder.length(), "");
			System.out.println(uriBuilder);
			
		}
		
		switch(uriBuilder.toString()) {
		case "login":
				ld.process(request, response);
			break;
			
		case "employee":
			break;
		
		case "manager":
			break;
		
		default:
			response.sendError(404, "Path not supported.");
			break;
		
		}
	}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		switch(request.getRequestURI()) {
		case "/FrontController/login":
			
			break;
		default:
			
			break;
		}
			return null;
		}
}
	
