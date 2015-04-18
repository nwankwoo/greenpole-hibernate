/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entity;

import java.io.Serializable;
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
    private String chn;
    private Double bondUnits;
    private String nubanAccount;
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

    public HolderBondAccount(HolderBondAccountId id, Bank bank, BondOffer bondOffer, Holder holder, HolderBondAccount holderBondAccount, String chn, Double bondUnits, String nubanAccount, boolean merged, boolean holderBondAccPrimary) {
        this.id = id;
        this.bank = bank;
        this.bondOffer = bondOffer;
        this.holder = holder;
        this.holderBondAccount = holderBondAccount;
        this.chn = chn;
        this.bondUnits = bondUnits;
        this.nubanAccount = nubanAccount;
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

    public String getChn() {
        return chn;
    }

    public void setChn(String chn) {
        this.chn = chn;
    }

    public Double getBondUnits() {
        return bondUnits;
    }

    public void setBondUnits(Double bondUnits) {
        this.bondUnits = bondUnits;
    }

    public String getNubanAccount() {
        return nubanAccount;
    }

    public void setNubanAccount(String nubanAccount) {
        this.nubanAccount = nubanAccount;
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
