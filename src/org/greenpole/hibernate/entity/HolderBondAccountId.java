package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:26:20 by Hibernate Tools 4.3.1



/**
 * HolderBondAccountId generated by hbm2java
 */
public class HolderBondAccountId  implements java.io.Serializable {


     private int holderId;
     private int bondOfferId;

    public HolderBondAccountId() {
    }

    public HolderBondAccountId(int holderId, int bondOfferId) {
       this.holderId = holderId;
       this.bondOfferId = bondOfferId;
    }
   
    public int getHolderId() {
        return this.holderId;
    }
    
    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }
    public int getBondOfferId() {
        return this.bondOfferId;
    }
    
    public void setBondOfferId(int bondOfferId) {
        this.bondOfferId = bondOfferId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HolderBondAccountId) ) return false;
		 HolderBondAccountId castOther = ( HolderBondAccountId ) other; 
         
		 return (this.getHolderId()==castOther.getHolderId())
 && (this.getBondOfferId()==castOther.getBondOfferId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getHolderId();
         result = 37 * result + this.getBondOfferId();
         return result;
   }   


}


