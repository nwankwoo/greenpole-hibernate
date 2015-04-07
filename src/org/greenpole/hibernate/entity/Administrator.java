package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Administrator generated by hbm2java
 */
public class Administrator  implements java.io.Serializable {


     private int id;
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


