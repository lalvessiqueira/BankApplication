package com.learning.bankingapp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingapp.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	Customer findBycustomerId(Long Id);

}
