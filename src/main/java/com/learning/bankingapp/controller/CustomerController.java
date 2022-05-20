package com.learning.bankingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.enums.AccountType;
import com.learning.bankingapp.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer) {

		customerService.register(customer);
		return customer;
	}
	
	@PostMapping("/authenticate")
	public void Authenticate() {}
	
	@PostMapping("/{CustId}/account")
	public Account createAccount(@PathVariable ("CustId") Long CustId, @RequestBody Account account) {

		return customerService.createAccount(CustId,account);
		
	}
	
	@PostMapping("/{CustId}/account/{AccNo}")
	public Account approveAccount(@PathVariable ("AccNo") Long AccNo, @PathVariable ("CustId")Long CustId, @RequestBody Account account) {

		return customerService.approveAccount(CustId,AccNo,account);
		
	}
	
	@GetMapping("/{CustId}/account")
	public List<Account> getAllAccountByCustId(@PathVariable("CustId") Long CustId) {
		return customerService.getAllAccount(CustId);
	}
	
	@GetMapping("/{CustId}")
	public Optional<Customer> getCustomerByCustId(@PathVariable("CustId") Long CustId) {
		return customerService.getCustomer(CustId);
	}
	
	@PostMapping("/{CustId}")
	public void updateCustomer(@PathVariable ("CustId") Long CustId, @RequestBody Customer customer) {

		customerService.updateAccount(CustId,customer);
		
	}
	
	@GetMapping("/{CustId}/account/{AccNo}")
	public Account getAccount(@PathVariable ("AccNo") Long AccNo, @PathVariable ("CustId")Long CustId) {

		return customerService.getAccount(CustId,AccNo);
		
	}
	
	@PostMapping("/{CustId}/beneficiary")
	public Beneficiary addBeneficiary(@PathVariable ("CustId") Long CustId, @RequestBody Beneficiary beneficiary) {

			return customerService.addBeneficiary(CustId,beneficiary);
		
	}
	
	@GetMapping("/{CustId}/beneficiary")
	public List<Beneficiary> getAllBeneficiaryByCustId(@PathVariable("CustId") Long CustId) {
		return customerService.getAllBeneficiary(CustId);
	}
	
	@DeleteMapping("/{CustId}/beneficiary/{BenId}")
	public void deleteMobileById(@PathVariable("CustId") Long CustId,@PathVariable("BenId") Long BenId) {
		
		customerService.deleteBeneficiary(CustId,BenId);
	
	}
	/*
	@PostMapping("/{CustId}/account/{AccNo}")
	public Account approveAccount(@PathVariable ("AccNo") Long AccNo, @PathVariable ("CustId")Long CustId, @RequestBody Account account) {

		return customerService.approveAccount(CustId,AccNo,account);
		
	}*/
}
	


