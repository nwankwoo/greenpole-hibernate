/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.greenpole.util.Descriptor;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akinwale Agbaje Query implementations to do with client company
 * requirements.
 */
public class ClientCompanyComponentQueryImpl extends GeneralisedAbstractDao implements ClientCompanyComponentQuery {

    private static final Logger logger = LoggerFactory.getLogger(ClientCompanyComponentQueryImpl.class);

    @Override
    public boolean checkClientCompany(String companyName) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.ilike("name", "%" + companyName + "%"))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkClientCompanyByCode(String companyCode) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.ilike("code", "%" + companyCode + "%"))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
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
    public ClientCompany getClientCompany(String code) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.eq("code", "%" + code + "%"));
        getTransaction().commit();
        return (ClientCompany) criteria.list().get(0);
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
        getTransaction().commit();
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
    public boolean uploadShareQuotation(List<ShareQuotation> shareQuotations) {
        startOperation();
        boolean created = false;
        try {
            shareQuotations.stream().forEach((quotation) -> {
                createUpdateObject(quotation);
            });
            getTransaction().commit();
            created = true;
            return created;
        } catch (Exception ex) {
            logger.error("error uploading share quotations - ", ex);
            getTransaction().rollback();
            return created;
        }
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

    /**
     * Gets the criteria for a search on all client companies in the database.
     * @return the criteria for a search on all client companies
     */
    private Criteria getStartCriteria() {
        return getSession().createCriteria(ClientCompany.class, "cc");
    }

    /**
     * Gets the criteria for a search on all client companies according
     * specified object.
     * @param baseCriteria the criteria, typically one for a search on all
     * client companies in the database
     * @param clientCompany the client company object containing search patterns
     * @param ccAddress the client company address object containing search
     * patterns
     * @param ccPhone the client company phone object containing search patterns
     * @param ccEmail the client company email address object containing search
     * patterns
     * @return the criteria for a search on all client companies
     */
    private Criteria searchClientCompanyAccordingToObject(Criteria baseCriteria, ClientCompany clientCompany) {
        List<ClientCompanyAddress> cc_address_list = new ArrayList<>(clientCompany.getClientCompanyAddresses());
        List<ClientCompanyPhoneNumber> cc_phone_list = new ArrayList<>(clientCompany.getClientCompanyPhoneNumbers());
        List<ClientCompanyEmailAddress> cc_email_list = new ArrayList<>(clientCompany.getClientCompanyEmailAddresses());
        
        ClientCompanyAddress ccAddress = cc_address_list.get(0);
        ClientCompanyPhoneNumber ccPhone = cc_phone_list.get(0);
        ClientCompanyEmailAddress ccEmail = cc_email_list.get(0);
        
        return baseCriteria.add(Example.create(clientCompany).enableLike())
                .createCriteria("cc.clientCompanyAddresses", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(ccAddress).enableLike())
                .createCriteria("cc.clientCompanyPhoneNumbers", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(ccPhone).enableLike())
                .createCriteria("cc.clientCompanyEmailAddresses", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(ccEmail).enableLike());
    }

    /**
     * Gets the criteria for a search on all client companies according to
     * specified unit prices.
     * @param baseCriteria the criteria, typically one for a search on all
     * client companies in the database (but not limited to)
     * @param descriptorValue the value of the descriptor to determine what type
     * of search to carry out [whether an exact search - with one value, or a
     * range search - with two values]
     * @param unitPriceCriteria the unit price value(s) to search for
     * @return the criteria for a search on all client companies according to
     * specified unit prices
     */
    private Criteria searchUnitPrice(Criteria baseCriteria, String descriptorValue, Map<String, Double> unitPriceCriteria) {
        Criteria tempCriteria = baseCriteria; //save criteria state, in case it needs to be returned
        baseCriteria.createCriteria("shareQuotations", JoinType.LEFT_OUTER_JOIN);

        if (descriptorValue.equalsIgnoreCase("exact")) {
            double startUnit = unitPriceCriteria.get("start");
            return baseCriteria.add(Restrictions.eq("unitPrice", startUnit));
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            double startUnit = unitPriceCriteria.get("start");
            double endUnit = unitPriceCriteria.get("end");
            return baseCriteria.add(Restrictions.ge("unitPrice", startUnit))
                    .add(Restrictions.le("unitPrice", endUnit));
        }

        return tempCriteria;
    }

    /**
     * Gets the list of client companies according to the specified number of
     * shareholders.
     * @param clientCompanies the pool of client companies to search from
     * @param descriptorValue the value of the descriptor to determine what type
     * of search to carry out [whether an exact search - with one value, or a
     * range search - with two values]
     * @param noOfShareholders the number of shareholders to search for
     * @return the list of client companies according to the specified number of
     * shareholders
     */
    private List<ClientCompany> searchNumberOfShareholders(List<ClientCompany> clientCompanies, String descriptorValue, Map<String, Integer> noOfShareholders) {
        List<ClientCompany> searchResult = new ArrayList<>();

        if (descriptorValue.equalsIgnoreCase("exact")) {
            int startNo = noOfShareholders.get("start");
            for (ClientCompany cc : clientCompanies) {
                if (cc.getHolderCompanyAccounts().size() == startNo) {
                    searchResult.add(cc);
                }
            }
            return searchResult;
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            int startNo = noOfShareholders.get("start");
            int endNo = noOfShareholders.get("end");
            for (ClientCompany cc : clientCompanies) {
                if (cc.getHolderCompanyAccounts().size() >= startNo && cc.getHolderCompanyAccounts().size() <= endNo) {
                    searchResult.add(cc);
                }
            }
            return searchResult;
        }

        return clientCompanies;
    }

    /**
     * Gets the list of client companies according to the specified number of
     * bond holders.
     * @param clientCompanies the pool of client companies to search from
     * @param descriptorValue the value of the descriptor to determine what type
     * of search to carry out [whether an exact search - with one value, or a
     * range search - with two values]
     * @param noOfBondholders the number of bond holders to search for
     * @return the list of client companies according to the specified number of
     * bond holders
     */
    private List<ClientCompany> searchNumberOfBondholders(List<ClientCompany> clientCompanies, String descriptorValue, Map<String, Integer> noOfBondholders) {
        List<ClientCompany> searchResult = new ArrayList<>();
        int bondAccounts = 0;

        if (descriptorValue.equalsIgnoreCase("exact")) {
            int startNo = noOfBondholders.get("start");
            for (ClientCompany cc : clientCompanies) {
                Iterator it = cc.getBondOffers().iterator();
                while (it.hasNext()) {
                    BondOffer bondOffer = (BondOffer) it.next();
                    if (bondOffer.getHolderBondAccounts().size() > 0) {
                        bondAccounts += bondOffer.getHolderBondAccounts().size();
                    }
                }
                if (bondAccounts == startNo) {
                    searchResult.add(cc);
                }
            }
            return searchResult;
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            int startNo = noOfBondholders.get("start");
            int endNo = noOfBondholders.get("end");
            for (ClientCompany cc : clientCompanies) {
                Iterator it = cc.getBondOffers().iterator();
                while (it.hasNext()) {
                    BondOffer bondOffer = (BondOffer) it.next();
                    if (bondOffer.getHolderBondAccounts().size() > 0) {
                        bondAccounts += bondOffer.getHolderBondAccounts().size();
                    }
                }
                if (bondAccounts >= startNo && bondAccounts <= endNo) {
                    searchResult.add(cc);
                }
            }
            return searchResult;
        }

        return clientCompanies;
    }

    @Override
    public List<ClientCompany> queryClientCompany(String descriptor, ClientCompany ccSearchParams, Map<String, Double> shareUnitCriteria,
            Map<String, Integer> noOfShareholdersCriteria, Map<String, Integer> noOfBondholdersCriteria) {
        //descriptor=clientCompany:none;shareUnit:none;numberOfShareholders:none;numberOfBondholders:none
        Map<String, String> descriptorSplits = Descriptor.decipherDescriptor(descriptor);
        String clientCompanyDescriptor = descriptorSplits.get("clientCompany");
        String shareUnitDescriptor = descriptorSplits.get("shareUnit");
        String numberOfShareholdersDescriptor = descriptorSplits.get("numberOfShareholders");
        String numberOfBondholdersDescriptor = descriptorSplits.get("numberOfBondholders");

        startOperation();
        Criteria baseCriteria = getStartCriteria();

        //we should assume the  result will consist of the base client company list
        List<ClientCompany> result = baseCriteria.list();
        Criteria clientCompanyUnitPriceCriteria;
        Criteria clientCompanySearchCriteria = baseCriteria; //client company search criteria must be initialised since it is being used in an isolated if statement
        //under the share unit price search (see if statement for clarification).

        if (clientCompanyDescriptor.equalsIgnoreCase("exact")) {
            clientCompanySearchCriteria = searchClientCompanyAccordingToObject(baseCriteria, ccSearchParams);
            result = clientCompanySearchCriteria.list();
        }

        //if client company was searched for, pass client company search criteria into unit price search. Otherwise, use base criteria
        if (!shareUnitDescriptor.equalsIgnoreCase("none") && clientCompanyDescriptor.equalsIgnoreCase("exact")) {
            clientCompanyUnitPriceCriteria = searchUnitPrice(clientCompanySearchCriteria, shareUnitDescriptor, shareUnitCriteria);
            result = clientCompanyUnitPriceCriteria.list();
        } else if (!shareUnitDescriptor.equalsIgnoreCase("none") && !clientCompanyDescriptor.equalsIgnoreCase("exact")) {
            clientCompanyUnitPriceCriteria = searchUnitPrice(baseCriteria, shareUnitDescriptor, shareUnitCriteria);
            result = clientCompanyUnitPriceCriteria.list();
        }

        if (!numberOfShareholdersDescriptor.equalsIgnoreCase("none")) {
            result = searchNumberOfShareholders(result, numberOfShareholdersDescriptor, noOfShareholdersCriteria);
        }

        if (!numberOfBondholdersDescriptor.equalsIgnoreCase("none")) {
            result = searchNumberOfBondholders(result, numberOfBondholdersDescriptor, noOfBondholdersCriteria);
        }

        getTransaction().commit();

        return result;
    }
}
