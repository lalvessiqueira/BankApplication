package com.learning.bankingapp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.bankingapp.Repo.AccountRepo;
import com.learning.bankingapp.Repo.BeneficiaryRepo;
import com.learning.bankingapp.Repo.CustomerRepo;
import com.learning.bankingapp.repo.StaffRepo;
import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.entity.Staff;
import com.learning.bankingapp.entity.Transaction;
import com.learning.bankingapp.enums.TransactionType;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;
	
	@Autowired
	private StaffRepo staffRepo;
	
	@Override
	public String security(Staff staff1) {
		
		Staff staff2 = staffRepo.findBystaffId(staff1.getStaffId());
		
		if (staff2.getUsername().equals(staff1.getUsername()) &&
				staff2.getPassword().equals(staff1.getPassword()) ) {
			return "good to go";
		}
		else
			return "Not correct";
		
	}

	@Override
	public Account staffgetAccount(String AccNo) {
		
		Account account = accountRepo.findByAccountNumber(AccNo);
		return account;
	
	}

	@Override
	public List<Beneficiary> getBeneficiaryToApproved() {
		
		List<Beneficiary> beneficiaries = new ArrayList<>();
		List<Beneficiary> toApprove = new ArrayList<>();
		
		beneficiaries = beneficiaryRepo.findAll();
		
		for(int i=0;i<beneficiaries.size();i++) {
			
			if(beneficiaries.get(i).getApproved().equalsIgnoreCase("no"))
				
				toApprove.add(beneficiaries.get(i));
		}
		
		return toApprove;

		
	}

	@Override
	public Beneficiary approveBeneficiary(Beneficiary beneficiary1) {
		
		Beneficiary beneficiary2 = beneficiaryRepo.getById(beneficiary1.getBId());
		
		beneficiary2.setApproved(beneficiary1.getApproved());
		
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
		account2.setAproverName(account1.getAproverName());
		
		return accountRepo.save(account2);
	}

	@Override
	public List<Customer> getAllCustomer() {

		return customerRepo.findAll();
	}

	@Override
	public Customer enableCustomer(Customer customer1) {

		Customer customer2 = customerRepo.findBycustomerId(customer1.getCustomerId());
		
		customer2.setStatus(customer1.getStatus());
			
			return customerRepo.save(customer2);

	}

	@Override
	public Customer getCustomerById(String CustId) {
		
		Customer customer = customerRepo.findBycustomerId(CustId);
		
		return customer;
	}

	@Override
	public void transfer(ArrayList<String> list) throws Exception {
		
		Date currentDate = Calendar.getInstance().getTime();

		String fromAccNumber = list.get(0);
		String toAccNumber =  list.get(1);
		double amount= Double.parseDouble(list.get(2));
		
		if(!fromAccNumber.equals(toAccNumber)) {
		
		Account accountTo  = accountRepo.getById(toAccNumber);
		Account accountFrom = accountRepo.getById(fromAccNumber);
		
		double balanceTo = accountTo.getAccountBalance();
		double balanceFrom = accountFrom.getAccountBalance();
		
		if (balanceFrom>=amount) {
			
			Transaction transaction1 = new Transaction();
			
			transaction1.setAmount(amount);
			transaction1.setType(TransactionType.DEBIT);;
			transaction1.setReference(list.get(3));
			transaction1.setTransactionDate(currentDate);
			transaction1.setAccNo(fromAccNumber);
			transaction1.setTransactionBy("Staff");
			
			accountFrom.setAccountBalance(balanceFrom-amount);
			accountFrom.getTransactions().add(transaction1);
			
			Transaction transaction2 = new Transaction();
			
			transaction2.setAmount(amount*-1);
			transaction2.setType(TransactionType.DEBIT);;
			transaction2.setReference(list.get(3));
			transaction2.setTransactionDate(currentDate);
			transaction2.setAccNo(toAccNumber);
			transaction2.setTransactionBy("Staff");
			
			accountTo.setAccountBalance(balanceTo+amount);
			accountTo.getTransactions().add(transaction2);
			
			accountRepo.save(accountFrom);
			accountRepo.save(accountTo);
		}
		
		}
		else 
			throw new Exception();
		
	}


}
