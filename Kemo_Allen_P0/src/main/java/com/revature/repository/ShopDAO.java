package com.revature.repository;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;
import com.revature.models.Item;
import com.revature.models.Manager;
import com.revature.models.Offer;
import com.revature.models.OfferHistory;
import com.revature.models.Payment;

public interface ShopDAO {

	//Create
	boolean insertCustomer(Customer cust);
	boolean insertEmployee(Employee emp);
	boolean insertManager(Manager mana);
	boolean insertItem(Item item);
	boolean insertInventory(Inventory inv);
	boolean insertOffer(Offer offer);
	boolean insertOfferHistory(OfferHistory oH);
	boolean insertPayment(Payment pay);
	
	//Read
	Customer selectCustomerByName(String name);
	Customer selectCustomerById(int id);
	List<Customer> selectAllCustomers();
	
	Employee selectEmployeeByName(String name);
	Employee selectEmployeeById(int id);
	List<Employee> selectAllEmployees();
	
	Manager selectManagerByName(String name);
	Manager selectManagerById(int id);
	
	Item selectItemByName(String name);
	Item selectItemById(int id);
	List<Item> selectAllItems();
	
	List<Inventory> selectInventoryByCustomerId(int id);
	
	Offer selectOfferByCustomerId(int id);
	List<Offer> selectAllOffers();
	
	OfferHistory selectOfferHistoryByCustomerId(int id);
	List<OfferHistory> selectAllOfferHistories();
	
	Payment selectPaymentByCustomerId(int id);
	List<Payment> selectAllPayments();
	
	//Update
	boolean updateCustomer(Customer cust);
	boolean updateEmployee(Employee emp);
	boolean updateManager(Manager mana);
	boolean updateItem(Item item);
	boolean updateOffer(Offer offer);
	boolean updateOfferHistory(OfferHistory oH);
	boolean updatePayment(Payment pay);
	
	//Delete
	boolean deleteCustomerById(int id);
	boolean deleteEmployeeById(int id);
	boolean deleteItemById(int id);
	boolean deleteInventoryByCustomerId(int id);
	boolean deleteOfferByItemId(int id);
	boolean deleteOfferUnaccepted(int id);
	boolean deletePaymentByCustomerId(int id);

}

