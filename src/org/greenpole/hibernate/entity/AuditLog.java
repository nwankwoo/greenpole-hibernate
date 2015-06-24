package org.greenpole.hibernate.entity;
// Generated 24-Jun-2015 14:34:48 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * AuditLog generated by hbm2java
 */
public class AuditLog  implements java.io.Serializable {


     private int id;
     private Long version;
     private String userId;
     private String functionPerformed;
     private Boolean approverRequired;
     private String designatedApprover;
     private String affectedEntityType;
     private String entityName;
     private Date dateTime;

    public AuditLog() {
    }

    public AuditLog(String userId, String functionPerformed, Boolean approverRequired, String designatedApprover, String affectedEntityType, String entityName, Date dateTime) {
       this.userId = userId;
       this.functionPerformed = functionPerformed;
       this.approverRequired = approverRequired;
       this.designatedApprover = designatedApprover;
       this.affectedEntityType = affectedEntityType;
       this.entityName = entityName;
       this.dateTime = dateTime;
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
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getFunctionPerformed() {
        return this.functionPerformed;
    }
    
    public void setFunctionPerformed(String functionPerformed) {
        this.functionPerformed = functionPerformed;
    }
    public Boolean getApproverRequired() {
        return this.approverRequired;
    }
    
    public void setApproverRequired(Boolean approverRequired) {
        this.approverRequired = approverRequired;
    }
    public String getDesignatedApprover() {
        return this.designatedApprover;
    }
    
    public void setDesignatedApprover(String designatedApprover) {
        this.designatedApprover = designatedApprover;
    }
    public String getAffectedEntityType() {
        return this.affectedEntityType;
    }
    
    public void setAffectedEntityType(String affectedEntityType) {
        this.affectedEntityType = affectedEntityType;
    }
    public String getEntityName() {
        return this.entityName;
    }
    
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    public Date getDateTime() {
        return this.dateTime;
    }
    
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }




}


