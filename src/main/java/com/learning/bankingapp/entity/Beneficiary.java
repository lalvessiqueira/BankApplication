package com.learning.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "beneficiaries")
@DiscriminatorValue (value = "Beneficiary")
public class Beneficiary  extends User
{

    private String beneficiaryAcctNo;
    private String beneficiaryName;
    private Date dateAdded;



//    private pan: multi part/image
//    private aarchar : multi part/ image

    @ManyToOne
    private Customer primary;

}
