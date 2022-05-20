package com.learning.bankingapp.entity;

import com.learning.bankingapp.enums.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "User_type")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
    private long uid;
    @Column(name = "username")
    private String username;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "usertype")
    private Usertype usertype;
    
	public User(String username, String fullName, String password, Usertype usertype) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.usertype = usertype;
	}
    
    /*
    @OneToOne(cascade = CascadeType.ALL)
    Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    Staff staff;
    
    @OneToOne(cascade = CascadeType.ALL)
    Beneficiary beneficiary;
    
    @OneToOne(cascade = CascadeType.ALL)
    Admin admin;
*/
    // security?
//    private String secretQuestion;
//    private String secretAnswer;

    
    
}