/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderChangeType;
import org.greenpole.hibernate.entity.HolderChanges;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderEmailAddress;
import org.greenpole.hibernate.entity.HolderPhoneNumber;
import org.greenpole.hibernate.entity.HolderPostalAddress;
import org.greenpole.hibernate.entity.HolderResidentialAddress;
import org.hibernate.id.IdentifierGeneratorHelper;

/**
 *
 * @author Akinwale Agbaje
 */
public interface HolderComponentQuery {
    
    /**
     * Creates a new holder account (for shareholder), along with a holder company account.
     * @param holder the holder account to create
     * @param holderCompanyAccount the holder company account to create
     * @param residentialAddresses the holder's residential address
     * @param postalAddresses the holder's postal address
     * @param phoneNumbers the holder's phone number
     * @return true, if create transaction is successful
     */
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, List<HolderResidentialAddress> residentialAddresses,
            List<HolderPostalAddress> postalAddresses, List<HolderPhoneNumber> phoneNumbers);
    
    /**
     * Creates a new / updates an existing holder company account (for shareholder).
     * This method can be called in instances where a holder already exists
     * but does not have an account with a particular client company.
     * @param holderCompanyAccount the holder company account to create / update
     */
    public void createUpdateHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount);
    
    /**
     * Creates a new holder account (for bondholder), along with a holder bond account.
     * @param holder the holder account to create
     * @param holderBondAccount the holder bond account to create
     * @param residentialAddresses the holder's residential addresses
     * @param postalAddresses the holder's postal addresses
     * @param phoneNumbers the holder's phone numbers
     * @return true, if create transaction is successful
     */
    public boolean createHolderAccount(Holder holder, HolderBondAccount holderBondAccount, List<HolderResidentialAddress> residentialAddresses,
            List<HolderPostalAddress> postalAddresses, List<HolderPhoneNumber> phoneNumbers);
    
    /**
     * Creates a new / updates an existing holder bond account (for bondholder).
     * This method can be called in instances where a holder already exists
     * but does not have an account with a particular client company.
     * @param holderBondAccount the holder bond account to create
     */
    public void createUpdateHolderBondAccount(HolderBondAccount holderBondAccount);
    
    /**
     * Updates an existing holder account (for shareholder and bondholder).
     * This method could work when creating a holder without wanting to create an accompanying
     * holder company / bond account, though this would be in violation of the current business
     * rule in place.
     * As such, do not use when trying to create a holder account, only when trying to update a
     * holder account.
     * @param holder the holder account to update
     * @param residentialAddresses the holder's residential addresses
     * @param postalAddresses the holder's postal addresses
     * @param phoneNumbers the holder's phone numbers
     * @return true, if update transaction is successful
     */
    public boolean updateHolderAccount(Holder holder, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses,
            List<HolderPhoneNumber> phoneNumbers);
    
    /**
     * Checks the existence of a holder.
     * @param holderId the holder's id
     * @return true, if the holder exists. Otherwise, false
     */
    public boolean checkHolderAccount(int holderId);
    
    /**
     * Checks the existence of a holder.
     * @param chn the holder's chn
     * @return true, if the holder exists. Otherwise, false
     */
    public boolean checkHolderAccount(String chn);
    
    /**
     * Checks the existence of a holder company account.
     * @param holderId the holder's id
     * @param clientCompanyId the client company's id, which the holder has an account with
     * @return true, if the holder company account exists. Otherwise, false
     */
    public boolean checkHolderCompanyAccount(int holderId, int clientCompanyId);
    
    /**
     * Checks the existence of a holder bond account.
     * @param holderId the holder's id
     * @param bondOfferId the bond offer id, which the holder has an account with
     * @return true, if the holder bond account exists. Otherwise, false
     */
    public boolean checkHolderBondAccount(int holderId, int bondOfferId);
    
    /**
     * Checks the existence of a holder company account.
     * @param chn the holder's chn
     * @return true, if the holder company account exists. Otherwise, false
     */
    public boolean checkHolderCompanyAccount(String chn);
    
    /**
     * Checks the existence of a holder bond account.
     * @param chn the holder's chn
     * @return true, if the holder bond account exists. Otherwise, false
     */
    public boolean checkHolderBondAccount(String chn);
    
    /**
     * Queries the holder changes according to the search parameters.
     * @param descriptor the description of the type of search to carry out
     * @param searchParams the holder changes search parameter
     * @param startDate the start date of the search
     * @param endDate the end date of the search
     * @return the list of holder changes from the search
     */
    public List<HolderChanges> queryHolderChanges(String descriptor, HolderChanges searchParams, String startDate, String endDate);
    
    /**
     * Gets the holder object according to the specified id.
     * @param holderId the holder id
     * @return the holder object
     */
    public Holder getHolder(int holderId);
    
    /**
     * Gets the holder object according to the specified chn.
     * @param chn the holder's chn
     * @return the holder object
     */
    public Holder getHolder(String chn);
    
    /**
     * Gets the holder company account object according to the specified ids.
     * @param holderId the holder id
     * @param clientCompanyId the client company id, which the holder has an account with
     * @return the holder company account object
     */
    public HolderCompanyAccount getHolderCompanyAccount(int holderId, int clientCompanyId);
    
    /**
     * Gets the holder bond account object according to the specified ids.
     * @param holderId the holder id
     * @param bondOfferId the bond offer id, which the holder has an account with
     * @return the holder bond account object
     */
    public HolderBondAccount getHolderBondAccount(int holderId, int bondOfferId);
    
    /**
     * Gets the holder company account object according to the specified chn.
     * @param chn the holder's chn
     * @return the holder company account object
     */
    public HolderCompanyAccount getHolderCompanyAccount(String chn);
    
    /**
     * Gets the holder bond account object according to the specified chn.
     * @param chn the holder's chn
     * @return the holder bond account object
     */
    public HolderBondAccount getHolderBondAccount(String chn);
    
    /**
     * Searches for list of holders according to the provided search parameters.
     * @param descriptor the description of the type of search to carry out
     * @param searchParams the holder search parameters
     * @param shareUnits_search the share units search criteria
     * @param totalHoldings_search the total holdings search criteria
     * @return the list of holders from the search
     */
    public List<Holder> queryHolderAccount(String descriptor, Holder searchParams, Map<String, Integer> shareUnits_search,
            Map<String, Integer> totalHoldings_search);
    
    /**
     * Gets the holder's residential addresses.
     * @param holderId the holder's id
     * @return the list of the holder's residential addresses
     */
    public List<HolderResidentialAddress> getHolderResidentialAddress(int holderId);
    
    /**
     * Gets the holder's residential addresses.
     * @param holderId the holder's id
     * @return the list of the holder's residential addresses
     */
    public List<HolderPostalAddress> getHolderPostalAddress(int holderId);
    
    /**
     * Gets the holder's residential addresses.
     * @param holderId the holder's id
     * @return the list of the holder's residential addresses
     */
    public List<HolderPhoneNumber> getHolderPhoneNumbers(int holderId);
    
    /**
     * Gets the holder's residential addresses.
     * @param holderId the holder's id
     * @return the list of the holder's residential addresses
     */
    public List<HolderEmailAddress> getHolderEmailAddresses(int holderId);
    
    /**
     * Transfers share units from one holder company account to another.
     * @param sender the holder company account sending the share units
     * @param receiver the holder company account receiving the share units
     * @param shareUnits the share units to be sent
     * @return true, if transaction was successful. Otherwise, false
     */
    public boolean transferShareUnits(HolderCompanyAccount sender, HolderCompanyAccount receiver, int shareUnits);
    
    /**
     * Transfers bond units from one holder bond account to another.
     * @param sender the holder bond account sending the bond units
     * @param receiver the holder bond account receiving the bond units
     * @param bondUnits the bond units to be sent
     * @param unitPrice the price per bond unit
     * @return true, if transaction was successful. Otherwise, false
     */
    public boolean transferBondUnits(HolderBondAccount sender, HolderBondAccount receiver, int bondUnits, double unitPrice);
    
    /**
     * Checks if holder has any company account.
     * @param holderId the holder's id
     * @return true, if holder has one or more company accounts
     */
    public boolean hasCompanyAccount(int holderId);
    
    /**
     * Checks if a holder has any bond account.
     * @param holderId the holder's id
     * @return true, if holder has one or more bond accounts
     */
    public boolean hasBondAccount(int holderId);
    
    /**
     * Gets all company accounts for a holder.
     * @param holderId the holder's id
     * @return list of all company accounts for a holder
     */
    public List<HolderCompanyAccount> getAllHolderCompanyAccounts(int holderId);
    
    /**
     * Gets all bond accounts for a holder.
     * @param holderId the holder's id
     * @return list of all bond accounts for a holder
     */
    public List<HolderBondAccount> getAllHolderBondAccounts(int holderId);
    
    public boolean mergeHolderAccounts(Holder primaryHolder, List<Holder> secondaryHolders, List<HolderCompanyAccount> secHolderCompAccts,
            List<HolderBondAccount> secHolderBondAccts);
    
}
