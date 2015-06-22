package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:17:29 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SuspendedTransaction generated by hbm2java
 */
public class SuspendedTransaction  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private Integer cscsTransactionId;
     private Date transactionDate;
     private Date suspensionDate;
     private String suspensionReason;
     private Boolean reconciled;
     private String companyName;
     private Set suspendedTransactionHolders = new HashSet(0);

    public SuspendedTransaction() {
    }

    public SuspendedTransaction(ClientCompany clientCompany, Integer cscsTransactionId, Date transactionDate, Date suspensionDate, String suspensionReason, Boolean reconciled, String companyName, Set suspendedTransactionHolders) {
       this.clientCompany = clientCompany;
       this.cscsTransactionId = cscsTransactionId;
       this.transactionDate = transactionDate;
       this.suspensionDate = suspensionDate;
       this.suspensionReason = suspensionReason;
       this.reconciled = reconciled;
       this.companyName = companyName;
       this.suspendedTransactionHolders = suspendedTransactionHolders;
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
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public Integer getCscsTransactionId() {
        return this.cscsTransactionId;
    }
    
    public void setCscsTransactionId(Integer cscsTransactionId) {
        this.cscsTransactionId = cscsTransactionId;
    }
    public Date getTransactionDate() {
        return this.transactionDate;
    }
    
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public Date getSuspensionDate() {
        return this.suspensionDate;
    }
    
    public void setSuspensionDate(Date suspensionDate) {
        this.suspensionDate = suspensionDate;
    }
    public String getSuspensionReason() {
        return this.suspensionReason;
    }
    
    public void setSuspensionReason(String suspensionReason) {
        this.suspensionReason = suspensionReason;
    }
    public Boolean getReconciled() {
        return this.reconciled;
    }
    
    public void setReconciled(Boolean reconciled) {
        this.reconciled = reconciled;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Set getSuspendedTransactionHolders() {
        return this.suspendedTransactionHolders;
    }
    
    public void setSuspendedTransactionHolders(Set suspendedTransactionHolders) {
        this.suspendedTransactionHolders = suspendedTransactionHolders;
    }




}


