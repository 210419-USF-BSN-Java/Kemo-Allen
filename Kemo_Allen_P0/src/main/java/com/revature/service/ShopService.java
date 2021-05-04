package com.revature.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;
import com.revature.models.Item;
import com.revature.models.Manager;
import com.revature.models.Offer;
import com.revature.models.OfferHistory;
import com.revature.models.Payment;
import com.revature.repository.ShopDAO;

public class ShopService {

	private ShopDAO sDao;
	
	public ShopService() {
		
	}
	
	public ShopService(ShopDAO sDao) {
		super();
		this.sDao = sDao;
	}
	
	public int validInteger(String input) {
		int value;
		
		try {
			value = Integer.parseInt(input);
			
		}catch(NumberFormatException e) {
			value = 0;
		}
		
		return value;
	}
	
	public double validDouble(String input) {
		double value;
		
		try {
			value = Double.parseDouble(input);
			
		}catch(NumberFormatException e) {
			value = 0;
		}
		
		return value;
	}
	
	public int validPayInput(String input, Payment pay) {
		int value = validInteger(input);
		
		if(value > 0) {
			if((pay.getPaymentsRemaining() - value) < 0) {
				value = 0;
			}
		}
		
		return value;
	}
	
	public Offer constructOffer(Customer cust, Item item, String paymentType) {
		return new Offer(0,cust.getId(), item.getItemId(), item.getPrice(), paymentType, false);
	 
	}
	
	public Payment constructPayment(Offer offer) {
		int payments;
		
		if(offer.getPaymentType() == null) {
			offer.setPaymentType("0");
		}
		
		switch(offer.getPaymentType()) {
		case "1": payments = 4;
			break;
		case "2": payments = 6;
			break;
		case "3": payments = 8;
			break;
		case "4": payments = 10;
			break;
		default: payments = 0;
			break;
		
		}
		
		return new Payment(0, offer.getCustomerId(), offer.getItemId(), offer.getItemPrice(), 0, payments, payments);
	}
	
	public Inventory constructInventory(int customerId, Item item) {
		return new Inventory(0, customerId, item.getName(), item.getDescription());
	}
	
	public List<OfferHistory> constructOfferHistory(List<Offer> offerList) {
		List<OfferHistory> oHList = new LinkedList<>();
		String status = "";
		
		if(!offerList.isEmpty()) {
			for(Offer o: offerList) {
				if(o.isAccepted()) {
					status = "accepted";
				}
				else {
					status = "rejected";
				}
				
				oHList.add(new OfferHistory(0, o.getCustomerId(), o.getItemId(), o.getPaymentType(), status));
			}
		}
		
		return oHList;
		
	}
	
	public boolean addCustomer(Customer cust) {
		List<Customer> custList = getAllCustomers();
		boolean isNew = true;
		
		//Check if a customer by the given userName exists in the DB before trying to add
		for(Customer c: custList) {
			if(cust.getUserName().compareTo(c.getUserName()) == 0) {
				isNew = false;
				break;
			}
		}
		
		if(isNew) {
			return sDao.insertCustomer(cust);
		}
		else {
			return false;
		}
	}
	
	public boolean addEmployee(Employee emp) {
		List<Employee> empList = getAllEmployees();
		boolean isNew = true;
		
		for(Employee e: empList) {
			if(emp.getUserName().compareTo(e.getUserName()) == 0) {
				isNew = false;
				break;
			}
		}
		
		if(isNew) {
			return sDao.insertEmployee(emp);
		}
		else {
			return false;
		}
	}
	
	public boolean addManager(Manager mana) {
		return sDao.insertManager(mana);
	}
	
	public boolean addItem(Item item) {
		List<Item> itemList = getAllItems();
		boolean isNew = true;
		
		for(Item i: itemList) {
			if(item.getName().compareTo(i.getName()) == 0) {
				isNew = false;
			}
		}
		
		if(isNew) {
			return sDao.insertItem(item);
		}
		else{
			return false;
		}
	}
	
	public boolean addInventory(Inventory inv) {
		return sDao.insertInventory(inv);
	}
	
	public boolean addOffer(Offer offer) {
		return sDao.insertOffer(offer);
	}
	
	public boolean addOfferHistory(OfferHistory oH) {
		return sDao.insertOfferHistory(oH);
	}
	
	public boolean addPayment(Payment pay) {
		return sDao.insertPayment(pay);
	}
	
	public Customer getCustomerByName(String name) {
		Customer customer = null;
		customer = sDao.selectCustomerByName(name);
		return customer;
	}
	
	public Customer getCustomerById(int id) {
		Customer customer = null;
		customer = sDao.selectCustomerById(id);
		return customer;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> custList;
		custList = sDao.selectAllCustomers();
		return custList;
	}
	
