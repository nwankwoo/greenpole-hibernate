package org.greenpole.hibernate.entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import org.greenpole.hibernate.backup_entity.*;
import org.greenpole.hibernate.entity.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Holder generated by hbm2java
 */
public class Holder  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Holder holder;
     private int holderAcctNumber;
     private String firstName;
     private String middleName;
     private String lastName;
     private String type;
     private String gender;
     private Date dob;
     private boolean taxExempted;
     private boolean merged;
     private boolean pryHolder;
     private Set privatePlacementApplications = new HashSet(0);
     private Set holders = new HashSet(0);
     private Set holderGmAttendances = new HashSet(0);
     private Set holderSignatures = new HashSet(0);
     private Set ipoApplications = new HashSet(0);
     private Set holderPhoneNumbers = new HashSet(0);
     private Set suspendedTransactionHolders = new HashSet(0);
     private Set rightsIssueApplications = new HashSet(0);
     private Set digitalCaptures = new HashSet(0);
     private Set processedTransactionHolders = new HashSet(0);
     private Set powerOfAttorneys = new HashSet(0);
     private Set holderResidentialAddresses = new HashSet(0);
     private Set holderCompanyAccounts = new HashSet(0);
     private Set holderPostalAddresses = new HashSet(0);
     private Set stockbrokers = new HashSet(0);
     private Set holderEmailAddresses = new HashSet(0);
     private Set holderVotings = new HashSet(0);
     private Set cautions = new HashSet(0);
     private Set certificates = new HashSet(0);
     private Set administrators = new HashSet(0);

    public Holder() {
    }

    public Holder(Holder holder, int holderAcctNumber, String firstName, String middleName, String lastName, String type, String gender, Date dob, boolean taxExempted, boolean merged, boolean pryHolder, Set privatePlacementApplications, Set holders, Set holderGmAttendances, Set holderSignatures, Set ipoApplications, Set holderPhoneNumbers, Set suspendedTransactionHolders, Set rightsIssueApplications, Set digitalCaptures, Set processedTransactionHolders, Set powerOfAttorneys, Set holderResidentialAddresses, Set holderCompanyAccounts, Set holderPostalAddresses, Set stockbrokers, Set holderEmailAddresses, Set holderVotings, Set cautions, Set certificates, Set administrators) {
       this.holder = holder;
       this.holderAcctNumber = holderAcctNumber;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.type = type;
       this.gender = gender;
       this.dob = dob;
       this.taxExempted = taxExempted;
       this.merged = merged;
       this.pryHolder = pryHolder;
       this.privatePlacementApplications = privatePlacementApplications;
       this.holders = holders;
       this.holderGmAttendances = holderGmAttendances;
       this.holderSignatures = holderSignatures;
       this.ipoApplications = ipoApplications;
       this.holderPhoneNumbers = holderPhoneNumbers;
       this.suspendedTransactionHolders = suspendedTransactionHolders;
       this.rightsIssueApplications = rightsIssueApplications;
       this.digitalCaptures = digitalCaptures;
       this.processedTransactionHolders = processedTransactionHolders;
       this.powerOfAttorneys = powerOfAttorneys;
       this.holderResidentialAddresses = holderResidentialAddresses;
       this.holderCompanyAccounts = holderCompanyAccounts;
       this.holderPostalAddresses = holderPostalAddresses;
       this.stockbrokers = stockbrokers;
       this.holderEmailAddresses = holderEmailAddresses;
       this.holderVotings = holderVotings;
       this.cautions = cautions;
       this.certificates = certificates;
       this.administrators = administrators;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for Holder object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for Holder object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public int getHolderAcctNumber() {
        return this.holderAcctNumber;
    }
    
    public void setHolderAcctNumber(int holderAcctNumber) {
        this.holderAcctNumber = holderAcctNumber;
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
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
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
    public boolean isTaxExempted() {
        return this.taxExempted;
    }
    
    public void setTaxExempted(boolean taxExempted) {
        this.taxExempted = taxExempted;
    }
    public boolean isMerged() {
        return this.merged;
    }
    
    public void setMerged(boolean merged) {
        this.merged = merged;
    }
    public boolean isPryHolder() {
        return this.pryHolder;
    }
    
    public void setPryHolder(boolean pryHolder) {
        this.pryHolder = pryHolder;
    }
    public Set getPrivatePlacementApplications() {
        return this.privatePlacementApplications;
    }
    
    public void setPrivatePlacementApplications(Set privatePlacementApplications) {
        this.privatePlacementApplications = privatePlacementApplications;
    }
    public Set getHolders() {
        return this.holders;
    }
    
    public void setHolders(Set holders) {
        this.holders = holders;
    }
    public Set getHolderGmAttendances() {
        return this.holderGmAttendances;
    }
    
    public void setHolderGmAttendances(Set holderGmAttendances) {
        this.holderGmAttendances = holderGmAttendances;
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
    public Set getHolderCompanyAccounts() {
        return this.holderCompanyAccounts;
    }
    
    public void setHolderCompanyAccounts(Set holderCompanyAccounts) {
        this.holderCompanyAccounts = holderCompanyAccounts;
    }
    public Set getHolderPostalAddresses() {
        return this.holderPostalAddresses;
    }
    
    public void setHolderPostalAddresses(Set holderPostalAddresses) {
        this.holderPostalAddresses = holderPostalAddresses;
    }
    public Set getStockbrokers() {
        return this.stockbrokers;
    }
    
    public void setStockbrokers(Set stockbrokers) {
        this.stockbrokers = stockbrokers;
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
    public Set getAdministrators() {
        return this.administrators;
    }
    
    public void setAdministrators(Set administrators) {
        this.administrators = administrators;
    }




}


