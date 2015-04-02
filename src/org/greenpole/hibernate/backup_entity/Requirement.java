package org.greenpole.hibernate.backup_entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import org.greenpole.hibernate.entity.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Requirement generated by hbm2java
 */
public class Requirement  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Group group;
     private String name;
     private String description;
     private String screen;
     private Set requirementFunctions = new HashSet(0);
     private Set userAccounts = new HashSet(0);

    public Requirement() {
    }

    public Requirement(Group group, String name, String description, String screen, Set requirementFunctions, Set userAccounts) {
       this.group = group;
       this.name = name;
       this.description = description;
       this.screen = screen;
       this.requirementFunctions = requirementFunctions;
       this.userAccounts = userAccounts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for Requirement object version, mostly assist in 
     * concurrency and easy retrieval of an object
     * @return  versionId, which is unique to a particular object, aside the 
	database primary key
    */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for Requirement object version, mostly assist in 
     * concurrency. it keeps records of general modified persistence object
     * @param versionId, argument that takes automatic generated versionId by the hibernate
    */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    
    public Group getGroup() {
        return this.group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
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
    public String getScreen() {
        return this.screen;
    }
    
    public void setScreen(String screen) {
        this.screen = screen;
    }
    public Set getRequirementFunctions() {
        return this.requirementFunctions;
    }
    
    public void setRequirementFunctions(Set requirementFunctions) {
        this.requirementFunctions = requirementFunctions;
    }
    public Set getUserAccounts() {
        return this.userAccounts;
    }
    
    public void setUserAccounts(Set userAccounts) {
        this.userAccounts = userAccounts;
    }




}


