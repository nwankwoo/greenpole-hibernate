package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1



/**
 * StockbrokerSignature generated by hbm2java
 */
public class StockbrokerSignature  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Stockbroker stockbroker;
     private String signaturePath;
     private boolean stockbrokerSignPrimary;

    public StockbrokerSignature() {
    }

    public StockbrokerSignature(Stockbroker stockbroker, String signaturePath, boolean stockbrokerSignPrimary) {
       this.stockbroker = stockbroker;
       this.signaturePath = signaturePath;
       this.stockbrokerSignPrimary = stockbrokerSignPrimary;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
       /**
     * A getter for StockbrokerSignature object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for StockbrokerSignature object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }
    public Stockbroker getStockbroker() {
        return this.stockbroker;
    }
    
    public void setStockbroker(Stockbroker stockbroker) {
        this.stockbroker = stockbroker;
    }
    public String getSignaturePath() {
        return this.signaturePath;
    }
    
    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath;
    }
    public boolean isStockbrokerSignPrimary() {
        return this.stockbrokerSignPrimary;
    }
    
    public void setStockbrokerSignPrimary(boolean stockbrokerSignPrimary) {
        this.stockbrokerSignPrimary = stockbrokerSignPrimary;
    }




}


