package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.learning.bankingapp.enums.Status;
import com.learning.bankingapp.enums.UserType;


@Data
@NoArgsConstructor

@Entity
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(columnNames = {"customerId"} ))
//@DiscriminatorValue (value = "Customer")
//@PrimaryKeyJoinColumn(referencedColumnName = "uid")
public class Customer extends User
{
	@Generated(GenerationTime.INSERT)
	@Column(name = "customerId", columnDefinition = "serial", updatable = false)
	private Long customerId;
    private int phone;
    private String StateID=null;
    private Long SSN;
    private String secretQuestion=null;
    private String secretAnswer=null;
    private Status status=Status.DISABLED;
    private UserType usertype=UserType.CUSTOMER;


    @OneToMany(cascade = CascadeType.ALL) 
    private List<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL) 
    private List<Beneficiary> beneficiaries;



}
