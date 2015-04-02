package org.greenpole.hibernate.backup_entity;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1

import org.greenpole.hibernate.entity.*;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * HolderVoting generated by hbm2java
 */
public class HolderVoting  implements java.io.Serializable {


     private HolderVotingId id;
     private Holder holder;
     private VotingProcess votingProcess;
     private String voteFor;
     private String voteAgainst;

    public HolderVoting() {
    }

	
    public HolderVoting(HolderVotingId id, Holder holder, VotingProcess votingProcess) {
        this.id = id;
        this.holder = holder;
        this.votingProcess = votingProcess;
    }
    public HolderVoting(HolderVotingId id, Holder holder, VotingProcess votingProcess, String voteFor, String voteAgainst) {
       this.id = id;
       this.holder = holder;
       this.votingProcess = votingProcess;
       this.voteFor = voteFor;
       this.voteAgainst = voteAgainst;
    }
   
    public HolderVotingId getId() {
        return this.id;
    }
    
    public void setId(HolderVotingId id) {
        this.id = id;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public VotingProcess getVotingProcess() {
        return this.votingProcess;
    }
    
    public void setVotingProcess(VotingProcess votingProcess) {
        this.votingProcess = votingProcess;
    }
    public String getVoteFor() {
        return this.voteFor;
    }
    
    public void setVoteFor(String voteFor) {
        this.voteFor = voteFor;
    }
    public String getVoteAgainst() {
        return this.voteAgainst;
    }
    
    public void setVoteAgainst(String voteAgainst) {
        this.voteAgainst = voteAgainst;
    }




}


