package com.revature.models;

public class Offer {
	private int offerId;
	private int customerId;
	private int itemId;
	private boolean accepted;
	
	public Offer() {
		super();
		
	}

	public Offer(int offerId, int customerId, int itemId, boolean accepted) {
		super();
		this.offerId = offerId;
		this.customerId = customerId;
		this.itemId = itemId;
		this.accepted = accepted;
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
		return "Offer [offerId=" + offerId + ", customerId=" + customerId + ", itemId=" + itemId + ", accepted="
				+ accepted + "]";
	}

}
