package com.cg.ems.expenseclaim.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;

@Repository
public class ExpenseClaimDaoImpl implements ExpenseClaimDao {
	
	@Autowired
	private EntityManager mgr;

	@Override
	public int addClaim(ExpenseClaim claim) {
		mgr.persist(claim);
		return claim.getClaimId();
	}

	@Override
	public ExpenseClaim viewClaim(int claimId) throws ExpenseClaimNotFound {
		ExpenseClaim claim = mgr.find(ExpenseClaim.class, claimId);
		if (claim==null) {
			throw new ExpenseClaimNotFound("Expense Claim With the Following Id NO Found:"+claimId);
		}
		return claim;
	}

	@Override
	public ExpenseClaim modifyClaim(ExpenseClaim claim) {
		//ExpenseClaim initialClaim = mgr.find(ExpenseClaim.class, claimId);
		//System.out.println(initialClaim);
		mgr.merge(claim);
		return claim;
	}

	@Override
	public boolean deleteClaim(int claimId) {
		
		ExpenseClaim deleteClaim=mgr.find(ExpenseClaim.class, claimId);
		if (deleteClaim==null) {
			return false;
		}else {
		mgr.remove(deleteClaim);
		return true;
		}
	}

	@Override
	public List<ExpenseClaim> getAllClaims() {
		// TODO Auto-generated method stub
		return null;
	}


}
