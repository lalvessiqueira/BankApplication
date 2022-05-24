package com.learning.bankingapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public Customer registerCustomer(@RequestBody Customer customer) {

		customerService.register(customer);
		return customer;
	}
	
	@PostMapping("/authenticate")
	public String Authenticate(@RequestBody Customer customer) {
		return customerService.security(customer);
	}
	
	@PostMapping("/{CustId}/account")
	public Account createAccount(@PathVariable ("CustId") String CustId, @RequestBody Account account) {

		return customerService.createAccount(CustId,account);
		
	}//IF DONT WORK "ACCOUNT CANNOT BE CREATED"
	
	@PostMapping("/{CustId}/account/{AccNo}")
	public Account approveAccount(@PathVariable ("AccNo") String AccNo, @PathVariable ("CustId")String CustId, @RequestBody Account account) {

		return customerService.approveAccount(CustId,AccNo,account);
		
	}//IF DONT WORK PLEASE CHECK ACCOUNT NUMBER
	
	@GetMapping("/{CustId}/account")
	public List<Account> getAllAccountByCustId(@PathVariable("CustId") String CustId) {
		return customerService.getAllAccount(CustId);
	}
	
	@GetMapping("/{CustId}")
	public Customer getCustomerByCustId(@PathVariable("CustId") String CustId) {
		return customerService.getCustomer(CustId);
	}//"SORRY CUSTOMER WITH <ID> NOT FOUND"
	
	@PostMapping("/{CustId}")
	public Customer updateCustomer(@PathVariable ("CustId") String CustId, @RequestBody Customer customer) {

		return customerService.updateCustomer(CustId,customer);
		
	}//"SORRY CUSTOMER WITH <ID> NOT FOUND"
	
	@GetMapping("/{CustId}/account/{AccNo}")
	public Optional<Account> getAccount(@PathVariable ("AccNo") String AccNo, @PathVariable ("CustId")String CustId) {

		return customerService.getAccount(CustId,AccNo);
		
	}//"SORRY CUSTOMER WITH <ID> NOT FOUND"
	
	@PostMapping("/{CustId}/beneficiary")
	public String addBeneficiary(@PathVariable ("CustId") String CustId, @RequestBody Beneficiary beneficiary) {

			Beneficiary beneficiary2 = customerService.addBeneficiary(CustId,beneficiary);
			
			if (beneficiary2!=null)
				return "Beneficiary with "+beneficiary.getBeneficiaryAcctNo()+" added";
			else
				return
						"Beneficiary with "+beneficiary.getBeneficiaryAcctNo()+" not added";
	}
	
	@GetMapping("/{CustId}/beneficiary")
	public List<Beneficiary> getAllBeneficiaryByCustId(@PathVariable("CustId") String CustId) {
		return customerService.getAllBeneficiary(CustId);
	}
	
	@DeleteMapping("/{CustId}/beneficiary/{BenId}")
	public String deleteMobileById(@PathVariable("CustId") String CustId,@PathVariable("BenId") String BenId) {
		
		return customerService.deleteBeneficiary(CustId,BenId);
	
	}  
	
	@PostMapping("/transfer")
	public String transfer(@RequestBody ArrayList <String>list) {

		customerService.transfer(list);
		
		return list.get(3);
	}//"From/To Account Number Not Valid"
	
	@GetMapping("/{UserName}/forgot/{Question}/{Answer}")
	public String forgotPassword(@PathVariable("UserName") String userName,
			@PathVariable("Question") String question,@PathVariable("Answer") String answer)
	{
		
		return customerService.forgot(userName,question,answer);
		
	}
	
	@PutMapping("{UserName}/forgot")
	public String changePassword(@PathVariable ("UserName") String UserName, @RequestBody Customer customer) {

			return customerService.changePassword (UserName,customer);
		
	}
	
	
	
}


