package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 15:41:35 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * CompanyAccountConsolidation generated by hbm2java
 */
public class CompanyAccountConsolidation  implements java.io.Serializable {


     private int id;
     private Long version;
     private AccountConsolidation accountConsolidation;
     private Integer forCompanyId;
     private Integer forBondOfferId;
     private Integer tiedToInitialHolderId;
     private Integer tiedToCurrentHolderId;
     private String initialChn;
     private String currentChn;
     private Integer bondShareUnit;
     private Boolean transfer;
     private Integer receiverUnitState;
     private Integer receiverStartUnit;
     private Integer unitAfterTransfer;
     private Date mergeDate;

    public CompanyAccountConsolidation() {
    }

    public CompanyAccountConsolidation(AccountConsolidation accountConsolidation, Integer forCompanyId, Integer forBondOfferId, Integer tiedToInitialHolderId, Integer tiedToCurrentHolderId, String initialChn, String currentChn, Integer bondShareUnit, Boolean transfer, Integer receiverUnitState, Integer receiverStartUnit, Integer unitAfterTransfer, Date mergeDate) {
       this.accountConsolidation = accountConsolidation;
       this.forCompanyId = forCompanyId;
       this.forBondOfferId = forBondOfferId;
       this.tiedToInitialHolderId = tiedToInitialHolderId;
       this.tiedToCurrentHolderId = tiedToCurrentHolderId;
       this.initialChn = initialChn;
       this.currentChn = currentChn;
       this.bondShareUnit = bondShareUnit;
       this.transfer = transfer;
       this.receiverUnitState = receiverUnitState;
       this.receiverStartUnit = receiverStartUnit;
       this.unitAfterTransfer = unitAfterTransfer;
       this.mergeDate = mergeDate;
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
    public AccountConsolidation getAccountConsolidation() {
        return this.accountConsolidation;
    }
    
    public void setAccountConsolidation(AccountConsolidation accountConsolidation) {
        this.accountConsolidation = accountConsolidation;
    }
    public Integer getForCompanyId() {
        return this.forCompanyId;
    }
    
    public void setForCompanyId(Integer forCompanyId) {
        this.forCompanyId = forCompanyId;
    }
    public Integer getForBondOfferId() {
        return this.forBondOfferId;
    }
    
    public void setForBondOfferId(Integer forBondOfferId) {
        this.forBondOfferId = forBondOfferId;
    }
    public Integer getTiedToInitialHolderId() {
        return this.tiedToInitialHolderId;
    }
    
    public void setTiedToInitialHolderId(Integer tiedToInitialHolderId) {
        this.tiedToInitialHolderId = tiedToInitialHolderId;
    }
    public Integer getTiedToCurrentHolderId() {
        return this.tiedToCurrentHolderId;
    }
    
    public void setTiedToCurrentHolderId(Integer tiedToCurrentHolderId) {
        this.tiedToCurrentHolderId = tiedToCurrentHolderId;
    }
    public String getInitialChn() {
        return this.initialChn;
    }
    
    public void setInitialChn(String initialChn) {
        this.initialChn = initialChn;
    }
    public String getCurrentChn() {
        return this.currentChn;
    }
    
    public void setCurrentChn(String currentChn) {
        this.currentChn = currentChn;
    }
    public Integer getBondShareUnit() {
        return this.bondShareUnit;
    }
    
    public void setBondShareUnit(Integer bondShareUnit) {
        this.bondShareUnit = bondShareUnit;
    }
    public Boolean getTransfer() {
        return this.transfer;
    }
    
    public void setTransfer(Boolean transfer) {
        this.transfer = transfer;
    }
    public Integer getReceiverUnitState() {
        return this.receiverUnitState;
    }
    
    public void setReceiverUnitState(Integer receiverUnitState) {
        this.receiverUnitState = receiverUnitState;
    }
    public Integer getReceiverStartUnit() {
        return this.receiverStartUnit;
    }
    
    public void setReceiverStartUnit(Integer receiverStartUnit) {
        this.receiverStartUnit = receiverStartUnit;
    }
    public Integer getUnitAfterTransfer() {
        return this.unitAfterTransfer;
    }
    
    public void setUnitAfterTransfer(Integer unitAfterTransfer) {
        this.unitAfterTransfer = unitAfterTransfer;
    }
    public Date getMergeDate() {
        return this.mergeDate;
    }
    
    public void setMergeDate(Date mergeDate) {
        this.mergeDate = mergeDate;
    }




}


