package com.learning.bankingapp.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bankingapp.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByFullName(String fullname);
}
