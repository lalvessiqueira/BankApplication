package com.learning.bankingapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.*;
//=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//>>>>>>> Stashed changes

import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.service.StaffService;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin
public class StaffController {
	
	@Autowired
	StaffService staffService;

	//Get all accounts
	@GetMapping("/account/{AccNo}")
	public ResponseEntity<Object> getAllAccountByCustId(@PathVariable("AccNo") String AccNo) {
		try {
			Account acc = staffService.staffgetAccount(AccNo);
			if(acc==null)
				throw new Exception();
			return ResponseEntity.ok(acc);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Account not found");
		}
	}
		
	//get all beneficiaries
	@GetMapping("/beneficiary")
	public ResponseEntity<Object> getAllBeneficiaryToApproved(){
		try {
		List<Beneficiary> beneficiaries = staffService.getBeneficiaryToApproved();
		return ResponseEntity.ok(beneficiaries);
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body("Account not found");
		}
	}

	//approve beneficiary
	@PostMapping("/beneficiary")
	public ResponseEntity<Object> approveBeneficiary( @RequestBody Beneficiary beneficiary) {
		try {
			Beneficiary ben= staffService.approveBeneficiary(beneficiary);
			return ResponseEntity.accepted().body(ben);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry benficiary not found");
		}
		
	}
	
	//get all account that need approved
	@GetMapping("/accounts/approve")
	public ResponseEntity<Object> getAllAccountsToApproved(){
		try {
			List<Account> accounts = staffService.getAccountToApproved();
			return ResponseEntity.ok(accounts);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry benficiary not found");
		}
	}
	
	//Approve account
	@PostMapping("/accounts/approve")
	public ResponseEntity<Object> approveAccount( @RequestBody Account accounts) {
		try {
			Account acc = staffService.approveAccount(accounts);
			return ResponseEntity.ok(acc);

		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Approving of account was not succesful");

		}

	}
	
	//get all customers
	@GetMapping("/customer")
	public ResponseEntity<Object> getAllCustomer(){
		try {
		List<Customer> customers =staffService.getAllCustomer();
		return ResponseEntity.ok(customers);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("");

		}
	}
	
	//enable customer
	@PostMapping("/customer")
	public ResponseEntity<Object> enableCustomer( @RequestBody Customer customer) {

			try {
				Customer cus = staffService.enableCustomer(customer);
				return ResponseEntity.ok(cus);
				}
				catch (Exception e) {
					return ResponseEntity.badRequest().body("Customer Status not Changed");

				}
			
	}
	
	//get customer by ID
	@GetMapping("/customer/{CustId}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("CustId") String CustId) {
	
		try {
		Customer cus = staffService.getCustomerById(CustId);
		if(cus==null)
			throw new Exception();
		return ResponseEntity.ok(cus);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Customer not found");

		}
		
	}
	
	//transfer money from one account to another
	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody ArrayList <String>list) {

		try {
			staffService.transfer(list);
			return ResponseEntity.ok("Transaction completed");
			}
			catch (Exception e) {
				return ResponseEntity.badRequest().body("From/To Account Number not Valid");
			}
		
	}
	
	//logout
	@PostMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/register";
	}
	
}

