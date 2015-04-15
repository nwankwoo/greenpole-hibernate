/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
import org.greenpole.hibernate.exception.DataAccessLayerException;
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
 * @see ClientCompanyQueryImpl
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
        tx = session.beginTransaction();
    }

    /**
     * Gets the current hibernate session.
     * Ensure that the method {@link #startOperation()} has been called before
     * calling this method.
     * @return the hibernate session
     */
    public Session getSession() {
        return session;
    }

    /**
     * Gets the hibernate transaction.
     * Ensure that the method {@link #startOperation()} has been called before
     * calling this method.
     * @return the hibernate transaction
     */
    public Transaction getTransaction() {
        return tx;
    }
    
    /**
     * 
     * @param ex
     * @throws DataAccessLayerException 
     * @deprecated exceptions / rollbacks will not be handled this way. If a 
     * rollback must occur, it should be called explicitly within the running
     * method.
     */
    @Deprecated
    private void handleException(String information, HibernateException ex) throws DataAccessLayerException{
        HibernateUtil.rollback(tx);
        throw new DataAccessLayerException(information, ex);
    }
    
    
    /**
     * Saves or updates a hibernate object in the database.
     * The {@link #startOperation()} method must be explicitly called, along
     * with the {@link #getSession()} and {@link #getTransaction()} to commit.
     * @param object a hibernate entity
     */
    public void createUpdateObject(Object object){
        session.saveOrUpdate(object);
    } 
    /**
     * Returns the component instance of the given entity class 
     * with the given identifier, or null if there is no such 
     * persistent instance.
     * The {@link #startOperation()} method must be explicitly called, along
     * with the {@link #getSession()} and {@link #getTransaction()} to commit.
     * @param clz the entity class
     * @param id the id of the object to retrieve
     * @return the object of the entity class
     */
    public Object searchObject(Class clz, Integer id){
        Object object = session.get(clz, id);
        return object;
    }
    
    /**
     * Returns all component instances of the given entity class.
     * The {@link #startOperation()} method must be explicitly called, along
     * with the {@link #getSession()} and {@link #getTransaction()} to commit.
     * @param clz the entity class
     * @return a list of objects of the entity class
     */
    public List searchAll(Class clz){
        Query query = session.createQuery("FROM " + clz.getName());
        List objects = query.list();
        return objects;
    }
}
