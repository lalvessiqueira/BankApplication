package com.learning.bankingapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.learning.bankingapp.entity.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, String> {
	Staff findBystaffId(String Id);
}
