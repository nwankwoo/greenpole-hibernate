package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * HolderEmailAddress generated by hbm2java
 */
public class HolderEmailAddress  implements java.io.Serializable {


     private HolderEmailAddressId id;
     private Holder holder;

    public HolderEmailAddress() {
    }

    public HolderEmailAddress(HolderEmailAddressId id, Holder holder) {
       this.id = id;
       this.holder = holder;
    }
   
    public HolderEmailAddressId getId() {
        return this.id;
    }
    
    public void setId(HolderEmailAddressId id) {
        this.id = id;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }




}

