package com.shop.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
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
import com.revature.repository.ShopDAOImpl;
import com.revature.service.ShopService;

public class ShopTests {
	
	private static ShopService sS;
	private static Customer cust = new Customer(5, "Test", "123", false);
	private static Manager mana = new Manager(2, "Anne", "bbb", false);
	private static Employee emp = new Employee(5, "Mark", "aaa", 2, false);
	private static Item item = new Item(5, "Epee", "Pointy Sword", 99.99, false);
	private static Offer offer, offer2;
	private static Payment pay;
	private static Payment pay2 = new Payment(9, 9, 9, 120, 0, 10, 5);
	private static Inventory inv;
	private static OfferHistory oH;
	
	@Mock
	private static ShopDAOImpl sD;
	
	@BeforeClass
	public static void setup() {
		sD = Mockito.mock(ShopDAOImpl.class); //Mock DAO for service
		sS = new ShopService(sD); //Dependency Injection
		
		//Customer List
		List<Customer> custList = new ArrayList<>();
		Customer cust1 = new Customer(1, "John", "p@ssw0rd", false);
		Customer cust2 = new Customer(2, "Candice", "qwerty", false);
		custList.add(cust1);
		custList.add(cust2);
		
		//Manager List
		List<Manager> manaList = new ArrayList<>();
		Manager mana1 = new Manager(1, "Kevin", "SUPERp@ssw0ord", false);
		manaList.add(mana1);
		
		//Employee List
		List<Employee> empList = new ArrayList<>();
		Employee emp1 = new Employee(1, "Kemo", "PassWord", mana1.getId(), false);
		Employee emp2 = new Employee(2, "Steve", "123", mana1.getId(), false);
		empList.add(emp1);
		empList.add(emp2);
		
		//Item List
		List<Item> itemList = new ArrayList<>();
		Item item1 = new Item(1, "Icebrand", "Icy Sword", 189.29, false);
		Item item2 = new Item(2, "Flametongue", "Fiery Sword", 200.59, true);
		Item item3 = new Item(3, "Excalibur", "Holy Sword", 399.99, true);
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		
		//Inventory List
		List<Inventory> invList = new ArrayList<>();
		Inventory inv1 = new Inventory(1, cust1.getId(), item2.getName(), item2.getDescription());
		Inventory inv2 = new Inventory(2, cust2.getId(), item3.getName(), item3.getDescription());
		invList.add(inv1);
		invList.add(inv2);
		
		//Offer List 
		List<Offer> offerList = new ArrayList<>();
		Offer offer1 = new Offer(3, cust2.getId(), item1.getItemId(), item1.getPrice(), "2", false);
		Offer offer2 = new Offer(4, cust1.getId(), item1.getItemId(), item1.getPrice(), "3", false);
		offerList.add(offer1);
		offerList.add(offer2);
		
		//OfferHistory List
		List<OfferHistory> oHList = new ArrayList<>();
		OfferHistory oH1 = new OfferHistory(1, cust1.getId(), item2.getItemId(), "1", "accepted");
		OfferHistory oH2 = new OfferHistory(2, cust2.getId(), item2.getItemId(), "1", "rejected");
		OfferHistory oH3 = new OfferHistory(3, cust2.getId(), item3.getItemId(), "2", "accepted");
		oHList.add(oH1);
		oHList.add(oH2);
		
		//Payment List
		List<Payment> payList = new ArrayList<>();
		Payment pay1 = new Payment(1, cust1.getId(), item2.getItemId(), item2.getPrice(), 0, 4, 4);
		Payment pay2 = new Payment(2, cust2.getId(), item3.getItemId(), item3.getPrice(), 0, 6, 6);
		payList.add(pay1);
		payList.add(pay2);
		
		//Mock DAO
		//select customer
		Mockito.when(sD.selectCustomerByName(cust1.getUserName())).thenReturn(cust1);
		Mockito.when(sD.selectCustomerById(cust2.getId())).thenReturn(cust2);
		Mockito.when(sD.selectAllCustomers()).thenReturn(custList);
		//select employee
		Mockito.when(sD.selectEmployeeByName(emp1.getUserName())).thenReturn(emp1);
		Mockito.when(sD.selectEmployeeById(emp2.getId())).thenReturn(emp2);
		Mockito.when(sD.selectAllEmployees()).thenReturn(empList);
		Mockito.when(sD.selectEmployeesByManager((Integer)mana1.getId())).thenReturn(empList
																					.stream().filter(x -> x.getManagerId() == (Integer)mana1.getId())
																					.collect(Collectors.toList()));
		//select manager
		Mockito.when(sD.selectManagerById(mana1.getId())).thenReturn(mana1);
		Mockito.when(sD.selectManagerByName(mana1.getUserName())).thenReturn(mana1);
		//select item
		Mockito.when(sD.selectItemByName(item1.getName())).thenReturn(item1);
		Mockito.when(sD.selectItemById(item2.getItemId())).thenReturn(item2);
		Mockito.when(sD.selectAllItems()).thenReturn(itemList);
		Mockito.when(sD.selectUnownedItems()).thenReturn(itemList
											.stream().filter(x -> x.isOwned() == false)
											.collect(Collectors.toList()));
		//select inventory
		Mockito.when(sD.selectInventoryByCustomerId(inv1.getCustomerId())).thenReturn(invList
																			.stream().filter(x -> x.getCustomerId() == inv1.getCustomerId())
																			.collect(Collectors.toList()));
		//select offer
		Mockito.when(sD.selectOffersByCustomerId(offer1.getCustomerId())).thenReturn(offerList
																			.stream().filter(x -> x.getCustomerId() == offer1.getCustomerId())
																			.collect(Collectors.toList()));
		Mockito.when(sD.selectOffersByItemId(offer1.getItemId())).thenReturn(offerList
																			.stream().filter(x -> x.getItemId() == offer1.getItemId())
																			.collect(Collectors.toList()));
		Mockito.when(sD.selectAllOffers()).thenReturn(offerList);
		//select offer history
		Mockito.when(sD.selectOfferHistoriesByCustomerId(oH3.getCustomerId())).thenReturn(oHList
																				.stream().filter(x -> x.getCustomerId() == oH3.getCustomerId())
																				.collect(Collectors.toList()));
		Mockito.when(sD.selectOfferHistoriesByItemId(oH1.getItemId())).thenReturn(oHList
																		.stream().filter(x -> x.getItemId() == oH1.getItemId())
																		.collect(Collectors.toList()));
		Mockito.when(sD.selectAllOfferHistories()).thenReturn(oHList);
		//select payment
		Mockito.when(sD.selectPaymentsByCustomerId(pay1.getCustomerId())).thenReturn(payList
																			.stream().filter(x -> x.getCustomerId() == oH1.getCustomerId())
																			.collect(Collectors.toList()));
		Mockito.when(sD.selectAllPayments()).thenReturn(payList);
		
		//Insert statements
		Mockito.when(sD.insertCustomer(cust)).thenReturn(true);
		Mockito.when(sD.insertEmployee(emp)).thenReturn(true);
		Mockito.when(sD.insertManager(mana)).thenReturn(true);
		Mockito.when(sD.insertItem(item)).thenReturn(true);
		Mockito.when(sD.insertInventory(inv)).thenReturn(true);
		Mockito.when(sD.insertOffer(offer)).thenReturn(true);
		Mockito.when(sD.insertOfferHistory(oH)).thenReturn(true);
		Mockito.when(sD.insertPayment(pay)).thenReturn(true);
		
		//Update statements
		Mockito.when(sD.updateCustomerLogin(cust)).thenReturn(true);
		Mockito.when(sD.updateEmployeeLogin(emp)).thenReturn(true);
		Mockito.when(sD.updateManagerLogin(mana)).thenReturn(true);
		Mockito.when(sD.updateItemDescription(item)).thenReturn(true);
		Mockito.when(sD.updateItemPrice(item)).thenReturn(true);
		Mockito.when(sD.updateItemIsOwned(item)).thenReturn(true);
		Mockito.when(sD.updateOfferIsAccepted(offer)).thenReturn(true); //Not working as expected
		Mockito.when(sD.updateRemainingPayments(pay)).thenReturn(true);
		
		//Delete statements
		Mockito.when(sD.deleteCustomerById(cust1.getId())).thenReturn(true);
		Mockito.when(sD.deleteEmployeeById(emp1.getId())).thenReturn(true);
		Mockito.when(sD.deleteItemById(item1.getItemId())).thenReturn(true);
		Mockito.when(sD.deleteInventoryByCustomerId(inv1.getCustomerId())).thenReturn(true);
		Mockito.when(sD.deleteOffersByItemId(offer1.getItemId())).thenReturn(true);
		Mockito.when(sD.deleteCustomerOffer(offer2.getCustomerId(), offer2.getItemId())).thenReturn(true);
		Mockito.when(sD.deletePaymentByCustomerId(pay1.getCustomerId())).thenReturn(true);
		
	}
	
