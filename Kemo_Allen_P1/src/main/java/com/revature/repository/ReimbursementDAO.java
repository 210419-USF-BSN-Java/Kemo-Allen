package com.revature.repository;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement selectReimbursement();
	List<Reimbursement> selectAllReimbursements();
	
	boolean insertReimbursement();
	
	boolean updateReimbursement();
	
	boolean deleteReimbursement();

}
