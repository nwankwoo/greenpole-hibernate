package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;




/**
 * AprDepartment generated by hbm2java
 */
public class AprDepartment  implements java.io.Serializable {


     private int id;
     private long versionId;
     private String name;
     private String description;
     private Set aprUnits = new HashSet(0);
     private Set userAccounts = new HashSet(0);

    public AprDepartment() {
    }

    public AprDepartment(String name, String description, Set aprUnits, Set userAccounts) {
       this.name = name;
       this.description = description;
       this.aprUnits = aprUnits;
       this.userAccounts = userAccounts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
        /**
     * A getter for AprDepartment object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for AprDepartment object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public Set getAprUnits() {
        return aprUnits;
    }

    public void setAprUnits(Set aprUnits) {
        this.aprUnits = aprUnits;
    }

    public Set getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(Set userAccounts) {
        this.userAccounts = userAccounts;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


