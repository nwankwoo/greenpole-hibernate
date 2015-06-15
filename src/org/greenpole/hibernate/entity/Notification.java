package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 13:01:59 by Hibernate Tools 4.3.1



/**
 * Notification generated by hbm2java
 */
public class Notification  implements java.io.Serializable {


     private int id;
     private Long version;
     private String fileName;
     private String description;
     private String sentFrom;
     private String sentTo;
     private String fromType;
     private String toType;
     private Boolean attendedTo;
     private Boolean writeOff;

    public Notification() {
    }

    public Notification(String fileName, String description, String sentFrom, String sentTo, String fromType, String toType, Boolean attendedTo, Boolean writeOff) {
       this.fileName = fileName;
       this.description = description;
       this.sentFrom = sentFrom;
       this.sentTo = sentTo;
       this.fromType = fromType;
       this.toType = toType;
       this.attendedTo = attendedTo;
       this.writeOff = writeOff;
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
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSentFrom() {
        return this.sentFrom;
    }
    
    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }
    public String getSentTo() {
        return this.sentTo;
    }
    
    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }
    public String getFromType() {
        return this.fromType;
    }
    
    public void setFromType(String fromType) {
        this.fromType = fromType;
    }
    public String getToType() {
        return this.toType;
    }
    
    public void setToType(String toType) {
        this.toType = toType;
    }
    public Boolean getAttendedTo() {
        return this.attendedTo;
    }
    
    public void setAttendedTo(Boolean attendedTo) {
        this.attendedTo = attendedTo;
    }
    public Boolean getWriteOff() {
        return this.writeOff;
    }
    
    public void setWriteOff(Boolean writeOff) {
        this.writeOff = writeOff;
    }




}


