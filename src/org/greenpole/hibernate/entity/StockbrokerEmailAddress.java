package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 12:07:06 by Hibernate Tools 4.3.1



/**
 * StockbrokerEmailAddress generated by hbm2java
 */
public class StockbrokerEmailAddress  implements java.io.Serializable {


     private int id;
     private Long version;
     private Stockbroker stockbroker;
     private String emailAddress;
     private Boolean isPrimary;

    public StockbrokerEmailAddress() {
    }

    public StockbrokerEmailAddress(Stockbroker stockbroker, String emailAddress, Boolean isPrimary) {
       this.stockbroker = stockbroker;
       this.emailAddress = emailAddress;
       this.isPrimary = isPrimary;
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
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public Boolean getIsPrimary() {
        return this.isPrimary;
    }
    
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }




}


