package org.greenpole.hibernate.backup_entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import org.greenpole.hibernate.entity.*;
import java.util.HashSet;
import java.util.Set;

/**
 * StockbrokerAgent generated by hbm2java
 */
public class StockbrokerAgent  implements java.io.Serializable {


     private int id;
     private long versionId;
     private Stockbroker stockbroker;
     private String firstName;
     private String middleName;
     private String lastName;
     private String position;
     private Set agentSignatures = new HashSet(0);

    public StockbrokerAgent() {
    }

    public StockbrokerAgent(Stockbroker stockbroker, String firstName, String middleName, String lastName, String position, Set agentSignatures) {
       this.stockbroker = stockbroker;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.position = position;
       this.agentSignatures = agentSignatures;
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
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    public Set getAgentSignatures() {
        return this.agentSignatures;
    }
    
    public void setAgentSignatures(Set agentSignatures) {
        this.agentSignatures = agentSignatures;
    }




}


