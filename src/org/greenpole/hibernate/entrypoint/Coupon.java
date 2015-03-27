package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Coupon generated by hbm2java
 */
public class Coupon  implements java.io.Serializable {


     private int id;
     private HolderCompanyAccount holderCompanyAccount;
     private String clientCompanyName;
     private Date issueDate;
     private int couponNumber;
     private String bondType;
     private Double redemptionAmt;
     private Double couponAmt;
     private String bondholderMailingAddress;
     private Date redemptnDate;
     private Double totalPymtsToBMade;
     private Double totalPaymtsMade;
     private boolean paid;
     private Date paidDate;

    public Coupon() {
    }

    public Coupon(HolderCompanyAccount holderCompanyAccount, String clientCompanyName, Date issueDate, int couponNumber, String bondType, Double redemptionAmt, Double couponAmt, String bondholderMailingAddress, Date redemptnDate, Double totalPymtsToBMade, Double totalPaymtsMade, boolean paid, Date paidDate) {
       this.holderCompanyAccount = holderCompanyAccount;
       this.clientCompanyName = clientCompanyName;
       this.issueDate = issueDate;
       this.couponNumber = couponNumber;
       this.bondType = bondType;
       this.redemptionAmt = redemptionAmt;
       this.couponAmt = couponAmt;
       this.bondholderMailingAddress = bondholderMailingAddress;
       this.redemptnDate = redemptnDate;
       this.totalPymtsToBMade = totalPymtsToBMade;
       this.totalPaymtsMade = totalPaymtsMade;
       this.paid = paid;
       this.paidDate = paidDate;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public HolderCompanyAccount getHolderCompanyAccount() {
        return this.holderCompanyAccount;
    }
    
    public void setHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount) {
        this.holderCompanyAccount = holderCompanyAccount;
    }
    public String getClientCompanyName() {
        return this.clientCompanyName;
    }
    
    public void setClientCompanyName(String clientCompanyName) {
        this.clientCompanyName = clientCompanyName;
    }
    public Date getIssueDate() {
        return this.issueDate;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public int getCouponNumber() {
        return this.couponNumber;
    }
    
    public void setCouponNumber(int couponNumber) {
        this.couponNumber = couponNumber;
    }
    public String getBondType() {
        return this.bondType;
    }
    
    public void setBondType(String bondType) {
        this.bondType = bondType;
    }
    public Double getRedemptionAmt() {
        return this.redemptionAmt;
    }
    
    public void setRedemptionAmt(Double redemptionAmt) {
        this.redemptionAmt = redemptionAmt;
    }
    public Double getCouponAmt() {
        return this.couponAmt;
    }
    
    public void setCouponAmt(Double couponAmt) {
        this.couponAmt = couponAmt;
    }
    public String getBondholderMailingAddress() {
        return this.bondholderMailingAddress;
    }
    
    public void setBondholderMailingAddress(String bondholderMailingAddress) {
        this.bondholderMailingAddress = bondholderMailingAddress;
    }
    public Date getRedemptnDate() {
        return this.redemptnDate;
    }
    
    public void setRedemptnDate(Date redemptnDate) {
        this.redemptnDate = redemptnDate;
    }
    public Double getTotalPymtsToBMade() {
        return this.totalPymtsToBMade;
    }
    
    public void setTotalPymtsToBMade(Double totalPymtsToBMade) {
        this.totalPymtsToBMade = totalPymtsToBMade;
    }
    public Double getTotalPaymtsMade() {
        return this.totalPaymtsMade;
    }
    
    public void setTotalPaymtsMade(Double totalPaymtsMade) {
        this.totalPaymtsMade = totalPaymtsMade;
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




}


