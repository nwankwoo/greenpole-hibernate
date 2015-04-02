package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * ShareQuotation generated by hbm2java
 */
public class ShareQuotation  implements java.io.Serializable {


     private int id;
     private ClientCompany clientCompany;
     private String code;
     private Double unitPrice;

    public ShareQuotation() {
    }

    public ShareQuotation(ClientCompany clientCompany, String code, Double unitPrice) {
       this.clientCompany = clientCompany;
       this.code = code;
       this.unitPrice = unitPrice;
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
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public Double getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }




}


