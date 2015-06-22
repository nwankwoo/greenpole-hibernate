/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.hibernate.query;

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
    
    /**
     * Saves / updates a text message record.
     * @param text the text message record
     * @return true, if save / update is successful
     */
    public boolean persistTextMessageRecord(TextMessage text);
    
    /**
     * Saves multiple text message records.
     * @param texts a list of text message records
     * @return true, if save is successful
     */
    public boolean persistMultipleTextMessageRecord(List<TextMessage> texts);
    
    /**
     * Gets a text message record according to a specified message id.
     * @param messageId the message id
     * @return the text message record object
     */
    public TextMessage getTextMessageRecord(String messageId);
    
    /**
     * Gets all email property.
     * @return a list of all email property
     */
    public List<PropertyEmail> getAllEmailProperty();
    
    /**
     * Gets all greenpole engine property.
     * @return a list of all greenpole engine property
     */
    public List<PropertyGreenpoleEngine> getAllEngineProperty();
    
    /**
     * Gets all notifications property.
     * @return a list of all notifications property
     */
    public List<PropertyNotifications> getAllNotificationsProperty();
    
    /**
     * Get all notifiers property.
     * @return a list of all notifiers property
     */
    public List<PropertyNotifiers> getAllNotifiersProperty();
    
    /**
     * Get all queue config property.
     * @return a list of all queue config property
     */
    public List<PropertyQueueConfig> getAllQueueConfigProperty();
    
    /**
     * Get all sms property.
     * @return a list of all sms property
     */
    public List<PropertySms> getAllSmsProperty();
    
    /**
     * Get all thread pool property.
     * @return a list of all thread pool property
     */
    public List<PropertyThreadpool> getAllThreadProperty();
    
    /**
     * Gets an email property according to the specified property name.
     * @param propertyName the property name
     * @return an email property object
     */
    public PropertyEmail getEmailProperty(String propertyName);
    
    /**
     * Gets a greenpole engine property according to the specified property name.
     * @param propertyName the property name
     * @return a greenpole engine property object
     */
    public PropertyGreenpoleEngine getEngineProperty(String propertyName);
    
    /**
     * Gets a notifications property according to the specified property name.
     * @param propertyName the property name
     * @return a notifications property object
     */
    public PropertyNotifications getNotificationsProperty(String propertyName);
    
    /**
     * Gets a notifiers property according to the specified property name.
     * @param propertyName the property name
     * @return a notifiers property object
     */
    public PropertyNotifiers getNotifiersProperty(String propertyName);
    
    /**
     * Gets a queue config property according to the specified property name.
     * @param propertyName the property name
     * @return a queue config property object
     */
    public PropertyQueueConfig getQueueConfigProperty(String propertyName);
    
    /**
     * Gets an SMS property according to the specified property name.
     * @param propertyName the property name
     * @return an SMS property object
     */
    public PropertySms getSmsProperty(String propertyName);
    
    /**
     * Gets a thread pool property according to the specified property name.
     * @param propertyName the property name
     * @return a thread pool property object
     */
    public PropertyThreadpool getThreadProperty(String propertyName);
    
    /**
     * Updates an email property.
     * @param property the property to update
     */
    public void updateEmailProperty(PropertyEmail property);
    
    /**
     * Updates a greenpole engine property.
     * @param property the property to update
     */
    public void updateEngineProperty(PropertyGreenpoleEngine property);
    
    /**
     * Updates a notifications property.
     * @param property the property to update
     */
    public void updateNotificationsProperty(PropertyNotifications property);
    
    /**
     * Updates a notifiers property.
     * @param property the property to update
     */
    public void updateNotifiersProperty(PropertyNotifiers property);
    
    /**
     * Updates a queue config property.
     * @param property the property to update
     */
    public void updateQueueConfigProperty(PropertyQueueConfig property);
    
    /**
     * Updates an SMS property.
     * @param property the property to update 
     */
    public void updateSmsProperty(PropertySms property);
    
    /**
     * Updates a thread pool property.
     * @param property the property to update
     */
    public void updateThreadProperty(PropertyThreadpool property);
    
    /**
     * Gets an environmental variable according to a specified variable name.
     * @param variable the variable name
     * @return an environmental variable object
     */
    public EnvironmentalVariables getVariable(String variable);
    
    /**
     * Gets a list of environmental variables.
     * @return a list of environmental variables
     */
    public List<EnvironmentalVariables> getAllVariables();
}
