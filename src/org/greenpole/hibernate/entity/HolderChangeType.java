package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * HolderChangeType generated by hbm2java
 */
public class HolderChangeType  implements java.io.Serializable {


     private int id;
     private Long version;
     private String changeType;
     private String description;
     private Set holderChangeses = new HashSet(0);

    public HolderChangeType() {
    }

    public HolderChangeType(String changeType, String description, Set holderChangeses) {
       this.changeType = changeType;
       this.description = description;
       this.holderChangeses = holderChangeses;
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
    public String getChangeType() {
        return this.changeType;
    }
    
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getHolderChangeses() {
        return this.holderChangeses;
    }
    
    public void setHolderChangeses(Set holderChangeses) {
        this.holderChangeses = holderChangeses;
    }




}


