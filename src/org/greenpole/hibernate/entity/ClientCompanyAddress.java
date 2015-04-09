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
public class ClientCompanyAddress implements Serializable {

    private ClientCompanyAddressId id;
    private ClientCompany clientCompany;
    private long versionId;
    private String lineType;
    private String addressType;

    public ClientCompanyAddress() {
    }

    public ClientCompanyAddress(ClientCompanyAddressId id, ClientCompany clientCompany) {
        this.id = id;
        this.clientCompany = clientCompany;
    }

    public ClientCompanyAddress(ClientCompanyAddressId id, ClientCompany clientCompany, String lineType, String addressType) {
        this.id = id;
        this.clientCompany = clientCompany;
        this.lineType = lineType;
        this.addressType = addressType;
    }

    public ClientCompanyAddressId getId() {
        return id;
    }

    public void setId(ClientCompanyAddressId id) {
        this.id = id;
    }
    
    /**
     * A getter for HolderPostalAddress object which retrieve a version
     * identifier, apart from the primary key of object
     *
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }

    /**
     * A setter for HolderPostalAddress object which persist the versionId
     * identifier in the memory by hibernate
     *
     * @param versionId, an argument that receives the generated version of
     * current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public ClientCompany getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }

    public String getLineType() {
        return this.lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
