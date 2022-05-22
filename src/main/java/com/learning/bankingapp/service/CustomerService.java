package com.learning.bankingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;

public interface CustomerService {

	public void register(Customer customer);
	public String security(Customer customer);
	public Account createAccount(Long CustId, Account account1);
	public Account approveAccount(Long CustId, Long AccNo,Account account);
	public List<Account> getAllAccount(Long CustId);
	public Customer getCustomer(Long CustId);
	public Customer updateCustomer(Long CustId,Customer customer);
	public Optional<Account> getAccount(Long CustId,Long AccNo);
	public Beneficiary addBeneficiary(Long CustId,Beneficiary beneficiary);
	public List<Beneficiary> getAllBeneficiary(Long CustId);
	public String deleteBeneficiary(Long CustId,Long BenId);
	public void transfer(ArrayList<String> list);
	public String forgot(String userName);
	public String changePassword (String UserName,Customer customer);
	
	
	
	
}
