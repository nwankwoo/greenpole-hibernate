package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 15:41:35 by Hibernate Tools 4.3.1



/**
 * PropertyNotifiers generated by hbm2java
 */
public class PropertyNotifiers  implements java.io.Serializable {


     private int id;
     private Long version;
     private String propertyName;
     private String propertyValue;

    public PropertyNotifiers() {
    }

    public PropertyNotifiers(String propertyName, String propertyValue) {
       this.propertyName = propertyName;
       this.propertyValue = propertyValue;
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
    public String getPropertyName() {
        return this.propertyName;
    }
    
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    public String getPropertyValue() {
        return this.propertyValue;
    }
    
    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }




}


