package org.greenpole.hibernate.entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import org.greenpole.hibernate.backup_entity.*;
import org.greenpole.hibernate.entity.*;
import java.util.HashSet;
import java.util.Set;

/**
 * HolderCompanyAccount generated by hbm2java
 */
public class HolderCompanyAccount  implements java.io.Serializable {


     private HolderCompanyAccountId id;
     private Bank bank;
     private ClientCompany clientCompany;
     private Holder holder;
     private HolderCompanyAccount holderCompanyAccount;
     private String chn;
     private boolean esop;
     private boolean taxExempted;
     private String nubanAccount;
     private boolean merged;
     private boolean holderCompAccPrimary;
     private Set coupons = new HashSet(0);
     private Set dividends = new HashSet(0);
     private Set holderCompanyAccounts = new HashSet(0);

    public HolderCompanyAccount() {
    }

	
    public HolderCompanyAccount(HolderCompanyAccountId id, ClientCompany clientCompany, Holder holder) {
        this.id = id;
        this.clientCompany = clientCompany;
        this.holder = holder;
    }
    public HolderCompanyAccount(HolderCompanyAccountId id, Bank bank, ClientCompany clientCompany, Holder holder, HolderCompanyAccount holderCompanyAccount, String chn, boolean esop, boolean taxExempted, String nubanAccount, boolean merged, boolean holderCompAccPrimary, Set coupons, Set dividends, Set holderCompanyAccounts) {
       this.id = id;
       this.bank = bank;
       this.clientCompany = clientCompany;
       this.holder = holder;
       this.holderCompanyAccount = holderCompanyAccount;
       this.chn = chn;
       this.esop = esop;
       this.taxExempted = taxExempted;
       this.nubanAccount = nubanAccount;
       this.merged = merged;
       this.holderCompAccPrimary = holderCompAccPrimary;
       this.coupons = coupons;
       this.dividends = dividends;
       this.holderCompanyAccounts = holderCompanyAccounts;
    }
   
    public HolderCompanyAccountId getId() {
        return this.id;
    }
    
    public void setId(HolderCompanyAccountId id) {
        this.id = id;
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
    public String getChn() {
        return this.chn;
    }
    
    public void setChn(String chn) {
        this.chn = chn;
    }
    public boolean isEsop() {
        return this.esop;
    }
    
    public void setEsop(boolean esop) {
        this.esop = esop;
    }
    public boolean isTaxExempted() {
        return this.taxExempted;
    }
    
    public void setTaxExempted(boolean taxExempted) {
        this.taxExempted = taxExempted;
    }
    public String getNubanAccount() {
        return this.nubanAccount;
    }
    
    public void setNubanAccount(String nubanAccount) {
        this.nubanAccount = nubanAccount;
    }
    public boolean isMerged() {
        return this.merged;
    }
    
    public void setMerged(boolean merged) {
        this.merged = merged;
    }
    public boolean isHolderCompAccPrimary() {
        return this.holderCompAccPrimary;
    }
    
    public void setHolderCompAccPrimary(boolean holderCompAccPrimary) {
        this.holderCompAccPrimary = holderCompAccPrimary;
    }
    public Set getCoupons() {
        return this.coupons;
    }
    
    public void setCoupons(Set coupons) {
        this.coupons = coupons;
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


