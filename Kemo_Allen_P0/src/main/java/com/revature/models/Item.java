package com.revature.models;

public class Item {
	private int itemId;
	private String name;
	private String description;
	private double price;
	private boolean owned;
	
	public Item() {
		super();
		
	}

	public Item(int itemId, String name, String description, double price, boolean owned) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.owned = owned;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isOwned() {
		return owned;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", owned=" + owned + "]";
	}
	
}
