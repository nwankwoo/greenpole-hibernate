/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.factory;

import org.greenpole.hibernate.query.ClientCompanyComponentQuery;
import org.greenpole.hibernate.query.impl.ClientCompanyComponentQueryImpl;

/**
 *
 * @author Akinwale Agbaje
 * The factory class that creates all component query implementation classes.
 */
public class ComponentQueryFactory {
    public static ClientCompanyComponentQuery getClientCompanyQuery() {
        return new ClientCompanyComponentQueryImpl();
    }
}
