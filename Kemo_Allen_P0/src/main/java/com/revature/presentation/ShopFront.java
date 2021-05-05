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
			System.out.println("Hello customer! What is your user name?");
			name = scan.nextLine().trim();
			
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
				}while(passLoop.compareTo("y") == 0);
			}
			
		}while(nameLoop.compareTo("y") == 0);
		
		
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
			System.out.println("Hello employee! What is your user name?");
			name = scan.nextLine().trim();
			
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
				}while(passLoop.compareTo("y") == 0);
			}
			
		}while(nameLoop.compareTo("y") == 0);
		
		
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
			System.out.println("Hello manager! What is your user name?");
			name = scan.nextLine().trim();
			
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
				}while(passLoop.compareTo("y") == 0);
			}
			
		}while(nameLoop.compareTo("y") == 0);
		
		
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
			case "5": makePayment(customer);
				break;
			case "6": viewMyOffers(customer);
				break;
			case "7": manageMyOffers(customer);
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
		System.out.println("\t Make Payment(s) (5)");
		System.out.println("\t View Offers (6)");
		System.out.println("\t Manage Offers (7)");
		
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
				System.out.println("\t" + i);
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
		Item offerItem;
		Offer offer;
		String paymentType;
		String loop, input;
		List<Offer> custOffers;
		boolean uniqueOffer;
		
		do {
			//reset default values
			offerItem = null;
			offer = null;
			paymentType = null;
			uniqueOffer = true;
			
			custOffers = service.getOffersByCustomerId(cust.getId());
				
			System.out.println("Which item would you like to make an offer for? (Item id)");
			
			input = scan.nextLine();
			itemId = service.validInteger(input);
			
			if(itemId != 0) {
				//Look for requested item
				for(Item i: itemList) {
					if(i.getItemId() == itemId) {
						offerItem = i;
						break;
					}
				}
				
				//Select payment type
				paymentType = selectPaymentType();
				
				//Create Offer
				offer = service.constructOffer(cust, offerItem, paymentType);
				
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
			loop = scan.nextLine();
		
		}while(loop.compareTo("y") == 0);
		
	}
	
	public String selectPaymentType() {
		String paymentType;
		
		System.out.println("Which payment type would you like? ");
		System.out.println("\t No payment plan, pay in full (0)");
		System.out.println("\t Type 1: Four payments (1)");
		System.out.println("\t Type 2: Six payments (2)");
		System.out.println("\t Type 3: Eight payments (3)");
		System.out.println("\t Type 4: Ten payments (4)");
		
		String input = scan.nextLine();
		
		switch(input) {
			
		case "1": paymentType = "1";
			break;
		case "2": paymentType = "2";
			break;
		case "3": paymentType = "3";
			break;
		case "4": paymentType = "4";
			break;
		default: paymentType = "0";
			break;
		
		}
		
		return paymentType;
	}
	
	public void viewRemainingPayments(Customer cust) {
		List<Payment> payList = service.getPaymentsByCustomerId(cust.getId());
		double amountRemaining, weeklyPayment;
		
		if(!payList.isEmpty()) {
			System.out.println("Here are your current payments:");
			for(Payment p: payList) {
				weeklyPayment = service.calculateWeeklyPayment(p);
				amountRemaining = service.calculateAmountRemaining(p, weeklyPayment);
				System.out.println("\tPayment: " + p.getPaymentId() + " has " + p.getPaymentsRemaining() +" payment(s) remaining."
						+ " Weekly payment is $" + weeklyPayment + ", with a remaining balance of $" + amountRemaining);
			}
			
		}
		else {
			System.out.println("You don't currently have any payments.");
		}
		
	}
	
	public void makePayment(Customer cust) {
		Payment pay;
		List<Payment> payList;
		int payId, numPayments;
		String loop, input;
		
		do {
			pay = null;
			payList = service.getPaymentsByCustomerId(cust.getId());
			
			System.out.println("Which payment would you like to make? (Payment id)");
			input = scan.nextLine();
			payId = service.validInteger(input);	
					
			if(payId != 0) {
				
				for(Payment p: payList) {
					if(payId == p.getPaymentId()) {
						pay = p;
						break;
					}
				}
				
				if(pay != null) {
					System.out.println(pay);
					System.out.println("How many payments would you like to make on payment " + pay.getPaymentId() + "?");
					input = scan.nextLine();
					numPayments = service.validPayInput(input, pay);
					
					if(numPayments > 0) {
						System.out.println("You made " + numPayments + " payments on payment " + pay.getPaymentId() + ".");
						pay.setPaymentsRemaining(pay.getPaymentsRemaining() - numPayments);
						service.updateRemainingPayments(pay);
						LOG.info("Customer " + cust.getId() + " made a payment.");
						//Update the customer payments
						payList = service.getPaymentsByCustomerId(cust.getId());
						//TODO functionality to empty payments with 0 payments
						
					}
					else{
						System.out.println("That was an invalid number of payments.");
					}
					
				}else {
					System.out.println("Payment " + payId + " could not be found for you.");
				}
				
			}
			else {
				System.out.println("That was an invalid payment id.");
			}
			
			System.out.println("Would you like to make another payment? (y/n)");
			loop = scan.nextLine();
			
		}while(loop.compareToIgnoreCase("y") == 0);
	}
	
	public void viewMyOffers(Customer cust) {
		List<Offer> myOffers = service.getOffersByCustomerId(cust.getId());
		
		if(!myOffers.isEmpty()) {
			System.out.println("Here is a list of your current offers:");
			for(Offer o: myOffers) {
				System.out.println("\t" + o);
			}
		}
		else {
			System.out.println("You don't currently have any pending offers.");
		}
		
	}
	
	public void manageMyOffers(Customer cust) {
		String loop, input;
		List<Offer> myOffers ;
		Offer offer;
		int offerId;
		boolean success;
		
		do {
			myOffers = service.getOffersByCustomerId(cust.getId());
			offer = null;
			
			System.out.println("Which offer would you like to retract? (Offer id)");
			input = scan.nextLine();
			offerId = service.validInteger(input);
			
			if(offerId > 0) {
				for(Offer o: myOffers) {
					if(o.getItemId() == offerId) {
						offer = o;
						break;
					}
				}
				
				if(offer != null) {
					success = service.deleteCustomerOffer(offer.getCustomerId(), offer.getItemId());
					if(success) {
						System.out.println("Offer by id " + offer.getOfferId() +" was successfully deleted.");
						LOG.info("Customer by id " + cust.getId() + " removed their offer by id " + offer.getOfferId() + ".");
					}
					
				}
				else {
					System.out.println("Sorry that offer is not in our system.");
				}
				
			}
			else {
				System.out.println("That was an invalid offer id.");
			}
			
			System.out.println("Would you like to retract another offer? (y/n)");
			loop = scan.nextLine();
			
		}while(loop.compareTo("y") == 0);
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
			case "7": viewListOfOffers();
				break;
			case "8": manageCustomerOffers(employee);
				break;
			case "9": viewListOfPayments();
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
		System.out.println("\t View Customer Offers (7)");
		System.out.println("\t Manage Customer Offers (8)");
		System.out.println("\t View a List of Payments (9)");
		
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
		List<Item> itemList;
		String itemName, desc;
		double price;
		boolean success, isNewItem;
		String loop, input;
		
		do {
			isNewItem = true;
			itemList = service.getAllItems();
			
			System.out.println("Enter the name of the new item: ");
			itemName = scan.nextLine();
			
			for(Item i: itemList) {
				if(i.getName().compareTo(itemName) == 0) {
					System.out.println("Item " + itemName + " is already in the shop.");
					isNewItem = false;
					break;
				}
			}
			
			if(isNewItem) {
				System.out.println("Enter a desciption for the item: ");
				desc = scan.nextLine();
				
				System.out.println("Enter the price for the item (a negative number will be default to 0): ");
				input = scan.nextLine();
				price = service.validDouble(input);
				
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
			}
			
			System.out.println("Would you like to add another item? (y/n)");
			loop = scan.nextLine();
			
		}while(loop.compareTo("y") == 0);
		
	}
	
	public void editExistingItems(Employee emp) {
		Item item;
		String loop, input;
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
				input = scan.nextLine();
				itemId = service.validInteger(input);
				
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
						input = scan.nextLine();
						price = service.validDouble(input);
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
				loop = scan.nextLine();
			}
			else {
				System.out.println("There are no items in the shop.");
				break;
			}
		}while(loop.compareToIgnoreCase("y") == 0);
	}
	
	public void removeItemsFromShop(Employee emp) {
		Item item;
		String loop, input;
		boolean success;
		int itemId;
		List<Item> itemList;
		
		do{
			//update for loop
			item = null;
			itemList = service.getAllItems();
			
			if(!itemList.isEmpty()) {
				System.out.println("Which item would you like to delete? (Item id)");
				input = scan.nextLine();
				itemId = service.validInteger(input);
				
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
						
						//remove offers for item
						service.deleteItemOffers(item.getItemId());
						
					}
					else {
						System.out.println("Could not find item by id " + itemId + ".");
					}
					
				}
				else {
					System.out.println("That was an invalid item id.");
				}
				
				System.out.println("Would you like to delete another item?");
				loop = scan.nextLine();
			}
			else {
				System.out.println("There are no items in the shop.");
				break;
			}
		}while(loop.compareToIgnoreCase("y") == 0);
		
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
			System.out.println("No customers were found.");
		}
		
	}
	
	public void viewListOfOffers() {
		List<Offer> offerList = service.getAllOffers();
		
		if(!offerList.isEmpty()) {
			for(Offer o: offerList){
				System.out.println("\t" + o);
			}
			
		}
		else {
			System.out.println("Currently there are no unmanaged offers.");
		}
		
	}
	
	public void manageCustomerOffers(Employee emp) {
		String loop, input;
		int offerId;
		List<Offer> offerList, itemOfferList;
		List<OfferHistory> historyList;
		Offer offer;
		Item item;
		Inventory inv;
		Payment pay;
		
		do {
			offer = null;
			item = null;
			inv = null;
			pay = null;
			
			offerList = service.getAllOffers();
			System.out.println("Which offer would you like to accept? (Offer id)");
			input = scan.nextLine();
			offerId = service.validInteger(input);
			
			if(offerId > 0) {
				for(Offer o: offerList) {
					if(o.getOfferId() == offerId) {
						offer = o;
						break;
					}
				}			
				
				if(offer != null) {
					//Accept offer
					offer.setAccepted(true);
					service.updateOfferIsAccepted(offer);
					
					//Get item from db
					item = service.getItemById(offer.getItemId());
					item.setOwned(true);
					service.updateItemIsOwned(item);
					
					//Construct Payment from offer
					pay = service.constructPayment(offer);
					service.addPayment(pay);
					
					//Construct Inventory for offer customer
					inv = service.constructInventory(offer.getCustomerId(), item);
					service.addInventory(inv);
					
					//Make offer history of other offers for the same item
					itemOfferList = service.getOffersByItemId(offer.getItemId());
					//System.out.println(itemOfferList);
					historyList = service.constructOfferHistory(itemOfferList);
					//System.out.println(historyList);
					
					for(OfferHistory oH: historyList) {
						service.addOfferHistory(oH);
					}
					
					//Remove offers for the item from db
					service.deleteItemOffers(offer.getItemId());
					
					System.out.println("A new payment has been added for Customer by id " + offer.getCustomerId());
						
				}
				else {
					System.out.println("We could not find offer by id " + offerId + ".");
				}
				
			}
			else {
				System.out.println("That was an invalid offer id");
			}
			
			System.out.println("Would you like to accept another offer?");
			loop = scan.nextLine();
			
		}while(loop.compareToIgnoreCase("y") == 0);
		
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
		else {
			System.out.println("You are not currently supervising any employees.");
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
			System.out.println("New employee " + emp.getUserName() + " has been added.");
			LOG.info("Manager " + mana.getUserName() + " hired new employee " + emp.getUserName());
		}
		else {
			System.out.println("Sorry we could not the new Employee. Maybe employee: " + emp.getUserName() + " already exists.");
		}
		//TODO make sure manager id works
	}
	
	public void fireEmployee(Manager mana) {
		int empId;
		String loop, input;
		Employee emp = null;
		List<Employee> empList;
		boolean success;
		
		System.out.println("Which employee would you like to fire? (Employee id)");
		input = scan.nextLine();
		empId = service.validInteger(input);
		
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
			loop = scan.nextLine();
		}while(loop.compareTo("y") == 0);
		
	}
	
	public void viewAllOfferHistory() {
		List<OfferHistory> oHList = service.getAllOfferHistories();
		
		if(!oHList.isEmpty()) {
			for(OfferHistory oH: oHList) {
				System.out.println("\t" + oH);
			}
		}
		else {
			System.out.println("The offer history is currently empty.");
		}
		
	}

}
