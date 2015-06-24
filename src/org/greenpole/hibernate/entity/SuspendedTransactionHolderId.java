package org.greenpole.hibernate.entity;
// Generated 24-Jun-2015 14:34:48 by Hibernate Tools 4.3.1



/**
 * SuspendedTransactionHolderId generated by hbm2java
 */
public class SuspendedTransactionHolderId  implements java.io.Serializable {


     private int transactionId;
     private int holderId;

    public SuspendedTransactionHolderId() {
    }

    public SuspendedTransactionHolderId(int transactionId, int holderId) {
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
		 if ( !(other instanceof SuspendedTransactionHolderId) ) return false;
		 SuspendedTransactionHolderId castOther = ( SuspendedTransactionHolderId ) other; 
         
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


