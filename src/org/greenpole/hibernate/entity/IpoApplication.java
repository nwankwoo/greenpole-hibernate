package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 12:07:06 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * IpoApplication generated by hbm2java
 */
public class IpoApplication  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClearingHouse clearingHouse;
     private Holder holder;
     private InitialPublicOffer initialPublicOffer;
     private String issuer;
     private Integer sharesSubscribed;
     private Double amountPaid;
     private String issuingHouse;
     private Double sharesSubscribedValue;
     private Integer sharesAdjusted;
     private Double returnMoney;
     private Boolean processingPayment;
     private Boolean approved;
     private Boolean canceled;
     private Date dateApplied;

    public IpoApplication() {
    }

    public IpoApplication(ClearingHouse clearingHouse, Holder holder, InitialPublicOffer initialPublicOffer, String issuer, Integer sharesSubscribed, Double amountPaid, String issuingHouse, Double sharesSubscribedValue, Integer sharesAdjusted, Double returnMoney, Boolean processingPayment, Boolean approved, Boolean canceled, Date dateApplied) {
       this.clearingHouse = clearingHouse;
       this.holder = holder;
       this.initialPublicOffer = initialPublicOffer;
       this.issuer = issuer;
       this.sharesSubscribed = sharesSubscribed;
       this.amountPaid = amountPaid;
       this.issuingHouse = issuingHouse;
       this.sharesSubscribedValue = sharesSubscribedValue;
       this.sharesAdjusted = sharesAdjusted;
       this.returnMoney = returnMoney;
       this.processingPayment = processingPayment;
       this.approved = approved;
       this.canceled = canceled;
       this.dateApplied = dateApplied;
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
    public ClearingHouse getClearingHouse() {
        return this.clearingHouse;
    }
    
    public void setClearingHouse(ClearingHouse clearingHouse) {
        this.clearingHouse = clearingHouse;
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
    public String getIssuer() {
        return this.issuer;
    }
    
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    public Integer getSharesSubscribed() {
        return this.sharesSubscribed;
    }
    
    public void setSharesSubscribed(Integer sharesSubscribed) {
        this.sharesSubscribed = sharesSubscribed;
    }
    public Double getAmountPaid() {
        return this.amountPaid;
    }
    
    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public String getIssuingHouse() {
        return this.issuingHouse;
    }
    
    public void setIssuingHouse(String issuingHouse) {
        this.issuingHouse = issuingHouse;
    }
    public Double getSharesSubscribedValue() {
        return this.sharesSubscribedValue;
    }
    
    public void setSharesSubscribedValue(Double sharesSubscribedValue) {
        this.sharesSubscribedValue = sharesSubscribedValue;
    }
    public Integer getSharesAdjusted() {
        return this.sharesAdjusted;
    }
    
    public void setSharesAdjusted(Integer sharesAdjusted) {
        this.sharesAdjusted = sharesAdjusted;
    }
    public Double getReturnMoney() {
        return this.returnMoney;
    }
    
    public void setReturnMoney(Double returnMoney) {
        this.returnMoney = returnMoney;
    }
    public Boolean getProcessingPayment() {
        return this.processingPayment;
    }
    
    public void setProcessingPayment(Boolean processingPayment) {
        this.processingPayment = processingPayment;
    }
    public Boolean getApproved() {
        return this.approved;
    }
    
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    public Boolean getCanceled() {
        return this.canceled;
    }
    
    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }
    public Date getDateApplied() {
        return this.dateApplied;
    }
    
    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }




}


