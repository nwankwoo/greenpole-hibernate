/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.BondOffer;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyAddress;
import org.greenpole.hibernate.entity.ClientCompanyEmailAddress;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;
import org.greenpole.hibernate.entity.InitialPublicOffer;
import org.greenpole.hibernate.entity.PrivatePlacement;
import org.greenpole.hibernate.entity.ShareQuotation;

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
     * Checks the existence of a client company.
     * @param clientCompanyId client company id to search with
     * @return true, if company exists. Otherwise, false
     */
    public boolean checkClientCompany(int clientCompanyId);
    
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
    
    /**
     * Sets up a bond offer.
     * @param bondOffer the bond offer to be created
     */
    public void createBondOffer(BondOffer bondOffer);
    
    /**
     * Sets up an initial public offer.
     * @param initialPublicOffer the ipo to be created
     */
    public void createInitialPublicOffer(InitialPublicOffer initialPublicOffer);
    
    /**
     * Sets up a private placement.
     * @param privatePlacement the private placement to be created
     */
    public void createPrivatePlacement(PrivatePlacement privatePlacement);
    
    /**
     * Retrieves a list of all available share unit quotations.
     * @return the list of share unit quotations
     */
    public List retrieveShareUnitQuatationList();
    
    /**
     * Creates a new share unit quotation.
     * @param shareQuotation the share quotation to be created
     */
    public void uploadShareQuotation(ShareQuotation shareQuotation);
    
    /**
     * Checks if a client company has shareholders tied to it.
     * @param clientCompanyName the client company to check
     * @return true if the client company has more than one holder company account
     * or more than one certificate (in case of a nominal transfer)
     */
    public boolean checkClientCompanyForShareholders(String clientCompanyName);
    
    /**
     * Searches for list of client companies according to the provided search parameters.
     * @param descriptor the description of the type of search to carry out
     * @param ccSearchParams the client company search parameters
     * @param ccAddressSearchParams the client company address search parameters
     * @param ccPhoneSearchParams the client company phone number search parameters
     * @param ccEmailSearchParams the client company email address search parameters
     * @param shareUnitCriteria the share unit search criteria
     * @param noOfShareholders the number of shareholders search criteria
     * @param noOfBondholders the number of bond holders search criteria
     * @return the list of client companies according from the search
     */
    public List<ClientCompany> queryClientCompany(String descriptor, ClientCompany ccSearchParams, ClientCompanyAddress ccAddressSearchParams,
            ClientCompanyPhoneNumber ccPhoneSearchParams, ClientCompanyEmailAddress ccEmailSearchParams, Map<String, Double> shareUnitCriteria, 
            Map<String, Integer> noOfShareholders, Map<String, Integer> noOfBondholders);
    
}
