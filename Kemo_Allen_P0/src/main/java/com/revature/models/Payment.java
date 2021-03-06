package com.revature.models;

public class Payment {
	private int paymentId;
	private int customerId;
	private int itemId;
	private double itemPrice;
	private double rate;
	private int numberOfPayments;
	private int paymentsRemaining;
	
	public Payment() {
		super();
		
	}
	
	public Payment(int paymentId, int customerId, int itemId, double itemPrice, double rate, int numberOfPayments,
			int paymentsRemaining) {
		super();
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.itemId = itemId;
		this.itemPrice = itemPrice;
		this.rate = rate;
		this.numberOfPayments = numberOfPayments;
		this.paymentsRemaining = paymentsRemaining;
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getNumberOfPayments() {
		return numberOfPayments;
	}
	public void setNumberOfPayments(int numberOfPayments) {
		this.numberOfPayments = numberOfPayments;
	}
	public int getPaymentsRemaining() {
		return paymentsRemaining;
	}
	public void setPaymentsRemaining(int paymentsRemaining) {
		this.paymentsRemaining = paymentsRemaining;
	}
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", customerId=" + customerId + ", itemId=" + itemId + ", itemPrice="
				+ itemPrice + ", rate=" + rate + ", numberOfPayments=" + numberOfPayments + ", paymentsRemaining="
				+ paymentsRemaining + "]";
	}
	
}
