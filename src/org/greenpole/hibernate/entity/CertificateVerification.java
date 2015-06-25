package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 15:41:35 by Hibernate Tools 4.3.1



/**
 * CertificateVerification generated by hbm2java
 */
public class CertificateVerification  implements java.io.Serializable {


     private int id;
     private Long version;
     private Certificate certificate;
     private Stockbroker stockbroker;
     private String status;
     private String note;

    public CertificateVerification() {
    }

    public CertificateVerification(Certificate certificate, Stockbroker stockbroker, String status, String note) {
       this.certificate = certificate;
       this.stockbroker = stockbroker;
       this.status = status;
       this.note = note;
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
    public Stockbroker getStockbroker() {
        return this.stockbroker;
    }
    
    public void setStockbroker(Stockbroker stockbroker) {
        this.stockbroker = stockbroker;
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


