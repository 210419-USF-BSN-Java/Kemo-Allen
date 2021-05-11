package com.revature.models;

import java.io.Serializable;

public class Reimbursement implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private double reimbAmount;
	private boolean reimbSubmitted;
	private boolean reimbResolved;
	private String reimbDescription;
	//receipt
}
