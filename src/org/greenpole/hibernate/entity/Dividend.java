package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:26:20 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Dividend generated by hbm2java
 */
public class Dividend  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private DividendDeclared dividendDeclared;
     private DividendIssueType dividendIssueType;
     private HolderCompanyAccount holderCompanyAccount;
     private Long warrantNumber;
     private String clientCompName;
     private String issueType;
     private Date issueDate;
     private Integer divNumber;
     private String yearType;
     private Date yearEnding;
     private String SHolderMailingAddr;
     private Double rate;
     private Integer compAccHoldings;
     private Double withldingTaxRate;
     private Double grossAmount;
     private Double tax;
     private Double payableAmount;
     private Date payableDate;
     private Boolean issued;
     private Date issuedDate;
     private Boolean reIssued;
     private Date reIssuedDate;
     private Boolean paid;
     private Date paidDate;
     private String paymentMethod;
     private Boolean unclaimed;
     private Date unclaimedDate;
     private Boolean cancelled;
     private Date canelledDate;
     private Set dividenAnnotations = new HashSet(0);

    public Dividend() {
    }

    public Dividend(ClientCompany clientCompany, DividendDeclared dividendDeclared, DividendIssueType dividendIssueType, HolderCompanyAccount holderCompanyAccount, Long warrantNumber, String clientCompName, String issueType, Date issueDate, Integer divNumber, String yearType, Date yearEnding, String SHolderMailingAddr, Double rate, Integer compAccHoldings, Double withldingTaxRate, Double grossAmount, Double tax, Double payableAmount, Date payableDate, Boolean issued, Date issuedDate, Boolean reIssued, Date reIssuedDate, Boolean paid, Date paidDate, String paymentMethod, Boolean unclaimed, Date unclaimedDate, Boolean cancelled, Date canelledDate, Set dividenAnnotations) {
       this.clientCompany = clientCompany;
       this.dividendDeclared = dividendDeclared;
       this.dividendIssueType = dividendIssueType;
       this.holderCompanyAccount = holderCompanyAccount;
       this.warrantNumber = warrantNumber;
       this.clientCompName = clientCompName;
       this.issueType = issueType;
       this.issueDate = issueDate;
       this.divNumber = divNumber;
       this.yearType = yearType;
       this.yearEnding = yearEnding;
       this.SHolderMailingAddr = SHolderMailingAddr;
       this.rate = rate;
       this.compAccHoldings = compAccHoldings;
       this.withldingTaxRate = withldingTaxRate;
       this.grossAmount = grossAmount;
       this.tax = tax;
       this.payableAmount = payableAmount;
       this.payableDate = payableDate;
       this.issued = issued;
       this.issuedDate = issuedDate;
       this.reIssued = reIssued;
       this.reIssuedDate = reIssuedDate;
       this.paid = paid;
       this.paidDate = paidDate;
       this.paymentMethod = paymentMethod;
       this.unclaimed = unclaimed;
       this.unclaimedDate = unclaimedDate;
       this.cancelled = cancelled;
       this.canelledDate = canelledDate;
       this.dividenAnnotations = dividenAnnotations;
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
    public DividendDeclared getDividendDeclared() {
        return this.dividendDeclared;
    }
    
    public void setDividendDeclared(DividendDeclared dividendDeclared) {
        this.dividendDeclared = dividendDeclared;
    }
    public DividendIssueType getDividendIssueType() {
        return this.dividendIssueType;
    }
    
    public void setDividendIssueType(DividendIssueType dividendIssueType) {
        this.dividendIssueType = dividendIssueType;
    }
    public HolderCompanyAccount getHolderCompanyAccount() {
        return this.holderCompanyAccount;
    }
    
    public void setHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount) {
        this.holderCompanyAccount = holderCompanyAccount;
    }
    public Long getWarrantNumber() {
        return this.warrantNumber;
    }
    
    public void setWarrantNumber(Long warrantNumber) {
        this.warrantNumber = warrantNumber;
    }
    public String getClientCompName() {
        return this.clientCompName;
    }
    
    public void setClientCompName(String clientCompName) {
        this.clientCompName = clientCompName;
    }
    public String getIssueType() {
        return this.issueType;
    }
    
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }
    public Date getIssueDate() {
        return this.issueDate;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public Integer getDivNumber() {
        return this.divNumber;
    }
    
    public void setDivNumber(Integer divNumber) {
        this.divNumber = divNumber;
    }
    public String getYearType() {
        return this.yearType;
    }
    
    public void setYearType(String yearType) {
        this.yearType = yearType;
    }
    public Date getYearEnding() {
        return this.yearEnding;
    }
    
    public void setYearEnding(Date yearEnding) {
        this.yearEnding = yearEnding;
    }
    public String getSHolderMailingAddr() {
        return this.SHolderMailingAddr;
    }
    
    public void setSHolderMailingAddr(String SHolderMailingAddr) {
        this.SHolderMailingAddr = SHolderMailingAddr;
    }
    public Double getRate() {
        return this.rate;
    }
    
    public void setRate(Double rate) {
        this.rate = rate;
    }
    public Integer getCompAccHoldings() {
        return this.compAccHoldings;
    }
    
    public void setCompAccHoldings(Integer compAccHoldings) {
        this.compAccHoldings = compAccHoldings;
    }
    public Double getWithldingTaxRate() {
        return this.withldingTaxRate;
    }
    
    public void setWithldingTaxRate(Double withldingTaxRate) {
        this.withldingTaxRate = withldingTaxRate;
    }
    public Double getGrossAmount() {
        return this.grossAmount;
    }
    
    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }
    public Double getTax() {
        return this.tax;
    }
    
    public void setTax(Double tax) {
        this.tax = tax;
    }
    public Double getPayableAmount() {
        return this.payableAmount;
    }
    
    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }
    public Date getPayableDate() {
        return this.payableDate;
    }
    
    public void setPayableDate(Date payableDate) {
        this.payableDate = payableDate;
    }
    public Boolean getIssued() {
        return this.issued;
    }
    
    public void setIssued(Boolean issued) {
        this.issued = issued;
    }
    public Date getIssuedDate() {
        return this.issuedDate;
    }
    
    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
    public Boolean getReIssued() {
        return this.reIssued;
    }
    
    public void setReIssued(Boolean reIssued) {
        this.reIssued = reIssued;
    }
    public Date getReIssuedDate() {
        return this.reIssuedDate;
    }
    
    public void setReIssuedDate(Date reIssuedDate) {
        this.reIssuedDate = reIssuedDate;
    }
    public Boolean getPaid() {
        return this.paid;
    }
    
    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
    public Date getPaidDate() {
        return this.paidDate;
    }
    
    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Boolean getUnclaimed() {
        return this.unclaimed;
    }
    
    public void setUnclaimed(Boolean unclaimed) {
        this.unclaimed = unclaimed;
    }
    public Date getUnclaimedDate() {
        return this.unclaimedDate;
    }
    
    public void setUnclaimedDate(Date unclaimedDate) {
        this.unclaimedDate = unclaimedDate;
    }
    public Boolean getCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
    public Date getCanelledDate() {
        return this.canelledDate;
    }
    
    public void setCanelledDate(Date canelledDate) {
        this.canelledDate = canelledDate;
    }
    public Set getDividenAnnotations() {
        return this.dividenAnnotations;
    }
    
    public void setDividenAnnotations(Set dividenAnnotations) {
        this.dividenAnnotations = dividenAnnotations;
    }




}


