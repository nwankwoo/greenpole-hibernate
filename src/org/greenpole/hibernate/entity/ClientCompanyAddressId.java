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
    private String addressLine;
    private int lineNumber;

    public ClientCompanyAddressId() {
    }

    public ClientCompanyAddressId(int clientCompanyId, String addressLine, int lineNumber) {
        this.clientCompanyId = clientCompanyId;
        this.addressLine = addressLine;
        this.lineNumber = lineNumber;
    }

    public int getClientCompanyId() {
        return this.clientCompanyId;
    }

    public void setClientCompanyId(int clientCompanyId) {
        this.clientCompanyId = clientCompanyId;
    }

    public String getAddressLine() {
        return this.addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
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
                && ((this.getAddressLine() == castOther.getAddressLine()) || (this.getAddressLine() != null && castOther.getAddressLine() != null && this.getAddressLine().equals(castOther.getAddressLine())))
                && (this.getLineNumber() == castOther.getLineNumber());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getClientCompanyId();
        result = 37 * result + (getAddressLine() == null ? 0 : this.getAddressLine().hashCode());
        result = 37 * result + this.getLineNumber();
        return result;
    }
}
