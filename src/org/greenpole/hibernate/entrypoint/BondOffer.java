package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * BondOffer generated by hbm2java
 */
public class BondOffer  implements java.io.Serializable {


     private int id;
     private ClientCompany clientCompany;
     private String title;
     private Double bondUnitPrice;
     private Date bondMaturity;
     private String bondType;
     private Double taxRate;
     private String paymentPlan;

    public BondOffer() {
    }

    public BondOffer(ClientCompany clientCompany, String title, Double bondUnitPrice, Date bondMaturity, String bondType, Double taxRate, String paymentPlan) {
       this.clientCompany = clientCompany;
       this.title = title;
       this.bondUnitPrice = bondUnitPrice;
       this.bondMaturity = bondMaturity;
       this.bondType = bondType;
       this.taxRate = taxRate;
       this.paymentPlan = paymentPlan;
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
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public Double getBondUnitPrice() {
        return this.bondUnitPrice;
    }
    
    public void setBondUnitPrice(Double bondUnitPrice) {
        this.bondUnitPrice = bondUnitPrice;
    }
    public Date getBondMaturity() {
        return this.bondMaturity;
    }
    
    public void setBondMaturity(Date bondMaturity) {
        this.bondMaturity = bondMaturity;
    }
    public String getBondType() {
        return this.bondType;
    }
    
    public void setBondType(String bondType) {
        this.bondType = bondType;
    }
    public Double getTaxRate() {
        return this.taxRate;
    }
    
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
    public String getPaymentPlan() {
        return this.paymentPlan;
    }
    
    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }




}


