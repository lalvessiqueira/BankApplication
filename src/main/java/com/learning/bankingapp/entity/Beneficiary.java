package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.learning.bankingapp.enums.AccountType;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "beneficiaries")
//@DiscriminatorValue (value = "Beneficiary")
public class Beneficiary {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long bId;
    private Long beneficiaryAcctNo;
	private AccountType accountType;
    private String beneficiaryName;
    private String valid;
    private Date dateAdded;



//    private pan: multi part/image
//    private aarchar : multi part/ image

    @ManyToOne
    private Customer primary;

}
