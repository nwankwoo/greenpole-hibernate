/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entity;

import java.io.Serializable;

/**
 *
 * @author Akinwale Agbaje
 */
public class HolderBonusId implements Serializable {
    private int holderId;
    private int shareBonusId;

    public HolderBonusId() {
    }

    public HolderBonusId(int holderId, int shareBonusId) {
        this.holderId = holderId;
        this.shareBonusId = shareBonusId;
    }

    public int getHolderId() {
        return holderId;
    }

    public void setHolderId(int holderId) {
        this.holderId = holderId;
    }

    public int getShareBonusId() {
        return shareBonusId;
    }

    public void setShareBonusId(int shareBonusId) {
        this.shareBonusId = shareBonusId;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof HolderBonusId)) {
            return false;
        }
        HolderBonusId castOther = (HolderBonusId) other;

        return (this.getHolderId() == castOther.getHolderId())
                && (this.getShareBonusId() == castOther.getShareBonusId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getHolderId();
        result = 37 * result + this.getShareBonusId();
        return result;
    }
}
