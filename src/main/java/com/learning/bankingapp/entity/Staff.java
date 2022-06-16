package com.learning.bankingapp.entity;

import com.learning.bankingapp.enums.EnableStatus;
import com.learning.bankingapp.enums.UserType;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Staff", uniqueConstraints = @UniqueConstraint(columnNames = {"staffId"} ))
//@DiscriminatorValue (value = "Staff")
public class Staff extends User {
	
	private String staffId;
    private EnableStatus status=EnableStatus.DISABLED;
    
	public Staff(String username, String fullName, String password, UserType usertype) {
		super(username, fullName, password, usertype);
		// TODO Auto-generated constructor stub
	}
    
    

}
