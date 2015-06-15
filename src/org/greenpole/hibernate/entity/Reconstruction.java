package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 12:07:06 by Hibernate Tools 4.3.1



/**
 * Reconstruction generated by hbm2java
 */
public class Reconstruction  implements java.io.Serializable {


     private int id;
     private Long version;
     private ClientCompany clientCompany;
     private ReconstructionType reconstructionType;
     private Integer qualifyShareUnit;
     private Integer actionShareUnit;
     private String increaseOrDecrease;

    public Reconstruction() {
    }

    public Reconstruction(ClientCompany clientCompany, ReconstructionType reconstructionType, Integer qualifyShareUnit, Integer actionShareUnit, String increaseOrDecrease) {
       this.clientCompany = clientCompany;
       this.reconstructionType = reconstructionType;
       this.qualifyShareUnit = qualifyShareUnit;
       this.actionShareUnit = actionShareUnit;
       this.increaseOrDecrease = increaseOrDecrease;
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
    public ReconstructionType getReconstructionType() {
        return this.reconstructionType;
    }
    
    public void setReconstructionType(ReconstructionType reconstructionType) {
        this.reconstructionType = reconstructionType;
    }
    public Integer getQualifyShareUnit() {
        return this.qualifyShareUnit;
    }
    
    public void setQualifyShareUnit(Integer qualifyShareUnit) {
        this.qualifyShareUnit = qualifyShareUnit;
    }
    public Integer getActionShareUnit() {
        return this.actionShareUnit;
    }
    
    public void setActionShareUnit(Integer actionShareUnit) {
        this.actionShareUnit = actionShareUnit;
    }
    public String getIncreaseOrDecrease() {
        return this.increaseOrDecrease;
    }
    
    public void setIncreaseOrDecrease(String increaseOrDecrease) {
        this.increaseOrDecrease = increaseOrDecrease;
    }




}


