package org.greenpole.hibernate.entity;
// Generated 25-Jun-2015 15:41:35 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PrivatePlacement generated by hbm2java
 */
public class PrivatePlacement  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private Long totalSharesOnOffer;
     private Integer methodOnOffer;
     private Integer startingMinSubscrptn;
     private Integer continuingMinSubscrptn;
     private Double offerPrice;
     private Double offerSize;
     private Date openingDate;
     private Date closingDate;
     private Boolean placementClosed;
     private Double tax;
     private Double interestRate;
     private Set certificates = new HashSet(0);
     private Set privatePlacementApplications = new HashSet(0);

    public PrivatePlacement() {
    }

    public PrivatePlacement(ClientCompany clientCompany, Long totalSharesOnOffer, Integer methodOnOffer, Integer startingMinSubscrptn, Integer continuingMinSubscrptn, Double offerPrice, Double offerSize, Date openingDate, Date closingDate, Boolean placementClosed, Double tax, Double interestRate, Set certificates, Set privatePlacementApplications) {
       this.clientCompany = clientCompany;
       this.totalSharesOnOffer = totalSharesOnOffer;
       this.methodOnOffer = methodOnOffer;
       this.startingMinSubscrptn = startingMinSubscrptn;
       this.continuingMinSubscrptn = continuingMinSubscrptn;
       this.offerPrice = offerPrice;
       this.offerSize = offerSize;
       this.openingDate = openingDate;
       this.closingDate = closingDate;
       this.placementClosed = placementClosed;
       this.tax = tax;
       this.interestRate = interestRate;
       this.certificates = certificates;
       this.privatePlacementApplications = privatePlacementApplications;
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
    public Integer getMethodOnOffer() {
        return this.methodOnOffer;
    }
    
    public void setMethodOnOffer(Integer methodOnOffer) {
        this.methodOnOffer = methodOnOffer;
    }
    public Integer getStartingMinSubscrptn() {
        return this.startingMinSubscrptn;
    }
    
    public void setStartingMinSubscrptn(Integer startingMinSubscrptn) {
        this.startingMinSubscrptn = startingMinSubscrptn;
    }
    public Integer getContinuingMinSubscrptn() {
        return this.continuingMinSubscrptn;
    }
    
    public void setContinuingMinSubscrptn(Integer continuingMinSubscrptn) {
        this.continuingMinSubscrptn = continuingMinSubscrptn;
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
    public Boolean getPlacementClosed() {
        return this.placementClosed;
    }
    
    public void setPlacementClosed(Boolean placementClosed) {
        this.placementClosed = placementClosed;
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
    public Set getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates) {
        this.certificates = certificates;
    }
    public Set getPrivatePlacementApplications() {
        return this.privatePlacementApplications;
    }
    
    public void setPrivatePlacementApplications(Set privatePlacementApplications) {
        this.privatePlacementApplications = privatePlacementApplications;
    }




}


