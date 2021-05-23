package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repository.ReimbDAOImpl;
import com.revature.repository.ReimbursementDAO;
import com.revature.repository.UserDAO;
import com.revature.repository.UserDAOImpl;
import com.revature.service.ReimbServiceImpl;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class EmployeeDelegate implements Delegateable{
	private ObjectMapper om = new ObjectMapper();
	private UserDAO userDao;
	private UserService userService;
	private ReimbursementDAO reimbDao;
	private ReimbursementService reimbService;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//DAOs and Services
		userDao = new UserDAOImpl();
		userService = new UserServiceImpl(userDao);
		reimbDao = new ReimbDAOImpl();
		reimbService = new ReimbServiceImpl(reimbDao);
		
		PrintWriter pw = response.getWriter();
		
		String path = (String) request.getAttribute("path");
		
		//Add time datatype to Jackson
		om.registerModule(new JavaTimeModule());
		
		//Get the user id from the session
		HttpSession session = request.getSession();
		Integer id = tryParseInt((String)(session.getAttribute("id")));
		
		System.out.println(request.getMethod());
		
		switch(request.getMethod()) {
		case "GET":
			switch(path) {
			case "profile":
				User employee = userService.getUserById(id);
				response.getWriter().write(om.writeValueAsString(employee));
				//pw.write(om.writeValueAsString(obj));
				break;
			case "viewPending":	
				List<Reimbursement> pendingList = reimbService.getReimbursementsByAuthorAndStatus(id, 0);
				response.getWriter().write(om.writeValueAsString(pendingList));
				break;
			case "viewResolved":
				List<Reimbursement> resolvedList = reimbService.getReimbursementsByAuthorAndStatus(id, 1);
				response.getWriter().write(om.writeValueAsString(resolvedList));
				break;
			default:
				break;
			}
			break;
		case "POST":
			switch(path) {
			case "submitForm":
				String type = request.getParameter("type");
				Integer reimbType = tryParseInt(type);
				
				String amount = request.getParameter("amount");
				Double reimbAmount = tryParseDouble(amount);
				
				String reimbDesc = request.getParameter("desc");
				
				LocalDateTime timeSummited = LocalDateTime.now();
				
				Reimbursement reimb = new Reimbursement(0, id, null, 0, reimbAmount, null, timeSummited, null, reimbType, reimbDesc);
				
				System.out.println(reimbAmount);
				
				if(reimb != null) {
					reimbService.addReimbursement(reimb);
				}
				
				response.sendRedirect("/static/employee.html");
				
				break;
			case "updateProfile":
				User user = userService.getUserById(id);
				String fName = request.getParameter("firstName");
				String lName = request.getParameter("lastName");
				
				System.out.println(fName + lName);
				System.out.println("In method");
				response.sendRedirect("/static/employee.html");
				break; 
			}
		case "PUT":
			switch(path) { //DO as post
//			case "updateProfile":
//				User user = userService.getUserById(id);
//				String fName = request.getParameter("firstName");
//				String lName = request.getParameter("lastName");
//				
//				System.out.println(fName + lName);
//				System.out.println("In method");
//				break;
			}
			break;
		default:
			break;
		
		}
		
	}
	
	public Integer getIdFromCookies(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		
		for(Cookie c: cookies) {
			
		}
		
		return 0;
	}
	
	public Integer tryParseInt(String input) {
		Integer num;
		
		try {
			num = Integer.parseInt(input);
		}catch(NumberFormatException e){
			num = 0;
		}
		
		return num;
	}
	
	public Double tryParseDouble(String input) {
		Double num;
		
		try {
			num = Double.parseDouble(input);
		}catch(NumberFormatException e){
			num = 0.0;
		}
		
		return num;
	}

}
