package org.greenpole.hibernate.entity;
// Generated 23-Jun-2015 04:56:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Bank generated by hbm2java
 */
public class Bank  implements java.io.Serializable {


     private int id;
     private Long version;
     private String bankName;
     private String bankCode;
     private Set holderBondAccounts = new HashSet(0);
     private Set holderCompanyAccounts = new HashSet(0);

    public Bank() {
    }

    public Bank(String bankName, String bankCode, Set holderBondAccounts, Set holderCompanyAccounts) {
       this.bankName = bankName;
       this.bankCode = bankCode;
       this.holderBondAccounts = holderBondAccounts;
       this.holderCompanyAccounts = holderCompanyAccounts;
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
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankCode() {
        return this.bankCode;
    }
    
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public Set getHolderBondAccounts() {
        return this.holderBondAccounts;
    }
    
    public void setHolderBondAccounts(Set holderBondAccounts) {
        this.holderBondAccounts = holderBondAccounts;
    }
    public Set getHolderCompanyAccounts() {
        return this.holderCompanyAccounts;
    }
    
    public void setHolderCompanyAccounts(Set holderCompanyAccounts) {
        this.holderCompanyAccounts = holderCompanyAccounts;
    }




}


