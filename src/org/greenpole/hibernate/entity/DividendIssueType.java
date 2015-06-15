package org.greenpole.hibernate.entity;
// Generated 15-Jun-2015 14:01:49 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * DividendIssueType generated by hbm2java
 */
public class DividendIssueType  implements java.io.Serializable {


     private int id;
     private Long version;
     private String dividendType;
     private String description;
     private Set dividends = new HashSet(0);

    public DividendIssueType() {
    }

    public DividendIssueType(String dividendType, String description, Set dividends) {
       this.dividendType = dividendType;
       this.description = description;
       this.dividends = dividends;
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
    public String getDividendType() {
        return this.dividendType;
    }
    
    public void setDividendType(String dividendType) {
        this.dividendType = dividendType;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getDividends() {
        return this.dividends;
    }
    
    public void setDividends(Set dividends) {
        this.dividends = dividends;
    }




}


