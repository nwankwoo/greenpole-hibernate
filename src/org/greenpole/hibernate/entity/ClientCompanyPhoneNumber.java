package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * ClientCompanyPhoneNumber generated by hbm2java
 */
public class ClientCompanyPhoneNumber  implements java.io.Serializable {


     private ClientCompanyPhoneNumberId id;
     private ClientCompany clientCompany;

    public ClientCompanyPhoneNumber() {
    }

    public ClientCompanyPhoneNumber(ClientCompanyPhoneNumberId id, ClientCompany clientCompany) {
       this.id = id;
       this.clientCompany = clientCompany;
    }
   
    public ClientCompanyPhoneNumberId getId() {
        return this.id;
    }
    
    public void setId(ClientCompanyPhoneNumberId id) {
        this.id = id;
    }
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }




}


