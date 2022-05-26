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
import com.learning.bankingapp.entity.Account;
import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.entity.Transaction;
import com.learning.bankingapp.enums.AccountType;
import com.learning.bankingapp.enums.TransactionType;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public void register(Customer customer) {
		
		customerRepo.save(customer);
		String[] Name = customer.getFullName().split("\\s");
		if(Name.length>1)
			customer.setCustomerId("C"+(Name[0].substring(0,1)+Name[1].substring(0,1)).toUpperCase()+"_"+customer.getUid());
		else
			customer.setCustomerId("C"+(Name[0].substring(0,1)+Name[0].substring(1,2)).toUpperCase()+"_"+customer.getUid());

		customerRepo.save(customer);
	}

	@Override
	public String security(Customer customer1) {
		
		Customer customer2 = customerRepo.findByusername(customer1.getUsername());
		if (customer2 != null) {
			if (customer2.getUsername().equals(customer1.getUsername()) &&
					customer2.getPassword().equals(customer1.getPassword())) {
				return "good to go";
			} else
				return "Not correct";
		}
		return "Customer not found";
	}
	
	@Override
	public Account createAccount(String CustId, Account account1)  {

		Date currentDate = Calendar.getInstance().getTime();
		
		Customer customer = customerRepo.findBycustomerId(CustId);
		Account account2= new Account();
	
			
		account2.setAccountType(account1.getAccountType());
		account2.setAccountBalance(account1.getAccountBalance());
		account2.setDateOfCreation(currentDate);
		account2.setCustomerId(customer.getCustomerId());
		account2.setCustomerName(customer.getFullName());
		
		customer.getAccounts().add(account2);
				
		 Long N = Long.parseLong(customer.getUid());
		 N = N*100+111+customer.getAccounts().size();
	     String number= String.format("%09d", N);
		
		account2.setAccountNumber(number);
		
		customerRepo.save(customer);
	
	 return account2;
	}
	

	@Override
	public Account approveAccount(String CustId, String AccNo, Account account1) {
		
		Account account2 = accountRepo.getById(AccNo);
		
		if (account2.getCustomerId().equals(CustId)) {
			
			account2.setApproved(account1.getApproved());
			return accountRepo.save(account2);
			
		}
		
		return null;
		
	}

	@Override
	public List<Account> getAllAccount(String CustId) {

		Customer customer = customerRepo.findBycustomerId(CustId);
		return customer.getAccounts();
	}

	@Override
	public Customer getCustomer(String CustId) {
		Customer customer = customerRepo.findBycustomerId(CustId);
		return customer;
	}

	@Override
	public Customer getCustomerFromUsername(String username) {
		Customer customer = customerRepo.findByusername(username);
		return customer;
	}

	@Override
	public Customer updateCustomer(String CustId, Customer customer1) {
		
		Customer customer2 = customerRepo.findBycustomerId(CustId);
	
		customer2.setFullName(customer1.getFullName());
		customer2.setPhone(customer1.getPhone());
		customer2.setStateID(customer1.getStateID());
		customer2.setSecretQuestion(customer1.getSecretQuestion());
		customer2.setSecretAnswer(customer1.getSecretAnswer());
		customer2.setSSN(customer1.getSSN());
		
		return customerRepo.save(customer2);
	
	}

	@Override
	public Account getAccount(String CustId, String AccNo) {
		
		Account account = accountRepo.findByAccountNumber(AccNo);
		
		return account;
		
	}

	@Override
	public Beneficiary addBeneficiary(String CustId, Beneficiary beneficiary1) {
		
		Date currentDate = Calendar.getInstance().getTime();
		
		Customer customer = customerRepo.findBycustomerId(CustId);
		Beneficiary beneficiary2= new Beneficiary();
		
	    int SIZE = customer.getAccounts().size();
	    
		
		for (int i =0; i<SIZE; i++) {
		
			if(customer.getAccounts().get(i).getAccountNumber().equals(beneficiary1.getBeneficiaryAcctNo())) {
				
				beneficiary2.setBeneficiaryAcctNo(beneficiary1.getBeneficiaryAcctNo());
			    beneficiary2.setAccountType(beneficiary1.getAccountType());
			    beneficiary2.setBeneficiaryName(beneficiary1.getBeneficiaryName());
			    beneficiary2.setDateAdded(currentDate);
			    beneficiary2.setCustomerId(customer.getCustomerId());
			    
			    customer.getBeneficiaries().add(beneficiary2);
			    
			    customerRepo.save(customer);
			   
			    return beneficiary2;
			}
		}
		
		return null;
		
	}

	@Override
	public List<Beneficiary> getAllBeneficiary(String CustId) {
		
		Customer customer = customerRepo.findBycustomerId(CustId);
		return customer.getBeneficiaries();
	}

	@Override
	public String deleteBeneficiary(String CustId, String BenId) {
		
		Customer customer = customerRepo.findBycustomerId(CustId);

	    int SIZE = customer.getBeneficiaries().size();
		
		for (int i =0; i<SIZE; i++) {
		
			if(customer.getBeneficiaries().get(i).getBId().equals(BenId)) {
				
				customer.getBeneficiaries().remove(i);
				beneficiaryRepo.deleteById(BenId);
		
				return "Beneficiary Deleted Succesfully";
			}
			}
		return "Beneficiary not Deleted";
	
	}

	@Override
	public void transfer(ArrayList<String> list) throws Exception  {
		
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
			transaction1.setTransactionBy("Customer");

			accountFrom.setAccountBalance(balanceFrom-amount);
			accountFrom.getTransactions().add(transaction1);
			
			Transaction transaction2 = new Transaction();
			
			transaction2.setAmount(amount*-1);
			transaction2.setType(TransactionType.DEBIT);;
			transaction2.setReference(list.get(3));
			transaction2.setTransactionDate(currentDate);
			transaction2.setAccNo(toAccNumber);
			transaction2.setTransactionBy("Customer");
			
			accountTo.setAccountBalance(balanceTo+amount);
			accountTo.getTransactions().add(transaction2);
			
			accountRepo.save(accountTo);
			accountRepo.save(accountFrom);
		}
		}
		else 
			throw new Exception();
		
	}

	@Override
	public String forgot(String userName, String question,String answer) {
		
		Customer customer = customerRepo.findByusername(userName);

		if(customer!=null) {
			
			if (customer.getSecretQuestion().equals(question) && customer.getSecretAnswer().equals(answer))
				
				return "Details validated";

			else
				
				return "Sorry your secret details are not matching";
		}
			
		else 
			return "Username not found";
	}

	

	@Override
	public String changePassword(String userName, Customer customer1) {
		
		Customer customer2 = customerRepo.findByusername(userName);
			
			customer2.setPassword(customer1.getPassword());
		
			customerRepo.save(customer2);
			
			return "New password updated";
	
	}



}
