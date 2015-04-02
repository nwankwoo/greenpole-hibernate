package org.greenpole.hibernate.entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.backup_entity.*;
import org.greenpole.hibernate.entity.*;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * HolderPostalAddressId generated by hbm2java
 */
public class HolderPostalAddressId  implements java.io.Serializable {


     private int holderId;
     private String addressLine;
     private int lineNumber;

    public HolderPostalAddressId() {
    }

    public HolderPostalAddressId(int holderId, String addressLine, int lineNumber) {
       this.holderId = holderId;
       this.addressLine = addressLine;
       this.lineNumber = lineNumber;
    }
   
    public int getHolderId() {
        return this.holderId;
    }
    
    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }
    public String getAddressLine() {
        return this.addressLine;
    }
    
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
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
		 if ( !(other instanceof HolderPostalAddressId) ) return false;
		 HolderPostalAddressId castOther = ( HolderPostalAddressId ) other; 
         
		 return (this.getHolderId()==castOther.getHolderId())
 && ( (this.getAddressLine()==castOther.getAddressLine()) || ( this.getAddressLine()!=null && castOther.getAddressLine()!=null && this.getAddressLine().equals(castOther.getAddressLine()) ) )
 && (this.getLineNumber()==castOther.getLineNumber());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getHolderId();
         result = 37 * result + ( getAddressLine() == null ? 0 : this.getAddressLine().hashCode() );
         result = 37 * result + this.getLineNumber();
         return result;
   }   


}


