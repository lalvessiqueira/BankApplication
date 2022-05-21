package com.learning.bankingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;


public interface StaffService {
	
	public Optional<Account> staffgetAccount(Long AccNo);
	public List<Beneficiary> getBeneficiaryToApproved();
	public Beneficiary approveBeneficiary(Beneficiary beneficiary);
	public List<Account> getAccountToApproved();
	public Account approveAccount(Account account);
	public List<Customer> getAllCustomer();
	public Customer enableCustomer(Customer customer);
	public Customer getCustomerById(Long CustId) ;
	public void transfer(ArrayList<String> list);
}
