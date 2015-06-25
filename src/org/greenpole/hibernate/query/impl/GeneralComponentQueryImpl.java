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
        try {
            startOperation();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public void createUpdateNotification(Notification notification) {
        try {
            startOperation();
            createUpdateObject(notification);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public List<Notification> getNotificationsForReceiver(String userId) {
        List<Notification> resultList = new ArrayList<>();
        try {
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

            resultList = new ArrayList<>();
            for (Notification n : nonAttended) {
                resultList.add(n);
            }
            for (Notification n : rejected) {
                resultList.add(n);
            }
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return resultList;
    }

    @Override
    public List<Notification> getNotificationsForSender(String userId) {
        List<Notification> resultList = new ArrayList<>();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(Notification.class)
                    .add(Restrictions.eq("sentFrom", userId))
                    .add(Restrictions.eq("attendedTo", false))
                    .add(Restrictions.eq("rejected", false))
                    .add(Restrictions.eq("writeOff", false));
            resultList = criteria.list();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return resultList;
    }

    @Override
    public Notification getNotification(String notificationCode) {
        Notification result = new Notification();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(Notification.class)
                    .add(Restrictions.eq("fileName", notificationCode))
                    .add(Restrictions.eq("writeOff", false));
            result = (Notification) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return result;
    }

    @Override
    public boolean checkNotification(String notificationCode) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(Notification.class)
                    .add(Restrictions.eq("fileName", notificationCode))
                    .add(Restrictions.eq("attendedTo", false))
                    .add(Restrictions.eq("rejected", false))
                    .add(Restrictions.eq("writeOff", false))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkNotificationAgainstUser(String userId, String notificationCode) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(Notification.class)
                    .add(Restrictions.eq("sentTo", userId))
                    .add(Restrictions.eq("fileName", notificationCode))
                    .add(Restrictions.eq("attendedTo", false))
                    .add(Restrictions.eq("rejected", false))
                    .add(Restrictions.eq("writeOff", false))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkFromToSame(String userId, String notificationCode) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(Notification.class)
                    .add(Restrictions.eq("sentFrom", userId))
                    .add(Restrictions.eq("sentTo", userId))
                    .add(Restrictions.eq("fileName", notificationCode))
                    .add(Restrictions.eq("attendedTo", false))
                    .add(Restrictions.eq("rejected", false))
                    .add(Restrictions.eq("writeOff", false))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkNotificationIgnoreAttended(String notificationCode) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(Notification.class)
                    .add(Restrictions.eq("fileName", notificationCode))
                    .add(Restrictions.eq("writeOff", false))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkValidUser(String userId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(UserAccess.class)
                    .add(Restrictions.eq("email", userId))
                    .add(Restrictions.eq("suspended", false))
                    .add(Restrictions.eq("locked", false))
                    .add(Restrictions.eq("expired", false))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public boolean checkUser(String userId) {
        Long count = 0L;
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(UserAccess.class)
                    .add(Restrictions.eq("email", userId))
                    .setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return count > 0;
    }

    @Override
    public UserAccount getUserAccount(String userId) {
        UserAccount acctInfo = new UserAccount();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(UserAccount.class)
                    .add(Restrictions.eq("userAccesses.email", userId));
            acctInfo = (UserAccount) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return acctInfo;
    }

    @Override
    public UserAccess getUserAccess(String userId) {
        UserAccess accessInfo = new UserAccess();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(UserAccess.class)
                    .add(Restrictions.eq("email", userId));
            accessInfo = (UserAccess) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return accessInfo;
    }

    @Override
    public boolean persistTextMessageRecord(TextMessage text) {
        boolean persisted = false;
        try {
            startOperation();
            createUpdateObject(text);
            commit();
            persisted = true;
        } catch (Exception ex) {
            logger.error("error thrown while persisting text message record - ", ex);
            rollback();
        } finally {
            closeSession();
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
            commit();
            persisted = true;
        } catch (Exception ex) {
            logger.error("error thrown while persisting text message record - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return persisted;
    }

    @Override
    public TextMessage getTextMessageRecord(String messageId) {
        TextMessage txt = new TextMessage();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(TextMessage.class)
                    .add(Restrictions.eq("messageId", messageId));
            txt = (TextMessage) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return txt;
    }

    @Override
    public List<PropertyEmail> getAllEmailProperty() {
        List<PropertyEmail> propList = new ArrayList<>();
        try {
            startOperation();
            propList = searchAll(PropertyEmail.class);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return propList;
    }

    @Override
    public List<PropertyGreenpoleEngine> getAllEngineProperty() {
        List<PropertyGreenpoleEngine> propList = new ArrayList<>();
        try {
            startOperation();
            propList = searchAll(PropertyGreenpoleEngine.class);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return propList;
    }

    @Override
    public List<PropertyNotifications> getAllNotificationsProperty() {
        List<PropertyNotifications> propList = new ArrayList<>();
        try {
            startOperation();
            propList = searchAll(PropertyNotifications.class);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return propList;
    }

    @Override
    public List<PropertyNotifiers> getAllNotifiersProperty() {
        List<PropertyNotifiers> propList = new ArrayList<>();
        try {
            startOperation();
            propList = searchAll(PropertyNotifiers.class);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return propList;
    }

    @Override
    public List<PropertyQueueConfig> getAllQueueConfigProperty() {
        List<PropertyQueueConfig> propList = new ArrayList<>();
        try {
            startOperation();
            propList = searchAll(PropertyQueueConfig.class);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return propList;
    }

    @Override
    public List<PropertySms> getAllSmsProperty() {
        List<PropertySms> propList = new ArrayList<>();
        try {
            startOperation();
            propList = searchAll(PropertySms.class);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return propList;
    }

    @Override
    public List<PropertyThreadpool> getAllThreadProperty() {
        List<PropertyThreadpool> propList = new ArrayList<>();
        try {
            startOperation();
            propList = searchAll(PropertyThreadpool.class);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return propList;
    }

    @Override
    public PropertyEmail getEmailProperty(String propertyName) {
        PropertyEmail prop = new PropertyEmail();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PropertyEmail.class)
                    .add(Restrictions.eq("propertyName", propertyName));
            prop = (PropertyEmail) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return prop;
    }

    @Override
    public PropertyGreenpoleEngine getEngineProperty(String propertyName) {
        PropertyGreenpoleEngine prop = new PropertyGreenpoleEngine();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PropertyGreenpoleEngine.class)
                    .add(Restrictions.eq("propertyName", propertyName));
            prop = (PropertyGreenpoleEngine) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return prop;
    }

    @Override
    public PropertyNotifications getNotificationsProperty(String propertyName) {
        PropertyNotifications prop = new PropertyNotifications();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PropertyNotifications.class)
                    .add(Restrictions.eq("propertyName", propertyName));
            prop = (PropertyNotifications) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return prop;
    }

    @Override
    public PropertyNotifiers getNotifiersProperty(String propertyName) {
        PropertyNotifiers prop = new PropertyNotifiers();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PropertyNotifiers.class)
                    .add(Restrictions.eq("propertyName", propertyName));
            prop = (PropertyNotifiers) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return prop;
    }

    @Override
    public PropertyQueueConfig getQueueConfigProperty(String propertyName) {
        PropertyQueueConfig prop = new PropertyQueueConfig();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PropertyQueueConfig.class)
                    .add(Restrictions.eq("propertyName", propertyName));
            prop = (PropertyQueueConfig) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return prop;
    }

    @Override
    public PropertySms getSmsProperty(String propertyName) {
        PropertySms prop = new PropertySms();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PropertySms.class)
                    .add(Restrictions.eq("propertyName", propertyName));
            prop = (PropertySms) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return prop;
    }

    @Override
    public PropertyThreadpool getThreadProperty(String propertyName) {
        PropertyThreadpool prop = new PropertyThreadpool();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(PropertyThreadpool.class)
                    .add(Restrictions.eq("propertyName", propertyName));
            prop = (PropertyThreadpool) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return prop;
    }

    @Override
    public void updateEmailProperty(PropertyEmail property) {
        try {
            startOperation();
            createUpdateObject(property);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public void updateEngineProperty(PropertyGreenpoleEngine property) {
        try {
            startOperation();
            createUpdateObject(property);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public void updateNotificationsProperty(PropertyNotifications property) {
        try {
            startOperation();
            createUpdateObject(property);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public void updateNotifiersProperty(PropertyNotifiers property) {
        try {
            startOperation();
            createUpdateObject(property);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public void updateQueueConfigProperty(PropertyQueueConfig property) {
        try {
            startOperation();
            createUpdateObject(property);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public void updateSmsProperty(PropertySms property) {
        try {
            startOperation();
            createUpdateObject(property);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public void updateThreadProperty(PropertyThreadpool property) {
        try {
            startOperation();
            createUpdateObject(property);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
    }

    @Override
    public EnvironmentalVariables getVariable(String variable) {
        EnvironmentalVariables ev = new EnvironmentalVariables();
        try {
            startOperation();
            Criteria criteria = getSession().createCriteria(EnvironmentalVariables.class)
                    .add(Restrictions.eq("variable", variable));
            ev = (EnvironmentalVariables) criteria.list().get(0);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return ev;
    }

    @Override
    public List<EnvironmentalVariables> getAllVariables() {
        List<EnvironmentalVariables> evList = new ArrayList<>();
        try {
            startOperation();
            evList = searchAll(EnvironmentalVariables.class);
            commit();
        } catch (Exception ex) {
            logger.error("error thrown - ", ex);
            rollback();
        } finally {
            closeSession();
        }
        return evList;
    }
    
}
