/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Akin
 */
public class HolderBondAccount implements Serializable {
    
    private HolderBondAccountId id;
    private long versionId;
    private Bank bank;
    private BondOffer bondOffer;
    private Holder holder;
    private HolderBondAccount holderBondAccount;
    private int bondUnits;
    private Double startingPrincipalValue;
    private Double remainingPrincipalValue;
    private String nubanAccount;
    private Date dateApplied;
    private boolean merged;
    private boolean holderBondAccPrimary;
    private Set coupons = new HashSet(0);
    private Set holderBondAccounts = new HashSet(0);

    public HolderBondAccount() {
    }

    public HolderBondAccount(HolderBondAccountId id, BondOffer bondOffer, Holder holder) {
        this.id = id;
        this.bondOffer = bondOffer;
        this.holder = holder;
    }

    public HolderBondAccount(HolderBondAccountId id, Bank bank, BondOffer bondOffer, Holder holder, HolderBondAccount holderBondAccount, int bondUnits, Double startingPrincipalValue, Double remainingPrincipalValue, String nubanAccount, Date dateApplied, boolean merged, boolean holderBondAccPrimary) {
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
        this.holderBondAccPrimary = holderBondAccPrimary;
    }

    public HolderBondAccountId getId() {
        return id;
    }

    public void setId(HolderBondAccountId id) {
        this.id = id;
    }

    public long getVersionId() {
        return versionId;
    }

    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BondOffer getBondOffer() {
        return bondOffer;
    }

    public void setBondOffer(BondOffer bondOffer) {
        this.bondOffer = bondOffer;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public HolderBondAccount getHolderBondAccount() {
        return holderBondAccount;
    }

    public void setHolderBondAccount(HolderBondAccount holderBondAccount) {
        this.holderBondAccount = holderBondAccount;
    }

    public int getBondUnits() {
        return bondUnits;
    }

    public void setBondUnits(int bondUnits) {
        this.bondUnits = bondUnits;
    }

    public Double getStartingPrincipalValue() {
        return startingPrincipalValue;
    }

    public void setStartingPrincipalValue(Double startingPrincipalValue) {
        this.startingPrincipalValue = startingPrincipalValue;
    }

    public Double getRemainingPrincipalValue() {
        return remainingPrincipalValue;
    }

    public void setRemainingPrincipalValue(Double remainingPrincipalValue) {
        this.remainingPrincipalValue = remainingPrincipalValue;
    }

    public String getNubanAccount() {
        return nubanAccount;
    }

    public void setNubanAccount(String nubanAccount) {
        this.nubanAccount = nubanAccount;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

    public boolean isHolderBondAccPrimary() {
        return holderBondAccPrimary;
    }

    public void setHolderBondAccPrimary(boolean holderBondAccPrimary) {
        this.holderBondAccPrimary = holderBondAccPrimary;
    }

    public Set getCoupons() {
        return coupons;
    }

    public void setCoupons(Set coupons) {
        this.coupons = coupons;
    }

    public Set getHolderBondAccounts() {
        return holderBondAccounts;
    }

    public void setHolderBondAccounts(Set holderBondAccounts) {
        this.holderBondAccounts = holderBondAccounts;
    }
    
}
