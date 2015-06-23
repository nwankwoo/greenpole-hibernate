package org.greenpole.hibernate.entity;
// Generated 23-Jun-2015 04:56:55 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * CertificateEvent generated by hbm2java
 */
public class CertificateEvent  implements java.io.Serializable {


     private int id;
     private Long version;
     private Certificate certificate;
     private Boolean splitStatus;
     private Boolean mergeStatus;
     private Date eventDate;

    public CertificateEvent() {
    }

    public CertificateEvent(Certificate certificate, Boolean splitStatus, Boolean mergeStatus, Date eventDate) {
       this.certificate = certificate;
       this.splitStatus = splitStatus;
       this.mergeStatus = mergeStatus;
       this.eventDate = eventDate;
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
    public Certificate getCertificate() {
        return this.certificate;
    }
    
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
    public Boolean getSplitStatus() {
        return this.splitStatus;
    }
    
    public void setSplitStatus(Boolean splitStatus) {
        this.splitStatus = splitStatus;
    }
    public Boolean getMergeStatus() {
        return this.mergeStatus;
    }
    
    public void setMergeStatus(Boolean mergeStatus) {
        this.mergeStatus = mergeStatus;
    }
    public Date getEventDate() {
        return this.eventDate;
    }
    
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }




}


