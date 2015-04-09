package org.greenpole.hibernate.backup_entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.entity.*;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * AdministratorPhoneNumber generated by hbm2java
 */
public class AdministratorPhoneNumber  implements java.io.Serializable {


     private AdministratorPhoneNumberId id;
     private long versionId;
     private Administrator administrator;

    public AdministratorPhoneNumber() {
    }

    public AdministratorPhoneNumber(AdministratorPhoneNumberId id, Administrator administrator) {
       this.id = id;
       this.administrator = administrator;
    }
   
    public AdministratorPhoneNumberId getId() {
        return this.id;
    }
    
    public void setId(AdministratorPhoneNumberId id) {
        this.id = id;
    }
    
    /**
     * A getter for AdministratorPhoneNumber object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for AdministratorPhoneNumber object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    public Administrator getAdministrator() {
        return this.administrator;
    }
    
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }




}


