/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entity;

import java.io.Serializable;

/**
 *
 * @author Akinwale.Agbaje
 */
public class ClientCompanyAddressId implements Serializable {

    private int clientCompanyId;
    private String addressLine1;
    private String state;
    private String country;

    public ClientCompanyAddressId() {
    }

    public ClientCompanyAddressId(int clientCompanyId, String addressLine1, String state, String country) {
        this.clientCompanyId = clientCompanyId;
        this.addressLine1 = addressLine1;
        this.state = state;
        this.country = country;
    }

    public int getClientCompanyId() {
        return this.clientCompanyId;
    }

    public void setClientCompanyId(int clientCompanyId) {
        this.clientCompanyId = clientCompanyId;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof ClientCompanyAddressId)) {
            return false;
        }
        ClientCompanyAddressId castOther = (ClientCompanyAddressId) other;

        return (this.getClientCompanyId() == castOther.getClientCompanyId())
                && ((this.getAddressLine1() == castOther.getAddressLine1()) || (this.getAddressLine1() != null && castOther.getAddressLine1() != null && this.getAddressLine1().equals(castOther.getAddressLine1())))
                && ((this.getState() == castOther.getState()) || (this.getState() != null && castOther.getState() != null && this.getState().equals(castOther.getState())))
                && ((this.getCountry() == castOther.getCountry()) || (this.getCountry() != null && castOther.getCountry() != null && this.getCountry().equals(castOther.getCountry())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getClientCompanyId();
        result = 37 * result + (getAddressLine1() == null ? 0 : this.getAddressLine1().hashCode());
        result = 37 * result + (getState() == null ? 0 : this.getState().hashCode());
        result = 37 * result + (getCountry() == null ? 0 : this.getCountry().hashCode());
        return result;
    }
}
