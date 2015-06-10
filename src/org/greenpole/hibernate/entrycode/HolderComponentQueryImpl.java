/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenpole.hibernate.entity.Caution;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.IpoApplication;
import org.greenpole.hibernate.entity.PrivatePlacement;
import org.greenpole.hibernate.entity.RightsIssue;
import org.greenpole.hibernate.entity.RightsIssueApplication;
import org.greenpole.hibernate.query.impl.ClientCompanyComponentQueryImpl;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ahmad.Gbadamosi
 */
public class HolderComponentQueryImpl extends GeneralisedAbstractDao {
    
    Session session;
    ClientCompanyDao clientDao;
    private static final Logger logger = LoggerFactory.getLogger(ClientCompanyComponentQueryImpl.class);    
    
    /*****************************PHASE TWO************************************/
    
    /**
     * Upload shareholder / bondholder details en-mass, for IPO, Right Issue, and Private Placement
     * Hibernate will cache all the persisted objects in the session-level cache and<p>
     * ultimately our application would fall over with an OutOfMemoryException,
     * <p>BATCH PROCRESS is implemented to avoid this
     * @param holderlist
     */
    public void uploadHolderDetailsenMass(List<Holder> holderlist){
        startOperation();
        //Hibernate will cache all the persisted objects in the session-level cache and 
        //ultimately our application would fall over with an OutOfMemoryException, BATCH PROCRESS is implemeted to avoid this
        //“for each iteration, assign the next element of Holderlist to Holder holder instance, then execute the following statement.”
        for (int counter = 0; counter < holderlist.size(); counter++) {
            Holder holder = holderlist.get(counter);
            createUpdateObject(holder);
            if (counter % 20 == 0) {
                getSession().flush();
                getSession().clear();
            }//end if
        }
        getTransaction().commit();
    }

    /**
     * Query cautioned shareholders / bondholders
     * All [holder type / both] accounts cautioned on DATE
     * @param holderType
     * @param cautionedDate
     * @return 
     */
    public List queryCautionedHolders(List<String> holderType, Date cautionedDate){
        startOperation();
        List<String> typesofholders = holderType;
        List<Holder> cautionedHolders = new ArrayList<>(); //dynamically initialise the size to accomodate additional object
        Criteria baseCriteria = getSession().createCriteria( Holder.class, "holder_alias" );
            
        Junction junxRestriction = Restrictions.disjunction();
            typesofholders.stream().forEach((typeholder) -> {
                junxRestriction.add(Restrictions.eq("holder_alias.type", typeholder).ignoreCase());
        });
            
        baseCriteria.createAlias("cautions", "caution_alias", JoinType.LEFT_OUTER_JOIN)
                .add(junxRestriction)                               //add(Restrictions.in("holder_alias.type", typeofholder ))
                .add(Restrictions.eq("caution_alias.cautionDate", cautionedDate));

        cautionedHolders = baseCriteria.list();
        getTransaction().commit();
        return cautionedHolders;
    }
    
    /**
     * Query cautioned shareholders / bondholders
     * All [holder type / both] accounts cautioned between DATE and DATE
     * @param holderType
     * @param cautionedStartDate
     * @param cautionedEndDate
     * @return 
     */
    public List queryCautionedHolders( List<String> holderType, Date cautionedStartDate, Date cautionedEndDate ){
        startOperation();
        List<String> typesofholders = holderType;
        List<Holder> cautionedHolders = new ArrayList<>();
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias");
        
        Junction junxRestriction = Restrictions.disjunction();
        typesofholders.stream().forEach((typeholder) -> {
            junxRestriction.add(Restrictions.eq("holder_alias.type", typeholder).ignoreCase());
        });
                baseCriteria.createAlias("cautions", "caution_alias", JoinType.LEFT_OUTER_JOIN)
                .add(junxRestriction)              //.add(Restrictions.in("holder_alias.type", typeofholder))
                .add(Restrictions.between("caution_alias.cautionDate", cautionedStartDate, cautionedEndDate));
        
        cautionedHolders = baseCriteria.list();
        getTransaction().commit();
        return cautionedHolders;
    }
    
    /**
     * Query cautioned shareholders / bondholders
     * All [holder type / both] accounts cautioned before DATE
     * @param holderType
     * @param cautionedStartDate
     * @return 
     */
    public List queryCautionedHoldersBefore(List<String> holderType, Date cautionedStartDate){
        startOperation();
        List<String> typesofholders = holderType;
        List<Holder> cautionedHolders = new ArrayList<>();
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias");
        Junction junxRestriction = Restrictions.disjunction();
        
        for (String typeholder : typesofholders) {
            junxRestriction.add(Restrictions.eq("holder_alias.type", typeholder).ignoreCase());
        }
        
        baseCriteria.createAlias("cautions", "caution_alias", JoinType.LEFT_OUTER_JOIN)
                .add(junxRestriction)
                .add(Restrictions.le("caution_alias.cautionDate", cautionedStartDate));
        cautionedHolders = baseCriteria.list();
        getTransaction().commit();
        return cautionedHolders;
    }
    
