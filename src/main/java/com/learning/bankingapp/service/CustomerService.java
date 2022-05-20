package com.learning.bankingapp.service;

import java.util.List;
import java.util.Optional;

import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.enums.AccountType;

public interface CustomerService {

	public void register(Customer customer);
	public Account createAccount(Long CustId, Account account1);
	public Account approveAccount(Long CustId, Long AccNo,Account account);
	public List<Account> getAllAccount(Long CustId);
	public Optional<Customer> getCustomer(Long CustId);
	public void updateAccount(Long CustId,Customer customer);
	public Account getAccount(Long CustId,Long AccNo);
	public Beneficiary addBeneficiary(Long CustId,Beneficiary beneficiary);
	public List<Beneficiary> getAllBeneficiary(Long CustId);
	public void deleteBeneficiary(Long CustId,Long BenId);
	
	
}
