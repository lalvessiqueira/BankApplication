package com.learning.bankingapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingapp.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

}
