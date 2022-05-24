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
//>>>>>>> Stashed changes

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
	
	@PostMapping("/register")
	public ResponseEntity<Object> registerCustomer(@RequestBody Customer customer) {
		
		try {
		customerService.register(customer);
		return ResponseEntity.accepted().body(customer);
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body("User Name in use");
		}
		}
	
	@PostMapping("/authenticate")
	public String Authenticate(@RequestBody Customer customer) {
		return customerService.security(customer);
	}
	
	@PostMapping("/{CustId}/account")
	public ResponseEntity<Object> createAccount(@PathVariable ("CustId") String CustId, @RequestBody Account account) {
		
		try {
		Account acc = customerService.createAccount(CustId,account);
		return ResponseEntity.accepted().body(acc);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account cannot be created");
		}
	}
	
	@PostMapping("/{CustId}/account/{AccNo}")
	public ResponseEntity<Object> approveAccount(@PathVariable ("AccNo") String AccNo, @PathVariable ("CustId")String CustId, @RequestBody Account account) {

		try {
		Account acc = customerService.approveAccount(CustId,AccNo,account);
		return ResponseEntity.accepted().body(acc);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Please check account number");
		}
	}
	
	@GetMapping("/{CustId}/account")
	public ResponseEntity<Object> getAllAccountByCustId(@PathVariable("CustId") String CustId) {
		
		try {
		List<Account> accounts = customerService.getAllAccount(CustId);
		return ResponseEntity.accepted().body(accounts);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Please check customer ID");
		}
	}
	
	@GetMapping("/{CustId}")
	public ResponseEntity<Object> getCustomerByCustId(@PathVariable("CustId") String CustId) {
		try {
		Customer cus = customerService.getCustomer(CustId);
		if(cus==null)
			throw new Exception();
		return ResponseEntity.accepted().body(cus);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry Customer with "+CustId+" not found");
		}
	}

	@GetMapping("/username/{Username}")
	public ResponseEntity<Object> getCustomerByUsername(@PathVariable("Username") String username) {
		try {
			Customer cus = customerService.getCustomerFromUsername(username);
			if(cus==null)
				throw new Exception();
			return ResponseEntity.accepted().body(cus);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry Customer with "+username+" not found");
		}
	}
	
	@PostMapping("/{CustId}")
	public ResponseEntity<Object> updateCustomer(@PathVariable ("CustId") String CustId, @RequestBody Customer customer) {
		try {
		Customer cus = customerService.updateCustomer(CustId,customer);
		return ResponseEntity.accepted().body(cus);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry Customer with "+CustId+" not found");
		}
	}

	
	@GetMapping("/{CustId}/account/{AccNo}")
	public ResponseEntity<Object> getAccount(@PathVariable ("AccNo") String AccNo, @PathVariable ("CustId")String CustId) {

		try {
		Account account = customerService.getAccount(CustId,AccNo);
		if(account==null)
			throw new Exception();
		return ResponseEntity.accepted().body(account);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry account not found");
		}
		
	}
	
	@PostMapping("/{CustId}/beneficiary")
	public ResponseEntity<String> addBeneficiary(@PathVariable ("CustId") String CustId, @RequestBody Beneficiary beneficiary) {
			try {
			Beneficiary beneficiary2 = customerService.addBeneficiary(CustId,beneficiary);
			if (beneficiary2!=null)
				return ResponseEntity.accepted().body("Beneficiary with "+beneficiary.getBeneficiaryAcctNo()+" added");
			else
				throw new Exception(); 
			}
			catch(Exception e) {
		
			return ResponseEntity.badRequest().body("Sorry Beneficiary with "+beneficiary.getBeneficiaryAcctNo()+" not added");
	
			}
	}
			
	
	@GetMapping("/{CustId}/beneficiary")
	public ResponseEntity<Object> getAllBeneficiaryByCustId(@PathVariable("CustId") String CustId) {
		try {
		List<Beneficiary> beneficiaries = customerService.getAllBeneficiary(CustId);
		return ResponseEntity.accepted().body(beneficiaries);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Sorry Customer with "+CustId+" not found");
		}
		
	}
	
	@DeleteMapping("/{CustId}/beneficiary/{BenId}")
	public ResponseEntity<String> deleteMobileById(@PathVariable("CustId") String CustId,@PathVariable("BenId") String BenId) {
		try {
		String msg = customerService.deleteBeneficiary(CustId,BenId);
		return ResponseEntity.accepted().body(msg);
		}
		catch (Exception e) {
		return ResponseEntity.badRequest().body("Check Input");

		}
	}  
	
	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody ArrayList <String>list) {
		
		try {
		customerService.transfer(list);
		return ResponseEntity.accepted().body(list.get(3));
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("From/To Account Number not Valid");
		}
	}
	
	@GetMapping("/{UserName}/forgot/{Question}/{Answer}")
	public ResponseEntity<String> forgotPassword(@PathVariable("UserName") String userName,
			@PathVariable("Question") String question,@PathVariable("Answer") String answer)
	{
		
		try {
			return ResponseEntity.accepted().body(customerService.forgot(userName,question,answer));
			}
			catch (Exception e) {
				return ResponseEntity.badRequest().body("Sorry Customer with "+userName+" not found");
			}
	}

	@PutMapping("{UserName}/forgot")
	public ResponseEntity<String> changePassword(@PathVariable ("UserName") String UserName, @RequestBody Customer customer) {
		try {
			
			return ResponseEntity.accepted().body(customerService.changePassword(UserName,customer));
		}

			catch(Exception e) {
				return ResponseEntity.badRequest().body("Sorry password not updated");
			}
		
	}
	
	
	
}
