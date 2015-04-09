/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

import java.util.List;
import org.greenpole.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ahmad.Gbadamosi
 * A general abstract superclass, provides the attributes and methods<p> 
 * that are common among subclasses. It is inherited by various data access
 *<p>objects (concrete classes) and from which, implements complete
 * details of the methods in the inherited abstract class<p>
 * is a concrete class that implements the abstract class
 * @see ClientCompanyDao
 */
public abstract class GeneralisedAbstractDao {
    
    private Session session;
    private Transaction tx; 
    
    /**
     * Operational method for hibernate to obtain a session and <p>
     * start a hibernate transaction, applied to a sequence of operation
     */
    public void startOperation(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();  //use hibernate api to manage and demarcate transaction
    }
    
    
    protected void handleException(HibernateException e) throws DataAccessLayerException{
        HibernateUtil.rollback(tx);
        throw new DataAccessLayerException(e);
    }
    
    
    /**
     * Utility save or update method that persist the our objects
     * @param object
     */
    protected void createUpdateObject(Object object){
        try{
            startOperation();
            session.saveOrUpdate(object);
            session.getTransaction();
            tx.commit();
        }catch(HibernateException he){
            HibernateUtil.rollback(tx);
            throw new DataAccessLayerException(he);
        }
    } 
    /**
     * Return the component instance of the given entity class 
     * with the given identifier, or null if there is no such 
     * persistent instance
     * @return obj
     */
    protected Object searchObject(Class classObj, String searchParams){
        Object object = null;
        
        startOperation();
        session.get(classObj, searchParams);  //get is used over load, becuase load cannot handle non-identifier searchParams
        tx.commit();
        return object;
    }
    
    protected List searchAll(Class classObj){
        List objects = null;
        startOperation();
        Query query = session.createQuery("from" + classObj.getName());
        objects = query.list();
        tx.commit();
        return objects;
    }
}
