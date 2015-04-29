package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * HolderResidentialAddress generated by hbm2java
 */
public class HolderResidentialAddress  implements java.io.Serializable {


     private HolderResidentialAddressId id;
     private long versionId;
     private Holder holder;
     private String addressLine2;
     private String addressLine3;
     private String addressLine4;
     private String postCode;
     private String city;
     private boolean isPrimary;

    public HolderResidentialAddress() {
    }

	
    public HolderResidentialAddress(HolderResidentialAddressId id, Holder holder) {
        this.id = id;
        this.holder = holder;
    }
    public HolderResidentialAddress(HolderResidentialAddressId id, Holder holder, String addressLine2, String addressLine3, String addressLine4, String postCode, String city, boolean isPrimary) {
       this.id = id;
       this.holder = holder;
       this.addressLine2 = addressLine2;
       this.addressLine3 = addressLine3;
       this.addressLine4 = addressLine4;
       this.postCode = postCode;
       this.city = city;
       this.isPrimary = isPrimary;
    }
   
    public HolderResidentialAddressId getId() {
        return this.id;
    }
    
    public void setId(HolderResidentialAddressId id) {
        this.id = id;
    }
    /**
     * A getter for HolderPhoneNumber object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for HolderPhoneNumber object which persist the 
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
    public boolean isIsPrimary() {
        return this.isPrimary;
    }
    
    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }


}


