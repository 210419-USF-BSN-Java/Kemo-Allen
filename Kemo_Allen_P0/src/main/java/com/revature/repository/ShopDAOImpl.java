package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Inventory;
import com.revature.models.Item;
import com.revature.models.Manager;
import com.revature.models.Offer;
import com.revature.models.OfferHistory;
import com.revature.models.Payment;
import com.revature.util.ShopConnection;

public class ShopDAOImpl implements ShopDAO{
	
	private final Logger LOG = Logger.getLogger(ShopDAOImpl.class);

	public ShopDAOImpl() {
		super();
	}
	
	@Override
	public boolean insertCustomer(Customer cust) {
		boolean success = false;
		
		String sql = "INSERT INTO customers (user_name, pass_word) VALUES (?,?)";
		//String sql = "INSERT INTO customers (user_name, pass_word) VALUES (?,?) generating user_id";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cust.getUserName());
			ps.setString(2, cust.getPassword());
			
			ps.execute();
			
//			ResultSet rs = ps.executeQuery(); //gets the user_id from the generating, so this can be used as a return 
//			if(rs.next()) { //if keys were generated from the ps.execute
//			
//			}
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when adding a customer.");
		}
		
		return success;
	}

	@Override
	public boolean insertEmployee(Employee emp) {
		boolean success = false;
		
		String sql = "INSERT INTO employees (user_name, pass_word) VALUES (?,?)";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getUserName());
			ps.setString(2, emp.getPassword());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when adding an employee.");
		}
		
		return success;
	}

	@Override
	public boolean insertManager(Manager mana) {
		boolean success = false;
		
		String sql = "INSERT INTO managers (user_name, pass_word) VALUES (?,?)";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mana.getUserName());
			ps.setString(2, mana.getPassword());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when adding a manager.");
		}
		
		return success;
	}

	@Override
	public boolean insertItem(Item item) {
		boolean success = false;
		
		String sql = "INSERT INTO items (item_name, description, price) VALUES (?,?,?)";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setString(2, item.getDescription());
			ps.setDouble(3, item.getPrice());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when adding an item.");
		}
		
		return success;
	}

	@Override
	public boolean insertInventory(Inventory inv) {
		boolean success = false;
		
		String sql = "INSERT INTO inventories (customer_id, item_name, description) VALUES (?,?,?)";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inv.getCustomerId());
			ps.setString(2, inv.getItemName());
			ps.setString(3, inv.getDescription());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when adding an inventory.");
		}
		
		return success;
	}

	@Override
	public boolean insertOffer(Offer offer) {
		boolean success = false;
		
		String sql = "INSERT INTO offers (customer_id, item_id, item_price, payment_type) VALUES (?,?,?,?)";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, offer.getCustomerId());
			ps.setInt(2, offer.getItemId());
			ps.setDouble(3, offer.getItemPrice());
			ps.setString(4, offer.getPaymentType());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when adding an offer.");
		}
		
		return success;
	}

	@Override
	public boolean insertOfferHistory(OfferHistory oH) {
		boolean success = false;
		
		String sql = "INSERT INTO offer_histories (customer_id, item_id, payment_type,status) VALUES (?,?,?,?)";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oH.getCustomerId());
			ps.setInt(2, oH.getItemId());
			ps.setString(3, oH.getPaymentType());
			ps.setString(4, oH.getStatus());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when adding an offer history.");
		}
		
		return success;
	}
	
	@Override
	public boolean insertOfferHistories(List<OfferHistory> historyList) {
		return false;
	}

	@Override
	public boolean insertPayment(Payment pay) {
		boolean success = false;
		
		String sql = "INSERT INTO payments (customer_id, item_id, item_price, rate, number_of_payments, payments_remaining) VALUES (?,?,?,?,?,?)";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pay.getCustomerId());
			ps.setInt(2, pay.getItemId());
			ps.setDouble(3, pay.getItemPrice());
			ps.setDouble(4, pay.getRate());
			ps.setInt(5, pay.getNumberOfPayments());
			ps.setInt(6, pay.getPaymentsRemaining());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when adding a payment.");
		}
		
		return success;
	}

	@Override
	public Customer selectCustomerByName(String name) {
		Customer cust = null;
		String sql = "SELECT * FROM customers WHERE user_name = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cust = new Customer(rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("pass_word"),
						rs.getBoolean("is_logged_in"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a customer.");
		}
		return cust;
	}

	@Override
	public Customer selectCustomerById(int id) {
		Customer cust = null;
		String sql = "SELECT * FROM customers WHERE user_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cust = new Customer(rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("pass_word"),
						rs.getBoolean("is_logged_in"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a customer.");
		}
		return cust;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> custList = new LinkedList<Customer>();
		
		String sql = "SELECT * FROM customers";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				custList.add(
						new Customer(rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("pass_word"),
						rs.getBoolean("is_logged_in")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a list of customers.");
		}
		return custList;
	}

	@Override
	public Employee selectEmployeeByName(String name) {
		Employee emp = null;
		String sql = "SELECT * FROM employees WHERE user_name = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employee(rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("pass_word"),
						rs.getInt("manager_id"),
						rs.getBoolean("is_logged_in"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a employee.");
		}
		return emp;
	}

	@Override
	public Employee selectEmployeeById(int id) {
		Employee emp = null;
		String sql = "SELECT * FROM employees WHERE user_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employee(rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("pass_word"),
						rs.getInt("manager_id"),
						rs.getBoolean("is_logged_in"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a employee.");
		}
		return emp;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		List<Employee> empList = new LinkedList<Employee>();
		
		String sql = "SELECT * FROM employees";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				empList.add( new Employee(rs.getInt("user_id"),
								rs.getString("user_name"),
								rs.getString("pass_word"),
								rs.getInt("manager_id"),
								rs.getBoolean("is_logged_in")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a list of employees.");
		}
		return empList;
	}
	
	@Override
	public List<Employee> selectEmployeesByManager(Integer id) {
		List<Employee> empList = new LinkedList<Employee>();
		
		String sql = "SELECT * FROM employees where manager_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				empList.add( new Employee(rs.getInt("user_id"),
								rs.getString("user_name"),
								rs.getString("pass_word"),
								rs.getInt("manager_id"),
								rs.getBoolean("is_logged_in")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a list of employees.");
		}
		return empList;
	}

	@Override
	public Manager selectManagerByName(String name) {
		Manager mana = null;
		String sql = "SELECT * FROM managers WHERE user_name = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				mana = new Manager(rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("pass_word"),
						rs.getBoolean("is_logged_in"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a manager.");
		}
		return mana;
	}

	@Override
	public Manager selectManagerById(int id) {
		Manager mana = null;
		String sql = "SELECT * FROM managers WHERE user_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				mana = new Manager(rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("pass_word"),
						rs.getBoolean("is_logged_in"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a manager.");
		}
		return mana;
	}

	@Override
	public Item selectItemByName(String name) {
		Item item = null;
		
		String sql = "SELECT * FROM items WHERE item_name = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				item = new Item(rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getBoolean("is_owned"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting an item.");
		}
		
		return item;
	}

	@Override
	public Item selectItemById(int id) {
		Item item = null;
		
		String sql = "SELECT * FROM items WHERE item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				item = new Item(rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getBoolean("is_owned"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting an item.");
		}
		
		return item;
	}

	@Override
	public List<Item> selectAllItems() {
		List<Item> itemList = new LinkedList<>();
		
		String sql = "SELECT * FROM items";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				itemList.add(new Item(rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getBoolean("is_owned")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a list of items.");
		}
		
		return itemList;
	}
	
	@Override
	public List<Item> selectUnownedItems() {
		List<Item> itemList = new LinkedList<>();
		
		String sql = "SELECT * FROM items WHERE is_owned = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, false);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				itemList.add(new Item(rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getBoolean("is_owned")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a list of items.");
		}
		
		return itemList;
	}

	@Override
	public List<Inventory> selectInventoryByCustomerId(int id) {
		List<Inventory> invList = new LinkedList<>();
		
		String sql = "SELECT * FROM inventories WHERE customer_id = ?";
		
		try(Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				invList.add(new Inventory(rs.getInt("inventory_id"),
						rs.getInt("customer_id"),
						rs.getString("item_name"),
						rs.getString("description")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting a customer inventory.");
		}
		
		return invList;
	}

	@Override
	public List<Offer> selectOffersByCustomerId(int id) {
		List<Offer> offers = new LinkedList<>();
		
		String sql = "SELECT * FROM offers WHERE customer_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 offers.add(new Offer(rs.getInt("offer_id"),
						rs.getInt("customer_id"),
						rs.getInt("item_id"),
						rs.getDouble("item_price"),
						rs.getString("payment_type"),
						rs.getBoolean("is_accepted")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting offers.");
		}
		
		return offers;
	}
	@Override
	public List<Offer> selectOffersByItemId(int id){
		List<Offer> offers = new LinkedList<>();
		
		String sql = "SELECT * FROM offers WHERE item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 offers.add(new Offer(rs.getInt("offer_id"),
						rs.getInt("customer_id"),
						rs.getInt("item_id"),
						rs.getDouble("item_price"),
						rs.getString("payment_type"),
						rs.getBoolean("is_accepted")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting offers.");
		}
		
		return offers;
	}

	@Override
	public List<Offer> selectAllOffers() {
		List<Offer> offers = new LinkedList<>();
		
		String sql = "SELECT * FROM offers";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 offers.add(new Offer(rs.getInt("offer_id"),
						rs.getInt("customer_id"),
						rs.getInt("item_id"),
						rs.getDouble("item_price"),
						rs.getString("payment_type"),
						rs.getBoolean("is_accepted")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting offers.");
		}
		
		return offers;
	}

	@Override
	public List<OfferHistory> selectOfferHistoriesByCustomerId(int id) {
		List<OfferHistory> oH = new LinkedList<>();
		
		String sql = "SELECT * FROM offer_histories WHERE customer_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				oH.add(new OfferHistory(rs.getInt("history_id"),
						rs.getInt("customer_id"),
						rs.getInt("item_id"),
						rs.getString("payment_type"),
						rs.getString("status")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting offer history.");
		}
		
		return oH;
	}
	
	@Override
	public List<OfferHistory> selectOfferHistoriesByItemId(int id) {
		List<OfferHistory> oH = new LinkedList<>();
		
		String sql = "SELECT * FROM offer_histories WHERE item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				oH.add(new OfferHistory(rs.getInt("history_id"),
						rs.getInt("customer_id"),
						rs.getInt("item_id"),
						rs.getString("payment_type"),
						rs.getString("status")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting offer history.");
		}
		
		return oH;
	}

	@Override
	public List<OfferHistory> selectAllOfferHistories() {
		List<OfferHistory> oH = new LinkedList<>();
		
		String sql = "SELECT * FROM offer_histories";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				oH.add(new OfferHistory(rs.getInt("history_id"),
						rs.getInt("customer_id"),
						rs.getInt("item_id"),
						rs.getString("payment_type"),
						rs.getString("status")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting offer history.");
		}
		
		return oH;
	}

	@Override
	public List<Payment> selectPaymentsByCustomerId(int id) {
		List<Payment> pay = new LinkedList<>();
		
		String sql = "SELECT * FROM payments WHERE customer_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pay.add(new Payment(rs.getInt("payment_id"),
						rs.getInt("customer_id"),
						rs.getInt("item_id"),
						rs.getDouble("item_price"),
						rs.getDouble("rate"),
						rs.getInt("number_of_payments"),
						rs.getInt("payments_remaining")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting payments.");
		}
		
		return pay;
	}

	@Override
	public List<Payment> selectAllPayments() {
		List<Payment> pay = new LinkedList<>();
		
		String sql = "SELECT * FROM payments";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pay.add(new Payment(rs.getInt("payment_id"),
						rs.getInt("customer_id"),
						rs.getInt("item_id"),
						rs.getDouble("item_price"),
						rs.getDouble("rate"),
						rs.getInt("number_of_payments"),
						rs.getInt("payments_remaining")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when getting payments.");
		}
		
		return pay;
	}

	@Override
	public boolean updateCustomerLogin(Customer cust) {
		boolean success = false;
		
		String sql = "UPDATE customers SET is_logged_in = ? WHERE user_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, cust.isLoggedIn());
			ps.setInt(2, cust.getId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue with updating a customer.");
		}
		
		return success;
	}

	@Override
	public boolean updateEmployeeLogin(Employee emp) {
		boolean success = false;
		
		String sql = "UPDATE employees SET is_logged_in = ? WHERE user_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, emp.isLoggedIn());
			ps.setInt(2, emp.getId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue with updating an employee.");
		}
		
		return success;
	}

	@Override
	public boolean updateManagerLogin(Manager mana) {
		boolean success = false;
		
		String sql = "UPDATE managers SET is_logged_in = ? WHERE user_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, mana.isLoggedIn());
			ps.setInt(2, mana.getId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue with updating a manager.");
		}
		
		return success;
	}

	@Override
	public boolean updateItemDescription(Item item) {
		boolean success = false;
		
		String sql = "UPDATE items SET description = ? WHERE item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getDescription());
			ps.setInt(2, item.getItemId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when updating an item.");
		}
		
		return success;
	}
	
	@Override
	public boolean updateItemPrice(Item item) {
		boolean success = false;
		
		String sql = "UPDATE items SET price = ? WHERE item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, item.getPrice());
			ps.setInt(2, item.getItemId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when updating an item.");
		}
		
		return success;
	}
	
	@Override
	public boolean updateItemIsOwned(Item item) {
		boolean success = false;
		
		String sql = "UPDATE items SET is_owned = ? WHERE item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, item.isOwned());
			ps.setInt(2, item.getItemId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when updating an item.");
		}
		
		return success;
	}

	@Override
	public boolean updateOfferIsAccepted(Offer offer) {
		boolean success = false;
		
		String sql = "UPDATE offers SET is_accepted = ? WHERE offer_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, offer.isAccepted());
			ps.setInt(2, offer.getOfferId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when updating an offer.");
		}
		
		return success;
	}

	@Override
	public boolean updateOfferHistoryStatus(OfferHistory oH) {
		boolean success = false;
		
		String sql = "UPDATE offer_histories SET status = ? WHERE history_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, oH.getStatus());
			ps.setInt(2, oH.getHistoryId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when updating an offer history.");
		}
		
		return success;
	}

	@Override
	public boolean updateRemainingPayments(Payment pay) {
		boolean success = false;
		
		String sql = "UPDATE payments SET payments_remaining = ? WHERE payment_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,pay.getPaymentsRemaining());
			ps.setInt(2, pay.getPaymentId());
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("");
		}
		
		return success;
	}

	@Override
	public boolean deleteCustomerById(int id) {
		boolean success = false;
		
		String sql = "DELETE FROM customers WHERE user_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when deleting a customer.");
		}
		
		return success;
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		boolean success = false;
		
		String sql = "DELETE FROM employees WHERE user_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when deleting an employee.");
		}
		
		return success;
	}

	@Override
	public boolean deleteItemById(int id) {
		boolean success = false;
		
		String sql = "DELETE FROM items WHERE item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when deleting an item.");
		}
		
		return success;
	}

	@Override
	public boolean deleteInventoryByCustomerId(int id) {
		boolean success = false;
		
		String sql = "DELETE FROM inventories WHERE customer_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when deleting a customer inventory.");
		}
		
		return success;
	}

	@Override
	public boolean deleteOffersByItemId(int id) {
		boolean success = false;
		
		String sql = "DELETE FROM offers WHERE item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when deleting offers");
		}
		
		return success;
	}

	@Override
	public boolean deleteCustomerOffer(int custId, int itemId) {
		boolean success = false;
		
		String sql = "DELETE FROM offers WHERE customer_id = ? AND item_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			ps.setInt(2, itemId);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when deleting offers");
		}
		
		return success;
	}

	@Override
	public boolean deletePaymentByCustomerId(int id) {
		boolean success = false;
		
		String sql = "DELETE FROM paymenys WHERE customer_id = ?";
		
		try (Connection conn = ShopConnection.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			success = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			LOG.error("There was an issue when deleting payments.");
		}
		
		return success;
	}

}
