package com.learning.bankingapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingapp.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

}
