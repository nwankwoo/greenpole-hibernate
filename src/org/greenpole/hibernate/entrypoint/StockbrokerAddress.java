package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * StockbrokerAddress generated by hbm2java
 */
public class StockbrokerAddress  implements java.io.Serializable {


     private StockbrokerAddressId id;
     private Stockbroker stockbroker;
     private String type;

    public StockbrokerAddress() {
    }

	
    public StockbrokerAddress(StockbrokerAddressId id, Stockbroker stockbroker) {
        this.id = id;
        this.stockbroker = stockbroker;
    }
    public StockbrokerAddress(StockbrokerAddressId id, Stockbroker stockbroker, String type) {
       this.id = id;
       this.stockbroker = stockbroker;
       this.type = type;
    }
   
    public StockbrokerAddressId getId() {
        return this.id;
    }
    
    public void setId(StockbrokerAddressId id) {
        this.id = id;
    }
    public Stockbroker getStockbroker() {
        return this.stockbroker;
    }
    
    public void setStockbroker(Stockbroker stockbroker) {
        this.stockbroker = stockbroker;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }




}


