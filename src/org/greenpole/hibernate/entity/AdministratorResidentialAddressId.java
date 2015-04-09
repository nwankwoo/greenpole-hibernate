package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * AdministratorResidentialAddressId generated by hbm2java
 */
public class AdministratorResidentialAddressId  implements java.io.Serializable {


     private int administratorId;
     private String addressLine;
     private int lineNumber;

    public AdministratorResidentialAddressId() {
    }

    public AdministratorResidentialAddressId(int administratorId, String addressLine, int lineNumber) {
       this.administratorId = administratorId;
       this.addressLine = addressLine;
       this.lineNumber = lineNumber;
    }
   
    public int getAdministratorId() {
        return this.administratorId;
    }
    
    public void setAdministratorId(int administratorId) {
        this.administratorId = administratorId;
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
		 if ( !(other instanceof AdministratorResidentialAddressId) ) return false;
		 AdministratorResidentialAddressId castOther = ( AdministratorResidentialAddressId ) other; 
         
		 return (this.getAdministratorId()==castOther.getAdministratorId())
 && ( (this.getAddressLine()==castOther.getAddressLine()) || ( this.getAddressLine()!=null && castOther.getAddressLine()!=null && this.getAddressLine().equals(castOther.getAddressLine()) ) )
 && (this.getLineNumber()==castOther.getLineNumber());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getAdministratorId();
         result = 37 * result + ( getAddressLine() == null ? 0 : this.getAddressLine().hashCode() );
         result = 37 * result + this.getLineNumber();
         return result;
   }   


}


