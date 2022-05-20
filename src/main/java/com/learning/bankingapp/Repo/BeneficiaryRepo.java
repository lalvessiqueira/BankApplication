package com.learning.bankingapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingapp.entity.Beneficiary;
import com.learning.bankingapp.entity.Customer;

@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long> {

}
