/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumberId;
import org.hibernate.Session;

/**
 *
 * @author Ahmad.Gbadamosi
 */
public class ClientCompanyQueryImpl {
    
    Session session;
    ClientCompanyDao clientDao;
    
    public void persistClientCompany(){
        ClientCompany client = new ClientCompany();
        clientDao.create(client);
    }
    
    public void queryClientCompany(){}
    
    public void editClientCompany(int clientId){
        queryClientCompany();
        ClientCompany client = new ClientCompany();
        client = (ClientCompany) session.get(ClientCompany.class, clientId); //fetch a particular client
        //NOTE: Remember to add the clientcompanyAddress after the creation of the table
        ClientCompanyPhoneNumber  ccNumber = new ClientCompanyPhoneNumber();
        ClientCompanyPhoneNumberId ccfone = new ClientCompanyPhoneNumberId();
        ccfone.setClientCompanyId(client.getId());
        client.setName(null);
        client.setCode(null);
        client.setCeo(null);
        client.setDepository(null);
        client.setDepository(null);
        
    }
    
}
