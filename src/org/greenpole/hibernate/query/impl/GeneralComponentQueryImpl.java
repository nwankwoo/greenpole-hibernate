/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.util.ArrayList;
import java.util.List;
import org.greenpole.hibernate.entity.EnvironmentalVariables;
import org.greenpole.hibernate.entity.Notification;
import org.greenpole.hibernate.entity.PropertyEmail;
import org.greenpole.hibernate.entity.PropertyGreenpoleEngine;
import org.greenpole.hibernate.entity.PropertyNotifications;
import org.greenpole.hibernate.entity.PropertyNotifiers;
import org.greenpole.hibernate.entity.PropertyQueueConfig;
import org.greenpole.hibernate.entity.PropertySms;
import org.greenpole.hibernate.entity.PropertyThreadpool;
import org.greenpole.hibernate.entity.TextMessage;
import org.greenpole.hibernate.entity.UserAccess;
import org.greenpole.hibernate.entity.UserAccount;
import org.greenpole.hibernate.query.GeneralComponentQuery;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Akinwale Agbaje
 */
public class GeneralComponentQueryImpl extends GeneralisedAbstractDao implements GeneralComponentQuery {
    private static final Logger logger = LoggerFactory.getLogger(GeneralComponentQueryImpl.class);

    @Override
    public void testConnection() {
        startOperation();
        getTransaction().commit();
    }

    @Override
    public void createUpdateNotification(Notification notification) {
        startOperation();
        createUpdateObject(notification);
        getTransaction().commit();
    }

    @Override
    public List<Notification> getNotificationsForReceiver(String userId) {
        startOperation();
        Criteria nonAttendedCriteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("sentTo", userId))
                .add(Restrictions.eq("attendedTo", false))
                .add(Restrictions.eq("rejected", false))
                .add(Restrictions.eq("writeOff", false));
        List<Notification> nonAttended = nonAttendedCriteria.list();
        
