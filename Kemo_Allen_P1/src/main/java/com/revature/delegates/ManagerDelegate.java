package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class ManagerDelegate implements Delegateable{
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
		System.out.println(path);
		
		switch(request.getMethod()) {
		case "GET":
			switch(path) {
			case "viewPending":
				List<Reimbursement> pendingList = reimbService.getReimbursementsByStatus(0);
				response.getWriter().write(om.writeValueAsString(pendingList));
				break;
			case "viewResolved":
				List<Reimbursement> resolvedList = reimbService.getResolvedReimbursements();
				response.getWriter().write(om.writeValueAsString(resolvedList));
				break;
			case "viewEmployees":
				List<User> empList = userService.getAllEmployees();
				response.getWriter().write(om.writeValueAsString(empList));
				break;
			case "viewEmployeeReimbursement":
				System.out.println("Inside");
				String query = request.getQueryString();
				System.out.println(query);
				
//				String id = request.getParameter("empId");
//				Integer empId = tryParseInt(id);
//				List<Reimbursement> employeeReimb = reimbService.getReimbursementsByAuthor(empId);
//				
//				if(employeeReimb.isEmpty()) {
//					response.getWriter().write(om.writeValueAsString(null));
//				}
//				else {
//					response.getWriter().write(om.writeValueAsString(employeeReimb));
//				}
				
				break;
			default:
				break;
			}
		
			break;
		case "POST":
			switch(path) { //Create View
			case "viewEmployeeReimbursement":
				String id = request.getParameter("empId");
				System.out.println(id);

				Integer empId = tryParseInt(id);
				List<Reimbursement> employeeReimb = reimbService.getReimbursementsByAuthor(empId);
				
				if(employeeReimb.isEmpty()) {
					response.getWriter().write(om.writeValueAsString(null));
				}
				else {
					response.getWriter().write(om.writeValueAsString(employeeReimb));
				}
				
				break;
			}
			break;
		default:
			break;
		}
		
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

}
