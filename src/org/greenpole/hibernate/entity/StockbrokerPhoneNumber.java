package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:17:29 by Hibernate Tools 4.3.1



/**
 * StockbrokerPhoneNumber generated by hbm2java
 */
public class StockbrokerPhoneNumber  implements java.io.Serializable {


     private int id;
     private Long version;
     private Stockbroker stockbroker;
     private String phoneNumber;
     private Boolean isPrimary;

    public StockbrokerPhoneNumber() {
    }

    public StockbrokerPhoneNumber(Stockbroker stockbroker, String phoneNumber, Boolean isPrimary) {
       this.stockbroker = stockbroker;
       this.phoneNumber = phoneNumber;
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
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Boolean getIsPrimary() {
        return this.isPrimary;
    }
    
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }




}


