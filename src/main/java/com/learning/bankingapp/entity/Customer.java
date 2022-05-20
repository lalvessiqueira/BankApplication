package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

import com.learning.bankingapp.enums.Usertype;


@Data
@NoArgsConstructor

@Entity
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(columnNames = {"customerId"} ))
//@DiscriminatorValue (value = "Customer")
//@PrimaryKeyJoinColumn(referencedColumnName = "uid")
public class Customer extends User
{
	
	private Long customerId=null;
    private int phone;
    


    @OneToMany(cascade = CascadeType.ALL) // One customer can have multiple accounts
    // create separate table to denote acct owner, joined by customer idCustomer
//    @JoinTable(name = "account_owner", joinColumns = @JoinColumn(name = "customerId"))
    private List<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL) // One customer can have multiple beneficiary accounts
    // create separate table to denote acct owner, joined by customer idCustomer
 //   @JoinTable(name = "beneficiary", joinColumns = @JoinColumn(name = "customerId"))
    private List<Beneficiary> beneficiaries;

  //  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   // private List<Staff> staff;

//    private pan: multi part/image
//    private aarchar : multi part/ image

    public Customer(String username, String fullName, String password) {
		super(username, fullName, password, Usertype.CUSTOMER);
	}

   
    


}
