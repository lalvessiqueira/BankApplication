package com.learning.bankingapp.entity;

import com.learning.bankingapp.enums.AccountStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    private String staffId;
    private AccountStatus authorized;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "staff")
    // create separate table to denote acct owner, joined by customer idCustomer
    private List<Customer> customers;


}
