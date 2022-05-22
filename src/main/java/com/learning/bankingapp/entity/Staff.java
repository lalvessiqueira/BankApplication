package com.learning.bankingapp.entity;

import com.learning.bankingapp.enums.Status;
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
public class Staff extends User{
	
	@Generated(GenerationTime.INSERT)
	@Column(name = "staffId", columnDefinition = "serial", updatable = false)
    private Long staffId;
    private Status status=Status.DISABLED;
    private UserType usertype=UserType.STAFF;

}
