package com.learning.bankingapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingapp.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
