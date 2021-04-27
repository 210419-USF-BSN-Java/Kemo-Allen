package com.revature.presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.service.ShopService;

public class ShopFront {
	
	private final Logger LOG = Logger.getLogger(ShopFront.class);
	private ShopService service;
	private Scanner scan = new Scanner(System.in);
	
	public ShopFront() {
		
	}
	
	public ShopFront(ShopService service) {
		super();
		this.service = service;
	}
	
	public boolean displayMainMenu() {
		boolean cont = true;
		String choice = "";
		Customer customer = null;
		Employee employee = null;
		Manager manager = null;
		
		System.out.println("\tWelcome to the Main Menu! What would you like to do?\n");
		viewMainMenu();
		
		switch(choice) {
		case "0": viewMainMenu();
			break;
		case "1": cont = false;
			break;
		case "2": addNewCustomer();
			break;
		case "3": customer = customerLogin();
			break;
		case "4": employee = employeeLogin();
			break;
		case "5": manager = managerLogin();
			break;
		default: System.out.println("Sorry that was an invalid input.");
			break;
		
		}
		
		return cont;
	}
	
	public void viewMainMenu() {
		System.out.println("\t View Menu (0)");
		System.out.println("\t Exit Menu (1)");
		System.out.println("\t New Customer Sign-up (2)");
		System.out.println("\t Customer Login (3)");
		System.out.println("\t Employee Login (4)");
		System.out.println("\t Manager Login (5)");
		
		
	}
	
	public void addNewCustomer() {
		
	}
	
	public Customer customerLogin() {
		Customer customer = null;
		
		return customer;
	}
	
	public Employee employeeLogin() {
		Employee employee = null;
		
		return employee;
	}
	
	public Manager managerLogin() {
		Manager manager = null;
		
		return manager;
	}
	
	public void displayCustomerMenu(Customer customer) {
		boolean cont = true;
		String choice = "";
		
		System.out.println("\tHello " + customer.getUserName() + "! What would you like to do? \n");
		viewCustomerMenu();
		
		choice = scan.nextLine();
		
		do {
			switch(choice) {
			case "0": viewCustomerMenu();
				break;
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			default: System.out.println("Sorry that was an invalid input.");
				break;
			}
			
		}while(cont);
		
	}
	
	public void viewCustomerMenu() {
		System.out.println("\t View Menu (0)");
		System.out.println("\t Logout (1)");
		System.out.println("\t View My Inventory (2)");
		System.out.println("\t View Shop Items (3)");
		System.out.println("\t Make an Offer for an Item (4)");
		System.out.println("\t View Remaining Payments (5)");
		System.out.println("\t Make a Payment (6)");
		
	}
	
	public void viewMyInventory() {
		
	}
	
	public void viewShopItems() {
		
	}
	
	public void displayEmployeeMenu(Employee employee) {
		boolean cont = true;
		String choice = "";
		
		System.out.println("\tHello " + employee.getUserName() + "! What would you like to do? \n");
		viewEmployeeMenu();
		
		choice = scan.nextLine();
		
		do {
			switch(choice) {
			
			case "0": viewEmployeeMenu();
				break;
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			default: System.out.println("Sorry that was an invalid input.");
				break;
			}
			
		}while(cont);

	}
	
	public void viewEmployeeMenu() {
		System.out.println("\t View Menu (0)");
		System.out.println("\t Logout (1)");
		System.out.println("\t View Shop Items (2)");
		System.out.println("\t Add New Items to Shop (3)");
		System.out.println("\t Edit Existing Items (4)");
		System.out.println("\t Remove Items from Shop (5)");
		System.out.println("\t View a List of Customers (6)");
		System.out.println("\t Manage Customer Offers (7)");
		System.out.println("\t View a List of Payments (8)");
		
	}
	
	public void displayManagerMenu(Manager manager) {
		boolean cont = true;
		String choice = "";
		
		System.out.println("\tHello " + manager.getUserName() + "! What would you like to do? \n");
		viewMangerMenu();
		
		choice = scan.nextLine();
		
		do {
			switch(choice) {
			case "0": viewMangerMenu();
				break;
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			default: System.out.println("Sorry that was an invalid input.");
				break;
			}
			
		}while(cont);

	}
	
	public void viewMangerMenu() {
		System.out.println("\t View Menu (0)");
		System.out.println("\t Logout (1)");
		System.out.println("\t View a List of Employees (2)");
		System.out.println("\t Hire New Employee(s) (3)");
		System.out.println("\t Fire Existing Employee(s) (4)");
		System.out.println("\t View all Offer History (5)");
		
	}
	
	

}
