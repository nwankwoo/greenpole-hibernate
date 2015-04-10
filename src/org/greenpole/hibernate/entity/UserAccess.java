package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * UserAccess generated by hbm2java
 */
public class UserAccess  implements java.io.Serializable {


     private int id;
     private long versionId;
     private UserAccount userAccount;
     private String email;
     private String password;
     private String userType;
     private int maxIndividualShareHolding;
     private int maxTotalShareHolding;
     private boolean suspended;
     private Date releaseSuspension;
     private boolean locked;
     private boolean expired;
     private String expiredPassword1;
     private String expiredPassword2;
     private String expiredPassword3;
     private String expiredPassword4;

    public UserAccess() {
    }

    public UserAccess(UserAccount userAccount, String email, String password, String userType, int maxIndividualShareHolding, int maxTotalShareHolding, boolean suspended, Date releaseSuspension, boolean locked, boolean expired, String expiredPassword1, String expiredPassword2, String expiredPassword3, String expiredPassword4) {
       this.userAccount = userAccount;
       this.email = email;
       this.password = password;
       this.userType = userType;
       this.maxIndividualShareHolding = maxIndividualShareHolding;
       this.maxTotalShareHolding = maxTotalShareHolding;
       this.suspended = suspended;
       this.releaseSuspension = releaseSuspension;
       this.locked = locked;
       this.expired = expired;
       this.expiredPassword1 = expiredPassword1;
       this.expiredPassword2 = expiredPassword2;
       this.expiredPassword3 = expiredPassword3;
       this.expiredPassword4 = expiredPassword4;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for UserAccess object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for UserAccess object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    public UserAccount getUserAccount() {
        return this.userAccount;
    }
    
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    public int getMaxIndividualShareHolding() {
        return this.maxIndividualShareHolding;
    }
    
    public void setMaxIndividualShareHolding(int maxIndividualShareHolding) {
        this.maxIndividualShareHolding = maxIndividualShareHolding;
    }
    public int getMaxTotalShareHolding() {
        return this.maxTotalShareHolding;
    }
    
    public void setMaxTotalShareHolding(int maxTotalShareHolding) {
        this.maxTotalShareHolding = maxTotalShareHolding;
    }
    public boolean isSuspended() {
        return this.suspended;
    }
    
    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }
    public Date getReleaseSuspension() {
        return this.releaseSuspension;
    }
    
    public void setReleaseSuspension(Date releaseSuspension) {
        this.releaseSuspension = releaseSuspension;
    }
    public boolean isLocked() {
        return this.locked;
    }
    
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public boolean isExpired() {
        return this.expired;
    }
    
    public void setExpired(boolean expired) {
        this.expired = expired;
    }
    public String getExpiredPassword1() {
        return this.expiredPassword1;
    }
    
    public void setExpiredPassword1(String expiredPassword1) {
        this.expiredPassword1 = expiredPassword1;
    }
    public String getExpiredPassword2() {
        return this.expiredPassword2;
    }
    
    public void setExpiredPassword2(String expiredPassword2) {
        this.expiredPassword2 = expiredPassword2;
    }
    public String getExpiredPassword3() {
        return this.expiredPassword3;
    }
    
    public void setExpiredPassword3(String expiredPassword3) {
        this.expiredPassword3 = expiredPassword3;
    }
    public String getExpiredPassword4() {
        return this.expiredPassword4;
    }
    
    public void setExpiredPassword4(String expiredPassword4) {
        this.expiredPassword4 = expiredPassword4;
    }




}


