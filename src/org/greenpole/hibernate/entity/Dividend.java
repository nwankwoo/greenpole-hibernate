package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Dividend generated by hbm2java
 */
public class Dividend  implements java.io.Serializable {


     private int id;
     private long versionId;
     private ClientCompany clientCompany;
     private DividendDeclared dividendDeclared;
     private DividendIssueType dividendIssueType;
     private HolderCompanyAccount holderCompanyAccount;
     private int warrantNumber;
     private String clientCompName;
     private String issueType;
     private Date issueDate;
     private int divNumber;
     private String yearType;
     private Date yearEnding;
     private String SHolderMailingAddr;
     private Double rate;
     private int compAccHoldings;
     private Double withldingTaxRate;
     private Double grossAmount;
     private Double tax;
     private Double payableAmount;
     private Date payableDate;
     private boolean issued;
     private Date issuedDate;
     private boolean reIssued;
     private Date reIssuedDate;
     private boolean paid;
     private Date paidDate;
     private String paymentMethod;
     private boolean unclaimed;
     private Date unclaimedDate;
     private boolean cancelled;
     private Date canelledDate;
     private Set dividenAnnotations = new HashSet(0);

    public Dividend() {
    }

	
    public Dividend(int warrantNumber) {
        this.warrantNumber = warrantNumber;
    }
    public Dividend(ClientCompany clientCompany, DividendDeclared dividendDeclared, DividendIssueType dividendIssueType, HolderCompanyAccount holderCompanyAccount, int warrantNumber, String clientCompName, String issueType, Date issueDate, int divNumber, String yearType, Date yearEnding, String SHolderMailingAddr, Double rate, int compAccHoldings, Double withldingTaxRate, Double grossAmount, Double tax, Double payableAmount, Date payableDate, boolean issued, Date issuedDate, boolean reIssued, Date reIssuedDate, boolean paid, Date paidDate, String paymentMethod, boolean unclaimed, Date unclaimedDate, boolean cancelled, Date canelledDate, Set dividenAnnotations) {
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
    /**
     * A getter for Dividend object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for Dividend object which persist the 
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
    public int getWarrantNumber() {
        return this.warrantNumber;
    }
    
    public void setWarrantNumber(int warrantNumber) {
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
    public int getDivNumber() {
        return this.divNumber;
    }
    
    public void setDivNumber(int divNumber) {
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
    public int getCompAccHoldings() {
        return this.compAccHoldings;
    }
    
    public void setCompAccHoldings(int compAccHoldings) {
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
    public boolean isIssued() {
        return this.issued;
    }
    
    public void setIssued(boolean issued) {
        this.issued = issued;
    }
    public Date getIssuedDate() {
        return this.issuedDate;
    }
    
    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
    public boolean isReIssued() {
        return this.reIssued;
    }
    
    public void setReIssued(boolean reIssued) {
        this.reIssued = reIssued;
    }
    public Date getReIssuedDate() {
        return this.reIssuedDate;
    }
    
    public void setReIssuedDate(Date reIssuedDate) {
        this.reIssuedDate = reIssuedDate;
    }
    public boolean isPaid() {
        return this.paid;
    }
    
    public void setPaid(boolean paid) {
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
    public boolean isUnclaimed() {
        return this.unclaimed;
    }
    
    public void setUnclaimed(boolean unclaimed) {
        this.unclaimed = unclaimed;
    }
    public Date getUnclaimedDate() {
        return this.unclaimedDate;
    }
    
    public void setUnclaimedDate(Date unclaimedDate) {
        this.unclaimedDate = unclaimedDate;
    }
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(boolean cancelled) {
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


