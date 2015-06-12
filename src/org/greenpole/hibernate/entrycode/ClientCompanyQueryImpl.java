/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.greenpole.hibernate.entity.BondOffer;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.DividendDeclared;
import org.greenpole.hibernate.entity.DividendIssueType;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderResidentialAddress;
import org.greenpole.hibernate.entity.InitialPublicOffer;
import org.greenpole.hibernate.entity.PrivatePlacement;
import org.greenpole.hibernate.entity.Reconstruction;
import org.greenpole.hibernate.entity.RightsIssue;
import org.greenpole.hibernate.entity.RightsIssueApplication;
import org.greenpole.hibernate.entity.ShareBonus;
import org.greenpole.hibernate.entity.Stockbroker;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ahmad.Gbadamosi
 */
public class ClientCompanyQueryImpl extends GeneralisedAbstractDao {
    
    Session session;
    ClientCompanyDao clientDao;
    private static final Logger logger = LoggerFactory.getLogger(ClientCompanyQueryImpl.class);
    
    /***************************PHASE TWO QUERIES************************************/
    /**
     * Apply for Initial Public Offer (IPO)
     * create initial public offer by taken object of IPO from engine
     * @param ipo an object argument taken by this method
     * @return 
     */
    public boolean createIPO(InitialPublicOffer ipo){
        startOperation();
        boolean ipoCreation  = false;
        try{
            createUpdateObject(ipo);
            getTransaction().commit();
            ipoCreation = true;
            return ipoCreation;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error in persisting initial public offer application - please review", he);
            return false;
        }
    }
    
     /**
     * Apply for Initial Public Offer (IPO)
     * create private placement by taken object of PrivatePlacement from engine
     * @param privateplacemt an object argument taken by this method
     * @return 
     */
    public boolean createPrivatePlacement(PrivatePlacement privateplacemt){
        startOperation();
        boolean ppCreation  = false;
        try{
            createUpdateObject(privateplacemt);
            getTransaction().commit();
            ppCreation = true;
            return ppCreation;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error in persisting initial public offer application - please review", he);
            return false;
        }
    }  
    
    /**
     * View Bond Offer Report
     * @param bondTitle ,specify the bond title whether active or passive or both
     * @return List of object, BondOffer, Holder and HolderBondAccount
     */
    public List viewBondOfferReport(List<String> bondTitle){
        startOperation();
        List listofBondOfferInfo = new ArrayList<>();
        List<String> titles = bondTitle;
        Criteria baseCriteria = getSession().createCriteria(BondOffer.class, "bondoffer_alias");
        
        Junction junxRestriction = Restrictions.disjunction();
        titles.stream().forEach((bond_title) -> {
            junxRestriction.add(Restrictions.eq("bondoffer_alias.title", bond_title).ignoreCase());
        });
        
        baseCriteria.add(junxRestriction)
                .createAlias("bondoffer_alias.holderBondAccounts", "bondaccount_alias", JoinType.LEFT_OUTER_JOIN)
                .createAlias("bondaccount_alias.holder", "holder_alias", JoinType.LEFT_OUTER_JOIN);
        
        logger.debug("The query commands containing multiple tables needs to be review - ", baseCriteria);
        listofBondOfferInfo = baseCriteria.list();
        getTransaction().commit();
        return listofBondOfferInfo;
    }
    
