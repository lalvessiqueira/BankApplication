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
//>>>>>>> Stashed changes
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	//Create Account using customer ID
	@PostMapping("/{CustId}/account")
	public ResponseEntity<Object> createAccount(@PathVariable ("CustId") String CustId, @RequestBody Account account) {
		
		try {
		Account acc = customerService.createAccount(CustId,account);
		return ResponseEntity.ok(acc);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account cannot be created");
		}
	}
	
	//Approve account- Used by Staff
	@PostMapping("/{CustId}/account/{AccNo}")
	public ResponseEntity<Object> approveAccount(@PathVariable ("AccNo") String AccNo, @PathVariable ("CustId")String CustId, @RequestBody Account account) {

		try {
		Account acc = customerService.approveAccount(CustId,AccNo,account);
		return ResponseEntity.ok(acc);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Please check account number");
		}
	}
	
	//get All accounts by Customer ID
	@GetMapping("/{CustId}/account")
	public ResponseEntity<Object> getAllAccountByCustId(@PathVariable("CustId") String CustId) {
		
		try {
		List<Account> accounts = customerService.getAllAccount(CustId);
		return ResponseEntity.ok(accounts);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Please check customer ID");
		}
	}
	
	//get Customer by ID
	@GetMapping("/{CustId}")
	public ResponseEntity<Object> getCustomerByCustId(@PathVariable("CustId") String CustId) {
		try {
		Customer cus = customerService.getCustomer(CustId);
		if(cus==null)
			throw new Exception();
		return ResponseEntity.ok(cus);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry Customer with "+CustId+" not found");
		}
	}

	//Get Customer by user name
	@GetMapping("/username/{Username}")
	public ResponseEntity<Object> getCustomerByUsername(@PathVariable("Username") String username) {
		try {
			Customer cus = customerService.getCustomerFromUsername(username);
			if(cus==null)
				throw new Exception();
			return ResponseEntity.ok(cus);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry Customer with "+username+" not found");
		}
	}
	
	//Update Customer by ID
	@PostMapping("/{CustId}")
	public ResponseEntity<Object> updateCustomer(@PathVariable ("CustId") String CustId, @RequestBody Customer customer) {
		try {
		Customer cus = customerService.updateCustomer(CustId,customer);
		return ResponseEntity.ok(cus);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry Customer with "+CustId+" not found");
		}
	}

	//Get Account 
	@GetMapping("/{CustId}/account/{AccNo}")
	public ResponseEntity<Object> getAccount(@PathVariable ("AccNo") String AccNo, @PathVariable ("CustId")String CustId) {

		try {
		Account account = customerService.getAccount(CustId,AccNo);
		if(account==null)
			throw new Exception();
		return ResponseEntity.ok(account);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry account not found");
		}
		
	}
	
	// Add Beneficiary
	@PostMapping("/{CustId}/beneficiary")
	public ResponseEntity<String> addBeneficiary(@PathVariable ("CustId") String CustId, @RequestBody Beneficiary beneficiary) {
			try {
			Beneficiary beneficiary2 = customerService.addBeneficiary(CustId,beneficiary);
			if (beneficiary2!=null)
				return ResponseEntity.ok("Beneficiary with "+beneficiary.getBeneficiaryAcctNo()+" added");
			else
				throw new Exception(); 
			}
			catch(Exception e) {
		
			return ResponseEntity.badRequest().body("Sorry Beneficiary with "+beneficiary.getBeneficiaryAcctNo()+" not added");
	
			}
	}
			
	//get all beneficiary
	@GetMapping("/{CustId}/beneficiary")
	public ResponseEntity<Object> getAllBeneficiaryByCustId(@PathVariable("CustId") String CustId) {
		try {
		List<Beneficiary> beneficiaries = customerService.getAllBeneficiary(CustId);
		return ResponseEntity.ok(beneficiaries);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry Customer with "+CustId+" not found");
		}
		
	}
	
	//Delete Beneficiary
	@DeleteMapping("/{CustId}/beneficiary/{BenId}")
	public ResponseEntity<String> deleteMobileById(@PathVariable("CustId") String CustId,@PathVariable("BenId") String BenId) {
		try {
		String msg = customerService.deleteBeneficiary(CustId,BenId);
		return ResponseEntity.ok(msg);
		}
		catch (Exception e) {
		return ResponseEntity.badRequest().body("Check Input");

		}
	}  
	
	//Transactions between to different accounts
	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody ArrayList <String>list){
		
		try {
		customerService.transfer(list);
		return ResponseEntity.ok("Transaction completed");
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("From/To Account Number not Valid");
		}
	}
	
	//Validate details to change password
	@GetMapping("/{UserName}/forgot/{Question}/{Answer}")
	public ResponseEntity<String> forgotPassword(@PathVariable("UserName") String userName,
			@PathVariable("Question") String question,@PathVariable("Answer") String answer)
	{
		
		try {
			return ResponseEntity.ok(customerService.forgot(userName,question,answer));
			}
			catch (Exception e) {
				return ResponseEntity.badRequest().body("Sorry Customer with "+userName+" not found");
			}
	}
/*
	//Change Password
	@PostMapping("{UserName}/forgot")
	public ResponseEntity<String> changePassword(@PathVariable ("UserName") String UserName, @RequestBody Customer customer) {
		try {
			
			return ResponseEntity.ok(customerService.changePassword(UserName,customer));
		}

			catch(Exception e) {
				return ResponseEntity.badRequest().body("Sorry password not updated");
			}
		
	}*/
	
	@PostMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/register";
	}
	
	
	
}
