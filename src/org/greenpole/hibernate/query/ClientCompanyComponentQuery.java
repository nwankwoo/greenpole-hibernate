/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyAddress;
import org.greenpole.hibernate.entity.ClientCompanyEmailAddress;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;

/**
 *
 * @author Akinwale Agbaje
 * Contains queries to do with client company requirements.
 */
public interface ClientCompanyComponentQuery {
    /**
     * Checks the existence of a client company.
     * @param companyName company name to search for
     * @return true, if company exists. Otherwise, false
     */
    public boolean checkClientCompany(String companyName);
    
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
    
    /**
     * Retrieves the unique identifier of the client company according to the
     * provided name.
     * @param clientCompanyName the name of the client company
     * @return the client company id
     */
    public int getClientCompanyId(String clientCompanyName);
    
    /**
     * Creates a new address for the client company.
     * @param address the client company's address
     */
    public void createAddress(ClientCompanyAddress address);
    
    /**
     * Creates a new email address for the client company.
     * @param emailAddress the client company's email address
     */
    public void createEmailAddress(ClientCompanyEmailAddress emailAddress);
    
    /**
     * Creates a new phone number for the client company.
     * @param phoneNumber the client company's phone number
     */
    public void createPhoneNumber(ClientCompanyPhoneNumber phoneNumber);
    
}
