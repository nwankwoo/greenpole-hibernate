/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ahmad.Gbadamosi
 * An unchecked exception subclass to RuntimeException
 * This exception is used to mark (fatal) failures in the data 
 * access layer level and system code.
 * @deprecated should not be used any longer. Hibernate exceptions will be caught
 * in the middle tier and not here.
 */
@Deprecated
public class DataAccessLayerException extends RuntimeException {

    /**
     * it constructs a new runtime exception with null as its detail message
     */
    public DataAccessLayerException() {
    } 
    /**
     * This constructs a new runtime exception with specified information   
     * @param information
     */
    public DataAccessLayerException(String information){
        super(information);
    }
    
    /**
     it constructs a new runtime exception with the specified cause
     * @param cause
     */
    public DataAccessLayerException(Throwable cause){
        super(cause);
    }
    
    /**
    *it constructs a new runtime exception with the specified 
    detail message and cause
     * @param information
     * @param cause
     */
    public DataAccessLayerException(String information, Throwable cause){
        super( information, cause);
    }
    
}
