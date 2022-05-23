package com.learning.bankingapp.util;

import java.io.Serializable;
import java.util.Random;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.learning.bankingapp.entity.Beneficiary;

public class BeneficiaryIdGenerator implements IdentifierGenerator {

    public static final String generatorName = "myGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        Random rnd = new Random();
        return ("B"+((Beneficiary)object).getBeneficiaryName().substring(0,2)).toUpperCase() + "_" + String.format("%06d", rnd.nextInt(999999));

    }
    

}