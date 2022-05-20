package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.learning.bankingapp.enums.AccountType;

import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private Long accountNumber;
    private AccountType accountType;
    private double accountBalance;
    private Date dateOfCreation;
    private String approved="no";
//    private String pan;
//    private String aadhar;
    
    @ManyToOne
  //@JoinTable(name="emp_addr_tbl",joinColumns = @JoinColumn (name="empId"))
   Customer customer;

	public Account(AccountType accountType, double accountBalance, String approved) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.approved = approved;
	}




}
