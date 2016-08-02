/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Intis Telecom
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.intistele.sdk;

import com.intistele.sdk.entity.*;

import java.util.List;

import com.intistele.sdk.exceptions.*;

/**
 * Interface IClient
 *
 * Class with methods of receiving SDK information
 */
public interface IClient {

    /**
     * Get balance
     * @return Balance
     */
    Balance getBalance() throws BalanceException;
    /**
     * Getting user lists
     * @return list of phone base
     */
    List<PhoneBase> getPhoneBases() throws PhoneBasesException;

    /**
     * Get sender names
     * @return list of senders with its statuses
     */
    List<Originator> getOriginators() throws OriginatorException;

    /**
     * Get phone numbers from list
     * @param baseId - List ID
     * @param page - Page number
     * @return list subscribers
     */
    List<PhoneBaseItem> getPhoneBaseItems(Integer baseId, Integer page) throws PhoneBaseItemException;

    /**
     * Get information of message status
     * @param messageId - Message ID
     * @return list of message status
     */
    List<DeliveryStatus> getDeliveryStatus(String[] messageId) throws DeliveryStatusException;

    /**
     * Send a message
     * @param phone - Phone number
     * @param originator - Sender name (one of the approved in your account)
     * @param text - SMS text
     * @return results list
     */
    List<MessageSendingResult> sendMessage(String[] phone, String originator, String text) throws MessageSendingResultException;

    /**
     * Send a message
     * @param phone - Phone number
     * @param originator - Sender name (one of the approved in your account)
     * @param text - SMS text
     * @param sendingTime - An optional parameter, it is used when it is necessary to schedule SMS message
     * @return results list
     */
    List<MessageSendingResult> sendMessage(String[] phone, String originator, String text, String sendingTime) throws MessageSendingResultException;

    /**
     * Search of number in stop list
     * @param phone - Phone number
     * @return stop list
     */
    StopList checkStopList(String phone) throws StopListException;

    /**
     * Add number to stop list
     * @param phone - Phone number
     * @return ID in stop list
     */
    Long addToStopList(String phone) throws AddToStopListException;

    /**
     * Get list of templates
     * @return list of templates
     */
    List<Template> getTemplates() throws TemplateException;

    /**
     * Add a template
     * @param title - Template name
     * @param template - Template
     * @return ID in the template list
     */
    Long addTemplate(String title, String template) throws AddTemplateException;

    /**
     * Edit a template
     * @param title - Template name
     * @param template - Template
     * @return ID in the template list
     */
    Long editTemplate(String title, String template) throws AddTemplateException;

    /**
     * Get statistics for a month by days
     * @param year - Year
     * @param month - Month
     * @return statistics
     */
    List<DailyStats> getDailyStatsByMonth(Integer year, Integer month) throws DailyStatsException;

    /**
     * HLR request
     * @param phone - Phone number
     * @return results list
     */
    List<HLRResponse> makeHlrRequest(String[] phone) throws HLRResponseException;

    /**
     * Statistics of HLR requests
     * @param from - Initial date in the format YYYY-MM-DD
     * @param to - Final date in the format YYYY-MM-DD
     * @return statuses
     */
    List<HLRStatItem> getHlrStats(String from, String to) throws HLRStatItemException;

    /**
     * Get operator
     * @param phone - Phone number
     * @return operator
     */
    Network getNetworkByPhone(String phone) throws NetworkException;

    /**
     * Get incoming SMS
     * @param date - Date in the format YYYY-MM-DD
     * @return list of incoming messages
     */
    List<IncomingMessage> getIncomingMessages(String date) throws IncomingMessageException;

    /**
     * Get incoming SMS for the period
     * @param from - Initial date in the format YYYY-MM-DD HH:II:SS
     * @param to - Finel date in the format YYYY-MM-DD HH:II:SS
     * @return list of incoming messages
     */
    List<IncomingMessage> getIncomingMessages(String from, String to) throws IncomingMessageException;
}
