/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderChanges;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderEmailAddress;
import org.greenpole.hibernate.entity.HolderPhoneNumber;
import org.greenpole.hibernate.entity.HolderPostalAddress;
import org.greenpole.hibernate.entity.HolderResidentialAddress;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.greenpole.hibernate.query.HolderComponentQuery;

/**
 *
 * @author Akin
 */
public class HolderComponentQueryImpl extends GeneralisedAbstractDao implements HolderComponentQuery {

    @Override
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses, List<HolderPhoneNumber> phoneNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUpdateHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createHolderAccount(Holder holder, HolderBondAccount holderBondAccount, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses, List<HolderPhoneNumber> phoneNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUpdateHolderBondAccount(HolderBondAccount holderBondAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateHolderAccount(Holder holder, List<HolderResidentialAddress> residentialAddresses, List<HolderPostalAddress> postalAddresses, List<HolderPhoneNumber> phoneNumbers) {
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
    
    @Override
    public List<Holder> queryHolderAccount(String descriptor, Holder searchParams, Map<String, Integer> shareUnits_search, Map<String, Integer> totalHoldings_search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    
}
