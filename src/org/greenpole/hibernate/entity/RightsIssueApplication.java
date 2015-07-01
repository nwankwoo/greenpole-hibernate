package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * RightsIssueApplication generated by hbm2java
 */
public class RightsIssueApplication  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClearingHouse clearingHouse;
     private Holder holder;
     private RightsIssue rightsIssue;
     private String issuer;
     private Integer totalHoldings;
     private Integer allottedRights;
     private Integer sharesSubscribed;
     private Integer additionalSharesSubscribed;
     private Integer additionalSharesGiven;
     private Double amountPaid;
     private String issuingHouse;
     private Double sharesSubscribedValue;
     private Double additionalSharesSubValue;
     private Double additionalSharesGivenValue;
     private Double totalValue;
     private Integer totalSharesRenounced;
     private Double returnMoney;
     private Boolean processingPayment;
     private Boolean approved;
     private Boolean canceled;
     private Date dateApplied;

    public RightsIssueApplication() {
    }

    public RightsIssueApplication(ClearingHouse clearingHouse, Holder holder, RightsIssue rightsIssue, String issuer, Integer totalHoldings, Integer allottedRights, Integer sharesSubscribed, Integer additionalSharesSubscribed, Integer additionalSharesGiven, Double amountPaid, String issuingHouse, Double sharesSubscribedValue, Double additionalSharesSubValue, Double additionalSharesGivenValue, Double totalValue, Integer totalSharesRenounced, Double returnMoney, Boolean processingPayment, Boolean approved, Boolean canceled, Date dateApplied) {
       this.clearingHouse = clearingHouse;
       this.holder = holder;
       this.rightsIssue = rightsIssue;
       this.issuer = issuer;
       this.totalHoldings = totalHoldings;
       this.allottedRights = allottedRights;
       this.sharesSubscribed = sharesSubscribed;
       this.additionalSharesSubscribed = additionalSharesSubscribed;
       this.additionalSharesGiven = additionalSharesGiven;
       this.amountPaid = amountPaid;
       this.issuingHouse = issuingHouse;
       this.sharesSubscribedValue = sharesSubscribedValue;
       this.additionalSharesSubValue = additionalSharesSubValue;
       this.additionalSharesGivenValue = additionalSharesGivenValue;
       this.totalValue = totalValue;
       this.totalSharesRenounced = totalSharesRenounced;
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
    public RightsIssue getRightsIssue() {
        return this.rightsIssue;
    }
    
    public void setRightsIssue(RightsIssue rightsIssue) {
        this.rightsIssue = rightsIssue;
    }
    public String getIssuer() {
        return this.issuer;
    }
    
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    public Integer getTotalHoldings() {
        return this.totalHoldings;
    }
    
    public void setTotalHoldings(Integer totalHoldings) {
        this.totalHoldings = totalHoldings;
    }
    public Integer getAllottedRights() {
        return this.allottedRights;
    }
    
    public void setAllottedRights(Integer allottedRights) {
        this.allottedRights = allottedRights;
    }
    public Integer getSharesSubscribed() {
        return this.sharesSubscribed;
    }
    
    public void setSharesSubscribed(Integer sharesSubscribed) {
        this.sharesSubscribed = sharesSubscribed;
    }
    public Integer getAdditionalSharesSubscribed() {
        return this.additionalSharesSubscribed;
    }
    
    public void setAdditionalSharesSubscribed(Integer additionalSharesSubscribed) {
        this.additionalSharesSubscribed = additionalSharesSubscribed;
    }
    public Integer getAdditionalSharesGiven() {
        return this.additionalSharesGiven;
    }
    
    public void setAdditionalSharesGiven(Integer additionalSharesGiven) {
        this.additionalSharesGiven = additionalSharesGiven;
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
    public Double getAdditionalSharesSubValue() {
        return this.additionalSharesSubValue;
    }
    
    public void setAdditionalSharesSubValue(Double additionalSharesSubValue) {
        this.additionalSharesSubValue = additionalSharesSubValue;
    }
    public Double getAdditionalSharesGivenValue() {
        return this.additionalSharesGivenValue;
    }
    
    public void setAdditionalSharesGivenValue(Double additionalSharesGivenValue) {
        this.additionalSharesGivenValue = additionalSharesGivenValue;
    }
    public Double getTotalValue() {
        return this.totalValue;
    }
    
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
    public Integer getTotalSharesRenounced() {
        return this.totalSharesRenounced;
    }
    
    public void setTotalSharesRenounced(Integer totalSharesRenounced) {
        this.totalSharesRenounced = totalSharesRenounced;
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


