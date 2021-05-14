package com.revature.tests;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repository.ReimbDAOImpl;
import com.revature.repository.UserDAOImpl;
import com.revature.service.ReimbServiceImpl;
import com.revature.service.UserServiceImpl;

public class ERSTests {
	
	private static UserServiceImpl us;
	private static ReimbServiceImpl rs;
	private static User testEmp = new User(5, "tester", "123", "The", "Test", "the.test@rev.com", 1, false);
	private static User testMana = new User(4, "jsmith", "def", "John", "Smith", "john.smith@rev.com", 2, false);
	private static Reimbursement testReimb = new Reimbursement(4, 5, 0, 0, 500.00, null, null, 2, "Did catering.");
	
	@Mock
	private static UserDAOImpl ud;
	@Mock
	private static ReimbDAOImpl rd;
	
	@BeforeClass
	public static void setup() {
		ud = Mockito.mock(UserDAOImpl.class);
		rd = Mockito.mock(ReimbDAOImpl.class);
		us = new UserServiceImpl(ud);
		rs = new ReimbServiceImpl(rd);
		
		//User List
		List<User> userList = new LinkedList<>();
		User emp1 = new User(1, "kallen", "123", "Kemo", "Allen", "kemo.allen@rev.com", 1, false);
		User emp2 = new User(2, "squid", "321", "Sydney", "Martin", "sydney.martin@rev.com", 1, false);
		User mana1 = new User(3, "kth", "abc", "Kevin", "Hau", "kevin.hau@rev.com", 2, false);
		userList.add(emp1);
		userList.add(emp2);
		userList.add(mana1);
		
		//Reimbursement List
		List<Reimbursement> reimbList = new LinkedList<>();
		Reimbursement reimb1 = new Reimbursement(1, 1, 3, -1, 49.89, null, null, 2, "Food was bad.");
		Reimbursement reimb2 = new Reimbursement(2, 2, 3, 1, 549.32, null, null, 3, "Moving is expensive.");
		Reimbursement reimb3 = new Reimbursement(3, 1, 3, 1, 100.00, null, null, 1, "Company card didn't work on the first day.");
		reimbList.add(reimb1);
		reimbList.add(reimb2);
		reimbList.add(reimb3);
		
		//User
		//Select
		Mockito.when(ud.selectUserById(emp1.getId())).thenReturn(userList.stream().filter(x -> x.getId() == emp1.getId()).collect(CustomCollector.returnSingle()));
		Mockito.when(ud.selectUserByUserName(emp2.getUserName())).thenReturn(userList.stream().filter(x -> x.getUserName() == emp2.getUserName()).collect(CustomCollector.returnSingle()));
		Mockito.when(ud.selectAllUsers()).thenReturn(userList);
		//Employees: userRole = 1
		Mockito.when(ud.selectAllEmployees()).thenReturn(userList.stream().filter(x -> x.getUserRole() == 1).collect(Collectors.toList()));
		//Manager: userRole = 2
		Mockito.when(ud.selectAllManagers()).thenReturn(userList.stream().filter(x -> x.getUserRole() == 2).collect(Collectors.toList()));
		//Insert
		Mockito.when(ud.insertUser(testMana)).thenReturn(true);
		//Update
		Mockito.when(ud.updateUserInfo(testMana)).thenReturn(true);
		Mockito.when(ud.updateLoggedIn(testMana.getId())).thenReturn(true);
		//Delete
		Mockito.when(ud.deleteUser(testEmp.getId())).thenReturn(true);
		
		//Reimbursement
		//Select
		Mockito.when(rd.selectReimbursementById(reimb1.getId())).thenReturn(reimbList.stream().filter(x -> x.getId() == reimb1.getId()).collect(CustomCollector.returnSingle()));
		Mockito.when(rd.selectReimbursementsByAuthor(reimb1.getAuthorId())).thenReturn(reimbList.stream().filter(x -> x.getAuthorId() == reimb1.getAuthorId()).collect(Collectors.toList()));
		Mockito.when(rd.selectReimbursementsByResolver(reimb1.getResolverId())).thenReturn(reimbList.stream().filter(x -> x.getResolverId() == reimb1.getResolverId()).collect(Collectors.toList()));
		Mockito.when(rd.selectReimbursementsByStatus(reimb2.getReimbStatus())).thenReturn(reimbList.stream().filter(x -> x.getReimbStatus() == reimb2.getReimbStatus()).collect(Collectors.toList()));
		Mockito.when(rd.selectAllReimbursements()).thenReturn(reimbList);
		//Insert
		Mockito.when(rd.insertReimbursement(testReimb)).thenReturn(true);
		//Update
		Mockito.when(rd.updateReimbursement(testReimb)).thenReturn(true);
		//Delete
		Mockito.when(rd.deleteReimbursementById(testReimb.getId())).thenReturn(true);
	}
	
	
}


