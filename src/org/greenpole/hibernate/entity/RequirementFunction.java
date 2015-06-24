package org.greenpole.hibernate.entity;
// Generated 24-Jun-2015 14:34:48 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * RequirementFunction generated by hbm2java
 */
public class RequirementFunction  implements java.io.Serializable {


     private int id;
     private Long version;
     private Requirement requirement;
     private String name;
     private String description;
     private Set userAccounts = new HashSet(0);

    public RequirementFunction() {
    }

    public RequirementFunction(Requirement requirement, String name, String description, Set userAccounts) {
       this.requirement = requirement;
       this.name = name;
       this.description = description;
       this.userAccounts = userAccounts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    public Requirement getRequirement() {
        return this.requirement;
    }
    
    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
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
    public Set getUserAccounts() {
        return this.userAccounts;
    }
    
    public void setUserAccounts(Set userAccounts) {
        this.userAccounts = userAccounts;
    }




}


