package com.intis.sdk;

import com.intis.sdk.entity.*;

import java.util.List;

import com.intis.sdk.exceptions.*;

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
     * @return PhoneBase[]
     */
    List<PhoneBase> getPhoneBases() throws PhoneBasesException;

    /**
     * Get sender names
     * @return Originator[]
     */
    List<Originator> getOriginators() throws OriginatorException;

    /**
     * Get phone numbers from list
     * @param baseId - List ID
     * @param page - Page number
     * @return PhoneBaseItem[]
     */
    List<PhoneBaseItem> getPhoneBaseItems(Integer baseId, Integer page) throws PhoneBaseItemException;

    /**
     * Get information of message status
     * @param messageId - Message ID
     * @return PhoneBaseItem[]
     */
    List<DeliveryStatus> getDeliveryStatus(String[] messageId) throws DeliveryStatusException;

    /**
     * Send a message
     * @param phone - Phone number
     * @param originator - Sender name (one of the approved in your account)
     * @param text - SMS text
     * @return Message ID
     */
    List<MessageSendingResult> sendMessage(String[] phone, String originator, String text) throws MessageSendingResultException;

    /**
     * Search of number in stop list
     * @param phone - Phone number
     * @return StopList
     */
    StopList checkStopList(String phone) throws StopListException;

    /**
     * Add number to stop list
     * @param phone - Phone number
     * @return ID
     */
    Long addToStopList(String phone) throws AddToStopListException;

    /**
     * Get list of templates
     * @return Template[]
     */
    List<Template> getTemplates() throws TemplateException;

    /**
     * Add a template
     * @param title - Template name
     * @param template - Template
     * @return ID
     */
    Long addTemplate(String title, String template) throws AddTemplateException;

    /**
     * Get statistics for a month by days
     * @param year - Year
     * @param month - Month
     * @return DailyStats[]
     */
    List<DailyStats> getDailyStatsByMonth(Integer year, Integer month) throws DailyStatsException;

    /**
     * HLR request
     * @param phone - Phone number
     * @return HLRResponse[]
     */
    List<HLRResponse> makeHlrRequest(String[] phone) throws HLRResponseException;

    /**
     * Statistics of HLR requests
     * @param from - Initial date in the format YYYY-MM-DD
     * @param to - Final date in the format YYYY-MM-DD
     * @return HLRStatItem[]
     */
    List<HLRStatItem> getHlrStats(String from, String to) throws HLRStatItemException;

    /**
     * Get operator
     * @param phone - Phone number
     * @return Network
     */
    Network getNetworkByPhone(String phone) throws NetworkException;

    /**
     * Get incoming SMS
     * @param date - Date in the format YYYY-MM-DD
     * @return IncomingMessage[]
     */
    List<IncomingMessage> getIncomingMessages(String date) throws IncomingMessageException;
}
