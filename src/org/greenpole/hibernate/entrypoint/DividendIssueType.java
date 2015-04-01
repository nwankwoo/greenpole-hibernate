package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * DividendIssueType generated by hbm2java
 */
public class DividendIssueType  implements java.io.Serializable {


     private int id;
     private long versionId;
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
    /**
     * A getter for DividendIssueType object which retrieve 
     * a version identifier, apart from the primary key of object
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }
    /**
     * A setter for DividendIssueType object which persist the 
     * versionId identifier in the memory by hibernate
     * @param versionId, an argument that receives the generated 
     * version of current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
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


