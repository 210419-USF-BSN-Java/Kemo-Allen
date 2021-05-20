package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
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
		userDao = new UserDAOImpl();
		userService = new UserServiceImpl(userDao);
		reimbDao = new ReimbDAOImpl();
		reimbService = new ReimbServiceImpl(reimbDao);
		
		PrintWriter pw = response.getWriter();
		
		String path = (String) request.getAttribute("path");
		System.out.println(path);
		
		switch(request.getMethod()) {
		case "GET":
			switch(path) {
			case "profile":
				Object obj = request.getSession().getAttribute("employee");
				//response.sendRedirect("profile.html");
				response.getWriter().write(om.writeValueAsString(obj));
				//pw.write(om.writeValueAsString(obj));
				break;
			case "viewPending":
				List<Reimbursement> reimbList = reimbService.getAllReimbursements();
				response.getWriter().write(om.writeValueAsString(reimbList));
				break;
			case "viewResolved":
				
				break;
			default:
				break;
			}
			break;
		case "POST":
			switch(path) {
			case "submitForm":
				
				break;
			}
			break;
		default:
			break;
		
		}
		
	}

}
