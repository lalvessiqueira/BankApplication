package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
@DiscriminatorValue (value = "Admin")
public class Admin extends User
{

    private String customerId;



}
