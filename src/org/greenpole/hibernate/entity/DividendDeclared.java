package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:17:29 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DividendDeclared generated by hbm2java
 */
public class DividendDeclared  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private String yearType;
     private String issueType;
     private Date qualifyDate;
     private Double withholdingTaxRateInd;
     private Double withholdingTaxRateCorp;
     private Integer yearEnding;
     private Date datePayable;
     private Double rate;
     private Set dividends = new HashSet(0);
     private Set dividendSettlements = new HashSet(0);

    public DividendDeclared() {
    }

    public DividendDeclared(ClientCompany clientCompany, String yearType, String issueType, Date qualifyDate, Double withholdingTaxRateInd, Double withholdingTaxRateCorp, Integer yearEnding, Date datePayable, Double rate, Set dividends, Set dividendSettlements) {
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
    public String getYearType() {
        return this.yearType;
    }
    
    public void setYearType(String yearType) {
        this.yearType = yearType;
    }
    public String getIssueType() {
        return this.issueType;
    }
    
    public void setIssueType(String issueType) {
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
    public Integer getYearEnding() {
        return this.yearEnding;
    }
    
    public void setYearEnding(Integer yearEnding) {
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


