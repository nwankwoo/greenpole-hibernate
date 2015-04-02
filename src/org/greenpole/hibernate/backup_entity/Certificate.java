package org.greenpole.hibernate.backup_entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import org.greenpole.hibernate.entity.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Certificate generated by hbm2java
 */
public class Certificate  implements java.io.Serializable {


     private int id;
     private long versionId;
     private CertificateLodgement certificateLodgement;
     private ClientCompany clientCompany;
     private Holder holder;
     private InitialPublicOffer initialPublicOffer;
     private PrivatePlacement privatePlacement;
     private RightsIssue rightsIssue;
     private ShareBonus shareBonus;
     private int certificateNumber;
     private int shareVolume;
     private int bondHolding;
     private String holderName;
     private String holderAddress;
     private String issuingCompName;
     private Date issueDate;
     private String certNarration;
     private boolean cancelled;
     private boolean claimed;
     private boolean immobStatus;
     private Set certificateVerifications = new HashSet(0);

    public Certificate() {
    }

    public Certificate(CertificateLodgement certificateLodgement, ClientCompany clientCompany, Holder holder, InitialPublicOffer initialPublicOffer, PrivatePlacement privatePlacement, RightsIssue rightsIssue, ShareBonus shareBonus, int certificateNumber, int shareVolume, int bondHolding, String holderName, String holderAddress, String issuingCompName, Date issueDate, String certNarration, boolean cancelled, boolean claimed, boolean immobStatus, Set certificateVerifications) {
       this.certificateLodgement = certificateLodgement;
       this.clientCompany = clientCompany;
       this.holder = holder;
       this.initialPublicOffer = initialPublicOffer;
       this.privatePlacement = privatePlacement;
       this.rightsIssue = rightsIssue;
       this.shareBonus = shareBonus;
       this.certificateNumber = certificateNumber;
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
       this.certificateVerifications = certificateVerifications;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for Certificate object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for Certificate object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
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
    public int getShareVolume() {
        return this.shareVolume;
    }
    
    public void setShareVolume(int shareVolume) {
        this.shareVolume = shareVolume;
    }
    public int getBondHolding() {
        return this.bondHolding;
    }
    
    public void setBondHolding(int bondHolding) {
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
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
    public boolean isClaimed() {
        return this.claimed;
    }
    
    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }
    public boolean isImmobStatus() {
        return this.immobStatus;
    }
    
    public void setImmobStatus(boolean immobStatus) {
        this.immobStatus = immobStatus;
    }
    public Set getCertificateVerifications() {
        return this.certificateVerifications;
    }
    
    public void setCertificateVerifications(Set certificateVerifications) {
        this.certificateVerifications = certificateVerifications;
    }




}


