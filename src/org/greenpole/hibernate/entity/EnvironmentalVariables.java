package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 15:58:53 by Hibernate Tools 4.3.1



/**
 * EnvironmentalVariables generated by hbm2java
 */
public class EnvironmentalVariables  implements java.io.Serializable {


     private int id;
     private Long version;
     private String variable;
     private String path;

    public EnvironmentalVariables() {
    }

    public EnvironmentalVariables(String variable, String path) {
       this.variable = variable;
       this.path = path;
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
    public String getVariable() {
        return this.variable;
    }
    
    public void setVariable(String variable) {
        this.variable = variable;
    }
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }




}


