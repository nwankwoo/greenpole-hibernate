/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.util.Iterator;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.query.ClientCompanyComponentQuery;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.greenpole.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Akinwale Agbaje
 * Query implementations to do with client company requirements.
 */
public class ClientCompanyComponentQueryImpl extends GeneralisedAbstractDao implements ClientCompanyComponentQuery  {

    @Override
    public boolean checkClientCompany(String companyname) {
        startOperation();
        String hql = "SELECT count(distinct name) FROM ClientCompany WHERE name = :companyname";
        Query query = getSession().createQuery(hql);
        query.setParameter("companyname", companyname);
        int count = 0;
        for (Iterator it = query.iterate(); it.hasNext();) {
            count = (int) it.next();
        }
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public void create(ClientCompany clientCompany) {
        createUpdateObject(clientCompany);
    }

    @Override
    public ClientCompany getClientCompany(Integer id) {
        return (ClientCompany) searchObject(ClientCompany.class, id);
    }

    @Override
    public void editClientCompany(ClientCompany clientCompany) {
        createUpdateObject(clientCompany);
    }
    
}
