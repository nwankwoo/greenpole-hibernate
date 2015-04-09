package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * ClientCompanyPhoneNumber generated by hbm2java
 */
public class ClientCompanyPhoneNumber  implements java.io.Serializable {


     private ClientCompanyPhoneNumberId id;
     private long versionId;
     private ClientCompany clientCompany; // to which client

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
    
    /**
     * A getter for ClientCompanyPhoneNumber object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for ClientCompanyPhoneNumber object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }




}


