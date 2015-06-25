package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 15:58:53 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * HolderBondAccount generated by hbm2java
 */
public class HolderBondAccount  implements java.io.Serializable {


     private HolderBondAccountId id;
     private Long version;
     private Bank bank;
     private BondOffer bondOffer;
     private Holder holder;
     private HolderBondAccount holderBondAccount;
     private Integer bondUnits;
     private Double startingPrincipalValue;
     private Double remainingPrincipalValue;
     private String nubanAccount;
     private Date dateApplied;
     private Boolean merged;
     private Boolean holderBondAcctPrimary;
     private Set holderBondAccounts = new HashSet(0);
     private Set coupons = new HashSet(0);

    public HolderBondAccount() {
    }

	
    public HolderBondAccount(HolderBondAccountId id, BondOffer bondOffer, Holder holder) {
        this.id = id;
        this.bondOffer = bondOffer;
        this.holder = holder;
    }
    public HolderBondAccount(HolderBondAccountId id, Bank bank, BondOffer bondOffer, Holder holder, HolderBondAccount holderBondAccount, Integer bondUnits, Double startingPrincipalValue, Double remainingPrincipalValue, String nubanAccount, Date dateApplied, Boolean merged, Boolean holderBondAcctPrimary, Set holderBondAccounts, Set coupons) {
       this.id = id;
       this.bank = bank;
       this.bondOffer = bondOffer;
       this.holder = holder;
       this.holderBondAccount = holderBondAccount;
       this.bondUnits = bondUnits;
       this.startingPrincipalValue = startingPrincipalValue;
       this.remainingPrincipalValue = remainingPrincipalValue;
       this.nubanAccount = nubanAccount;
       this.dateApplied = dateApplied;
       this.merged = merged;
       this.holderBondAcctPrimary = holderBondAcctPrimary;
       this.holderBondAccounts = holderBondAccounts;
       this.coupons = coupons;
    }
   
    public HolderBondAccountId getId() {
        return this.id;
    }
    
    public void setId(HolderBondAccountId id) {
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
    public BondOffer getBondOffer() {
        return this.bondOffer;
    }
    
    public void setBondOffer(BondOffer bondOffer) {
        this.bondOffer = bondOffer;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public HolderBondAccount getHolderBondAccount() {
        return this.holderBondAccount;
    }
    
    public void setHolderBondAccount(HolderBondAccount holderBondAccount) {
        this.holderBondAccount = holderBondAccount;
    }
    public Integer getBondUnits() {
        return this.bondUnits;
    }
    
    public void setBondUnits(Integer bondUnits) {
        this.bondUnits = bondUnits;
    }
    public Double getStartingPrincipalValue() {
        return this.startingPrincipalValue;
    }
    
    public void setStartingPrincipalValue(Double startingPrincipalValue) {
        this.startingPrincipalValue = startingPrincipalValue;
    }
    public Double getRemainingPrincipalValue() {
        return this.remainingPrincipalValue;
    }
    
    public void setRemainingPrincipalValue(Double remainingPrincipalValue) {
        this.remainingPrincipalValue = remainingPrincipalValue;
    }
    public String getNubanAccount() {
        return this.nubanAccount;
    }
    
    public void setNubanAccount(String nubanAccount) {
        this.nubanAccount = nubanAccount;
    }
    public Date getDateApplied() {
        return this.dateApplied;
    }
    
    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }
    public Boolean getMerged() {
        return this.merged;
    }
    
    public void setMerged(Boolean merged) {
        this.merged = merged;
    }
    public Boolean getHolderBondAcctPrimary() {
        return this.holderBondAcctPrimary;
    }
    
    public void setHolderBondAcctPrimary(Boolean holderBondAcctPrimary) {
        this.holderBondAcctPrimary = holderBondAcctPrimary;
    }
    public Set getHolderBondAccounts() {
        return this.holderBondAccounts;
    }
    
    public void setHolderBondAccounts(Set holderBondAccounts) {
        this.holderBondAccounts = holderBondAccounts;
    }
    public Set getCoupons() {
        return this.coupons;
    }
    
    public void setCoupons(Set coupons) {
        this.coupons = coupons;
    }




}


