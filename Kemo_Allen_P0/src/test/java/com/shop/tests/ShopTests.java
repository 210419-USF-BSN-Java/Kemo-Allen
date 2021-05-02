package com.shop.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;
import com.revature.models.Item;
import com.revature.models.Manager;
import com.revature.models.Offer;
import com.revature.models.OfferHistory;
import com.revature.models.Payment;
import com.revature.service.ShopService;

public class ShopTests {
	
	@Mock
	static ShopService sS;
	
	@BeforeClass
	public static void setup() {
		sS = Mockito.mock(ShopService.class);
		
		//Customer List
		List<Customer> custList = new ArrayList<>();
		Customer cust1 = new Customer();
		Customer cust2 = new Customer();
		custList.add(cust1);
		custList.add(cust2);
		
		//Employee List
		List<Employee> empList = new ArrayList<>();
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		empList.add(emp1);
		empList.add(emp2);
		
		//Manager List
		List<Manager> manaList = new ArrayList<>();
		Manager mana1 = new Manager();
		manaList.add(mana1);
		
		//Item List
		List<Item> itemList = new ArrayList<>();
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		
		//Inventory List
		List<Inventory> invList = new ArrayList<>();
		
		//Offer List 
		List<Offer> offerList = new ArrayList<>();
		
		//OfferHistory List
		List<OfferHistory> oHList = new ArrayList<>();
		
		//Payment List
		List<Payment> payList = new ArrayList<>();
		
		//Mock Service
		Mockito.when(sS.getAllCustomers()).thenReturn(custList);
		Mockito.when(sS.getCustomerById(1)).thenReturn(custList.get(1));
		
		
	}

}
