package com.learning.bankingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.entity.Staff;


public interface StaffService {
	
	public String security(Staff staff1);
	public Account staffgetAccount(String AccNo);
	public List<Beneficiary> getBeneficiaryToApproved();
	public Beneficiary approveBeneficiary(Beneficiary beneficiary);
	public List<Account> getAccountToApproved();
	public Account approveAccount(Account account);
	public List<Customer> getAllCustomer();
	public Customer enableCustomer(Customer customer);
	public Customer getCustomerById(String CustId) ;
	public void transfer(ArrayList<String> list);
}
