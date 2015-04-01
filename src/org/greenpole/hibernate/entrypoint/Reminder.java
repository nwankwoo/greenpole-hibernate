package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * Reminder generated by hbm2java
 */
public class Reminder  implements java.io.Serializable {


     private int id;
     private long versionId;
     private String title;
     private String mailBody;
     private String component;
     private String reminderFunction;
     private String type;

    public Reminder() {
    }

    public Reminder(String title, String mailBody, String component, String reminderFunction, String type) {
       this.title = title;
       this.mailBody = mailBody;
       this.component = component;
       this.reminderFunction = reminderFunction;
       this.type = type;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for Reminder object version, mostly assist in 
     * concurrency and easy retrieval of an object
     * @return  versionId, which is unique to a particular object, aside the 
	database primary key
    */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for Reminder object version, mostly assist in 
     * concurrency. it keeps records of general modified persistence object
     * @param versionId, argument that takes automatic generated versionId by the hibernate
    */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMailBody() {
        return this.mailBody;
    }
    
    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }
    public String getComponent() {
        return this.component;
    }
    
    public void setComponent(String component) {
        this.component = component;
    }
    public String getReminderFunction() {
        return this.reminderFunction;
    }
    
    public void setReminderFunction(String reminderFunction) {
        this.reminderFunction = reminderFunction;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }




}


