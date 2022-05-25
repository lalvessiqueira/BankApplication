package com.learning.bankingapp.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.learning.bankingapp.enums.UserType;

@Data
@NoArgsConstructor

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = {"username"} ))
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "User_type")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_seq")
    @GenericGenerator(name = "customer_seq", strategy = "com.learning.bankingapp.util.UserIdGenerator")
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
    private String uid;
    @Column(name = "username")
    private String username;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "password")
    private String password;
    private UserType usertype;
    
	public User(String username, String fullName, String password,UserType usertype ) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.usertype = usertype;
	}

	public User(String password) {
		super();
		this.password = password;
	}
	
	
       
}