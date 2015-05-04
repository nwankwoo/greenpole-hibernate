package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PowerOfAttorney generated by hbm2java
 */
public class PowerOfAttorney  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Holder holder;
     private String title;
     private String filePath;
     private String type;
     private Date startDate;
     private Date endDate;
     private boolean powerOfAttorneyPrimary;

    public PowerOfAttorney() {
    }
    
    
    public PowerOfAttorney(Holder holder, String title, String filePath, String type, Date startDate, Date endDate, boolean powerOfAttorneyPrimary) {
       this.holder = holder;
       this.title = title;
       this.filePath = filePath;
       this.type = type;
       this.startDate = startDate;
       this.endDate = endDate;
       this.powerOfAttorneyPrimary = powerOfAttorneyPrimary;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for PowerOfAttorney object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for PowerOfAttorney object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
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
    public String getFilePath() {
        return this.filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
    public boolean isPowerOfAttorneyPrimary() {
        return this.powerOfAttorneyPrimary;
    }
    
    public void setPowerOfAttorneyPrimary(boolean powerOfAttorneyPrimary) {
        this.powerOfAttorneyPrimary = powerOfAttorneyPrimary;
    }




}


