package com.revature.presentation;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;
import com.revature.models.Item;
import com.revature.models.Manager;
import com.revature.models.Offer;
import com.revature.models.OfferHistory;
import com.revature.models.Payment;
import com.revature.service.ShopService;

public class ShopFront {
	
	private final Logger LOG = Logger.getLogger(ShopFront.class);
	private ShopService service;
	private Scanner scan;
	
	public ShopFront() {
		
	}
	
	public ShopFront(ShopService service) {
		super();
		this.service = service;
	}
	
	public boolean displayMainMenu() {
		scan = new Scanner(System.in);
		boolean cont = true;
		String choice = "";
		Customer customer = null;
		Employee employee = null;
		Manager manager = null;
		
		System.out.println("\tThis is the Main Menu! What would you like to do?\n");
		viewMainMenu();
		choice = scan.nextLine();
		
		switch(choice) {
		case "0": viewMainMenu();
			break;
		case "1": cont = false;
			break;
		case "2": addNewCustomer();
			break;
		case "3": customer = customerLogin();
				if(customer != null) {
					displayCustomerMenu(customer);
				}
			break;
		case "4": employee = employeeLogin();
				if(employee != null) {
					displayEmployeeMenu(employee);
				}
			break;
		case "5": manager = managerLogin();
				if(manager != null) {
					displayManagerMenu(manager);
				}
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
		Customer cust;
		String userName, password;
		boolean success = false;
		
		System.out.println("Hello new customer!");
		System.out.println("Please enter a User Name!");
		userName = scan.nextLine();
		
		System.out.println("Please enter a Password!");
		password = scan.nextLine();
		
		cust = new Customer(0, userName, password, false);
		
		success = service.addCustomer(cust);
		
		if(success) {
			System.out.println("Your account has been added. Thank you for joining us!");
			LOG.info("New customer " + cust.getUserName() + " was added.");
		}
		else {
			System.out.println("Sorry we could not add your account. Maybe customer: " + userName + " already exists.");
		}
		
	}
	
	public Customer customerLogin() {
		Customer cust = null;
		String name, password;
		String nameLoop = "";
		String passLoop = "";
		boolean loginSuccess = false;
		
		do {
			System.out.println("Hello customer! What is your User Name?");
			name = scan.nextLine();
			
			cust = service.getCustomerByName(name);
			
			if(cust == null) {
				System.out.println("Sorry, it seems that you are not signed up with us.");
				System.out.println("Would you like to try again? (y/n)");
				nameLoop = scan.nextLine();
			}
			else {
				nameLoop = "n";
				do {
					System.out.println("Hello " + cust.getUserName() + "! What is your password?");
					password = scan.nextLine();
					loginSuccess = cust.logIn(password);
					
					if(loginSuccess) {
						service.updateCustomerLogin(cust);
						passLoop = "n";
						LOG.info("Customer " + cust.getUserName() + " has signed in.");
					}
					else {
						System.out.println("Passwords didn't match. Would you like to try again? (y/n)");
						passLoop = scan.nextLine();
					}
				}while(passLoop.compareTo("n") != 0);
			}
			
		}while(nameLoop.compareTo("n") != 0);
		
		
		if(cust.isLoggedIn()) {
			return cust;
		}
		else {
			return null;
		}
	}
	
	public Employee employeeLogin() {
		Employee emp = null;
		String name, password;
		String nameLoop = "";
		String passLoop = "";
		boolean loginSuccess = false;
		
		do {
			System.out.println("Hello employee! What is your User Name?");
			name = scan.nextLine();
			
			emp = service.getEmployeeByName(name);
			
			if(emp == null) {
				System.out.println("Sorry, it seems that you are not signed up with us.");
				System.out.println("Would you like to try again? (y/n)");
				nameLoop = scan.nextLine();
			}
			else {
				nameLoop = "n";
				do {
					System.out.println("Hello " + emp.getUserName() + "! What is your password?");
					password = scan.nextLine();
					loginSuccess = emp.logIn(password);
					
					if(loginSuccess) {
						service.updateEmployeeLogin(emp);
						passLoop = "n";
						LOG.info("Employee " + emp.getUserName() + " has signed in.");
					}
					else {
						System.out.println("Passwords didn't match. Would you like to try again? (y/n)");
						passLoop = scan.nextLine();
					}
				}while(passLoop.compareTo("n") != 0);
			}
			
		}while(nameLoop.compareTo("n") != 0);
		
		
		if(emp.isLoggedIn()) {
			return emp;
		}
		else {
			return null;
		}
	}
	
	public Manager managerLogin() {
		Manager mana = null;
		String name, password;
		String nameLoop = "";
		String passLoop = "";
		boolean loginSuccess = false;
		
		do {
			System.out.println("Hello manager! What is your User Name?");
			name = scan.nextLine();
			
			mana = service.getManagerByName(name);
			
			if(mana == null) {
				System.out.println("Sorry, it seems that you are not signed up with us.");
				System.out.println("Would you like to try again? (y/n)");
				nameLoop = scan.nextLine();
			}
			else {
				nameLoop = "n";
				do {
					System.out.println("Hello " + mana.getUserName() + "! What is your password?");
					password = scan.nextLine();
					loginSuccess = mana.logIn(password);
					
					if(loginSuccess) {
						service.updateManagerLogin(mana);
						passLoop = "n";
						LOG.info("Manager " + mana.getUserName() + " has signed in.");
					}
					else {
						System.out.println("Passwords didn't match. Would you like to try again? (y/n)");
						passLoop = scan.nextLine();
					}
				}while(passLoop.compareTo("n") != 0);
			}
			
		}while(nameLoop.compareTo("n") != 0);
		
		
		if(mana.isLoggedIn()) {
			return mana;
		}
		else {
			return null;
		}
	}
	
	public void displayCustomerMenu(Customer customer) {
		boolean cont = true;
		String choice = "";
		
		do {
			System.out.println("\tHello " + customer.getUserName() + "! What would you like to do? (Enter 0 to see menu)\n");
			viewCustomerMenu();
			choice = scan.nextLine();
			
			switch(choice) {
			case "0": viewCustomerMenu();
				break;
			case "1": logoutCustomer(customer);
						cont = false;
				break;
			case "2": viewMyInventory(customer);  
				break;
			case "3": viewShop(customer);
				break;
			case "4": viewRemainingPayments(customer);
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
		System.out.println("\t View Remaining Payments (4)");
		
	}
	
	public void logoutCustomer(Customer cust) {
		boolean loggedOut = false;
		cust.logOut();
		loggedOut = service.updateCustomerLogin(cust);
		
		if(loggedOut) {
			System.out.println("You have been successfully logged out. Have a good day!");
			LOG.info("Customer " + cust.getUserName() + " has logged out.");
		}
		else {
			System.out.println("There was an issue when trying to log you out. Returning to Main Menu.");
		}
		
	}
	
	public void viewMyInventory(Customer cust) {
		List<Inventory> invList = service.getCustomerInventory(cust.getId());
		
		if(!invList.isEmpty()) {
			System.out.println("Here is a list of items in your inventory:");
			for(Inventory i: invList) {
				System.out.println(i);
			}
		}
		else {
			System.out.println("Sorry. We could not find any items in your inventory.");
		}
		
	}
	
	public void viewShop(Customer cust) {
		List<Item> itemList = service.getCustItems();
		String choice = "n";
		
		if(!itemList.isEmpty()) {
			System.out.println("Here is a list of available items in the shop:");
			for(Item i: itemList) {
				System.out.println("\t" + i);
			}
			
			System.out.println("\nWould you like to make an offer? (y/n)");
			choice = scan.nextLine();
			if(choice.compareTo("y") == 0) {
				makeItemOffer(cust, itemList);
			}
			
		}
		else {
			System.out.println("Sorry. The shop is empty at the moment.");
		}
		
	}
	
	public void makeItemOffer(Customer cust, List<Item> itemList) {
		int itemId;
		Offer offer = null;
		String input = "y";
		List<Offer> custOffers;
		boolean uniqueOffer = true;
		
		do {
		custOffers = service.getOffersByCustomerId(cust.getId());
			
		System.out.println("Which item would you like to make an offer for? (Item id)");
		
		itemId = service.validInteger(scan);
		
		if(itemId != 0) {
			//Look for requested item
			for(Item i: itemList) {
				if(i.getItemId() == itemId) {
					offer = service.constructOffer(cust, i);
					break;
				}
			}
			
			for(Offer o: custOffers) {
				if(o.getCustomerId() == offer.getCustomerId() && o.getItemId() == offer.getItemId()) {
					uniqueOffer = false;
					break;
				}
			}
			
			if(offer != null && uniqueOffer) {
				service.addOffer(offer);
				LOG.info("An offer for item " + offer.getItemId() + " was made by user by id " + offer.getCustomerId());
			}
			else {
				System.out.println("An offer for item " + itemId + " could not be made.");
			}
			
		}
		else {
			System.out.println("The item id entered was invalid.");
		}
		
		System.out.println("Would you like to make another offer? (y/n)");
		input = scan.nextLine();
		
		}while(input.compareTo("y") == 0);
		
	}
	
	public void viewRemainingPayments(Customer cust) {
		List<Payment> payList = service.getPaymentsByCustomerId(cust.getId());
		String choice = "";
		
		if(!payList.isEmpty()) {
			System.out.println("Here are your current payments:");
			for(Payment p: payList) {
				System.out.println("\t" + p);
			}
			
			System.out.println("Would you like to make a payment? (y/n)");
			choice = scan.nextLine();
			if(choice.compareTo("y") == 0) {
				makePayment(cust, payList);
			}
		}
		else {
			System.out.println("You don't currently have any payments.");
		}
		
	}
	
	public void makePayment(Customer cust, List<Payment> payList) {
		Payment pay = null;
		int payId, numPayments;
		boolean foundPayment;
		String input;
		
		do {
			System.out.println("Which payment would you like to make? (Payment id)");
			payId = service.validInteger(scan);	
					
			if(payId != 0) {
				foundPayment = false;
				
				for(Payment p: payList) {
					if(payId == p.getPaymentId()) {
						foundPayment = true;
						pay = p;
						break;
					}
				}
				
				if(foundPayment) {
					System.out.println(pay);
					System.out.println("How many payments would you like to make on payment " + pay.getPaymentId() + "?");
					numPayments = service.validPayInput(scan, pay);
					
					if(numPayments > 0) {
						System.out.println("You made " + numPayments + " on payment " + pay.getPaymentId() + ".");
						pay.makePayment(numPayments);
						service.updateRemainingPayments(pay);
						LOG.info("Customer " + cust.getId() + " made a payment.");
						//Update the customer payments
						payList = service.getPaymentsByCustomerId(cust.getId());
						//TODO functionality to empty payments with 0 payments
						
					}
					else{
						System.out.println("That was either an invalid number of payments or it was too great");
					}
					
				}else {
					System.out.println("Payment " + payId + " could not be found for you.");
				}
				
			}
			else {
				System.out.println("That was an invalid payment id.");
			}
			
			System.out.println("Would you like to make another payment? (y/n)");
			input = scan.nextLine();
			
		}while(input.compareToIgnoreCase("y") == 0);
	}
	
	public void displayEmployeeMenu(Employee employee) {
		boolean cont = true;
		String choice = "";
		
		do {
			System.out.println("\tHello " + employee.getUserName() + "! What would you like to do? (Enter 0 to see menu) \n");
			viewEmployeeMenu();
			
			choice = scan.nextLine();
			
			switch(choice) {
			
			case "0": viewEmployeeMenu();
				break;
			case "1": logOutEmployee(employee);
						cont = false;
				break;
			case "2": viewShopItems();
				break;
			case "3": addNewItemsToShop(employee);
				break;
			case "4": editExistingItems(employee);
				break;
			case "5": removeItemsFromShop(employee);
				break;
			case "6": viewListOfCustomers();
				break;
			case "7": manageCustomerOffers();
				break;
			case "8": viewListOfPayments();
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
		System.out.println("\t Edit existing items (4)");
		System.out.println("\t Remove Items from Shop (5)");
		System.out.println("\t View a List of Customers (6)");
		System.out.println("\t Manage Customer Offers (7)");
		System.out.println("\t View a List of Payments (8)");
		
	}
	
	public void logOutEmployee(Employee emp) {
		boolean loggedOut = false;
		emp.logOut();
		loggedOut = service.updateEmployeeLogin(emp);
		
		if(loggedOut) {
			System.out.println("You have been successfully logged out. Have a good day!");
			LOG.info("Employee " + emp.getUserName() + " has logged out.");
		}
		else {
			System.out.println("There was an issue when trying to log you out. Returning to Main Menu.");
		}
	}
	
	public void viewShopItems() {
		List<Item> itemList = service.getAllItems();
		
		if(!itemList.isEmpty()) {
			System.out.println("Here is a list of the items in the shop:");
			for(Item i: itemList) {
				System.out.println("\t" + i);
			}
			System.out.println();
			
		}
		else {
			System.out.println("The shop is empty at the moment.");
		}
	}
	
	public void addNewItemsToShop(Employee emp) {
		Item item;
		String itemName, desc;
		double price;
		boolean success;
		String cont = "n";
		
		do {
			System.out.println("Enter the name of the new item: ");
			itemName = scan.nextLine();
			
			System.out.println("Enter a desciption for the item: ");
			desc = scan.nextLine();
			
			System.out.println("Enter the price for the item (a negative number will be default to 0): ");
			price = service.validDouble(scan);
			
			if(price < 0) {
				price = 0;
			}
			
			item = new Item(0, itemName, desc, price, false);
			
			success = service.addItem(item);
			
			if(success) {
				System.out.println("The item " + item.getName() + " has been added successfully!");
				LOG.info(emp.getUserName() + " added a new item: " + item.getName() + " to the database.");
			}
			else {
				System.out.println("");
			}
			
			System.out.println("Would you like to add another item? (y/n)");
			cont = scan.nextLine();
			
		}while(cont.compareTo("y") == 0);
		
	}
	
	public void editExistingItems(Employee emp) {
		Item item;
		String choice = "n";
		String desc;
		double price;
		int itemId;
		List<Item> itemList;
		
		do {
			//update for loop
			item = null;
			itemList = service.getAllItems();
			if(!itemList.isEmpty()) {
				System.out.println("Which item would you like to modify? (Item id)");
				itemId = service.validInteger(scan);
				
				if(itemId > 0) {
					for(Item i: itemList) {
						if(i.getItemId() == itemId) {
							item = i;
							break;
						}
					}
					
					if(item != null) {
						System.out.println(item);
						System.out.println("Enter the new description (a blank line will result in no change): ");
						desc = scan.nextLine();
						if(desc.trim().compareTo("") != 0) {
							item.setDescription(desc);
							service.updateItemDescription(item);
						}
						
						System.out.println("Enter the new price (a blank line will result in no change): ");
						price = service.validDouble(scan);
						if(price > 0) {
							item.setPrice(price);
							service.updateItemPrice(item);
						}
						
						//Condition for no changes?
						LOG.info(emp.getUserName() + " made an update to item by id " + item.getItemId()+ ".");
					}
					else {
						System.out.println("Could not find item by id " + itemId + ".");
					}
					
				}
				else {
					System.out.println("That was an invalid item id.");
				}
				
				System.out.println("Would you like to modify another item?");
				choice = scan.nextLine();
			}
			else {
				System.out.println("There are no items in the shop.");
				break;
			}
		}while(choice.compareToIgnoreCase("y") == 0);
	}
	
	public void removeItemsFromShop(Employee emp) {
		Item item;
		String choice = "n";
		boolean success;
		int itemId;
		List<Item> itemList;
		
		do{
			//update for loop
			item = null;
			itemList = service.getAllItems();
			if(!itemList.isEmpty()) {
				System.out.println("Which item would you like to delete? (Item id)");
				itemId = service.validInteger(scan);
				
				if(itemId > 0) {
					for(Item i: itemList) {
						if(i.getItemId() == itemId) {
							item = i;
							break;
						}
					}
					
					if(item != null) {
						success = service.deleteItem(item.getItemId());
						
						if(success) {
							System.out.println("Item by id " + item.getItemId() + " was successfully deleted.");
							LOG.info(emp.getUserName() + " removed item by id " + item.getItemId() + " from the database.");
						}
						
					}
					else {
						System.out.println("Could not find item by id " + itemId + ".");
					}
					
				}
				else {
					System.out.println("That was an invalid item id.");
				}
				
				System.out.println("Would you like to delete another item?");
				choice = scan.nextLine();
			}
			else {
				System.out.println("There are no items in the shop.");
				break;
			}
		}while(choice.compareToIgnoreCase("y") == 0);
		
	}
	
	public void viewListOfCustomers() {
		List<Customer> custList = service.getAllCustomers();
		
		if(!custList.isEmpty()) {
			System.out.println("Here is a list of our customers: ");
			for(Customer c: custList) {
				System.out.println("\t" + c);
			}
		}
		else {
			System.out.println("No customers were foound.");
		}
		
	}
	
	public void manageCustomerOffers() {
		//TODO
	}
	
	public void viewListOfPayments() {
		List<Payment> payList = service.getAllPayments();
		
		if(!payList.isEmpty()) {
			//Add list for completed payments
			System.out.println("Here are the current payments: ");
			for(Payment p: payList) {
				System.out.println("\t" + p);
			}
		}
		
	}
	
	public void displayManagerMenu(Manager manager) {
		boolean cont = true;
		String choice = "";
		
		do {
			System.out.println("\tHello " + manager.getUserName() + "! What would you like to do? \n");
			viewMangerMenu();
			
			choice = scan.nextLine();
			
			switch(choice) {
			case "0": viewMangerMenu();
				break;
			case "1": logoutManager(manager);
					cont = false;
				break;
			case "2": viewListOfEmployees(manager);
				break;
			case "3": hireNewEmployee(manager);
				break;
			case "4": fireEmployee(manager);
				break;
			case "5": viewAllOfferHistory();
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
	
	public void logoutManager(Manager mana) {
		boolean loggedOut = false;
		mana.logOut();
		loggedOut = service.updateManagerLogin(mana);
		
		if(loggedOut) {
			System.out.println("You have been successfully logged out. Have a good day!");
			LOG.info("Manager " + mana.getUserName() + " has logged out.");
		}
		else {
			System.out.println("There was an issue when trying to log you out. Returning to Main Menu.");
		}
	}
	
	public void viewListOfEmployees(Manager mana) {
		List<Employee> empList = service.getEmployeesByManager(mana.getId());
		
		if(!empList.isEmpty()) {
			System.out.println("Here is a list of employees that you supervise: ");
			for(Employee e: empList) {
				System.out.println("/t" + e);
			}
		}
		
	}
	
	public void hireNewEmployee(Manager mana) {
		Employee emp;
		String userName, password;
		boolean success;
		
		System.out.println("What is the new Employee's user name?");
		userName = scan.nextLine();
		
		System.out.println("What is the new Employee's password?");
		password = scan.nextLine();
		
		emp = new Employee(0, userName, password, mana.getId(), false);
		
		success = service.addEmployee(emp);
		
		if(success) {
			System.out.println("New employee by username:" + emp.getUserName() + " has been added.");
			LOG.info("Manager " + mana.getUserName() + " hired new employee " + emp.getUserName());
		}
		else {
			System.out.println("Sorry we could not the new Employee. Maybe employee: " + emp.getUserName() + " already exists.");
		}
		
	}
	
	public void fireEmployee(Manager mana) {
		int empId;
		String choice;
		Employee emp = null;
		List<Employee> empList;
		boolean success;
		
		System.out.println("Which employee would you like to fire? (Employee id)");
		empId = service.validInteger(scan);
		
		do {
			empList = service.getEmployeesByManager(mana.getId());
			
			if(empId > 0) {
				for(Employee e: empList) {
					if(empId == e.getId()) {
						emp = e;
						break;
					}
				}
				
				if(emp != null) {
					success = service.deleteEmployee(emp.getId());
					
					if(success) {
						System.out.println("Employee by id " + emp.getId() + " was removed from the database.");
						LOG.info("Manager " + mana.getUserName() + " has fired employee " + emp.getUserName() + ".");
					}
				}
				else {
					System.out.println("Sorry we couldn't find that employee for you.");
				}
				
				
			}else {
				System.out.println("That was an ivalid employee id.");
			}
			
			System.out.println("Would you like to fire another employee?");
			choice = scan.nextLine();
		}while(choice.compareTo("y") == 0);
		
	}
	
	public void viewAllOfferHistory() {
		List<OfferHistory> oHList = service.getAllOfferHistories();
		
		if(!oHList.isEmpty()) {
			for(OfferHistory oH: oHList) {
				System.out.println("/t" + oH);
			}
		}
		else {
			System.out.println("The offer history is currently empty.");
		}
		
	}
	

}
