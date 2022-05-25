package com.learning.bankingapp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Admin")
//@DiscriminatorValue (value = "Admin")
public class Admin extends User
{
	

}
