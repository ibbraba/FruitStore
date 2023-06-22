package com.doranco.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author celes
 */
public class DaoFactory {
    
    private static DaoFactory DAO_FACTORY;
    private final EntityManagerFactory emf;
    private final String PU_NAME = "fruit";
    
    public DaoFactory() {
        this.emf = Persistence.createEntityManagerFactory(PU_NAME);
    }
    
    public static DaoFactory getInstance() {
        if(DAO_FACTORY == null)
            DAO_FACTORY = new DaoFactory();
        System.out.println("==== INITIALIZE DB SUCCESS ! ====");
        return DAO_FACTORY;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void closeEntityManagerFactory() {
        emf.close();
    }
    
}