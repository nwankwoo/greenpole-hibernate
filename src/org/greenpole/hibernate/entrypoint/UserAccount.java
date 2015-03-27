package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserAccount generated by hbm2java
 */
public class UserAccount  implements java.io.Serializable {


     private int id;
     private String firstName;
     private String middleName;
     private String lastName;
     private Date dob;
     private String gender;
     private String position;
     private String unit;
     private int deptId;
     private int unitId;
     private Set groups = new HashSet(0);
     private Set requirementFunctions = new HashSet(0);
     private UserAccess userAccess;
     private Set requirements = new HashSet(0);

    public UserAccount() {
    }

    public UserAccount(String firstName, String middleName, String lastName, Date dob, String gender, String position, String unit, int deptId, int unitId, Set groups, Set requirementFunctions, UserAccess userAccess, Set requirements) {
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.dob = dob;
       this.gender = gender;
       this.position = position;
       this.unit = unit;
       this.deptId = deptId;
       this.unitId = unitId;
       this.groups = groups;
       this.requirementFunctions = requirementFunctions;
       this.userAccess = userAccess;
       this.requirements = requirements;
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
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public int getUnitId() {
        return this.unitId;
    }
    
    public void setUnitId(int unitId) {
        this.unitId = unitId;
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
    public UserAccess getUserAccess() {
        return this.userAccess;
    }
    
    public void setUserAccess(UserAccess userAccess) {
        this.userAccess = userAccess;
    }
    public Set getRequirements() {
        return this.requirements;
    }
    
    public void setRequirements(Set requirements) {
        this.requirements = requirements;
    }




}


