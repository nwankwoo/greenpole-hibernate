package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ClearingHouse generated by hbm2java
 */
public class ClearingHouse  implements java.io.Serializable {


     private int id;
     private String name;
     private Double brokerage;
     private boolean appCleared;
     private Date submissionDate;
     private Set privatePlacementApplications = new HashSet(0);
     private Set ipoApplications = new HashSet(0);
     private Set rightsIssueApplications = new HashSet(0);

    public ClearingHouse() {
    }

    public ClearingHouse(String name, Double brokerage, boolean appCleared, Date submissionDate, Set privatePlacementApplications, Set ipoApplications, Set rightsIssueApplications) {
       this.name = name;
       this.brokerage = brokerage;
       this.appCleared = appCleared;
       this.submissionDate = submissionDate;
       this.privatePlacementApplications = privatePlacementApplications;
       this.ipoApplications = ipoApplications;
       this.rightsIssueApplications = rightsIssueApplications;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Double getBrokerage() {
        return this.brokerage;
    }
    
    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }
    public boolean isAppCleared() {
        return this.appCleared;
    }
    
    public void setAppCleared(boolean appCleared) {
        this.appCleared = appCleared;
    }
    public Date getSubmissionDate() {
        return this.submissionDate;
    }
    
    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }
    public Set getPrivatePlacementApplications() {
        return this.privatePlacementApplications;
    }
    
    public void setPrivatePlacementApplications(Set privatePlacementApplications) {
        this.privatePlacementApplications = privatePlacementApplications;
    }
    public Set getIpoApplications() {
        return this.ipoApplications;
    }
    
    public void setIpoApplications(Set ipoApplications) {
        this.ipoApplications = ipoApplications;
    }
    public Set getRightsIssueApplications() {
        return this.rightsIssueApplications;
    }
    
    public void setRightsIssueApplications(Set rightsIssueApplications) {
        this.rightsIssueApplications = rightsIssueApplications;
    }




}