    /**
     * Setup Rights Issue
     * @param rightIssue
     * @return 
     */
    public boolean setUpRightIssue(RightsIssue rightIssue){
        startOperation();
        boolean rightissuePersisted = false;
        try{
            createUpdateObject(rightIssue);
            getTransaction().commit();
            rightissuePersisted = true;
            return rightissuePersisted;
           }catch(HibernateException he){
               getTransaction().rollback();
               logger.info("error occured while persisting your request, please review! - ", he);
               return rightissuePersisted;
           }
    }
    
/**
     * View IPO Reports based on date range that falls opening and closing Date
     * @param companyid
     * @param startDate
     * @param endDate
     * @param dateDescriptor
     * @return list of object of InitialPublicOffer, ClearingHouse, IpoApplication <p/> 
     * by creating criteria of IpoApplication
     */
    public List viewIPOReport(int companyid, Date startDate, Date endDate, String dateDescriptor){
        //Date startDate = initialoffer.getOpeningDate();
        startOperation();
        List listofInitialOffer = new ArrayList<>();
        Criteria baseCriteria = getSession().createCriteria(InitialPublicOffer.class, "ipo_alias");
        baseCriteria.add(Restrictions.eq("id", companyid));
        
        Criterion startCriterion = Restrictions.eq("ipo_alias.openingDate", this);
        Criterion endCriterion = Restrictions.eq("ipo_alias.closingDate", this);
        Criterion startBtwCriterion = Restrictions.ge("ipo_alias.openingDate", startDate);
        Criterion endBtwCriterion = Restrictions.le("ipo_alias.closingDate", endDate);
        
        Disjunction exactJxtn = Restrictions.disjunction();
        exactJxtn.add(startCriterion).add(endCriterion);
        
        Conjunction searchConjunction = Restrictions.conjunction();
        searchConjunction.add(startCriterion);
        searchConjunction.add(endCriterion);
        baseCriteria.createAlias("ipo_alias.ipoApplications", "ipoapplicatn_alias", JoinType.LEFT_OUTER_JOIN) //add the IpoApplication object to access ClearingHouse object using only the associatedPath and alias
                .createAlias("ipoapplicatn_alias.clearingHouse", "clearhouse_alias", JoinType.LEFT_OUTER_JOIN); 
        if (dateDescriptor.equalsIgnoreCase("exact")) {
            baseCriteria.add(exactJxtn);
        }
        else if(dateDescriptor.equalsIgnoreCase("before")){
            baseCriteria.add(endBtwCriterion);
        }
        else if (dateDescriptor.equalsIgnoreCase("after")) {
            baseCriteria.add(startBtwCriterion);
        }
        else if (dateDescriptor.equalsIgnoreCase("between")) {
            baseCriteria.add(searchConjunction);
        }
        listofInitialOffer = baseCriteria.list();
        getTransaction().commit();
        return listofInitialOffer;
    }

/**
     * View IPO Reports based on date range that falls opening and closing Date
     * @param companyid
     * @param startDate
     * @param endDate
     * @param dateDescriptor
     * @param dateFormat
     * @return list of object of InitialPublicOffer, ClearingHouse, IpoApplication <p/> 
     * by creating criteria of IpoApplication
     */
    public List viewIPOReportTakenString(int companyid, String startDate, String endDate, String dateDescriptor, String dateFormat){
        SimpleDateFormat simpleFormatter = new SimpleDateFormat(dateFormat);
        List listofInitialOffer = new ArrayList<>();
        startOperation();
            Criteria baseCriteria = getSession().createCriteria(InitialPublicOffer.class, "ipo_alias");
            baseCriteria.add(Restrictions.eq("ipo_alias.clientCompany", companyid));
//http://www.java4s.com/hibernate/difference-between-wrapper-and-primitive-types-in-hibernate/
            try{
                Criterion ipo_openCriterion = Restrictions.eq("ipo_alias.openingDate", simpleFormatter.parse(startDate));
                Criterion ipo_endCriterion = Restrictions.eq("ipo_alias.closingDate", simpleFormatter.parse(endDate));
                Criterion ipo_startBtwCriterion = Restrictions.ge("ipo_alias.openingDate", simpleFormatter.parse(startDate));
                Criterion ipo_endBtwCriterion = Restrictions.le("ipo_alias.closingDate", simpleFormatter.parse(endDate));
           
                Disjunction disjunxtn = Restrictions.disjunction();
                disjunxtn.add(ipo_openCriterion).add(ipo_endCriterion);

                Conjunction searchConjunction = Restrictions.conjunction();
                searchConjunction.add(ipo_startBtwCriterion);
                searchConjunction.add(ipo_endBtwCriterion);

                baseCriteria.createAlias("ipo_alias.ipoApplications", "ipoapplicatn_alias", JoinType.LEFT_OUTER_JOIN) //add the IpoApplication object to access ClearingHouse object using only the associatedPath and alias
                            .createAlias("ipoapplicatn_alias.clearingHouse", "clearhouse_alias", JoinType.LEFT_OUTER_JOIN); 
                if (dateDescriptor.equalsIgnoreCase("exact")){
                    baseCriteria.add(disjunxtn);
                }
                else if(dateDescriptor.equalsIgnoreCase("before")){
                    baseCriteria.add(ipo_endBtwCriterion);
                }
                else if(dateDescriptor.equalsIgnoreCase("after")){
                    baseCriteria.add(ipo_startBtwCriterion);
                }
                else if(dateDescriptor.equalsIgnoreCase("between")){
                    baseCriteria.add(searchConjunction);
                }
            }catch(ParseException dateerror){
                logger.error("error passing the date format, rreview!", dateerror);
                }
                listofInitialOffer = baseCriteria.list();
                getTransaction().commit();
                return listofInitialOffer;
    }

/**
     *   View Rights Issue Reports
     * @param companyid
     * @param startDate
     * @param endDate
     * @param dateDescriptor
     * @return 
     */
    public List viewRightsIssueReport(int companyid, Date startDate, Date endDate, String dateDescriptor){
        //Date startDate = initialoffer.getOpeningDate();
        startOperation();
        List listofrightissueReports = new ArrayList<>();
        Criteria baseCriteria = getSession().createCriteria(RightsIssue.class, "rightissues_alias");
        baseCriteria.add(Restrictions.eq("id", companyid));
        
        Criterion startCriterion = Restrictions.eq("rightissues_alias.openingDate", startDate);
        Criterion endCriterion = Restrictions.eq("rightissues_alias.closingDate", endDate);
        Criterion startBtwCriterion = Restrictions.ge("rightissues_alias.openingDate", startDate);
        Criterion endBtwCriterion = Restrictions.le("rightissues_alias.closingDate", endDate);
        
        Disjunction exactJxtn = Restrictions.disjunction();
        exactJxtn.add(startCriterion).add(endCriterion);
        
        Conjunction searchConjunction = Restrictions.conjunction();
        searchConjunction.add(startCriterion);
        searchConjunction.add(endCriterion);
        
        baseCriteria.add(searchConjunction)
                .createAlias("rightissues_alias.rightsIssueApplications", "rightissue_ppapplicatn_alias", JoinType.LEFT_OUTER_JOIN) //add the IpoApplication object to access ClearingHouse object using only the associatedPath and alias
                .createAlias("rightissue_ppapplicatn_alias.clearingHouse", "rightissue_clearhouse_alias", JoinType.LEFT_OUTER_JOIN); 
        if (dateDescriptor.equalsIgnoreCase("exact")) {
            baseCriteria.add(exactJxtn);
        }
        else if (dateDescriptor.equalsIgnoreCase("before")) {
            baseCriteria.add(endBtwCriterion);
        }
        else if (dateDescriptor.equalsIgnoreCase("after")) {
            baseCriteria.add(startBtwCriterion);
        }
        else if (dateDescriptor.equalsIgnoreCase("between")) {
            baseCriteria.add(searchConjunction);
        }
        listofrightissueReports = baseCriteria.list();
        getTransaction().commit();
        return listofrightissueReports;
    }
    
    public List viewRightIssueReportTakenString(int companyid, String startDate, String endDate, String dateDescriptor, String dateFormat){
        SimpleDateFormat simpleFormatter = new SimpleDateFormat(dateFormat);
        List listofRightsIssue = new ArrayList<>();
        startOperation();
            Criteria baseCriteria = getSession().createCriteria(RightsIssue.class, "right_alias");
            baseCriteria.add(Restrictions.eq("right_alias.clientCompany", companyid));
//http://www.java4s.com/hibernate/difference-between-wrapper-and-primitive-types-in-hibernate/
            try{
                Criterion right_openCriterion = Restrictions.eq("right_alias.openingDate", simpleFormatter.parse(startDate));
                Criterion right_endCriterion = Restrictions.eq("right_alias.closingDate", simpleFormatter.parse(endDate));
                Criterion right_startBtwCriterion = Restrictions.ge("right_alias.openingDate", simpleFormatter.parse(startDate));
                Criterion right_endBtwCriterion = Restrictions.le("right_alias.closingDate", simpleFormatter.parse(endDate));
           
                Disjunction disjunxtn = Restrictions.disjunction();
                disjunxtn.add(right_openCriterion).add(right_endCriterion);

                Conjunction searchConjunction = Restrictions.conjunction();
                searchConjunction.add(right_startBtwCriterion);
                searchConjunction.add(right_endBtwCriterion);

                baseCriteria.createAlias("right_alias.rightsIssueApplications", "rightapp_alias", JoinType.LEFT_OUTER_JOIN) //add the IpoApplication object to access ClearingHouse object using only the associatedPath and alias
                            .createAlias("rightapp_alias.clearingHouse", "clearhouse_alias", JoinType.LEFT_OUTER_JOIN); 
                if (dateDescriptor.equalsIgnoreCase("exact")){
                    baseCriteria.add(disjunxtn);
                }
                else if(dateDescriptor.equalsIgnoreCase("before")){
                    baseCriteria.add(right_endBtwCriterion);
                }
                else if(dateDescriptor.equalsIgnoreCase("after")){
                    baseCriteria.add(right_startBtwCriterion);
                }
                else if(dateDescriptor.equalsIgnoreCase("between")){
                    baseCriteria.add(searchConjunction);
                }
            }catch(ParseException dateerror){
                logger.error("error passing the date format, rreview!", dateerror);
                }
                listofRightsIssue = baseCriteria.list();
                getTransaction().commit();
                return listofRightsIssue;
    }


