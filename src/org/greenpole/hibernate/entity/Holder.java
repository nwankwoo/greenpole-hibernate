package org.greenpole.hibernate.entity;
// Generated 23-Jun-2015 04:56:55 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Holder generated by hbm2java
 */
public class Holder  implements java.io.Serializable {


     private int id;
     private Long version;
     private Holder holder;
     private HolderType holderType;
     private Integer holderAcctNumber;
     private String chn;
     private String firstName;
     private String middleName;
     private String lastName;
     private String gender;
     private Date dob;
     private Boolean taxExempted;
     private Boolean merged;
     private Boolean pryHolder;
     private String pryAddress;
     private Set holders = new HashSet(0);
     private Set holderSignatures = new HashSet(0);
     private Set ipoApplications = new HashSet(0);
     private Set rightsIssueApplications = new HashSet(0);
     private Set digitalCaptures = new HashSet(0);
     private Set processedTransactionHolders = new HashSet(0);
     private Set powerOfAttorneys = new HashSet(0);
     private Set holderResidentialAddresses = new HashSet(0);
     private Set accountConsolidations = new HashSet(0);
     private Set holderPostalAddresses = new HashSet(0);
     private Set holderChangeses = new HashSet(0);
     private Set administrators = new HashSet(0);
     private Set holderBondAccounts = new HashSet(0);
     private Set privatePlacementApplications = new HashSet(0);
     private Set holderGmAttendances = new HashSet(0);
     private Set holderPhoneNumbers = new HashSet(0);
     private Set suspendedTransactionHolders = new HashSet(0);
     private Set textMessages = new HashSet(0);
     private Set holderCompanyAccounts = new HashSet(0);
     private Set stockbrokers = new HashSet(0);
     private Set holderBonuses = new HashSet(0);
     private Set holderEmailAddresses = new HashSet(0);
     private Set holderVotings = new HashSet(0);
     private Set cautions = new HashSet(0);
     private Set certificates = new HashSet(0);

    public Holder() {
    }

