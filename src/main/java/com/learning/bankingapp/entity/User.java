package com.learning.bankingapp.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = {"username"} ))
@Inheritance (strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "User_type")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private long uid;
    @Column(name = "username")
    private String username;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "password")
    private String password;
   
    
	public User(String username, String fullName, String password) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
	}
       
}