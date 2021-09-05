package com.co.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private static final String UNIDAD_DE_PERSISTENCIA="HibernatePU";
    private static EntityManagerFactory factory;
    
    public static EntityManagerFactory geEntityManagerFactory(){
        if (factory==null) {
            factory=Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
        }
        return factory;
    }
    
    public static void shutDown(){
        if (factory!=null) {
            factory.close();
            factory=null;
        }
    }
    
}
