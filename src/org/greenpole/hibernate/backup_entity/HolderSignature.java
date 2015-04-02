package org.greenpole.hibernate.backup_entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.entity.*;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * HolderSignature generated by hbm2java
 */
public class HolderSignature  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Holder holder;
     private String signaturePath;
     private boolean holderSignaturePrimary;

    public HolderSignature() {
    }

    public HolderSignature(Holder holder, String signaturePath, boolean holderSignaturePrimary) {
       this.holder = holder;
       this.signaturePath = signaturePath;
       this.holderSignaturePrimary = holderSignaturePrimary;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for HolderSignature object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for HolderSignature object which persist the 
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
    public String getSignaturePath() {
        return this.signaturePath;
    }
    
    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath;
    }
    public boolean isHolderSignaturePrimary() {
        return this.holderSignaturePrimary;
    }
    
    public void setHolderSignaturePrimary(boolean holderSignaturePrimary) {
        this.holderSignaturePrimary = holderSignaturePrimary;
    }




}


