package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:17:29 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ProcessedTransaction generated by hbm2java
 */
public class ProcessedTransaction  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private TransactionType transactionType;
     private Integer cscsTransactionId;
     private String companyName;
     private Date transactionDate;
     private Set processedTransactionHolders = new HashSet(0);

    public ProcessedTransaction() {
    }

    public ProcessedTransaction(ClientCompany clientCompany, TransactionType transactionType, Integer cscsTransactionId, String companyName, Date transactionDate, Set processedTransactionHolders) {
       this.clientCompany = clientCompany;
       this.transactionType = transactionType;
       this.cscsTransactionId = cscsTransactionId;
       this.companyName = companyName;
       this.transactionDate = transactionDate;
       this.processedTransactionHolders = processedTransactionHolders;
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
    public TransactionType getTransactionType() {
        return this.transactionType;
    }
    
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    public Integer getCscsTransactionId() {
        return this.cscsTransactionId;
    }
    
    public void setCscsTransactionId(Integer cscsTransactionId) {
        this.cscsTransactionId = cscsTransactionId;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Date getTransactionDate() {
        return this.transactionDate;
    }
    
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public Set getProcessedTransactionHolders() {
        return this.processedTransactionHolders;
    }
    
    public void setProcessedTransactionHolders(Set processedTransactionHolders) {
        this.processedTransactionHolders = processedTransactionHolders;
    }




}


