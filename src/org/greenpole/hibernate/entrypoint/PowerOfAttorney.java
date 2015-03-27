package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PowerOfAttorney generated by hbm2java
 */
public class PowerOfAttorney  implements java.io.Serializable {


     private int id;
     private Holder holder;
     private String title;
     private String signaturePath;
     private String type;
     private Date startDate;
     private Date endDate;
     private String periodType;
     private boolean powerOfAttorneyPrimary;

    public PowerOfAttorney() {
    }

    public PowerOfAttorney(Holder holder, String title, String signaturePath, String type, Date startDate, Date endDate, String periodType, boolean powerOfAttorneyPrimary) {
       this.holder = holder;
       this.title = title;
       this.signaturePath = signaturePath;
       this.type = type;
       this.startDate = startDate;
       this.endDate = endDate;
       this.periodType = periodType;
       this.powerOfAttorneyPrimary = powerOfAttorneyPrimary;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSignaturePath() {
        return this.signaturePath;
    }
    
    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getPeriodType() {
        return this.periodType;
    }
    
    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }
    public boolean isPowerOfAttorneyPrimary() {
        return this.powerOfAttorneyPrimary;
    }
    
    public void setPowerOfAttorneyPrimary(boolean powerOfAttorneyPrimary) {
        this.powerOfAttorneyPrimary = powerOfAttorneyPrimary;
    }




}


