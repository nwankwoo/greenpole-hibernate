/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.AccountConsolidation;
import org.greenpole.hibernate.entity.BondOfferPaymentPlan;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.CompanyAccountConsolidation;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderChanges;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderEmailAddress;
import org.greenpole.hibernate.entity.HolderPhoneNumber;
import org.greenpole.hibernate.entity.HolderPostalAddress;
import org.greenpole.hibernate.entity.HolderResidentialAddress;
import org.greenpole.hibernate.entity.HolderSignature;
import org.greenpole.hibernate.entity.HolderType;
import org.greenpole.hibernate.entity.PowerOfAttorney;
import org.greenpole.hibernate.entity.Stockbroker;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.greenpole.hibernate.query.HolderComponentQuery;
import org.greenpole.util.Descriptor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 *
 * @author Akin
 */
public class HolderComponentQueryImpl extends GeneralisedAbstractDao implements HolderComponentQuery {

    @Override
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses, List<HolderEmailAddress> emailAddresses, List<HolderPhoneNumber> phoneNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUpdateHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createHolderAccount(Holder holder, HolderBondAccount holderBondAccount, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses, List<HolderEmailAddress> emailAddresses, List<HolderPhoneNumber> phoneNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUpdateHolderBondAccount(HolderBondAccount holderBondAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateHolderAccount(Holder holder, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses, List<HolderPhoneNumber> phoneNumbers, List<HolderEmailAddress> emailAddresses, List<HolderChanges> changes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateHolderAccountForTranspose(Holder holder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkHolderAccount(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkHolderAccount(String chn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkHolderCompanyAccount(int holderId, int clientCompanyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkHolderBondAccount(int holderId, int clientCompanyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkHolderCompanyAccount(String chn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkHolderBondAccount(String chn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HolderChanges> queryHolderChanges(String descriptor, HolderChanges searchParams, String startDate, String endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Holder getHolder(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Holder getHolder(String chn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HolderCompanyAccount getHolderCompanyAccount(int holderId, int clientCompanyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HolderBondAccount getHolderBondAccount(int holderId, int bondOfferId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HolderCompanyAccount getHolderCompanyAccount(String chn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HolderBondAccount getHolderBondAccount(String chn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Gets the criteria for a search on all holders in the database.
     * @return the criteria for a search on all holders
     */
    private Criteria getStartCriteria() {
        return getSession().createCriteria(Holder.class, "h");
    }
    
    /**
     * Gets the criteria for a search on all shareholders according
     * specified object.
     * @param baseCriteria the criteria, typically one for a search on all
     * client companies in the database
     * @param shareHolder the shareholder object containing search patterns
     * @return the criteria for a search on all client companies
     */
    private Criteria searchShareHolderAccordingToObject(Criteria baseCriteria, Holder shareHolder) {
        List<HolderResidentialAddress> h_res_list = new ArrayList<>(shareHolder.getHolderResidentialAddresses());
        List<HolderPostalAddress> h_pos_list = new ArrayList<>(shareHolder.getHolderPostalAddresses());
        List<HolderPhoneNumber> h_phone_list = new ArrayList<>(shareHolder.getHolderPhoneNumbers());
        List<HolderEmailAddress> h_email_list = new ArrayList<>(shareHolder.getHolderEmailAddresses());
        
        List<Stockbroker> h_broker_list = new ArrayList<>(shareHolder.getStockbrokers());
        List<HolderCompanyAccount> h_acct_list = new ArrayList<>(shareHolder.getHolderCompanyAccounts());
        
        HolderResidentialAddress hres = h_res_list.get(0);
        HolderPostalAddress hpos = h_pos_list.get(0);
        HolderPhoneNumber hphone = h_phone_list.get(0);
        HolderEmailAddress hemail = h_email_list.get(0);
        
        Stockbroker hbroker = h_broker_list.get(0);
        HolderCompanyAccount hacct = h_acct_list.get(0);
        
        baseCriteria.add(Example.create(shareHolder).enableLike())
                .createCriteria("h.holderResidentialAddresses", "r", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hres).enableLike().ignoreCase())
                .createCriteria("h.holderPostalAddresses", "p", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hpos).enableLike().ignoreCase())
                .createCriteria("h.holderPhoneNumbers", "n", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hphone).enableLike().ignoreCase())
                .createCriteria("h.holderEmailAddresses", "e", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hemail).enableLike().ignoreCase())
                .createCriteria("h.stockbrokers", "s", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hbroker).enableLike().ignoreCase())
                .createCriteria("h.holderCompanyAccounts", "c", JoinType.LEFT_OUTER_JOIN)
                .add(Example.create(hacct).enableLike().ignoreCase());
        
        //for residential address
        String res_addressLine1 = hres.getId().getAddressLine1();
        if (res_addressLine1 != null) {
            baseCriteria.add(Restrictions.ilike("r.id.addressLine1", res_addressLine1));
        }
        String res_state = hres.getId().getState();
        if (res_state != null) {
            baseCriteria.add(Restrictions.ilike("r.id.state", res_state));
        }
        String res_country = hres.getId().getCountry();
        if (res_country != null) {
            baseCriteria.add(Restrictions.ilike("r.id.country", res_country));
        }
        
        //for postal address
        String pos_addressLine1 = hpos.getId().getAddressLine1();
        if (pos_addressLine1 != null) {
            baseCriteria.add(Restrictions.ilike("p.id.addressLine1", pos_addressLine1));
        }
        String pos_state = hpos.getId().getState();
        if (pos_state != null) {
            baseCriteria.add(Restrictions.ilike("p.id.state", pos_state));
        }
        String pos_country = hpos.getId().getCountry();
        if (pos_country != null) {
            baseCriteria.add(Restrictions.ilike("p.id.country", pos_country));
        }
        
        //for phone number
        String phoneNumber = hphone.getId().getPhoneNumber();
        if (phoneNumber != null) {
            baseCriteria.add(Restrictions.ilike("n.id.phoneNumber", phoneNumber));
        }
        
        //for email address
        String emailAddress = hemail.getId().getEmailAddress();
        if (emailAddress != null) {
            baseCriteria.add(Restrictions.ilike("e.id.emailAddress", emailAddress));
        }
        
        //for company account
        int ccId = hacct.getId().getClientCompanyId();
        if (ccId > 0) {
            baseCriteria.add(Restrictions.eq("c.id.clientCompanyId", emailAddress));
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
    private Criteria searchShareUnitPrice(Criteria baseCriteria, String descriptorValue, String acctDescValue, Map<String, Integer> unitPriceCriteria) {
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
            double startUnit = unitPriceCriteria.get("start");
            return baseCriteria.add(Restrictions.eq("c.shareUnits", startUnit));
        }

        if (descriptorValue.equalsIgnoreCase("range")) {
            double startUnit = unitPriceCriteria.get("start");
            double endUnit = unitPriceCriteria.get("end");
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
    private List<Holder> searchTotalHoldings(List<Holder> holders, String descriptorValue, Map<String, Integer> holdingsCriteria) {
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
    
    @Override
    public List<Holder> queryShareholderAccount(String descriptor, Holder searchParams, Map<String, Integer> shareUnits_search, Map<String, Integer> totalHoldings_search) {
        //intial shareholder object, in case holder isnt searched
        Holder initialHolder = new Holder();
        initialHolder.setPryHolder(true);
        initialHolder.setMerged(false);
        
        //descriptor must be (default value) = holder:none;units:none;totalHoldings:none
        Map<String, String> descriptorSplits = Descriptor.decipherDescriptor(descriptor);
        String holderDescriptor = descriptorSplits.get("holder");
        String unitsDescriptor = descriptorSplits.get("units");
        String totalHoldingsDescriptor = descriptorSplits.get("totalHoldings");
        
        startOperation();
        Criteria baseCriteria = getStartCriteria();
        
        //we should assume that the result will consist of all base holders
        List<Holder> result = baseCriteria.list();
        Criteria shareHolderUnitCriteria;
        Criteria shareHolderSearchCriteria = baseCriteria; //shareholder search criteria must be initialised since it is being used in an isolated if statement
        //under the share unit price search (see if statement for clarification).
        
        if (holderDescriptor.equalsIgnoreCase("exact")) {
            shareHolderSearchCriteria = searchShareHolderAccordingToObject(baseCriteria, searchParams);
            result = shareHolderSearchCriteria.list();
        } else {
            baseCriteria.add(Example.create(initialHolder).enableLike());//ensure that only primary and non-merged holders are filtered out of list
        }
        
        //if shareholder was searched for, pass shareholder search criteria into unit search. Otherwise, use base criteria
        if (!unitsDescriptor.equalsIgnoreCase("none") && holderDescriptor.equalsIgnoreCase("exact")) {
            shareHolderUnitCriteria = searchShareUnitPrice(shareHolderSearchCriteria, unitsDescriptor, holderDescriptor, shareUnits_search);
            result = shareHolderUnitCriteria.list();
        } else if (!unitsDescriptor.equalsIgnoreCase("none") && !holderDescriptor.equalsIgnoreCase("exact")) {
            shareHolderUnitCriteria = searchShareUnitPrice(baseCriteria, unitsDescriptor, holderDescriptor, shareUnits_search);
            result = shareHolderUnitCriteria.list();
        }
        
        if (!totalHoldingsDescriptor.equalsIgnoreCase("none")) {
            result = searchTotalHoldings(result, totalHoldingsDescriptor, totalHoldings_search);
        }
        
        getTransaction().commit();
        
        return result;
    }

    @Override
    public List<HolderResidentialAddress> getHolderResidentialAddress(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HolderPostalAddress> getHolderPostalAddress(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HolderPhoneNumber> getHolderPhoneNumbers(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HolderEmailAddress> getHolderEmailAddresses(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean transferShareUnits(HolderCompanyAccount sender, HolderCompanyAccount receiver, int shareUnits) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean transferBondUnits(HolderBondAccount sender, HolderBondAccount receiver, int bondUnits, double unitPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasCompanyAccount(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasBondAccount(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HolderCompanyAccount> getAllHolderCompanyAccounts(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HolderBondAccount> getAllHolderBondAccounts(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean mergeHolderAccounts(Holder primaryHolder, List<Holder> secondaryHolders, List<HolderCompanyAccount> secHolderCompAccts, List<HolderBondAccount> secHolderBondAccts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean demergeHolderAccounts(Holder primaryHolder, Map<Holder, List<CompanyAccountConsolidation>> secondaryAcctInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Holder> getSecondaryHolderAccounts(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkInConsolidation(int pryHolderId, int secHolderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkInCompAcctConsolidation(int pryHolderId, int secHolderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkSecondaryHolders(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CompanyAccountConsolidation> getCompanyAccountMerges(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFinalUnitAfterTransfer(int holderId, int companyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AccountConsolidation> getAllHolderAccountConsolidation(String descriptor, String startDate, String endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CompanyAccountConsolidation> getCompAcctConsolidation(int acctConsolidationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createAdministratorForHolder(Holder holder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkCurrentPowerOfAttorney(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PowerOfAttorney getCurrentPowerOfAttorney(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkCurrentSignature(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HolderSignature getCurrentSignature(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean uploadPowerOfAttorney(PowerOfAttorney newPoa, PowerOfAttorney currentPoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean uploadHolderSignature(HolderSignature newSig, HolderSignature currentSig) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PowerOfAttorney getHolderPowerOfAttorney(int attorneyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PowerOfAttorney> getAllHolderPowerOfAttorney(int holderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkBank(int bankId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HolderType> getAllHolderTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BondOfferPaymentPlan> getAllBondOfferPaymentPlans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
