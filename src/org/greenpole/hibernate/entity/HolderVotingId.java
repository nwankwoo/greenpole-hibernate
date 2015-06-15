package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 13:01:59 by Hibernate Tools 4.3.1



/**
 * HolderVotingId generated by hbm2java
 */
public class HolderVotingId  implements java.io.Serializable {


     private int holderId;
     private int votingProcessId;

    public HolderVotingId() {
    }

    public HolderVotingId(int holderId, int votingProcessId) {
       this.holderId = holderId;
       this.votingProcessId = votingProcessId;
    }
   
    public int getHolderId() {
        return this.holderId;
    }
    
    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }
    public int getVotingProcessId() {
        return this.votingProcessId;
    }
    
    public void setVotingProcessId(int votingProcessId) {
        this.votingProcessId = votingProcessId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HolderVotingId) ) return false;
		 HolderVotingId castOther = ( HolderVotingId ) other; 
         
		 return (this.getHolderId()==castOther.getHolderId())
 && (this.getVotingProcessId()==castOther.getVotingProcessId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getHolderId();
         result = 37 * result + this.getVotingProcessId();
         return result;
   }   


}


