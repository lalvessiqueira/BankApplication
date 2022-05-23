package com.learning.bankingapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingapp.entity.Beneficiary;

@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, String> {

}
