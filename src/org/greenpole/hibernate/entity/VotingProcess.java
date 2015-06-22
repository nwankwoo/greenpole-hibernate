package org.greenpole.hibernate.entity;
// Generated 22-Jun-2015 15:17:29 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VotingProcess generated by hbm2java
 */
public class VotingProcess  implements java.io.Serializable {


     private int id;
     private Long version;
     private Gm gm;
     private String title;
     private String notes;
     private Set holderVotings = new HashSet(0);

    public VotingProcess() {
    }

    public VotingProcess(Gm gm, String title, String notes, Set holderVotings) {
       this.gm = gm;
       this.title = title;
       this.notes = notes;
       this.holderVotings = holderVotings;
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
    public Gm getGm() {
        return this.gm;
    }
    
    public void setGm(Gm gm) {
        this.gm = gm;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Set getHolderVotings() {
        return this.holderVotings;
    }
    
    public void setHolderVotings(Set holderVotings) {
        this.holderVotings = holderVotings;
    }




}


