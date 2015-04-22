package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * DigitalCapture generated by hbm2java
 */
public class DigitalCapture  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Holder holder;
     private String title;
     private byte[] signature;
     private byte[] fingerprint;

    public DigitalCapture() {
    }

    public DigitalCapture(Holder holder, String title, byte[] signature, byte[] fingerprint) {
       this.holder = holder;
       this.title = title;
       this.signature = signature;
       this.fingerprint = fingerprint;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for DigitalCapture object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for DigitalCapture object which persist the 
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public byte[] getSignature() {
        return this.signature;
    }
    
    public void setSignature(byte[] signature) {
        this.signature = signature;
    }
    public byte[] getFingerprint() {
        return this.fingerprint;
    }
    
    public void setFingerprint(byte[] fingerprint) {
        this.fingerprint = fingerprint;
    }




}


