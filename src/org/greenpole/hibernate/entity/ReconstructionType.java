/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Akin
 */
public class ReconstructionType implements java.io.Serializable {

    private int id;
    private long versionId;
    private String type;
    private String description;
    private Set reconstructions = new HashSet(0);

    public ReconstructionType() {
    }

    public ReconstructionType(String type, String description, Set reconstructions) {
        this.type = type;
        this.description = description;
        this.reconstructions = reconstructions;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * A getter for Administrator object which retrieve a version identifier,
     * apart from the primary key of object
     *
     * @return versionId identifier
     */
    public long getVersionId() {
        return versionId;
    }

    /**
     * A setter for Administrator object which persist the versionId identifier
     * in the memory by hibernate
     *
     * @param versionId, an argument that receives the generated version of
     * current object by hibernate
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set getReconstructions() {
        return this.reconstructions;
    }

    public void setReconstructions(Set reconstructions) {
        this.reconstructions = reconstructions;
    }

}
