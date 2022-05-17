package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String customerId;
    private int phone;


    @OneToMany(cascade = CascadeType.ALL) // One customer can have multiple accounts
    // create separate table to denote acct owner, joined by customer idCustomer
    @JoinTable(name = "account_owner", joinColumns = @JoinColumn(name = "customerId"))
    private List<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL) // One customer can have multiple beneficiary accounts
    // create separate table to denote acct owner, joined by customer idCustomer
    @JoinTable(name = "beneficiary", joinColumns = @JoinColumn(name = "customerId"))
    private List<Beneficiary> beneficiaries;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Staff> staff;

//    private pan: multi part/image
//    private aarchar : multi part/ image



}
