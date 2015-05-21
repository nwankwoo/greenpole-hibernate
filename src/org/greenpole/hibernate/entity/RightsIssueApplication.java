package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * RightsIssueApplication generated by hbm2java
 */
public class RightsIssueApplication  implements java.io.Serializable {


     private int id;
     private long versionId;
     private ClearingHouse clearingHouse;
     private Holder holder;
     private RightsIssue rightsIssue;
     private String issuer;
     private int sharesSubscribed;
     private int additionalSharesSubscribed;
     private Double amountPaid;
     private String issuingHouse;
     private Double sharesSubscribedValue;
     private Double additionalSharesSubValue;
     private Double totalValue;
     private int totalSharesRenounced;
     private Double returnMoney;
     private boolean processingPayment;
     private boolean approved;
     private boolean cancelled;

    public RightsIssueApplication() {
    }

    public RightsIssueApplication(ClearingHouse clearingHouse, Holder holder, RightsIssue rightsIssue, String issuer, int sharesSubscribed, int additionalSharesSubscribed, Double amountPaid, String issuingHouse, Double sharesSubscribedValue, Double additionalSharesSubValue, Double totalValue, int totalSharesRenounced, Double returnMoney, boolean processingPayment, boolean approved, boolean cancelled) {
       this.clearingHouse = clearingHouse;
       this.holder = holder;
       this.rightsIssue = rightsIssue;
       this.issuer = issuer;
       this.sharesSubscribed = sharesSubscribed;
       this.additionalSharesSubscribed = additionalSharesSubscribed;
       this.amountPaid = amountPaid;
       this.issuingHouse = issuingHouse;
       this.sharesSubscribedValue = sharesSubscribedValue;
       this.additionalSharesSubValue = additionalSharesSubValue;
       this.totalValue = totalValue;
       this.totalSharesRenounced = totalSharesRenounced;
       this.returnMoney = returnMoney;
       this.processingPayment = processingPayment;
       this.approved = approved;
       this.cancelled = cancelled;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
       /**
     * A getter for RightsIssueApplication object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for RightsIssueApplication object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
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
    public int getSharesSubscribed() {
        return this.sharesSubscribed;
    }
    
    public void setSharesSubscribed(int sharesSubscribed) {
        this.sharesSubscribed = sharesSubscribed;
    }
    public int getAdditionalSharesSubscribed() {
        return this.additionalSharesSubscribed;
    }
    
    public void setAdditionalSharesSubscribed(int additionalSharesSubscribed) {
        this.additionalSharesSubscribed = additionalSharesSubscribed;
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
    public Double getTotalValue() {
        return this.totalValue;
    }
    
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
    public int getTotalSharesRenounced() {
        return this.totalSharesRenounced;
    }
    
    public void setTotalSharesRenounced(int totalSharesRenounced) {
        this.totalSharesRenounced = totalSharesRenounced;
    }
    public Double getReturnMoney() {
        return this.returnMoney;
    }
    
    public void setReturnMoney(Double returnMoney) {
        this.returnMoney = returnMoney;
    }
    public boolean isProcessingPayment() {
        return processingPayment;
    }

    public void setProcessingPayment(boolean processingPayment) {
        this.processingPayment = processingPayment;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }




}


