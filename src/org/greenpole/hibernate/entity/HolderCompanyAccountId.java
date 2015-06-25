package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 11:31:21 by Hibernate Tools 4.3.1



/**
 * HolderCompanyAccountId generated by hbm2java
 */
public class HolderCompanyAccountId  implements java.io.Serializable {


     private int holderId;
     private int clientCompanyId;

    public HolderCompanyAccountId() {
    }

    public HolderCompanyAccountId(int holderId, int clientCompanyId) {
       this.holderId = holderId;
       this.clientCompanyId = clientCompanyId;
    }
   
    public int getHolderId() {
        return this.holderId;
    }
    
    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }
    public int getClientCompanyId() {
        return this.clientCompanyId;
    }
    
    public void setClientCompanyId(int clientCompanyId) {
        this.clientCompanyId = clientCompanyId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HolderCompanyAccountId) ) return false;
		 HolderCompanyAccountId castOther = ( HolderCompanyAccountId ) other; 
         
		 return (this.getHolderId()==castOther.getHolderId())
 && (this.getClientCompanyId()==castOther.getClientCompanyId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getHolderId();
         result = 37 * result + this.getClientCompanyId();
         return result;
   }   


}


