/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Akinwale.Agbaje
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    //An interface which specifies the basic logger methods
    private final static Logger logStatus = Logger.getLogger(HibernateUtil.class);
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration config = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            sessionFactory = config.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * Rollback an underlying transaction or Issue a log message on failure
     */
    public static void rollback(Transaction transaction){
        try{
            if(transaction != null){
            transaction.rollback();
            }
        }catch(HibernateException ignore){
                    logStatus.error("Couldn't rollback transaction", ignore);
        }       
    }
}
