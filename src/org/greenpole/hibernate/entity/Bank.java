package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Bank generated by hbm2java
 */
public class Bank  implements java.io.Serializable {


     private int id;
     private String bankName;
     private String bankCode;
     private Set holderCompanyAccounts = new HashSet(0);

    public Bank() {
    }

    public Bank(String bankName, String bankCode, Set holderCompanyAccounts) {
       this.bankName = bankName;
       this.bankCode = bankCode;
       this.holderCompanyAccounts = holderCompanyAccounts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    public Set getHolderCompanyAccounts() {
        return this.holderCompanyAccounts;
    }
    
    public void setHolderCompanyAccounts(Set holderCompanyAccounts) {
        this.holderCompanyAccounts = holderCompanyAccounts;
    }




}


