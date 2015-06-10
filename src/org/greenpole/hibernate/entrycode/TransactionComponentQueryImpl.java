/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenpole.hibernate.entity.CertificateLodgement;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.ProcessedTransaction;
import org.greenpole.hibernate.entity.ProcessedTransactionHolder;
import org.greenpole.hibernate.entity.SuspendedTransaction;
import org.greenpole.hibernate.entity.SuspendedTransactionHolder;
import org.greenpole.hibernate.entity.TransactionType;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
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
public class TransactionComponentQueryImpl extends GeneralisedAbstractDao {
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionComponentQueryImpl.class);
    /**
     * Upload Transaction
     */
    public boolean UploadTransaction(){
        
        return false;
    }
    
    /**
     * method to check shareholders with ESOP status
     * @param holderId identifier of the holder to know his/her esop status
     * return rowcount
     */ 
    public boolean checkHolderESOP(Integer holderId){
        /*select count(*) as y0_ from HolderCompanyAccount this_ where this_.id in 
        (select holder_alias_.id as y0_ from Holder holder_alias_ where holder_alias_.id = ?) and this_.ESOP=?*/
                startOperation();
        DetachedCriteria subquery = DetachedCriteria.forClass(Holder.class, "holder_alias")
                .setProjection(Property.forName(("holder_alias.id")))
                .add(Restrictions.idEq(holderId));
        
        Criteria baseCriteria = getSession().createCriteria(HolderCompanyAccount.class, "holderacct_alias")
                .add(Subqueries.propertyEq("holderacct_alias.id.holderId", subquery))
                .add(Restrictions.eq("holderacct_alias.esop", true))
                .setProjection(Projections.rowCount());
        Long count = (Long) baseCriteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
        /*Criteria baseCriteria = getSession().createCriteria(HolderCompanyAccount.class, "holderacct_alias")
                .createAlias("holderacct_alias.holder", "holder_alias")
                .add(Restrictions.idEq(holderId));
        HolderCompanyAccount holderAcct = new HolderCompanyAccount();
            holderAcct.setEsop(true);
            baseCriteria.add(Example.create(holderAcct).enableLike())
                    .setProjection(Projections.rowCount());
        Long rowcount = (Long) baseCriteria.uniqueResult();
        getTransaction().commit();
        return rowcount > 0;*/
            
    }
    
    /**
     * method to check if a transaction crediting has not been logged
     * @param cscsId in the Transaction file from the CSCS
     * @param creditedDate :the logged date 
     */
    public boolean checkTransactionCreditation(Integer cscsId){
        //select count(*) as y0_ from ProcessedTransaction this_ where (this_.loggeedDate=? and this_.cscsTransactionId=?)
        startOperation();
        Criteria baseCriteria = getSession().createCriteria(ProcessedTransaction.class, "proTransact_alias");
        
        Junction dateCriterion = Restrictions.conjunction(Restrictions.lt("proTransact_alias.transaction_date", new Date()));
                dateCriterion.add(Restrictions.eq("proTransact_alias.cscsTransactionId", cscsId));
                
                baseCriteria.add(dateCriterion).setProjection(Projections.rowCount());
        Long count = (Long) baseCriteria.uniqueResult();
        getTransaction().commit();
        return count > 0;            
    }
    
    /**
     * method to confirm if certificate crediting has not been logged
     * @param chn in the certificate file from the CSCS 
     * @param certificateNumber in the certificate file from the CSCS
     */
    public boolean checkCertificateCreditation(String certificateNumber, String chn){
        startOperation();
        Criteria baseCriteria = getSession().createCriteria(CertificateLodgement.class, "certLogment_alias");
        
        CertificateLodgement certLogged = new CertificateLodgement();
        certLogged.setChn(chn);
        certLogged.setCertificateNumber(certificateNumber);
        certLogged.setProcessed(true);
                baseCriteria.add(
                        Example.create(certLogged)
                        .enableLike().ignoreCase()
                ).setProjection(Projections.rowCount());
        
        Long count = (Long) baseCriteria.uniqueResult();
        getTransaction().commit();
        return count > 0;  
    }
    
    /**
     * If system discovers shareholders in the transaction 
     * text file that do not exist in the system
     * @param chn extracted from the Transaction file from CSCS
     */
    public boolean isTransactingHolderSystemAvailable(String chn){
        startOperation();
        Criteria baseCriteria = getSession().createCriteria(Holder.class);
        Holder holder = new Holder();
        holder.setChn(chn);
        baseCriteria.add(
                Example.create(holder)
                .ignoreCase().enableLike()
        ).setProjection(Projections.rowCount());
        
        Long rowcount = (Long)baseCriteria.uniqueResult();
        getTransaction().commit();
        return rowcount > 0;
    }
    
    /**
     * If system discovers existing shareholders with holder company accounts </p> 
     * in the transaction text file that do not exist in the system
     * @param chn 
     */
    public boolean isHolderPossessCompanyAccount(String chn){
        
        startOperation();
        Holder holder = new Holder();
        holder.setChn(chn);
        DetachedCriteria holderSubquery = DetachedCriteria.forClass(Holder.class, "holder_alias")
                .setProjection(Property.forName("holder_alias.id"))
                .add(Example.create(holder).enableLike().ignoreCase());
        
        Criteria baseCriteria = getSession().createCriteria(HolderCompanyAccount.class, "companyacct_alias")
                .add(Subqueries.propertyEq("companyacct_alias.id.holderId", holderSubquery))
                .setProjection(Projections.rowCount());

        Long rowcount = (Long) baseCriteria.uniqueResult();
        getTransaction().commit();
        return rowcount > 0;
        
    }
    
    /**
     * persist transaction type
     * @param typeOfTransact 
     */
    public boolean persistTransactionType(TransactionType typeOfTransact){
        boolean successful = false;
        try{
        startOperation();
        createUpdateObject(typeOfTransact);
        getTransaction().commit();
        successful = true;
        return successful;
        }catch(HibernateException he){
         getTransaction().rollback();
         logger.info("error persisting TransactionType object, review! - ", he);
         return successful;
        }   
    }
    
    /**
     * Upload Transaction and Master file
     * @param holderTransact 
     * @param processTransact 
     * @return successfulUpload
    */
    public boolean uploadTransactionFiles(List<ProcessedTransaction> processTransact, List<ProcessedTransactionHolder> holderTransact){
        boolean successfulUpload = false;
        ProcessedTransaction procexTranx = null;
        Holder holder = null;
        try{
        startOperation();
        processTransact.stream().forEach((each_processTransact) -> {
            createUpdateObject(each_processTransact);
        });
        //persist corresponding records in ProcessedTransactioHolder
        if (holderTransact != null) {
            for (ProcessedTransactionHolder correspond_holderTransact : holderTransact) {
                correspond_holderTransact.getId().setHolderId(holder.getId());
                correspond_holderTransact.getId().setTransactionId(procexTranx.getId());
                    createUpdateObject(correspond_holderTransact);
            }
        }         
        successfulUpload = true;
        getTransaction().commit();
        return successfulUpload;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error persisting Transaction record(s), review your code - ", he);
            return successfulUpload;
        }       
    }
    
    /**
     * persist suspended transaction
    */
    public boolean persistSuspendedTransaction( List<SuspendedTransaction> transactSuspended, List<SuspendedTransactionHolder> holderTransactSuspended){
        boolean successful = false;
        Holder holder = null;
        SuspendedTransaction suspTranx = null;
        try {
            startOperation();
            for (SuspendedTransaction each_suspendedTransact : transactSuspended) {
                createUpdateObject(each_suspendedTransact);
            }
            if (holderTransactSuspended != null ){
                for (SuspendedTransactionHolder correspond_HolderSuspTransact : holderTransactSuspended) {
                    correspond_HolderSuspTransact.getId().setHolderId(holder.getId());
                    correspond_HolderSuspTransact.getId().setTransactionId(suspTranx.getId());
                    createUpdateObject(correspond_HolderSuspTransact);
                 }
            }
        successful = true;
        getTransaction().commit();
        return successful;
        } catch (HibernateException he) {
            getTransaction().rollback();
            logger.info("error persisting Suspended Transactions, review your code - ", he);
            return successful;
        }
        
    }    
    
    /**
     * update share unit transfer in HolderCompanyAccount
     * @param holder_compAcct 
     */
    public void updateCompanyAccountForShareUnitTransfer(HolderCompanyAccount holder_compAcct){
        startOperation();
        createUpdateObject(holder_compAcct);
        getTransaction().commit();
    }
    
    /**
     * query Shareholder with ESPO
     * @param holderid 
     */
    public List queryHolderWithESOP(Integer holderid){
        startOperation();
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .createAlias("holder_alias.holderCompanyAccounts", "compAcct_alias", JoinType.LEFT_OUTER_JOIN)
                .add(Restrictions.idEq(holderid))
                .add(Restrictions.eq("compAcct_alias.esop", true));
        List esopHolder = baseCriteria.list();
        getTransaction().commit();
        return esopHolder;
    }
    
    /**
     * method to determine holder with esop status
     * @param holderid 
     */
    public boolean isHolderWithESOP(Integer holderid){
        startOperation();
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .createAlias("holder_alias.holderCompanyAccounts", "compAcct_alias", JoinType.LEFT_OUTER_JOIN)
                .add(Restrictions.idEq(holderid))
                .add(Restrictions.eq("compAcct_alias.esop", true));
        Long rowCount = (Long) baseCriteria.uniqueResult();
        getTransaction().commit();
        return rowCount > 0;
    }
    
    /**
     * System alerts super user on suspended ESOP shareholder transactions 
     */
    public List queryTransactionHolderWithESOP(String chn){
        startOperation();
        //select holderid from SuspendedTransactionHolder where chn = ?
        DetachedCriteria subquery = DetachedCriteria.forClass(SuspendedTransactionHolder.class, "suspendedHolder_alias")
                .setProjection(Property.forName("suspendedHolder_alias.id.holderId"));
        SuspendedTransactionHolder suspended_esopholder = new SuspendedTransactionHolder();
        suspended_esopholder.setHolderChn(chn);
        subquery.add(
                Example.create(suspended_esopholder)
                .ignoreCase().enableLike()
        );
//select Holder left join HolderCompanyAccount on holder.id=compacct.HolderId where holder.id (subquery) and compacct.ESOP=?
        Criteria baseCriteria = getSession().createCriteria(Holder.class, "holder_alias")
                .createAlias("holder_alias.holderCompanyAccounts", "compAcct_alias", JoinType.LEFT_OUTER_JOIN)
                .add(Subqueries.propertyEq("holder_alias.id", subquery))
                .add(Restrictions.eq("compAcct_alias.esop", true));

        List suspendedEsopHolder = baseCriteria.list();
        getTransaction().commit();
        return suspendedEsopHolder;
    }
    
    /**
     * Query Transaction
    */
    public List searchTransactionList(Date transact_date){
       List transactionList = new ArrayList();
         startOperation();
        ProcessedTransaction tranx = new ProcessedTransaction();
        tranx.setTransactionDate(transact_date);
        Criteria baseCriteria = getSession().createCriteria(ProcessedTransaction.class, "transact_alias");
            baseCriteria.add(Example.create(tranx))
                    .createAlias("transact_alias.processedTransactionHolders", "proTranHolder_alias", JoinType.LEFT_OUTER_JOIN);

        transactionList = baseCriteria.list();
        getTransaction().commit();
        return transactionList;
    } 
}