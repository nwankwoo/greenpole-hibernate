/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
import org.greenpole.hibernate.entity.Notification;

/**
 *
 * @author Akinwale Agbaje
 * Contains queries that cut across all components.
 */
public interface GeneralComponentQuery {
    /**
     * Registers a new notification record in the database.
     * @param notification the notification to be registered
     */
    public void createUpdateNotification(Notification notification);
    
    /**
     * Gets a list of notifications according to the specified userId.
     * This method should be used to get the notifications sent to
     * a particular user.
     * @param userId the user's id, typically an email address
     * @return a list of the user's notifications
     */
    public List<Notification> getNotificationsForReceiver(String userId);
    
    /**
     * Gets a list of notifications according to the specified userId.
     * This method should be used to get the notifications sent from
     * a particular user.
     * @param userId the user's id, typically an email address
     * @return a list of the user's notifications
     */
    public List<Notification> getNotificationsForSender(String userId);
    
    /**
     * Gets a notification according to the specified notification code.
     * @param notificationCode the notification code
     * @return the notification object
     */
    public Notification getNotification(String notificationCode);
    
    /**
     * Checks the existence of a notification in the database.
     * NOTE: only unattended notifications are valid in this check.
     * @param notificationCode the notification code
     * @return true, if notification exists. Otherwise, false
     */
    public boolean checkNotification(String notificationCode);
    
    /**
     * Checks the existence of a notification in the database.
     * NOTE: this method ignores the attended check as done in
     * {@link #checkNotification(java.lang.String) }
     * @param notificationCode the notification code
     * @return true, if notification exists. Otherwise, false
     */
    public boolean checkNotificationIgnoreAttended(String notificationCode);
    
}