        Criteria rejectedCriteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("sentFrom", userId))
                .add(Restrictions.eq("attendedTo", true))
                .add(Restrictions.eq("rejected", true))
                .add(Restrictions.eq("writeOff", false));
        List<Notification> rejected = rejectedCriteria.list();
        
        List<Notification> resultList = new ArrayList<>();
        for (Notification n : nonAttended) {
            resultList.add(n);
        }
        for (Notification n : rejected) {
            resultList.add(n);
        }
        getTransaction().commit();
        return resultList;
    }

    @Override
    public List<Notification> getNotificationsForSender(String userId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("sentFrom", userId))
                .add(Restrictions.eq("attendedTo", false))
                .add(Restrictions.eq("rejected", false))
                .add(Restrictions.eq("writeOff", false));
        List<Notification> resultList = criteria.list();
        getTransaction().commit();
        return resultList;
    }

    @Override
    public Notification getNotification(String notificationCode) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("fileName", notificationCode))
                .add(Restrictions.eq("writeOff", false));
        Notification result = (Notification) criteria.list().get(0);
        getTransaction().commit();
        return result;
    }

    @Override
    public boolean checkNotification(String notificationCode) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("fileName", notificationCode))
                .add(Restrictions.eq("attendedTo", false))
                .add(Restrictions.eq("rejected", false))
                .add(Restrictions.eq("writeOff", false))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkNotificationAgainstUser(String userId, String notificationCode) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("sentTo", userId))
                .add(Restrictions.eq("fileName", notificationCode))
                .add(Restrictions.eq("attendedTo", false))
                .add(Restrictions.eq("rejected", false))
                .add(Restrictions.eq("writeOff", false))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkFromToSame(String userId, String notificationCode) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("sentFrom", userId))
                .add(Restrictions.eq("sentTo", userId))
                .add(Restrictions.eq("fileName", notificationCode))
                .add(Restrictions.eq("attendedTo", false))
                .add(Restrictions.eq("rejected", false))
                .add(Restrictions.eq("writeOff", false))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkNotificationIgnoreAttended(String notificationCode) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("fileName", notificationCode))
                .add(Restrictions.eq("writeOff", false))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkValidUser(String userId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(UserAccess.class)
                .add(Restrictions.eq("email", userId))
                .add(Restrictions.eq("suspended", false))
                .add(Restrictions.eq("locked", false))
                .add(Restrictions.eq("expired", false))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public boolean checkUser(String userId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(UserAccess.class)
                .add(Restrictions.eq("email", userId))
                .setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        getTransaction().commit();
        return count > 0;
    }

    @Override
    public UserAccount getUserAccount(String userId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(UserAccount.class)
                .add(Restrictions.eq("userAccesses.email", userId));
        UserAccount acctInfo = (UserAccount) criteria.list().get(0);
        getTransaction().commit();
        return acctInfo;
    }

    @Override
    public UserAccess getUserAccess(String userId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(UserAccess.class)
                .add(Restrictions.eq("email", userId));
        UserAccess accessInfo = (UserAccess) criteria.list().get(0);
        getTransaction().commit();
        return accessInfo;
    }

    @Override
    public boolean persistTextMessageRecord(TextMessage text) {
        boolean persisted = false;
        try {
            startOperation();
            createUpdateObject(text);
            getTransaction().commit();
            persisted = true;
        } catch (Exception ex) {
            logger.error("error thrown while persisting text message record - ", ex);
            getTransaction().rollback();
        }
        return persisted;
    }

    @Override
    public boolean persistMultipleTextMessageRecord(List<TextMessage> texts) {
        boolean persisted = false;
        try {
            startOperation();
            texts.stream().forEach((text) -> {
                createUpdateObject(text);
            });
            getTransaction().commit();
            persisted = true;
        } catch (Exception ex) {
            logger.error("error thrown while persisting text message record - ", ex);
            getTransaction().rollback();
        }
        return persisted;
    }

    @Override
    public TextMessage getTextMessageRecord(String messageId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(TextMessage.class)
                .add(Restrictions.eq("messageId", messageId));
        TextMessage txt = (TextMessage) criteria.list().get(0);
        getTransaction().commit();
        return txt;
    }

    @Override
    public List<PropertyEmail> getAllEmailProperty() {
        startOperation();
        List<PropertyEmail> propList = searchAll(PropertyEmail.class);
        getTransaction().commit();
        return propList;
    }

    @Override
    public List<PropertyGreenpoleEngine> getAllEngineProperty() {
        startOperation();
        List<PropertyGreenpoleEngine> propList = searchAll(PropertyGreenpoleEngine.class);
        getTransaction().commit();
        return propList;
    }

    @Override
    public List<PropertyNotifications> getAllNotificationsProperty() {
        startOperation();
        List<PropertyNotifications> propList = searchAll(PropertyNotifications.class);
        getTransaction().commit();
        return propList;
    }

    @Override
    public List<PropertyNotifiers> getAllNotifiersProperty() {
        startOperation();
        List<PropertyNotifiers> propList = searchAll(PropertyNotifiers.class);
        getTransaction().commit();
        return propList;
    }

    @Override
    public List<PropertyQueueConfig> getAllQueueConfigProperty() {
        startOperation();
        List<PropertyQueueConfig> propList = searchAll(PropertyQueueConfig.class);
        getTransaction().commit();
        return propList;
    }

    @Override
    public List<PropertySms> getAllSmsProperty() {
        startOperation();
        List<PropertySms> propList = searchAll(PropertySms.class);
        getTransaction().commit();
        return propList;
    }

    @Override
    public List<PropertyThreadpool> getAllThreadProperty() {
        startOperation();
        List<PropertyThreadpool> propList = searchAll(PropertyThreadpool.class);
        getTransaction().commit();
        return propList;
    }

    @Override
    public PropertyEmail getEmailProperty(String propertyName) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PropertyEmail.class)
                .add(Restrictions.eq("propertyName", propertyName));
        PropertyEmail prop = (PropertyEmail) criteria.list().get(0);
        getTransaction().commit();
        return prop;
    }

    @Override
    public PropertyGreenpoleEngine getEngineProperty(String propertyName) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PropertyGreenpoleEngine.class)
                .add(Restrictions.eq("propertyName", propertyName));
        PropertyGreenpoleEngine prop = (PropertyGreenpoleEngine) criteria.list().get(0);
        getTransaction().commit();
        return prop;
    }

    @Override
    public PropertyNotifications getNotificationsProperty(String propertyName) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PropertyNotifications.class)
                .add(Restrictions.eq("propertyName", propertyName));
        PropertyNotifications prop = (PropertyNotifications) criteria.list().get(0);
        getTransaction().commit();
        return prop;
    }

    @Override
    public PropertyNotifiers getNotifiersProperty(String propertyName) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PropertyNotifiers.class)
                .add(Restrictions.eq("propertyName", propertyName));
        PropertyNotifiers prop = (PropertyNotifiers) criteria.list().get(0);
        getTransaction().commit();
        return prop;
    }

    @Override
    public PropertyQueueConfig getQueueConfigProperty(String propertyName) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PropertyQueueConfig.class)
                .add(Restrictions.eq("propertyName", propertyName));
        PropertyQueueConfig prop = (PropertyQueueConfig) criteria.list().get(0);
        getTransaction().commit();
        return prop;
    }

    @Override
    public PropertySms getSmsProperty(String propertyName) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PropertySms.class)
                .add(Restrictions.eq("propertyName", propertyName));
        PropertySms prop = (PropertySms) criteria.list().get(0);
        getTransaction().commit();
        return prop;
    }

    @Override
    public PropertyThreadpool getThreadProperty(String propertyName) {
        startOperation();
        Criteria criteria = getSession().createCriteria(PropertyThreadpool.class)
                .add(Restrictions.eq("propertyName", propertyName));
        PropertyThreadpool prop = (PropertyThreadpool) criteria.list().get(0);
        getTransaction().commit();
        return prop;
    }

    @Override
    public void updateEmailProperty(PropertyEmail property) {
        startOperation();
        createUpdateObject(property);
        getTransaction().commit();
    }

    @Override
    public void updateEngineProperty(PropertyGreenpoleEngine property) {
        startOperation();
        createUpdateObject(property);
        getTransaction().commit();
    }

    @Override
    public void updateNotificationsProperty(PropertyNotifications property) {
        startOperation();
        createUpdateObject(property);
        getTransaction().commit();
    }

    @Override
    public void updateNotifiersProperty(PropertyNotifiers property) {
        startOperation();
        createUpdateObject(property);
        getTransaction().commit();
    }

    @Override
    public void updateQueueConfigProperty(PropertyQueueConfig property) {
        startOperation();
        createUpdateObject(property);
        getTransaction().commit();
    }

    @Override
    public void updateSmsProperty(PropertySms property) {
        startOperation();
        createUpdateObject(property);
        getTransaction().commit();
    }

    @Override
    public void updateThreadProperty(PropertyThreadpool property) {
        startOperation();
        createUpdateObject(property);
        getTransaction().commit();
    }

    @Override
    public EnvironmentalVariables getVariable(String variable) {
        startOperation();
        Criteria criteria = getSession().createCriteria(EnvironmentalVariables.class)
                .add(Restrictions.eq("variable", variable));
        EnvironmentalVariables ev = (EnvironmentalVariables) criteria.list().get(0);
        getTransaction().commit();
        return ev;
    }

    @Override
    public List<EnvironmentalVariables> getAllVariables() {
        startOperation();
        List<EnvironmentalVariables> evList = searchAll(EnvironmentalVariables.class);
        getTransaction().commit();
        return evList;
    }
    
}
