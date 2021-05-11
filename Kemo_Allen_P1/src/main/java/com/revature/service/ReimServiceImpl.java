package com.revature.service;

import com.revature.repository.ReimbursementDAO;

public class ReimServiceImpl {
	
	private ReimbursementDAO rd;

	public ReimServiceImpl() {
		super();
	}
	
	public ReimServiceImpl(ReimbursementDAO rd) {
		this.rd = rd;
	}

}
