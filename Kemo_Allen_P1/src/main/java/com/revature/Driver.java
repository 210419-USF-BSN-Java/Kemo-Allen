package com.revature;

import java.time.LocalDateTime;

import com.revature.models.Reimbursement;
import com.revature.repository.ReimbDAOImpl;
import com.revature.repository.ReimbursementDAO;
import com.revature.repository.UserDAO;
import com.revature.repository.UserDAOImpl;
import com.revature.service.ReimbServiceImpl;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class Driver {

	public static void main(String[] args) {
		UserDAO ud = new UserDAOImpl();
		ReimbursementDAO rd = new ReimbDAOImpl();
		UserService us = new UserServiceImpl(ud);
		ReimbursementService rs = new ReimbServiceImpl(rd);
		
		LocalDateTime ts = LocalDateTime.now();
		
		Reimbursement r = new Reimbursement(0, 1, null, 0, 10.11, null, ts, null, 1, "Testing 2");
		
		//rs.addReimbursement(r);
		
		System.out.println(rs.getAllReimbursements());
		System.out.println(us.getAllUsers());
		
	}

}