	@Test
	public void testValidInteger() {
		assertEquals(1, sS.validInteger("1"));
		assertNotEquals(2, sS.validInteger("1"));
	}
	
	@Test
	public void testValidDouble() {
		assertEquals(1.99, sS.validDouble("1.99"), 0.001);
		assertNotEquals(2.03, sS.validDouble("2"), 0.001);
	}
	
	@Test
	public void testValidPayInput() {
		assertEquals(0, sS.validPayInput("a", pay2));
		assertEquals(3, sS.validPayInput("3", pay2));
	}
	
	@Test 
	public void testConstructOffer() {
		offer = sS.constructOffer(cust, item, "1");
		
		assertEquals(cust.getId(), offer.getCustomerId());
		assertEquals(item.getItemId(), offer.getItemId());
		assertEquals(item.getPrice(), offer.getItemPrice(), 0.001);
	}
	
	@Test
	public void testConstructPayment() {
		pay = sS.constructPayment(offer);
		
		assertEquals(cust.getId(), pay.getCustomerId());
		assertEquals(4, pay.getNumberOfPayments());
		
	}
	
	@Test
	public void testConstructInventory() {
		inv = sS.constructInventory(cust.getId(), item);
		
		assertEquals(cust.getId(), inv.getCustomerId());
		assertEquals(item.getName(), inv.getItemName());
	}
	
