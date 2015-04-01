package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DividendDeclared generated by hbm2java
 */
public class DividendDeclared  implements java.io.Serializable {


     private int id;
     private long versionId;
     private ClientCompany clientCompany;
     private String yearType;
     private byte[] issueType;
     private Date qualifyDate;
     private Double withholdingTaxRateInd;
     private Double withholdingTaxRateCorp;
     private int yearEnding;
     private Date datePayable;
     private Double rate;
     private Set dividends = new HashSet(0);
     private Set dividendSettlements = new HashSet(0);

    public DividendDeclared() {
    }

    public DividendDeclared(ClientCompany clientCompany, String yearType, byte[] issueType, Date qualifyDate, Double withholdingTaxRateInd, Double withholdingTaxRateCorp, int yearEnding, Date datePayable, Double rate, Set dividends, Set dividendSettlements) {
       this.clientCompany = clientCompany;
       this.yearType = yearType;
       this.issueType = issueType;
       this.qualifyDate = qualifyDate;
       this.withholdingTaxRateInd = withholdingTaxRateInd;
       this.withholdingTaxRateCorp = withholdingTaxRateCorp;
       this.yearEnding = yearEnding;
       this.datePayable = datePayable;
       this.rate = rate;
       this.dividends = dividends;
       this.dividendSettlements = dividendSettlements;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * A getter for DividendDeclared object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for DividendDeclared object which persist the 
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
    public String getYearType() {
        return this.yearType;
    }
    
    public void setYearType(String yearType) {
        this.yearType = yearType;
    }
    public byte[] getIssueType() {
        return this.issueType;
    }
    
    public void setIssueType(byte[] issueType) {
        this.issueType = issueType;
    }
    public Date getQualifyDate() {
        return this.qualifyDate;
    }
    
    public void setQualifyDate(Date qualifyDate) {
        this.qualifyDate = qualifyDate;
    }
    public Double getWithholdingTaxRateInd() {
        return this.withholdingTaxRateInd;
    }
    
    public void setWithholdingTaxRateInd(Double withholdingTaxRateInd) {
        this.withholdingTaxRateInd = withholdingTaxRateInd;
    }
    public Double getWithholdingTaxRateCorp() {
        return this.withholdingTaxRateCorp;
    }
    
    public void setWithholdingTaxRateCorp(Double withholdingTaxRateCorp) {
        this.withholdingTaxRateCorp = withholdingTaxRateCorp;
    }
    public int getYearEnding() {
        return this.yearEnding;
    }
    
    public void setYearEnding(int yearEnding) {
        this.yearEnding = yearEnding;
    }
    public Date getDatePayable() {
        return this.datePayable;
    }
    
    public void setDatePayable(Date datePayable) {
        this.datePayable = datePayable;
    }
    public Double getRate() {
        return this.rate;
    }
    
    public void setRate(Double rate) {
        this.rate = rate;
    }
    public Set getDividends() {
        return this.dividends;
    }
    
    public void setDividends(Set dividends) {
        this.dividends = dividends;
    }
    public Set getDividendSettlements() {
        return this.dividendSettlements;
    }
    
    public void setDividendSettlements(Set dividendSettlements) {
        this.dividendSettlements = dividendSettlements;
    }




}


