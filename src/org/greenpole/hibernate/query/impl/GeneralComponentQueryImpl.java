/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import java.util.List;
import org.greenpole.hibernate.entity.Notification;
import org.greenpole.hibernate.entity.UserAccess;
import org.greenpole.hibernate.entity.UserAccount;
import org.greenpole.hibernate.query.GeneralComponentQuery;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Akinwale Agbaje
 */
public class GeneralComponentQueryImpl extends GeneralisedAbstractDao implements GeneralComponentQuery {

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
        Criteria criteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("sentTo", userId))
                .add(Restrictions.eq("attendedTo", false))
                .add(Restrictions.eq("writeOff", false));
        List<Notification> resultList = criteria.list();
        getTransaction().commit();
        return resultList;
    }

    @Override
    public List<Notification> getNotificationsForSender(String userId) {
        startOperation();
        Criteria criteria = getSession().createCriteria(Notification.class)
                .add(Restrictions.eq("sentFrom", userId))
                .add(Restrictions.eq("attendedTo", false))
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
    
}
