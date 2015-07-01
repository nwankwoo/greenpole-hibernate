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
import org.greenpole.hibernate.entity.ClearingHouse;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyAddress;
import org.greenpole.hibernate.entity.ClientCompanyEmailAddress;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;
import org.greenpole.hibernate.entity.Depository;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.InitialPublicOffer;
import org.greenpole.hibernate.entity.IpoApplication;
import org.greenpole.hibernate.entity.NseSector;
import org.greenpole.hibernate.entity.PrivatePlacement;
import org.greenpole.hibernate.entity.PrivatePlacementApplication;
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
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.eq("name", companyName))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkClientCompanyByCode(String companyCode) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.eq("code", companyCode))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkClientCompany(int clientCompanyId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.eq("valid", true))
                    .add(Restrictions.idEq(clientCompanyId))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkClientCompanyIgnoreValid(int clientCompanyId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.idEq(clientCompanyId))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean clientCompanyIsValid(int clientCompanyId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.eq("valid", true))
                    .add(Restrictions.idEq(clientCompanyId))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public ClientCompany getClientCompany(Integer id) {
        ClientCompany cc = new ClientCompany();
        try {
            startOperation();
            cc = (ClientCompany) searchObject(ClientCompany.class, id);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return cc;
    }

    @Override
    public ClientCompany getClientCompany(String code) {
        ClientCompany cc = new ClientCompany();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.eq("code", code));
            cc = (ClientCompany) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return cc;
    }

    @Override
    public List<ClientCompany> getAllClientCompanies() {
        List<ClientCompany> cclist = new ArrayList<>();
        try {
            startOperation();
            cclist = searchAll(ClientCompany.class);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return cclist;
    }
    
    @Override
    public ClientCompany getClientCompanyByName(String name) {
        ClientCompany cc = new ClientCompany();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.eq("name", name));
            cc = (ClientCompany) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return cc;
    }

    @Override
    public int getClientCompanyId(String clientCompanyName) {
        ClientCompany cc = new ClientCompany();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.eq("name", clientCompanyName));
            cc = (ClientCompany) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return cc.getId();
    }

    @Override
    public void createAddress(ClientCompanyAddress address) {
        try {
            startOperation();
            createUpdateObject(address);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
    }

    @Override
    public void createEmailAddress(ClientCompanyEmailAddress emailAddress) {
        try {
            startOperation();
            createUpdateObject(emailAddress);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
    }

    @Override
    public void createPhoneNumber(ClientCompanyPhoneNumber phoneNumber) {
        try {
            startOperation();
            createUpdateObject(phoneNumber);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
    }

    @Override
    public List<ClientCompanyAddress> getClientCompanyAddresses(int clientCompanyId) {
        List<ClientCompanyAddress> addy_list = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompanyAddress.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            addy_list = criteria.list();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return addy_list;
    }

    @Override
    public ClientCompanyAddress getClientCompanyAddress(int id) {
        ClientCompanyAddress addy = new ClientCompanyAddress();
        try {
            startOperation();
            addy = (ClientCompanyAddress) searchObject(ClientCompanyAddress.class, id);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return addy;
    }

    @Override
    public List<ClientCompanyEmailAddress> getClientCompanyEmailAddresses(int clientCompanyId) {
        List<ClientCompanyEmailAddress> email_list = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompanyEmailAddress.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            email_list = criteria.list();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return email_list;
    }

    @Override
    public ClientCompanyEmailAddress getClientCompanyEmailAddress(int id) {
        ClientCompanyEmailAddress email = new ClientCompanyEmailAddress();
        try {
            startOperation();
            email = (ClientCompanyEmailAddress) searchObject(ClientCompanyEmailAddress.class, id);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return email;
    }

    @Override
    public List<ClientCompanyPhoneNumber> getClientCompanyPhoneNumbers(int clientCompanyId) {
        List<ClientCompanyPhoneNumber> phone_list = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompanyPhoneNumber.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            phone_list = criteria.list();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return phone_list;
    }

    @Override
    public ClientCompanyPhoneNumber getClientCompanyPhoneNumber(int id) {
        ClientCompanyPhoneNumber phone = new ClientCompanyPhoneNumber();
        try {
            startOperation();
            phone = (ClientCompanyPhoneNumber) searchObject(ClientCompanyPhoneNumber.class, id);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return phone;
    }

    @Override
    public int getNumberOfShareholders(int clientCompanyId) {
        int count = 0;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(HolderCompanyAccount.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            List<HolderCompanyAccount> accts = criteria.list();
            for (HolderCompanyAccount hca : accts) {
                if (hca.getShareUnits() != null && hca.getShareUnits() > 0) {
                    ++count;
                }
            }
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count;
    }

    @Override
    public int getNumberOfBondholders(int clientCompanyId) {
        int count = 0;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(BondOffer.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            List<BondOffer> offers = criteria.list();
            for (BondOffer bo : offers) {
                List<HolderBondAccount> accts = new ArrayList<>(bo.getHolderBondAccounts());
                for (HolderBondAccount hba : accts) {
                    if (!Objects.equals(hba.getRemainingPrincipalValue(), hba.getStartingPrincipalValue())) {
                        ++count;
                    }
                }
            }
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count;
    }

    @Override
    public double getUnitPrice(int clientCompanyId) {
        double price = 0.00;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ShareQuotation.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            if (criteria.list() != null && !criteria.list().isEmpty()) {
                ShareQuotation quotation = (ShareQuotation) criteria.list().get(0);
                price = quotation.getUnitPrice();
            }
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
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
            rollback();
            return created;
        } finally {
            closeSession();
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
            
            commit();
            updated = true;
            return updated;
        } catch (Exception ex) {
            logger.error("error updating client company - ", ex);
            rollback();
            return updated;
        } finally {
            closeSession();
        }
    }

    @Override
    public void createBondOffer(BondOffer bondOffer) {
        try {
            startOperation();
            createUpdateObject(bondOffer);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
    }

    @Override
    public boolean checkBondOffer(int bondOfferId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(BondOffer.class)
                    .add(Restrictions.idEq(bondOfferId))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean bondOfferIsValid(int bondOfferId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(BondOffer.class)
                    .add(Restrictions.eq("valid", true))
                    .add(Restrictions.idEq(bondOfferId))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public List<BondOffer> getAllBondOffers() {
        List<BondOffer> offerlist = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(BondOffer.class)
                    .add(Restrictions.eq("valid", true));
            offerlist = criteria.list();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return offerlist;
    }

    @Override
    public List<BondOffer> getAllBondOffersWithNonValid() {
        List<BondOffer> offerlist = new ArrayList<>();
        try {
            startOperation();
            offerlist = searchAll(BondOffer.class);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return offerlist;
    }

    @Override
    public void createInitialPublicOffer(InitialPublicOffer initialPublicOffer) {
        try {
            startOperation();
            createUpdateObject(initialPublicOffer);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
    }

    @Override
    public boolean clientCompanyHasIpo(int clientCompanyId) {
        int count = 0;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.idEq(clientCompanyId));
            ClientCompany cc = (ClientCompany) criteria.list().get(0);
            count = cc.getInitialPublicOffers().size();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public InitialPublicOffer getClientCompanyIpo(int clientCompanyId) {
        InitialPublicOffer ipo = new InitialPublicOffer();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(InitialPublicOffer.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            ipo = (InitialPublicOffer) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return ipo;
    }

    @Override
    public InitialPublicOffer getIpo(int ipoId) {
        InitialPublicOffer ipo = new InitialPublicOffer();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(InitialPublicOffer.class)
                    .add(Restrictions.idEq(ipo));
            ipo = (InitialPublicOffer) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return ipo;
    }

    @Override
    public InitialPublicOffer getActiveClientCompanyIpo(int clientCompanyId) {
        InitialPublicOffer ipo = new InitialPublicOffer();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(InitialPublicOffer.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId))
                    .add(Restrictions.eq("ipoClosed", false));
            ipo = (InitialPublicOffer) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return ipo;
    }

    @Override
    public InitialPublicOffer getActiveIpo(int ipoId) {
        InitialPublicOffer ipo = new InitialPublicOffer();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(InitialPublicOffer.class)
                    .add(Restrictions.idEq(ipo))
                    .add(Restrictions.eq("ipoClosed", false));
            ipo = (InitialPublicOffer) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return ipo;
    }

    @Override
    public boolean checkInitialPublicOffer(int ipoId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(InitialPublicOffer.class)
                    .add(Restrictions.idEq(ipoId));
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkActiveInitialPublicOffer(int ipoId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(InitialPublicOffer.class)
                    .add(Restrictions.eq("ipoClosed", false))
                    .add(Restrictions.idEq(ipoId));
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public List<InitialPublicOffer> getAllIpos() {
        List<InitialPublicOffer> all = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(InitialPublicOffer.class);
            all = criteria.list();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return all;
    }

    @Override
    public List<InitialPublicOffer> getAllActiveIpos() {
        List<InitialPublicOffer> all = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(InitialPublicOffer.class)
                    .add(Restrictions.eq("ipoClosed", false));
            all = criteria.list();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return all;
    }

    @Override
    public List<IpoApplication> getActiveIpoApplications(int ipoId) {
        List<IpoApplication> all = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(IpoApplication.class)
                    .add(Restrictions.eq("initialPublicOffer.id", ipoId))
                    .add(Restrictions.eq("canceled", false));
            all = criteria.list();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return all;
    }

    @Override
    public List<IpoApplication> getAllIpoApplications(int ipoId) {
        List<IpoApplication> all = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(IpoApplication.class)
                    .add(Restrictions.eq("initialPublicOffer.id", ipoId));
            all = criteria.list();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return all;
    }

    @Override
    public void createPrivatePlacement(PrivatePlacement privatePlacement) {
        try {
            startOperation();
            createUpdateObject(privatePlacement);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
    }

    @Override
    public List<PrivatePlacementApplication> getAllPrivatePlacementApplications(int ppId) {
        List<PrivatePlacementApplication> all = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PrivatePlacementApplication.class)
                    .add(Restrictions.eq("privatePlacement.id", ppId));
            all = criteria.list();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return all;
    }

    @Override
    public List<PrivatePlacementApplication> getAllActivePrivatePlacementApplications(int ppId) {
        List<PrivatePlacementApplication> all = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PrivatePlacementApplication.class)
                    .add(Restrictions.eq("privatePlacement.id", ppId))
                    .add(Restrictions.eq("canceled", false));
            all = criteria.list();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return all;
    }

    @Override
    public List<ShareQuotation> retrieveShareUnitQuatationList() {
        List<ShareQuotation> result = new ArrayList<>();
        try {
            startOperation();
            result = searchAll(ShareQuotation.class);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return result;
    }

    @Override
    public void uploadShareQuotation(ShareQuotation shareQuotation) {
        try {
            startOperation();
            createUpdateObject(shareQuotation);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
    }

    @Override
    public boolean uploadShareQuotation(List<ShareQuotation> shareQuotations) {
        boolean created = false;
        try {
            startOperation();
            shareQuotations.stream().forEach((quotation) -> {
                createUpdateObject(quotation);
            });
            commit();
            created = true;
            return created;
        } catch (Exception ex) {
            logger.error("error uploading share quotations - ", ex);
            rollback();
            return created;
        } finally {
            closeSession();
        }
    }

    @Override
    public boolean companyHasShareQuotation(String clientCompanyCode) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ShareQuotation.class)
                    .createAlias("clientCompany", "c")
                    .add(Restrictions.eq("c.code", clientCompanyCode))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public ShareQuotation getShareQuotation(String clientCompanyCode) {
        ShareQuotation sq = new ShareQuotation();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ShareQuotation.class)
                    .createAlias("clientCompany", "c")
                    .add(Restrictions.eq("c.code", clientCompanyCode));
            sq = (ShareQuotation) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return sq;
    }

    @Override
    public boolean checkClientCompanyForShareholders(String clientCompanyName) {
        int countAccounts = 0;
        int countCertificates = 0;
        try {
            startOperation();
            List result = getSession().createCriteria(ClientCompany.class)
                    .add(Restrictions.eq("name", clientCompanyName)).list();
            ClientCompany cc = (ClientCompany) result.get(0);
            List<HolderCompanyAccount> hcalist = new ArrayList<>(cc.getHolderCompanyAccounts());
            for (HolderCompanyAccount hca : hcalist) {
                if (hca.getShareUnits() != null && hca.getShareUnits() > 0
                        && hca.getHolder().getPryHolder() != null && hca.getHolder().getPryHolder()) {
                    ++countAccounts;
                }
            }
            countCertificates = cc.getCertificates().size();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
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
        
        List<ClientCompany> result = new ArrayList<>();
        try {
            startOperation();
            Criteria baseCriteria = getStartCriteria();

            //we should assume the  result will consist of the base client company list
            result = baseCriteria.list();
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

            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return result;
    }

    @Override
    public BondOffer getBondOffer(int bondOfferId) {
        BondOffer bo = new BondOffer();
        try {
            startOperation();
            bo = (BondOffer) searchObject(BondOffer.class, bondOfferId);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return bo;
    }

    @Override
    public boolean checkOpenPrivatePlacement(int clientCompanyId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PrivatePlacement.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public List<BondType> getAllBondTypes() {
        List<BondType> bt_list = new ArrayList<>();
        try {
            startOperation();
            bt_list = searchAll(BondType.class);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return bt_list;
    }

    @Override
    public BondType getBondType(int bondTypeId) {
        BondType type = new BondType();
        try {
            startOperation();
            type = (BondType) searchObject(BondType.class, bondTypeId);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return type;
    }

    @Override
    public List<BondOfferPaymentPlan> getAllBondOfferPaymentPlans() {
        List<BondOfferPaymentPlan> plans = new ArrayList<>();
        try {
            startOperation();
            plans = searchAll(BondOfferPaymentPlan.class);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return plans;
    }

    @Override
    public BondOfferPaymentPlan getBondOfferPaymentPlan(int planId) {
        BondOfferPaymentPlan plan = new BondOfferPaymentPlan();
        try {
            startOperation();
            plan = (BondOfferPaymentPlan) searchObject(BondOfferPaymentPlan.class, planId);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return plan;
    }

    @Override
    public List<NseSector> getAllNseSectors() {
        List<NseSector> sectors = new ArrayList<>();
        try {
            startOperation();
            sectors = searchAll(NseSector.class);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return sectors;
    }

    @Override
    public NseSector getNseSector(int sectorId) {
        NseSector sector = new NseSector();
        try {
            startOperation();
            sector = (NseSector) searchObject(NseSector.class, sectorId);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return sector;
    }

    @Override
    public List<Depository> getAllDepositories() {
        List<Depository> depositories = new ArrayList<>();
        try {
            startOperation();
            depositories = searchAll(Depository.class);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return depositories;
    }

    @Override
    public Depository getDepository(int depositoryId) {
        Depository depository = new Depository();
        try {
            startOperation();
            depository = (Depository) searchObject(Depository.class, depositoryId);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return depository;
    }

    @Override
    public ClearingHouse getClearingHouse(int chId) {
        ClearingHouse clearingHouse = new ClearingHouse();
        try {
            startOperation();
            clearingHouse = (ClearingHouse) searchObject(ClearingHouse.class, chId);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return clearingHouse;
    }

    @Override
    public PrivatePlacement getPrivatePlacement(int ppId) {
        PrivatePlacement pp = new PrivatePlacement();
        try {
            startOperation();
            pp = (PrivatePlacement) searchObject(PrivatePlacement.class, ppId);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return pp;
    }

    @Override
    public boolean checkPrivatePlacement(int ppId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PrivatePlacement.class)
                    .add(Restrictions.idEq(ppId));
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkActivePrivatePlacement(int ppId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PrivatePlacement.class)
                    .add(Restrictions.eq("placementClosed", false))
                    .add(Restrictions.idEq(ppId));
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkClientCompanyPrivatePlacement(int clientCompanyId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PrivatePlacement.class)
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkClientCompanyPrivatePlacement(int clientCompanyId, int ppId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PrivatePlacement.class)
                    .add(Restrictions.idEq(ppId))
                    .add(Restrictions.eq("clientCompany.id", clientCompanyId));
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public ClientCompany getRightsIssueClientCompany(int rightsId) {
        ClientCompany cc = new ClientCompany();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .createAlias("rightsIssues", "r")
                    .add(Restrictions.eq("r.id", rightsId));
            cc = (ClientCompany) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return cc;
    }

    @Override
    public ClientCompany getPrivatePlacementClientCompany(int ppId) {
        ClientCompany cc = new ClientCompany();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .createAlias("privatePlacements", "p")
                    .add(Restrictions.eq("p.id", ppId));
            cc = (ClientCompany) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return cc;
    }

    @Override
    public ClientCompany getIpoClientCompany(int ipoId) {
        ClientCompany cc = new ClientCompany();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(ClientCompany.class)
                    .createAlias("initialPublicOffers", "i")
                    .add(Restrictions.eq("i.id", ipoId));
            cc = (ClientCompany) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            rollback();
            logger.error("error thrown - ", ex);
        } finally {
            closeSession();
        }
        return cc;
    }
}
