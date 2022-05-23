package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "beneficiary_seq")
    @GenericGenerator(name = "beneficiary_seq", strategy = "com.learning.bankingapp.util.BeneficiaryIdGenerator")
	private String bId;
    private String beneficiaryAcctNo;
	private AccountType accountType;
    private String beneficiaryName;
    private String approved="no";
    private Date dateAdded;
    private Active active= Active.YES;

    private String CustomerId;

}
