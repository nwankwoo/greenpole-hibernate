/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import org.greenpole.entity.notification.NotificationWrapper;

/**
 *
 * @author Akinwale Agbaje
 * Contains queries that cut across all components.
 */
public interface GeneralComponentQuery {
    /**
     * Registers a new notification record in the database.
     * @param wrapper the notification wrapper containing information to be added
     *                into the database
     */
    public void createNotification(NotificationWrapper wrapper);
}
