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

import org.apache.log4j.Logger;

public class ShopDaoImpl implements ShopDAO{
	
	private final Logger LOG = Logger.getLogger(ShopDaoImpl.class);

	public ShopDaoImpl() {
		super();
	}
	
	@Override
	public boolean insertCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertManager(Manager mana) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertInventory(Inventory inv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOffer(Offer offer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOfferHistory(OfferHistory oH) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertPayment(Payment pay) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer selectCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee selectEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee selectEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager selectManagerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager selectManagerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item selectItemByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item selectItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> selectAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> selectInventoryByCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offer selectOfferByCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> selectAllOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfferHistory selectOfferHistoryByCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OfferHistory> selectAllOfferHistories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment selectPaymentByCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> selectAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateManager(Manager mana) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOffer(Offer offer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOfferHistory(OfferHistory oH) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePayment(Payment pay) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInventoryByCustomerId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOfferByItemId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOfferUnaccepted(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePaymentByCustomerId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