    public Holder(Holder holder, HolderType holderType, Integer holderAcctNumber, String chn, String firstName, String middleName, String lastName, String gender, Date dob, Boolean taxExempted, Boolean merged, Boolean pryHolder, String pryAddress, Set holders, Set holderSignatures, Set ipoApplications, Set rightsIssueApplications, Set digitalCaptures, Set processedTransactionHolders, Set powerOfAttorneys, Set holderResidentialAddresses, Set accountConsolidations, Set holderPostalAddresses, Set holderChangeses, Set administrators, Set holderBondAccounts, Set privatePlacementApplications, Set holderGmAttendances, Set holderPhoneNumbers, Set suspendedTransactionHolders, Set textMessages, Set holderCompanyAccounts, Set stockbrokers, Set holderBonuses, Set holderEmailAddresses, Set holderVotings, Set cautions, Set certificates) {
       this.holder = holder;
       this.holderType = holderType;
       this.holderAcctNumber = holderAcctNumber;
       this.chn = chn;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.gender = gender;
       this.dob = dob;
       this.taxExempted = taxExempted;
       this.merged = merged;
       this.pryHolder = pryHolder;
       this.pryAddress = pryAddress;
       this.holders = holders;
       this.holderSignatures = holderSignatures;
       this.ipoApplications = ipoApplications;
       this.rightsIssueApplications = rightsIssueApplications;
       this.digitalCaptures = digitalCaptures;
       this.processedTransactionHolders = processedTransactionHolders;
       this.powerOfAttorneys = powerOfAttorneys;
       this.holderResidentialAddresses = holderResidentialAddresses;
       this.accountConsolidations = accountConsolidations;
       this.holderPostalAddresses = holderPostalAddresses;
       this.holderChangeses = holderChangeses;
       this.administrators = administrators;
       this.holderBondAccounts = holderBondAccounts;
       this.privatePlacementApplications = privatePlacementApplications;
       this.holderGmAttendances = holderGmAttendances;
       this.holderPhoneNumbers = holderPhoneNumbers;
       this.suspendedTransactionHolders = suspendedTransactionHolders;
       this.textMessages = textMessages;
       this.holderCompanyAccounts = holderCompanyAccounts;
       this.stockbrokers = stockbrokers;
       this.holderBonuses = holderBonuses;
       this.holderEmailAddresses = holderEmailAddresses;
       this.holderVotings = holderVotings;
       this.cautions = cautions;
       this.certificates = certificates;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public HolderType getHolderType() {
        return this.holderType;
    }
    
    public void setHolderType(HolderType holderType) {
        this.holderType = holderType;
    }
    public Integer getHolderAcctNumber() {
        return this.holderAcctNumber;
    }
    
    public void setHolderAcctNumber(Integer holderAcctNumber) {
        this.holderAcctNumber = holderAcctNumber;
    }
    public String getChn() {
        return this.chn;
    }
    
    public void setChn(String chn) {
        this.chn = chn;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public Boolean getTaxExempted() {
        return this.taxExempted;
    }
    
    public void setTaxExempted(Boolean taxExempted) {
        this.taxExempted = taxExempted;
    }
    public Boolean getMerged() {
        return this.merged;
    }
    
    public void setMerged(Boolean merged) {
        this.merged = merged;
    }
    public Boolean getPryHolder() {
        return this.pryHolder;
    }
    
    public void setPryHolder(Boolean pryHolder) {
        this.pryHolder = pryHolder;
    }
    public String getPryAddress() {
        return this.pryAddress;
    }
    
    public void setPryAddress(String pryAddress) {
        this.pryAddress = pryAddress;
    }
    public Set getHolders() {
        return this.holders;
    }
    
    public void setHolders(Set holders) {
        this.holders = holders;
    }
    public Set getHolderSignatures() {
        return this.holderSignatures;
    }
    
    public void setHolderSignatures(Set holderSignatures) {
        this.holderSignatures = holderSignatures;
    }
    public Set getIpoApplications() {
        return this.ipoApplications;
    }
    
    public void setIpoApplications(Set ipoApplications) {
        this.ipoApplications = ipoApplications;
    }
    public Set getRightsIssueApplications() {
        return this.rightsIssueApplications;
    }
    
    public void setRightsIssueApplications(Set rightsIssueApplications) {
        this.rightsIssueApplications = rightsIssueApplications;
    }
    public Set getDigitalCaptures() {
        return this.digitalCaptures;
    }
    
    public void setDigitalCaptures(Set digitalCaptures) {
        this.digitalCaptures = digitalCaptures;
    }
    public Set getProcessedTransactionHolders() {
        return this.processedTransactionHolders;
    }
    
    public void setProcessedTransactionHolders(Set processedTransactionHolders) {
        this.processedTransactionHolders = processedTransactionHolders;
    }
    public Set getPowerOfAttorneys() {
        return this.powerOfAttorneys;
    }
    
    public void setPowerOfAttorneys(Set powerOfAttorneys) {
        this.powerOfAttorneys = powerOfAttorneys;
    }
    public Set getHolderResidentialAddresses() {
        return this.holderResidentialAddresses;
    }
    
    public void setHolderResidentialAddresses(Set holderResidentialAddresses) {
        this.holderResidentialAddresses = holderResidentialAddresses;
    }
    public Set getAccountConsolidations() {
        return this.accountConsolidations;
    }
    
    public void setAccountConsolidations(Set accountConsolidations) {
        this.accountConsolidations = accountConsolidations;
    }
    public Set getHolderPostalAddresses() {
        return this.holderPostalAddresses;
    }
    
    public void setHolderPostalAddresses(Set holderPostalAddresses) {
        this.holderPostalAddresses = holderPostalAddresses;
    }
    public Set getHolderChangeses() {
        return this.holderChangeses;
    }
    
    public void setHolderChangeses(Set holderChangeses) {
        this.holderChangeses = holderChangeses;
    }
    public Set getAdministrators() {
        return this.administrators;
    }
    
    public void setAdministrators(Set administrators) {
        this.administrators = administrators;
    }
    public Set getHolderBondAccounts() {
        return this.holderBondAccounts;
    }
    
    public void setHolderBondAccounts(Set holderBondAccounts) {
        this.holderBondAccounts = holderBondAccounts;
    }
    public Set getPrivatePlacementApplications() {
        return this.privatePlacementApplications;
    }
    
    public void setPrivatePlacementApplications(Set privatePlacementApplications) {
        this.privatePlacementApplications = privatePlacementApplications;
    }
    public Set getHolderGmAttendances() {
        return this.holderGmAttendances;
    }
    
    public void setHolderGmAttendances(Set holderGmAttendances) {
        this.holderGmAttendances = holderGmAttendances;
    }
    public Set getHolderPhoneNumbers() {
        return this.holderPhoneNumbers;
    }
    
    public void setHolderPhoneNumbers(Set holderPhoneNumbers) {
        this.holderPhoneNumbers = holderPhoneNumbers;
    }
    public Set getSuspendedTransactionHolders() {
        return this.suspendedTransactionHolders;
    }
    
    public void setSuspendedTransactionHolders(Set suspendedTransactionHolders) {
        this.suspendedTransactionHolders = suspendedTransactionHolders;
    }
    public Set getTextMessages() {
        return this.textMessages;
    }
    
    public void setTextMessages(Set textMessages) {
        this.textMessages = textMessages;
    }
    public Set getHolderCompanyAccounts() {
        return this.holderCompanyAccounts;
    }
    
    public void setHolderCompanyAccounts(Set holderCompanyAccounts) {
        this.holderCompanyAccounts = holderCompanyAccounts;
    }
    public Set getStockbrokers() {
        return this.stockbrokers;
    }
    
    public void setStockbrokers(Set stockbrokers) {
        this.stockbrokers = stockbrokers;
    }
    public Set getHolderBonuses() {
        return this.holderBonuses;
    }
    
    public void setHolderBonuses(Set holderBonuses) {
        this.holderBonuses = holderBonuses;
    }
    public Set getHolderEmailAddresses() {
        return this.holderEmailAddresses;
    }
    
    public void setHolderEmailAddresses(Set holderEmailAddresses) {
        this.holderEmailAddresses = holderEmailAddresses;
    }
    public Set getHolderVotings() {
        return this.holderVotings;
    }
    
    public void setHolderVotings(Set holderVotings) {
        this.holderVotings = holderVotings;
    }
    public Set getCautions() {
        return this.cautions;
    }
    
    public void setCautions(Set cautions) {
        this.cautions = cautions;
    }
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }




}