	@Test
	public void testConstructOfferHistory() {
		List<Offer> offerList = new ArrayList<>();
		List<OfferHistory> histList = new ArrayList<>();
		offer2 = new Offer(1, 4, 4, 90.00, "3", true);
		offerList.add(offer2);
		
		histList = sS.constructOfferHistory(offerList);
		assertFalse(histList.isEmpty());
	}
	
	@Test
	public void testCalculateWeeklyPayment(){
		assertEquals(12.0, sS.calculateWeeklyPayment(pay2), 0.00);
	}
	
	@Test
	public void testCalculateAmountRemaining() {
		assertEquals(60.0, sS.calculateAmountRemaining(pay2, 12.0), 0.00);

	}
	
	@Test
	public void testSelectCustomerByName() {
		String password = "p@ssw0rd";
		
		assertNotNull(sS.getCustomerByName("John"));
		assertEquals(password, sS.getCustomerByName("John").getPassword());
	}
	
	@Test
	public void testSelectCustomerById() {
		String userName = "Candice";
		
		assertNotNull(sS.getCustomerById(2));
		assertEquals(userName, sS.getCustomerById(2).getUserName());
	}
	
	@Test
	public void testSelectAllCustomers() {
		assertFalse(sS.getAllCustomers().isEmpty());
	}
	
	@Test
	public void testSelectEmployeeByName() {
		int id = 1;
		
		assertNotNull(sS.getEmployeeByName("Kemo"));
		assertEquals(id, sS.getEmployeeByName("Kemo").getId());
	}
	
	@Test
	public void testSelectEmployeeById() {
		String password = "123";
		
		assertNotNull(sS.getEmployeeById(2));
		assertEquals(password, sS.getEmployeeById(2).getPassword());
	}
	
	@Test
	public void testSelectAllEmployees() {
		assertFalse(sS.getAllEmployees().isEmpty());
	}
	
	@Test
	public void testSelectEmployeeByManager() {
		assertFalse(sS.getEmployeesByManager(1).isEmpty());
	}
	
	@Test
	public void testSelectManagerByName() {
		int id = 1;
		
		assertNotNull(sS.getManagerByName("Kevin"));
		assertEquals(id, sS.getManagerByName("Kevin").getId());

	}
	
	@Test
	public void testSelectManagerById() {
		String userName = "Kevin";
		
		assertNotNull(sS.getManagerById(1));
		assertEquals(userName, sS.getManagerById(1).getUserName());
	}
	
	@Test
	public void testSelectItemByName() {
		double price = 189.29;
		
		assertNotNull(sS.getItemByName("Icebrand"));
		assertEquals(price, sS.getItemByName("Icebrand").getPrice(), 0.001);	
	}
	
