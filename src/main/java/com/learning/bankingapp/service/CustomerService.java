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
	public Account createAccount(String CustId, Account account1);
	public Account approveAccount(String CustId, String AccNo,Account account);
	public List<Account> getAllAccount(String CustId);
	public Customer getCustomer(String CustId);
	public Customer getCustomerFromUsername(String username);
	public Customer updateCustomer(String CustId,Customer customer);
	public Account getAccount(String CustId,String AccNo);
	public Beneficiary addBeneficiary(String CustId,Beneficiary beneficiary);
	public List<Beneficiary> getAllBeneficiary(String CustId);
	public String deleteBeneficiary(String CustId,String BenId);
	public void transfer(ArrayList<String> list);
	public String forgot(String userName, String question, String answer);
	public String changePassword (String UserName,Customer customer);
	
	
	
	
}
