package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1



/**
 * AdministratorEmailAddress generated by hbm2java
 */
public class AdministratorEmailAddress  implements java.io.Serializable {


     private int id;
     private Long version;
     private Administrator administrator;
     private String emailAddress;
     private Boolean isPrimary;

    public AdministratorEmailAddress() {
    }

    public AdministratorEmailAddress(Administrator administrator, String emailAddress, Boolean isPrimary) {
       this.administrator = administrator;
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
    public Administrator getAdministrator() {
        return this.administrator;
    }
    
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
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


