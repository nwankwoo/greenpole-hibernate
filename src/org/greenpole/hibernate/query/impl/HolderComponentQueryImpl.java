/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
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
    public void createHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, HolderPostalAddress postalAddress, HolderPhoneNumber phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, HolderResidentialAddress residentialAddress, HolderPhoneNumber phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createHolderAccount(Holder holder, HolderBondAccount holderBondAccount, HolderPostalAddress postalAddress, HolderPhoneNumber phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createHolderCompanyAccount(HolderBondAccount holderBondAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createHolderAccount(Holder holder, HolderBondAccount holderBondAccount, HolderResidentialAddress residentialAddress, HolderPhoneNumber phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
