package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BondOffer generated by hbm2java
 */
public class BondOffer  implements java.io.Serializable {


     private int id;
     private long versionId;
     private ClientCompany clientCompany;
     private String title;
     private Double bondUnitPrice;
     private Date bondMaturity;
     private BondType bondType;
     private Double interestRate;
     private BondOfferPaymentPlan bondOfferPaymentPlan;
     private Set holderBondAccounts = new HashSet(0);

    public BondOffer() {
    }

    public BondOffer(ClientCompany clientCompany, String title, Double bondUnitPrice, Date bondMaturity, BondType bondType, Double interestRate, BondOfferPaymentPlan bondOfferPaymentPlan, Set holderBondAccounts) {
       this.clientCompany = clientCompany;
       this.title = title;
       this.bondUnitPrice = bondUnitPrice;
       this.bondMaturity = bondMaturity;
       this.bondType = bondType;
       this.interestRate = interestRate;
       this.bondOfferPaymentPlan = bondOfferPaymentPlan;
       this.holderBondAccounts = holderBondAccounts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * A getter for BobdOffer object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for BondOffer object which persist the 
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
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public Double getBondUnitPrice() {
        return this.bondUnitPrice;
    }
    
    public void setBondUnitPrice(Double bondUnitPrice) {
        this.bondUnitPrice = bondUnitPrice;
    }
    public Date getBondMaturity() {
        return this.bondMaturity;
    }
    
    public void setBondMaturity(Date bondMaturity) {
        this.bondMaturity = bondMaturity;
    }
    public BondType getBondType() {
        return this.bondType;
    }
    
    public void setBondType(BondType bondType) {
        this.bondType = bondType;
    }
    public Double getInterestRate() {
        return this.interestRate;
    }
    
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
    public BondOfferPaymentPlan getPaymentPlan() {
        return this.bondOfferPaymentPlan;
    }
    
    public void setPaymentPlan(BondOfferPaymentPlan paymentPlan) {
        this.bondOfferPaymentPlan = paymentPlan;
    }

    public Set getHolderBondAccounts() {
        return holderBondAccounts;
    }

    public void setHolderBondAccounts(Set holderBondAccounts) {
        this.holderBondAccounts = holderBondAccounts;
    }




}


