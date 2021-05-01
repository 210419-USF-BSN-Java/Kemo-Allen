package com.revature.models;

public class Inventory {
	private int inventoryId;
	private int customerId;
	private String itemName;
	private String description;
	
	public Inventory() {
		super();
		
	}

	public Inventory(int inventoryId, int customerId, String itemName, String description) {
		super();
		this.inventoryId = inventoryId;
		this.customerId = customerId;
		this.itemName = itemName;
		this.description = description;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", customerId=" + customerId + ", itemName=" + itemName
				+ ", description=" + description + "]";
	}
	
	

}
