package com.learning.bankingapp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.learning.bankingapp.entity.User;
import com.learning.bankingapp.enums.AccountType;


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
	}

	@Override
	public Account createAccount(Long CustId, Account account1) {

		Date currentDate = Calendar.getInstance().getTime();
		
		Customer customer = customerRepo.getById(CustId);
		Account account2= new Account();
		
		account2.setAccountType(account1.getAccountType());
		account2.setAccountBalance(account1.getAccountBalance());
		account2.setApproved(account1.getApproved());
		account2.setDateOfCreation(currentDate);
		
		customer.getAccounts().add(account2);
		
		account2.setAccountNumber(customer.getAccounts().size()+2121212*CustId);
		
		customerRepo.save(customer);
	
	 return account2;
	}

	@Override
	public Account approveAccount(Long CustId, Long AccNo, Account account) {
		
		Customer customer = customerRepo.getById(CustId);
		
		int SIZE = customer.getAccounts().size();
		
		for (int i =0; i<SIZE; i++) {
		
			if(customer.getAccounts().get(i).getAccountNumber().equals(AccNo)) {
				customer.getAccounts().get(i).setApproved(account.getApproved());
				customerRepo.save(customer);
				return customer.getAccounts().get(i);
			}
		}
		System.out.println("Please check Account Number");
		return null;
	}

	@Override
	public List<Account> getAllAccount(Long CustId) {

		Customer customer = customerRepo.getById(CustId);
		return customer.getAccounts();
	}

	@Override
	public Optional<Customer> getCustomer(Long CustId) {
	
		return customerRepo.findById(CustId);
	}

	@Override
	public void updateAccount(Long CustId, Customer customer1) {
		
		Customer customer2 = customerRepo.getById(CustId);
	
		customer2.setFullName(customer1.getFullName());
		customer2.setPhone(customer1.getPhone());
		
		customerRepo.save(customer2);
	
	}

	@Override
	public Account getAccount(Long CustId, Long AccNo) {
		
		Customer customer = customerRepo.getById(CustId);
		
		int SIZE = customer.getAccounts().size();
		
		for (int i =0; i<SIZE; i++) {
		
			if(customer.getAccounts().get(i).getAccountNumber().equals(AccNo)) {
				
				return customer.getAccounts().get(i);
			}
		}
		System.out.println("Sorry Account with "+CustId+" not found");
		return null;
		
		
	}

	@Override
	public Beneficiary addBeneficiary(Long CustId, Beneficiary beneficiary1) {
		
		Customer customer = customerRepo.getById(CustId);
		Beneficiary beneficiary2= new Beneficiary();
		
	    int SIZE = customer.getAccounts().size();
		
		for (int i =0; i<SIZE; i++) {
		
			if(customer.getAccounts().get(i).getAccountNumber().equals(beneficiary1.getBeneficiaryAcctNo())) {
				
				beneficiary2.setBeneficiaryAcctNo(beneficiary1.getBeneficiaryAcctNo());
			    beneficiary2.setAccountType(beneficiary1.getAccountType());
			    beneficiary2.setBeneficiaryName(beneficiary1.getBeneficiaryName());
			    beneficiary2.setValid(beneficiary1.getValid());
			    
			    customer.getBeneficiaries().add(beneficiary2);
			    
			    customerRepo.save(customer);
			   
			    return beneficiary2;
			}
		}
		
		return null;
		
	}

	@Override
	public List<Beneficiary> getAllBeneficiary(Long CustId) {
		
		Customer customer = customerRepo.getById(CustId);
		return customer.getBeneficiaries();
	}

	@Override
	public void deleteBeneficiary(Long CustId, Long BenId) {
		
		Customer customer = customerRepo.getById(CustId);

	    int SIZE = customer.getBeneficiaries().size();
		
		for (int i =0; i<SIZE; i++) {
			
			System.out.println(customer.getBeneficiaries().get(i).getBId());
			System.out.println(BenId);
			
			if(customer.getBeneficiaries().get(i).getBId()==BenId) {
				
				customer.getBeneficiaries().remove(i);
				beneficiaryRepo.deleteById(BenId);
		
				break;
			}
			}
	
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

	@Override
	public String forgot(Long CustId, String userName) {
		
		Customer customer = customerRepo.getById(CustId);
		
		if(userName.equals(customer.getUsername()))
			
			return "Details validated";
		
		else 
			return "Sorry your secret details are not matching";
	}

	@Override
	public String changePassword(Long CustId, Customer customer1) {
		
		Customer customer2 = customerRepo.getById(CustId);
		
		if(customer2.getUsername().equals(customer1.getUsername())) {
			
			customer2.setPassword(customer1.getPassword());
		
			customerRepo.save(customer2);
			
			return "New password updated";
		}
		else 
			return "Sorry password not updated";
	}

	
		
	
	
	

}
