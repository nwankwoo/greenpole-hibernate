package org.greenpole.hibernate.entity;
// Generated 29-May-2015 21:21:44 by Hibernate Tools 4.3.1



/**
 * ShareQuotation generated by hbm2java
 */
public class ShareQuotation  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private Double unitPrice;

    public ShareQuotation() {
    }

    public ShareQuotation(ClientCompany clientCompany, Double unitPrice) {
       this.clientCompany = clientCompany;
       this.unitPrice = unitPrice;
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
    public Double getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }




}


