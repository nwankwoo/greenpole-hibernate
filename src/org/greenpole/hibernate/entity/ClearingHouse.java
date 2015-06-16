package org.greenpole.hibernate.entity;
// Generated 16-Jun-2015 12:22:21 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ClearingHouse generated by hbm2java
 */
public class ClearingHouse  implements java.io.Serializable {


     private int id;
     private Long version;
     private String name;
     private Double brokerage;
     private Boolean appCleared;
     private Date submissionDate;
     private Set privatePlacementApplications = new HashSet(0);
     private Set ipoApplications = new HashSet(0);
     private Set rightsIssueApplications = new HashSet(0);

    public ClearingHouse() {
    }

    public ClearingHouse(String name, Double brokerage, Boolean appCleared, Date submissionDate, Set privatePlacementApplications, Set ipoApplications, Set rightsIssueApplications) {
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
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
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
    public Boolean getAppCleared() {
        return this.appCleared;
    }
    
    public void setAppCleared(Boolean appCleared) {
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


