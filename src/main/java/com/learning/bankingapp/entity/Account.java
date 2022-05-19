package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private String accountNumber;
    private double accountBalance;
    private Date dateOfCreation;
    boolean approved; // enum?
//    private String pan;
//    private String aadhar;
    
    @ManyToOne
   Customer customer;




}
