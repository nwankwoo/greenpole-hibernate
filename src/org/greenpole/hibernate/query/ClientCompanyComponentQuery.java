/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.BondOffer;
import org.greenpole.hibernate.entity.BondOfferPaymentPlan;
import org.greenpole.hibernate.entity.BondType;
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
     * @param companyCode company code to search for
     * @return true, if company exists. Otherwise, false
     */
    public boolean checkClientCompanyByCode(String companyCode);
    
    /**
     * Checks the existence of a client company.
     * @param clientCompanyId client company id to search with
     * @return true, if company exists. Otherwise, false
     */
    public boolean checkClientCompany(int clientCompanyId);
    
    /**
     * Checks the valid status of a client company.
     * @param clientCompanyId the client company id
     * @return true, if company is valid. Otherwise, false.
     */
    public boolean clientCompanyIsValid(int clientCompanyId);
    
    /**
     * Creates a new client company in the database.
     * @param clientCompany the client company object model containing data
     * to be added
     * @param addresses the client company's addresses
     * @param emailAddresses the client company's email addresses
     * @param phoneNumbers the client company's phone numbers
     * @return true if the creation was successful
     */
    public boolean createClientCompany(ClientCompany clientCompany, List<ClientCompanyAddress> addresses, 
            List<ClientCompanyEmailAddress> emailAddresses, List<ClientCompanyPhoneNumber> phoneNumbers);
    
    /**
     * Updates an existing client company in the database
     * @param clientCompany the client company object model containing data
     * to be added
     * @param addresses the client company's addresses to be edited
     * @param emailAddresses the client company's email addresses to be edited
     * @param phoneNumbers the client company's phone numbers to be edited
     * @param addressesToRemove the client company's addresses to be removed
     * @param emailAddressesToRemove the client company's email addresses to be removed
     * @param phoneNumbersToRemove the client company's phone numbers to be removed
     * @return true if update was successful
     */
    public boolean updateClientCompany(ClientCompany clientCompany, List<ClientCompanyAddress> addresses, 
            List<ClientCompanyEmailAddress> emailAddresses, List<ClientCompanyPhoneNumber> phoneNumbers,
            List<ClientCompanyAddress> addressesToRemove, List<ClientCompanyEmailAddress> emailAddressesToRemove,
            List<ClientCompanyPhoneNumber> phoneNumbersToRemove);
    
    /**
     * Gets a client company object by a specified id.
     * @param id the client company id
     * @return the client company object
     */
    public ClientCompany getClientCompany(Integer id);
    
    /**
     * Gets a client company object by a specified name.
     * @param name the client company's name
     * @return the client company object
     */
    public ClientCompany getClientCompanyByName(String name);
    
    /**
     * Gets a client company object by a specified code.
     * @param code the client company code
     * @return the client company object
     */
    public ClientCompany getClientCompany(String code);
    
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
     * Gets the addresses of a client company.
     * @param clientCompanyId the client company id
     * @return the list of the client company's addresses
     */
    public List<ClientCompanyAddress> getClientCompanyAddress(int clientCompanyId);
    
    /**
     * Gets the email addresses of a client company.
     * @param clientCompanyId the client company id
     * @return the list of the client company's email addresses
     */
    public List<ClientCompanyEmailAddress> getClientCompanyEmailAddress(int clientCompanyId);
    
    /**
     * Gets the phone numbers of a client company.
     * @param clientCompanyId the client company id
     * @return the list of the client company's phone numbers
     */
    public List<ClientCompanyPhoneNumber> getClientCompanyPhoneNumber(int clientCompanyId);
    
    /**
     * Sets up a bond offer.
     * @param bondOffer the bond offer to be created
     */
    public void createBondOffer(BondOffer bondOffer);
    
    /**
     * Checks the valid status of a bond offer.
     * @param bondOfferId the bond offer id
     * @return true, if bond offer is valid. Otherwise, false
     */
    public boolean bondOfferIsValid(int bondOfferId);
    
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
     * Creates a set of new share unit quotations.
     * @param shareQuotations the share quotations to be created
     * @return true, if creation is successful
     */
    public boolean uploadShareQuotation(List<ShareQuotation> shareQuotations);
    
    /**
     * Checks if a client company has shareholders tied to it.
     * @param clientCompanyName the client company to check
     * @return true if the client company has more than one holder company account
     * or more than one certificate (in case of a nominal transfer)
     */
    public boolean checkClientCompanyForShareholders(String clientCompanyName);
    
    /**
     * Checks if a client company has an open private placement.
     * @param clientCompanyId the company id
     * @return true if there is an open private placement. Otherwise, false
     */
    public boolean checkOpenPrivatePlacement(int clientCompanyId);
    
    /**
     * Searches for list of client companies according to the provided search parameters.
     * @param descriptor the description of the type of search to carry out
     * @param ccSearchParams the client company search parameters
     * @param shareUnitCriteria the share unit search criteria
     * @param noOfShareholdersCriteria the number of shareholders search criteria
     * @param noOfBondholdersCriteria the number of bond holders search criteria
     * @return the list of client companies from the search
     */
    public List<ClientCompany> queryClientCompany(String descriptor, ClientCompany ccSearchParams, Map<String, Double> shareUnitCriteria, 
            Map<String, Integer> noOfShareholdersCriteria, Map<String, Integer> noOfBondholdersCriteria);
    
    /**
     * Gets a bond offer by the specified id.
     * @param bondOfferId the bond offer id
     * @return the bond offer object
     */
    public BondOffer getBondOffer(int bondOfferId);
    
    /**
     * Gets all available bond types.
     * @return a list of all available bond types 
     */
    public List<BondType> getAllBondTypes();
    
    /**
     * Gets all available bond offer payment plans.
     * @return a list of available bond offer payment plans
     */
    public List<BondOfferPaymentPlan> getAllBondOfferPaymentPlans();
    
}
