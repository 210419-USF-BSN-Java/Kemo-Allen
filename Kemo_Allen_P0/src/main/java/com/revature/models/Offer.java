package com.revature.models;

public class Offer {
	private int offerId;
	private int customerId;
	private int itemId;
	private double itemPrice;
	private String paymentType;
	private boolean accepted;
	
	public Offer() {
		super();
		
	}

	public Offer(int offerId, int customerId, int itemId, double itemPrice, String paymentType, boolean accepted) {
		super();
		this.offerId = offerId;
		this.customerId = customerId;
		this.itemId = itemId;
		this.itemPrice = itemPrice;
		this.paymentType = paymentType;
		this.accepted = accepted;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", customerId=" + customerId + ", itemId=" + itemId + ", paymentType="
				+ paymentType + ", accepted=" + accepted + "]";
	}

	

}
