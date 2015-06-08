/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.AccountConsolidation;
import org.greenpole.hibernate.entity.Administrator;
import org.greenpole.hibernate.entity.AdministratorEmailAddress;
import org.greenpole.hibernate.entity.AdministratorPhoneNumber;
import org.greenpole.hibernate.entity.AdministratorPostalAddress;
import org.greenpole.hibernate.entity.AdministratorResidentialAddress;
import org.greenpole.hibernate.entity.Bank;
import org.greenpole.hibernate.entity.CompanyAccountConsolidation;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderBondAccountId;
import org.greenpole.hibernate.entity.HolderChangeType;
import org.greenpole.hibernate.entity.HolderChanges;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderCompanyAccountId;
import org.greenpole.hibernate.entity.HolderEmailAddress;
import org.greenpole.hibernate.entity.HolderPhoneNumber;
import org.greenpole.hibernate.entity.HolderPostalAddress;
import org.greenpole.hibernate.entity.HolderResidentialAddress;
import org.greenpole.hibernate.entity.HolderSignature;
import org.greenpole.hibernate.entity.HolderType;
import org.greenpole.hibernate.entity.PowerOfAttorney;
import org.greenpole.hibernate.entity.ProcessedTransaction;
import org.greenpole.hibernate.entity.ProcessedTransactionHolder;
import org.greenpole.hibernate.entity.ProcessedTransactionHolderId;
import org.greenpole.hibernate.entity.Stockbroker;
import org.greenpole.hibernate.entity.TransactionType;
import org.greenpole.hibernate.exception.GreenpoleQueryException;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.greenpole.hibernate.query.HolderComponentQuery;
import org.greenpole.hibernate.util.Descriptor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akin
 */
public class HolderComponentQueryImpl extends GeneralisedAbstractDao implements HolderComponentQuery {
    private static final Logger logger = LoggerFactory.getLogger(HolderComponentQueryImpl.class);

