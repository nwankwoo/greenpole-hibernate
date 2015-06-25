package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 11:31:21 by Hibernate Tools 4.3.1



/**
 * HolderEmailAddress generated by hbm2java
 */
public class HolderEmailAddress  implements java.io.Serializable {


     private int id;
     private Long version;
     private Holder holder;
     private String emailAddress;
     private Boolean isPrimary;

    public HolderEmailAddress() {
    }

    public HolderEmailAddress(Holder holder, String emailAddress, Boolean isPrimary) {
       this.holder = holder;
       this.emailAddress = emailAddress;
       this.isPrimary = isPrimary;
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
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public Boolean getIsPrimary() {
        return this.isPrimary;
    }
    
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }




}


