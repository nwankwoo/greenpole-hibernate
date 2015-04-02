package org.greenpole.hibernate.backup_entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.entity.*;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * ClientCompanyEmailAddressId generated by hbm2java
 */
public class ClientCompanyEmailAddressId  implements java.io.Serializable {


     private int clientCompanyId;
     private String emailAddress;
     private int lineNumber;

    public ClientCompanyEmailAddressId() {
    }

    public ClientCompanyEmailAddressId(int clientCompanyId, String emailAddress, int lineNumber) {
       this.clientCompanyId = clientCompanyId;
       this.emailAddress = emailAddress;
       this.lineNumber = lineNumber;
    }
   
    public int getClientCompanyId() {
        return this.clientCompanyId;
    }
    
    public void setClientCompanyId(int clientCompanyId) {
        this.clientCompanyId = clientCompanyId;
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
		 if ( !(other instanceof ClientCompanyEmailAddressId) ) return false;
		 ClientCompanyEmailAddressId castOther = ( ClientCompanyEmailAddressId ) other; 
         
		 return (this.getClientCompanyId()==castOther.getClientCompanyId())
 && ( (this.getEmailAddress()==castOther.getEmailAddress()) || ( this.getEmailAddress()!=null && castOther.getEmailAddress()!=null && this.getEmailAddress().equals(castOther.getEmailAddress()) ) )
 && (this.getLineNumber()==castOther.getLineNumber());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getClientCompanyId();
         result = 37 * result + ( getEmailAddress() == null ? 0 : this.getEmailAddress().hashCode() );
         result = 37 * result + this.getLineNumber();
         return result;
   }   


}


