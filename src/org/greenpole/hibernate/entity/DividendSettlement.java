package org.greenpole.hibernate.entity;
// Generated 23-Jun-2015 04:56:55 by Hibernate Tools 4.3.1



/**
 * DividendSettlement generated by hbm2java
 */
public class DividendSettlement  implements java.io.Serializable {


     private int id;
     private Long version;
     private DividendDeclared dividendDeclared;
     private Double totalDivAmtDec;
     private Double totalDivAmtPaid;
     private Double totalDivAmtUnpaid;
     private Double totalDivAmtLeft;
     private Integer shareholdersPaid;
     private Integer shareholdersUnpaid;

    public DividendSettlement() {
    }

    public DividendSettlement(DividendDeclared dividendDeclared, Double totalDivAmtDec, Double totalDivAmtPaid, Double totalDivAmtUnpaid, Double totalDivAmtLeft, Integer shareholdersPaid, Integer shareholdersUnpaid) {
       this.dividendDeclared = dividendDeclared;
       this.totalDivAmtDec = totalDivAmtDec;
       this.totalDivAmtPaid = totalDivAmtPaid;
       this.totalDivAmtUnpaid = totalDivAmtUnpaid;
       this.totalDivAmtLeft = totalDivAmtLeft;
       this.shareholdersPaid = shareholdersPaid;
       this.shareholdersUnpaid = shareholdersUnpaid;
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
    public DividendDeclared getDividendDeclared() {
        return this.dividendDeclared;
    }
    
    public void setDividendDeclared(DividendDeclared dividendDeclared) {
        this.dividendDeclared = dividendDeclared;
    }
    public Double getTotalDivAmtDec() {
        return this.totalDivAmtDec;
    }
    
    public void setTotalDivAmtDec(Double totalDivAmtDec) {
        this.totalDivAmtDec = totalDivAmtDec;
    }
    public Double getTotalDivAmtPaid() {
        return this.totalDivAmtPaid;
    }
    
    public void setTotalDivAmtPaid(Double totalDivAmtPaid) {
        this.totalDivAmtPaid = totalDivAmtPaid;
    }
    public Double getTotalDivAmtUnpaid() {
        return this.totalDivAmtUnpaid;
    }
    
    public void setTotalDivAmtUnpaid(Double totalDivAmtUnpaid) {
        this.totalDivAmtUnpaid = totalDivAmtUnpaid;
    }
    public Double getTotalDivAmtLeft() {
        return this.totalDivAmtLeft;
    }
    
    public void setTotalDivAmtLeft(Double totalDivAmtLeft) {
        this.totalDivAmtLeft = totalDivAmtLeft;
    }
    public Integer getShareholdersPaid() {
        return this.shareholdersPaid;
    }
    
    public void setShareholdersPaid(Integer shareholdersPaid) {
        this.shareholdersPaid = shareholdersPaid;
    }
    public Integer getShareholdersUnpaid() {
        return this.shareholdersUnpaid;
    }
    
    public void setShareholdersUnpaid(Integer shareholdersUnpaid) {
        this.shareholdersUnpaid = shareholdersUnpaid;
    }




}


