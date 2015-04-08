package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PrivatePlacement generated by hbm2java
 */
public class PrivatePlacement  implements java.io.Serializable {


     private int id;
     private long versionId;
     private ClientCompany clientCompany;
     private int totalSharesOnOffer;
     private int methodOnOffer;
     private int startingMinSubscrptn;
     private int continuingMinSubscrptn;
     private Double offerPrice;
     private int offerSize;
     private Date openingDate;
     private Date closingDate;
     private Set certificates = new HashSet(0);
     private Set privatePlacementApplications = new HashSet(0);

    public PrivatePlacement() {
    }

    public PrivatePlacement(ClientCompany clientCompany, int totalSharesOnOffer, int methodOnOffer, int startingMinSubscrptn, int continuingMinSubscrptn, Double offerPrice, int offerSize, Date openingDate, Date closingDate, Set certificates, Set privatePlacementApplications) {
       this.clientCompany = clientCompany;
       this.totalSharesOnOffer = totalSharesOnOffer;
       this.methodOnOffer = methodOnOffer;
       this.startingMinSubscrptn = startingMinSubscrptn;
       this.continuingMinSubscrptn = continuingMinSubscrptn;
       this.offerPrice = offerPrice;
       this.offerSize = offerSize;
       this.openingDate = openingDate;
       this.closingDate = closingDate;
       this.certificates = certificates;
       this.privatePlacementApplications = privatePlacementApplications;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * A getter for PrivatePlacement object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for PrivatePlacement object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public int getTotalSharesOnOffer() {
        return this.totalSharesOnOffer;
    }
    
    public void setTotalSharesOnOffer(int totalSharesOnOffer) {
        this.totalSharesOnOffer = totalSharesOnOffer;
    }
    public int getMethodOnOffer() {
        return this.methodOnOffer;
    }
    
    public void setMethodOnOffer(int methodOnOffer) {
        this.methodOnOffer = methodOnOffer;
    }
    public int getStartingMinSubscrptn() {
        return this.startingMinSubscrptn;
    }
    
    public void setStartingMinSubscrptn(int startingMinSubscrptn) {
        this.startingMinSubscrptn = startingMinSubscrptn;
    }
    public int getContinuingMinSubscrptn() {
        return this.continuingMinSubscrptn;
    }
    
    public void setContinuingMinSubscrptn(int continuingMinSubscrptn) {
        this.continuingMinSubscrptn = continuingMinSubscrptn;
    }
    public Double getOfferPrice() {
        return this.offerPrice;
    }
    
    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }
    public int getOfferSize() {
        return this.offerSize;
    }
    
    public void setOfferSize(int offerSize) {
        this.offerSize = offerSize;
    }
    public Date getOpeningDate() {
        return this.openingDate;
    }
    
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }
    public Date getClosingDate() {
        return this.closingDate;
    }
    
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }
    public Set getPrivatePlacementApplications() {
        return this.privatePlacementApplications;
    }
    
    public void setPrivatePlacementApplications(Set privatePlacementApplications) {
        this.privatePlacementApplications = privatePlacementApplications;
    }




}


