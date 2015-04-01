package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Administrator generated by hbm2java
 */
public class Administrator  implements java.io.Serializable {


     private int id;
     private long versionId;
     private String firstName;
     private String middleName;
     private String lastName;
     private Set administratorPhoneNumbers = new HashSet(0);
     private Set administratorResidentialAddresses = new HashSet(0);
     private Set holders = new HashSet(0);
     private Set administratorEmailAddresses = new HashSet(0);
     private Set administratorPostalAddresses = new HashSet(0);

    public Administrator() {
    }

    public Administrator(String firstName, String middleName, String lastName, Set administratorPhoneNumbers, Set administratorResidentialAddresses, Set holders, Set administratorEmailAddresses, Set administratorPostalAddresses) {
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.administratorPhoneNumbers = administratorPhoneNumbers;
       this.administratorResidentialAddresses = administratorResidentialAddresses;
       this.holders = holders;
       this.administratorEmailAddresses = administratorEmailAddresses;
       this.administratorPostalAddresses = administratorPostalAddresses;
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
    public Set getAdministratorPhoneNumbers() {
        return this.administratorPhoneNumbers;
    }
    
    public void setAdministratorPhoneNumbers(Set administratorPhoneNumbers) {
        this.administratorPhoneNumbers = administratorPhoneNumbers;
    }
    public Set getAdministratorResidentialAddresses() {
        return this.administratorResidentialAddresses;
    }
    
    public void setAdministratorResidentialAddresses(Set administratorResidentialAddresses) {
        this.administratorResidentialAddresses = administratorResidentialAddresses;
    }
    public Set getHolders() {
        return this.holders;
    }
    
    public void setHolders(Set holders) {
        this.holders = holders;
    }
    public Set getAdministratorEmailAddresses() {
        return this.administratorEmailAddresses;
    }
    
    public void setAdministratorEmailAddresses(Set administratorEmailAddresses) {
        this.administratorEmailAddresses = administratorEmailAddresses;
    }
    public Set getAdministratorPostalAddresses() {
        return this.administratorPostalAddresses;
    }
    
    public void setAdministratorPostalAddresses(Set administratorPostalAddresses) {
        this.administratorPostalAddresses = administratorPostalAddresses;
    }




}


