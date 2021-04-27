package com.revature.service;

import java.util.List;

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
	
	public boolean addCustomer(Customer cust) {
		return sDao.insertCustomer(cust);
	}
	
	public boolean addEmployee(Employee emp) {
		return sDao.insertEmployee(emp);
	}
	
	public boolean addManager(Manager mana) {
		return sDao.insertManager(mana);
	}
	
	public boolean addItem(Item item) {
		return sDao.insertItem(item);
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
	
	public List<Inventory> getCustomerInventory(int id){
		List<Inventory> inventory;
		inventory = sDao.selectInventoryByCustomerId(id);
		return inventory;
	}
	
	public Offer getOfferByCustomerId(int id) {
		Offer offer = null;
		offer = sDao.selectOfferByCustomerId(id);
		return offer;
	}
	
	public List<Offer> getAllOffers(){
		List<Offer> offerList;
		offerList = sDao.selectAllOffers();
		return offerList;
	}
	
	public OfferHistory getOfferHistoryByCustomerId(int id) {
		OfferHistory oH = null;
		oH = sDao.selectOfferHistoryByCustomerId(id);
		return oH;
	}
	
	public List<OfferHistory> getAllOfferHistories(){
		List<OfferHistory> oHList;
		oHList = sDao.selectAllOfferHistories();
		return oHList;
	}
	
	public Payment getPaymentByCustomerId(int id) {
		Payment payment = null;
		payment = sDao.selectPaymentByCustomerId(id);
		return payment;
	}
	
	public List<Payment> getAllPayments(){
		List<Payment> paymentList;
		paymentList = sDao.selectAllPayments();
		return paymentList;
	}
	
	public boolean updateCustomer(Customer cust) {
		return sDao.updateCustomer(cust);
	}
	
	public boolean updateEmployee(Employee emp) {
		return sDao.updateEmployee(emp);
	}
	
	public boolean updateManager(Manager mana) {
		return sDao.updateManager(mana);
	}
	
	public boolean updateItem(Item item) {
		return sDao.updateItem(item);
	}
	
	public boolean updateOffer(Offer offer) {
		return sDao.updateOffer(offer);
	}
	
	public boolean updateOfferHistory(OfferHistory oH) {
		return sDao.updateOfferHistory(oH);
	}
	
	public boolean updatePayment(Payment pay) {
		return sDao.updatePayment(pay);
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
		return sDao.deleteOfferByItemId(id);
	}
	
	public boolean deleteUnacceptedItemOffers(int id) {
		return sDao.deleteOfferUnaccepted(id);
	}
	
	public boolean deletePayment(int id) {
		return sDao.deletePaymentByCustomerId(id);
	}

}
