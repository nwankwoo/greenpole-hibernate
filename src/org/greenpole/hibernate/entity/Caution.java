package org.greenpole.hibernate.entity;
// Generated 29-May-2015 21:21:44 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Caution generated by hbm2java
 */
public class Caution  implements java.io.Serializable {


     private int id;
     private Long version;
     private Holder holder;
     private String title;
     private String description;
     private String type;
     private Boolean active;
     private Date cautionDate;
     private Date uncautionDate;

    public Caution() {
    }

    public Caution(Holder holder, String title, String description, String type, Boolean active, Date cautionDate, Date uncautionDate) {
       this.holder = holder;
       this.title = title;
       this.description = description;
       this.type = type;
       this.active = active;
       this.cautionDate = cautionDate;
       this.uncautionDate = uncautionDate;
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
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public Boolean getActive() {
        return this.active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Date getCautionDate() {
        return this.cautionDate;
    }
    
    public void setCautionDate(Date cautionDate) {
        this.cautionDate = cautionDate;
    }
    public Date getUncautionDate() {
        return this.uncautionDate;
    }
    
    public void setUncautionDate(Date uncautionDate) {
        this.uncautionDate = uncautionDate;
    }




}


