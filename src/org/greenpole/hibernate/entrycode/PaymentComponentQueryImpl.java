/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

import org.greenpole.hibernate.entity.Coupon;
import org.greenpole.hibernate.entity.Dividend;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Ahmad.Gbadamosi
 */
public class PaymentComponentQueryImpl extends GeneralisedAbstractDao {
    private static final Logger logger = LoggerFactory.getLogger(PaymentComponentQueryImpl.class);
    
    /**
     * construct method to Create Dividend
     * @param dividend object to persist
     */
    public boolean createDividend(Dividend dividend){
    
        boolean successful =false;
        try {
            startOperation();
            createUpdateObject(dividend);
            successful = true;
            getTransaction().commit();
            return successful;
        } catch (HibernateException he) {
            getTransaction().rollback();
            logger.info("error persisting dividend object, review! - ", he);
            return successful;
        }
    }
    
    /**
     * construct method to Create Coupon
     * @param dividend object to persist
     */
    public boolean createCoupon(Coupon coupon){
        boolean successful = false;
        try {
            startOperation();
            createUpdateObject(coupon);
            successful = true;
            getTransaction().commit();
            return successful;
        } catch (HibernateException he) {
            getTransaction().rollback();
            logger.info("error persisting coupon object, review! - ", he);
            return successful;
        }
    }
}
