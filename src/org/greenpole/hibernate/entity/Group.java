package org.greenpole.hibernate.entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import org.greenpole.hibernate.backup_entity.*;
import org.greenpole.hibernate.entity.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Group generated by hbm2java
 */
public class Group  implements java.io.Serializable {


     private int id;
     private long versionId;
     private String name;
     private String description;
     private Set requirements = new HashSet(0);
     private Set userAccounts = new HashSet(0);

    public Group() {
    }

    public Group(String name, String description, Set requirements, Set userAccounts) {
       this.name = name;
       this.description = description;
       this.requirements = requirements;
       this.userAccounts = userAccounts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for Group object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for Group object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
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
    public Set getRequirements() {
        return this.requirements;
    }
    
    public void setRequirements(Set requirements) {
        this.requirements = requirements;
    }
    public Set getUserAccounts() {
        return this.userAccounts;
    }
    
    public void setUserAccounts(Set userAccounts) {
        this.userAccounts = userAccounts;
    }




}


