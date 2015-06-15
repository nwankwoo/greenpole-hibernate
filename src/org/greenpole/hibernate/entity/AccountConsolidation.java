package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 14:01:49 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AccountConsolidation generated by hbm2java
 */
public class AccountConsolidation  implements java.io.Serializable {


     private int id;
     private Long version;
     private Holder holder;
     private String holderName;
     private Integer mergedToHolderId;
     private String mergedToHolderName;
     private Date mergeDate;
     private Boolean demerge;
     private String additionalChanges;
     private Date demergeDate;
     private Set companyAccountConsolidations = new HashSet(0);

    public AccountConsolidation() {
    }

    public AccountConsolidation(Holder holder, String holderName, Integer mergedToHolderId, String mergedToHolderName, Date mergeDate, Boolean demerge, String additionalChanges, Date demergeDate, Set companyAccountConsolidations) {
       this.holder = holder;
       this.holderName = holderName;
       this.mergedToHolderId = mergedToHolderId;
       this.mergedToHolderName = mergedToHolderName;
       this.mergeDate = mergeDate;
       this.demerge = demerge;
       this.additionalChanges = additionalChanges;
       this.demergeDate = demergeDate;
       this.companyAccountConsolidations = companyAccountConsolidations;
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
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public String getHolderName() {
        return this.holderName;
    }
    
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public Integer getMergedToHolderId() {
        return this.mergedToHolderId;
    }
    
    public void setMergedToHolderId(Integer mergedToHolderId) {
        this.mergedToHolderId = mergedToHolderId;
    }
    public String getMergedToHolderName() {
        return this.mergedToHolderName;
    }
    
    public void setMergedToHolderName(String mergedToHolderName) {
        this.mergedToHolderName = mergedToHolderName;
    }
    public Date getMergeDate() {
        return this.mergeDate;
    }
    
    public void setMergeDate(Date mergeDate) {
        this.mergeDate = mergeDate;
    }
    public Boolean getDemerge() {
        return this.demerge;
    }
    
    public void setDemerge(Boolean demerge) {
        this.demerge = demerge;
    }
    public String getAdditionalChanges() {
        return this.additionalChanges;
    }
    
    public void setAdditionalChanges(String additionalChanges) {
        this.additionalChanges = additionalChanges;
    }
    public Date getDemergeDate() {
        return this.demergeDate;
    }
    
    public void setDemergeDate(Date demergeDate) {
        this.demergeDate = demergeDate;
    }
    public Set getCompanyAccountConsolidations() {
        return this.companyAccountConsolidations;
    }
    
    public void setCompanyAccountConsolidations(Set companyAccountConsolidations) {
        this.companyAccountConsolidations = companyAccountConsolidations;
    }




}


