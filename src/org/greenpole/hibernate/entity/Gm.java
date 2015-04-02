package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Gm generated by hbm2java
 */
public class Gm  implements java.io.Serializable {


     private int id;
     private ClientCompany clientCompany;
     private String title;
     private String type;
     private String purpose;
     private String notes;
     private Date startDate;
     private Date endDate;
     private Set votingProcesses = new HashSet(0);
     private Set holderGmAttendances = new HashSet(0);

    public Gm() {
    }

    public Gm(ClientCompany clientCompany, String title, String type, String purpose, String notes, Date startDate, Date endDate, Set votingProcesses, Set holderGmAttendances) {
       this.clientCompany = clientCompany;
       this.title = title;
       this.type = type;
       this.purpose = purpose;
       this.notes = notes;
       this.startDate = startDate;
       this.endDate = endDate;
       this.votingProcesses = votingProcesses;
       this.holderGmAttendances = holderGmAttendances;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getPurpose() {
        return this.purpose;
    }
    
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Set getVotingProcesses() {
        return this.votingProcesses;
    }
    
    public void setVotingProcesses(Set votingProcesses) {
        this.votingProcesses = votingProcesses;
    }
    public Set getHolderGmAttendances() {
        return this.holderGmAttendances;
    }
    
    public void setHolderGmAttendances(Set holderGmAttendances) {
        this.holderGmAttendances = holderGmAttendances;
    }




}


