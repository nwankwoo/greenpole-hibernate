package org.greenpole.hibernate.entity;
// Generated 16-Jun-2015 12:22:21 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AprDepartment generated by hbm2java
 */
public class AprDepartment  implements java.io.Serializable {


     private int id;
     private Long version;
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
    public Set getAprUnits() {
        return this.aprUnits;
    }
    
    public void setAprUnits(Set aprUnits) {
        this.aprUnits = aprUnits;
    }
    public Set getUserAccounts() {
        return this.userAccounts;
    }
    
    public void setUserAccounts(Set userAccounts) {
        this.userAccounts = userAccounts;
    }




}


