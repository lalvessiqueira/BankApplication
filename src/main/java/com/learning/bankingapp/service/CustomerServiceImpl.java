package com.learning.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.bankingapp.Repo.CustomerRepo;
import com.learning.bankingapp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepo customerRepo;

	public CustomerServiceImpl() {
	
	}

	@Autowired
	public CustomerServiceImpl(CustomerRepo customerRepo) {
	
		this.customerRepo = customerRepo;
	}

	@Override
	public void register(Customer customer) {
		
		customerRepo.save(customer);
	}

}
