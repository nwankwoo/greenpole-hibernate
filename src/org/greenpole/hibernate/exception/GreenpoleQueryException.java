/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.exception;

import org.hibernate.TransactionException;

/**
 *
 * @author Akinwale Agbaje
 */
public class GreenpoleQueryException extends TransactionException {

    public GreenpoleQueryException() {
        super("Error thrown during query");
    }

    public GreenpoleQueryException(String message) {
        super(message);
    }
}
