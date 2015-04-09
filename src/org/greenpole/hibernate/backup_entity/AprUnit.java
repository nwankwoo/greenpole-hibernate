package org.greenpole.hibernate.backup_entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.entity.*;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * AprUnit generated by hbm2java
 */
public class AprUnit  implements java.io.Serializable {


     private int id;
     private long versionId;
     private String name;
     private String description;
     private int deptId;

    public AprUnit() {
    }

    public AprUnit(String name, String description, int deptId) {
       this.name = name;
       this.description = description;
       this.deptId = deptId;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for AprUnit object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for AprUnit object which persist the 
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
    public int getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }




}


