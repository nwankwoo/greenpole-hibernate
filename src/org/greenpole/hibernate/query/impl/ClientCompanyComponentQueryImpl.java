/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.greenpole.hibernate.entity.BondOffer;
import org.greenpole.hibernate.entity.BondOfferPaymentPlan;
import org.greenpole.hibernate.entity.BondType;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyAddress;
import org.greenpole.hibernate.entity.ClientCompanyEmailAddress;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;
import org.greenpole.hibernate.entity.Depository;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.InitialPublicOffer;
import org.greenpole.hibernate.entity.NseSector;
import org.greenpole.hibernate.entity.PrivatePlacement;
import org.greenpole.hibernate.entity.ShareQuotation;
import org.greenpole.hibernate.exception.GreenpoleQueryException;
import org.greenpole.hibernate.query.ClientCompanyComponentQuery;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.greenpole.hibernate.util.Descriptor;
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
                .add(Restrictions.eq("name", companyName))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkClientCompanyByCode(String companyCode) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.eq("code", companyCode))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkClientCompany(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.eq("valid", true))
                .add(Restrictions.idEq(clientCompanyId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkClientCompanyIgnoreValid(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.idEq(clientCompanyId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean clientCompanyIsValid(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.eq("valid", true))
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
                .add(Restrictions.eq("code", code));
        ClientCompany cc = (ClientCompany) criteria.list().get(0);
        getTransaction().commit();
        return cc;
    }

    @Override
    public List<ClientCompany> getAllClientCompanies() {
        startOperation();
        List<ClientCompany> cclist = searchAll(ClientCompany.class);
        getTransaction().commit();
        return cclist;
    }
    
    @Override
    public ClientCompany getClientCompanyByName(String name) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.eq("name", name));
        ClientCompany cc = (ClientCompany) criteria.list().get(0);
        getTransaction().commit();
        return cc;
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
    public List<ClientCompanyAddress> getClientCompanyAddresses(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompanyAddress.class)
                .add(Restrictions.eq("clientCompany.id", clientCompanyId));
        List<ClientCompanyAddress> addy_list = criteria.list();
        getTransaction().commit();
        return addy_list;
    }

    @Override
    public ClientCompanyAddress getClientCompanyAddress(int id) {
        startOperation();
        ClientCompanyAddress addy = (ClientCompanyAddress) searchObject(ClientCompanyAddress.class, id);
        getTransaction().commit();
        return addy;
    }

    @Override
    public List<ClientCompanyEmailAddress> getClientCompanyEmailAddresses(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompanyEmailAddress.class)
                .add(Restrictions.eq("clientCompany.id", clientCompanyId));
        List<ClientCompanyEmailAddress> email_list = criteria.list();
        getTransaction().commit();
        return email_list;
    }

    @Override
    public ClientCompanyEmailAddress getClientCompanyEmailAddress(int id) {
        startOperation();
        ClientCompanyEmailAddress email = (ClientCompanyEmailAddress) searchObject(ClientCompanyEmailAddress.class, id);
        getTransaction().commit();
        return email;
    }

    @Override
    public List<ClientCompanyPhoneNumber> getClientCompanyPhoneNumbers(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompanyPhoneNumber.class)
                .add(Restrictions.eq("clientCompany.id", clientCompanyId));
        List<ClientCompanyPhoneNumber> phone_list = criteria.list();
        getTransaction().commit();
        return phone_list;
    }

    @Override
    public ClientCompanyPhoneNumber getClientCompanyPhoneNumber(int id) {
        startOperation();
        ClientCompanyPhoneNumber phone = (ClientCompanyPhoneNumber) searchObject(ClientCompanyPhoneNumber.class, id);
        getTransaction().commit();
        return phone;
    }

    @Override
    public int getNumberOfShareholders(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderCompanyAccount.class)
                .add(Restrictions.eq("clientCompany.id", clientCompanyId));
        List<HolderCompanyAccount> accts = criteria.list();
        int count = 0;
        for (HolderCompanyAccount hca : accts) {
            if (hca.getShareUnits() != null && hca.getShareUnits() > 0)
                ++count;
        }
        getTransaction().commit();
        return count;
    }

    @Override
    public int getNumberOfBondholders(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(BondOffer.class)
                .add(Restrictions.eq("clientCompany.id", clientCompanyId));
        List<BondOffer> offers = criteria.list();
        int count = 0;
        for (BondOffer bo : offers) {
            List<HolderBondAccount> accts = new ArrayList<>(bo.getHolderBondAccounts());
            for (HolderBondAccount hba : accts) {
                if (!Objects.equals(hba.getRemainingPrincipalValue(), hba.getStartingPrincipalValue()))
                    ++count;
            }
        }
        getTransaction().commit();
        return count;
    }

    @Override
    public double getUnitPrice(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ShareQuotation.class)
                .add(Restrictions.eq("clientCompany.id", clientCompanyId));
        double price = 0.00;
        if (criteria.list() != null && !criteria.list().isEmpty()) {
            ShareQuotation quotation = (ShareQuotation) criteria.list().get(0);
            price = quotation.getUnitPrice();
        }
        getTransaction().commit();
        return price;
    }

    @Override
    public boolean createClientCompany(ClientCompany clientCompany, List<ClientCompanyAddress> addresses,
            List<ClientCompanyEmailAddress> emailAddresses, List<ClientCompanyPhoneNumber> phoneNumbers) {
        boolean created = false;
        try {
            startOperation();
            
            //update client company
            createUpdateObject(clientCompany);
            
            //create addresses
            addresses.stream().forEach((addy) -> {
                addy.setClientCompany(clientCompany);
                createUpdateObject(addy);
            });
            //create email addresses
            emailAddresses.stream().forEach((email) -> {
                email.setClientCompany(clientCompany);
                createUpdateObject(email);
            });
            //create phone numbers
            phoneNumbers.stream().forEach((phone) -> {
                phone.setClientCompany(clientCompany);
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
    public boolean updateClientCompany(ClientCompany clientCompany, List<ClientCompanyAddress> addresses, List<ClientCompanyEmailAddress> emailAddresses,
            List<ClientCompanyPhoneNumber> phoneNumbers, List<ClientCompanyAddress> addressesToRemove, 
            List<ClientCompanyEmailAddress> emailAddressesToRemove, List<ClientCompanyPhoneNumber> phoneNumbersToRemove) {
        boolean updated = false;
        try {
            startOperation();
            
            //update client company
            createUpdateObject(clientCompany);
            
            //update addresses
            if (addresses != null) {
                addresses.stream().forEach((addy) -> {
                    addy.setClientCompany(clientCompany);
                    createUpdateObject(addy);
                });
            }
            
            //update email addresses
            if (emailAddresses != null) {
                emailAddresses.stream().forEach((email) -> {
                    email.setClientCompany(clientCompany);
                    createUpdateObject(email);
                });
            }
            
            //update phone numbers
            if (phoneNumbers != null) {
                phoneNumbers.stream().forEach((phone) -> {
                    phone.setClientCompany(clientCompany);
                    createUpdateObject(phone);
                });
            }
            
            //remove addresses
            if (addressesToRemove != null) {
                addressesToRemove.stream().forEach((addy) -> {
                    addy.setClientCompany(clientCompany);
                    removeObject(addy);
                });
            }
            
            //remove email addresses
            if (emailAddressesToRemove != null) {
                emailAddressesToRemove.stream().forEach((email) -> {
                    email.setClientCompany(clientCompany);
                    removeObject(email);
                });
            }
            
            //remove phone numbers
            if (phoneNumbersToRemove != null) {
                phoneNumbersToRemove.stream().forEach((phone) -> {
                    phone.setClientCompany(clientCompany);
                    removeObject(phone);
                });
            }
            
            getTransaction().commit();
            updated = true;
            return updated;
        } catch (Exception ex) {
            logger.error("error updating client company - ", ex);
            getTransaction().rollback();
            return updated;
        }
    }

    @Override
    public void createBondOffer(BondOffer bondOffer) {
        startOperation();
        createUpdateObject(bondOffer);
        getTransaction().commit();
    }

    @Override
    public boolean bondOfferIsValid(int bondOfferId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(BondOffer.class)
                .add(Restrictions.eq("valid", true))
                .add(Restrictions.idEq(bondOfferId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public void createInitialPublicOffer(InitialPublicOffer initialPublicOffer) {
        startOperation();
        createUpdateObject(initialPublicOffer);
        getTransaction().commit();
    }

    @Override
    public boolean clientCompanyHasIpo(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(ClientCompany.class)
                .add(Restrictions.idEq(clientCompanyId));
        ClientCompany cc = (ClientCompany) criteria.list().get(0);
        int count = cc.getInitialPublicOffers().size();
        getTransaction().commit();
        return count > 0;
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
     * @return the criteria for a search on all client companies
     */
    private Criteria searchClientCompanyAccordingToObject(Criteria baseCriteria, ClientCompany clientCompany) {
        baseCriteria.add(Example.create(clientCompany).enableLike());
        
        List<ClientCompanyAddress> cc_address_list = new ArrayList<>(clientCompany.getClientCompanyAddresses());
        List<ClientCompanyPhoneNumber> cc_phone_list = new ArrayList<>(clientCompany.getClientCompanyPhoneNumbers());
        List<ClientCompanyEmailAddress> cc_email_list = new ArrayList<>(clientCompany.getClientCompanyEmailAddresses());
        
        if (clientCompany.getDepository().getName() != null) {
            baseCriteria.createCriteria("cc.depository", JoinType.LEFT_OUTER_JOIN)
                    .add(Example.create(clientCompany.getDepository()).enableLike().ignoreCase());
        }
        
        if (clientCompany.getNseSector().getName() != null) {
            baseCriteria.createCriteria("cc.nseSector", JoinType.LEFT_OUTER_JOIN)
                    .add(Example.create(clientCompany.getNseSector()).enableLike().ignoreCase());
        }
        
        if (!cc_address_list.isEmpty()) {
            ClientCompanyAddress ccAddress = cc_address_list.get(0);
            
            baseCriteria.createCriteria("cc.clientCompanyAddresses", "a", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(ccAddress).enableLike().ignoreCase());
        }
        
        if (!cc_phone_list.isEmpty()) {
            ClientCompanyPhoneNumber ccPhone = cc_phone_list.get(0);
            
            baseCriteria.createCriteria("cc.clientCompanyPhoneNumbers", "p", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(ccPhone).enableLike().ignoreCase());
        }
        
        if (!cc_email_list.isEmpty()) {
            ClientCompanyEmailAddress ccEmail = cc_email_list.get(0);
            
            baseCriteria.createCriteria("cc.clientCompanyEmailAddresses", "e", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(ccEmail).enableLike().ignoreCase());
        }
        
        return baseCriteria;
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
        baseCriteria.createCriteria("cc.shareQuotations", "s", JoinType.LEFT_OUTER_JOIN);

        if (descriptorValue.equalsIgnoreCase("exact")) {
            double startUnit = unitPriceCriteria.get("start");
            return baseCriteria.add(Restrictions.eq("s.unitPrice", startUnit));
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            double startUnit = unitPriceCriteria.get("start");
            double endUnit = unitPriceCriteria.get("end");
            return baseCriteria.add(Restrictions.ge("s.unitPrice", startUnit))
                    .add(Restrictions.le("s.unitPrice", endUnit));
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
                List<HolderCompanyAccount> acct_list = new ArrayList<>(cc.getHolderCompanyAccounts());
                int count = 0;
                for (HolderCompanyAccount hca : acct_list) {
                    if (hca.getShareUnits() != null && hca.getShareUnits() > 0)
                        ++count;
                }
                if (count == startNo) {
                    searchResult.add(cc);
                }
            }
            return searchResult;
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            int startNo = noOfShareholders.get("start");
            int endNo = noOfShareholders.get("end");
            for (ClientCompany cc : clientCompanies) {
                List<HolderCompanyAccount> acct_list = new ArrayList<>(cc.getHolderCompanyAccounts());
                int count = 0;
                for (HolderCompanyAccount hca : acct_list) {
                    if (hca.getShareUnits() != null && hca.getShareUnits() > 0)
                        ++count;
                }
                if (count >= startNo && count <= endNo) {
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

        if (descriptorValue.equalsIgnoreCase("exact")) {
            int startNo = noOfBondholders.get("start");
            for (ClientCompany cc : clientCompanies) {
                int bondAccounts = 0;
                Iterator it = cc.getBondOffers().iterator();
                while (it.hasNext()) {
                    BondOffer bondOffer = (BondOffer) it.next();
                    List<HolderBondAccount> bond_list = new ArrayList<>(bondOffer.getHolderBondAccounts());
                    for (HolderBondAccount hba : bond_list) {
                        if (hba.getBondUnits() != null && hba.getBondUnits() > 0)
                            ++bondAccounts;
                    }
                }
                if (bondAccounts == startNo) {
                    searchResult.add(cc);
                    bondAccounts = 0;
                }
            }
            return searchResult;
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            int startNo = noOfBondholders.get("start");
            int endNo = noOfBondholders.get("end");
            for (ClientCompany cc : clientCompanies) {
                int bondAccounts = 0;
                Iterator it = cc.getBondOffers().iterator();
                while (it.hasNext()) {
                    BondOffer bondOffer = (BondOffer) it.next();
                    List<HolderBondAccount> bond_list = new ArrayList<>(bondOffer.getHolderBondAccounts());
                    for (HolderBondAccount hba : bond_list) {
                        if (hba.getBondUnits() != null && hba.getBondUnits() > 0)
                            ++bondAccounts;
                    }
                }
                System.out.println("::::no of bonds found:::: " + bondAccounts);
                if (bondAccounts >= startNo && bondAccounts <= endNo) {
                    searchResult.add(cc);
                    bondAccounts = 0;
                }
            }
            return searchResult;
        }

        return clientCompanies;
    }

    @Override
    public List<ClientCompany> queryClientCompany(String descriptor, ClientCompany ccSearchParams, Map<String, Double> shareUnitCriteria,
            Map<String, Integer> noOfShareholdersCriteria, Map<String, Integer> noOfBondholdersCriteria) throws GreenpoleQueryException {
        Descriptor descriptorUtil = new Descriptor();
        //intial shareholder object, in case holder isnt searched
        ClientCompany initialCC = new ClientCompany();
        initialCC.setClientCompanyPrimary(true);
        initialCC.setMerged(false);
        
        //descriptor=clientCompany:none;shareUnit:none;numberOfShareholders:none;numberOfBondholders:none
        Map<String, String> descriptorSplits = descriptorUtil.decipherDescriptor(descriptor);
        String clientCompanyDescriptor = descriptorSplits.get("clientCompany");
        String shareUnitDescriptor = descriptorSplits.get("shareUnit");
        String numberOfShareholdersDescriptor = descriptorSplits.get("numberOfShareholders");
        String numberOfBondholdersDescriptor = descriptorSplits.get("numberOfBondholders");
        
        try {
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
            } else {
                baseCriteria.add(Example.create(initialCC).enableLike());
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
        } finally {
            if (getTransaction() != null && !getTransaction().wasCommitted())
                getTransaction().rollback();
        }
    }

    @Override
    public BondOffer getBondOffer(int bondOfferId) {
        startOperation();
        BondOffer bo = (BondOffer) searchObject(BondOffer.class, bondOfferId);
        getTransaction().commit();
        return bo;
    }

    @Override
    public boolean checkOpenPrivatePlacement(int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PrivatePlacement.class)
                .add(Restrictions.eq("clientCompany.id", clientCompanyId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        return count > 0;
    }

    @Override
    public List<BondType> getAllBondTypes() {
        startOperation();
        List<BondType> bt_list = searchAll(BondType.class);
        getTransaction().commit();
        return bt_list;
    }

    @Override
    public BondType getBondType(int bondTypeId) {
        startOperation();
        BondType type = (BondType) searchObject(BondType.class, bondTypeId);
        getTransaction().commit();
        return type;
    }

    @Override
    public List<BondOfferPaymentPlan> getAllBondOfferPaymentPlans() {
        startOperation();
        List<BondOfferPaymentPlan> plans = searchAll(BondOfferPaymentPlan.class);
        getTransaction().commit();
        return plans;
    }

    @Override
    public BondOfferPaymentPlan getBondOfferPaymentPlan(int planId) {
        startOperation();
        BondOfferPaymentPlan plan = (BondOfferPaymentPlan) searchObject(BondOfferPaymentPlan.class, planId);
        getTransaction().commit();
        return plan;
    }

    @Override
    public List<NseSector> getAllNseSectors() {
        startOperation();
        List<NseSector> sectors = searchAll(NseSector.class);
        getTransaction().commit();
        return sectors;
    }

    @Override
    public NseSector getNseSector(int sectorId) {
        startOperation();
        NseSector sector = (NseSector) searchObject(NseSector.class, sectorId);
        getTransaction().commit();
        return sector;
    }

    @Override
    public List<Depository> getAllDepositories() {
        startOperation();
        List<Depository> depositories = searchAll(Depository.class);
        getTransaction().commit();
        return depositories;
    }

    @Override
    public Depository getDepository(int depositoryId) {
        startOperation();
        Depository depository = (Depository) searchObject(Depository.class, depositoryId);
        getTransaction().commit();
        return depository;
    }
}
