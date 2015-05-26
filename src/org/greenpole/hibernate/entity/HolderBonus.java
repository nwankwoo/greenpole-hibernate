/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Akinwale Agbaje
 */
public class HolderBonus implements Serializable {
    private HolderBonusId id;
    private long versionId;
    private Holder holder;
    private ShareBonus shareBonus;
    private int totalHoldings;
    private int bonusUnits;
    private Date dateGiven;
    private boolean added;

    public HolderBonus() {
    }

    public HolderBonus(HolderBonusId id, Holder holder, ShareBonus shareBonus) {
        this.id = id;
        this.holder = holder;
        this.shareBonus = shareBonus;
    }

    public HolderBonus(HolderBonusId id, Holder holder, ShareBonus shareBonus, int totalHoldings, int bonusUnits, Date dateGiven, boolean added) {
        this.id = id;
        this.holder = holder;
        this.shareBonus = shareBonus;
        this.totalHoldings = totalHoldings;
        this.bonusUnits = bonusUnits;
        this.dateGiven = dateGiven;
        this.added = added;
    }

    public HolderBonusId getId() {
        return id;
    }

    public void setId(HolderBonusId id) {
        this.id = id;
    }

    public long getVersionId() {
        return versionId;
    }

    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public ShareBonus getShareBonus() {
        return shareBonus;
    }

    public void setShareBonus(ShareBonus shareBonus) {
        this.shareBonus = shareBonus;
    }

    public int getTotalHoldings() {
        return totalHoldings;
    }

    public void setTotalHoldings(int totalHoldings) {
        this.totalHoldings = totalHoldings;
    }

    public int getBonusUnits() {
        return bonusUnits;
    }

    public void setBonusUnits(int bonusUnits) {
        this.bonusUnits = bonusUnits;
    }

    public Date getDateGiven() {
        return dateGiven;
    }

    public void setDateGiven(Date dateGiven) {
        this.dateGiven = dateGiven;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }
    
    
}
