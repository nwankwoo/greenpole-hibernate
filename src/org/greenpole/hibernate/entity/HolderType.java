package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 14:01:49 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * HolderType generated by hbm2java
 */
public class HolderType  implements java.io.Serializable {


     private int id;
     private Long version;
     private String type;
     private String description;
     private Set holders = new HashSet(0);

    public HolderType() {
    }

    public HolderType(String type, String description, Set holders) {
       this.type = type;
       this.description = description;
       this.holders = holders;
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
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getHolders() {
        return this.holders;
    }
    
    public void setHolders(Set holders) {
        this.holders = holders;
    }




}


