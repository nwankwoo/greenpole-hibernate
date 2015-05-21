/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.entrycode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.greenpole.hibernate.entity.Administrator;
import org.greenpole.hibernate.entity.AdministratorEmailAddress;
import org.greenpole.hibernate.entity.AdministratorPhoneNumber;
import org.greenpole.hibernate.entity.AdministratorPostalAddress;
import org.greenpole.hibernate.entity.AdministratorResidentialAddress;
import org.greenpole.hibernate.entity.BondOffer;
import org.greenpole.hibernate.entity.ClientCompany;
import org.greenpole.hibernate.entity.ClientCompanyAddress;
import org.greenpole.hibernate.entity.ClientCompanyEmailAddress;
import org.greenpole.hibernate.entity.ClientCompanyPhoneNumber;
import org.greenpole.hibernate.entity.CompanyAccountConsolidation;
import org.greenpole.hibernate.entity.Depository;
import org.greenpole.hibernate.entity.Holder;
import org.greenpole.hibernate.entity.HolderBondAccount;
import org.greenpole.hibernate.entity.HolderChanges;
import org.greenpole.hibernate.entity.HolderCompanyAccount;
import org.greenpole.hibernate.entity.HolderEmailAddress;
import org.greenpole.hibernate.entity.HolderPhoneNumber;
import org.greenpole.hibernate.entity.HolderPostalAddress;
import org.greenpole.hibernate.entity.HolderResidentialAddress;
import org.greenpole.hibernate.entity.HolderSignature;
import org.greenpole.hibernate.entity.PowerOfAttorney;
import org.greenpole.hibernate.entity.PrivatePlacement;
import org.greenpole.hibernate.entity.ShareQuotation;
import org.greenpole.hibernate.query.impl.ClientCompanyComponentQueryImpl;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ahmad.Gbadamosi
 */
public class ClientCompanyQueryImpl extends GeneralisedAbstractDao {
    
    Session session;
    ClientCompanyDao clientDao;
    private static final Logger logger = LoggerFactory.getLogger(ClientCompanyComponentQueryImpl.class);
    public void persistClientCompany(){
        ClientCompany client = new ClientCompany();
        clientDao.create(client);
    }
    
    public void queryClientCompany(){}

