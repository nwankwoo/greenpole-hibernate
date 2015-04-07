package org.greenpole.hibernate.entity;
// Generated Apr 2, 2015 11:49:14 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Requirement generated by hbm2java
 */
public class Requirement  implements java.io.Serializable {


     private int id;
     private Group group;
     private String name;
     private String description;
     private String screen;
     private String viewType;
     private String model;
     private int authoriser;
     private Set requirementFunctions = new HashSet(0);
     private Set userAccounts = new HashSet(0);

    public Requirement() {
    }

    public Requirement(Group group, String name, String description, String screen, String viewType, String model, int authoriser, Set requirementFunctions, Set userAccounts) {
       this.group = group;
       this.name = name;
       this.description = description;
       this.screen = screen;
       this.viewType = viewType;
       this.model = model;
       this.authoriser = authoriser;
       this.requirementFunctions = requirementFunctions;
       this.userAccounts = userAccounts;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Group getGroup() {
        return this.group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getScreen() {
        return this.screen;
    }
    
    public void setScreen(String screen) {
        this.screen = screen;
    }
    public String getViewType() {
        return this.viewType;
    }
    
    public void setViewType(String viewType) {
        this.viewType = viewType;
    }
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    public int getAuthoriser() {
        return this.authoriser;
    }
    
    public void setAuthoriser(int authoriser) {
        this.authoriser = authoriser;
    }
    public Set getRequirementFunctions() {
        return this.requirementFunctions;
    }
    
    public void setRequirementFunctions(Set requirementFunctions) {
        this.requirementFunctions = requirementFunctions;
    }
    public Set getUserAccounts() {
        return this.userAccounts;
    }
    
    public void setUserAccounts(Set userAccounts) {
        this.userAccounts = userAccounts;
    }




}


