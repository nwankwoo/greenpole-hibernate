package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1



/**
 * CertificateChangeRecord generated by hbm2java
 */
public class CertificateChangeRecord  implements java.io.Serializable {


     private int id;
     private Long version;
     private Certificate certificate;
     private byte[] changeReason;

    public CertificateChangeRecord() {
    }

    public CertificateChangeRecord(Certificate certificate, byte[] changeReason) {
       this.certificate = certificate;
       this.changeReason = changeReason;
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
    public byte[] getChangeReason() {
        return this.changeReason;
    }
    
    public void setChangeReason(byte[] changeReason) {
        this.changeReason = changeReason;
    }




}


