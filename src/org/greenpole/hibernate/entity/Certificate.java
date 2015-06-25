package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 15:58:53 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Certificate generated by hbm2java
 */
public class Certificate  implements java.io.Serializable {


     private int id;
     private Long version;
     private CertificateLodgement certificateLodgement;
     private ClientCompany clientCompany;
     private Holder holder;
     private InitialPublicOffer initialPublicOffer;
     private PrivatePlacement privatePlacement;
     private RightsIssue rightsIssue;
     private ShareBonus shareBonus;
     private int certificateNumber;
     private String controlNumber;
     private Integer shareVolume;
     private Integer bondHolding;
     private String holderName;
     private String holderAddress;
     private String issuingCompName;
     private Date issueDate;
     private String certNarration;
     private Boolean cancelled;
     private Boolean claimed;
     private Boolean immobStatus;
     private Set certificateTransfers = new HashSet(0);
     private Set certificateChangeRecords = new HashSet(0);
     private Set certificateEvents = new HashSet(0);
     private Set certificateVerifications = new HashSet(0);

    public Certificate() {
    }

	
    public Certificate(int certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
    public Certificate(CertificateLodgement certificateLodgement, ClientCompany clientCompany, Holder holder, InitialPublicOffer initialPublicOffer, PrivatePlacement privatePlacement, RightsIssue rightsIssue, ShareBonus shareBonus, int certificateNumber, String controlNumber, Integer shareVolume, Integer bondHolding, String holderName, String holderAddress, String issuingCompName, Date issueDate, String certNarration, Boolean cancelled, Boolean claimed, Boolean immobStatus, Set certificateTransfers, Set certificateChangeRecords, Set certificateEvents, Set certificateVerifications) {
       this.certificateLodgement = certificateLodgement;
       this.clientCompany = clientCompany;
       this.holder = holder;
       this.initialPublicOffer = initialPublicOffer;
       this.privatePlacement = privatePlacement;
       this.rightsIssue = rightsIssue;
       this.shareBonus = shareBonus;
       this.certificateNumber = certificateNumber;
       this.controlNumber = controlNumber;
       this.shareVolume = shareVolume;
       this.bondHolding = bondHolding;
       this.holderName = holderName;
       this.holderAddress = holderAddress;
       this.issuingCompName = issuingCompName;
       this.issueDate = issueDate;
       this.certNarration = certNarration;
       this.cancelled = cancelled;
       this.claimed = claimed;
       this.immobStatus = immobStatus;
       this.certificateTransfers = certificateTransfers;
       this.certificateChangeRecords = certificateChangeRecords;
       this.certificateEvents = certificateEvents;
       this.certificateVerifications = certificateVerifications;
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
    public CertificateLodgement getCertificateLodgement() {
        return this.certificateLodgement;
    }
    
    public void setCertificateLodgement(CertificateLodgement certificateLodgement) {
        this.certificateLodgement = certificateLodgement;
    }
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public InitialPublicOffer getInitialPublicOffer() {
        return this.initialPublicOffer;
    }
    
    public void setInitialPublicOffer(InitialPublicOffer initialPublicOffer) {
        this.initialPublicOffer = initialPublicOffer;
    }
    public PrivatePlacement getPrivatePlacement() {
        return this.privatePlacement;
    }
    
    public void setPrivatePlacement(PrivatePlacement privatePlacement) {
        this.privatePlacement = privatePlacement;
    }
    public RightsIssue getRightsIssue() {
        return this.rightsIssue;
    }
    
    public void setRightsIssue(RightsIssue rightsIssue) {
        this.rightsIssue = rightsIssue;
    }
    public ShareBonus getShareBonus() {
        return this.shareBonus;
    }
    
    public void setShareBonus(ShareBonus shareBonus) {
        this.shareBonus = shareBonus;
    }
    public int getCertificateNumber() {
        return this.certificateNumber;
    }
    
    public void setCertificateNumber(int certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
    public String getControlNumber() {
        return this.controlNumber;
    }
    
    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }
    public Integer getShareVolume() {
        return this.shareVolume;
    }
    
    public void setShareVolume(Integer shareVolume) {
        this.shareVolume = shareVolume;
    }
    public Integer getBondHolding() {
        return this.bondHolding;
    }
    
    public void setBondHolding(Integer bondHolding) {
        this.bondHolding = bondHolding;
    }
    public String getHolderName() {
        return this.holderName;
    }
    
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public String getHolderAddress() {
        return this.holderAddress;
    }
    
    public void setHolderAddress(String holderAddress) {
        this.holderAddress = holderAddress;
    }
    public String getIssuingCompName() {
        return this.issuingCompName;
    }
    
    public void setIssuingCompName(String issuingCompName) {
        this.issuingCompName = issuingCompName;
    }
    public Date getIssueDate() {
        return this.issueDate;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public String getCertNarration() {
        return this.certNarration;
    }
    
    public void setCertNarration(String certNarration) {
        this.certNarration = certNarration;
    }
    public Boolean getCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
    public Boolean getClaimed() {
        return this.claimed;
    }
    
    public void setClaimed(Boolean claimed) {
        this.claimed = claimed;
    }
    public Boolean getImmobStatus() {
        return this.immobStatus;
    }
    
    public void setImmobStatus(Boolean immobStatus) {
        this.immobStatus = immobStatus;
    }
    public Set getCertificateTransfers() {
        return this.certificateTransfers;
    }
    
    public void setCertificateTransfers(Set certificateTransfers) {
        this.certificateTransfers = certificateTransfers;
    }
    public Set getCertificateChangeRecords() {
        return this.certificateChangeRecords;
    }
    
    public void setCertificateChangeRecords(Set certificateChangeRecords) {
        this.certificateChangeRecords = certificateChangeRecords;
    }
    public Set getCertificateEvents() {
        return this.certificateEvents;
    }
    
    public void setCertificateEvents(Set certificateEvents) {
        this.certificateEvents = certificateEvents;
    }
    public Set getCertificateVerifications() {
        return this.certificateVerifications;
    }
    
    public void setCertificateVerifications(Set certificateVerifications) {
        this.certificateVerifications = certificateVerifications;
    }




}


