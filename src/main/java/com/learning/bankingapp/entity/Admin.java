package com.learning.bankingapp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.learning.bankingapp.enums.UserType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Admin")
//@DiscriminatorValue (value = "Admin")
public class Admin extends User
{
	private UserType usertype=UserType.ADMIN;

}
