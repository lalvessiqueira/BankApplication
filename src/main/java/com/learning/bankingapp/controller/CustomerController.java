package com.learning.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer) {

		customerService.register(customer);
		return customer;
	}
	
	
	
	
}
	


