/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderPhoneNumber;
import org.greenpole.hibernate.entity.HolderPostalAddress;
import org.greenpole.hibernate.entity.HolderResidentialAddress;

/**
 *
 * @author Akinwale Agbaje
 */
public interface HolderComponentQuery {
    
    /**
     * Creates a new holder account, along with a holder company account.
     * This method is usually called when the holder's primary address is their
     * postal address.
     * @param holder the holder account to create
     * @param holderCompanyAccount the holder company account to create
     * @param postalAddress the holder's postal address
     * @param phoneNumber the holder's phone number
     * @return true, if create transaction is successful
     */
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, HolderPostalAddress postalAddress, 
            HolderPhoneNumber phoneNumber);
    
    /**
     * Creates a new holder company account.
     * This method is usually called in instances where a holder already exists
     * but does not have an account with a particular client company.
     * @param holderCompanyAccount the holder company account to create
     */
    public void createHolderCompanyAccount(HolderCompanyAccount holderCompanyAccount);
    
    /**
     * Creates a new holder account, along with a holder company account.
     * This method is usually called when the holder's primary address is their
     * postal address.
     * @param holder the holder account to create
     * @param holderCompanyAccount the holder company account to create
     * @param residentialAddress the holder's residential address
     * @param phoneNumber the holder's phone number
     * @return true, if create transaction is successful
     */
    public boolean createHolderAccount(Holder holder, HolderCompanyAccount holderCompanyAccount, HolderResidentialAddress residentialAddress,
            HolderPhoneNumber phoneNumber);
}
