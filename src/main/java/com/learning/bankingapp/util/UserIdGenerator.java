package com.learning.bankingapp.util;

import java.io.Serializable;
import java.util.Random;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {

    public static final String generatorName = "myGenerator";

    @Override
   public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        Random rnd = new Random();
        return String.format("%06d", rnd.nextInt(999999));

   }
}