    /*********************/
    public void queryClientCompanyWithOrCondition(List<String> userSearchParams, String userSearchTerm){
        String input = userSearchTerm;
        
        String searchQuery = "select id, depository, name, code, nseSector, ceo, "
                + "secretary, valid, merged, clientCompanyPrimary from dbo.ClientCompany where ";
        for(String searchParams : userSearchParams ){
            searchQuery+= " " + searchParams + "like '%'" + input + "'%' OR";
        }
            searchQuery = searchQuery.substring(0, searchQuery.trim().length()-2).trim(); //remove the OR and spaces
            System.out.println("Query written as" + searchQuery);
            SQLQuery query = session.createSQLQuery(searchQuery);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); //not printing
            List results = query.list();
        //return results;
            results.stream().forEach((objresults) -> {
                Map objectMap = (Map) objresults;
                System.out.println(objectMap.get("id"));
                /*
                for(Object objresults : results){
                Map objectMap = (Map) objresults;
                
                */
        });
    }
        
    /**
     *
     * @param clientid , identifier id of the client company to update
     * @param compname , name of the client company
     * @param compcode , code of the client company 
     * @param compceo , chief executive officer of the client company
     * @param compsec , secretary of the client company
     * @param state , state of the client company
     * @param city , city of the client company
     * @param country , country of the client company
     * @param email , email of the client company
     * @param clientphone , phone number of the client company
     * @param depository , depository a client company belongs to
     * @return clientcompany, returning object to the data access object class to update and persist
     */
    public ClientCompany editClientCompany(int clientid, String compname, String compcode, String compceo, String compsec, 
            String state, String city, String country, String email, String clientphone, Depository depository){
            ClientCompany clientcompany = (ClientCompany) session.get(ClientCompany.class, clientid); //fetch a particular client
            ClientCompanyAddress ccaddress = (ClientCompanyAddress) session.get(ClientCompanyAddress.class, clientcompany.getId());
            ClientCompanyEmailAddress clientemailaddress = (ClientCompanyEmailAddress) session.get(ClientCompanyEmailAddress.class, clientcompany.getId());
            ClientCompanyPhoneNumber ccphonenumber = (ClientCompanyPhoneNumber) session.get(ClientCompanyPhoneNumber.class, clientcompany.getId());
            //Depository depository = (Depository) session.get(Depository.class, clientcompany.getId());
            //update the address
            ccaddress.setCity(city);
            ccaddress.setPostCode(compcode);
            ccaddress.getId().setState(state);
            ccaddress.getId().setCountry(country);
            //update email address
            clientemailaddress.getId().setEmailAddress(email);
            //update clientcompany phone number
            ccphonenumber.getId().setPhoneNumber(clientphone);
            //update other direct company attributes
            clientcompany.setName(compname);
            clientcompany.setCode(compcode);
            clientcompany.setCeo(compceo);
            clientcompany.setSecretary(compsec);
            clientcompany.setDepository(depository);

            HashSet setclientcompanyAddress, setclientcompanyemail, setclientcompanyphonenumber;
            setclientcompanyAddress = new HashSet();
            setclientcompanyemail = new HashSet();
            setclientcompanyphonenumber = new HashSet();

            setclientcompanyAddress.add(ccaddress);
            setclientcompanyemail.add(clientemailaddress);
            setclientcompanyphonenumber.add(ccphonenumber);        
            //finaly update and persist client attributes that were edited
            clientcompany.setClientCompanyAddresses(setclientcompanyAddress);

            return clientcompany;             
    }
    
    /**
     * Setup a bond offer for a ClientCompany
     * @param companyid , identifier id of the client company to update
     * @param title , title of the bond on offer
     * @param bondunitprice , price of bond unit
     * @param bondMaturity , the maturity date of the bond to be paid to the holder
     * @param bondType , type of the bond on offer, Redeemable or fixed
     * @param interestRate , the tax rate on bond to offer
     * @param paymentPlan , method of payment
     * @return BondOffer , returning object to the data access object class to persist
     */
   public BondOffer setUpBondOffer(int companyid, String title, double bondunitprice, Date bondMaturity, String bondType,
           double interestRate, String paymentPlan ){
       
       ClientCompany client = (ClientCompany) session.get(ClientCompany.class, companyid);
       client.setId(companyid);
       //BondOffer bondoffer = new BondOffer(client, title, bondunitprice, bondMaturity, bondType, taxRate, paymentPlan);
       BondOffer bondoffer = new BondOffer();
       bondoffer.setTitle(title);
       bondoffer.setBondUnitPrice(bondunitprice);
       bondoffer.setBondMaturity(bondMaturity);
       //bondoffer.setBondType(bondType);
       bondoffer.setInterestRate(interestRate);
       //bondoffer.setbondOfferPaymentPlan(paymentPlan); 
       bondoffer.setClientCompany(client);
       return bondoffer;
   }
   
   /**
    * SETUP private placement
     *
     * @param companyid of the client company
     * @param totalSharesOnOffer ,to share place on offer by the client company
     * @param methodOnOffer , disbursement of the offer per offer price
     * @param startingMinSubscrptn , starting the minimum subscription
     * @param continuingMinSubscrptn , continuing minimum subscription 
     * @param offerSize , multiplication of total share and offer price
     * @param offerprice , price of the total offer by the client company
     * @param startDate , the starting date of the offer
     * @param endDate , the ending date of the offer
     * @return privateplacement ,returning object to the data access object class to persist
    */
   public PrivatePlacement setupPrivatePlacement(int companyid, int totalSharesOnOffer, int methodOnOffer, int startingMinSubscrptn, 
           int continuingMinSubscrptn, int offerSize, double offerprice, Date startDate, Date endDate){
       ClientCompany clientcompany = (ClientCompany) session.get(ClientCompany.class, companyid);
       clientcompany.setId(companyid);
       PrivatePlacement privateplacement = new PrivatePlacement();
       privateplacement.setTotalSharesOnOffer(totalSharesOnOffer);
       privateplacement.setMethodOnOffer(methodOnOffer);
       privateplacement.setStartingMinSubscrptn(startingMinSubscrptn);
       privateplacement.setContinuingMinSubscrptn(continuingMinSubscrptn);
       privateplacement.setOfferPrice(offerprice);
       //privateplacement.setOfferSize(offerSize);
       privateplacement.setOpeningDate(startDate);
       privateplacement.setClosingDate(endDate);
       privateplacement.setClientCompany(clientcompany);
       return privateplacement;
   }
   
   /**
    * Upload Share unit quotation
     * @param quotationid , the precise quotation identifier id
     * @param code , the code of the specified quotation
     * @param unit_price , the current market selling price at point in time
     * @return share_quote particular object to update
    */
    public ShareQuotation uploadShareQuotation(int quotationid, String code, double unit_price){
       ScrollableResults quotationCursor = session.createQuery("from ShareQuotation").scroll();
       
       int count = 0;
       ShareQuotation share_quotecursor = null;
       while( quotationCursor.next() ){
            share_quotecursor = (ShareQuotation) quotationCursor.get(0); //Get the <tt>i</tt>th object in the current row of results, without initializing any other results in the row.
           share_quotecursor.setUnitPrice(unit_price);
           
           if(++count % 20 == 0){
               session.flush();
               session.clear();
           }
       }
        return share_quotecursor;
   }
   
    /**
     * update the share quotation without
     * without generalised features among the queries
     * @param quotationid , the precise quotation identifier id
     * @param code , the code of the specified quotation
     * @param unit_price, the current market selling price at point in time
     * @return share_quote, returning object to be updated
     */
   public ShareQuotation updateQuotation(int quotationid, double unit_price){
       ShareQuotation share_quote = (ShareQuotation) session.get(ShareQuotation.class, quotationid);
       share_quote.setUnitPrice(unit_price);
       
       return share_quote;
   }
   
      public void uploadSignature(int holderid, String signaturePath, boolean holderSignaturePrimary){
       Holder holder = new Holder();
       holder.setId(holderid);
       HolderSignature holdersignature = new HolderSignature();
       holdersignature.setHolder(holder);
       holdersignature.setSignaturePath(signaturePath);
       holdersignature.setHolderSignaturePrimary(holderSignaturePrimary);
   }
   
   /**
    * Query Holder signature
     * @param holderid
     * @return 
    */
   public List queryHolderSignature(int holderid){
       
        List signtureList = null;
        String searchQuery = "select holdersign.signaturePath from HolderSignature as holdersign, Holder as holder "
               + "where holderSign.id = '" + holderid + "' and holder.id = '" + holderid + "'";
        Query queryResults = session.createQuery(searchQuery);
        signtureList = queryResults.list();
        return signtureList; //the content signaturePath in the signatureList is a string, must be casted to String if iterating it
   }
   
   /**
    * Create Shareholder Account details Manually
     * @param firstName
     * @param middleName
     * @param lastName
     * @param type
     * @param gender
     * @param dob
     * @param taxExempted
     * @param holdercityaddress
     * @param holdercodeaddress
     * @param holderstateaddress
     * @param holdercountryaddress
     * @param holderpostalcityaddress
     * @param holderpostalcodeaddress
     * @param holderpostalstateaddress
     * @param holderpostalcountryaddress
     * @param holderphonenumber
     * @param holderemailaddress
     * @param shareholderresidentaddline1
     * @param shareholderresidentaddline2
     * @param shareholderresidentaddline3
     * @param shareholderresidentaddline4
     * @param shareholderpostaladdline1
     * @param shareholderpostaladdline2
     * @param shareholderpostaladdline3
     * @param shareholderpostaladdline4
     * @param shareholderresidentaddrValidity
     * @param shareholderpostaladdrValidity
     * @param shareholderphoneaddrValidity
     * @return holderpersistence
    */
   public Holder createShareholder(String firstName, String middleName, String lastName, String type, String gender, Date dob, boolean taxExempted, 
           String holdercityaddress, String holdercodeaddress, String holderstateaddress, String holdercountryaddress, String holderpostalcityaddress, 
           String holderpostalcodeaddress, String holderpostalstateaddress, String holderpostalcountryaddress, String holderphonenumber, String holderemailaddress, 
           String shareholderresidentaddline1, String shareholderresidentaddline2, String shareholderresidentaddline3, String shareholderresidentaddline4, 
           String shareholderpostaladdline1, int shareholderpostaladdline2, String shareholderpostaladdline3, String shareholderpostaladdline4, 
           boolean shareholderresidentaddrValidity, boolean shareholderpostaladdrValidity, boolean shareholderphoneaddrValidity){
       
        Holder holderpersistence = new Holder();
        HolderResidentialAddress holderresidentialaddress = new HolderResidentialAddress();
        HolderPostalAddress holderpostaladdress = new HolderPostalAddress();
        HolderPhoneNumber holderfonenumber = new HolderPhoneNumber();
        HolderEmailAddress holderemailaddr = new HolderEmailAddress();
       
        //persist holder primary attributes
        holderpersistence.setFirstName(firstName);
        holderpersistence.setMiddleName(middleName);
        holderpersistence.setLastName(lastName);
        //holderpersistence.setType(type);
        holderpersistence.setGender(gender);
        holderpersistence.setDob(dob);
        holderpersistence.setTaxExempted(taxExempted);
       //insert holder adddress in the HolderResidentialAddress object
        holderresidentialaddress.getId().setHolderId(holderpersistence.getId()); //set the newly generated idetifier key in HolderResidentialAddress entity
        holderresidentialaddress.setCity(holdercityaddress);
        holderresidentialaddress.setPostCode(holdercodeaddress);
        holderresidentialaddress.getId().setState(holderstateaddress);
        holderresidentialaddress.getId().setCountry(holdercountryaddress);
        holderresidentialaddress.getId().setAddressLine1(shareholderresidentaddline1);
        holderresidentialaddress.setAddressLine2(shareholderresidentaddline2);
        holderresidentialaddress.setAddressLine3(shareholderresidentaddline3);
        holderresidentialaddress.setAddressLine4(shareholderresidentaddline4);
        holderresidentialaddress.setIsPrimary(shareholderresidentaddrValidity);
       //insert holder adddress in the HolderPostalAddress object
        holderpostaladdress.getId().setHolderId(holderpersistence.getId()); //set the newly generated idetifier key in HolderPostalAddress entity
        holderpostaladdress.setCity(holderpostalcityaddress);
        holderpostaladdress.setPostCode(holderpostalcodeaddress);
        holderpostaladdress.getId().setState(holderpostalstateaddress);
        holderpostaladdress.getId().setCountry(holderpostalcountryaddress);
        holderpostaladdress.getId().setAddressLine1(shareholderresidentaddline1);
        holderpostaladdress.setAddressLine2(shareholderresidentaddline2);
        holderpostaladdress.setAddressLine3(shareholderresidentaddline3);
        holderpostaladdress.setAddressLine4(shareholderresidentaddline4);
        holderpostaladdress.setIsPrimary(shareholderpostaladdrValidity);
        //insert holder adddress in the HolderPhoneNumber object
        holderfonenumber.getId().setHolderId(holderpersistence.getId());    //set the newly generated idetifier key in HolderPhoneNumber entity
        holderfonenumber.getId().setPhoneNumber(holderphonenumber);
        holderfonenumber.setIsPrimary(shareholderphoneaddrValidity);
        //insert holder adddress in the HolderEmailAddress object
        holderemailaddr.getId().setHolderId(holderpersistence.getId()); //set the newly generated idetifier key in HolderEmailAddress entity
        holderemailaddr.getId().setEmailAddress(holderemailaddress);   
        //Initialise the Hashset to contain set of addresses
        HashSet setHolderPostalAddresses, setHolderEmails, setHolderPhonenumbers, setHolderResidentialAddresses;
        setHolderResidentialAddresses = new HashSet();
        setHolderResidentialAddresses.add(holderresidentialaddress);
        setHolderPostalAddresses = new HashSet();
        setHolderPostalAddresses.add(holderpostaladdress);
        setHolderPhonenumbers = new HashSet();
        setHolderPhonenumbers.add(holderfonenumber);
        setHolderEmails = new HashSet();
        setHolderEmails.add(holderemailaddr);
        //persist the objects of the dependent models
       holderpersistence.setHolderResidentialAddresses(setHolderResidentialAddresses);
       holderpersistence.setHolderPostalAddresses(setHolderPostalAddresses);
       holderpersistence.setHolderPhoneNumbers(setHolderPhonenumbers);
       holderpersistence.setHolderEmailAddresses(setHolderEmails);      

       return holderpersistence;
   }
   
   /**
    * Create Bondholder Account, this method is subject to change to add the principalbond later
    * 
     * @param firstName , name of the bond owner
     * @param middleName ,middlename of the bond owner
     * @param lastName ,lastname of the bond owner
     * @param dob   , date of birth of the bond owner
     * @param gender 
     * @param bondholderCHN 
     * @param residentialcity
     * @param residentialpostalcode
     * @param residentialstate
     * @param residentialcountry
     * @param postalcity
     * @param postalpostcode
     * @param postalstate
     * @param postalcountry
     * @param bondholdernumber
     * @param bondholderemail
     * @param bondholderresidentaddline1
     * @param bondholderresidentaddline2
     * @param bondholderresidentaddline3
     * @param bondholderresidentaddline4
     * @param bondholderpostaladdline1
     * @param bondholderpostaladdline4
     * @param bondholderpostaladdline2
     * @param bondholderpostaladdline3
     * @param bhresidentaddrValidity , show if still valid
     * @param bhpostaladdrValidity  , show if still valid
     * @param bhphoneaddrValidity , show if still valid
     * @param bondunits
     * @return holderbondaccount
   */
   public HolderBondAccount createBondHolderAccount(String firstName, String middleName, String lastName, String gender, Date dob, String bondholderCHN,
           String residentialcity, String residentialpostalcode, String residentialstate, String residentialcountry, 
           String postalcity, String postalpostcode, String postalstate, String postalcountry, String bondholdernumber, String bondholderemail, 
           String bondholderresidentaddline1, String bondholderresidentaddline2, String bondholderresidentaddline3, String bondholderresidentaddline4, 
           String bondholderpostaladdline1, String bondholderpostaladdline2, String bondholderpostaladdline3, String bondholderpostaladdline4, 
           boolean bhresidentaddrValidity, boolean bhpostaladdrValidity, boolean bhphoneaddrValidity, double bondunits ){
       HolderBondAccount holderbondaccount = new HolderBondAccount();
       Holder bondHolder = new Holder();
       HolderResidentialAddress bondholderresidentialaddress = new HolderResidentialAddress();
       HolderPostalAddress bondholderpostaladdress = new HolderPostalAddress();
       HolderPhoneNumber bondholderfonenumber = new HolderPhoneNumber();
       HolderEmailAddress bondholderemailaddr = new HolderEmailAddress();       
       //persist the primary attributes of the bond owner in the Holder entity
       bondHolder.setFirstName(firstName);
       bondHolder.setMiddleName(middleName);
       bondHolder.setLastName(lastName);
       bondHolder.setGender(gender);
       bondHolder.setDob(dob);
       bondHolder.setChn(bondholderCHN);
       //bondunit, principalbondvalue,stockbroker, clientcompany buying from
       //persist the attribute with residential address
       bondholderresidentialaddress.getId().setHolderId(bondHolder.getId());
       bondholderresidentialaddress.setCity(residentialcity);
       bondholderresidentialaddress.setPostCode(residentialpostalcode);
       bondholderresidentialaddress.getId().setState(residentialstate);
       bondholderresidentialaddress.getId().setCountry(residentialcountry);
       bondholderresidentialaddress.getId().setAddressLine1(bondholderresidentaddline1);
       bondholderresidentialaddress.setAddressLine2(bondholderresidentaddline2);
       bondholderresidentialaddress.setAddressLine3(bondholderresidentaddline3);
       bondholderresidentialaddress.setAddressLine4(bondholderresidentaddline4);
       bondholderresidentialaddress.setIsPrimary(bhresidentaddrValidity);
       //persist the attribute with residential address
       bondholderpostaladdress.setCity(postalcity);
       bondholderpostaladdress.setPostCode(postalpostcode);
       bondholderpostaladdress.getId().setHolderId(bondHolder.getId());
       bondholderpostaladdress.getId().setState(postalstate);
       bondholderpostaladdress.getId().setCountry(postalcountry);
       bondholderpostaladdress.getId().setAddressLine1(bondholderpostaladdline1);
       bondholderpostaladdress.setAddressLine2(bondholderpostaladdline2);
       bondholderpostaladdress.setAddressLine3(bondholderpostaladdline3);
       bondholderpostaladdress.setAddressLine4(bondholderpostaladdline4);
       bondholderpostaladdress.setIsPrimary(bhpostaladdrValidity);
       //persist the attribute with phone number
       bondholderfonenumber.getId().setHolderId(bondHolder.getId());
       bondholderfonenumber.getId().setPhoneNumber(bondholdernumber);
       bondholderfonenumber.setIsPrimary(bhphoneaddrValidity);
       //persist the attribute with email address
       bondholderemailaddr.getId().setHolderId(bondHolder.getId());
       bondholderemailaddr.getId().setEmailAddress(bondholderemail);
       
       //Initialise the Hashset to contain set of addresses
        HashSet setBondHolderResidentialAddresses, setBondHolderPostalAddresses, setBondHolderPhonenumbers, setBondHolderEmails;
        setBondHolderResidentialAddresses = new HashSet();
        setBondHolderResidentialAddresses.add(bondholderresidentialaddress);
        setBondHolderPostalAddresses = new HashSet();
        setBondHolderPostalAddresses.add(bondholderpostaladdress);
        setBondHolderPhonenumbers = new HashSet();
        setBondHolderPhonenumbers.add(bondholderfonenumber);
        setBondHolderEmails = new HashSet();
        setBondHolderEmails.add(bondholderemailaddr);
        //finally persist all the entries
        holderbondaccount.getId().setHolderId(bondHolder.getId()); //corresponding identifier to the Holder table to whom the bond belongs
        //holderbondaccount.setBondUnits(bondunits);
        holderbondaccount.getHolder().setHolderResidentialAddresses(setBondHolderResidentialAddresses);
        holderbondaccount.getHolder().setHolderPostalAddresses(setBondHolderPostalAddresses);
        holderbondaccount.getHolder().setHolderPhoneNumbers(setBondHolderPhonenumbers);
        holderbondaccount.getHolder().setHolderEmailAddresses(setBondHolderPostalAddresses);
        
       return holderbondaccount ;
   }  
   
   /**
     * Query Clientcompany with list of searchable attribute and  <p>
     * list of search terms from user
     * @param defaultSearchableParams
     * @param userSearchTerms
     * @return resultList , the list of client company object: 
     */
    public List queryClientCompanyWithListParameters(List<String> defaultSearchableParams, List<String> userSearchTerms){
        int searchableparamComparator = defaultSearchableParams.size();
        int usersearchComparator= userSearchTerms.size();
        String searchQuery = "";
        if(searchableparamComparator == usersearchComparator){
            searchQuery = "select name, code, ceo, city, email from ClientCompany where";
            for(int i = 0; i < searchableparamComparator; i++){
                
                if(i == 0){
                    searchQuery+=" " + defaultSearchableParams.get(i) + " like '%" + userSearchTerms.get(i) +"'%";
                }
                if(i > 0){
                    searchQuery+=" AND" + defaultSearchableParams.get(i) + "like '%" +userSearchTerms.get(i)+ "%'";
                }
            } //end for-loop
        
        }   //end outer if
        SQLQuery querySearch = session.createSQLQuery(searchQuery);
        List resultList = querySearch.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).list();
        return resultList;
    }

    /**
    * Create Administrator for Shareholder / Bondholder
     * @param deceasedid
     * @param firstName
     * @param middleName
     * @param lastName
     * @param adminresidentialcity
     * @param adminresidentialpostalcode
     * @param adminresidentialstate
     * @param adminresidentialcountry
     * @param adminpostaladdresscity
     * @param adminpostaladdrpostcode
     * @param adminpostaladdrstate
     * @param adminemail
     * @param adminfonenumber
     * @param adminpostaladdrcountry
     * @param adminphoneValidity
     * @param adminresidentialValidity
     * @param adminpostalAddressValidity
     * @param adminresidentaddline1
     * @param adminresidentaddline2
     * @param adminresidentaddline3
     * @param adminresidentaddline4
     * @param adminpostaladdline1
     * @param adminpostaladdline3
     * @param adminpostaladdline2
     * @param adminpostaladdline4
     * @return 
    */
    public Administrator createAdministrator( int deceasedid, String firstName, String middleName, String lastName, 
           String adminresidentialcity, String adminresidentialpostalcode, String adminresidentialstate, String adminresidentialcountry, 
           String adminpostaladdresscity, String adminpostaladdrpostcode, String adminpostaladdrstate, String adminpostaladdrcountry, String adminfonenumber, 
           String adminemail, boolean adminphoneValidity, boolean adminresidentialValidity, boolean adminpostalAddressValidity, 
           String adminresidentaddline1, String adminresidentaddline2, String adminresidentaddline3, String adminresidentaddline4, 
           String adminpostaladdline1, String adminpostaladdline2, String adminpostaladdline3, String adminpostaladdline4 ){

        Administrator administrator = new Administrator();
        Holder holder = new Holder();
        AdministratorPhoneNumber administratorPhone = new AdministratorPhoneNumber();
        AdministratorEmailAddress administratorEmail = new AdministratorEmailAddress();
        AdministratorResidentialAddress administratorresidential = new AdministratorResidentialAddress();
        AdministratorPostalAddress administratorpostaladdr = new AdministratorPostalAddress();
        
        administrator.setFirstName(firstName);
        administrator.setMiddleName(middleName);
        administrator.setLastName(lastName);
        //the deceased holder
        holder.setId(deceasedid); 
        
        administratorPhone.getId().setAdministratorId(administrator.getId());
        administratorPhone.getId().setPhoneNumber(adminfonenumber);
        administratorPhone.setIsPrimary(adminphoneValidity);
        
        administratorEmail.getId().setAdministratorId(administrator.getId());
        administratorEmail.getId().setEmailAddress(adminemail);
        administratorPhone.setIsPrimary(adminphoneValidity);
        
        administratorresidential.getId().setAdministratorId(administrator.getId());
        administratorresidential.setCity(adminresidentialcity);
        administratorresidential.setPostCode(adminresidentialpostalcode);
        administratorresidential.setIsPrimary(adminresidentialValidity);
        administratorresidential.getId().setState(adminresidentialstate);
        administratorresidential.getId().setCountry(adminresidentialcountry);
        administratorresidential.getId().setAddressLine1(adminresidentaddline1);
        administratorresidential.setAddressLine2(adminresidentaddline2);
        administratorresidential.setAddressLine3(adminresidentaddline3);
        administratorresidential.setAddressLine4(adminresidentaddline4);
        
        administratorpostaladdr.getId().setAdministratorId(administrator.getId());
        administratorpostaladdr.setCity(adminpostaladdresscity);
        administratorpostaladdr.setPostCode(adminpostaladdrpostcode);
        administratorpostaladdr.getId().setState(adminpostaladdrstate);
        administratorpostaladdr.getId().setCountry(adminpostaladdrcountry);
        administratorpostaladdr.setIsPrimary(adminpostalAddressValidity);
        administratorpostaladdr.getId().setAddressLine1(adminpostaladdline1);
        administratorpostaladdr.setAddressLine2(adminpostaladdline2);
        administratorpostaladdr.setAddressLine3(adminpostaladdline3);
        administratorpostaladdr.setAddressLine4(adminpostaladdline4);
        
        
        HashSet setAdministratorFone, setAdministratorEmail, setAdministratorAddress, setAdministratorpostaladdr, setholder;
        setAdministratorFone = new HashSet();
        setAdministratorFone.add(administratorPhone);
        setAdministratorEmail = new HashSet();
        setAdministratorEmail.add(administratorEmail);
        setAdministratorAddress = new HashSet();
        setAdministratorAddress.add(administratorresidential);
        setAdministratorpostaladdr = new HashSet();
        setAdministratorpostaladdr.add(administratorpostaladdr);
        setholder = new HashSet();
        setholder.add(holder);

        administrator.setAdministratorPhoneNumbers(setAdministratorFone);
        administrator.setAdministratorEmailAddresses(setAdministratorEmail);
        administrator.setAdministratorResidentialAddresses(setAdministratorAddress);
        administrator.setAdministratorPostalAddresses(setAdministratorpostaladdr);
        administrator.setHolders(setholder);
        
        return administrator;
        
    }

   /*************SYSTEM ABOVE PULLED LAST APRIL/21/2015********/
    /**
     * Create Shareholder account[manual creation]
     * @param holder to be created and persisted
     * @param residentialaddresses list of residential addresses if any or one or many
     * @param postaladdresses list of postal addresses if any or one or many
     * @param emailaddresses list of email addresses if any or one or many
     * @param fonenumbers list of phone numbers if any or one or many
     * @param companyaccount company account to be created and persisted
     * @return boolean type to know if the commands were persisted or failed
     */
    public boolean createShareholder(Holder holder, List<HolderResidentialAddress> residentialaddresses, List<HolderPostalAddress> postaladdresses, 
            List<HolderEmailAddress> emailaddresses, List<HolderPhoneNumber> fonenumbers, HolderCompanyAccount companyaccount){
        
        boolean recordcreated = false;
        try{
            startOperation();
            createUpdateObject(holder);
            for( HolderResidentialAddress address : residentialaddresses ){
                address.getId().setHolderId(holder.getId());
                createUpdateObject(address);
            }
            for( HolderPostalAddress postal : postaladdresses ){
                postal.getId().setHolderId(holder.getId());
                createUpdateObject(postal);
            }
            for( HolderEmailAddress email : emailaddresses ){
                email.getId().setHolderId(holder.getId());
                createUpdateObject(email);
            }
            for( HolderPhoneNumber phone : fonenumbers ){
                phone.getId().setHolderId(holder.getId());
                createUpdateObject(phone);
            }
            //persist holdercompanyobject
            createUpdateObject(companyaccount);
            getTransaction().commit();
            recordcreated = true;
            return recordcreated;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("holder creation encountered error(s) in the process and could not effect your commands - ", he);
            return recordcreated;
        }
    }
    
    /**
     * Create Bondholder account[manual creation]
     * @param holder to be created and persisted
     * @param residentialaddresses list of residential addresses if any or one or many
     * @param postaladdresses list of postal addresses if any or one or many
     * @param emailaddresses list of email addresses if any or one or many
     * @param fonenumbers list of phone numbers if any or one or many
     * @param bondaccount
     * @return boolean type to know if the commands were persisted or failed
     */
    public boolean createBondHolder(Holder holder, List<HolderResidentialAddress> residentialaddresses, List<HolderPostalAddress> postaladdresses, 
            List<HolderEmailAddress> emailaddresses, List<HolderPhoneNumber> fonenumbers, HolderBondAccount bondaccount){
        
        boolean recordcreated = false;
        try{
            startOperation();
            createUpdateObject(holder);
            for( HolderResidentialAddress address : residentialaddresses ){
                address.getId().setHolderId(holder.getId());
                createUpdateObject(address);
            }
            for( HolderPostalAddress postal : postaladdresses ){
                postal.getId().setHolderId(holder.getId());
                createUpdateObject(postal);
            }
            for( HolderEmailAddress email : emailaddresses ){
                email.getId().setHolderId(holder.getId());
                createUpdateObject(email);
            }
            for( HolderPhoneNumber phone : fonenumbers ){
                phone.getId().setHolderId(holder.getId());
                createUpdateObject(phone);
            }
            //persist holdercompanyobject
            createUpdateObject(bondaccount);
            getTransaction().commit();
            recordcreated = true;
            return recordcreated;
        }catch(HibernateException he){
            getTransaction().rollback();
            logger.info("holder creation encountered error(s) in the process and could not effect your commands - ", he);
            return recordcreated;
        }
    }
    
    /**
    *          Upload Shareholder / Bondholder Signature
     * @param signature
    */
    public void uploadHolderSignature(HolderSignature signature){
        startOperation();
        createUpdateObject(signature);
        getTransaction().commit();
    }
    
    /**
     * Query Shareholder / Bondholder Signature
     * @param holderid
     * @return 
     */
    public List queryHolderSignatureByHolderId(int holderid){
        startOperation();
        List<HolderSignature> receiveSignature = new ArrayList<>();
        String searchQuery = "from HolderSignature as signature where signature.holder=" + holderid;
        Query querySearch = getSession().createQuery(searchQuery);
        receiveSignature = querySearch.list();
        getTransaction().commit();
        return receiveSignature;
    }
    
    /**
     *   Query Power of Attorney
     * @param id
     * @return 
     */
    public List queryPowerOfAttorneyById(int id){
        
        startOperation();
        Criteria powerofattorney = getSession().createCriteria(PowerOfAttorney.class);
        powerofattorney.add(Restrictions.idEq(id));
        List result = powerofattorney.list();
        getTransaction().commit();
        return result;
    }
    
    public PowerOfAttorney queryPowerOfAttorneyByObject(int id){
        
        startOperation();
        PowerOfAttorney powerofattorney = (PowerOfAttorney) searchObject(null, id);
        getTransaction().commit();
        return powerofattorney;
    }
    
    /**
     * Edit Shareholder / Bondholder Account details
     *An overloaded updateShareholderAccount that takes only objects of
     * Holder, and list of HolderEmailAddress, HolderPhoneNumber, HolderResidentialAddress, HolderPostalAddress
     * @param holder
     * @param holderemails
     * @param holderphones
     * @param holderpostaladdresses
     * @param holderresidentialaddresses
     * @return 
    */
    public boolean updateShareholderAccount(Holder holder, List<HolderEmailAddress> holderemails, List<HolderPhoneNumber> holderphones, 
            List<HolderPostalAddress> holderpostaladdresses, List<HolderResidentialAddress> holderresidentialaddresses){
        
        boolean updaterecord = false;
	try{
	startOperation();
        createUpdateObject(holder);
        for(HolderEmailAddress email : holderemails){
            createUpdateObject(email);
	}//end email for-loop
        holderphones.stream().forEach((phone) -> {
            createUpdateObject(phone);
        }); //end phone for-loop
        holderpostaladdresses.stream().forEach((postal) -> {
            createUpdateObject(postal);
        }); //end postal for-loop
        holderresidentialaddresses.stream().forEach((resident) -> {
            createUpdateObject(resident);
        }); //end resident for-loop
	getTransaction().commit();
	updaterecord = true;
	return updaterecord;
	}catch(HibernateException he){
            getTransaction().rollback();
            logger.info("error updating holder records - ", he);
            return updaterecord;
	}
    }
    
    /**
     * Store Shareholder / Bondholder NUBAN account number
     * @param holderaccount 
     */
    public void storeShareHolderNUBAN(HolderCompanyAccount holderaccount){
        startOperation();
        createUpdateObject(holderaccount);
        getTransaction().commit();
    }
    
    /**
     * Store Shareholder / Bondholder NUBAN account number
     * @param bondaccount
     */
    public void storeBondHolderNUBAN(HolderBondAccount bondaccount){
        startOperation();
        createUpdateObject(bondaccount);
        getTransaction().commit();
    }
    
    /**
     * Change Shareholder NUBAN account number by specific identifier id
     * @param id
     * @param nubantochange
     * @return 
     */
    public boolean changeShareHolderNUBANAccountById(int id, String nubantochange){
        //load the HolderCompanyAccount from db with identifier, obtain pessimistic lock to prevent two simultaneous update for the same person
        boolean updated = false;
        try{
        startOperation();
        HolderCompanyAccount shareholderaccount = 
                ( HolderCompanyAccount ) session.get( HolderCompanyAccount.class, id, LockOptions.UPGRADE);
        shareholderaccount.setNubanAccount(nubantochange);
            createUpdateObject( shareholderaccount );
        getTransaction().commit();
        updated = true;
        return updated;
        }catch(HibernateException he){
            logger.info("error updating NUBAN number", he);
            getTransaction().rollback();
            return updated;
        }
    }
    
    /**
     * Change Shareholder NUBAN account number by taken object as parameter
     * @param shareholderaccount
     * @return 
     */
    public boolean changeShareHolderNUBANAccountByObject( HolderCompanyAccount shareholderaccount ){
        //load the HolderCompanyAccount from db with identifier, obtain pessimistic lock to prevent two simultaneous update for the same person
        boolean updated = false;
        try{
        startOperation();
        createUpdateObject( shareholderaccount );
        getTransaction().commit();
        updated = true;
        return updated;
        }catch(HibernateException he){
            logger.info("error updating NUBAN number", he);
            getTransaction().rollback();
            return updated;
        }
    }
    
    /**
     * Change Bondholder NUBAN account number by specific identifier id
     * @param id
     * @param nubantochange
     * @return ,true if update is successful and false otherwise
     */
    public boolean changeBondHolderNUBANAccountById(int id, String nubantochange){
        //load the HolderCompanyAccount from db with identifier, obtain pessimistic lock to prevent two simultaneous update for the same person
        boolean updated = false;
        try{
        startOperation();
        HolderBondAccount holderbondaccount = 
                ( HolderBondAccount ) session.get( HolderBondAccount.class, id, LockOptions.UPGRADE);
        holderbondaccount.setNubanAccount(nubantochange);
        createUpdateObject( holderbondaccount );
        getTransaction().commit();
        updated = true;
        return updated;
        }catch(HibernateException he){
            logger.info( "error updating NUBAN number", he );
            getTransaction().rollback();
            return updated;
        }
    }
    
    /**
     * Change Bondholder NUBAN account number by taken object as parameter
     * @param holderbondaccount , sent object containing changes
     * @return , true if update is successful and false otherwise
     */
    public boolean changeBondHolderNUBANAccountByObject(HolderBondAccount holderbondaccount){
        //load the HolderCompanyAccount from db with identifier, obtain pessimistic lock to prevent two simultaneous update for the same person
        boolean updated = false;
        try{
            startOperation();
            createUpdateObject(holderbondaccount);
            getTransaction().commit();
            updated = true;
            return updated;
        }catch(HibernateException he){
            logger.info("error updating NUBAN number", he);
            getTransaction().rollback();
            return updated;
        }
        
    }
    
    /**
     * Query to load the source and destination shareholder account during Transferring, from which <p>
     * other attributes can be extracted
     * @param holdercompanyaccount
     * @return 
     */
    public HolderCompanyAccount getShareHolderAccount(int holdercompanyaccount){
        startOperation();
        HolderCompanyAccount holderaccount = 
                (HolderCompanyAccount) searchObject(HolderCompanyAccount.class, holdercompanyaccount);
        getTransaction().commit();
        return holderaccount;
    }
    
    /**
     * Transfer Share Units between Shareholder Company Accounts
     * @param holderaccount
     * @return 
     */
    public boolean transferShareunit(HolderCompanyAccount holderaccount){
        boolean transferUpdated = false;
        try{
            startOperation();
            createUpdateObject(holderaccount);
            getTransaction().commit();
            transferUpdated = true;
            return transferUpdated;
        }catch(HibernateException he){
            logger.info("error transfering the share units between the two shareholder's accounts", he);
            getTransaction().rollback();
            return transferUpdated;
        }
    }
    
    /**
     * Query to load the source and destination bond holder account,<p>
     * during Transferring from which other attributes can be extracted
     * @param holdercompanyaccount
     * @return 
     */
    public HolderBondAccount getHolderBondAccount(int holdercompanyaccount){
        startOperation();
        HolderBondAccount holderaccount = 
                (HolderBondAccount) searchObject(HolderBondAccount.class, holdercompanyaccount);
        getTransaction().commit();
        return holderaccount;
    }
    
    public boolean transferBondunit(HolderBondAccount holderbondaccount){
        boolean transferUpdated = false;
        try{
            startOperation();
            createUpdateObject(holderbondaccount);
            getTransaction().commit();
            transferUpdated = true;
            return transferUpdated;
        }catch(HibernateException he){
            logger.info("error transfering the bond unit between the two bondholder's accounts", he);
            getTransaction().rollback();
            return transferUpdated;
        }
    }
    /* ******************* LAST UPDATED ON APRIL 28TH, 2015****************** */  
    
   /**
    * View report on consolidation of Shareholder Accounts
    * first overloaded method to search all accounts merged between range of date
     * @param startdate
     * @param enddate
     * @return list of consolidated accounts
    */
    public List<CompanyAccountConsolidation> viewConsolidatedHolderAccount(Date startdate, Date enddate){
        startOperation();
        List<CompanyAccountConsolidation> listofconsolidatedaccounts = null;
        String searchQuery = "from CompanyAccountConsolidation as cac where cac.mergeDate between '" + startdate + "and'" + enddate +"'";
        Query querySearch = getSession().createQuery(searchQuery);
        listofconsolidatedaccounts = (List<CompanyAccountConsolidation>) querySearch.list();
        getTransaction().commit();
        return listofconsolidatedaccounts;
    }
    
    /**
    * View report on consolidation of Shareholder Accounts
    * second overloaded with only the merged date as taken parameter
     * @param mergeddate
     * @return list of consolidated accounts 
    */
    public List<CompanyAccountConsolidation> viewConsolidatedHolderAccount( Date mergeddate ){
        startOperation();
        List<CompanyAccountConsolidation> listofconsolidatedaccounts = null;
        String searchQuery = "from CompanyAccountConsolidation as cac where cac.mergeDate" + mergeddate;
        Query querySearch = getSession().createQuery(searchQuery);
        listofconsolidatedaccounts = (List<CompanyAccountConsolidation>) querySearch.list();
        getTransaction().commit();
        return listofconsolidatedaccounts;
    }
    
    /**
     * View report on consolidation of Shareholder Accounts;
     * All account merged before searching date
     * @param mergebeforesearchingdate , search parameter
     * @return list of consolidated accounts
     */
    public List<CompanyAccountConsolidation> viewConsolidatedHolderAccountBefore( Date mergebeforesearchingdate ){
        startOperation();
        List<CompanyAccountConsolidation> listofconsolidatedaccounts = null;
        Criteria criteriaEntity = getSession().createCriteria(CompanyAccountConsolidation.class);
        criteriaEntity.add( Restrictions.lt("mergeDate", mergebeforesearchingdate) );
        listofconsolidatedaccounts = (List<CompanyAccountConsolidation>) criteriaEntity.list();
        getTransaction().commit();
        return listofconsolidatedaccounts;
    }
    
    /**
     * View report on consolidation of Shareholder Accounts;
     * All accounts merged after searching date
     * @param mergeaftersearchingdate , search parameter
     * @return list of consolidated accounts
     */
    public List<CompanyAccountConsolidation> viewConsolidatedHolderAccountAfter( Date mergeaftersearchingdate ){
        startOperation();
        List<CompanyAccountConsolidation> listofconsolidatedaccounts = null;
        Criteria criteriaEntity = getSession().createCriteria(CompanyAccountConsolidation.class);
        criteriaEntity.add( Restrictions.gt("mergeDate", mergeaftersearchingdate) );
        listofconsolidatedaccounts = (List<CompanyAccountConsolidation>) criteriaEntity.list();
        getTransaction().commit();
        return listofconsolidatedaccounts;
    }
    
    /**
    * View Report on Shareholder/Bondholder Account details editing
    * first overloaded method to search all accounts edited between range of dates
     * @param startdate
     * @param enddate
     * @return list of edited accounts
    */
    public List<HolderChanges> viewEditedHolderAccount( Date startdate, Date enddate ){
        startOperation();
        List<HolderChanges> listofeditedholderaccounts = null;
        String searchQuery = "from HolderChanges as holderchange where holderchange.changeDate between '" + startdate + "and'" + enddate +"'";
        Query querySearch = getSession().createQuery(searchQuery);
        listofeditedholderaccounts = (List<HolderChanges>) querySearch.list();
        getTransaction().commit();
        return listofeditedholderaccounts;
    }
    
    /**
     * View Report on Shareholder/Bondholder Account details editing 
     * second overloaded with only the edited date as taken parameter
     * @param editeddate
     * @return list of edited accounts
     */
    public List<HolderChanges> viewEditedHolderAccount( Date editeddate ){
        startOperation();
        List<HolderChanges> listofeditedholderaccounts = null;
        String searchQuery = "from HolderChanges as holderchange where holderchange.changeDate" + editeddate;
        Query querySearch = getSession().createQuery(searchQuery);
        listofeditedholderaccounts = (List<HolderChanges>) querySearch.list();
        getTransaction().commit();
        return listofeditedholderaccounts;
    }
    
    /**
     * View report on consolidation of Shareholder Accounts;
     * All account merged before searching date
     * @param editbeforesearchingdate , search parameter
     * @return list of edited accounts
     */
    public List<HolderChanges> viewEditedHolderAccountBefore( Date editbeforesearchingdate ){
        startOperation();
        List<HolderChanges> listofeditedholderaccounts = null;
        Criteria criteriaEntity = getSession().createCriteria(HolderChanges.class);
        criteriaEntity.add( Restrictions.lt("changeDate", editbeforesearchingdate) );
        listofeditedholderaccounts = (List<HolderChanges>) criteriaEntity.list();
        getTransaction().commit();
        return listofeditedholderaccounts;
    }
    
    /**
     * View report on consolidation of Shareholder Accounts;
     * All accounts merged after searching date
     * @param editaftersearchingdate , search parameter
     * @return list of edited accounts
     */
    public List<HolderChanges> vieweditedHolderAccountAfter( Date editaftersearchingdate ){
        startOperation();
        List<HolderChanges> listofeditedholderaccounts = null;
        Criteria criteriaEntity = getSession().createCriteria(HolderChanges.class);
        criteriaEntity.add( Restrictions.gt("changeDate", editaftersearchingdate) );
        listofeditedholderaccounts = (List<HolderChanges>) criteriaEntity.list();
        getTransaction().commit();
        return listofeditedholderaccounts;
    }
    
    
    /**
     * Merge / Consolidate Shareholder Accounts
     * @param accountconsole
     * @return 
    
    //public boolean mergeHolderAccounts( HolderCompanyAccount primaryaccount, List<HolderCompanyAccount> secondaryaccounts )
    public boolean mergeHolderAccounts( CompanyAccountConsolidation accountconsole ){
    boolean isAccountsMerged = false;
    try{
        startOperation();
        createUpdateObject(accountconsole);
        getTransaction().commit();
        isAccountsMerged = true;
        return isAccountsMerged;
    }catch(HibernateException he){
        getTransaction().rollback();
        logger.info("error to persist the merging process, please review! - ", he);
        return isAccountsMerged;
        }
    } */
}
