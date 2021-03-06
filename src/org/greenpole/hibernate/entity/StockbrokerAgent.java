package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * StockbrokerAgent generated by hbm2java
 */
public class StockbrokerAgent  implements java.io.Serializable {


     private int id;
     private Long version;
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
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
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


