package com.revature.models;

public class OfferHistory {
	private int historyId;
	private int customerId;
	private int itemId;
	private int offerId;
	private String status;
	
	public OfferHistory() {
		super();
		
	}

	public OfferHistory(int historyId, int customerId, int itemId, int offerId, String status) {
		super();
		this.historyId = historyId;
		this.customerId = customerId;
		this.itemId = itemId;
		this.offerId = offerId;
		this.status = status;
	}
	
	public int getHistoryId() {
		return historyId;
	}
	
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OfferHistory [offerId=" + offerId + ", customerId=" + customerId + ", itemId=" + itemId + ", status="
				+ status + "]";
	}

}
