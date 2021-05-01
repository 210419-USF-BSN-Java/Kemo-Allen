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
	List<Employee> selectEmployeesByManager(Integer managerId);
	
	Manager selectManagerByName(String name);
	Manager selectManagerById(int id);
	
	Item selectItemByName(String name);
	Item selectItemById(int id);
	List<Item> selectAllItems();
	List<Item> selectUnownedItems();
	
	List<Inventory> selectInventoryByCustomerId(int id);
	
	List<Offer> selectOffersByCustomerId(int id);
	List<Offer> selectOffersByItemId(int id);
	List<Offer> selectAllOffers();
	
	List<OfferHistory> selectOfferHistoriesByCustomerId(int id);
	List<OfferHistory> selectOfferHistoriesByItemId(int id);
	List<OfferHistory> selectAllOfferHistories();
	
	List<Payment> selectPaymentsByCustomerId(int id);
	List<Payment> selectAllPayments();
	
	//Update
	boolean updateCustomerLogin(Customer cust);
	boolean updateEmployeeLogin(Employee emp);
	boolean updateManagerLogin(Manager mana);
	boolean updateItemDescription(Item item);
	boolean updateItemPrice(Item item);
	boolean updateItemIsOwned(Item item);
	boolean updateOfferIsAccepted(Offer offer);
	boolean updateOfferHistoryStatus(OfferHistory oH);
	boolean updateRemainingPayments(Payment pay);
	
	//Delete
	boolean deleteCustomerById(int id);
	boolean deleteEmployeeById(int id);
	boolean deleteItemById(int id);
	boolean deleteInventoryByCustomerId(int id);
	boolean deleteOfferByItemId(int id); //When deleting an item 
	boolean deleteOfferUnaccepted(int id, boolean isAccepted);
	boolean deletePaymentByCustomerId(int id);

}

