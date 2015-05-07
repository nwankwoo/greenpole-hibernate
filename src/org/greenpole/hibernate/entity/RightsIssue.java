package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RightsIssue generated by hbm2java
 */
public class RightsIssue  implements java.io.Serializable {


     private int id;
     private long versionId;
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
     private boolean rightsClosed;
     private Set rightsIssueApplications = new HashSet(0);
     private Set certificates = new HashSet(0);

    public RightsIssue() {
    }

    public RightsIssue(ClientCompany clientCompany, int totalSharesOnIssue, String methodOnOffer, Double issuePrice, int issueSize, int qualifyShareUnit, int alottedUnitPerQualifyUnit, Date qualifyDate, Date openingDate, Date closingDate, boolean rightsClosed, Set rightsIssueApplications, Set certificates) {
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
       this.rightsClosed = rightsClosed;
       this.rightsIssueApplications = rightsIssueApplications;
       this.certificates = certificates;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
       /**
     * A getter for RightsIssue object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for RightsIssue object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
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

    public boolean isRightsClosed() {
        return rightsClosed;
    }

    public void setRightsClosed(boolean rightsClosed) {
        this.rightsClosed = rightsClosed;
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


