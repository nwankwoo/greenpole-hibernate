package org.greenpole.hibernate.entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.backup_entity.*;
import org.greenpole.hibernate.entity.*;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * CertificateVerification generated by hbm2java
 */
public class CertificateVerification  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Certificate certificate;
     private String status;
     private String note;

    public CertificateVerification() {
    }

    public CertificateVerification(Certificate certificate, String status, String note) {
       this.certificate = certificate;
       this.status = status;
       this.note = note;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * A getter for CertificateVerification object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for CertificateVerification object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    
    public Certificate getCertificate() {
        return this.certificate;
    }
    
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }




}


