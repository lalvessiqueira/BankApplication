package com.learning.bankingapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingapp.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
	
	Customer findBycustomerId(String Id);
	Customer findByusername(String username);

}
