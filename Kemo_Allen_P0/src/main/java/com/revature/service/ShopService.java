package com.revature.service;

import com.revature.repository.ShopDAO;

public class ShopService {

	private ShopDAO sDao;
	
	public ShopService(ShopDAO sDao) {
		super();
		this.sDao = sDao;
	}
}