	@Test 
	public void testSelectItemById() {
		String description = "Fiery Sword";
		
		assertNotNull(sS.getItemById(2));
		assertEquals(description, sS.getItemById(2).getDescription());
	}
	
	@Test 
	public void testSelectAllItems() {
		assertFalse(sS.getAllItems().isEmpty());
	}
	
	@Test
	public void testSelectUnownedItems() {
		assertFalse(sS.getCustItems().isEmpty());
	}
	
	@Test
	public void testSelectInventoryByCustomerId() {
		assertFalse(sS.getCustomerInventory(1).isEmpty());
	}
	
	@Test
	public void testSelectOffersByCustomerId() {
		assertFalse(sS.getOffersByCustomerId(2).isEmpty());
	}
	
	@Test 
	public void testSelectOffersByItemId() {
		assertFalse(sS.getOffersByItemId(1).isEmpty());
	}
	
	@Test
	public void testSelectAllOffers() {
		assertFalse(sS.getAllOffers().isEmpty());
	}
	
	@Test
	public void testSelectOfferHistoriesByCustomerId() {
		assertFalse(sS.getOfferHistoriesByCustomerId(2).isEmpty());
	}
	
	@Test
	public void testSelectOfferHistoriesByItemId() {
		assertFalse(sS.getOfferHistoriesByItemId(2).isEmpty());
	} 
	
	@Test
	public void testSelectAllOfferHistories() {
		assertFalse(sS.getAllOfferHistories().isEmpty());
	}
	
	@Test
	public void testSelectPaymentsByCustomerId() {
		assertFalse(sS.getPaymentsByCustomerId(1).isEmpty());
	}
	
	@Test
	public void testSelectAllPayments() {
		assertFalse(sS.getAllPayments().isEmpty());
	}
	
	@Test
	public void testInsertCustomer() {
		assertTrue(sS.addCustomer(cust));
	}
	
	@Test
	public void testInsertEmployee() {
		assertTrue(sS.addEmployee(emp));
	}
	
	@Test 
	public void testInsertManager() {
		assertTrue(sS.addManager(mana));
	}
	
	@Test
	public void testInsertItem() {
		assertTrue(sS.addItem(item));
	}
	
	@Test
	public void testInsertInventory() {
		assertTrue(sS.addInventory(inv));
	}
	
	@Test
	public void testInsertOffer() {
		assertTrue(sS.addOffer(offer));
	}
	
	@Test
	public void testInsertOfferHistory() {
		assertTrue(sS.addOfferHistory(oH));
	}
	
	@Test
	public void testInsertPayment() {
		assertTrue(sS.addPayment(pay));
	}
	
	@Test
	public void testUpdateCustomerLogin() {
		assertTrue(sS.updateCustomerLogin(cust));
	}
	
	@Test
	public void testUpdateEmployeeLogin() {
		assertTrue(sS.updateEmployeeLogin(emp));
	}
	
	@Test 
	public void testUpdateManagerLogin() {
		assertTrue(sS.updateManagerLogin(mana));
	}
	
	@Test
	public void testUpdateItemPrice() {
		assertTrue(sS.updateItemPrice(item));
	}
	
	@Test
	public void testUpdateItemDescription() {
		assertTrue(sS.updateItemDescription(item));
	}
	
	@Test
	public void testUpdateItemIsOwned() {
		assertTrue(sS.updateItemIsOwned(item));
	}
	
	@Test
	public void testUpdateOfferIsAccepted() {
		//TODO
		assertFalse(sS.updateOfferIsAccepted(offer));
	}
	
	@Test
	public void testUpdateRemainingPayments() {
		assertTrue(sS.updateRemainingPayments(pay));
	}
	
	@Test
	public void testDeleteCustomer() {
		assertTrue(sS.deleteCustomer(1));
	}
	
	@Test
	public void testDeleteEmployee() {
		assertTrue(sS.deleteEmployee(1));
	}
	
	@Test
	public void testDeleteItem() {
		assertTrue(sS.deleteItem(1));
	}
	
	@Test
	public void testDeleteInventory() {
		assertTrue(sS.deleteInventory(1));
	}
	
	@Test
	public void testDeleteItemOffers() {
		assertTrue(sS.deleteItemOffers(1));
	}
	
	@Test
	public void testDeleteCustomerOffer() {
		assertTrue(sS.deleteCustomerOffer(1,1));
	}
	
	@Test
	public void testDeletePayment() {
		assertTrue(sS.deletePayment(1));
	}
	

}
