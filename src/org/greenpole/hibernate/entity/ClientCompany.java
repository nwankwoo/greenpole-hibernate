package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:17:29 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ClientCompany generated by hbm2java
 */
public class ClientCompany  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private Depository depository;
     private NseSector nseSector;
     private String name;
     private String code;
     private String ceo;
     private String secretary;
     private String depository_1;
     private Boolean valid;
     private Boolean merged;
     private Boolean clientCompanyPrimary;
     private Set clientCompanies = new HashSet(0);
     private Set initialPublicOffers = new HashSet(0);
     private Set shareBonuses = new HashSet(0);
     private Set gms = new HashSet(0);
     private Set certificates = new HashSet(0);
     private Set dividends = new HashSet(0);
     private Set holderCompanyAccounts = new HashSet(0);
     private Set reconstructions = new HashSet(0);
     private Set clientCompanyAddresses = new HashSet(0);
     private Set clientCompanyPhoneNumbers = new HashSet(0);
     private Set clientCompanyEmailAddresses = new HashSet(0);
     private Set privatePlacements = new HashSet(0);
     private Set shareQuotations = new HashSet(0);
     private Set dividendDeclareds = new HashSet(0);
     private Set processedTransactions = new HashSet(0);
     private Set rightsIssues = new HashSet(0);
     private Set suspendedTransactions = new HashSet(0);
     private Set bondOffers = new HashSet(0);

    public ClientCompany() {
    }

    public ClientCompany(ClientCompany clientCompany, Depository depository, NseSector nseSector, String name, String code, String ceo, String secretary, String depository_1, Boolean valid, Boolean merged, Boolean clientCompanyPrimary, Set clientCompanies, Set initialPublicOffers, Set shareBonuses, Set gms, Set certificates, Set dividends, Set holderCompanyAccounts, Set reconstructions, Set clientCompanyAddresses, Set clientCompanyPhoneNumbers, Set clientCompanyEmailAddresses, Set privatePlacements, Set shareQuotations, Set dividendDeclareds, Set processedTransactions, Set rightsIssues, Set suspendedTransactions, Set bondOffers) {
       this.clientCompany = clientCompany;
       this.depository = depository;
       this.nseSector = nseSector;
       this.name = name;
       this.code = code;
       this.ceo = ceo;
       this.secretary = secretary;
       this.depository_1 = depository_1;
       this.valid = valid;
       this.merged = merged;
       this.clientCompanyPrimary = clientCompanyPrimary;
       this.clientCompanies = clientCompanies;
       this.initialPublicOffers = initialPublicOffers;
       this.shareBonuses = shareBonuses;
       this.gms = gms;
       this.certificates = certificates;
       this.dividends = dividends;
       this.holderCompanyAccounts = holderCompanyAccounts;
       this.reconstructions = reconstructions;
       this.clientCompanyAddresses = clientCompanyAddresses;
       this.clientCompanyPhoneNumbers = clientCompanyPhoneNumbers;
       this.clientCompanyEmailAddresses = clientCompanyEmailAddresses;
       this.privatePlacements = privatePlacements;
       this.shareQuotations = shareQuotations;
       this.dividendDeclareds = dividendDeclareds;
       this.processedTransactions = processedTransactions;
       this.rightsIssues = rightsIssues;
       this.suspendedTransactions = suspendedTransactions;
       this.bondOffers = bondOffers;
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
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public Depository getDepository() {
        return this.depository;
    }
    
    public void setDepository(Depository depository) {
        this.depository = depository;
    }
    public NseSector getNseSector() {
        return this.nseSector;
    }
    
    public void setNseSector(NseSector nseSector) {
        this.nseSector = nseSector;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getCeo() {
        return this.ceo;
    }
    
    public void setCeo(String ceo) {
        this.ceo = ceo;
    }
    public String getSecretary() {
        return this.secretary;
    }
    
    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }
    public String getDepository_1() {
        return this.depository_1;
    }
    
    public void setDepository_1(String depository_1) {
        this.depository_1 = depository_1;
    }
    public Boolean getValid() {
        return this.valid;
    }
    
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    public Boolean getMerged() {
        return this.merged;
    }
    
    public void setMerged(Boolean merged) {
        this.merged = merged;
    }
    public Boolean getClientCompanyPrimary() {
        return this.clientCompanyPrimary;
    }
    
    public void setClientCompanyPrimary(Boolean clientCompanyPrimary) {
        this.clientCompanyPrimary = clientCompanyPrimary;
    }
    public Set getClientCompanies() {
        return this.clientCompanies;
    }
    
    public void setClientCompanies(Set clientCompanies) {
        this.clientCompanies = clientCompanies;
    }
    public Set getInitialPublicOffers() {
        return this.initialPublicOffers;
    }
    
    public void setInitialPublicOffers(Set initialPublicOffers) {
        this.initialPublicOffers = initialPublicOffers;
    }
    public Set getShareBonuses() {
        return this.shareBonuses;
    }
    
    public void setShareBonuses(Set shareBonuses) {
        this.shareBonuses = shareBonuses;
    }
    public Set getGms() {
        return this.gms;
    }
    
    public void setGms(Set gms) {
        this.gms = gms;
    }
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }
    public Set getDividends() {
        return this.dividends;
    }
    
    public void setDividends(Set dividends) {
        this.dividends = dividends;
    }
    public Set getHolderCompanyAccounts() {
        return this.holderCompanyAccounts;
    }
    
    public void setHolderCompanyAccounts(Set holderCompanyAccounts) {
        this.holderCompanyAccounts = holderCompanyAccounts;
    }
    public Set getReconstructions() {
        return this.reconstructions;
    }
    
    public void setReconstructions(Set reconstructions) {
        this.reconstructions = reconstructions;
    }
    public Set getClientCompanyAddresses() {
        return this.clientCompanyAddresses;
    }
    
    public void setClientCompanyAddresses(Set clientCompanyAddresses) {
        this.clientCompanyAddresses = clientCompanyAddresses;
    }
    public Set getClientCompanyPhoneNumbers() {
        return this.clientCompanyPhoneNumbers;
    }
    
    public void setClientCompanyPhoneNumbers(Set clientCompanyPhoneNumbers) {
        this.clientCompanyPhoneNumbers = clientCompanyPhoneNumbers;
    }
    public Set getClientCompanyEmailAddresses() {
        return this.clientCompanyEmailAddresses;
    }
    
    public void setClientCompanyEmailAddresses(Set clientCompanyEmailAddresses) {
        this.clientCompanyEmailAddresses = clientCompanyEmailAddresses;
    }
    public Set getPrivatePlacements() {
        return this.privatePlacements;
    }
    
    public void setPrivatePlacements(Set privatePlacements) {
        this.privatePlacements = privatePlacements;
    }
    public Set getShareQuotations() {
        return this.shareQuotations;
    }
    
    public void setShareQuotations(Set shareQuotations) {
        this.shareQuotations = shareQuotations;
    }
    public Set getDividendDeclareds() {
        return this.dividendDeclareds;
    }
    
    public void setDividendDeclareds(Set dividendDeclareds) {
        this.dividendDeclareds = dividendDeclareds;
    }
    public Set getProcessedTransactions() {
        return this.processedTransactions;
    }
    
    public void setProcessedTransactions(Set processedTransactions) {
        this.processedTransactions = processedTransactions;
    }
    public Set getRightsIssues() {
        return this.rightsIssues;
    }
    
    public void setRightsIssues(Set rightsIssues) {
        this.rightsIssues = rightsIssues;
    }
    public Set getSuspendedTransactions() {
        return this.suspendedTransactions;
    }
    
    public void setSuspendedTransactions(Set suspendedTransactions) {
        this.suspendedTransactions = suspendedTransactions;
    }
    public Set getBondOffers() {
        return this.bondOffers;
    }
    
    public void setBondOffers(Set bondOffers) {
        this.bondOffers = bondOffers;
    }




}


