package org.greenpole.hibernate.backup_entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.entity.*;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * HolderEmailAddress generated by hbm2java
 */
public class HolderEmailAddress  implements java.io.Serializable {


     private HolderEmailAddressId id;
     private long versionId;
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
    
    /**
     * A getter for HolderEmailAddress object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for HolderEmailAddress object which persist the 
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




}


