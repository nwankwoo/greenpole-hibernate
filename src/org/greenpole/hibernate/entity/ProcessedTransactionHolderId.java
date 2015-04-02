package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * ProcessedTransactionHolderId generated by hbm2java
 */
public class ProcessedTransactionHolderId  implements java.io.Serializable {


     private int transactionId;
     private int holderId;

    public ProcessedTransactionHolderId() {
    }

    public ProcessedTransactionHolderId(int transactionId, int holderId) {
       this.transactionId = transactionId;
       this.holderId = holderId;
    }
   
    public int getTransactionId() {
        return this.transactionId;
    }
    
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public int getHolderId() {
        return this.holderId;
    }
    
    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProcessedTransactionHolderId) ) return false;
		 ProcessedTransactionHolderId castOther = ( ProcessedTransactionHolderId ) other; 
         
		 return (this.getTransactionId()==castOther.getTransactionId())
 && (this.getHolderId()==castOther.getHolderId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getTransactionId();
         result = 37 * result + this.getHolderId();
         return result;
   }   


}


