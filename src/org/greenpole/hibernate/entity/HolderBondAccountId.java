/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entity;

import java.io.Serializable;

/**
 *
 * @author Akin
 */
public class HolderBondAccountId implements Serializable {

    private int holderId;
    private int bondOfferId;

    public HolderBondAccountId() {
    }

    public HolderBondAccountId(int holderId, int bondOfferId) {
        this.holderId = holderId;
        this.bondOfferId = bondOfferId;
    }

    public int getHolderId() {
        return holderId;
    }

    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }

    public int getBondOfferId() {
        return bondOfferId;
    }

    public void setBondOfferId(int bondOfferId) {
        this.bondOfferId = bondOfferId;
    }
    
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof HolderBondAccountId)) {
            return false;
        }
        HolderBondAccountId castOther = (HolderBondAccountId) other;

        return (this.getHolderId() == castOther.getHolderId())
                && (this.getBondOfferId() == castOther.getBondOfferId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getHolderId();
        result = 37 * result + this.getBondOfferId();
        return result;
    }
    
}