	public Employee getEmployeeByName(String name) {
		Employee employee = null;
		employee = sDao.selectEmployeeByName(name);
		return employee;
	}
	
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		employee = sDao.selectEmployeeById(id);
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> empList;
		empList = sDao.selectAllEmployees();
		return empList;
	}
	
	public List<Employee> getEmployeesByManager(Integer managerId){
		List<Employee> empList;
		empList = sDao.selectEmployeesByManager(managerId);
		return empList;
	}
	
	public Manager getManagerByName(String name) {
		Manager manager = null;
		manager = sDao.selectManagerByName(name);
		return manager;
	}
	
	public Manager getManagerById(int id) {
		Manager manager = null;
		manager = sDao.selectManagerById(id);
		return manager;
	}
	
	public Item getItemByName(String name) {
		Item item = null;
		item = sDao.selectItemByName(name);
		return item;
	}
	
	public Item getItemById(int id) {
		Item item = null;
		item = sDao.selectItemById(id);
		return item;
	}
	
	public List<Item> getAllItems(){
		List<Item> itemList;
		itemList = sDao.selectAllItems();
		return itemList;
	}
	
	public List<Item> getCustItems(){
		List<Item> itemList;
		itemList = sDao.selectUnownedItems();
		return itemList;
	}
	
	public List<Inventory> getCustomerInventory(int id){
		List<Inventory> inventory;
		inventory = sDao.selectInventoryByCustomerId(id);
		return inventory;
	}
	
	public List<Offer> getOffersByCustomerId(int id) {
		List<Offer> offerList;
		offerList = sDao.selectOffersByCustomerId(id);
		return offerList;
	}
	
	public List<Offer> getOffersByItemId(int id){
		List<Offer> offerList;
		offerList = sDao.selectOffersByItemId(id);
		return offerList;
	}
	
	public List<Offer> getAllOffers(){
		List<Offer> offerList;
		offerList = sDao.selectAllOffers();
		return offerList;
	}
	
	public List<OfferHistory> getOfferHistoriesByCustomerId(int id){
		List<OfferHistory> oHList;
		oHList = sDao.selectOfferHistoriesByCustomerId(id);
		return oHList;
	}
	
	public List<OfferHistory> getOfferHistoriesByItemId(int id){
		List<OfferHistory> oHList;
		oHList = sDao.selectOfferHistoriesByItemId(id);
		return oHList;
	}
	
	public List<OfferHistory> getAllOfferHistories(){
		List<OfferHistory> oHList;
		oHList = sDao.selectAllOfferHistories();
		return oHList;
	}
	
	public List<Payment> getPaymentsByCustomerId(int id) {
		List<Payment> paymentList;
		paymentList = sDao.selectPaymentsByCustomerId(id);
		return paymentList;
	}
	
	public List<Payment> getAllPayments(){
		List<Payment> paymentList;
		paymentList = sDao.selectAllPayments();
		return paymentList;
	}
	
	public boolean updateCustomerLogin(Customer cust) {
		return sDao.updateCustomerLogin(cust);
	}
	
	public boolean updateEmployeeLogin(Employee emp) {
		return sDao.updateEmployeeLogin(emp);
	}
	
	public boolean updateManagerLogin(Manager mana) {
		return sDao.updateManagerLogin(mana);
	}
	
	public boolean updateItemDescription(Item item) {
		return sDao.updateItemDescription(item);
	}
	
	public boolean updateItemPrice(Item item) {
		return sDao.updateItemPrice(item);
	}
	
	public boolean updateItemIsOwned(Item item) {
		return sDao.updateItemIsOwned(item);
	}
	
	public boolean updateOfferIsAccepted(Offer offer) {
		return sDao.updateOfferIsAccepted(offer);
	}
	
//	public boolean updateOfferHistoryStatus(OfferHistory oH) {
//		return sDao.updateOfferHistoryStatus(oH);
//	}
	
	public boolean updateRemainingPayments(Payment pay) {
		return sDao.updateRemainingPayments(pay);
	}
	
	public boolean deleteCustomer(int id) {
		return sDao.deleteCustomerById(id);
	}
	
	public boolean deleteEmployee(int id) {
		return sDao.deleteEmployeeById(id);
	}
	
	public boolean deleteItem(int id) {
		return sDao.deleteItemById(id);
	}
	
	public boolean deleteInventory(int id) {
		return sDao.deleteInventoryByCustomerId(id);
	}
	
	public boolean deleteItemOffers(int id) {
		return sDao.deleteOffersByItemId(id);
	}
	
	public boolean deleteCustomerOffer(int custId, int itemId) {
		return sDao.deleteCustomerOffer(custId, itemId);
	}
	
	public boolean deletePayment(int id) {
		return sDao.deletePaymentByCustomerId(id);
	}

}
