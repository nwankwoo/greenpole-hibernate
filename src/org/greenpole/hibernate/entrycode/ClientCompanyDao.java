/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

import org.greenpole.hibernate.entity.ClientCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ahmad.Gbadamosi
 */
public class ClientCompanyDao extends GeneralisedAbstractDao{
    private final Logger log = LoggerFactory.getLogger(ClientCompanyDao.class);
    
    /**
     *
     * @param clientcompany
     * @throws DataAccessLayerException
     */
    public void create(ClientCompany clientcompany) throws DataAccessLayerException{
        super.createUpdateObject(this);
    }
    /**
     *
     * @param cc
     * @return
     * @throws DataAccessLayerException
     */
    public ClientCompany getClientCompany(int cc) throws DataAccessLayerException{
        return (ClientCompany)super.searchObject(ClientCompany.class, cc);
    }
    
    public void editClientCompany(ClientCompany clientcompany){
        super.createUpdateObject(this);
    }
}
