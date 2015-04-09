package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * StockbrokerEmailAddressId generated by hbm2java
 */
public class StockbrokerEmailAddressId  implements java.io.Serializable {


     private int stockbrokerId;
     private long versionId;
     private String emailAddress;
     private int lineNumber;

    public StockbrokerEmailAddressId() {
    }

    public StockbrokerEmailAddressId(int stockbrokerId, String emailAddress, int lineNumber) {
       this.stockbrokerId = stockbrokerId;
       this.emailAddress = emailAddress;
       this.lineNumber = lineNumber;
    }
   
    public int getStockbrokerId() {
        return this.stockbrokerId;
    }
    
    public void setStockbrokerId(int stockbrokerId) {
        this.stockbrokerId = stockbrokerId;
    }
      /**
     * A getter for StockbrokerEmailAddressId object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for StockbrokerEmailAddressId object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public int getLineNumber() {
        return this.lineNumber;
    }
    
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StockbrokerEmailAddressId) ) return false;
		 StockbrokerEmailAddressId castOther = ( StockbrokerEmailAddressId ) other; 
         
		 return (this.getStockbrokerId()==castOther.getStockbrokerId())
 && ( (this.getEmailAddress()==castOther.getEmailAddress()) || ( this.getEmailAddress()!=null && castOther.getEmailAddress()!=null && this.getEmailAddress().equals(castOther.getEmailAddress()) ) )
 && (this.getLineNumber()==castOther.getLineNumber());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getStockbrokerId();
         result = 37 * result + ( getEmailAddress() == null ? 0 : this.getEmailAddress().hashCode() );
         result = 37 * result + this.getLineNumber();
         return result;
   }   


}


