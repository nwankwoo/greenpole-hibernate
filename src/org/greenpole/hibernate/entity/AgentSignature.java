package org.greenpole.hibernate.entity;
// Generated 16-Jun-2015 12:22:21 by Hibernate Tools 4.3.1



/**
 * AgentSignature generated by hbm2java
 */
public class AgentSignature  implements java.io.Serializable {


     private int id;
     private Long version;
     private StockbrokerAgent stockbrokerAgent;
     private String title;
     private String signaturePath;
     private Boolean agentSignaturePrimary;

    public AgentSignature() {
    }

    public AgentSignature(StockbrokerAgent stockbrokerAgent, String title, String signaturePath, Boolean agentSignaturePrimary) {
       this.stockbrokerAgent = stockbrokerAgent;
       this.title = title;
       this.signaturePath = signaturePath;
       this.agentSignaturePrimary = agentSignaturePrimary;
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
    public StockbrokerAgent getStockbrokerAgent() {
        return this.stockbrokerAgent;
    }
    
    public void setStockbrokerAgent(StockbrokerAgent stockbrokerAgent) {
        this.stockbrokerAgent = stockbrokerAgent;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSignaturePath() {
        return this.signaturePath;
    }
    
    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath;
    }
    public Boolean getAgentSignaturePrimary() {
        return this.agentSignaturePrimary;
    }
    
    public void setAgentSignaturePrimary(Boolean agentSignaturePrimary) {
        this.agentSignaturePrimary = agentSignaturePrimary;
    }




}


