package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RightsIssue generated by hbm2java
 */
public class RightsIssue  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private Long totalSharesOnIssue;
     private String methodOnOffer;
     private Double issuePrice;
     private Double issueSize;
     private Integer qualifyShareUnit;
     private Integer alottedUnitPerQualifyUnit;
     private Date qualifyDate;
     private Date openingDate;
     private Date closingDate;
     private Boolean rightsClosed;
     private Double tax;
     private Double interestRate;
     private Set rightsIssueApplications = new HashSet(0);
     private Set certificates = new HashSet(0);

    public RightsIssue() {
    }

    public RightsIssue(ClientCompany clientCompany, Long totalSharesOnIssue, String methodOnOffer, Double issuePrice, Double issueSize, Integer qualifyShareUnit, Integer alottedUnitPerQualifyUnit, Date qualifyDate, Date openingDate, Date closingDate, Boolean rightsClosed, Double tax, Double interestRate, Set rightsIssueApplications, Set certificates) {
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
       this.tax = tax;
       this.interestRate = interestRate;
       this.rightsIssueApplications = rightsIssueApplications;
       this.certificates = certificates;
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
    public ClientCompany getClientCompany() {
        return this.clientCompany;
    }
    
    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
    public Long getTotalSharesOnIssue() {
        return this.totalSharesOnIssue;
    }
    
    public void setTotalSharesOnIssue(Long totalSharesOnIssue) {
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
    public Double getIssueSize() {
        return this.issueSize;
    }
    
    public void setIssueSize(Double issueSize) {
        this.issueSize = issueSize;
    }
    public Integer getQualifyShareUnit() {
        return this.qualifyShareUnit;
    }
    
    public void setQualifyShareUnit(Integer qualifyShareUnit) {
        this.qualifyShareUnit = qualifyShareUnit;
    }
    public Integer getAlottedUnitPerQualifyUnit() {
        return this.alottedUnitPerQualifyUnit;
    }
    
    public void setAlottedUnitPerQualifyUnit(Integer alottedUnitPerQualifyUnit) {
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
    public Boolean getRightsClosed() {
        return this.rightsClosed;
    }
    
    public void setRightsClosed(Boolean rightsClosed) {
        this.rightsClosed = rightsClosed;
    }
    public Double getTax() {
        return this.tax;
    }
    
    public void setTax(Double tax) {
        this.tax = tax;
    }
    public Double getInterestRate() {
        return this.interestRate;
    }
    
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
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


