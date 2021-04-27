package com.revature.models;

public class Inventory {
	private int inventoryId;
	private int customerId;
	private int itemId;
	
	public Inventory() {
		super();
		
	}

	public Inventory(int inventoryId, int customerId, int itemId) {
		super();
		this.inventoryId = inventoryId;
		this.itemId = itemId;
		this.customerId = customerId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", itemId=" + itemId + ", customerId=" + customerId + "]";
	}

}