    @Override
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, List<HolderResidentialAddress> residentialAddresses, 
            List<HolderPostalAddress> postalAddresses, List<HolderEmailAddress> emailAddresses, List<HolderPhoneNumber> phoneNumbers) {
        boolean created = false;
        try {
            startOperation();
            //create holder
            createUpdateObject(holder);
            
            //create company account
            if (holderCompanyAccount != null) {
                holderCompanyAccount.getId().setHolderId(holder.getId());
                createUpdateObject(holderCompanyAccount);
            }
            
            //create residential address
            if (residentialAddresses != null) {
                for (HolderResidentialAddress res : residentialAddresses) {
                    res.setHolder(holder);
                    createUpdateObject(res);
                }
            }
            
            //create postal address
            if (postalAddresses != null) {
                for (HolderPostalAddress pos : postalAddresses) {
                    pos.setHolder(holder);
                    createUpdateObject(pos);
                }
            }
            
            //create email address
            if (emailAddresses != null) {
                for (HolderEmailAddress email : emailAddresses) {
                    email.setHolder(holder);
                    createUpdateObject(email);
                }
            }
            
            //create phone numbers
            if (phoneNumbers != null) {
                for (HolderPhoneNumber phone : phoneNumbers) {
                    phone.setHolder(holder);
                    createUpdateObject(phone);
                }
            }
            
            getTransaction().commit();
            created = true;
            return created;
        } catch (Exception ex) {
            logger.error("error creating shareholder account - ", ex);
            getTransaction().rollback();
            return created;
        }
    }

    @Override
    public void createUpdateHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount) {
        startOperation();
        createUpdateObject(holderCompanyAccount);
        getTransaction().commit();
    }

    @Override
    public boolean createHolderAccount(Holder holder, HolderBondAccount holderBondAccount, List<HolderResidentialAddress> residentialAddresses,
            List<HolderPostalAddress> postalAddresses, List<HolderEmailAddress> emailAddresses, List<HolderPhoneNumber> phoneNumbers) {
        boolean created = false;
        try {
            startOperation();
            //create holder
            createUpdateObject(holder);
            
            //create bond account
            if (holderBondAccount != null) {
                holderBondAccount.getId().setHolderId(holder.getId());
                createUpdateObject(holderBondAccount);
            }
            
            //create residential address
            if (residentialAddresses != null) {
                for (HolderResidentialAddress res : residentialAddresses) {
                    res.setHolder(holder);
                    createUpdateObject(res);
                }
            }
            
            //create postal address
            if (postalAddresses != null) {
                for (HolderPostalAddress pos : postalAddresses) {
                    pos.setHolder(holder);
                    createUpdateObject(pos);
                }
            }
            
            //create email address
            if (emailAddresses != null) {
                for (HolderEmailAddress email : emailAddresses) {
                    email.setHolder(holder);
                    createUpdateObject(email);
                }
            }
            
            //create phone numbers
            if (phoneNumbers != null) {
                for (HolderPhoneNumber phone : phoneNumbers) {
                    phone.setHolder(holder);
                    createUpdateObject(phone);
                }
            }
            
            getTransaction().commit();
            created = true;
            return created;
        } catch (Exception ex) {
            logger.error("error creating bond-holder account - ", ex);
            getTransaction().rollback();
            return created;
        }
    }

    @Override
    public void createUpdateHolderBondAccount(HolderBondAccount holderBondAccount) {
        startOperation();
        createUpdateObject(holderBondAccount);
        getTransaction().commit();
    }

    @Override
    public boolean updateHolderAccount(Holder holder, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses,
            List<HolderPhoneNumber> phoneNumbers, List<HolderEmailAddress> emailAddresses, List<HolderResidentialAddress> deletedResAddresses,
            List<HolderPostalAddress> deletedPosAddresses, List<HolderPhoneNumber> deletedPhoneNumbers, List<HolderEmailAddress> deletedEmailAddresses,
            List<HolderChanges> changes) {
        boolean created = false;
        try {
            startOperation();
            //update holder
            createUpdateObject(holder);
            
            //update residential address
            if (residentialAddresses != null) {
                for (HolderResidentialAddress res : residentialAddresses) {
                    res.setHolder(holder);
                    createUpdateObject(res);
                }
            }
            
            //update postal address
            if (postalAddresses != null) {
                for (HolderPostalAddress pos : postalAddresses) {
                    pos.setHolder(holder);
                    createUpdateObject(pos);
                }
            }
            
            //update email address
            if (emailAddresses != null) {
                for (HolderEmailAddress email : emailAddresses) {
                    email.setHolder(holder);
                    createUpdateObject(email);
                }
            }
            
            //update phone numbers
            if (phoneNumbers != null) {
                for (HolderPhoneNumber phone : phoneNumbers) {
                    phone.setHolder(holder);
                    createUpdateObject(phone);
                }
            }
            
            //register changes
            if (changes != null) {
                for (HolderChanges change : changes) {
                    createUpdateObject(change);
                }
            }
            
            //delete resident address
            if (deletedResAddresses != null) {
                for (HolderResidentialAddress res : deletedResAddresses) {
                    res.setHolder(holder);
                    removeObject(res);
                }
            }
            
            //delete postal address
            if (deletedPosAddresses != null) {
                for (HolderPostalAddress pos : deletedPosAddresses) {
                    pos.setHolder(holder);
                    removeObject(pos);
                }
            }
            
            //delete email address
            if (deletedEmailAddresses != null) {
                for (HolderEmailAddress email : deletedEmailAddresses) {
                    email.setHolder(holder);
                    removeObject(email);
                }
            }
            
            //delete phone address
            if (deletedPhoneNumbers != null) {
                for (HolderPhoneNumber phone : deletedPhoneNumbers) {
                    phone.setHolder(holder);
                    removeObject(phone);
                }
            }
            
            getTransaction().commit();
            created = true;
            return created;
        } catch (Exception ex) {
            logger.error("error creating/updating holder account - ", ex);
            getTransaction().rollback();
            return created;
        }
    }

    @Override
    public void updateHolderAccountForTranspose(Holder holder) {
        startOperation();
        createUpdateObject(holder);
        getTransaction().commit();
    }

    @Override
    public boolean checkHolderAccount(int holderId) {
        Holder h = new Holder();
        h.setPryHolder(true);
        
        startOperation();
        Criteria criteria = getSession().createCriteria(Holder.class)
                .add(Example.create(h).enableLike())
                .add(Restrictions.idEq(holderId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkHolderAccount(String chn) {
        Holder h = new Holder();
        h.setPryHolder(true);
        h.setMerged(false);
        
        startOperation();
        Criteria criteria = getSession().createCriteria(Holder.class)
                .add(Example.create(h).enableLike())
                .add(Restrictions.eq("chn", chn))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkHolderCompanyAccount(int holderId, int clientCompanyId) {
        HolderCompanyAccount hca = new HolderCompanyAccount();
        hca.setHolderCompAccPrimary(true);
        hca.setMerged(false);
        
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderCompanyAccount.class)
                .add(Example.create(hca).enableLike())
                .add(Restrictions.eq("id.holderId", holderId))
                .add(Restrictions.eq("id.clientCompanyId", clientCompanyId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkHolderBondAccount(int holderId, int bondOfferId) {
        HolderBondAccount hba = new HolderBondAccount();
        hba.setHolderBondAcctPrimary(true);
        hba.setMerged(false);
        
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderBondAccount.class)
                .add(Example.create(hba).enableLike())
                .add(Restrictions.eq("id.holderId", holderId))
                .add(Restrictions.eq("id.bondOfferId", bondOfferId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public List<HolderChanges> queryHolderChanges(String descriptor, HolderChanges searchParams, String startDate, String endDate, String dateFormat) {
        //descriptor must be date:none / date:exact / date:between / date:before / date:after
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        HolderChangeType changeType = searchParams.getHolderChangeType();
        
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderChanges.class, "hc")
                .add(Example.create(searchParams).enableLike())
                .createCriteria("hc.holderChangeType", "t", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(changeType).enableLike().ignoreCase());
        
        if (descriptor.equalsIgnoreCase("exact")) {
            try {
                criteria.add(Restrictions.eq("hc.changeDate", formatter.parse(startDate)));
                List<HolderChanges> returnlist = criteria.list();
                getTransaction().commit();
                return returnlist;
            } catch (ParseException ex) {
                logger.error("error parsing date - ", ex);
            }
        }
        
        if (descriptor.equalsIgnoreCase("between")) {
            try {
                criteria.add(Restrictions.between("hc.changeDate", formatter.parse(startDate), formatter.parse(endDate)));
                List<HolderChanges> returnlist = criteria.list();
                getTransaction().commit();
                return returnlist;
            } catch (ParseException ex) {
                logger.error("error parsing date - ", ex);
            }
        }
        
        if (descriptor.equalsIgnoreCase("before")) {
            try {
                criteria.add(Restrictions.lt("hc.changeDate", formatter.parse(startDate)));
                List<HolderChanges> returnlist = criteria.list();
                getTransaction().commit();
                return returnlist;
            } catch (ParseException ex) {
                logger.error("error parsing date - ", ex);
            }
        }
        
        if (descriptor.equalsIgnoreCase("after")) {
            try {
                criteria.add(Restrictions.gt("hc.changeDate", formatter.parse(startDate)));
                List<HolderChanges> returnlist = criteria.list();
                getTransaction().commit();
                return returnlist;
            } catch (ParseException ex) {
                logger.error("error parsing date - ", ex);
            }
        }
        
        List<HolderChanges> returnlist = criteria.list();
        getTransaction().commit();
        return returnlist;
    }

    @Override
    public List<HolderChangeType> getAllChangeTypes() {
        startOperation();
        List<HolderChangeType> types = searchAll(HolderChangeType.class);
        getTransaction().commit();
        return types;
    }

    @Override
    public HolderChangeType getChangeType(int typeId) {
        startOperation();
        HolderChangeType type = (HolderChangeType) searchObject(HolderChangeType.class, typeId);
        getTransaction().commit();
        return type;
    }

    @Override
    public Holder getHolder(int holderId) {
        startOperation();
        Holder h = (Holder) searchObject(Holder.class, holderId);
        getTransaction().commit();
        return h;
    }

    @Override
    public Holder getHolder(String chn) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Holder.class)
                .add(Restrictions.eq("chn", chn));
        Holder h = (Holder) criteria.list().get(0);
        getTransaction().commit();
        return h;
    }

    @Override
    public HolderCompanyAccount getHolderCompanyAccount(int holderId, int clientCompanyId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderCompanyAccount.class)
                .add(Restrictions.eq("id.holderId", holderId))
                .add(Restrictions.eq("id.clientCompanyId", clientCompanyId))
                .add(Restrictions.eq("holderCompAccPrimary", true));
        HolderCompanyAccount hca = (HolderCompanyAccount) criteria.list().get(0);
        getTransaction().commit();
        return hca;
    }

    @Override
    public HolderBondAccount getHolderBondAccount(int holderId, int bondOfferId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderBondAccount.class)
                .add(Restrictions.eq("id.holderId", holderId))
                .add(Restrictions.eq("id.bondOfferId", bondOfferId))
                .add(Restrictions.eq("holderBondAcctPrimary", true));
        HolderBondAccount hba = (HolderBondAccount) criteria.list().get(0);
        getTransaction().commit();
        return hba;
    }

    @Override
    public Administrator getAdministrator(int administratorId) {
        startOperation();
        Administrator admin = (Administrator) searchObject(Administrator.class, administratorId);
        getTransaction().commit();
        return admin;
    }
    
    @Override
    public List<Holder> queryShareholderAccount(String descriptor, Holder searchParams, Map<String, Integer> shareUnits_search, Map<String, Integer> totalShareHoldings_search) {
        Descriptor descriptorUtil = new Descriptor();
        
        //intial shareholder object, in case holder isnt searched
        Holder initialHolder = new Holder();
        initialHolder.setPryHolder(true);
        initialHolder.setMerged(false);
        
        //descriptor must be (default value) = holder:none;units:none;totalHoldings:none
        Map<String, String> descriptorSplits = descriptorUtil.decipherDescriptor(descriptor);
        String holderDescriptor = descriptorSplits.get("holder");
        String unitsDescriptor = descriptorSplits.get("units");
        String totalHoldingsDescriptor = descriptorSplits.get("totalHoldings");
        try {
            startOperation();
            Criteria baseCriteria = getStartCriteria();

            //we should assume that the result will consist of all base holders
            List<Holder> result;
            Criteria shareHolderUnitCriteria;
            Criteria shareHolderSearchCriteria = baseCriteria; //shareholder search criteria must be initialised since it is being used in an isolated if statement
            //under the share unit price search (see if statement for clarification).

            if (holderDescriptor.equalsIgnoreCase("exact")) {
                shareHolderSearchCriteria = searchShareholderAccordingToObject(baseCriteria, searchParams);
                result = shareHolderSearchCriteria.list();
            } else {
                baseCriteria.add(Example.create(initialHolder).enableLike());//ensure that only primary and non-merged holders are filtered out of list
                result = baseCriteria.list();
            }

            //if shareholder was searched for, pass shareholder search criteria into unit search. Otherwise, use base criteria
            if (!unitsDescriptor.equalsIgnoreCase("none") && holderDescriptor.equalsIgnoreCase("exact")) {
                shareHolderUnitCriteria = searchShareUnit(shareHolderSearchCriteria, unitsDescriptor, holderDescriptor, shareUnits_search);
                result = shareHolderUnitCriteria.list();
            } else if (!unitsDescriptor.equalsIgnoreCase("none") && !holderDescriptor.equalsIgnoreCase("exact")) {
                shareHolderUnitCriteria = searchShareUnit(baseCriteria, unitsDescriptor, holderDescriptor, shareUnits_search);
                result = shareHolderUnitCriteria.list();
            }

            if (!totalHoldingsDescriptor.equalsIgnoreCase("none")) {
                result = searchTotalShareHoldings(result, totalHoldingsDescriptor, totalShareHoldings_search);
            }

            //ensure that only shareholders are returned
            List<Holder> shareholders = new ArrayList<>();
            for (Holder holder : result) {
                if (holder.getHolderCompanyAccounts() != null && holder.getHolderCompanyAccounts().size() > 0) {
                    Iterator it = holder.getHolderCompanyAccounts().iterator();
                    while (it.hasNext()) {
                        HolderCompanyAccount acct = (HolderCompanyAccount) it.next();
                        if (acct.getShareUnits() != null && acct.getShareUnits() > 0) {
                            shareholders.add(holder);
                        }
                    }
                }
            }

            getTransaction().commit();
            
            return shareholders;
        } finally {
            if (getTransaction() != null && !getTransaction().wasCommitted())
                getTransaction().rollback();
        }
    }

    @Override
    public List<Holder> queryBondholderAccount(String descriptor, Holder searchParams, Map<String, Integer> bondUnits_search, Map<String, Integer> totalBondHoldings_search) {
        Descriptor descriptorUtil = new Descriptor();
        
        //intial shareholder object, in case holder isnt searched
        Holder initialHolder = new Holder();
        initialHolder.setPryHolder(true);
        initialHolder.setMerged(false);
        
        //descriptor must be (default value) = holder:none;units:none;totalHoldings:none
        Map<String, String> descriptorSplits = descriptorUtil.decipherDescriptor(descriptor);
        String holderDescriptor = descriptorSplits.get("holder");
        String unitsDescriptor = descriptorSplits.get("units");
        String totalHoldingsDescriptor = descriptorSplits.get("totalHoldings");
        
        try {
            startOperation();
            Criteria baseCriteria = getStartCriteria();
            
            //we should assume that the result will consist of all base holders (set in holderDescriptor if statement)
            List<Holder> result;
            Criteria bondholderUnitCriteria;
            Criteria bondholderSearchCriteria = baseCriteria; //bond-holder search criteria must be initialised since it is being used in an isolated if statement
            //under the bond unit search (see if statement for clarification).

            if (holderDescriptor.equalsIgnoreCase("exact")) {
                bondholderSearchCriteria = searchBondholderAccordingToObject(baseCriteria, searchParams);
                result = bondholderSearchCriteria.list();
            } else {
                baseCriteria.add(Example.create(initialHolder).enableLike());//ensure that only primary and non-merged holders are filtered out of list
                result = baseCriteria.list();
            }

            //if bond-holder was searched for, pass bond-holder search criteria into unit search. Otherwise, use base criteria
            if (!unitsDescriptor.equalsIgnoreCase("none") && holderDescriptor.equalsIgnoreCase("exact")) {
                bondholderUnitCriteria = searchBondUnit(bondholderSearchCriteria, unitsDescriptor, holderDescriptor, bondUnits_search);
                result = bondholderUnitCriteria.list();
            } else if (!unitsDescriptor.equalsIgnoreCase("none") && !holderDescriptor.equalsIgnoreCase("exact")) {
                bondholderUnitCriteria = searchBondUnit(baseCriteria, unitsDescriptor, holderDescriptor, bondUnits_search);
                result = bondholderUnitCriteria.list();
            }

            if (!totalHoldingsDescriptor.equalsIgnoreCase("none")) {
                result = searchTotalBondHoldings(result, totalHoldingsDescriptor, totalBondHoldings_search);
            }

            //ensure that only bondholders are returned
            List<Holder> bondholders = new ArrayList<>();
            for (Holder holder : result) {
                if (holder.getHolderBondAccounts() != null && holder.getHolderBondAccounts().size() > 0) {
                    Iterator it = holder.getHolderBondAccounts().iterator();
                    while (it.hasNext()) {
                        HolderBondAccount acct = (HolderBondAccount) it.next();
                        if (acct.getBondUnits() != null && acct.getBondUnits() > 0) {
                            bondholders.add(holder);
                            break;
                        }
                    }
                }
            }

            getTransaction().commit();

            return bondholders;
        } finally {
            if (getTransaction() != null && !getTransaction().wasCommitted())
                getTransaction().rollback();
        }
    }

    @Override
    public List<HolderResidentialAddress> getHolderResidentialAddresses(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderResidentialAddress.class)
                .add(Restrictions.eq("holder.id", holderId));
        List<HolderResidentialAddress> returnlist = criteria.list();
        getTransaction().commit();
        return returnlist;
    }

    @Override
    public HolderResidentialAddress getHolderResidentialAddress(int id) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderResidentialAddress.class)
                .add(Restrictions.idEq(id));
        HolderResidentialAddress addy = (HolderResidentialAddress) criteria.list().get(0);
        getTransaction().commit();
        return addy;
    }

    @Override
    public List<HolderPostalAddress> getHolderPostalAddresses(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderPostalAddress.class)
                .add(Restrictions.eq("holder.id", holderId));
        List<HolderPostalAddress> returnlist = criteria.list();
        getTransaction().commit();
        return returnlist;
    }

    @Override
    public HolderPostalAddress getHolderPostalAddress(int id) {
        startOperation();
        HolderPostalAddress addy = (HolderPostalAddress) searchObject(HolderPostalAddress.class, id);
        getTransaction().commit();
        return addy;
    }

    @Override
    public List<HolderPhoneNumber> getHolderPhoneNumbers(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderPhoneNumber.class)
                .add(Restrictions.eq("holder.id", holderId));
        List<HolderPhoneNumber> returnlist = criteria.list();
        getTransaction().commit();
        return returnlist;
    }

    @Override
    public HolderPhoneNumber getHolderPhoneNumber(int id) {
        startOperation();
        HolderPhoneNumber phone = (HolderPhoneNumber) searchObject(HolderPhoneNumber.class, id);
        getTransaction().commit();
        return phone;
    }

    @Override
    public List<HolderEmailAddress> getHolderEmailAddresses(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderEmailAddress.class)
                .add(Restrictions.eq("holder.id", holderId));
        List<HolderEmailAddress> returnlist = criteria.list();
        getTransaction().commit();
        return returnlist;
    }

    @Override
    public HolderEmailAddress getHolderEmailAddress(int id) {
        startOperation();
        HolderEmailAddress email = (HolderEmailAddress) searchObject(HolderEmailAddress.class, id);
        getTransaction().commit();
        return email;
    }

    @Override
    public AdministratorResidentialAddress getAdministratorResidentialAddress(int id) {
        startOperation();
        AdministratorResidentialAddress addy = (AdministratorResidentialAddress) searchObject(AdministratorResidentialAddress.class, id);
        getTransaction().commit();
        return addy;
    }

    @Override
    public AdministratorPostalAddress getAdministratorPostalAddress(int id) {
        startOperation();
        AdministratorPostalAddress addy = (AdministratorPostalAddress) searchObject(AdministratorPostalAddress.class, id);
        getTransaction().commit();
        return addy;
    }

    @Override
    public AdministratorEmailAddress getAdministratorEmailAddress(int id) {
        startOperation();
        AdministratorEmailAddress email = (AdministratorEmailAddress) searchObject(AdministratorEmailAddress.class, id);
        getTransaction().commit();
        return email;
    }

    @Override
    public List<AdministratorEmailAddress> getAdministratorEmailAddresses(int administratorId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(AdministratorEmailAddress.class)
                .add(Restrictions.eq("administrator.id", administratorId));
        List <AdministratorEmailAddress> emails = criteria.list();
        getTransaction().commit();
        return emails;
    }

    @Override
    public AdministratorPhoneNumber getAdministratorPhoneNumber(int id) {
        startOperation();
        AdministratorPhoneNumber phone = (AdministratorPhoneNumber) searchObject(AdministratorPhoneNumber.class, id);
        getTransaction().commit();
        return phone;
    }

    @Override
    public List<AdministratorPhoneNumber> getAdministratorPhoneNumbers(int administratorId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(AdministratorPhoneNumber.class)
                .add(Restrictions.eq("administrator.id", administratorId));
        List<AdministratorPhoneNumber> phones = criteria.list();
        getTransaction().commit();
        return phones;
    }

    @Override
    public boolean transferShareUnits(HolderCompanyAccount sender, HolderCompanyAccount receiver, int shareUnits, int transferTypeId) {
        boolean transferred = false;
        try {
            ProcessedTransaction pt = new ProcessedTransaction();
            ProcessedTransactionHolder pt_sender = new ProcessedTransactionHolder();
            ProcessedTransactionHolderId pt_sender_id = new ProcessedTransactionHolderId();
            ProcessedTransactionHolder pt_receiver = new ProcessedTransactionHolder();
            ProcessedTransactionHolderId pt_receiver_id = new ProcessedTransactionHolderId();
            
            startOperation();
            
            sender = (HolderCompanyAccount) getSession().merge(sender);
            receiver = (HolderCompanyAccount) getSession().merge(receiver);
            TransactionType type = (TransactionType) searchObject(TransactionType.class, transferTypeId);
            
            int senderUnits = sender.getShareUnits();
            sender.setShareUnits(senderUnits - shareUnits);
            createUpdateObject(receiver);

            int receiverUnits = receiver.getShareUnits();
            receiver.setShareUnits(receiverUnits + shareUnits);
            createUpdateObject(receiver);
            
            processTransactionShareTransfer(pt, sender, type, pt_sender_id, pt_sender, shareUnits, pt_receiver_id, receiver, pt_receiver);

            getTransaction().commit();
            transferred = true;
            return transferred;
        } catch (Exception ex) {
            logger.error("share transfer transaction error - ", ex);
            getTransaction().rollback();
            return transferred;
        }
    }

    @Override
    public boolean transferBondUnits(HolderBondAccount sender, HolderBondAccount receiver, int bondUnits, double unitPrice, int transferTypeId) {
        boolean transferred = false;
        
        int unitsAfter;
        double newPrincipalValue;
        double formerStartingPrincipalValue;
        
        try {
            ProcessedTransaction pt = new ProcessedTransaction();
            ProcessedTransactionHolder pt_sender = new ProcessedTransactionHolder();
            ProcessedTransactionHolderId pt_sender_id = new ProcessedTransactionHolderId();
            ProcessedTransactionHolder pt_receiver = new ProcessedTransactionHolder();
            ProcessedTransactionHolderId pt_receiver_id = new ProcessedTransactionHolderId();
            
            startOperation();
            
            sender = (HolderBondAccount) getSession().merge(sender);
            receiver = (HolderBondAccount) getSession().merge(receiver);
            TransactionType type = (TransactionType) searchObject(TransactionType.class, transferTypeId);
            
            int senderUnits = sender.getBondUnits();
            unitsAfter = senderUnits - bondUnits;
            newPrincipalValue = unitsAfter * unitPrice;
            
            sender.setBondUnits(unitsAfter);
            sender.setRemainingPrincipalValue(newPrincipalValue);
            createUpdateObject(receiver);
            
            int receiverUnits = receiver.getBondUnits();
            unitsAfter = receiverUnits + bondUnits;
            newPrincipalValue = unitsAfter * unitPrice;
            formerStartingPrincipalValue = receiver.getStartingPrincipalValue();
            
            receiver.setBondUnits(receiverUnits + bondUnits);
            receiver.setStartingPrincipalValue(formerStartingPrincipalValue + newPrincipalValue);
            receiver.setRemainingPrincipalValue(newPrincipalValue);
            createUpdateObject(receiver);
            
            processTransactionBondTransfer(pt, sender, type, pt_sender_id, pt_sender, bondUnits, pt_receiver_id, receiver, pt_receiver);
            
            getTransaction().commit();
            transferred = true;
            return transferred;
        } catch (Exception ex) {
            logger.error("share transfer transaction error - ", ex);
            getTransaction().rollback();
            return transferred;
        }
    }

    @Override
    public boolean hasCompanyAccount(int holderId) {
        startOperation();
        boolean hasAcct = false;
        Holder h = (Holder) searchObject(Holder.class, holderId);
        List<HolderCompanyAccount> hca_list = new ArrayList<>(h.getHolderCompanyAccounts());
        for (HolderCompanyAccount hca : hca_list) {
            if (hca.getShareUnits() != null && hca.getShareUnits() > 0 && hca.getHolderCompAccPrimary()) {
                hasAcct = true;
                break;
            }
        }
        getTransaction().commit();
        return hasAcct;
    }

    @Override
    public boolean hasBondAccount(int holderId) {
        startOperation();
        boolean hasAcct = false;
        Holder h = (Holder) searchObject(Holder.class, holderId);
        List<HolderBondAccount> hba_list = new ArrayList<>(h.getHolderBondAccounts());
        for (HolderBondAccount hba : hba_list) {
            if (hba.getBondUnits() != null && hba.getBondUnits() > 0 && hba.getHolderBondAcctPrimary() && !hba.getMerged()) {
                hasAcct = true;
                break;
            }
        }
        getTransaction().commit();
        return hasAcct;
    }

    @Override
    public List<HolderCompanyAccount> getAllHolderCompanyAccounts(int holderId) {
        HolderCompanyAccount hca = new HolderCompanyAccount();
        hca.setHolderCompAccPrimary(true);
        hca.setMerged(false);
        
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderCompanyAccount.class)
                .add(Example.create(hca).enableLike())
                .add(Restrictions.eq("id.holderId", holderId));
        List<HolderCompanyAccount> returnlist = criteria.list();
        getTransaction().commit();
        return returnlist;
    }

    @Override
    public List<HolderBondAccount> getAllHolderBondAccounts(int holderId) {
        HolderBondAccount hba = new HolderBondAccount();
        hba.setHolderBondAcctPrimary(true);
        hba.setMerged(false);
        
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderBondAccount.class)
                .add(Example.create(hba).enableLike())
                .add(Restrictions.eq("id.holderId", holderId));
        List<HolderBondAccount> returnlist = criteria.list();
        getTransaction().commit();
        return returnlist;
    }

    @Override
    public boolean mergeHolderAccounts(Holder primaryHolder, List<Holder> secondaryHolders, List<HolderCompanyAccount> secHolderCompAccts,
            List<HolderBondAccount> secHolderBondAccts, String pryHolderOriginalValues) {
        boolean merged = false;
        
        int receiverShareUnitState = 0;
        
        try {
            startOperation();
            
            //re-attach primary holder
            primaryHolder = (Holder) getSession().merge(primaryHolder);
            primaryHolder.setMerged(true);
            createUpdateObject(primaryHolder);//update primary holder
            
            //account consolidation ids for comp account consolidation entry
            Map<Integer, AccountConsolidation> cons = new HashMap<>();
            
            //set all sec holders to non-pry and merged - record in account consolidation
            for (Holder sec : secondaryHolders) {
                sec.setHolder(primaryHolder);
                sec.setPryHolder(false);
                sec.setMerged(true);
                
                createUpdateObject(sec);//update secondary holder
                
                AccountConsolidation sec_cons = new AccountConsolidation();
                sec_cons.setHolder(sec);
                sec_cons.setHolderName(sec.getFirstName() + " " + sec.getLastName());
                sec_cons.setMergeDate(new Date());
                sec_cons.setMergedToHolderId(primaryHolder.getId());
                sec_cons.setMergedToHolderName(primaryHolder.getFirstName() + " " + primaryHolder.getLastName());
                sec_cons.setAdditionalChanges(pryHolderOriginalValues);
                sec_cons.setDemerge(false);
                
                createUpdateObject(sec_cons);//create account consolidation record
                cons.put(sec.getId(), sec_cons);//add consolidation id to list
            }
            
            //set all sec comp accts to non-pry and merged (if for transfer) - record in company account consolidation
            //(before recording, compare with comp accts in pry holder. If similar, do transfer. If not, sever from old holder and bond with pry holder)
            List<HolderCompanyAccount> pry_hca_list = new ArrayList<>(primaryHolder.getHolderCompanyAccounts());
            boolean foundHca = false;
            for (HolderCompanyAccount hca : secHolderCompAccts) {
                HolderCompanyAccount transferTo = new HolderCompanyAccount();
                
                for (HolderCompanyAccount pry_hca : pry_hca_list) {
                    if (hca.getId().getClientCompanyId() == pry_hca.getId().getClientCompanyId()) {//similar companies
                        foundHca = true;
                        transferTo = pry_hca;
                        break;
                    }
                }
                
                CompanyAccountConsolidation sec_comp_cons = new CompanyAccountConsolidation();
                //AccountConsolidation sec_cons = (AccountConsolidation) getSession().get(AccountConsolidation.class, cons.get(hca.getId().getHolderId()));
                AccountConsolidation sec_cons = cons.get(hca.getId().getHolderId());
                if (!foundHca) {//if accounts of the same company exists in both pry and sec, carry out transfer
                    HolderCompanyAccountId oldId = new HolderCompanyAccountId(hca.getId().getHolderId(), hca.getId().getClientCompanyId());
                    HolderCompanyAccount oldAcct = (HolderCompanyAccount) searchObject(HolderCompanyAccount.class, oldId);
                    
                    int initialHolderId = hca.getId().getHolderId();
                    int currentHolderId = primaryHolder.getId();
                    
                    hca.getId().setHolderId(currentHolderId);
                    createUpdateObject(hca);//update sec comp account (severe and bond to current holder)
                    removeObject(oldAcct);//get rid of old object
                    
                    sec_comp_cons.setAccountConsolidation(sec_cons);
                    sec_comp_cons.setForCompanyId(hca.getId().getClientCompanyId());
                    sec_comp_cons.setTiedToInitialHolderId(initialHolderId);
                    sec_comp_cons.setTiedToCurrentHolderId(currentHolderId);
                    sec_comp_cons.setInitialChn(sec_cons.getHolder().getChn());
                    sec_comp_cons.setCurrentChn(primaryHolder.getChn());
                    sec_comp_cons.setBondShareUnit(hca.getShareUnits());
                    sec_comp_cons.setTransfer(false);
                    sec_comp_cons.setMergeDate(new Date());
                    
                    createUpdateObject(sec_comp_cons);//create comp account consolidation record
                } else {//if no pry-sec accounts of the same company, sever sec comp acct and attach to pry holder
                    int unitsToMove = hca.getShareUnits();
                    int pryUnits = transferTo.getShareUnits();
                    
                    if (receiverShareUnitState == 0)
                        receiverShareUnitState = pryUnits;
                    
                    transferTo.setShareUnits(pryUnits + unitsToMove);
                    transferTo.setMerged(true);
                    createUpdateObject(transferTo);//update pry comp account
                    
                    hca.setShareUnits(0);
                    hca.setHolderCompanyAccount(transferTo);
                    hca.setHolderCompAccPrimary(false);
                    hca.setMerged(true);
                    createUpdateObject(hca);//update sec comp account
                    
                    sec_comp_cons.setAccountConsolidation(sec_cons);
                    sec_comp_cons.setForCompanyId(hca.getId().getClientCompanyId());
                    sec_comp_cons.setTiedToInitialHolderId(hca.getId().getHolderId());
                    sec_comp_cons.setTiedToCurrentHolderId(transferTo.getId().getHolderId());
                    sec_comp_cons.setInitialChn(sec_cons.getHolder().getChn());
                    sec_comp_cons.setCurrentChn(primaryHolder.getChn());
                    sec_comp_cons.setBondShareUnit(unitsToMove);
                    sec_comp_cons.setTransfer(true);
                    sec_comp_cons.setReceiverUnitState(receiverShareUnitState);
                    sec_comp_cons.setReceiverStartUnit(pryUnits);
                    sec_comp_cons.setUnitAfterTransfer(pryUnits + unitsToMove);
                    sec_comp_cons.setMergeDate(new Date());
                    
                    createUpdateObject(sec_comp_cons);
                    
                    foundHca = false; //set back to false when done
                }
            }
            
            //set all sec bond accts to non-pry and merged - record in company account consolidation
            //(before recording, compare with bond accts in pry holder. If similar, do transfer. If not, sever from old holder and bond with pry holder)
            List<HolderBondAccount> pry_hba_list = new ArrayList<>(primaryHolder.getHolderBondAccounts());
            boolean foundHba = false;
            for (HolderBondAccount hba : secHolderBondAccts) {
                
                for (HolderBondAccount pry_hba : pry_hba_list) {
                    if (hba.getId().getBondOfferId() == pry_hba.getId().getBondOfferId() &&
                            hba.getRemainingPrincipalValue() != 0) {
                        foundHba = true;
                        break;
                    }
                }
                
                CompanyAccountConsolidation sec_comp_cons = new CompanyAccountConsolidation();
                //AccountConsolidation sec_cons = (AccountConsolidation) getSession().get(AccountConsolidation.class, cons.get(hba.getId().getHolderId()));
                AccountConsolidation sec_cons = cons.get(hba.getId().getHolderId());
                if (!foundHba) {
                    HolderBondAccountId oldId = new HolderBondAccountId(hba.getId().getHolderId(), hba.getId().getBondOfferId());
                    HolderBondAccount oldAcct = (HolderBondAccount) searchObject(HolderBondAccount.class, oldId);
                    
                    int initialHolderId = hba.getId().getHolderId();
                    int currentHolderId = primaryHolder.getId();
                    
                    hba.getId().setHolderId(currentHolderId);
                    createUpdateObject(hba);//update sec comp account (severe and bond to current holder)
                    removeObject(oldAcct);//get rid of old object
                    
                    sec_comp_cons.setAccountConsolidation(sec_cons);
                    sec_comp_cons.setForBondOfferId(hba.getId().getBondOfferId());
                    sec_comp_cons.setTiedToInitialHolderId(initialHolderId);
                    sec_comp_cons.setTiedToCurrentHolderId(currentHolderId);
                    sec_comp_cons.setInitialChn(sec_cons.getHolder().getChn());
                    sec_comp_cons.setCurrentChn(primaryHolder.getChn());
                    sec_comp_cons.setBondShareUnit(hba.getBondUnits());
                    sec_comp_cons.setTransfer(false);
                    sec_comp_cons.setMergeDate(new Date());
                    
                    createUpdateObject(sec_comp_cons);//create comp account consolidation record
                }
            }
            
            getTransaction().commit();
            merged = true;
            return merged;
        } catch (Exception ex) {
            logger.error("merge error - ", ex);
            getTransaction().rollback();
            return merged;
        }
    }

    @Override
    public boolean demergeHolderAccounts(Holder primaryHolder, Map<Holder, List<CompanyAccountConsolidation>> secondaryAcctInfo) {
        boolean demerged = false;
        
        try {
            startOperation();
            
            //null accounts
            Holder h_null = null;
            HolderCompanyAccount hca_null = null;
            
            //changed merged status of primary holder
            primaryHolder.setMerged(false);
            createUpdateObject(primaryHolder);//update primary holder

            //change pry and merge status of secondary holders
            List<Holder> sec_list = new ArrayList<>(secondaryAcctInfo.keySet());
            for (Holder sec : sec_list) {
                sec.setHolder(h_null);
                sec.setMerged(false);
                sec.setPryHolder(true);
                createUpdateObject(sec);//update secondary holder
                
                //AccountConsolidation acctCons = (AccountConsolidation) searchObject(AccountConsolidation.class, sec.getId());
                Criteria consCriteria = getSession().createCriteria(AccountConsolidation.class)
                        .add(Restrictions.eq("mergedToHolderId", primaryHolder.getId()))
                        .add(Restrictions.eq("holder.id", sec.getId()))
                        .add(Restrictions.eq("demerge", false));
                if (consCriteria.list() == null || consCriteria.list().isEmpty())
                    throw new GreenpoleQueryException("Illegal secondary holder in demerge operation. "
                            + "Secondary holder has no account consolidation record.");
                AccountConsolidation acctCons = (AccountConsolidation) consCriteria.list().get(0);
                acctCons.setDemerge(true);
                acctCons.setDemergeDate(new Date());
                createUpdateObject(acctCons);//update account consolidation record
            }
            
            //for non-transfer sec comp accts, sever and re-attach to sec accounts
            Iterator it = secondaryAcctInfo.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Holder sec = (Holder) entry.getKey();
                List<CompanyAccountConsolidation> compAcctCons_list = (List<CompanyAccountConsolidation>) entry.getValue();
                
                for (CompanyAccountConsolidation compAcctCons : compAcctCons_list) {
                    int initialId = compAcctCons.getTiedToInitialHolderId();
                    int currentId = compAcctCons.getTiedToCurrentHolderId();
                    Integer compId = 0;
                    Integer bondId = 0;
                    
                    if (compAcctCons.getForCompanyId() != null)
                        compId = compAcctCons.getForCompanyId();
                    
                    if (compAcctCons.getForBondOfferId() != null)
                        bondId = compAcctCons.getForBondOfferId();

                    if (!compAcctCons.getTransfer()) {
                        //re-attach to secondary holder
                        if (compAcctCons.getForCompanyId() != null && compAcctCons.getForCompanyId() > 0) {
                            HolderCompanyAccountId hca_pry_id = new HolderCompanyAccountId(currentId, compId);
                            HolderCompanyAccount hca_pry = (HolderCompanyAccount) searchObject(HolderCompanyAccount.class, hca_pry_id);
                            getSession().evict(hca_pry);
                            hca_pry.getId().setHolderId(initialId);
                            createUpdateObject(hca_pry);//update sec comp acct
                            
                            HolderCompanyAccountId oldHcaId = new HolderCompanyAccountId(currentId, compId);
                            HolderCompanyAccount oldHca = (HolderCompanyAccount) searchObject(HolderCompanyAccount.class, oldHcaId);
                            removeObject(oldHca);//remove the old pry comp acct
                        }
                        
                        //for bonds, detach and retach
                        if (compAcctCons.getForBondOfferId() != null && compAcctCons.getForBondOfferId() > 0) {
                            HolderBondAccountId hba_pry_id = new HolderBondAccountId(currentId, bondId);
                            HolderBondAccount hba_pry = (HolderBondAccount) searchObject(HolderBondAccount.class, hba_pry_id);
                            getSession().evict(hba_pry);
                            hba_pry.getId().setHolderId(sec.getId());
                            createUpdateObject(hba_pry);//update pry bond acct
                            
                            HolderBondAccountId oldHbaId = new HolderBondAccountId(currentId, bondId);
                            HolderBondAccount oldHba = (HolderBondAccount) searchObject(HolderBondAccount.class, oldHbaId);
                            removeObject(oldHba);//remove the old pry bond acct
                        }
                    } else {
                        //for transfer sec comp accts, move original data back (share units), change pry and merge status
                        if (compAcctCons.getForCompanyId() != null && compAcctCons.getForCompanyId() > 0) {
                            int unitsForSec = compAcctCons.getBondShareUnit();
                            //int pryUnits = hca_pry.getShareUnits();

                            HolderCompanyAccountId hca_sec_id = new HolderCompanyAccountId(initialId, compId);
                            HolderCompanyAccount hca_sec = (HolderCompanyAccount) searchObject(HolderCompanyAccount.class, hca_sec_id);

                            hca_sec.setShareUnits(unitsForSec);
                            hca_sec.setHolderCompAccPrimary(true);
                            hca_sec.setMerged(false);
                            hca_sec.setHolderCompanyAccount(hca_null);
                            createUpdateObject(hca_sec);//update sec comp acct
                            
                            HolderCompanyAccountId hca_pry_id = new HolderCompanyAccountId(currentId, compId);
                            HolderCompanyAccount hca_pry = (HolderCompanyAccount) searchObject(HolderCompanyAccount.class, hca_pry_id);
                            
                            hca_pry.setShareUnits(hca_pry.getShareUnits() - unitsForSec);
                            hca_pry.setMerged(false);
                            createUpdateObject(hca_pry);//update pry comp acct
                        }
                    }
                }
            }

            getTransaction().commit();
            demerged = true;
            return demerged;
        } catch (Exception ex) {
            logger.error("demerge error - ", ex);
            getTransaction().rollback();
            return demerged;
        }
    }

    @Override
    public List<Holder> getSecondaryHolderAccounts(int holderId) {
        startOperation();        
        Criteria criteria = getSession().createCriteria(Holder.class)
                .add(Restrictions.eq("pryHolder", false))
                .add(Restrictions.eq("merged", true))
                .add(Restrictions.eq("holder.id", holderId));
        List<Holder> resultlist = criteria.list();
        getTransaction().commit();
        return resultlist;
    }

    @Override
    public boolean checkInConsolidation(int pryHolderId, int secHolderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(AccountConsolidation.class)
                .add(Restrictions.eq("demerge", false))
                .add(Restrictions.eq("mergedToHolderId", pryHolderId))
                .add(Restrictions.eq("holder.id", secHolderId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkInCompAcctConsolidation(int pryHolderId, int secHolderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(CompanyAccountConsolidation.class)
                .createAlias("accountConsolidation", "a")
                .add(Restrictions.eq("a.demerge", false))
                .add(Restrictions.eq("tiedToCurrentHolderId", pryHolderId))
                .add(Restrictions.eq("tiedToInitialHolderId", secHolderId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkSecondaryHolders(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Holder.class)
                .add(Restrictions.eq("holder.id", holderId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public List<CompanyAccountConsolidation> getCompanyAccountMerges(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(CompanyAccountConsolidation.class)
                .createAlias("accountConsolidation", "a")
                .add(Restrictions.eq("a.demerge", false))
                .add(Restrictions.eq("tiedToInitialHolderId", holderId));
        List<CompanyAccountConsolidation> resultlist = criteria.list();
        getTransaction().commit();
        return resultlist;
    }

    @Override
    public int getFinalUnitAfterTransfer(int holderId, int compOrBondId, boolean isShare) {
        startOperation();
        Criteria criteria;
        if (isShare) {
            criteria = getSession().createCriteria(CompanyAccountConsolidation.class)
                    .createAlias("accountConsolidation", "a")
                    .add(Restrictions.eq("a.demerge", false))
                    .add(Restrictions.eq("tiedToCurrentHolderId", holderId))
                    .add(Restrictions.eq("forCompanyId", compOrBondId))
                    .setProjection(Projections.max("unitAfterTransfer"));
        } else {
            criteria = getSession().createCriteria(CompanyAccountConsolidation.class)
                    .createAlias("accountConsolidation", "a")
                    .add(Restrictions.eq("a.demerge", false))
                    .add(Restrictions.eq("tiedToCurrentHolderId", holderId))
                    .add(Restrictions.eq("forBondOfferId", compOrBondId))
                    .setProjection(Projections.max("unitAfterTransfer"));
        }
        Integer finalUnit = (Integer) criteria.uniqueResult();
        getTransaction().commit();
        return finalUnit;
    }

    @Override
    public List<AccountConsolidation> getAllHolderAccountConsolidation(String descriptor, String startDate, String endDate, String dateFormat) {
        //descriptor must be date:none / date:exact / date:between / date:before / date:after
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(AccountConsolidation.class);

            if (descriptor.equalsIgnoreCase("exact")) {
                try {
                    criteria.add(Restrictions.eq("mergeDate", formatter.parse(startDate)));
                    List<AccountConsolidation> returnlist = criteria.list();
                    getTransaction().commit();
                    return returnlist;
                } catch (ParseException ex) {
                    logger.error("error parsing date - ", ex);
                }
            }

            if (descriptor.equalsIgnoreCase("between")) {
                try {
                    criteria.add(Restrictions.between("mergeDate", formatter.parse(startDate), formatter.parse(endDate)));
                    List<AccountConsolidation> returnlist = criteria.list();
                    getTransaction().commit();
                    return returnlist;
                } catch (ParseException ex) {
                    logger.error("error parsing date - ", ex);
                }
            }

            if (descriptor.equalsIgnoreCase("before")) {
                try {
                    criteria.add(Restrictions.lt("mergeDate", formatter.parse(startDate)));
                    List<AccountConsolidation> returnlist = criteria.list();
                    getTransaction().commit();
                    return returnlist;
                } catch (ParseException ex) {
                    logger.error("error parsing date - ", ex);
                }
            }

            if (descriptor.equalsIgnoreCase("after")) {
                try {
                    criteria.add(Restrictions.gt("mergeDate", formatter.parse(startDate)));
                    List<AccountConsolidation> returnlist = criteria.list();
                    getTransaction().commit();
                    return returnlist;
                } catch (ParseException ex) {
                    logger.error("error parsing date - ", ex);
                }
            }

            List<AccountConsolidation> returnlist = criteria.list();
            getTransaction().commit();
            return returnlist;
        } finally {
            if (getTransaction() != null && !getTransaction().wasCommitted())
                getTransaction().rollback();
        }
    }

    @Override
    public List<CompanyAccountConsolidation> getCompAcctConsolidation(int acctConsolidationId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(CompanyAccountConsolidation.class)
                .add(Restrictions.eq("accountConsolidation.demerge", false))
                .add(Restrictions.eq("accountConsolidation.id", acctConsolidationId));
        List<CompanyAccountConsolidation> resultlist = criteria.list();
        getTransaction().commit();
        return resultlist;
    }

    @Override
    public boolean createAdministratorForHolder(Holder holder, HolderChanges change) {
        boolean created = false;
        
        try {
            startOperation();
            createUpdateObject(change); //record change
            createUpdateObject(holder);
            
            List<Administrator> admin_list = new ArrayList<>(holder.getAdministrators());
            for (Administrator admin : admin_list) {
                
                createUpdateObject(admin);//create admin
                List<AdministratorEmailAddress> email_list = new ArrayList<>(admin.getAdministratorEmailAddresses());
                
                for (AdministratorEmailAddress email : email_list) {
                    email.setAdministrator(admin);
                    createUpdateObject(email);//create email
                }
                
                List<AdministratorPhoneNumber> phone_list = new ArrayList<>(admin.getAdministratorPhoneNumbers());
                for (AdministratorPhoneNumber phone : phone_list) {
                    phone.setAdministrator(admin);
                    createUpdateObject(phone);//create phone
                }
                
                List<AdministratorPostalAddress> pos_list = new ArrayList<>(admin.getAdministratorPostalAddresses());
                for (AdministratorPostalAddress pos : pos_list) {
                    pos.setAdministrator(admin);
                    createUpdateObject(pos);//create postal address
                }
                
                List<AdministratorResidentialAddress> res_list = new ArrayList<>(admin.getAdministratorResidentialAddresses());
                for (AdministratorResidentialAddress res : res_list) {
                    res.setAdministrator(admin);
                    createUpdateObject(res);//create residential address
                }
            }
            
            getTransaction().commit();
            created = true;
            return created;
        } catch (Exception ex) {
            logger.error("error creating administrator account - ", ex);
            getTransaction().rollback();
            return created;
        }
    }

    @Override
    public boolean checkCurrentPowerOfAttorney(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PowerOfAttorney.class)
                .add(Restrictions.eq("powerOfAttorneyPrimary", true))
                .add(Restrictions.eq("holder.id", holderId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public PowerOfAttorney getCurrentPowerOfAttorney(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PowerOfAttorney.class)
                .add(Restrictions.eq("powerOfAttorneyPrimary", true))
                .add(Restrictions.eq("holder.id", holderId));
        PowerOfAttorney poa = (PowerOfAttorney) criteria.list().get(0);
        getTransaction().commit();
        return poa;
    }

    @Override
    public boolean checkCurrentSignature(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderSignature.class)
                .add(Restrictions.eq("holderSignaturePrimary", true))
                .add(Restrictions.eq("holder.id", holderId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public HolderSignature getCurrentSignature(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderSignature.class)
                .add(Restrictions.eq("holderSignaturePrimary", true))
                .add(Restrictions.eq("holder.id", holderId));
        HolderSignature hs = (HolderSignature) criteria.list().get(0);
        getTransaction().commit();
        return hs;
    }

    @Override
    public boolean uploadPowerOfAttorney(PowerOfAttorney newPoa, PowerOfAttorney currentPoa) {
        boolean uploaded = false;
        try {
            startOperation();
            createUpdateObject(newPoa);
            if (currentPoa != null)
                createUpdateObject(currentPoa);
            getTransaction().commit();
            uploaded = true;
            return uploaded;
        } catch (Exception ex) {
            logger.error("error uploading power of attorney - ", ex);
            getTransaction().rollback();
            return uploaded;
        }
    }

    @Override
    public boolean uploadHolderSignature(HolderSignature newSig, HolderSignature currentSig) {
        boolean uploaded = false;
        try {
            startOperation();
            createUpdateObject(newSig);
            if (currentSig != null)
                createUpdateObject(currentSig);
            getTransaction().commit();
            uploaded = true;
            return uploaded;
        } catch (Exception ex) {
            logger.error("error uploading signature - ", ex);
            getTransaction().rollback();
            return uploaded;
        }
    }

    @Override
    public PowerOfAttorney getHolderPowerOfAttorney(int attorneyId) {
        startOperation();
        PowerOfAttorney poa = (PowerOfAttorney) searchObject(PowerOfAttorney.class, attorneyId);
        getTransaction().commit();
        return poa;
    }

    @Override
    public List<PowerOfAttorney> getAllHolderPowerOfAttorney(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PowerOfAttorney.class)
                .add(Restrictions.eq("holder.id", holderId));
        List<PowerOfAttorney> poa_list = criteria.list();
        getTransaction().commit();
        return poa_list;
    }

    @Override
    public boolean checkBank(int bankId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Bank.class)
                .add(Restrictions.idEq(bankId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public List<HolderType> getAllHolderTypes() {
        startOperation();
        List<HolderType> type_list = searchAll(HolderType.class);
        getTransaction().commit();
        return type_list;
    }

    @Override
    public HolderType getHolderType(int typeId) {
        startOperation();
        HolderType type = (HolderType) searchObject(HolderType.class, typeId);
        getTransaction().commit();
        return type;
    }

    @Override
    public List<TransactionType> getAllTransactionTypes() {
        startOperation();
        List<TransactionType> type_list = searchAll(TransactionType.class);
        getTransaction().commit();
        return type_list;
    }

    @Override
    public TransactionType getTransactionType(int typeId) {
        startOperation();
        TransactionType type = (TransactionType) searchObject(TransactionType.class, typeId);
        getTransaction().commit();
        return type;
    }

    @Override
    public Bank getBankDetails(int bankId) {
        startOperation();
        Bank bank = (Bank) searchObject(Bank.class, bankId);
        getTransaction().commit();
        return bank;
    }

    @Override
    public boolean holderHasEsopAccount(int holderId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(HolderCompanyAccount.class)
                .add(Restrictions.eq("id.holderId", holderId))
                .add(Restrictions.eq("esop", true))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }
    
    /**
     * Gets the criteria for a search on all holders in the database.
     * @return the criteria for a search on all holders
     */
    private Criteria getStartCriteria() {
        return getSession().createCriteria(Holder.class, "h");
    }
    
    /**
     * Gets the criteria for a search on all bond-holders according
     * specified object.
     * @param baseCriteria the criteria, typically one for a search on all
     * holders in the database
     * @param bondholder the bond-holder object containing search patterns
     * @return the criteria for a search on all holders
     */
    private Criteria searchBondholderAccordingToObject(Criteria baseCriteria, Holder bondholder) {
        baseCriteria.add(Example.create(bondholder).enableLike());
        
        List<HolderResidentialAddress> h_res_list = new ArrayList<>(bondholder.getHolderResidentialAddresses());
        List<HolderPostalAddress> h_pos_list = new ArrayList<>(bondholder.getHolderPostalAddresses());
        List<HolderPhoneNumber> h_phone_list = new ArrayList<>(bondholder.getHolderPhoneNumbers());
        List<HolderEmailAddress> h_email_list = new ArrayList<>(bondholder.getHolderEmailAddresses());
        
        List<Stockbroker> h_broker_list = new ArrayList<>(bondholder.getStockbrokers());
        List<HolderBondAccount> h_acct_list = new ArrayList<>(bondholder.getHolderBondAccounts());
        
        //for residential address
        if (!h_res_list.isEmpty()) {
            HolderResidentialAddress hres = h_res_list.get(0);
            
            baseCriteria.createCriteria("h.holderResidentialAddresses", "r", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hres).enableLike().ignoreCase());
        }

        //for postal address
        if (!h_pos_list.isEmpty()) {
            HolderPostalAddress hpos = h_pos_list.get(0);
            
            baseCriteria.createCriteria("h.holderPostalAddresses", "p", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hpos).enableLike().ignoreCase());
        }
        
        //for phone number
        if (!h_phone_list.isEmpty()) {
            HolderPhoneNumber hphone = h_phone_list.get(0);
            
            baseCriteria.createCriteria("h.holderPhoneNumbers", "n", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hphone).enableLike().ignoreCase());
        }
        
        //for email address
        if (!h_email_list.isEmpty()) {
            HolderEmailAddress hemail = h_email_list.get(0);
            
            baseCriteria.createCriteria("h.holderEmailAddresses", "e", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hemail).enableLike().ignoreCase());
        }
        
        //for stockbroker
        if (!h_broker_list.isEmpty()) {
            Stockbroker hbroker = h_broker_list.get(0);
            
            baseCriteria.createCriteria("h.stockbrokers", "s", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hbroker).enableLike().ignoreCase());
        }
        
        //for bond account
        if (!h_acct_list.isEmpty()) {
            HolderBondAccount hacct = h_acct_list.get(0);
            
            baseCriteria.createCriteria("h.holderBondAccounts", "c", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hacct).enableLike().ignoreCase());
            
            if (hacct.getId() != null && hacct.getId().getBondOfferId() > 0) {
                int offerId = hacct.getId().getBondOfferId();
                baseCriteria.add(Restrictions.eq("c.id.holderId", offerId));
            }
        }
        return baseCriteria;
    }
    
    /**
     * Gets the criteria for a search on all shareholders according
     * specified object.
     * @param baseCriteria the criteria, typically one for a search on all
     * holders in the database
     * @param shareholder the shareholder object containing search patterns
     * @return the criteria for a search on all holders
     */
    private Criteria searchShareholderAccordingToObject(Criteria baseCriteria, Holder shareholder) {
        baseCriteria.add(Example.create(shareholder).enableLike());
        
        List<HolderResidentialAddress> h_res_list = new ArrayList<>(shareholder.getHolderResidentialAddresses());
        List<HolderPostalAddress> h_pos_list = new ArrayList<>(shareholder.getHolderPostalAddresses());
        List<HolderPhoneNumber> h_phone_list = new ArrayList<>(shareholder.getHolderPhoneNumbers());
        List<HolderEmailAddress> h_email_list = new ArrayList<>(shareholder.getHolderEmailAddresses());
        
        List<Stockbroker> h_broker_list = new ArrayList<>(shareholder.getStockbrokers());
        List<HolderCompanyAccount> h_acct_list = new ArrayList<>(shareholder.getHolderCompanyAccounts());
        
        //for residential address
        if (!h_res_list.isEmpty()) {
            HolderResidentialAddress hres = h_res_list.get(0);
            
            baseCriteria.createCriteria("h.holderResidentialAddresses", "r", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hres).enableLike().ignoreCase());
        }

        //for postal address
        if (!h_pos_list.isEmpty()) {
            HolderPostalAddress hpos = h_pos_list.get(0);
            
            baseCriteria.createCriteria("h.holderPostalAddresses", "p", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hpos).enableLike().ignoreCase());
        }
        
        //for phone number
        if (!h_phone_list.isEmpty()) {
            HolderPhoneNumber hphone = h_phone_list.get(0);
            System.out.println(":::phone:::::: " + hphone.getPhoneNumber());
            baseCriteria.createCriteria("h.holderPhoneNumbers", "n", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hphone).enableLike().ignoreCase());
        }
        
        //for email address
        if (!h_email_list.isEmpty()) {
            HolderEmailAddress hemail = h_email_list.get(0);
            
            baseCriteria.createCriteria("h.holderEmailAddresses", "e", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hemail).enableLike().ignoreCase());
        }
        
        //for stockbroker
        if (!h_broker_list.isEmpty()) {
            Stockbroker hbroker = h_broker_list.get(0);
            
            baseCriteria.createCriteria("h.stockbrokers", "s", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hbroker).enableLike().ignoreCase());
        }
        
        //for company account
        if (!h_acct_list.isEmpty()) {
            HolderCompanyAccount hacct = h_acct_list.get(0);
            baseCriteria.createCriteria("h.holderCompanyAccounts", "c", JoinType.LEFT_OUTER_JOIN)
                    .add(Example.create(hacct).enableLike().ignoreCase());
           
            if (hacct.getId() != null && hacct.getId().getClientCompanyId() > 0) {
                int compId = hacct.getId().getClientCompanyId();
                baseCriteria.add(Restrictions.eq("c.id.clientCompanyId", compId));
            }
        }
        
        return baseCriteria;
    }
    
    /**
     * Gets the criteria for a search on all holders according to specified unit prices.
     * @param baseCriteria the criteria, typically one for a search on all holders in 
     * the database (but not limited to)
     * @param descriptorValue the value of the descriptor to determine what type
     * of search to carry out [whether an exact search - with one value, or a
     * range search - with two values]
     * @param unitPriceCriteria the unit price value(s) to search for
     * @return the criteria for a search on all holders according to specified unit prices
     */
    private Criteria searchBondUnit(Criteria baseCriteria, String descriptorValue, String acctDescValue, Map<String, Integer> unitPriceCriteria) {
        //intial shareholder company account object, in case holder isnt searched
        HolderBondAccount initialAcct = new HolderBondAccount();
        initialAcct.setHolderBondAcctPrimary(true);
        initialAcct.setMerged(false);
        
        Criteria tempCriteria = baseCriteria; //save criteria state, in case it needs to be returned
        
        if (!acctDescValue.equalsIgnoreCase("exact") && 
                (descriptorValue.equalsIgnoreCase("exact") || descriptorValue.equalsIgnoreCase("range"))) {
            baseCriteria.createCriteria("h.holderBondAccounts", "b", JoinType.LEFT_OUTER_JOIN)
                    .add(Example.create(initialAcct).enableLike());
        }
        
        if (descriptorValue.equalsIgnoreCase("exact")) {
            int startUnit = unitPriceCriteria.get("start");
            return baseCriteria.add(Restrictions.eq("c.bondUnits", startUnit));
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            int startUnit = unitPriceCriteria.get("start");
            int endUnit = unitPriceCriteria.get("end");
            return baseCriteria.add(Restrictions.ge("c.bondUnits", startUnit))
                    .add(Restrictions.le("c.bondUnits", endUnit));
        }

        return tempCriteria;
    }
    
    /**
     * Gets the criteria for a search on all holders according to specified unit prices.
     * @param baseCriteria the criteria, typically one for a search on all holders in 
     * the database (but not limited to)
     * @param descriptorValue the value of the descriptor to determine what type
     * of search to carry out [whether an exact search - with one value, or a
     * range search - with two values]
     * @param unitPriceCriteria the unit price value(s) to search for
     * @return the criteria for a search on all holders according to specified unit prices
     */
    private Criteria searchShareUnit(Criteria baseCriteria, String descriptorValue, String acctDescValue, Map<String, Integer> unitPriceCriteria) {
        //intial shareholder company account object, in case holder isnt searched
        HolderCompanyAccount initialAcct = new HolderCompanyAccount();
        initialAcct.setHolderCompAccPrimary(true);
        initialAcct.setMerged(false);
        
        Criteria tempCriteria = baseCriteria; //save criteria state, in case it needs to be returned
        
        if (!acctDescValue.equalsIgnoreCase("exact") && 
                (descriptorValue.equalsIgnoreCase("exact") || descriptorValue.equalsIgnoreCase("range"))) {
            baseCriteria.createCriteria("h.holderCompanyAccounts", "c", JoinType.LEFT_OUTER_JOIN)
                    .add(Example.create(initialAcct).enableLike());
        }
        
        if (descriptorValue.equalsIgnoreCase("exact")) {
            int startUnit = unitPriceCriteria.get("start");
            return baseCriteria.add(Restrictions.eq("c.shareUnits", startUnit));
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            int startUnit = unitPriceCriteria.get("start");
            int endUnit = unitPriceCriteria.get("end");
            return baseCriteria.add(Restrictions.ge("c.shareUnits", startUnit))
                    .add(Restrictions.le("c.shareUnits", endUnit));
        }

        return tempCriteria;
    }
    
    /**
     * Gets the list of shareholders according to the specified total holdings.
     * @param holders the pool of holders to search from
     * @param descriptorValue the value of the descriptor to determine what type
     * of search to carry out [whether an exact search - with one value, or a
     * range search - with two values]
     * @param holdingsCriteria the total holdings to search for
     * @return the list of shareholders according to the specified total holdings
     */
    private List<Holder> searchTotalBondHoldings(List<Holder> holders, String descriptorValue, Map<String, Integer> holdingsCriteria) {
        List<Holder> searchResult = new ArrayList<>();
        
        if (descriptorValue.equalsIgnoreCase("exact")) {
            int startNo = holdingsCriteria.get("start");
            for (Holder h : holders) {
                List<HolderBondAccount> acct_list = new ArrayList<>(h.getHolderBondAccounts());
                int totalUnits = 0;
                for (HolderBondAccount hbc : acct_list) {
                    totalUnits += hbc.getBondUnits();
                }
                if (totalUnits == startNo) {
                    searchResult.add(h);
                }
            }
            return searchResult;
        }
        
        if (descriptorValue.equalsIgnoreCase("range")) {
            int startNo = holdingsCriteria.get("start");
            int endNo = holdingsCriteria.get("end");
            for (Holder h : holders) {
                List<HolderBondAccount> acct_list = new ArrayList<>(h.getHolderBondAccounts());
                int totalUnits = 0;
                for (HolderBondAccount hba : acct_list) {
                    totalUnits += hba.getBondUnits();
                }
                if (totalUnits >= startNo && totalUnits <= endNo) {
                    searchResult.add(h);
                }
            }
            return searchResult;
        }
        
        return holders;
    }
    
    /**
     * Gets the list of shareholders according to the specified total holdings.
     * @param holders the pool of holders to search from
     * @param descriptorValue the value of the descriptor to determine what type
     * of search to carry out [whether an exact search - with one value, or a
     * range search - with two values]
     * @param holdingsCriteria the total holdings to search for
     * @return the list of shareholders according to the specified total holdings
     */
    private List<Holder> searchTotalShareHoldings(List<Holder> holders, String descriptorValue, Map<String, Integer> holdingsCriteria) {
        List<Holder> searchResult = new ArrayList<>();
        
        if (descriptorValue.equalsIgnoreCase("exact")) {
            int startNo = holdingsCriteria.get("start");
            for (Holder h : holders) {
                List<HolderCompanyAccount> acct_list = new ArrayList<>(h.getHolderCompanyAccounts());
                int totalUnits = 0;
                for (HolderCompanyAccount hca : acct_list) {
                    totalUnits += hca.getShareUnits();
                }
                if (totalUnits == startNo) {
                    searchResult.add(h);
                }
            }
            return searchResult;
        }
        
        if (descriptorValue.equalsIgnoreCase("range")) {
            int startNo = holdingsCriteria.get("start");
            int endNo = holdingsCriteria.get("end");
            for (Holder h : holders) {
                List<HolderCompanyAccount> acct_list = new ArrayList<>(h.getHolderCompanyAccounts());
                int totalUnits = 0;
                for (HolderCompanyAccount hca : acct_list) {
                    totalUnits += hca.getShareUnits();
                }
                if (totalUnits >= startNo && totalUnits <= endNo) {
                    searchResult.add(h);
                }
            }
            return searchResult;
        }
        
        return holders;
    }

    /**
     * See {@link #transferBondUnits(org.greenpole.hibernate.entity.HolderBondAccount, org.greenpole.hibernate.entity.HolderBondAccount, int, double, int) }
     */
    private void processTransactionBondTransfer(ProcessedTransaction pt, HolderBondAccount sender, TransactionType type, ProcessedTransactionHolderId pt_sender_id, ProcessedTransactionHolder pt_sender, int bondUnits, ProcessedTransactionHolderId pt_receiver_id, HolderBondAccount receiver, ProcessedTransactionHolder pt_receiver) {
        //set transaction overall
        pt.setCscsTransactionId(0);
        pt.setCompanyName(sender.getBondOffer().getTitle());//record bond title under company name
        pt.setClientCompany(sender.getBondOffer().getClientCompany());
        pt.setTransactionType(type);
        createUpdateObject(pt);
        
        //set transaction for sender
        pt_sender_id.setHolderId(sender.getId().getHolderId());
        pt_sender_id.setTransactionId(pt.getId());
        pt_sender.setId(pt_sender_id);
        pt_sender.setHolder(sender.getHolder());
        pt_sender.setHolderName(sender.getHolder().getFirstName() + " " + sender.getHolder().getLastName());
        pt_sender.setHolderChn(sender.getHolder().getChn());
        pt_sender.setUnits(bondUnits);
        pt_sender.setUnitType("bond");
        pt_sender.setFromTo("from");
        createUpdateObject(pt_sender);
        
        //set transaction for receiver
        pt_receiver_id.setHolderId(receiver.getId().getHolderId());
        pt_receiver_id.setTransactionId(pt.getId());
        pt_receiver.setProcessedTransaction(pt);
        pt_receiver.setHolder(receiver.getHolder());
        pt_receiver.setHolderName(receiver.getHolder().getFirstName() + " " + receiver.getHolder().getLastName());
        pt_receiver.setHolderChn(receiver.getHolder().getChn());
        pt_receiver.setUnits(bondUnits);
        pt_receiver.setUnitType("bond");
        pt_receiver.setFromTo("to");
        createUpdateObject(pt_receiver);
    }
    
    /**
     * See {@link #transferShareUnits(org.greenpole.hibernate.entity.HolderCompanyAccount, org.greenpole.hibernate.entity.HolderCompanyAccount, int, int) }
     */
    private void processTransactionShareTransfer(ProcessedTransaction pt, HolderCompanyAccount sender, TransactionType type, ProcessedTransactionHolderId pt_sender_id, ProcessedTransactionHolder pt_sender, int shareUnits, ProcessedTransactionHolderId pt_receiver_id, HolderCompanyAccount receiver, ProcessedTransactionHolder pt_receiver) {
        //set transaction overall
        pt.setCscsTransactionId(0);
        pt.setCompanyName(sender.getClientCompany().getName());
        pt.setClientCompany(sender.getClientCompany());
        pt.setTransactionType(type);
        createUpdateObject(pt);
        
        //set transaction for sender
        pt_sender_id.setHolderId(sender.getId().getHolderId());
        pt_sender_id.setTransactionId(pt.getId());
        pt_sender.setId(pt_sender_id);
        pt_sender.setHolder(sender.getHolder());
        pt_sender.setHolderName(sender.getHolder().getFirstName() + " " + sender.getHolder().getLastName());
        pt_sender.setHolderChn(sender.getHolder().getChn());
        pt_sender.setUnits(shareUnits);
        pt_sender.setUnitType("shares");
        pt_sender.setFromTo("from");
        createUpdateObject(pt_sender);
        
        //set transaction for receiver
        pt_receiver_id.setHolderId(receiver.getId().getHolderId());
        pt_receiver_id.setTransactionId(pt.getId());
        pt_receiver.setProcessedTransaction(pt);
        pt_receiver.setHolder(receiver.getHolder());
        pt_receiver.setHolderName(receiver.getHolder().getFirstName() + " " + receiver.getHolder().getLastName());
        pt_receiver.setHolderChn(receiver.getHolder().getChn());
        pt_receiver.setUnits(shareUnits);
        pt_receiver.setUnitType("share");
        pt_receiver.setFromTo("to");
        createUpdateObject(pt_receiver);
    }
}
