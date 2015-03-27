package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * IpoApplication generated by hbm2java
 */
public class IpoApplication  implements java.io.Serializable {


     private int id;
     private ClearingHouse clearingHouse;
     private Holder holder;
     private InitialPublicOffer initialPublicOffer;
     private String issuer;
     private int sharesSubscribed;
     private Double amountPaid;
     private String issuingHouse;
     private Double sharesSubscribedValue;
     private Double returnMoney;
     private boolean cancelled;

    public IpoApplication() {
    }

    public IpoApplication(ClearingHouse clearingHouse, Holder holder, InitialPublicOffer initialPublicOffer, String issuer, int sharesSubscribed, Double amountPaid, String issuingHouse, Double sharesSubscribedValue, Double returnMoney, boolean cancelled) {
       this.clearingHouse = clearingHouse;
       this.holder = holder;
       this.initialPublicOffer = initialPublicOffer;
       this.issuer = issuer;
       this.sharesSubscribed = sharesSubscribed;
       this.amountPaid = amountPaid;
       this.issuingHouse = issuingHouse;
       this.sharesSubscribedValue = sharesSubscribedValue;
       this.returnMoney = returnMoney;
       this.cancelled = cancelled;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public ClearingHouse getClearingHouse() {
        return this.clearingHouse;
    }
    
    public void setClearingHouse(ClearingHouse clearingHouse) {
        this.clearingHouse = clearingHouse;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public InitialPublicOffer getInitialPublicOffer() {
        return this.initialPublicOffer;
    }
    
    public void setInitialPublicOffer(InitialPublicOffer initialPublicOffer) {
        this.initialPublicOffer = initialPublicOffer;
    }
    public String getIssuer() {
        return this.issuer;
    }
    
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    public int getSharesSubscribed() {
        return this.sharesSubscribed;
    }
    
    public void setSharesSubscribed(int sharesSubscribed) {
        this.sharesSubscribed = sharesSubscribed;
    }
    public Double getAmountPaid() {
        return this.amountPaid;
    }
    
    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public String getIssuingHouse() {
        return this.issuingHouse;
    }
    
    public void setIssuingHouse(String issuingHouse) {
        this.issuingHouse = issuingHouse;
    }
    public Double getSharesSubscribedValue() {
        return this.sharesSubscribedValue;
    }
    
    public void setSharesSubscribedValue(Double sharesSubscribedValue) {
        this.sharesSubscribedValue = sharesSubscribedValue;
    }
    public Double getReturnMoney() {
        return this.returnMoney;
    }
    
    public void setReturnMoney(Double returnMoney) {
        this.returnMoney = returnMoney;
    }
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }




}


