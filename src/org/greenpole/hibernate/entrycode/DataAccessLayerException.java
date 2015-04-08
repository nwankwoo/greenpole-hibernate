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
 * This exception is used to mark (fatal) failures in the data 
 * access layer level and system code.
 */
public class DataAccessLayerException extends RuntimeException{

    /**
     * it constructs a new runtime exception with null as its detail message
     */
    public DataAccessLayerException() {
    } 
    /**
     * This constructs a new runtime exception with specified information   
     */
    public DataAccessLayerException(String information){
        super(information);
    }
    /**
     it constructs a new runtime exception with the specified cause
     */
    public DataAccessLayerException(Throwable cause){
        super(cause);
    }
    /**
    *it constructs a new runtime exception with the specified 
    detail message and cause
     */
    public DataAccessLayerException(String information, Throwable cause){
        super( information, cause);
    }
    
}
