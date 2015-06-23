package org.greenpole.hibernate.entity;
// Generated 23-Jun-2015 04:56:55 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * InitialPublicOffer generated by hbm2java
 */
public class InitialPublicOffer  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private Long totalSharesOnOffer;
     private String methodOfOffer;
     private Integer startingMinSub;
     private Integer contMinSub;
     private Double offerPrice;
     private Double offerSize;
     private Date openingDate;
     private Date closingDate;
     private Boolean ipoClosed;
     private Double tax;
     private Double interestRate;
     private Set ipoApplications = new HashSet(0);
     private Set certificates = new HashSet(0);

    public InitialPublicOffer() {
    }

    public InitialPublicOffer(ClientCompany clientCompany, Long totalSharesOnOffer, String methodOfOffer, Integer startingMinSub, Integer contMinSub, Double offerPrice, Double offerSize, Date openingDate, Date closingDate, Boolean ipoClosed, Double tax, Double interestRate, Set ipoApplications, Set certificates) {
       this.clientCompany = clientCompany;
       this.totalSharesOnOffer = totalSharesOnOffer;
       this.methodOfOffer = methodOfOffer;
       this.startingMinSub = startingMinSub;
       this.contMinSub = contMinSub;
       this.offerPrice = offerPrice;
       this.offerSize = offerSize;
       this.openingDate = openingDate;
       this.closingDate = closingDate;
       this.ipoClosed = ipoClosed;
       this.tax = tax;
       this.interestRate = interestRate;
       this.ipoApplications = ipoApplications;
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
    public Long getTotalSharesOnOffer() {
        return this.totalSharesOnOffer;
    }
    
    public void setTotalSharesOnOffer(Long totalSharesOnOffer) {
        this.totalSharesOnOffer = totalSharesOnOffer;
    }
    public String getMethodOfOffer() {
        return this.methodOfOffer;
    }
    
    public void setMethodOfOffer(String methodOfOffer) {
        this.methodOfOffer = methodOfOffer;
    }
    public Integer getStartingMinSub() {
        return this.startingMinSub;
    }
    
    public void setStartingMinSub(Integer startingMinSub) {
        this.startingMinSub = startingMinSub;
    }
    public Integer getContMinSub() {
        return this.contMinSub;
    }
    
    public void setContMinSub(Integer contMinSub) {
        this.contMinSub = contMinSub;
    }
    public Double getOfferPrice() {
        return this.offerPrice;
    }
    
    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }
    public Double getOfferSize() {
        return this.offerSize;
    }
    
    public void setOfferSize(Double offerSize) {
        this.offerSize = offerSize;
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
    public Boolean getIpoClosed() {
        return this.ipoClosed;
    }
    
    public void setIpoClosed(Boolean ipoClosed) {
        this.ipoClosed = ipoClosed;
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
    public Set getIpoApplications() {
        return this.ipoApplications;
    }
    
    public void setIpoApplications(Set ipoApplications) {
        this.ipoApplications = ipoApplications;
    }
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }




}


