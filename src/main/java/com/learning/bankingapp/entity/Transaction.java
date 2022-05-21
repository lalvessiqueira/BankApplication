package com.learning.bankingapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.learning.bankingapp.enums.AccountType;
import com.learning.bankingapp.enums.Status;
import com.learning.bankingapp.enums.TransactionType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private Date transactionDate;
	private String reference;
	private String TransactionBy;
	private double amount;
	private TransactionType type;
	

	//@ManyToOne
	//private Account account;
	
	 private Long AccNo;
	
}
