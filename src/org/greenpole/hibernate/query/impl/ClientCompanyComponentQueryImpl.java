/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.util.List;
import org.greenpole.hibernate.entity.BondOffer;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyAddress;
import org.greenpole.hibernate.entity.ClientCompanyEmailAddress;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;
import org.greenpole.hibernate.entity.InitialPublicOffer;
import org.greenpole.hibernate.entity.PrivatePlacement;
import org.greenpole.hibernate.entity.ShareQuotation;
import org.greenpole.hibernate.query.ClientCompanyComponentQuery;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.ilike("name", "%"+companyName+"%"))
                .setProjection(Projections.rowCount());
        Long count =  (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkClientCompany(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.idEq(clientCompanyId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
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
            getTransaction().commit();
            created = true;
            return created;
        } catch (Exception ex) {
            logger.error("error creating client company - ", ex);
            getTransaction().rollback();
            return created;
        }
    }

    @Override
    public void createBondOffer(BondOffer bondOffer) {
        startOperation();
        createUpdateObject(bondOffer);
        getTransaction().commit();
    }

    @Override
    public void createInitialPublicOffer(InitialPublicOffer initialPublicOffer) {
        startOperation();
        createUpdateObject(initialPublicOffer);
        getTransaction().commit();
    }

    @Override
    public void createPrivatePlacement(PrivatePlacement privatePlacement) {
        startOperation();
        createUpdateObject(privatePlacement);
        getTransaction().commit();
    }

    @Override
    public List retrieveShareUnitQuatationList() {
        startOperation();
        List result = searchAll(ShareQuotation.class);
        getTransaction().commit();
        return result;
    }

    @Override
    public void uploadShareQuotation(ShareQuotation shareQuotation) {
        startOperation();
        createUpdateObject(shareQuotation);
        getTransaction().commit();
    }

    @Override
    public boolean checkClientCompanyForShareholders(String clientCompanyName) {
        startOperation();
        List result = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.eq("name", clientCompanyName)).list();
        ClientCompany cc = (ClientCompany) result.get(0);
        int countAccounts = cc.getHolderCompanyAccounts().size();
        int countCertificates = cc.getCertificates().size();
        getTransaction().commit();
        return countAccounts > 0 || countCertificates > 0;
    }

}
