package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.learning.bankingapp.enums.AccountType;
import com.learning.bankingapp.enums.Status;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private Long accountNumber;
    private AccountType accountType;
    private double accountBalance;
    private String approved="no";
    private Date dateOfCreation;
    private Status accountStatus=Status.DISABLED; 
   
    
   // @ManyToOne
  //@JoinTable(name="emp_addr_tbl",joinColumns = @JoinColumn (name="empId"))
  // Customer customer;

    private Long CustomerId;
    
    @OneToMany(cascade = CascadeType.ALL) // One customer can have multiple accounts
    // create separate table to denote acct owner, joined by customer idCustomer
//    @JoinTable(name = "account_owner", joinColumns = @JoinColumn(name = "customerId"))
    private List<Transaction> transactions;
    
	public Account(AccountType accountType, double accountBalance, String approved) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.approved = approved;
	}




}
