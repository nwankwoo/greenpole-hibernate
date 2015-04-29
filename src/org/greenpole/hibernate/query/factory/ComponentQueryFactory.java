/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.factory;

import org.greenpole.hibernate.query.ClientCompanyComponentQuery;
import org.greenpole.hibernate.query.GeneralComponentQuery;
import org.greenpole.hibernate.query.impl.ClientCompanyComponentQueryImpl;
import org.greenpole.hibernate.query.impl.GeneralComponentQueryImpl;
import org.greenpole.hibernate.query.impl.HolderComponentQueryImpl;

/**
 *
 * @author Akinwale Agbaje
 * The factory class that creates all component query implementation classes.
 */
public class ComponentQueryFactory {
    /**
     * Creates a new client company component query implementation.
     * @return a new client company component query implementation
     */
    public static ClientCompanyComponentQuery getClientCompanyQuery() {
        return new ClientCompanyComponentQueryImpl();
    }
    
    /**
     * Creates a new holder component query implementation.
     * @return a new holder component query implementation
     */
    public static HolderComponentQueryImpl getHolderComponentQuery() {
        return new HolderComponentQueryImpl();
    }
    
    /**
     * Creates a new general component query implementation.
     * @return a new general component query implementation
     */
    public static GeneralComponentQuery getGeneralComponentQuery() {
        return new GeneralComponentQueryImpl();
    }
}