    /**
     * Query cautioned shareholders / bondholders
     * All [holder type / both] accounts cautioned after DATE
     * @param holderType
     * @param cautionedAfterDate
     * @return 
     */
    public List queryCautionedHoldersAfter(List<String> holderType, Date cautionedAfterDate){
        startOperation();
        List<String> typesofholders = holderType;
        List<Holder> cautionedHolders = new ArrayList<>();
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias");
        Junction junxRestriction = Restrictions.disjunction();
        
        for (String typeholder : typesofholders) {
            junxRestriction.add(Restrictions.eq("holder_alias.type", typeholder).ignoreCase());
        }
        
        baseCriteria.createAlias("cautions", "caution_alias", JoinType.LEFT_OUTER_JOIN)
                .add(junxRestriction)
                .add(Restrictions.le("caution_alias.cautionDate", cautionedAfterDate));
        cautionedHolders = baseCriteria.list();
        getTransaction().commit();
        return cautionedHolders;
    }
    
    /**
     * Caution and Uncaution Shareholder / Bondholder Account
     * @param cautioned
     * @return 
     */
    public boolean cautionHolder(Caution cautioned){
        boolean cautionCreated = false;
        try{
            startOperation();
            createUpdateObject(cautioned);
            getTransaction().commit();
            cautionCreated = true;
            return cautionCreated;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error cautioning the holder, please review your code! - ", he);
            return cautionCreated;
        }  
    }
    
    /**
     * Add and Adjust Share Units, using HolderCompanyAccount model
     * @param companyAccounts
     * @return 
     */
    public boolean updateHolderCompanyAccount( HolderCompanyAccount companyAccounts){
        boolean updateAccountObj = false;
        try{
            startOperation();
            createUpdateObject(companyAccounts);
            getTransaction().commit();
            updateAccountObj = true;
            return updateAccountObj;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error updating the respective holder companyaccount attributes, please review your code! - ", he);
            return updateAccountObj;
        }  
    }
    
   /*
    public List queryCautionedHoldersByObject(preDescriptor descriptor, Holder holder, Caution caution){
        List<Holder> cautionedHolder = new ArrayList<>();
        //switch(){}
    
        
        return null;
    }*/
    
    /**
     * Apply for Rights Issue
     */
    public boolean createRightsIssue(RightsIssue rightsissue){
        boolean rightissue_created = false;
        try{
            startOperation();
            createUpdateObject(rightsissue);
            getTransaction().commit();
            rightissue_created = true;
            return rightissue_created;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error persistiing Right issue, review and try again! - ", he);
            return rightissue_created;
        }
    }
    
    /**
     * Cancel Rights Issue
     */
    public RightsIssueApplication cancelRightIssue(Integer holderid){
    //List rightissueToCancel;
    startOperation();
    RightsIssueApplication rightissueTocancel = (RightsIssueApplication) searchObject(RightsIssueApplication.class, holderid);
    getTransaction().commit();
    return rightissueTocancel;
    }
    
    /**
     * Cancel IpoApplication
     * method to load a particular Ipo application
     * @param holderid : holder identifier whose ipoApplication is to be loaded
     */
    public IpoApplication cancelIpoApplication(Integer holderid){
    //List rightissueToCancel;
    startOperation();
    IpoApplication ipoTocancel = (IpoApplication) searchObject(IpoApplication.class, holderid);
    getTransaction().commit();
    return ipoTocancel;
    }
    
    /**
     * Cancel PrivatePlacement
     */
    public PrivatePlacement cancelPrivatePlacement(Integer holderid){
    //List rightissueToCancel;
    startOperation();
    PrivatePlacement ppTocancel = (PrivatePlacement) searchObject(PrivatePlacement.class, holderid);
    getTransaction().commit();
    return ppTocancel;
    }
    
    /**
     * Check availability of holder in the system
     * @param holderid
     * @return counter representing availability of the holder or false
     */
    public boolean checkHolderById(Integer holderid){
        startOperation();
        Criteria baseCriteria = getSession().createCriteria(Holder.class);
            baseCriteria.add(Restrictions.eqOrIsNull("id", holderid));
            if (baseCriteria != null) {
                baseCriteria.setProjection(Projections.rowCount());
                Long counter = (Long) baseCriteria.uniqueResult();
                getTransaction().commit();
                return counter > 0;
        } else 
                return false;   
    }
    
    /**
     * Check availability of holder in the system
     * @param chn
     * @return counter representing availability of the holder or false
     */
    public boolean checkHolderByCHN(String chn){
        startOperation();
        Criteria baseCriteria = getSession().createCriteria(Holder.class);
            baseCriteria.add(Restrictions.ilike("chn", "%" +chn+ "%"));
            if (baseCriteria != null) {
                baseCriteria.setProjection(Projections.rowCount());
                Long counter = (Long) baseCriteria.uniqueResult();
                getTransaction().commit();
                return counter > 0;
        } else 
                return false;   
    }
    
    /**
     * Retrieve an holder by Id
     * @param holderid
     * @return  an object of Holder
     */
    public Holder getHolderById(Integer holderid){
        startOperation();
        Criteria baseHolder = getSession().createCriteria(Holder.class);
            baseHolder.add(Restrictions.eq("id", holderid));
            Holder holder = (Holder) baseHolder.list().get(0);
        getTransaction().commit();
            return holder;
    }
    
    /**
     * Retrieve an holder by Id
     * @param holderid
     * @return  an object of Holder
     */
    public Holder getHolderByCHN(String chn){
        startOperation();
        Criteria baseHolder = getSession().createCriteria(Holder.class);
            baseHolder.add(Restrictions.ilike("chn", "%"+ chn + "%"));
            Holder holder = (Holder) baseHolder.list().get(0);
        getTransaction().commit();
            return holder;
    }
}
