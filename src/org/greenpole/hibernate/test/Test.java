/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.test;

import java.util.List;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

/**
 *
 * @author Akinwale Agbaje
 */
public class Test extends GeneralisedAbstractDao {
    
    public void testrun() {
        startOperation();
        Holder h = new Holder();
        h.setFirstName("%lala%");
        Criteria criteria = getSession().createCriteria(Holder.class)
                .add(Example.create(h).enableLike());
        List<Holder> hlist = criteria.list();
        getTransaction().commit();
        for (Holder hh : hlist) {
            System.out.println(hh.getFirstName());
        }
    }
    
    public void testholder() {
        startOperation();
        Holder holder = new Holder();
        holder.setFirstName("Tester");
        holder.setMiddleName("Middle name tester");
        holder.setLastName("Testie");
        holder.setGender("female");
        //holder.setChn("CHN3234");
        //holder.setDob("15/03/1985");
        holder.setTaxExempted(false);
        //holder.setResidentialAddresses(addylist);
        //holder.setPostalAddresses(addylist2);
        //holder.setEmailAddresses(emaillist);
        //holder.setPhoneNumbers(phonelist);
        //holder.setTypeId(1);
        //holder.setPryAddress(AddressTag.residential.toString());
        createUpdateObject(holder);
        getTransaction().commit();
    }
    
    public static void main(String[] args) {
        //new Test().testrun();
        new Test().testholder();
    }
}
