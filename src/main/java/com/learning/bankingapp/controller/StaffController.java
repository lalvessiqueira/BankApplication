package com.learning.bankingapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.*;
//=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.learning.bankingapp.entity.Staff;
import com.learning.bankingapp.service.StaffService;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@PostMapping("/authenticate")
	public String Authenticate(@RequestBody Staff staff) {
		return staffService.security(staff);
	}
	
	@GetMapping("/account/{AccNo}")
	public ResponseEntity<Object> getAllAccountByCustId(@PathVariable("AccNo") String AccNo) {
		try {
			Account acc = staffService.staffgetAccount(AccNo);
			if(acc==null)
				throw new Exception();
			return ResponseEntity.accepted().body(acc);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Account not found");
		}
	}
		
	
	@GetMapping("/beneficiary")
	public ResponseEntity<Object> getAllBeneficiaryToApproved(){
		try {
		List<Beneficiary> beneficiaries = staffService.getBeneficiaryToApproved();
		return ResponseEntity.accepted().body(beneficiaries);
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body("Account not found");
		}
	}

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
	
	@GetMapping("/accounts/approve")
	public ResponseEntity<Object> getAllAccountsToApproved(){
		try {
			List<Account> accounts = staffService.getAccountToApproved();
			return ResponseEntity.accepted().body(accounts);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry benficiary not found");
		}
	}
	
	@PostMapping("/accounts/approve")
	public ResponseEntity<Object> approveAccount( @RequestBody Account accounts) {
		try {
			Account acc = staffService.approveAccount(accounts);
			return ResponseEntity.accepted().body(acc);

		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Approving of account was not succesful");

		}

	}
	
	@GetMapping("/customer")
	public ResponseEntity<Object> getAllCustomer(){
		try {
		List<Customer> customers =staffService.getAllCustomer();
		return ResponseEntity.accepted().body(customers);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("");

		}
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Object> enableCustomer( @RequestBody Customer customer) {

			try {
				Customer cus = staffService.enableCustomer(customer);
				return ResponseEntity.accepted().body(cus);
				}
				catch (Exception e) {
					return ResponseEntity.badRequest().body("Customer Status not Changed");

				}
			
	}
	
	
	@GetMapping("/customer/{CustId}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("CustId") String CustId) {
	
		try {
		Customer cus = staffService.getCustomerById(CustId);
		if(cus==null)
			throw new Exception();
		return ResponseEntity.accepted().body(cus);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Customer not found");

		}
		
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody ArrayList <String>list) {

		try {
			staffService.transfer(list);
			return ResponseEntity.accepted().body(list.get(3));
			}
			catch (Exception e) {
				return ResponseEntity.badRequest().body("From/To Account Number not Valid");
			}
		
	}
	
}

