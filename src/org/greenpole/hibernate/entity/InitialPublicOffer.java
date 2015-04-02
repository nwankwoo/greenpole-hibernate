package org.greenpole.hibernate.entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import org.greenpole.hibernate.backup_entity.*;
import org.greenpole.hibernate.entity.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * InitialPublicOffer generated by hbm2java
 */
public class InitialPublicOffer  implements java.io.Serializable {


     private int id;
     private int versionId;
     private ClientCompany clientCompany;
     private int totalSharesOnOffer;
     private String methodOnOffer;
     private int startingMinSub;
     private int contMinSub;
     private Double offerPrice;
     private int offerSize;
     private Date openingDate;
     private Date closingDate;
     private Set ipoApplications = new HashSet(0);
     private Set certificates = new HashSet(0);

    public InitialPublicOffer() {
    }

    public InitialPublicOffer(ClientCompany clientCompany, int totalSharesOnOffer, String methodOnOffer, int startingMinSub, int contMinSub, Double offerPrice, int offerSize, Date openingDate, Date closingDate, Set ipoApplications, Set certificates) {
       this.clientCompany = clientCompany;
       this.totalSharesOnOffer = totalSharesOnOffer;
       this.methodOnOffer = methodOnOffer;
       this.startingMinSub = startingMinSub;
       this.contMinSub = contMinSub;
       this.offerPrice = offerPrice;
       this.offerSize = offerSize;
       this.openingDate = openingDate;
       this.closingDate = closingDate;
       this.ipoApplications = ipoApplications;
       this.certificates = certificates;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for InitialPublicOffer object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public int getVersionId() {
        return versionId;
    }
    /**
     * A setter for InitialPublicOffer object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(int versionId) {
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
    public String getMethodOnOffer() {
        return this.methodOnOffer;
    }
    
    public void setMethodOnOffer(String methodOnOffer) {
        this.methodOnOffer = methodOnOffer;
    }
    public int getStartingMinSub() {
        return this.startingMinSub;
    }
    
    public void setStartingMinSub(int startingMinSub) {
        this.startingMinSub = startingMinSub;
    }
    public int getContMinSub() {
        return this.contMinSub;
    }
    
    public void setContMinSub(int contMinSub) {
        this.contMinSub = contMinSub;
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
    public Set getIpoApplications() {
        return this.ipoApplications;
    }
    
    public void setIpoApplications(Set ipoApplications) {
        this.ipoApplications = ipoApplications;
    }
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }




}


