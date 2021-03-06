package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1



/**
 * DividenAnnotation generated by hbm2java
 */
public class DividenAnnotation  implements java.io.Serializable {


     private int id;
     private Long version;
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
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
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


