/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

/**
 *
 * @author Akinwale Agbaje
 * Contains queries to do with client company requirements.
 */
public interface ClientCompanyComponentQuery {
    /**
     * Checks the existence of a client company.
     * @param companyname company name to search for
     * @return true, if company exists. Otherwise, false
     */
    public boolean checkClientCompany(String companyname);
}
