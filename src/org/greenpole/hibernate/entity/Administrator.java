package org.greenpole.hibernate.entity;
// Generated 01-Jul-2015 10:37:17 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Administrator generated by hbm2java
 */
public class Administrator  implements java.io.Serializable {


     private int id;
     private Long version;
     private String firstName;
     private String middleName;
     private String lastName;
     private String pryAddress;
     private Set administratorPhoneNumbers = new HashSet(0);
     private Set administratorResidentialAddresses = new HashSet(0);
     private Set holders = new HashSet(0);
     private Set administratorEmailAddresses = new HashSet(0);
     private Set administratorPostalAddresses = new HashSet(0);

    public Administrator() {
    }

    public Administrator(String firstName, String middleName, String lastName, String pryAddress, Set administratorPhoneNumbers, Set administratorResidentialAddresses, Set holders, Set administratorEmailAddresses, Set administratorPostalAddresses) {
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.pryAddress = pryAddress;
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
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
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
    public String getPryAddress() {
        return this.pryAddress;
    }
    
    public void setPryAddress(String pryAddress) {
        this.pryAddress = pryAddress;
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


