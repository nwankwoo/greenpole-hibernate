package org.greenpole.hibernate.entity;
// Generated 16-Jun-2015 12:22:21 by Hibernate Tools 4.3.1



/**
 * ClientCompanyEmailAddress generated by hbm2java
 */
public class ClientCompanyEmailAddress  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private String emailAddress;
     private Boolean isPrimary;

    public ClientCompanyEmailAddress() {
    }

    public ClientCompanyEmailAddress(ClientCompany clientCompany, String emailAddress, Boolean isPrimary) {
       this.clientCompany = clientCompany;
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
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
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


