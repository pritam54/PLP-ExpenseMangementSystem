package com.cg.ems.expenseclaim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.service.ExpenseClaimService;

@RestController
@RequestMapping("/ems")
public class ExpenseClaimController {
	
	@Autowired
	private ExpenseClaimService service;
	@Autowired
	RestTemplate template;
	
	@PostMapping(value = "/claim/addclaim",produces = "application/json",consumes = "application/json")
	public int addClaim(@RequestBody ExpenseClaim claim) {
		return service.addClaim(claim);
	}
	
	@GetMapping(value="/claim/{claimId}",produces = "application/json")
	public ExpenseClaim findClaim(@PathVariable int claimId) {
		return service.viewClaim(claimId);
	}
	
	@PutMapping(value = "/claim/modifyclaim/claimId",produces = "application/json",consumes = "application/json")
	public ExpenseClaim modifyClaim(@PathVariable int claimId,@RequestBody ExpenseClaim claim) {
		return service.modifyClaim(claimId, claim);
		
	}
	@DeleteMapping(value = "/claim/deleteclaim",produces = "application/json")
	public boolean deleteclaim(@RequestParam int claimId) {
		return service.deleteClaim(claimId);
		
	}

}
