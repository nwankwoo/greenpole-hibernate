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
import org.greenpole.hibernate.entity.ClearingHouse;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyAddress;
import org.greenpole.hibernate.entity.ClientCompanyEmailAddress;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;
import org.greenpole.hibernate.entity.Depository;
import org.greenpole.hibernate.entity.InitialPublicOffer;
import org.greenpole.hibernate.entity.IpoApplication;
import org.greenpole.hibernate.entity.NseSector;
import org.greenpole.hibernate.entity.PrivatePlacement;
import org.greenpole.hibernate.entity.PrivatePlacementApplication;
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
     * Checks the existence of a client company while ignoring its valid status.
     * @param clientCompanyId client company id to search with
     * @return true, if company exists. Otherwise, false
     */
    public boolean checkClientCompanyIgnoreValid(int clientCompanyId);
    
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
     * Gets all available client companies.
     * @return a list of all available client companies
     */
    public List<ClientCompany> getAllClientCompanies();
    
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
    public List<ClientCompanyAddress> getClientCompanyAddresses(int clientCompanyId);
    
    /**
     * Gets the address of a client company according to a specified id.
     * @param id the address id
     * @return the client company's address
     */
    public ClientCompanyAddress getClientCompanyAddress(int id);
    
    /**
     * Gets the email addresses of a client company.
     * @param clientCompanyId the client company id
     * @return the list of the client company's email addresses
     */
    public List<ClientCompanyEmailAddress> getClientCompanyEmailAddresses(int clientCompanyId);
    
    /**
     * Gets the email address of a client company according to a specified id. 
     * @param id the email id
     * @return the client company's email address
     */
    public ClientCompanyEmailAddress getClientCompanyEmailAddress(int id);
    
    /**
     * Gets the phone numbers of a client company.
     * @param clientCompanyId the client company id
     * @return the list of the client company's phone numbers
     */
    public List<ClientCompanyPhoneNumber> getClientCompanyPhoneNumbers(int clientCompanyId);
    
    /**
     * Gets the phone number of a client company according to a specified id.
     * @param id the phone number id
     * @return the client company's phone number
     */
    public ClientCompanyPhoneNumber getClientCompanyPhoneNumber(int id);
    
    /**
     * Gets the number of shareholders of a client company.
     * @param clientCompanyId the client company id
     * @return the number of shareholders of a client company
     */
    public int getNumberOfShareholders(int clientCompanyId);
    
    /**
     * Gets the number of bondholders of a client company.
     * @param clientCompanyId the client company id
     * @return the number of bondholders of a client company
     */
    public int getNumberOfBondholders (int clientCompanyId);
    
    /**
     * Gets the unit price of a client company.
     * @param clientCompanyId the client company id
     * @return the unit price of a client company
     */
    public double getUnitPrice(int clientCompanyId);
    
    /**
     * Sets up a bond offer.
     * @param bondOffer the bond offer to be created
     */
    public void createBondOffer(BondOffer bondOffer);
    
    /**
     * Checks if a bond offer exists, whether valid or not.
     * @param bondOfferId the bond offer id
     * @return true, if bond offer exists
     */
    public boolean checkBondOffer(int bondOfferId);
    
    /**
     * Checks the valid status of a bond offer.
     * @param bondOfferId the bond offer id
     * @return true, if bond offer is valid. Otherwise, false
     */
    public boolean bondOfferIsValid(int bondOfferId);
    
    /**
     * Gets all available bond offers in the system.
     * @return a list of all available bond offers in the system
     */
    public List<BondOffer> getAllBondOffers();
    
    /**
     * Gets all bond offers, including non valid ones.
     * @return a list of all bond offers
     */
    public List<BondOffer> getAllBondOffersWithNonValid();
    
    /**
     * Sets up an initial public offer.
     * @param initialPublicOffer the ipo to be created
     */
    public void createInitialPublicOffer(InitialPublicOffer initialPublicOffer);
    
    /**
     * Checks if a client company already has an ipo setup.
     * @param clientCompanyId the company's id
     * @return true, if client company already has an ipo. Otherwise, false
     */
    public boolean clientCompanyHasIpo(int clientCompanyId);
    
    /**
     * Gets the ipo of a client company, whether active or not.
     * @param clientCompanyId the company's id
     * @return the client company's ipo
     */
    public InitialPublicOffer getClientCompanyIpo(int clientCompanyId);
    
    /**
     * Gets an ipo object.
     * @param ipoId the ipo id
     * @return the ipo object
     */
    public InitialPublicOffer getIpo(int ipoId);
    
    /**
     * Gets the active ipo of a client company
     * @param clientCompanyId the company's id
     * @return the client company's active ipo
     */
    public InitialPublicOffer getActiveClientCompanyIpo(int clientCompanyId);
    
    /**
     * Gets an active ipo object.
     * @param ipoId the ipo id
     * @return the active ipo object
     */
    public InitialPublicOffer getActiveIpo(int ipoId);
    
    /**
     * Checks if an IPO exists in the database.
     * @param ipoId the ipo id
     * @return true, if the IPO exists in the database. Otherwise, false
     */
    public boolean checkInitialPublicOffer(int ipoId);
    
    /**
     * Checks if an IPO exists and is still open.
     * @param ipoId the ipo id
     * @return true, if the IPO exists and is still open. Otherwise, false
     */
    public boolean checkActiveInitialPublicOffer(int ipoId);
    
    /**
     * Gets a list of all ipos.
     * @return a list of all ipos
     */
    public List<InitialPublicOffer> getAllIpos();
    
    /**
     * Gets a list of all active ipos.
     * @return a list of all active ipos
     */
    public List<InitialPublicOffer> getAllActiveIpos();
    
    /**
     * Gets all submitted ipo applications according to a specified ipo id 
     * that have not been cancelled.
     * @param ipoId the ipo id
     * @return a list of ipo applications
     */
    public List<IpoApplication> getActiveIpoApplications(int ipoId);
    
    /**
     * Gets all submitted ipo applications according to a specified ipo id 
     * whether they have been cancelled or not.
     * @param ipoId the ipo id
     * @return a list of ipo applications
     */
    public List<IpoApplication> getAllIpoApplications(int ipoId);
    
    /**
     * Sets up a private placement.
     * @param privatePlacement the private placement to be created
     */
    public void createPrivatePlacement(PrivatePlacement privatePlacement);
    
    /**
     * Gets all submitted private placement applications according to a specified private placement id
     * whether they have been cancelled or not.
     * @param ppId the private placement id
     * @return a list of private placement applications
     */
    public List<PrivatePlacementApplication> getAllPrivatePlacementApplications(int ppId);
    
    /**
     * Gets all submitted private placement applications according to a specified private placement id
     * that have not been cancelled.
     * @param ppId the private placement id
     * @return a list of private placement applications
     */
    public List<PrivatePlacementApplication> getAllActivePrivatePlacementApplications(int ppId);
    
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
     * Checks if a client company already has uploaded share quotation.
     * @param clientCompanyCode the client company code
     * @return true, if client company already has uploaded share quotation
     */
    public boolean companyHasShareQuotation(String clientCompanyCode);
    
    /**
     * Gets the share quotation according to a specified client company code.
     * @param clientCompanyCode the client company code
     * @return the share quotation object
     */
    public ShareQuotation getShareQuotation(String clientCompanyCode);
    
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
     * Gets the bond type according to a specified id.
     * @param bondTypeId the bond type id
     * @return the bond type object
     */
    public BondType getBondType(int bondTypeId);
    
    /**
     * Gets all available bond offer payment plans.
     * @return a list of available bond offer payment plans
     */
    public List<BondOfferPaymentPlan> getAllBondOfferPaymentPlans();
    
    /**
     * Gets the bond offer payment plan according to a specified id.
     * @param planId the plan id
     * @return the bond offer payment plan object
     */
    public BondOfferPaymentPlan getBondOfferPaymentPlan(int planId);
    
    /**
     * Gets all available nse sectors.
     * @return a list of all available nse sectors
     */
    public List<NseSector> getAllNseSectors();
    
    /**
     * Gets the nse sector according to the specified id.
     * @param sectorId the nse sector id
     * @return the nse sector object
     */
    public NseSector getNseSector(int sectorId);
    
    /**
     * Gets all available depositories.
     * @return a list of all available depositories
     */
    public List<Depository> getAllDepositories();
    
    /**
     * Gets the depository according to a specified id.
     * @param depositoryId the depository id
     * @return the depository object
     */
    public Depository getDepository(int depositoryId);
    
    /**
     * Gets the clearing house according to a specified id.
     * @param chId the clearing house id
     * @return the clearing house object
     */
    public ClearingHouse getClearingHouse(int chId);
    
    /**
     * Gets the private placement object according to a specified id.
     * @param ppId the private placement id
     * @return the private placement object
     */
    public PrivatePlacement getPrivatePlacement(int ppId);
    
    /**
     * Checks if a private placement exists.
     * @param ppId the private placement id
     * @return true, if the private placement exists. Otherwise, false
     */
    public boolean checkPrivatePlacement(int ppId);
    
    /**
     * Checks if a private placement exists while it's still active.
     * @param ppId the private placement id
     * @return true, if the private placement exists and is active. Otherwise, false
     */
    public boolean checkActivePrivatePlacement(int ppId);
    
    /**
     * Checks if a client company has any open private placements.
     * @param clientCompanyId the client company id
     * @return true, if client company has an open private placement. Otherwise, false
     */
    public boolean checkClientCompanyPrivatePlacement(int clientCompanyId);
    
    /**
     * Checks if a client company has an open private placement according to the specified private placement id.
     * @param clientCompanyId the client company id
     * @param ppId the private placement id
     * @return true, if the private placement is open for the client company. Otherwise, false
     */
    public boolean checkClientCompanyPrivatePlacement(int clientCompanyId, int ppId);
    
    /**
     * Gets the client company for which the specified rights issue belongs to.
     * @param rightsId the rights issue id
     * @return the client company object
     */
    public ClientCompany getRightsIssueClientCompany(int rightsId);
    
    /**
     * Gets the client company for which the specified private placement belongs to.
     * @param ppId the private placement id
     * @return the client company object
     */
    public ClientCompany getPrivatePlacementClientCompany(int ppId);
    
    /**
     * Gets the client company for which the specified ipo belongs to.
     * @param ipoId the ipo id
     * @return the client company object
     */
    public ClientCompany getIpoClientCompany(int ipoId);
}
