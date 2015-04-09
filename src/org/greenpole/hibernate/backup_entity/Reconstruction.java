package org.greenpole.hibernate.backup_entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.entity.*;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * Reconstruction generated by hbm2java
 */
public class Reconstruction  implements java.io.Serializable {


     private int id;   
     private long versionId;
     private ClientCompany clientCompany;
     private String reconstructionType;
     private int shareRatio;
     private String increaseOrDecrease;

    public Reconstruction() {
    }

    public Reconstruction(ClientCompany clientCompany, String reconstructionType, int shareRatio, String increaseOrDecrease) {
       this.clientCompany = clientCompany;
       this.reconstructionType = reconstructionType;
       this.shareRatio = shareRatio;
       this.increaseOrDecrease = increaseOrDecrease;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for Reconstruction object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for Reconstruction object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public String getReconstructionType() {
        return this.reconstructionType;
    }
    
    public void setReconstructionType(String reconstructionType) {
        this.reconstructionType = reconstructionType;
    }
    public int getShareRatio() {
        return this.shareRatio;
    }
    
    public void setShareRatio(int shareRatio) {
        this.shareRatio = shareRatio;
    }
    public String getIncreaseOrDecrease() {
        return this.increaseOrDecrease;
    }
    
    public void setIncreaseOrDecrease(String increaseOrDecrease) {
        this.increaseOrDecrease = increaseOrDecrease;
    }




}


