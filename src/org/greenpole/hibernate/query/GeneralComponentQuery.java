/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

import java.util.List;
import org.greenpole.hibernate.entity.Notification;
import org.greenpole.hibernate.entity.UserAccess;
import org.greenpole.hibernate.entity.UserAccount;

/**
 *
 * @author Akinwale Agbaje
 * Contains queries that cut across all components.
 */
public interface GeneralComponentQuery {
    
    /**
     * Test connection.
     */
    public void testConnection();
    
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
     * Checks the existence of a notification that belongs to the specified user.
     * @param userId the user's id
     * @param notificationCode the notification code
     * @return true, if notification belongs to user. Otherwise, false
     */
    public boolean checkNotificationAgainstUser(String userId, String notificationCode);
    
    /**
     * Checks that notification code is tied to the sent to/from persons.
     * @param userId the user's id
     * @param notificationCode the notification code
     * @return true, if notification code is tied to the sent to/from persons
     */
    public boolean checkFromToSame(String userId, String notificationCode);
    
    /**
     * Checks the existence of a notification in the database.
     * NOTE: this method ignores the attended check as done in
     * {@link #checkNotification(java.lang.String) }
     * @param notificationCode the notification code
     * @return true, if notification exists. Otherwise, false
     */
    public boolean checkNotificationIgnoreAttended(String notificationCode);
    
    /**
     * Checks that a user is valid.
     * @param userId the user's id, typically an email address
     * @return true, if user exists. Otherwise, false
     */
    public boolean checkValidUser(String userId);
    
    /**
     * Checks that user exists in database.
     * @param userId the user's id, typically an email address
     * @return true, if user exists. Otherwise, false
     */
    public boolean checkUser(String userId);
    
    /**
     * Gets a user's account information
     * @param userId the user's id, typically an email address
     * @return the user's account information
     */
    public UserAccount getUserAccount(String userId);
    
    /**
     * Gets a user's access information.
     * @param userId the user's id, typically an email address
     * @return the user's access information
     */
    public UserAccess getUserAccess(String userId);
    
}
