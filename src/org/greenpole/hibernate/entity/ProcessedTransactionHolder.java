package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1



/**
 * ProcessedTransactionHolder generated by hbm2java
 */
public class ProcessedTransactionHolder  implements java.io.Serializable {


     private ProcessedTransactionHolderId id;
     private Long version;
     private Holder holder;
     private ProcessedTransaction processedTransaction;
     private String holderName;
     private String holderChn;
     private Integer units;
     private String unitType;
     private String fromTo;

    public ProcessedTransactionHolder() {
    }

	
    public ProcessedTransactionHolder(ProcessedTransactionHolderId id, Holder holder, ProcessedTransaction processedTransaction) {
        this.id = id;
        this.holder = holder;
        this.processedTransaction = processedTransaction;
    }
    public ProcessedTransactionHolder(ProcessedTransactionHolderId id, Holder holder, ProcessedTransaction processedTransaction, String holderName, String holderChn, Integer units, String unitType, String fromTo) {
       this.id = id;
       this.holder = holder;
       this.processedTransaction = processedTransaction;
       this.holderName = holderName;
       this.holderChn = holderChn;
       this.units = units;
       this.unitType = unitType;
       this.fromTo = fromTo;
    }
   
    public ProcessedTransactionHolderId getId() {
        return this.id;
    }
    
    public void setId(ProcessedTransactionHolderId id) {
        this.id = id;
    }
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public ProcessedTransaction getProcessedTransaction() {
        return this.processedTransaction;
    }
    
    public void setProcessedTransaction(ProcessedTransaction processedTransaction) {
        this.processedTransaction = processedTransaction;
    }
    public String getHolderName() {
        return this.holderName;
    }
    
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public String getHolderChn() {
        return this.holderChn;
    }
    
    public void setHolderChn(String holderChn) {
        this.holderChn = holderChn;
    }
    public Integer getUnits() {
        return this.units;
    }
    
    public void setUnits(Integer units) {
        this.units = units;
    }
    public String getUnitType() {
        return this.unitType;
    }
    
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
    public String getFromTo() {
        return this.fromTo;
    }
    
    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }




}


