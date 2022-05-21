package com.learning.bankingapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.service.CustomerService;
import com.learning.bankingapp.service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@PostMapping("/authenticate")
	public void Authenticate() {}
	
	@GetMapping("/account/{AccNo}")
	public Optional<Account> getAllAccountByCustId(@PathVariable("AccNo") Long AccNo) {
		return staffService.staffgetAccount(AccNo);
	}//"ACCOUNT NOT FOUND"
	
	@GetMapping("/beneficiary")
	public List<Beneficiary> getAllBeneficiaryToApproved(){
		return staffService.getBeneficiaryToApproved();
	}

	@PostMapping("/beneficiary")
	public Beneficiary approveBeneficiary( @RequestBody Beneficiary beneficiary) {

			return staffService.approveBeneficiary(beneficiary);
	}//"SORRY BENEFICIARY NOT APPROVED"
	
	@GetMapping("/accounts/approve")
	public List<Account> getAllAccountsToApproved(){
		return staffService.getAccountToApproved();
	}
	
	@PostMapping("/accounts/approve")
	public Account approveAccount( @RequestBody Account accounts) {

			return staffService.approveAccount(accounts);
	}//"APPROVING OF ACCOUNT WAS NOT SUCCESFULL"
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		
		return staffService.getAllCustomer();
		
	}
	
	@PostMapping("/customer")
	public Customer enableCustomer( @RequestBody Customer customer) {

			return staffService.enableCustomer(customer);
			
	}//"CUSTOMER STATUS NOT CHANGED"
	
	
	@GetMapping("/customer/{CustId}")
	public Customer getCustomerById(@PathVariable("CustId") Long CustId) {
		return staffService.getCustomerById(CustId);
	}//"CUSTOMER NOT FOUND"
	
	@PostMapping("/transfer")
	public String transfer(@RequestBody ArrayList <String>list) {

		staffService.transfer(list);
		
		return list.get(3);
	}//"FROM/TO ACCOUNT NUMBER NOT VALID"
	
}