   /**
     *   View Private Placement Reports
     * @param companyid
     * @param startDate
     * @param endDate
     * @param dateDescriptor
     * @return 
     */
    public List viewPPReport(int companyid, String startDate, String endDate, String dateDescriptor){
        
        //SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        //Date startDate = initialoffer.getOpeningDate();
        startOperation();
        List listofppReports = new ArrayList<>();
        Criteria baseCriteria = getSession().createCriteria(PrivatePlacement.class, "pp_alias");
        baseCriteria.add(Restrictions.eq("id", companyid));
        
        Criterion startCriterion = Restrictions.eq("pp_alias.openingDate", startDate);
        Criterion endCriterion = Restrictions.eq("pp_alias.closingDate", endDate);
        Criterion startBtwCriterion = Restrictions.ge("pp_alias.openingDate", startDate  );
        Criterion endBtwCriterion = Restrictions.le("pp_alias.closingDate", endDate );
        
        Disjunction exactJxtn = Restrictions.disjunction();
        exactJxtn.add(startCriterion).add(endCriterion);
        
        Conjunction searchConjunction = Restrictions.conjunction();
        searchConjunction.add(startBtwCriterion);
        searchConjunction.add(endBtwCriterion);
        
        baseCriteria.createAlias("pp_alias.privatePlacementApplications", "pp_ppapplicatn_alias") //add the IpoApplication object to access ClearingHouse object using only the associatedPath and alias
                .createAlias("pp_ppapplicatn_alias.clearingHouse", "pp_clearhouse_alias", JoinType.LEFT_OUTER_JOIN); 
        if (dateDescriptor.equalsIgnoreCase("exact")) {
            baseCriteria.add(exactJxtn);
        }
        else if (dateDescriptor.equalsIgnoreCase("before")) {
            baseCriteria.add(endBtwCriterion);
        }
        else if (dateDescriptor.equalsIgnoreCase("after")) {
            baseCriteria.add(startBtwCriterion);
        }
        else if (dateDescriptor.equalsIgnoreCase("between")) {
            baseCriteria.add(searchConjunction);
        }
        listofppReports = baseCriteria.list();
        getTransaction().commit();
        return listofppReports;
    }


/**
     * View Private Placement Reports based on date range that falls opening and closing Date
     * @param companyid
     * @param startDate
     * @param endDate
     * @param dateDescriptor
     * @param dateFormat
     * @return list of object of InitialPublicOffer, ClearingHouse, IpoApplication <p/> 
     * by creating criteria of IpoApplication
     */
    public List viewPPReportTakenString(int companyid, String startDate, String endDate, String dateDescriptor, String dateFormat){
        SimpleDateFormat simpleFormatter = new SimpleDateFormat(dateFormat);
        List listofprivateplacmt = new ArrayList<>();
        startOperation();
            Criteria baseCriteria = getSession().createCriteria(PrivatePlacement.class, "pp_alias");
            baseCriteria.add(Restrictions.eq("pp_alias.clientCompany", companyid));
            try{
                Criterion pp_openCriterion = Restrictions.eq("pp_alias.openingDate", simpleFormatter.parse(startDate));
                Criterion pp_endCriterion = Restrictions.eq("pp_alias.closingDate", simpleFormatter.parse(endDate));
                Criterion pp_startBtwCriterion = Restrictions.ge("pp_alias.openingDate", simpleFormatter.parse(startDate));
                Criterion pp_endBtwCriterion = Restrictions.le("pp_alias.closingDate", simpleFormatter.parse(endDate));
           
                Disjunction disjunxtn = Restrictions.disjunction();
                disjunxtn.add(pp_openCriterion).add(pp_endCriterion);

                Conjunction searchConjunction = Restrictions.conjunction();
                searchConjunction.add(pp_startBtwCriterion);
                searchConjunction.add(pp_endBtwCriterion);

                baseCriteria.createAlias("pp_alias.privatePlacementApplications", "ppapp_alias", JoinType.LEFT_OUTER_JOIN) //add the IpoApplication object to access ClearingHouse object using only the associatedPath and alias
                            .createAlias("ppapp_alias.clearingHouse", "clearhouse_alias", JoinType.LEFT_OUTER_JOIN); 
                if (dateDescriptor.equalsIgnoreCase("exact")){
                    baseCriteria.add(disjunxtn);
                }
                else if(dateDescriptor.equalsIgnoreCase("before")){
                    baseCriteria.add(pp_endBtwCriterion);
                }
                else if(dateDescriptor.equalsIgnoreCase("after")){
                    baseCriteria.add(pp_startBtwCriterion);
                }
                else if(dateDescriptor.equalsIgnoreCase("between")){
                    baseCriteria.add(searchConjunction);
                }
            }catch(ParseException dateerror){
                logger.error("error passing the date format, rreview!", dateerror);
                }
                listofprivateplacmt = baseCriteria.list();
                getTransaction().commit();
                return listofprivateplacmt;
    }

/**
     * @param companyid
     * @param dateDescriptor
     * @param reportDescriptor
     * @param startdate
     * @param enddate
     * @param dateFormat
     * @return 
	 */
public List viewGeneralCorporateReports(Integer companyid, String dateDescriptor, String reportDescriptor, String startdate, String enddate, String dateFormat){
        
        //reportDescriptor is either ipo; right; or pp
        //dateDescriptor is either exact; before; after; or between
        SimpleDateFormat simpleFormatter = new SimpleDateFormat(dateFormat);
        Criteria baseCriteria;
        List returnedObjects = new ArrayList<>() ;
        startOperation();
        try{ 
                        //define restrictions for initial public offer requirement
            Criterion ipo_openCriterion = Restrictions.eq("ipo_alias.openingDate", simpleFormatter.parse(startdate));
            Criterion ipo_endCriterion = Restrictions.eq("ipo_alias.closingDate", simpleFormatter.parse(enddate));
            Criterion ipo_startBtwCriterion = Restrictions.ge("ipo_alias.openingDate", simpleFormatter.parse(startdate));
            Criterion ipo_endBtwCriterion = Restrictions.le("ipo_alias.closingDate", simpleFormatter.parse(enddate));
            //Or test criterion
            Disjunction ipo_exactDisjxtn = Restrictions.disjunction();
            ipo_exactDisjxtn.add(ipo_openCriterion);
            ipo_exactDisjxtn.add(ipo_endCriterion);
            //And or Between criterion
            Conjunction ipo_searchConjunction = Restrictions.conjunction();
            ipo_searchConjunction.add(ipo_startBtwCriterion);
            ipo_searchConjunction.add(ipo_endBtwCriterion);
            
            //define restrictions for PrivatePlacement requirement
            Criterion pp_openCriterion = Restrictions.eq("pp_alias.openingDate", simpleFormatter.parse(startdate));
            Criterion pp_endCriterion = Restrictions.eq("pp_alias.closingDate", simpleFormatter.parse(enddate));
            Criterion pp_startBtwCriterion = Restrictions.ge("pp_alias.openingDate", simpleFormatter.parse(startdate));
            Criterion pp_endBtwCriterion = Restrictions.le("pp_alias.closingDate", simpleFormatter.parse(enddate));
            //Or test criterion for Private Placement
            Disjunction pp_exactDisjxtn = Restrictions.disjunction();
            pp_exactDisjxtn.add(pp_openCriterion).add(pp_endCriterion);
            //And or Between criterion for Private Placement
            Conjunction pp_searchConjunction = Restrictions.conjunction();
            pp_searchConjunction.add(pp_startBtwCriterion).add(pp_endBtwCriterion);
            
            //define restrictions for RightsIssue requirement
            Criterion right_openCriterion = Restrictions.eq("right_alias.openingDate", simpleFormatter.parse(startdate));
            Criterion right_endCriterion = Restrictions.eq("right_alias.closingDate", simpleFormatter.parse(enddate));
            Criterion right_startBtwCriterion = Restrictions.ge("right_alias.openingDate", simpleFormatter.parse(startdate));
            Criterion right_endBtwCriterion = Restrictions.le("right_alias.closingDate", simpleFormatter.parse(enddate));
            //Or test criterion for RightsIssue
            Disjunction right_exactDisjxtn = Restrictions.disjunction();
            right_exactDisjxtn.add(right_openCriterion).add(right_endCriterion);
            //And or Between criterion for RightsIssue
            Conjunction right_searchConjunction = Restrictions.conjunction();
            right_searchConjunction.add(right_startBtwCriterion).add(right_endBtwCriterion);
        if( reportDescriptor.equalsIgnoreCase("ipo") ){
            baseCriteria = getSession().createCriteria(InitialPublicOffer.class, "ipo_alias")
                            .add(Restrictions.eq("ipo_alias.clientCompany", companyid))
                            .createAlias("ipo_alias.ipoApplications", "ipoapp_alias", JoinType.LEFT_OUTER_JOIN)
                            .createAlias("ipoapp_alias.clearingHouse", "clearhouse_alias", JoinType.LEFT_OUTER_JOIN);
                if (dateDescriptor.equalsIgnoreCase("exact")) {
                    baseCriteria.add(ipo_exactDisjxtn);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                } //end inner if
                else if (dateDescriptor.equalsIgnoreCase("before")) {
                    baseCriteria.add(ipo_endBtwCriterion);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
                else if (dateDescriptor.equalsIgnoreCase("after")) {
                    baseCriteria.add(ipo_startBtwCriterion);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
                else if (dateDescriptor.equalsIgnoreCase("between")) {
                    baseCriteria.add(ipo_searchConjunction);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
            }//end outer if for ipo descriptor
            if (reportDescriptor.equalsIgnoreCase("pp")) {
                baseCriteria = getSession().createCriteria(PrivatePlacement.class, "pp_alias")
                        .add(Restrictions.eq("pp_alias.clientCompany", companyid))
                        .createAlias("pp_alias.privatePlacementApplications", "ppapp_alias", JoinType.LEFT_OUTER_JOIN)
                        .createAlias("ppapp_alias.clearingHouse", "clearhouse_alias", JoinType.LEFT_OUTER_JOIN);
                if (dateDescriptor.equalsIgnoreCase("exact")) {
                    baseCriteria.add(pp_exactDisjxtn);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
                else if (dateDescriptor.equalsIgnoreCase("before")) {
                    baseCriteria.add(pp_endBtwCriterion);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
                else if (dateDescriptor.equalsIgnoreCase("after")) {
                    baseCriteria.add(pp_startBtwCriterion);
                    returnedObjects = baseCriteria.list();
                    getTransaction().commit();
                    //return returnedObjects;
                }
                else if (dateDescriptor.equalsIgnoreCase("between")) {
                    baseCriteria.add(pp_searchConjunction);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
            }//end outer if for private placement descriptor
            if (reportDescriptor.equalsIgnoreCase("right")) {
                baseCriteria = getSession().createCriteria(RightsIssue.class, "right_alias")
                        .add(Restrictions.eq("right_alias.clientCompany", companyid))
                        .createAlias("right_alias.rightsIssueApplications", "rightapp_alias", JoinType.LEFT_OUTER_JOIN)
                        .createAlias("rightapp_alias.clearingHouse", "clearhouse_alias", JoinType.LEFT_OUTER_JOIN);
                if (dateDescriptor.equalsIgnoreCase("exact")) {
                    baseCriteria.add(right_exactDisjxtn);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
                else if (dateDescriptor.equalsIgnoreCase("before")) {
                    baseCriteria.add(right_endBtwCriterion);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
                else if (dateDescriptor.equalsIgnoreCase("after")) {
                    baseCriteria.add(right_startBtwCriterion);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
                else if (dateDescriptor.equalsIgnoreCase("between")) {
                    baseCriteria.add(right_searchConjunction);
                    returnedObjects = baseCriteria.list();
                    //getTransaction().commit();
                    //return returnedObjects;
                }
            }//end outer if for RightsIssue
        }catch(ParseException dateerror){
            logger.error("error passing date format, please review! - ", dateerror);
        }
        getTransaction().commit();
        return returnedObjects;
    }
   
    /**
     * Declare Share Bonus: declare share bonus for client company.
     * @param sharebonus : a sharebonus object to persist
     * @return : a boolean type to show status of the query
     */
    public boolean declareShareBonus(ShareBonus sharebonus){
        boolean bonusDeclared = false;
        startOperation();
        try{
            createUpdateObject(sharebonus);
            getTransaction().commit();
            bonusDeclared = true;
            return bonusDeclared;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error persisting the Share Bonus declared, review! - ", he);
            return bonusDeclared;
        }
    }
    
    /**
     * Apply stock split [share reconstruction] : 
     * to increase or decrease overall company shares and maintain </p>
     * its ratio by increase or decrease the share unit price
     */
    
    /**
     * Query shareholder list :using companyid through </p>
     * HolderCompanyAccount entity that associated holder and company
     * @param companyid : accepted parameter for search
     * @return 
     */
    public List getAllHoldersUnderCompanyById(int  companyid){
        List listofholders = new ArrayList<>();
        startOperation();
       /* String searchQuery = ("from Holder as holders where holders.id in "
                + "(select companyaccount.holders.id from HolderCompanyAccount as "
                + "companyaccount where companyaccount.clientcompany.id = '"+ companyid +"')");
        Query querySearch = getSession().createQuery(searchQuery);
        listofholders = querySearch.list(); */
        DetachedCriteria companySubquery = DetachedCriteria.forClass(HolderCompanyAccount.class, "holdercompany_alias");
        companySubquery.setProjection(Property.forName("holder"));
        companySubquery.createCriteria("holdercompany_alias.id.clientCompanyId", "clientcompany_alias")
                .add(Restrictions.eq("clientcompany_alias.id", companyid));
        
        Criteria holderCriteria = getSession().createCriteria(Holder.class, "holder_alias");
        holderCriteria.add(Subqueries.propertyIn("id", companySubquery))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        
        listofholders = holderCriteria.list();
        getTransaction().commit();
        return listofholders;
    }

    /**
     * Query shareholder list :using companyid and holder gender through </p>
     * HolderCompanyAccount entity that associated holder and company
     * @param companyid : accepted parameter for search
     * @param sextype   : holder sex
     * @return 
     */
    public List getAllHoldersUnderCompanyByGender(int companyid, String sextype){
        List listofholders = new ArrayList<>();
        startOperation();
        
    /*    String searchQuery = ("from Holder as holders where holders.gender = '" + sextype +"' and holders.id in "
                + "(select companyaccount.holders.id from HolderCompanyAccount as "
                + "companyaccount where companyaccount.clientcompany.id = '"+ companyid +"')");
        Query querySearch = getSession().createQuery(searchQuery);
        listofholders = querySearch.list(); 
        getTransaction().commit();
        return listofholders;
        */
        DetachedCriteria companySubquery = DetachedCriteria.forClass(HolderCompanyAccount.class, "holdercompany_alias");
        companySubquery.setProjection(Property.forName("holder"));
        companySubquery.createCriteria("holdercompany_alias.clientCompany", "clientcompany_alias")
                .add(Restrictions.eq("id", companyid));
        
        Criteria holderCriteria = getSession().createCriteria(Holder.class, "holder_alias");
        holderCriteria.add(Subqueries.propertyIn("id", companySubquery))
                .add(Restrictions.eq("gender", sextype))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        
        listofholders = holderCriteria.list();
        getTransaction().commit();
        return listofholders;
        
    }
    
    /**
     * Query shareholder list :using companyid and holder gender through </p>
     * HolderCompanyAccount entity that associated holder and company
     * @param companyid : accepted parameter for search
     * @param brokerid
     * @return 
     */
    public List getAllHoldersUnderCompanyByBroker(Integer companyid, int brokerid){
        startOperation();
        List listofholders = new ArrayList<>();
        
    /*    String searchQuery = ("from Holder as holders where holders.id IN "
                + "(select companyaccount.holders.id from HolderCompanyAccount as companyaccount where companyaccount.clientcompany.id = '"+ companyid +"') "
                + "and IN (select joint_alias.holders from Stockbroker broker_alias, IN(broker_alias.holders) joint_alias where broker_alias.id='"+brokerid+"' )");

        Query querySearch = getSession().createQuery(searchQuery);
        listofholders = querySearch.list(); */
        
        //select holder from holdercompanyacct inner join clientcompany where where company id =?
        DetachedCriteria companySubquery = DetachedCriteria.forClass(HolderCompanyAccount.class, "holdercompany_alias");
                companySubquery.setProjection(Property.forName("holdercompany_alias.holder"))
                .createCriteria("holdercompany_alias.clientCompany", "clientcompany_alias")
                        .add(Restrictions.eq("clientcompany_alias.id", companyid));
        //subselect query to retrieve broker identifier
        DetachedCriteria stockbrokerSubquery = DetachedCriteria.forClass(Stockbroker.class, "broker_alias");
                stockbrokerSubquery.setProjection(Property.forName("broker_alias.holders"))
                        .add(Restrictions.eq("id", brokerid));
        //combine the subselect queries using and logical expression        
        Junction combineSubqueries = Restrictions.conjunction();
                combineSubqueries.add(Restrictions.and(Subqueries.propertyIn("id", companySubquery), 
                        Subqueries.propertyIn("id", stockbrokerSubquery)));
        
        Criteria holderCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                        .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                holderCriteria.add(combineSubqueries);
        
        getTransaction().commit();
        return listofholders;
    }
    
    /**
     * Query shareholder list :using companyid and holder gender through </p>
     * HolderCompanyAccount entity that associated holder and company
     * @param companyid : accepted parameter for search
     * @param lowAge
     * @param highAge
     * @return qualifiedHoldersList
     */
    public List getAllHoldersUnderCompanyByAge(Integer companyid, int lowAge, int highAge){
        startOperation();
        List listofholders = new ArrayList<>();
        List qualifiedHoldersList = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR); //get the current year in integer format
        
        DetachedCriteria companySubquery = DetachedCriteria.forClass(HolderCompanyAccount.class, "holdercompany_alias")
                .setProjection(Property.forName("holdercompany_alias.holder"));
                companySubquery.createCriteria("holdercompany_alias.clientCompany", "clientcompany_alias")
                        .add(Restrictions.eq("clientcompany_alias.id", companyid));
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .add(Subqueries.propertyIn("holder_alias.id", companySubquery));
        
        listofholders = baseCriteria.list();
            for(Object holder : listofholders){
                Holder currentHolder = (Holder) holder;
                Date dob  = currentHolder.getDob();
                int holderAge = currentYear - this.getBirthYear(dob);
                
                if (holderAge >= lowAge && holderAge <= highAge) {
                    qualifiedHoldersList.add(holder);
                }
        }
        getTransaction().commit();
        return qualifiedHoldersList;
    }
    
    /**
     * Extractor method to extract a particular year from date of birth </p>
     * of an holder retrieved from the database
     * @param dateOfBirth the full date format retrieving from DB, to be extracted
     * @return year of integer type
     */
    public int getBirthYear(Date dateOfBirth){
        String[] dates = dateOfBirth.toString().split("-"); //split the date string around matches of the given regular "-"
        int year = 0;
        for (String dateToken : dates) {
            if (dateToken.length() == 4) {      //check where the length of the figure is 4
                year = Integer.parseInt(dateToken); //convert the string to int
            }
        }
        return year;
    }
    
    /**
     * Query shareholder list : using companyid and holder address
    */
    public List getAllHoldersUnderCompanyByHolderAddress(Integer companyid, String address){
        startOperation();
        List listofholders = new ArrayList<>();
        Holder holder = new Holder();
        List<HolderResidentialAddress> addresses = new ArrayList<>(holder.getHolderResidentialAddresses());
        //get each address index 
        HolderResidentialAddress each_address = addresses.get(0);
        
        //select holderid from HCA inner join CC on HCA.CompanyId = CC.id where CC.id = ?
        DetachedCriteria compAcctSubquery = DetachedCriteria.forClass(HolderCompanyAccount.class, "compacct_alias")
                .setProjection(Property.forName("compacct_alias.holder"))
                .createCriteria("compacct_alias.clientCompany", "clientcomp")
                .add(Restrictions.eq("clientcomp.id", companyid));
        //from Holder where in (compAcctSubquery) left outer join Address
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .add(Subqueries.propertyIn("id", compAcctSubquery))
                .createCriteria("holder_alias.holderResidentialAddresses", "address_alias", JoinType.LEFT_OUTER_JOIN);
        //search through the address queryy object
            String searchableAddress = each_address.getAddressLine1();
            if (searchableAddress != null){
                baseCriteria.add(Restrictions.ilike("address_alias.id.addressLine1", address, MatchMode.ANYWHERE));
            }
            String searchableCity = each_address.getCity();
            if (searchableCity != null){
                baseCriteria.add(Restrictions.ilike("address_alias.city", address, MatchMode.ANYWHERE));
            }
            String searchablePostcode = each_address.getPostCode();
            if (searchablePostcode != null){
                baseCriteria.add(Restrictions.ilike("address_alias.postCode", address, MatchMode.ANYWHERE));
            }
            String searchableState = each_address.getState();
            if (searchableState != null) {
                baseCriteria.add(Restrictions.ilike("address_alias.id.state", address, MatchMode.ANYWHERE));
            }
            String searchableCountry = each_address.getCountry();
            if (searchableCountry != null) {
                baseCriteria.add(Restrictions.ilike("address_alias.id.country", address, MatchMode.ANYWHERE));
            }
        
        listofholders = baseCriteria.list();
        getTransaction().commit();
        return listofholders;
    } 
    
    /**
     * Apply stock split [share reconstruction] and Apply reverse stock split [share reconstruction]
     * persist or update the share volume respective shareholder based on criteria for 
     * qualification which directly affect the affected company undergoing reconstruction  </p> 
     * @param reconstruction object to be persisted or updated
     */
    public boolean stockSplit(Reconstruction reconstruction){
        startOperation();
        boolean successful = false;

        try{
            createUpdateObject(reconstruction);
            getTransaction().commit();
            successful = true;
            return successful;
        }catch(HibernateException he){
            logger.info("error persisting reconstruction, review! - ", he);
            getTransaction().rollback();
            return successful;
        }
        
    }
    
    /**
     * resultant query after the rule for Reconstruction is set
     * for confirmation
     * @param companyid ,company db identifier for reconstruction
     * @return list of Holder with their respective share unit and volume
     */
    public List queryToReconstruct(Integer companyid){
        startOperation();
        List listofaccountsaffected = new ArrayList<>();
        
        //select unitprice from shareQuotation inner join clientcompany where companyid=?
        DetachedCriteria companyacctCriteria = DetachedCriteria.forClass(ClientCompany.class, "company_alias")
                .createCriteria("quotatn_alias.shareQuotations", "quotatn_alias")
                .setProjection(Property.forName("quotatn_alias.unitPrice"))
                .add(Restrictions.eq("quotatn_alias.clientCompany", companyid)); 
        
        //select from Holder left outer join HoldercompanyAccount where in (subquery)       
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .createCriteria("holder_alias.holderCompanyAccounts", "companyacct", JoinType.LEFT_OUTER_JOIN)
                .setProjection(Property.forName("companyacct.shareUnits")) //select the share volume from HolderCompanyAccount
                .add(Subqueries.propertyIn("companyacct.clientCompany", companyacctCriteria));
        
        listofaccountsaffected =  baseCriteria.list();
        getTransaction().commit();
        return listofaccountsaffected;
    }
    
    /**
     * Query bondholder list by company identifier
     * @param companyid : Client company whose bond list need to be retrieved
     * @return listofbondholders : list of bondholders under a particular company
     */
    public List getAllBondHolderByCompanyId(Integer companyid){
        startOperation();
        List listofbondholders = new ArrayList<>();
        //select id from BondOffer where clientcompanyid = ?
        DetachedCriteria firstSubquery = DetachedCriteria.forClass(BondOffer.class, "bondoffer_alias")
                .setProjection(Property.forName("bondoffer_alias.id"))
                .add(Restrictions.eq("bondoffer_alias.clientCompany", companyid));
        //select holderid from HolderBondAccount where bondofferid IN (firstSubquery)
        DetachedCriteria secondSubquery = DetachedCriteria.forClass(HolderBondAccount.class, "bondacct_alias")
                .setProjection(Property.forName("bondacct_alias.holder"))
                .add(Subqueries.propertyIn("bondacct_alias.bondOffer", firstSubquery));

        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .add(Subqueries.propertyIn("holder_alias.id", secondSubquery));

        getTransaction().commit();
        listofbondholders = baseCriteria.list();
        return listofbondholders;
    }
    
    /**
     * Query bondholder list by Gender
     * @param companyid : Client company whose bond list need to be retrievede 
     * @param gender : a further criteria to filter bond holders to be retrieved
     * @return listofbondholders : list of bondholders under a particular company
     */
    public List getAllBondHolderByGender(Integer companyid, String gender){
        startOperation();
        List listofBondHolders = new ArrayList<>();
        
        //select id from BondOffer where clientcompanyid = ?
        DetachedCriteria firstSubquery = DetachedCriteria.forClass(BondOffer.class, "bondoffer_alias")
                .setProjection(Property.forName("bondoffer_alias.id"))
                .add(Restrictions.eq("bondoffer_alias.clientCompany", companyid));
        //select holderid from HolderBondAccount where bondofferid IN (firstSubquery)
        DetachedCriteria secondSubquery = DetachedCriteria.forClass(HolderBondAccount.class, "bondacct_alias")
                .setProjection(Property.forName("bondacct_alias.holder"))
                .add(Subqueries.propertyIn("bondacct_alias.bondOffer", firstSubquery));

        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .add(Subqueries.propertyIn("holder_alias.id", secondSubquery))
                .add(Restrictions.eq("holder_alias.gender", gender));

        getTransaction().commit();
        listofBondHolders = baseCriteria.list();
        return listofBondHolders;
    }
    
    /**
     * Query bondholder list by Age Range
     * @param companyid : Client company whose bond holder list need to be retrieved 
     * @param lowAge : first parameter to start the filtering age bound
     * @param highAge : second parameter to end the filtering age bound
     * @return qualifiedBondholdersList : list of bondholders under a particular company
     */
    public List getAllBondHoldersByAgeRange(Integer companyid, int lowAge, int highAge){
        startOperation();
        List listofBondholders = new ArrayList<>();
        List qualifiedBondholdersList = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        //select id from BondOffer where clientcompanyid = ?
        DetachedCriteria firstSubquery = DetachedCriteria.forClass(BondOffer.class, "bondoffer_alias")
                .setProjection(Property.forName("bondoffer_alias.id"))
                .add(Restrictions.eq("bondoffer_alias.clientCompany", companyid));
        //select holderid from HolderBondAccount where bondofferid IN (firstSubquery)
        DetachedCriteria secondSubquery = DetachedCriteria.forClass(HolderBondAccount.class, "bondacct_alias")
                .setProjection(Property.forName("bondacct_alias.holder"))
                .add(Subqueries.propertyIn("bondacct_alias.bondOffer", firstSubquery));

        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .add(Subqueries.propertyIn("holder_alias.id", secondSubquery));

        getTransaction().commit();
        listofBondholders = baseCriteria.list();
        
        for (Object holder : listofBondholders) {
            Holder currentHolder = (Holder) holder;
            Date dob = currentHolder.getDob();
            int holderAge = currentYear - this.getBirthYear(dob);
            
            if (holderAge >= lowAge && holderAge <= highAge) {
                qualifiedBondholdersList.add(holder);
            }
        }
        getTransaction().commit();
        return qualifiedBondholdersList;
    }
    
    /**
     * Query bondholder list by Address
     * @param companyid : Client company whose bond holder list need to be retrieved 
     * @param address : another criteria to further filter the search
     * @return listofbondholders
     */
    public List getAllBondHoldersByAgeRange(Integer companyid, String address){
        
        List listofbondholders = new ArrayList<>();
        Holder holder = new Holder();
        List<HolderResidentialAddress> holderAddresses = new ArrayList<>(holder.getHolderResidentialAddresses());
        HolderResidentialAddress each_address = holderAddresses.get(0);
        startOperation();
        //select id from BondOffer where clientcompanyid = ?
        DetachedCriteria firstSubquery = DetachedCriteria.forClass(BondOffer.class, "bondoffer_alias")
                .setProjection(Property.forName("bondoffer_alias.id"))
                .add(Restrictions.eq("bondoffer_alias.clientCompany", companyid));
        //select holderid from HolderBondAccount where bondofferid IN (firstSubquery)
        DetachedCriteria secondSubquery = DetachedCriteria.forClass(HolderBondAccount.class, "bondacct_alias")
                .setProjection(Property.forName("bondacct_alias.holder"))
                .add(Subqueries.propertyEq("bondacct_alias.bondOffer", firstSubquery));

        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .add(Subqueries.propertyEq("holder_alias.id", secondSubquery))
                .createCriteria("holder_alias.holderResidentialAddresses", "address_alias", JoinType.LEFT_OUTER_JOIN);
        //String searchableAddress = each_address.getId().getAddressLine1();
                String searchableAddress = each_address.getAddressLine1();
            if (searchableAddress != null){
                baseCriteria.add(Restrictions.ilike("address_alias.id.addressLine1", address, MatchMode.ANYWHERE));
            }
            String searchableCity = each_address.getCity();
            if (searchableCity != null){
                baseCriteria.add(Restrictions.ilike("address_alias.city", address, MatchMode.ANYWHERE));
            }
            String searchablePostcode = each_address.getPostCode();
            if (searchablePostcode != null){
                baseCriteria.add(Restrictions.ilike("address_alias.postCode", address, MatchMode.ANYWHERE));
            }
            String searchableState = each_address.getState();
            if (searchableState != null) {
                baseCriteria.add(Restrictions.ilike("address_alias.id.state", address, MatchMode.ANYWHERE));
            }
            String searchableCountry = each_address.getCountry();
            if (searchableCountry != null) {
                baseCriteria.add(Restrictions.ilike("address_alias.id.country", address, MatchMode.ANYWHERE));
            }          
        listofbondholders = baseCriteria.list();
        getTransaction().commit();
        return listofbondholders;
    }
    
    /**
     * Query bondholder list by stockbroker
     */
    public List getAllBondHolderByBroker(Integer companyid, Integer brokerid){
        startOperation();
        List listofbondholders = new ArrayList<>();
        
        //select id from BondOffer where clientcompanyid = ?
        DetachedCriteria firstSubquery = DetachedCriteria.forClass(BondOffer.class, "bondoffer_alias")
                .setProjection(Property.forName("bondoffer_alias.id"))
                .add(Restrictions.eq("bondoffer_alias.clientCompany", companyid));
        //select holderid from HolderBondAccount where bondofferid IN (firstSubquery)
        DetachedCriteria secondSubquery = DetachedCriteria.forClass(HolderBondAccount.class, "bondacct_alias")
                .setProjection(Property.forName("bondacct_alias.holder"))
                .add(Subqueries.propertyIn("bondacct_alias.bondOffer", firstSubquery));

        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .add(Subqueries.propertyIn("holder_alias.id", secondSubquery))
                .createCriteria("holder_alias.stockbrokers", "broker_alias", JoinType.LEFT_OUTER_JOIN)
                .add(Restrictions.eq("broker_alias.id", brokerid));
        
        listofbondholders = baseCriteria.list();
        getTransaction().commit();
        return listofbondholders;
    }
    
    /**
     *  Apply Additional Shares to Shareholder
     * method to get list of holder requested for additional shares during Right Issue,</p>
     * from which an Integer total additional number can be extracted
     */
    public List numberOfHolderForAdditionalShare(Integer companyid){
        startOperation();
        List listofHoldersForAdditionalShare = new ArrayList<>();
        //select id from RightsIssue where clientcompany id = ?
        DetachedCriteria rightIssSubquery = DetachedCriteria.forClass(RightsIssue.class, "rightissue_alias")
                .setProjection(Property.forName("rightissue_alias.id"))
                .add(Restrictions.eq("rightissue_alias.clientCompany", companyid));
        //select all from RightsIssueApplication where rightsIssueId IN (rightIssSubquery)
        Criteria baseCriteria = getSession().createCriteria( RightsIssueApplication.class, "rightissueapp_alias" )
                .add(Subqueries.propertyIn("rightissueapp_alias.rightsIssue", rightIssSubquery))
                .createCriteria("rightissueapp_alias.holder");
        
        getTransaction().commit();
        listofHoldersForAdditionalShare = baseCriteria.list();
        return listofHoldersForAdditionalShare;
    }
    
    /**
     *  Apply Additional Shares to Shareholder
     * Update RightsIssueApplication when needed</p>
     * from which an Integer total additional number can be extracted
     */
    public boolean UpdateRightsIssueApplication( RightsIssueApplication rightissuApp ){
        startOperation();
        boolean successful = false;
        try{
        createUpdateObject(rightissuApp);
        getTransaction().commit();
        successful = true;
        return successful;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error updating your requests, please review! - ", he);
            return successful;
        }
        

    }
    
    /**
     *  Merge Client Companies
     */
    
    /**
     *  Invalidate Client Company
     *  ascertains if client company has or has no shareholder
     */
    public boolean invalidateClientCompany(Integer companyid){
        startOperation();
        boolean isholderAvailable = false;
        DetachedCriteria holdercompAcctSubquery = DetachedCriteria.forClass(HolderCompanyAccount.class, "compacct_alias")
                .setProjection(Property.forName("compacct_alias.id.holderId"))
                .add(Restrictions.eq("compacct_alias.id.clientCompanyId", companyid));
        //select * from Holder where holderid In (select holderid from HCA inner join CC on compacct_alias.id.clientCompanyId = companyid where companyid = ?)
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .add(Subqueries.propertyIn("holder_alias.id", holdercompAcctSubquery));
       
         if (baseCriteria != null) {
                getTransaction().commit();
                isholderAvailable = true;
                return isholderAvailable;
            }
         else
             return isholderAvailable;     
    }
    
    //***************************PHASE FOUR*******************************
    /**
     * persist dividendTypes
     */
    public boolean dividendType(DividendIssueType dvdType){
        boolean successful = false;
        try {
            startOperation();
            createUpdateObject(dvdType);
            successful = true;
            getTransaction().commit();
            return successful;
        } catch (HibernateException he) {
            getTransaction().commit();
            logger.info("error perssiting Dividend type - ", he);
            return successful;
        }
    }
    /**
     * construct method to declare dividend
     */
    public boolean declareDividend(DividendDeclared dvdDeclared){
        boolean successful = false;
        try {
            startOperation();
            createUpdateObject(dvdDeclared);
            successful = true;
            getTransaction().commit();
            return successful;
        } catch (HibernateException he) {
            getTransaction().rollback();
            logger.info("", he);
            return successful;
        }
    }
    
    /**
     * View Corporate Action report (on declared bonus/dividend)
     */
    public List reportOnBonusDeclaration(int companyId, Date beginDate, Date endDate){
        List declaredBonus = new ArrayList<>();
        ClientCompany compIdentity = new ClientCompany();
        compIdentity.setId(companyId);
        
        DetachedCriteria holdersubQuery = DetachedCriteria.forClass(ClientCompany.class, "cc_alias")
                .add(Example.create(compIdentity))
                .createAlias("cc_alias.holderCompanyAccounts", "compAcct_alias", JoinType.LEFT_OUTER_JOIN)
                .createAlias("compAcct_alias.holder", "holder_alias", JoinType.LEFT_OUTER_JOIN);
        
        Criteria baseCriteria = getSession().createCriteria(ShareBonus.class, "bonus_alias");
            baseCriteria.add(Subqueries.propertyEq("bonus_alias.clientCompany", holdersubQuery))
                .add(Restrictions.between("bonus_alias.qualifyDate", beginDate, endDate));
        
            declaredBonus = baseCriteria.list();
            getTransaction().commit();
            return declaredBonus;
    }
    
     /**
     * View Corporate Action report (on declared bonus/dividend)
     
    public List reportOnDividendDeclared(int companyId ){
        
        
    
    }*/
}
