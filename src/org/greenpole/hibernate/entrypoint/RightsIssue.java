package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RightsIssue generated by hbm2java
 */
public class RightsIssue  implements java.io.Serializable {


     private int id;
     private ClientCompany clientCompany;
     private int totalSharesOnIssue;
     private String methodOnOffer;
     private Double issuePrice;
     private int issueSize;
     private int qualifyShareUnit;
     private int alottedUnitPerQualifyUnit;
     private Date qualifyDate;
     private Date openingDate;
     private Date closingDate;
     private Set rightsIssueApplications = new HashSet(0);
     private Set certificates = new HashSet(0);

    public RightsIssue() {
    }

    public RightsIssue(ClientCompany clientCompany, int totalSharesOnIssue, String methodOnOffer, Double issuePrice, int issueSize, int qualifyShareUnit, int alottedUnitPerQualifyUnit, Date qualifyDate, Date openingDate, Date closingDate, Set rightsIssueApplications, Set certificates) {
       this.clientCompany = clientCompany;
       this.totalSharesOnIssue = totalSharesOnIssue;
       this.methodOnOffer = methodOnOffer;
       this.issuePrice = issuePrice;
       this.issueSize = issueSize;
       this.qualifyShareUnit = qualifyShareUnit;
       this.alottedUnitPerQualifyUnit = alottedUnitPerQualifyUnit;
       this.qualifyDate = qualifyDate;
       this.openingDate = openingDate;
       this.closingDate = closingDate;
       this.rightsIssueApplications = rightsIssueApplications;
       this.certificates = certificates;
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
    public int getTotalSharesOnIssue() {
        return this.totalSharesOnIssue;
    }
    
    public void setTotalSharesOnIssue(int totalSharesOnIssue) {
        this.totalSharesOnIssue = totalSharesOnIssue;
    }
    public String getMethodOnOffer() {
        return this.methodOnOffer;
    }
    
    public void setMethodOnOffer(String methodOnOffer) {
        this.methodOnOffer = methodOnOffer;
    }
    public Double getIssuePrice() {
        return this.issuePrice;
    }
    
    public void setIssuePrice(Double issuePrice) {
        this.issuePrice = issuePrice;
    }
    public int getIssueSize() {
        return this.issueSize;
    }
    
    public void setIssueSize(int issueSize) {
        this.issueSize = issueSize;
    }
    public int getQualifyShareUnit() {
        return this.qualifyShareUnit;
    }
    
    public void setQualifyShareUnit(int qualifyShareUnit) {
        this.qualifyShareUnit = qualifyShareUnit;
    }
    public int getAlottedUnitPerQualifyUnit() {
        return this.alottedUnitPerQualifyUnit;
    }
    
    public void setAlottedUnitPerQualifyUnit(int alottedUnitPerQualifyUnit) {
        this.alottedUnitPerQualifyUnit = alottedUnitPerQualifyUnit;
    }
    public Date getQualifyDate() {
        return this.qualifyDate;
    }
    
    public void setQualifyDate(Date qualifyDate) {
        this.qualifyDate = qualifyDate;
    }
    public Date getOpeningDate() {
        return this.openingDate;
    }
    
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }
    public Date getClosingDate() {
        return this.closingDate;
    }
    
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }
    public Set getRightsIssueApplications() {
        return this.rightsIssueApplications;
    }
    
    public void setRightsIssueApplications(Set rightsIssueApplications) {
        this.rightsIssueApplications = rightsIssueApplications;
    }
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }




}


