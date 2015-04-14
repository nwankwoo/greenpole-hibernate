/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.util.Iterator;
import java.util.List;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyAddress;
import org.greenpole.hibernate.entity.ClientCompanyEmailAddress;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;
import org.greenpole.hibernate.query.ClientCompanyComponentQuery;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akinwale Agbaje
 * Query implementations to do with client company requirements.
 */
public class ClientCompanyComponentQueryImpl extends GeneralisedAbstractDao implements ClientCompanyComponentQuery  {
    private static final Logger logger = LoggerFactory.getLogger(ClientCompanyComponentQueryImpl.class);

    @Override
    public boolean checkClientCompany(String companyName) {
        startOperation();
        String hql = "SELECT count(distinct name) FROM ClientCompany WHERE name = :companyname";
        Query query = getSession().createQuery(hql);
        query.setParameter("companyname", companyName);
        int count = 0;
        for (Iterator it = query.iterate(); it.hasNext();) {
            count = (int) it.next();
        }
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public ClientCompany getClientCompany(Integer id) {
        startOperation();
        ClientCompany cc = (ClientCompany) searchObject(ClientCompany.class, id);
        getTransaction().commit();
        return cc;
    }

    @Override
    public void editClientCompany(ClientCompany clientCompany) {
        startOperation();
        createUpdateObject(clientCompany);
        getTransaction().commit();
    }

    @Override
    public int getClientCompanyId(String clientCompanyName) {
        startOperation();
        String hql = "FROM ClientCompany WHERE name = :companyname";
        Query query = getSession().createQuery(hql);
        query.setParameter("companyname", clientCompanyName);
        List results = query.list();
        ClientCompany cc = (ClientCompany) results.get(0);
        getTransaction().commit();
        return cc.getId();
    }

    @Override
    public void createAddress(ClientCompanyAddress address) {
        startOperation();
        createUpdateObject(address);
        getTransaction();
    }

    @Override
    public void createEmailAddress(ClientCompanyEmailAddress emailAddress) {
        startOperation();
        createUpdateObject(emailAddress);
        getTransaction().commit();
    }

    @Override
    public void createPhoneNumber(ClientCompanyPhoneNumber phoneNumber) {
        startOperation();
        createUpdateObject(phoneNumber);
        getTransaction().commit();
    }

    @Override
    public boolean createOrUpdateClientCompany(ClientCompany clientCompany, List<ClientCompanyAddress> addresses, 
            List<ClientCompanyEmailAddress> emailAddresses, List<ClientCompanyPhoneNumber> phoneNumbers) {
        boolean created = false;
        try {
            startOperation();
            //create client company
            createUpdateObject(clientCompany);
            //create addresses
            addresses.stream().map((address) -> {
                address.getId().setClientCompanyId(clientCompany.getId());
                return address;
            }).forEach((addy) -> {
                createUpdateObject(addy);
            });
            //create email addresses
            emailAddresses.stream().map((email) -> {
                email.getId().setClientCompanyId(clientCompany.getId());
                return email;
            }).forEach((email) -> {
                createUpdateObject(email);
            });
            //create phone numbers
            phoneNumbers.stream().map((phone) -> {
                phone.getId().setClientCompanyId(clientCompany.getId());
                return phone;
            }).forEach((phone) -> {
                createUpdateObject(phone);
            });
            created = true;
            return created;
        } catch (Exception ex) {
            logger.error("error creating client company - ", ex);
            getTransaction().rollback();
            return created;
        }
    }
    
}
