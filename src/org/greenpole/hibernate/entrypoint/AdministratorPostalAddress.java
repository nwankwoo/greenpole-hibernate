package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * AdministratorPostalAddress generated by hbm2java
 */
public class AdministratorPostalAddress  implements java.io.Serializable {


     private AdministratorPostalAddressId id;
     private Administrator administrator;
     private String type;

    public AdministratorPostalAddress() {
    }

	
    public AdministratorPostalAddress(AdministratorPostalAddressId id, Administrator administrator) {
        this.id = id;
        this.administrator = administrator;
    }
    public AdministratorPostalAddress(AdministratorPostalAddressId id, Administrator administrator, String type) {
       this.id = id;
       this.administrator = administrator;
       this.type = type;
    }
   
    public AdministratorPostalAddressId getId() {
        return this.id;
    }
    
    public void setId(AdministratorPostalAddressId id) {
        this.id = id;
    }
    public Administrator getAdministrator() {
        return this.administrator;
    }
    
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }




}


