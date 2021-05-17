package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public RequestHelper() {
		super();
		
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		StringBuilder uriBuilder = new StringBuilder(request.getRequestURI());
		
		//Replace domain with ""
		uriBuilder.replace(0, request.getContextPath().length() + 1, "");
		
		if(uriBuilder.indexOf("/") != -1) {
			request.setAttribute("path", uriBuilder.substring(uriBuilder.indexOf("/") + 1));
			//places subdirectory in an attribute called path
			
			uriBuilder.replace(uriBuilder.indexOf("/"), uriBuilder.length(), "");
			
		}
		
		switch(uriBuilder.toString()) {
		case "login":
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
	
}
