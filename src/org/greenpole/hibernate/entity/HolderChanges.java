package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 13:01:59 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * HolderChanges generated by hbm2java
 */
public class HolderChanges  implements java.io.Serializable {


     private int id;
     private Long version;
     private Holder holder;
     private HolderChangeType holderChangeType;
     private String initialForm;
     private String currentForm;
     private Date changeDate;

    public HolderChanges() {
    }

    public HolderChanges(Holder holder, HolderChangeType holderChangeType, String initialForm, String currentForm, Date changeDate) {
       this.holder = holder;
       this.holderChangeType = holderChangeType;
       this.initialForm = initialForm;
       this.currentForm = currentForm;
       this.changeDate = changeDate;
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
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public HolderChangeType getHolderChangeType() {
        return this.holderChangeType;
    }
    
    public void setHolderChangeType(HolderChangeType holderChangeType) {
        this.holderChangeType = holderChangeType;
    }
    public String getInitialForm() {
        return this.initialForm;
    }
    
    public void setInitialForm(String initialForm) {
        this.initialForm = initialForm;
    }
    public String getCurrentForm() {
        return this.currentForm;
    }
    
    public void setCurrentForm(String currentForm) {
        this.currentForm = currentForm;
    }
    public Date getChangeDate() {
        return this.changeDate;
    }
    
    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }




}


