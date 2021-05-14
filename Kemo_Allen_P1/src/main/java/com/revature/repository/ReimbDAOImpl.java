package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;

public class ReimbDAOImpl implements ReimbursementDAO{

	private final Logger LOG = Logger.getLogger(ReimbDAOImpl.class);
	//private static ERSConnection conn = new ERSConnection();
	
	public ReimbDAOImpl() {
		super();
	}

	@Override
	public Reimbursement selectReimbursementById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByAuthor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByResolver(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByStatus(int status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertReimbursement(Reimbursement reimb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReimbursementById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
