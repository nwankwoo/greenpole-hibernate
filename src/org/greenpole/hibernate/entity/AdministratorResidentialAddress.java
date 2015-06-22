package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:17:29 by Hibernate Tools 4.3.1



/**
 * AdministratorResidentialAddress generated by hbm2java
 */
public class AdministratorResidentialAddress  implements java.io.Serializable {


     private int id;
     private Long version;
     private Administrator administrator;
     private String addressLine1;
     private String addressLine2;
     private String addressLine3;
     private String addressLine4;
     private String postCode;
     private String city;
     private String state;
     private String country;
     private Boolean isPrimary;

    public AdministratorResidentialAddress() {
    }

    public AdministratorResidentialAddress(Administrator administrator, String addressLine1, String addressLine2, String addressLine3, String addressLine4, String postCode, String city, String state, String country, Boolean isPrimary) {
       this.administrator = administrator;
       this.addressLine1 = addressLine1;
       this.addressLine2 = addressLine2;
       this.addressLine3 = addressLine3;
       this.addressLine4 = addressLine4;
       this.postCode = postCode;
       this.city = city;
       this.state = state;
       this.country = country;
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
    public String getAddressLine1() {
        return this.addressLine1;
    }
    
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2() {
        return this.addressLine2;
    }
    
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public String getAddressLine3() {
        return this.addressLine3;
    }
    
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }
    public String getAddressLine4() {
        return this.addressLine4;
    }
    
    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }
    public String getPostCode() {
        return this.postCode;
    }
    
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public Boolean getIsPrimary() {
        return this.isPrimary;
    }
    
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }




}


