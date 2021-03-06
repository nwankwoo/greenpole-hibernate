package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * BondOfferPaymentPlan generated by hbm2java
 */
public class BondOfferPaymentPlan  implements java.io.Serializable {


     private int id;
     private Long version;
     private String paymentPlan;
     private String description;
     private Set bondOffers = new HashSet(0);

    public BondOfferPaymentPlan() {
    }

    public BondOfferPaymentPlan(String paymentPlan, String description, Set bondOffers) {
       this.paymentPlan = paymentPlan;
       this.description = description;
       this.bondOffers = bondOffers;
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
    public String getPaymentPlan() {
        return this.paymentPlan;
    }
    
    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
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




}


