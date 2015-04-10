package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * StockbrokerEmailAddressId generated by hbm2java
 */
public class StockbrokerEmailAddressId  implements java.io.Serializable {


     private int stockbrokerId;
     private String emailAddress;

    public StockbrokerEmailAddressId() {
    }

    public StockbrokerEmailAddressId(int stockbrokerId, String emailAddress) {
       this.stockbrokerId = stockbrokerId;
       this.emailAddress = emailAddress;
    }
   
    public int getStockbrokerId() {
        return this.stockbrokerId;
    }
    
    public void setStockbrokerId(int stockbrokerId) {
        this.stockbrokerId = stockbrokerId;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StockbrokerEmailAddressId) ) return false;
		 StockbrokerEmailAddressId castOther = ( StockbrokerEmailAddressId ) other; 
         
		 return (this.getStockbrokerId()==castOther.getStockbrokerId())
 && ( (this.getEmailAddress()==castOther.getEmailAddress()) || ( this.getEmailAddress()!=null && castOther.getEmailAddress()!=null && this.getEmailAddress().equals(castOther.getEmailAddress()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getStockbrokerId();
         result = 37 * result + ( getEmailAddress() == null ? 0 : this.getEmailAddress().hashCode() );
         return result;
   }   


}


