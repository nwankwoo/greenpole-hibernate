package org.greenpole.hibernate.entity;
// Generated 16-Jun-2015 12:22:21 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CertificateLodgement generated by hbm2java
 */
public class CertificateLodgement  implements java.io.Serializable {


     private int id;
     private Long version;
     private int controlNumber;
     private String title;
     private Date date;
     private String certificateNumber;
     private Integer holdings;
     private String shareholderName;
     private String chn;
     private String status;
     private Boolean processed;
     private Set certificates = new HashSet(0);

    public CertificateLodgement() {
    }

	
    public CertificateLodgement(int controlNumber) {
        this.controlNumber = controlNumber;
    }
    public CertificateLodgement(int controlNumber, String title, Date date, String certificateNumber, Integer holdings, String shareholderName, String chn, String status, Boolean processed, Set certificates) {
       this.controlNumber = controlNumber;
       this.title = title;
       this.date = date;
       this.certificateNumber = certificateNumber;
       this.holdings = holdings;
       this.shareholderName = shareholderName;
       this.chn = chn;
       this.status = status;
       this.processed = processed;
       this.certificates = certificates;
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
    public int getControlNumber() {
        return this.controlNumber;
    }
    
    public void setControlNumber(int controlNumber) {
        this.controlNumber = controlNumber;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getCertificateNumber() {
        return this.certificateNumber;
    }
    
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
    public Integer getHoldings() {
        return this.holdings;
    }
    
    public void setHoldings(Integer holdings) {
        this.holdings = holdings;
    }
    public String getShareholderName() {
        return this.shareholderName;
    }
    
    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName;
    }
    public String getChn() {
        return this.chn;
    }
    
    public void setChn(String chn) {
        this.chn = chn;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Boolean getProcessed() {
        return this.processed;
    }
    
    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }




}


