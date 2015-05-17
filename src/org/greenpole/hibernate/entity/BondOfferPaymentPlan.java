package org.greenpole.hibernate.entity;
// Generated 16-May-2015 16:13:37 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;




/**
 * BondOfferPaymentPlan generated by hbm2java
 */
public class BondOfferPaymentPlan  implements java.io.Serializable {


     private int id;
     private long versionId;
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
    /**
     * A getter for Administrator object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for Administrator object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
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
        return bondOffers;
    }

    public void setBondOffers(Set bondOffers) {
        this.bondOffers = bondOffers;
    }




}


