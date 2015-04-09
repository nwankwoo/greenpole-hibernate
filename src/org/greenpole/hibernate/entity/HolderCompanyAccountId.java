package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * HolderCompanyAccountId generated by hbm2java
 */
public class HolderCompanyAccountId  implements java.io.Serializable {


     private int holderId;
     private long versionId;
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
    
    /**
     * A getter for HolderCompanyAccountId object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for HolderCompanyAccountId object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
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


