package com.intis.sdk;

import com.intis.sdk.entity.*;

import java.util.ArrayList;

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
    Balance getBalance();
    /**
     * Getting user lists
     * @return PhoneBase[]
     */
    ArrayList<PhoneBase> getPhoneBases();

    /**
     * Get sender names
     * @return Originator[]
     */
    ArrayList<Originator> getOriginators();

    /**
     * Get phone numbers from list
     * @param baseId - List ID
     * @param page - Page number
     * @return PhoneBaseItem[]
     */
    ArrayList<PhoneBaseItem> getPhoneBaseItems(int baseId, int page);

    /**
     * Get information of message status
     * @param messageId - Message ID
     * @return PhoneBaseItem[]
     */
    ArrayList<DeliveryStatus> getDeliveryStatus(String[] messageId);

    /**
     * Send a message
     * @param phone - Phone number
     * @param originator - Sender name (one of the approved in your account)
     * @param text - SMS text
     * @return Message ID
     */
    ArrayList<MessageSendingResult> gendMessage(long[] phone, String originator, String text);

    /**
     * Search of number in stop list
     * @param phone - Phone number
     * @return StopList
     */
    StopList checkStopList(long phone);

    /**
     * Add number to stop list
     * @param phone - Phone number
     * @return ID
     */
    long addToStopList(long phone);

    /**
     * Get list of templates
     * @return Template[]
     */
    ArrayList<Template> getTemplates();

    /**
     * Add a template
     * @param title - Template name
     * @param template - Template
     * @return ID
     */
    long addTemplate(String title, String template);

    /**
     * Get statistics for a month by days
     * @param year - Year
     * @param month - Month
     * @return DailyStats[]
     */
    ArrayList<DailyStats> getDailyStatsByMonth(int year, int month);

    /**
     * HLR request
     * @param phone - Phone number
     * @return HLRResponse[]
     */
    ArrayList<HLRResponse> makeHlrRequest(long[] phone);

    /**
     * Statistics of HLR requests
     * @param from - Initial date in the format YYYY-MM-DD
     * @param to - Final date in the format YYYY-MM-DD
     * @return HLRStatItem[]
     */
    ArrayList<HLRStatItem> getHlrStats(String from, String to);

    /**
     * Get operator
     * @param phone - Phone number
     * @return Network
     */
    Network getNetworkByPhone(long phone);

    /**
     * Get incoming SMS
     * @param date - Date in the format YYYY-MM-DD
     * @return IncomingMessage[]
     */
    ArrayList<IncomingMessage> getIncomingMessages(String date);
}
