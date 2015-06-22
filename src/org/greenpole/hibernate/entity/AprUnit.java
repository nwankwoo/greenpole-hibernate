package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:17:29 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AprUnit generated by hbm2java
 */
public class AprUnit  implements java.io.Serializable {


     private int id;
     private Long version;
     private AprDepartment aprDepartment;
     private String name;
     private String description;
     private Set userAccounts = new HashSet(0);

    public AprUnit() {
    }

    public AprUnit(AprDepartment aprDepartment, String name, String description, Set userAccounts) {
       this.aprDepartment = aprDepartment;
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
    public AprDepartment getAprDepartment() {
        return this.aprDepartment;
    }
    
    public void setAprDepartment(AprDepartment aprDepartment) {
        this.aprDepartment = aprDepartment;
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


