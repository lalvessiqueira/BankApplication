package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;


import com.learning.bankingapp.enums.EnableStatus;
import com.learning.bankingapp.enums.UserType;


@Data
@NoArgsConstructor

@Entity
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(columnNames = {"customerId"} ))
//@DiscriminatorValue (value = "Customer")
//@PrimaryKeyJoinColumn(referencedColumnName = "uid")
public class Customer extends User
{
	
	private String customerId;
    private Long phone;
    private String StateID=null;
    private Long SSN;
    private String secretQuestion=null;
    private String secretAnswer=null;
    private EnableStatus status=EnableStatus.DISABLED;

    public Customer(String username, String fullName, String password, UserType usertype) {
		super(username, fullName, password, usertype);
		// TODO Auto-generated constructor stub
	}

	@OneToMany(cascade = CascadeType.ALL) 
    private List<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL) 
    private List<Beneficiary> beneficiaries;

    public Customer(String password) {
		super(password);
		
	}

}
