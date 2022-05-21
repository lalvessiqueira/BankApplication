package com.learning.bankingapp.entity;

import com.learning.bankingapp.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "staff", uniqueConstraints = @UniqueConstraint(columnNames = {"staffId"} ))
//@Table(name = "staff")
//@DiscriminatorValue (value = "Staff")
public class Staff extends User
{
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Generated(GenerationTime.INSERT)
	@Column(name = "staffId", columnDefinition = "serial", updatable = false)
    private Long staffId;
    private Status status=Status.DISABLED;

   // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "staff")
    // create separate table to denote acct owner, joined by customer idCustomer
   // private List<Customer> customers;


}
