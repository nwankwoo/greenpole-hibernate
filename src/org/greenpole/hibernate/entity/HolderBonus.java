package org.greenpole.hibernate.entity;
// Generated 16-Jun-2015 12:22:21 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * HolderBonus generated by hbm2java
 */
public class HolderBonus  implements java.io.Serializable {


     private HolderBonusId id;
     private Long version;
     private Holder holder;
     private ShareBonus shareBonus;
     private Integer totalHoldings;
     private Integer bonusUnits;
     private Date dateGiven;
     private Boolean added;

    public HolderBonus() {
    }

	
    public HolderBonus(HolderBonusId id, Holder holder, ShareBonus shareBonus) {
        this.id = id;
        this.holder = holder;
        this.shareBonus = shareBonus;
    }
    public HolderBonus(HolderBonusId id, Holder holder, ShareBonus shareBonus, Integer totalHoldings, Integer bonusUnits, Date dateGiven, Boolean added) {
       this.id = id;
       this.holder = holder;
       this.shareBonus = shareBonus;
       this.totalHoldings = totalHoldings;
       this.bonusUnits = bonusUnits;
       this.dateGiven = dateGiven;
       this.added = added;
    }
   
    public HolderBonusId getId() {
        return this.id;
    }
    
    public void setId(HolderBonusId id) {
        this.id = id;
    }
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public ShareBonus getShareBonus() {
        return this.shareBonus;
    }
    
    public void setShareBonus(ShareBonus shareBonus) {
        this.shareBonus = shareBonus;
    }
    public Integer getTotalHoldings() {
        return this.totalHoldings;
    }
    
    public void setTotalHoldings(Integer totalHoldings) {
        this.totalHoldings = totalHoldings;
    }
    public Integer getBonusUnits() {
        return this.bonusUnits;
    }
    
    public void setBonusUnits(Integer bonusUnits) {
        this.bonusUnits = bonusUnits;
    }
    public Date getDateGiven() {
        return this.dateGiven;
    }
    
    public void setDateGiven(Date dateGiven) {
        this.dateGiven = dateGiven;
    }
    public Boolean getAdded() {
        return this.added;
    }
    
    public void setAdded(Boolean added) {
        this.added = added;
    }




}


