/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import org.greenpole.entity.notification.NotificationWrapper;
import org.greenpole.hibernate.entity.Notification;
import org.greenpole.hibernate.query.GeneralComponentQuery;
import org.greenpole.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Akinwale Agbaje
 */
public class GeneralComponentQueryImpl implements GeneralComponentQuery {

    @Override
    public void createNotification(NotificationWrapper wrapper) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Notification notification = new Notification(wrapper.getCode(), 
                wrapper.getDescription(),wrapper.getFrom(), wrapper.getTo(),
                wrapper.getFromType(), wrapper.getToType(), wrapper.isAttendedTo());
        session.save(notification);
        tx.commit();
    }
    
}
