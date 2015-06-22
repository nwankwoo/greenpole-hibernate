package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:26:20 by Hibernate Tools 4.3.1



/**
 * HolderSignature generated by hbm2java
 */
public class HolderSignature  implements java.io.Serializable {


     private int id;
     private Long version;
     private Holder holder;
     private String title;
     private String signaturePath;
     private Boolean holderSignaturePrimary;

    public HolderSignature() {
    }

    public HolderSignature(Holder holder, String title, String signaturePath, Boolean holderSignaturePrimary) {
       this.holder = holder;
       this.title = title;
       this.signaturePath = signaturePath;
       this.holderSignaturePrimary = holderSignaturePrimary;
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
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSignaturePath() {
        return this.signaturePath;
    }
    
    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath;
    }
    public Boolean getHolderSignaturePrimary() {
        return this.holderSignaturePrimary;
    }
    
    public void setHolderSignaturePrimary(Boolean holderSignaturePrimary) {
        this.holderSignaturePrimary = holderSignaturePrimary;
    }




}


