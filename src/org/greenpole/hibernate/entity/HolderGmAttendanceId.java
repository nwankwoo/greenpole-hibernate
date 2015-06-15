package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 12:07:06 by Hibernate Tools 4.3.1



/**
 * HolderGmAttendanceId generated by hbm2java
 */
public class HolderGmAttendanceId  implements java.io.Serializable {


     private int holderId;
     private int gmId;

    public HolderGmAttendanceId() {
    }

    public HolderGmAttendanceId(int holderId, int gmId) {
       this.holderId = holderId;
       this.gmId = gmId;
    }
   
    public int getHolderId() {
        return this.holderId;
    }
    
    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }
    public int getGmId() {
        return this.gmId;
    }
    
    public void setGmId(int gmId) {
        this.gmId = gmId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HolderGmAttendanceId) ) return false;
		 HolderGmAttendanceId castOther = ( HolderGmAttendanceId ) other; 
         
		 return (this.getHolderId()==castOther.getHolderId())
 && (this.getGmId()==castOther.getGmId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getHolderId();
         result = 37 * result + this.getGmId();
         return result;
   }   


}


