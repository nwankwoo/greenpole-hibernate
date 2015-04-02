/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

/**
 *
 * @author Ahmad.Gbadamosi
 * An unchecked exception subclass to RuntimeException
 */
public class DataAccessLayerException extends RuntimeException{

    public DataAccessLayerException() {
    }
    
    /**
     * This constructs a new runtime exception with specified information   
     */
    public DataAccessLayerException(String information){
        super(information);
    }
    
    public DataAccessLayerException(Throwable cause){
    }
    
}
