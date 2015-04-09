/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import org.greenpole.hibernate.entity.ClientCompany;

/**
 *
 * @author Akinwale Agbaje
 * Contains queries to do with client company requirements.
 */
public interface ClientCompanyComponentQuery {
    /**
     * Checks the existence of a client company.
     * @param companyname company name to search for
     * @return true, if company exists. Otherwise, false
     */
    public boolean checkClientCompany(String companyname);
    
    /**
     * Creates a new client company in the database.
     * @param clientCompany the client company object model containing data
     * to be added
     */
    public void create(ClientCompany clientCompany);
    
    /**
     * Gets a client company object by a specified id.
     * @param id the client company id
     * @return the client company object
     */
    public ClientCompany getClientCompany(Integer id);
    
    /**
     * Updates an existing client company in the database.
     * @param clientCompany the client company object model containing data
     * to be updated
     */
    public void editClientCompany(ClientCompany clientCompany);
    
}
