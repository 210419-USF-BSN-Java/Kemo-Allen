package com.revature.models;

public class OfferHistory {
	private int historyId;
	private int customerId;
	private int itemId;
	private String paymentType;
	private String status;
	
	public OfferHistory() {
		super();
		
	}

	public OfferHistory(int historyId, int customerId, int itemId, String paymentType, String status) {
		super();
		this.historyId = historyId;
		this.customerId = customerId;
		this.itemId = itemId;
		this.paymentType = paymentType;
		this.status = status;
	}
	
	public int getHistoryId() {
		return historyId;
	}
	
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OfferHistory [historyId=" + historyId + ", customerId=" + customerId
				+ ", itemId=" + itemId + ", paymentType=" + paymentType + ", status=" + status + "]";
	}

}
