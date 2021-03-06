package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * BondType generated by hbm2java
 */
public class BondType  implements java.io.Serializable {


     private int id;
     private Long version;
     private String type;
     private String description;
     private Set bondOffers = new HashSet(0);
     private Set coupons = new HashSet(0);

    public BondType() {
    }

    public BondType(String type, String description, Set bondOffers, Set coupons) {
       this.type = type;
       this.description = description;
       this.bondOffers = bondOffers;
       this.coupons = coupons;
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
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getBondOffers() {
        return this.bondOffers;
    }
    
    public void setBondOffers(Set bondOffers) {
        this.bondOffers = bondOffers;
    }
    public Set getCoupons() {
        return this.coupons;
    }
    
    public void setCoupons(Set coupons) {
        this.coupons = coupons;
    }




}


