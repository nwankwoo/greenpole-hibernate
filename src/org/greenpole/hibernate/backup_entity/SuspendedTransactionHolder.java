package org.greenpole.hibernate.backup_entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.entity.*;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * SuspendedTransactionHolder generated by hbm2java
 */
public class SuspendedTransactionHolder  implements java.io.Serializable {


     private SuspendedTransactionHolderId id;
     private long versionId;
     private Holder holder;
     private SuspendedTransaction suspendedTransaction;
     private String holderName;
     private String holderChn;
     private int units;
     private String unitType;
     private String fromTo;

    public SuspendedTransactionHolder() {
    }

	
    public SuspendedTransactionHolder(SuspendedTransactionHolderId id, Holder holder, SuspendedTransaction suspendedTransaction) {
        this.id = id;
        this.holder = holder;
        this.suspendedTransaction = suspendedTransaction;
    }
    public SuspendedTransactionHolder(SuspendedTransactionHolderId id, Holder holder, SuspendedTransaction suspendedTransaction, String holderName, String holderChn, int units, String unitType, String fromTo) {
       this.id = id;
       this.holder = holder;
       this.suspendedTransaction = suspendedTransaction;
       this.holderName = holderName;
       this.holderChn = holderChn;
       this.units = units;
       this.unitType = unitType;
       this.fromTo = fromTo;
    }
   
    public SuspendedTransactionHolderId getId() {
        return this.id;
    }
    
    public void setId(SuspendedTransactionHolderId id) {
        this.id = id;
    }
      /**
     * A getter for SuspendedTransactionHolder object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for SuspendedTransactionHolder object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public SuspendedTransaction getSuspendedTransaction() {
        return this.suspendedTransaction;
    }
    
    public void setSuspendedTransaction(SuspendedTransaction suspendedTransaction) {
        this.suspendedTransaction = suspendedTransaction;
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
    public int getUnits() {
        return this.units;
    }
    
    public void setUnits(int units) {
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


