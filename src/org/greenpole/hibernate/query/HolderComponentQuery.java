/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.AccountConsolidation;
import org.greenpole.hibernate.entity.Administrator;
import org.greenpole.hibernate.entity.AdministratorEmailAddress;
import org.greenpole.hibernate.entity.AdministratorPhoneNumber;
import org.greenpole.hibernate.entity.AdministratorPostalAddress;
import org.greenpole.hibernate.entity.AdministratorResidentialAddress;
import org.greenpole.hibernate.entity.Bank;
import org.greenpole.hibernate.entity.CompanyAccountConsolidation;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderChangeType;
import org.greenpole.hibernate.entity.HolderChanges;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderEmailAddress;
import org.greenpole.hibernate.entity.HolderPhoneNumber;
import org.greenpole.hibernate.entity.HolderPostalAddress;
import org.greenpole.hibernate.entity.HolderResidentialAddress;
import org.greenpole.hibernate.entity.HolderSignature;
import org.greenpole.hibernate.entity.HolderType;
import org.greenpole.hibernate.entity.IpoApplication;
import org.greenpole.hibernate.entity.PowerOfAttorney;
import org.greenpole.hibernate.entity.PrivatePlacementApplication;
import org.greenpole.hibernate.entity.RightsIssue;
import org.greenpole.hibernate.entity.RightsIssueApplication;
import org.greenpole.hibernate.entity.TransactionType;

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
     * @param changes recordable changes made to the holder account
     * @return true, if update transaction is successful
     */
    public boolean updateHolderAccount(Holder holder, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses,
            List<HolderPhoneNumber> phoneNumbers, List<HolderEmailAddress> emailAddresses, List<HolderChanges> changes);
    
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
     * Checks the existence of a holder.
     * @param firstName the holder's first name
     * @param lastName the holder's last name
     * @return true, if the holder exists. Otherwise, false
     */
    public boolean checkHolderAccount(String firstName, String lastName);
    
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
     * Gets all holder change types.
     * @return a list of all holder change types
     */
    public List<HolderChangeType> getAllChangeTypes();
    
    /**
     * Gets a holder change type according to a specified id.
     * @param typeId the holder change type id
     * @return the holder change type object
     */
    public HolderChangeType getChangeType(int typeId);
    
    /**
     * Checks if a holder change type exists.
     * @param typeId the holder change type id
     * @return true, if holder change type exists. Otherwise, false
     */
    public boolean checkChangeType(int typeId);
    
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
     * Gets all primary holders in the system.
     * @param isShareholder whether to search for all shareholders or bond-holders
     * @return a list of all primary holders in the system
     */
    public List<Holder> getAllHolders(boolean isShareholder);
    
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
     * Gets an administrator according to a specified id.
     * @param administratorId the administrator id
     * @return the administrator object
     */
    public Administrator getAdministrator(int administratorId);
    
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
    public List<HolderResidentialAddress> getHolderResidentialAddresses(int holderId);
    
    /**
     * Gets the holder's residential address according to a specified id.
     * @param id the holder address id
     * @return the holder's address
     */
    public HolderResidentialAddress getHolderResidentialAddress(int id);
    
    /**
     * Gets the holder's residential addresses.
     * @param holderId the holder's id
     * @return the list of the holder's residential addresses
     */
    public List<HolderPostalAddress> getHolderPostalAddresses(int holderId);
    
    /**
     * Gets the holder's residential address according to a specified id.
     * @param id the holder address id
     * @return the holder's address
     */
    public HolderPostalAddress getHolderPostalAddress(int id);
    
    /**
     * Gets the holder's residential addresses.
     * @param holderId the holder's id
     * @return the list of the holder's residential addresses
     */
    public List<HolderPhoneNumber> getHolderPhoneNumbers(int holderId);
    
    /**
     * Gets the holder's primary phone number.
     * @param holderId the holder's id
     * @return the holder's primary phone number
     */
    public String getHolderPryPhoneNumber(int holderId);
    
    /**
     * Gets the holder's phone number according to a specified id.
     * @param id the holder phone number id
     * @return the holder's phone number
     */
    public HolderPhoneNumber getHolderPhoneNumber(int id);
    
    /**
     * Gets the holder's residential addresses.
     * @param holderId the holder's id
     * @return the list of the holder's residential addresses
     */
    public List<HolderEmailAddress> getHolderEmailAddresses(int holderId);
    
    /**
     * Gets the holder's email address according to a specified id.
     * @param id the holder email address id
     * @return the holder's email address
     */
    public HolderEmailAddress getHolderEmailAddress(int id);
    
    /**
     * Gets the administrator's residential address according to a specified id
     * @param id the administrator residential id
     * @return the administrator's residential address
     */
    public AdministratorResidentialAddress getAdministratorResidentialAddress(int id);
    
    /**
     * Gets the administrator's postal address according to a specified id
     * @param id the administrator postal id
     * @return the administrator's postal address
     */
    public AdministratorPostalAddress getAdministratorPostalAddress(int id);
    
    /**
     * Gets the administrator's email address according to a specified id.
     * @param id the administrator email id
     * @return the administrator's email address
     */
    public AdministratorEmailAddress getAdministratorEmailAddress(int id);
    
    /**
     * Gets all email addresses belonging to a specified administrator
     * @param administratorId the administrator id
     * @return the list of all email addresses belonging to a specified administrator
     */
    public List<AdministratorEmailAddress> getAdministratorEmailAddresses(int administratorId);
    
    /**
     * Gets the administrator's phone number according to a specified id.
     * @param id the administrator phone number id
     * @return the administrator's phone number
     */
    public AdministratorPhoneNumber getAdministratorPhoneNumber(int id);
    
    /**
     * Gets all phone numbers belonging to a specified administrator
     * @param administratorId the administrator id
     * @return the list of all phone numbers belonging to a specified administrator
     */
    public List<AdministratorPhoneNumber> getAdministratorPhoneNumbers(int administratorId);
    
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
     * @param transferTypeId the type of transfer
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
     * @param pryHolderOriginalValues the original values stored in the holder account before merge
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
     * Gets all company account consolidation according to the specified account consolidation id.
     * This method does not consider whether the company account has been de-merged.
     * @param acctConsolidationId the account consolidation id
     * @return a list of company account consolidation records
     */
    public List<CompanyAccountConsolidation> getCompAcctConsolidationIgnoreDemerge(int acctConsolidationId);
    
    /**
     * Creates administrators for a holder.
     * @param holder the holder object which holds all administrator objects
     * @param change the change object which holds changes to the holder
     * @return true if creation is successful. Otherwise, false
     */
    public boolean createAdministratorForHolder(Holder holder, HolderChanges change);
    
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
    
    /**
     * Gets the holder type according to a specified id.
     * @param typeId the holder type id
     * @return the holder type object
     */
    public HolderType getHolderType(int typeId);
    /**
     * Gets all available transaction types.
     * @return a list of all transaction types
     */
    public List<TransactionType> getAllTransactionTypes();
    
    /**
     * Gets the transaction type according to a specified id.
     * @param typeId the transaction type id
     * @return the transaction type object
     */
    public TransactionType getTransactionType(int typeId);
    
    /**
     * Gets the details of a bank in the database.
     * @param bankId the bank id
     * @return the bank object
     */
    public Bank getBankDetails(int bankId);
    
    /**
     * Checks if holder has an ESOP company account
     * @param holderId the holder id
     * @return true, if holder has an ESOP company account. Otherwise, false
     */
    public boolean holderHasEsopAccount(int holderId);
    
    /**
     * Persists a holder's ipo application in the database.
     * @param application the holder's ipo application
     * @return true, if persistence is successful. Otherwise, false
     */
    public boolean applyForIpo(IpoApplication application);
    
    /**
     * Persists holders' ipo applications in the database.
     * @param applications the list of holder ipo applications
     * @return true, if persistence is successful. Otherwise, false
     */
    public boolean applyForIpoMultiple(List<IpoApplication> applications);
    
    /**
     * Persists a holder's private placement application in the database.
     * @param application the holder's private placement application
     * @return true, if persistence is successful. Otherwise, false
     */
    public boolean applyForPrivatePlacement(PrivatePlacementApplication application);
    
    /**
     * Persists holders' private placement applications in the database.
     * @param applications the list of holders' private placement applications
     * @return true, if persistence is successful. Otherwise, false
     */
    public boolean applyForPrivatePlacementMultiple(List<PrivatePlacementApplication> applications);
    
    /**
     * Persists a holder's rights issue application in the database.
     * @param application the holder's rights issue application
     * @return true, if persistence is successful. Otherwise, false
     */
    public boolean applyForRightsIssue(RightsIssueApplication application);
    
    /**
     * Persists holders' rights issue applications in the database.
     * @param applications the list of holders' rights issue applications
     * @return true, if persistence is successful. Otherwise, false
     */
    public boolean applyForRightsIssueMultiple(List<RightsIssueApplication> applications);
    
    /**
     * Gets the ipo application according to a specified id.
     * @param applicationId the ipo application id
     * @return the ipo application object
     */
    public IpoApplication getIpoApplication(int applicationId);
    
    /**
     * Gets the private placement application according to a specified id.
     * @param applicationId the private placement id
     * @return the private placement object
     */
    public PrivatePlacementApplication getPrivatePlacementApplication(int applicationId);
    
    /**
     * Gets the rights issue application according to a specified id.
     * @param applicationId the rights issue application id
     * @return the rights issue application object
     */
    public RightsIssueApplication getRightsIssueApplication(int applicationId);
    
    /**
     * Checks if a holder bearing the specified first and last name combination has#
     * a CHN.
     * @param firstName holder first name
     * @param lastName holder last name
     * @return true, if holder has CHN. Otherwise, false
     */
    public boolean holderHasCHN(String firstName, String lastName);
}
