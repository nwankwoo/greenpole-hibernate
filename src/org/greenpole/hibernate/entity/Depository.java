package org.greenpole.hibernate.entity;
// Generated 23-Jun-2015 04:56:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Depository generated by hbm2java
 */
public class Depository  implements java.io.Serializable {


     private int id;
     private Long version;
     private String name;
     private String description;
     private Set clientCompanies = new HashSet(0);

    public Depository() {
    }

    public Depository(String name, String description, Set clientCompanies) {
       this.name = name;
       this.description = description;
       this.clientCompanies = clientCompanies;
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
    public Set getClientCompanies() {
        return this.clientCompanies;
    }
    
    public void setClientCompanies(Set clientCompanies) {
        this.clientCompanies = clientCompanies;
    }




}


