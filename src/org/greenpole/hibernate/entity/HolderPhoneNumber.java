package org.greenpole.hibernate.entity;
// Generated 29-May-2015 21:21:44 by Hibernate Tools 4.3.1



/**
 * HolderPhoneNumber generated by hbm2java
 */
public class HolderPhoneNumber  implements java.io.Serializable {


     private HolderPhoneNumberId id;
     private Long version;
     private Holder holder;
     private Boolean isPrimary;

    public HolderPhoneNumber() {
    }

	
    public HolderPhoneNumber(HolderPhoneNumberId id, Holder holder) {
        this.id = id;
        this.holder = holder;
    }
    public HolderPhoneNumber(HolderPhoneNumberId id, Holder holder, Boolean isPrimary) {
       this.id = id;
       this.holder = holder;
       this.isPrimary = isPrimary;
    }
   
    public HolderPhoneNumberId getId() {
        return this.id;
    }
    
    public void setId(HolderPhoneNumberId id) {
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
    public Boolean getIsPrimary() {
        return this.isPrimary;
    }
    
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }




}


