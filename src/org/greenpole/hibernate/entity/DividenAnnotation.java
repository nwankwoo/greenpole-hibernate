package org.greenpole.hibernate.entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.backup_entity.*;
import org.greenpole.hibernate.entity.*;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * DividenAnnotation generated by hbm2java
 */
public class DividenAnnotation  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Dividend dividend;
     private String annotation;

    public DividenAnnotation() {
    }

    public DividenAnnotation(Dividend dividend, String annotation) {
       this.dividend = dividend;
       this.annotation = annotation;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for DividenAnnotation object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for DividenAnnotation object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    
    public Dividend getDividend() {
        return this.dividend;
    }
    
    public void setDividend(Dividend dividend) {
        this.dividend = dividend;
    }
    public String getAnnotation() {
        return this.annotation;
    }
    
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }




}


