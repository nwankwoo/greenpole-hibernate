package org.greenpole.hibernate.entity;
// Generated 29-May-2015 21:21:44 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserAccount generated by hbm2java
 */
public class UserAccount  implements java.io.Serializable {


     private int id;
     private Long version;
     private AprDepartment aprDepartment;
     private AprUnit aprUnit;
     private String firstName;
     private String middleName;
     private String lastName;
     private Date dob;
     private String gender;
     private String position;
     private Set groups = new HashSet(0);
     private Set requirementFunctions = new HashSet(0);
     private Set userAccesses = new HashSet(0);
     private Set requirements = new HashSet(0);

    public UserAccount() {
    }

    public UserAccount(AprDepartment aprDepartment, AprUnit aprUnit, String firstName, String middleName, String lastName, Date dob, String gender, String position, Set groups, Set requirementFunctions, Set userAccesses, Set requirements) {
       this.aprDepartment = aprDepartment;
       this.aprUnit = aprUnit;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.dob = dob;
       this.gender = gender;
       this.position = position;
       this.groups = groups;
       this.requirementFunctions = requirementFunctions;
       this.userAccesses = userAccesses;
       this.requirements = requirements;
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
    public AprDepartment getAprDepartment() {
        return this.aprDepartment;
    }
    
    public void setAprDepartment(AprDepartment aprDepartment) {
        this.aprDepartment = aprDepartment;
    }
    public AprUnit getAprUnit() {
        return this.aprUnit;
    }
    
    public void setAprUnit(AprUnit aprUnit) {
        this.aprUnit = aprUnit;
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
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    public Set getGroups() {
        return this.groups;
    }
    
    public void setGroups(Set groups) {
        this.groups = groups;
    }
    public Set getRequirementFunctions() {
        return this.requirementFunctions;
    }
    
    public void setRequirementFunctions(Set requirementFunctions) {
        this.requirementFunctions = requirementFunctions;
    }
    public Set getUserAccesses() {
        return this.userAccesses;
    }
    
    public void setUserAccesses(Set userAccesses) {
        this.userAccesses = userAccesses;
    }
    public Set getRequirements() {
        return this.requirements;
    }
    
    public void setRequirements(Set requirements) {
        this.requirements = requirements;
    }




}


