package org.greenpole.hibernate.entity;
// Generated 23-Jun-2015 04:56:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * HolderCompanyAccount generated by hbm2java
 */
public class HolderCompanyAccount  implements java.io.Serializable {


     private HolderCompanyAccountId id;
     private Long version;
     private Bank bank;
     private ClientCompany clientCompany;
     private Holder holder;
     private HolderCompanyAccount holderCompanyAccount;
     private Integer shareUnits;
     private Boolean esop;
     private String nubanAccount;
     private Boolean merged;
     private Boolean EPayment;
     private Boolean holderCompAccPrimary;
     private Set dividends = new HashSet(0);
     private Set holderCompanyAccounts = new HashSet(0);

    public HolderCompanyAccount() {
    }

	
    public HolderCompanyAccount(HolderCompanyAccountId id, ClientCompany clientCompany, Holder holder) {
        this.id = id;
        this.clientCompany = clientCompany;
        this.holder = holder;
    }
    public HolderCompanyAccount(HolderCompanyAccountId id, Bank bank, ClientCompany clientCompany, Holder holder, HolderCompanyAccount holderCompanyAccount, Integer shareUnits, Boolean esop, String nubanAccount, Boolean merged, Boolean EPayment, Boolean holderCompAccPrimary, Set dividends, Set holderCompanyAccounts) {
       this.id = id;
       this.bank = bank;
       this.clientCompany = clientCompany;
       this.holder = holder;
       this.holderCompanyAccount = holderCompanyAccount;
       this.shareUnits = shareUnits;
       this.esop = esop;
       this.nubanAccount = nubanAccount;
       this.merged = merged;
       this.EPayment = EPayment;
       this.holderCompAccPrimary = holderCompAccPrimary;
       this.dividends = dividends;
       this.holderCompanyAccounts = holderCompanyAccounts;
    }
   
    public HolderCompanyAccountId getId() {
        return this.id;
    }
    
    public void setId(HolderCompanyAccountId id) {
        this.id = id;
    }
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    public Bank getBank() {
        return this.bank;
    }
    
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public HolderCompanyAccount getHolderCompanyAccount() {
        return this.holderCompanyAccount;
    }
    
    public void setHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount) {
        this.holderCompanyAccount = holderCompanyAccount;
    }
    public Integer getShareUnits() {
        return this.shareUnits;
    }
    
    public void setShareUnits(Integer shareUnits) {
        this.shareUnits = shareUnits;
    }
    public Boolean getEsop() {
        return this.esop;
    }
    
    public void setEsop(Boolean esop) {
        this.esop = esop;
    }
    public String getNubanAccount() {
        return this.nubanAccount;
    }
    
    public void setNubanAccount(String nubanAccount) {
        this.nubanAccount = nubanAccount;
    }
    public Boolean getMerged() {
        return this.merged;
    }
    
    public void setMerged(Boolean merged) {
        this.merged = merged;
    }
    public Boolean getEPayment() {
        return this.EPayment;
    }
    
    public void setEPayment(Boolean EPayment) {
        this.EPayment = EPayment;
    }
    public Boolean getHolderCompAccPrimary() {
        return this.holderCompAccPrimary;
    }
    
    public void setHolderCompAccPrimary(Boolean holderCompAccPrimary) {
        this.holderCompAccPrimary = holderCompAccPrimary;
    }
    public Set getDividends() {
        return this.dividends;
    }
    
    public void setDividends(Set dividends) {
        this.dividends = dividends;
    }
    public Set getHolderCompanyAccounts() {
        return this.holderCompanyAccounts;
    }
    
    public void setHolderCompanyAccounts(Set holderCompanyAccounts) {
        this.holderCompanyAccounts = holderCompanyAccounts;
    }




}


