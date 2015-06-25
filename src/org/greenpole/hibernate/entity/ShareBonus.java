package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 11:31:21 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ShareBonus generated by hbm2java
 */
public class ShareBonus  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private String title;
     private Date qualifyDate;
     private Integer qualifyShareUnit;
     private Integer bonusUnitPerQualifyUnit;
     private Set holderBonuses = new HashSet(0);
     private Set certificates = new HashSet(0);

    public ShareBonus() {
    }

    public ShareBonus(ClientCompany clientCompany, String title, Date qualifyDate, Integer qualifyShareUnit, Integer bonusUnitPerQualifyUnit, Set holderBonuses, Set certificates) {
       this.clientCompany = clientCompany;
       this.title = title;
       this.qualifyDate = qualifyDate;
       this.qualifyShareUnit = qualifyShareUnit;
       this.bonusUnitPerQualifyUnit = bonusUnitPerQualifyUnit;
       this.holderBonuses = holderBonuses;
       this.certificates = certificates;
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
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getQualifyDate() {
        return this.qualifyDate;
    }
    
    public void setQualifyDate(Date qualifyDate) {
        this.qualifyDate = qualifyDate;
    }
    public Integer getQualifyShareUnit() {
        return this.qualifyShareUnit;
    }
    
    public void setQualifyShareUnit(Integer qualifyShareUnit) {
        this.qualifyShareUnit = qualifyShareUnit;
    }
    public Integer getBonusUnitPerQualifyUnit() {
        return this.bonusUnitPerQualifyUnit;
    }
    
    public void setBonusUnitPerQualifyUnit(Integer bonusUnitPerQualifyUnit) {
        this.bonusUnitPerQualifyUnit = bonusUnitPerQualifyUnit;
    }
    public Set getHolderBonuses() {
        return this.holderBonuses;
    }
    
    public void setHolderBonuses(Set holderBonuses) {
        this.holderBonuses = holderBonuses;
    }
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }




}


