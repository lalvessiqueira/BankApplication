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

public class Beneficiary {

    @Id
    private String beneficiaryAcctNo;
    private String beneficiaryName;
    private Date dateAdded;



//    private pan: multi part/image
//    private aarchar : multi part/ image



}
