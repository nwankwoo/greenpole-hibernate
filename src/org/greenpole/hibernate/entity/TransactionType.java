package org.greenpole.hibernate.entity;
// Generated 05-Jun-2015 21:07:19 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TransactionType generated by hbm2java
 */
public class TransactionType  implements java.io.Serializable {


     private int id;
     private Long version;
     private String type;
     private String description;
     private Set processedTransactions = new HashSet(0);

    public TransactionType() {
    }

    public TransactionType(String type, String description, Set processedTransactions) {
       this.type = type;
       this.description = description;
       this.processedTransactions = processedTransactions;
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
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getProcessedTransactions() {
        return this.processedTransactions;
    }
    
    public void setProcessedTransactions(Set processedTransactions) {
        this.processedTransactions = processedTransactions;
    }




}


