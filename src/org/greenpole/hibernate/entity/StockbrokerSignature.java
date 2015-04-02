package org.greenpole.hibernate.entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.backup_entity.*;
import org.greenpole.hibernate.entity.*;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



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
     * A getter for an object version, mostly assist in 
     * concurrency and easy retrieval of an object
     * @return  versionId, which is unique to a particular object, aside the 
	database primary key
    */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for the object version, mostly assist in 
     * concurrency. it keeps records of general modified persistence object
     * @param versionId, argument that takes automatic generated versionId by the hibernate
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


