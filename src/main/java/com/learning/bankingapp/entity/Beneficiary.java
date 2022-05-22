package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.learning.bankingapp.enums.AccountType;
import com.learning.bankingapp.enums.Active;

import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Beneficiaries")
@DiscriminatorValue (value = "Beneficiary")
public class Beneficiary {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long bId;
    private Long beneficiaryAcctNo;
	private AccountType accountType;
    private String beneficiaryName;
    private String approved="no";
    private Date dateAdded;
    private Active active= Active.YES;

    private Long CustomerId;

}
