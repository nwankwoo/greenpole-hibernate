/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
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
     * Creates a new client company, or updates an existing one in the database.
     * @param clientCompany the client company object model containing data
     * to be added
     * @param addresses the client company's addresses
     * @param emailAddresses the client company's email addresses
     * @param phoneNumbers the client company's phone numbers
     * @return true if the creation was successful
     */
    public boolean createOrUpdateClientCompany(ClientCompany clientCompany, List<ClientCompanyAddress> addresses, 
            List<ClientCompanyEmailAddress> emailAddresses, List<ClientCompanyPhoneNumber> phoneNumbers);
    
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
     * @deprecated outdated method. Use {@link #createOrUpdateClientCompany(org.greenpole.hibernate.entity.ClientCompany, org.greenpole.hibernate.entity.ClientCompanyAddress, org.greenpole.hibernate.entity.ClientCompanyEmailAddress, org.greenpole.hibernate.entity.ClientCompanyPhoneNumber)}
     * instead
     */
    @Deprecated
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
