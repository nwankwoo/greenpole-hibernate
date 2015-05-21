/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.AccountConsolidation;
import org.greenpole.hibernate.entity.BondOfferPaymentPlan;
import org.greenpole.hibernate.entity.CompanyAccountConsolidation;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderChanges;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderEmailAddress;
import org.greenpole.hibernate.entity.HolderPhoneNumber;
import org.greenpole.hibernate.entity.HolderPostalAddress;
import org.greenpole.hibernate.entity.HolderResidentialAddress;
import org.greenpole.hibernate.entity.HolderSignature;
import org.greenpole.hibernate.entity.HolderType;
import org.greenpole.hibernate.entity.PowerOfAttorney;

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
     * @param emailAddresses the holder's email address
     * @param phoneNumbers the holder's phone number
     * @return true, if create transaction is successful
     */
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, List<HolderResidentialAddress> residentialAddresses,
            List<HolderPostalAddress> postalAddresses, List<HolderEmailAddress> emailAddresses, List<HolderPhoneNumber> phoneNumbers);
    
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
     * @param emailAddresses the holder's email address
     * @param phoneNumbers the holder's phone numbers
     * @return true, if create transaction is successful
     */
    public boolean createHolderAccount(Holder holder, HolderBondAccount holderBondAccount, List<HolderResidentialAddress> residentialAddresses,
            List<HolderPostalAddress> postalAddresses, List<HolderEmailAddress> emailAddresses, List<HolderPhoneNumber> phoneNumbers);
    
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
     * @param emailAddresses the holder's email address
     * @param deletedResAddresses the holder's residential addresses to be deleted
     * @param deletedPosAddresses the holder's postal addresses to be deleted
     * @param deletedPhoneNumbers the holder's phone numbers to be deleted
     * @param deletedEmailAddresses the holder's email address to be deleted
     * @param changes recordable changes made to the holder account
     * @return true, if update transaction is successful
     */
    public boolean updateHolderAccount(Holder holder, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses,
            List<HolderPhoneNumber> phoneNumbers, List<HolderEmailAddress> emailAddresses, List<HolderResidentialAddress> deletedResAddresses,
            List<HolderPostalAddress> deletedPosAddresses, List<HolderPhoneNumber> deletedPhoneNumbers, List<HolderEmailAddress> deletedEmailAddresses,  
            List<HolderChanges> changes);
    
    /**
     * Updates an existing holder account (for shareholder and bondholder).
     * This method should only be used when trying to transpose a holder's name, thus
     * no need to update the holder's address and co.
     * @param holder the holder
     */
    public void updateHolderAccountForTranspose(Holder holder);
    
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
     * Queries the holder changes according to the search parameters.
     * @param descriptor the description of the type of search to carry out
     * @param searchParams the holder changes search parameter
     * @param startDate the start date of the search
     * @param endDate the end date of the search
     * @param dateFormat the format with which the dates are set to
     * @return the list of holder changes from the search
     */
    public List<HolderChanges> queryHolderChanges(String descriptor, HolderChanges searchParams, String startDate, String endDate, String dateFormat);
    
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
     * Searches for list of shareholders according to the provided search parameters.
     * @param descriptor the description of the type of search to carry out
     * @param searchParams the shareholder search parameters
     * @param shareUnits_search the share units search criteria
     * @param totalShareHoldings_search the total share holdings search criteria
     * @return the list of holders from the search
     */
    public List<Holder> queryShareholderAccount(String descriptor, Holder searchParams, Map<String, Integer> shareUnits_search,
            Map<String, Integer> totalShareHoldings_search);
    
    /**
     * Searches for list of bond-holders according to the provided search parameters.
     * @param descriptor the description of the type of search to carry out
     * @param searchParams the bond-holder search parameters
     * @param bondUnits_search the bond units search criteria
     * @param totalBondHoldings_search the total bond holdings search criteria
     * @return the list of holders from the search
     */
    public List<Holder> queryBondholderAccount(String descriptor, Holder searchParams, Map<String, Integer> bondUnits_search,
            Map<String, Integer> totalBondHoldings_search);
    
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
     * @param transferTypeId the type of transfer
     * @return true, if transaction was successful. Otherwise, false
     */
    public boolean transferShareUnits(HolderCompanyAccount sender, HolderCompanyAccount receiver, int shareUnits, int transferTypeId);
    
    /**
     * Transfers bond units from one holder bond account to another.
     * @param sender the holder bond account sending the bond units
     * @param receiver the holder bond account receiving the bond units
     * @param bondUnits the bond units to be sent
     * @param unitPrice the price per bond unit
     * @return true, if transaction was successful. Otherwise, false
     */
    public boolean transferBondUnits(HolderBondAccount sender, HolderBondAccount receiver, int bondUnits, double unitPrice, int transferTypeId);
    
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
    
    /**
     * Merges a list of secondary holder accounts to a primary holder account, while moving company / bond accounts
     * from the secondary holder accounts to the primary holder account.
     * @param primaryHolder the primary holder account
     * @param secondaryHolders the list of secondary holder accounts
     * @param secHolderCompAccts the list of company accounts tied to the secondary holder accounts
     * @param secHolderBondAccts the list of legitimate bond accounts tied to the secondary holder accounts
     * @return true if merge was successful. Otherwise, false
     */
    public boolean mergeHolderAccounts(Holder primaryHolder, List<Holder> secondaryHolders, List<HolderCompanyAccount> secHolderCompAccts,
            List<HolderBondAccount> secHolderBondAccts, String pryHolderOriginalValues);
    
    /**
     * Demerges a list of secondary holder accounts from a primary holder account.
     * @param primaryHolder the primary holder account to demerge from
     * @param secondaryAcctInfo consolidation information on the secondary holder accounts
     * @return true if demerge was successful. Otherwise, false
     */
    public boolean demergeHolderAccounts(Holder primaryHolder, Map<Holder, List<CompanyAccountConsolidation>> secondaryAcctInfo);
    
    /**
     * Gets the secondary holder accounts of a primary holder account
     * @param holderId the primary holder account's id
     * @return a list of secondary holder accounts
     */
    public List<Holder> getSecondaryHolderAccounts(int holderId);
    
    /**
     * Check that a secondary holder has a record in the account consolidation table, against
     * a primary holder.
     * @param pryHolderId the primary holder id
     * @param secHolderId the secondary holder id
     * @return true if record exists. Otherwise, false
     */
    public boolean checkInConsolidation(int pryHolderId, int secHolderId);
    
    /**
     * Check that a secondary holder has a record in the company account consolidation table, against
     * a primary holder.
     * @param pryHolderId the primary holder id
     * @param secHolderId the secondary holder id
     * @return true if record exists. Otherwise, false
     */
    public boolean checkInCompAcctConsolidation(int pryHolderId, int secHolderId);
    
    /**
     * Check that a primary holder has secondary holders tied to it.
     * @param holderId the primary holder id
     * @return true if primary holder has secondary holders tied to it. Otherwise, false
     */
    public boolean checkSecondaryHolders(int holderId);
    
    /**
     * Gets the list of company account consolidations of a secondary holder.
     * @param holderId the secondary holder id
     * @return the list of company account consolidations
     */
    public List<CompanyAccountConsolidation> getCompanyAccountMerges(int holderId);
    
    /**
     * Gets the final unit after merge transfer between company/bond accounts.
     * @param holderId the primary holder id (who holds the transfered units)
     * @param compOrBondId the id of the company/bond offer for which the account concerns
     * @param isShare if the final unit is for a share transfer or bond
     * @return the final unit after merge transfer between company accounts
     */
    public int getFinalUnitAfterTransfer(int holderId, int compOrBondId, boolean isShare);

    /**
     * Gets all account consolidation according to specified dates.
     * @param descriptor the description of the type of search to carry out 
     * @param startDate the start date
     * @param endDate the end date
     * @param dateFormat the format of dates
     * @return a list of account consolidation records
     */
    public List<AccountConsolidation> getAllHolderAccountConsolidation(String descriptor, String startDate, String endDate, String dateFormat);
    
    /**
     * Gets all company account consolidation according to the specified account consolidation id.
     * @param acctConsolidationId the account consolidation id
     * @return a list of company account consolidation records
     */
    public List<CompanyAccountConsolidation> getCompAcctConsolidation(int acctConsolidationId);
    
    /**
     * Creates administrators for a holder.
     * @param holder the holder object which holds all administrator objects
     * @return true if creation is successful. Otherwise, false
     */
    public boolean createAdministratorForHolder(Holder holder);
    
    /**
     * Checks the status of a holder's current power of attorney.
     * The holder's current power of attorney should be the power of attorney that
     * has its primary attribute set to true.
     * @param holderId the holder's id
     * @return true if successful. Otherwise, false
     */
    public boolean checkCurrentPowerOfAttorney(int holderId);
    
    /**
     * Gets a holder's current power of attorney.
     * The holder's current power of attorney should be the power of attorney that
     * has its primary attribute set to true.
     * @param holderId
     * @return holder's current power of attorney
     */
    public PowerOfAttorney getCurrentPowerOfAttorney(int holderId);
    
    /**
     * Checks the status of a holder's current signature.
     * @param holderId the holder's id
     * @return true if successful. Otherwise, false
     */
    public boolean checkCurrentSignature(int holderId);
    
    /**
     * Gets a holder's current signature.
     * @param holderId the holder's id
     * @return holder's current signature
     */
    public HolderSignature getCurrentSignature(int holderId);
    
    /**
     * Uploads a new power of attorney to replace the current power of attorney (if there is one).
     * @param newPoa the new power of attorney
     * @param currentPoa the current (soon to be old) power of attorney
     * @return true if upload successful. Otherwise, false
     */
    public boolean uploadPowerOfAttorney(PowerOfAttorney newPoa, PowerOfAttorney currentPoa);
    
    /**
     * Uploads a new holder signature to replace the current holder signature (if there is one).
     * @param newSig the new holder signature
     * @param currentSig the current (soon to be old) holder signature=
     * @return true if upload successful. Otherwise, false
     */
    public boolean uploadHolderSignature(HolderSignature newSig, HolderSignature currentSig);
    
    /**
     * Gets a power of attorney belonging to a holder.
     * @param attorneyId the power of attorney id
     * @return the holder's power of attorney
     */
    public PowerOfAttorney getHolderPowerOfAttorney(int attorneyId);
    
    /**
     * Gets all powers of attorney for a specified holder.
     * @param holderId the holder's id
     * @return the list of the holder's powers of attorney
     */
    public List<PowerOfAttorney> getAllHolderPowerOfAttorney(int holderId);
    
    /**
     * Checks the existence of a bank in the database.
     * @param bankId the bank's id
     * @return true if bank exists. Otherwise, false
     */
    public boolean checkBank(int bankId);
    
    /**
     * Gets all available holder types.
     * @return a list of all holder types
     */
    public List<HolderType> getAllHolderTypes();
}
