package org.greenpole.hibernate.entity;
// Generated 05-Jun-2015 21:07:19 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Stockbroker generated by hbm2java
 */
public class Stockbroker  implements java.io.Serializable {


     private int id;
     private Long version;
     private String name;
     private String cscsAccNo;
     private Boolean active;
     private Boolean valid;
     private Set stockbrokerAddresses = new HashSet(0);
     private Set stockbrokerPhoneNumbers = new HashSet(0);
     private Set holders = new HashSet(0);
     private Set stockbrokerAgents = new HashSet(0);
     private Set stockbrokerSignatures = new HashSet(0);
     private Set stockbrokerEmailAddresses = new HashSet(0);

    public Stockbroker() {
    }

    public Stockbroker(String name, String cscsAccNo, Boolean active, Boolean valid, Set stockbrokerAddresses, Set stockbrokerPhoneNumbers, Set holders, Set stockbrokerAgents, Set stockbrokerSignatures, Set stockbrokerEmailAddresses) {
       this.name = name;
       this.cscsAccNo = cscsAccNo;
       this.active = active;
       this.valid = valid;
       this.stockbrokerAddresses = stockbrokerAddresses;
       this.stockbrokerPhoneNumbers = stockbrokerPhoneNumbers;
       this.holders = holders;
       this.stockbrokerAgents = stockbrokerAgents;
       this.stockbrokerSignatures = stockbrokerSignatures;
       this.stockbrokerEmailAddresses = stockbrokerEmailAddresses;
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
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getCscsAccNo() {
        return this.cscsAccNo;
    }
    
    public void setCscsAccNo(String cscsAccNo) {
        this.cscsAccNo = cscsAccNo;
    }
    public Boolean getActive() {
        return this.active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getValid() {
        return this.valid;
    }
    
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    public Set getStockbrokerAddresses() {
        return this.stockbrokerAddresses;
    }
    
    public void setStockbrokerAddresses(Set stockbrokerAddresses) {
        this.stockbrokerAddresses = stockbrokerAddresses;
    }
    public Set getStockbrokerPhoneNumbers() {
        return this.stockbrokerPhoneNumbers;
    }
    
    public void setStockbrokerPhoneNumbers(Set stockbrokerPhoneNumbers) {
        this.stockbrokerPhoneNumbers = stockbrokerPhoneNumbers;
    }
    public Set getHolders() {
        return this.holders;
    }
    
    public void setHolders(Set holders) {
        this.holders = holders;
    }
    public Set getStockbrokerAgents() {
        return this.stockbrokerAgents;
    }
    
    public void setStockbrokerAgents(Set stockbrokerAgents) {
        this.stockbrokerAgents = stockbrokerAgents;
    }
    public Set getStockbrokerSignatures() {
        return this.stockbrokerSignatures;
    }
    
    public void setStockbrokerSignatures(Set stockbrokerSignatures) {
        this.stockbrokerSignatures = stockbrokerSignatures;
    }
    public Set getStockbrokerEmailAddresses() {
        return this.stockbrokerEmailAddresses;
    }
    
    public void setStockbrokerEmailAddresses(Set stockbrokerEmailAddresses) {
        this.stockbrokerEmailAddresses = stockbrokerEmailAddresses;
    }




}


