package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 13:01:59 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Group generated by hbm2java
 */
public class Group  implements java.io.Serializable {


     private int id;
     private Long version;
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
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
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


