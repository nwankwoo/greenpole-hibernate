package org.greenpole.hibernate.entity;
// Generated 29-May-2015 21:21:44 by Hibernate Tools 4.3.1



/**
 * StockbrokerSignature generated by hbm2java
 */
public class StockbrokerSignature  implements java.io.Serializable {


     private int id;
     private Long version;
     private Stockbroker stockbroker;
     private String title;
     private String signaturePath;
     private Boolean stockbrokerSignPrimary;

    public StockbrokerSignature() {
    }

    public StockbrokerSignature(Stockbroker stockbroker, String title, String signaturePath, Boolean stockbrokerSignPrimary) {
       this.stockbroker = stockbroker;
       this.title = title;
       this.signaturePath = signaturePath;
       this.stockbrokerSignPrimary = stockbrokerSignPrimary;
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
    public Stockbroker getStockbroker() {
        return this.stockbroker;
    }
    
    public void setStockbroker(Stockbroker stockbroker) {
        this.stockbroker = stockbroker;
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
    public Boolean getStockbrokerSignPrimary() {
        return this.stockbrokerSignPrimary;
    }
    
    public void setStockbrokerSignPrimary(Boolean stockbrokerSignPrimary) {
        this.stockbrokerSignPrimary = stockbrokerSignPrimary;
    }




}


