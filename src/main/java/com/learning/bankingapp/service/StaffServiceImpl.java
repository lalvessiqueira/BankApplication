package com.learning.bankingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.bankingapp.Repo.AccountRepo;
import com.learning.bankingapp.Repo.BeneficiaryRepo;
import com.learning.bankingapp.Repo.CustomerRepo;
import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;

	@Override
	public Optional<Account> staffgetAccount(Long AccNo) {
		
		return accountRepo.findById(AccNo);
	
	}

	@Override
	public List<Beneficiary> getBeneficiaryToApproved() {
		
		List<Beneficiary> beneficiaries = new ArrayList<>();
		List<Beneficiary> toApprove = new ArrayList<>();
		
		beneficiaries = beneficiaryRepo.findAll();
		
		for(int i=0;i<beneficiaries.size();i++) {
			
			if(beneficiaries.get(i).getValid().equalsIgnoreCase("no"))
				
				toApprove.add(beneficiaries.get(i));
		}
		
		return toApprove;

		
	}

	@Override
	public Beneficiary approveBeneficiary(Beneficiary beneficiary1) {
		
		Beneficiary beneficiary2 = beneficiaryRepo.getById(beneficiary1.getBId());
		
		beneficiary2.setValid(beneficiary1.getValid());
		
		return beneficiaryRepo.save(beneficiary2);
		
	}

	@Override
	public List<Account> getAccountToApproved() {

		List<Account> accounts = new ArrayList<>();
		List<Account> toApprove = new ArrayList<>();
		
		 accounts = accountRepo.findAll();
		
		for(int i=0;i<accounts.size();i++) {
			
			if(accounts.get(i).getApproved().equalsIgnoreCase("no"))
				
				toApprove.add(accounts.get(i));
		}
		
		return toApprove;
		
	}

	@Override
	public Account approveAccount(Account account1) {
		Account account2 = accountRepo.getById(account1.getAccountNumber());
		
	account2.setApproved(account1.getApproved());
		
		return accountRepo.save(account2);
	}

	@Override
	public List<Customer> getAllCustomer() {

		return customerRepo.findAll();
	}

	@Override
	public Customer enableCustomer(Customer customer1) {

		Customer customer2 = customerRepo.getById(customer1.getUid());
		
		//customer2.setApproved(customer1.getApproved());
			
			return customerRepo.save(customer2);

	}

	@Override
	public Optional<Customer> getCustomerById(Long CustId) {
		
		return customerRepo.findById(CustId);
	}

	@Override
	public void transfer(ArrayList<String> list) {

		Long fromAccNumber = Long.parseLong(list.get(0));
		Long toAccNumber =  Long.parseLong(list.get(1));
		double amount= Double.parseDouble(list.get(2));
		
		if(fromAccNumber!=toAccNumber) {
		
		Account accountTo  = accountRepo.getById(toAccNumber);
		Account accountFrom = accountRepo.getById(fromAccNumber);
		
		double balance=accountFrom.getAccountBalance();
		
		if (balance>=amount) {
			accountFrom.setAccountBalance(balance-amount);
			accountTo.setAccountBalance(balance+amount);
			
			accountRepo.save(accountFrom);
			accountRepo.save(accountTo);
		}
		}
		
	}
	
	

}
