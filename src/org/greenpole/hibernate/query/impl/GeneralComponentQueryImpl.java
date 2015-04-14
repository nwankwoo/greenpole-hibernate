/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query.impl;

import org.greenpole.hibernate.entity.Notification;
import org.greenpole.hibernate.query.GeneralComponentQuery;
import org.greenpole.hibernate.query.GeneralisedAbstractDao;

/**
 *
 * @author Akinwale Agbaje
 */
public class GeneralComponentQueryImpl extends GeneralisedAbstractDao implements GeneralComponentQuery {

    @Override
    public void createNotification(Notification notification) {
        startOperation();
        createUpdateObject(notification);
        getTransaction().commit();
    }
    
}
