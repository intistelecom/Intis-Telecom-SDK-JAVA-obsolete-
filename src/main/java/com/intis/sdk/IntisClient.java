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
package com.intis.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.String.*;

/**
 * Class IntisClient
 * The main class for SMS sending and getting API information
 */
public class IntisClient extends AClient implements IClient {

    /**
     * Class constructor
     *
     * @param login user login
     * @param apiKey user API key
     * @param apiHost API address
     * @param apiConnector API data connector
     */
    public IntisClient(String login, String apiKey, String apiHost, IApiConnector apiConnector) {
        super(apiConnector);
        mLogin = login;
        mApiKey = apiKey;
        mApiHost = apiHost;
    }

    /**
     * Class constructor
     *
     * @param login user login
     * @param apiKey user API key
     * @param apiHost API address
     */
    public IntisClient(String login, String apiKey, String apiHost) {
        this(login, apiKey, apiHost, null);
    }

    /**
     * Getting user balance
     *
     * @throws BalanceException
     * @return Balance
     */
    public Balance getBalance() throws BalanceException {
        Map<String, String> parameters = new HashMap<String, String>();

        try {
            String content = getContent("balance", parameters);
            ObjectMapper mapper = new ObjectMapper();
            Balance balance = mapper.readValue(content, Balance.class);

            return balance;
        } catch (Throwable ex) {
            throw new BalanceException(parameters, ex);
        }
    }

    /**
     * Getting all user lists
     *
     * @throws PhoneBasesException
     * @return list of phone base
     */
    public List<PhoneBase> getPhoneBases() throws PhoneBasesException {
        Map<String, String> parameters = new HashMap<String, String>();

        try {
            String content = getContent("base", parameters);

            List<PhoneBase> bases = new ArrayList<PhoneBase>();

            Map<Long, PhoneBase> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<Long, PhoneBase>>() {
            });

            for (Map.Entry<Long, PhoneBase> entry : map.entrySet()) {
                Long baseId = entry.getKey();
                PhoneBase phoneBase = entry.getValue();
                phoneBase.setBaseId(baseId);
                bases.add(phoneBase);
            }

            return bases;
        } catch (Exception e) {
            throw new PhoneBasesException(parameters, e);
        }
    }

    /**
     * Getting all user sender names
     *
     * @throws OriginatorException
     * @return list of senders with its statuses
     */
    public List<Originator> getOriginators() throws OriginatorException {
        Map<String, String> parameters = new HashMap<String, String>();

        try {
            String content = getContent("senders", parameters);

            List<Originator> originators = new ArrayList<Originator>();

            Map<String, String> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<String, String>>() {
            });

            for (Map.Entry<String, String> entry : map.entrySet()) {
                originators.add(new Originator(entry.getKey(), entry.getValue()));
            }

            return originators;
        } catch (Exception e) {
            throw new OriginatorException(parameters, e);
        }
    }

    /**
     * Getting subscribers of list
     *
     * @param baseId List ID
     * @param page Page of list
     *
     * @throws PhoneBaseItemException
     * @return list subscribers
     */
    public List<PhoneBaseItem> getPhoneBaseItems(Integer baseId, Integer page) throws PhoneBaseItemException {
        if (page.equals(null))
            page = 1;

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("base", baseId.toString());
        parameters.put("page", page.toString());

        try {
            String content = getContent("phone", parameters);

            List<PhoneBaseItem> phoneBaseItems = new ArrayList<PhoneBaseItem>();

            Map<Long, PhoneBaseItem> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<Long, PhoneBaseItem>>() {
            });

            for (Map.Entry<Long, PhoneBaseItem> entry : map.entrySet()) {
                Long phone = entry.getKey();
                PhoneBaseItem phoneBase = entry.getValue();
                phoneBase.setPhone(phone);
                phoneBaseItems.add(phoneBase);
            }

            return phoneBaseItems;
        } catch (Exception ex) {
            throw new PhoneBaseItemException(parameters, ex);
        }
    }

    /**
     * Getting message status
     *
     * @param messageId Message ID
     *
     * @throws DeliveryStatusException
     * @return list of message status
     */
    public List<DeliveryStatus> getDeliveryStatus(String[] messageId) throws DeliveryStatusException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("state", join(",", messageId));

        try {
            String content = getContent("status", parameters);

            List<DeliveryStatus> deliveryStatus = new ArrayList<DeliveryStatus>();

            Map<String, DeliveryStatus> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<String, DeliveryStatus>>() {});

            for (Map.Entry<String, DeliveryStatus> entry : map.entrySet()) {
                String MessageId = entry.getKey();
                DeliveryStatus item = entry.getValue();
                item.setMessageId(MessageId);
                deliveryStatus.add(item);
            }

            return deliveryStatus;
        } catch (Exception ex) {
            throw new DeliveryStatusException(parameters, ex);
        }
    }

    /**
     * SMS sending
     *
     * @param phone phone number(s)
     * @param originator sender name
     * @param text sms text
     *
     * @throws MessageSendingResultException
     * @return results list
     */
    public List<MessageSendingResult> sendMessage(String[] phone, String originator, String text) throws MessageSendingResultException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", join(",", phone));
        parameters.put("sender", originator);
        parameters.put("text", text);

        return querySendMessage(parameters);
    }

    /**
     * SMS sending
     *
     * @param phone phone number(s)
     * @param originator sender name
     * @param text sms text
     * @param sendingTime an optional parameter, it is used when it is necessary to schedule SMS messages
     *
     * @throws MessageSendingResultException
     * @return results list
     */
    public List<MessageSendingResult> sendMessage(String[] phone, String originator, String text, String sendingTime) throws MessageSendingResultException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", join(",", phone));
        parameters.put("sender", originator);
        parameters.put("text", text);
        parameters.put("sendingTime", sendingTime);

        return querySendMessage(parameters);
    }

    private List<MessageSendingResult> querySendMessage( Map<String, String> parameters) throws MessageSendingResultException{
        try {
            String content = getContent("send", parameters);

            List<MessageSendingResult> messages = new ArrayList<MessageSendingResult>();

            Map<String, MessageSending> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<String, MessageSending>>() {
            });

            for (Map.Entry<String, MessageSending> entry : map.entrySet()) {
                MessageSending result = entry.getValue();
                result.setPhone(entry.getKey());
                if (result.getError() == 0) {
                    MessageSendingSuccess success = new MessageSendingSuccess();
                    success.setPhone(result.getPhone());
                    success.setMessageId(result.getMessageId());
                    success.setMessagesCount(result.getMessagesCount());
                    success.setCost(result.getCost());
                    success.setCurrency(result.getCurrency());

                    messages.add(success);
                } else {
                    MessageSendingError error = new MessageSendingError();
                    error.setPhone(result.getPhone());
                    error.setCode(result.getError());

                    messages.add(error);
                }
            }

            return messages;
        } catch (Exception ex) {
            throw new MessageSendingResultException(parameters, ex);
        }
    }

    /**
     * Testing phone number for stop list
     *
     * @param phone phone number
     *
     * @throws StopListException
     * @return stop list
     */
    public StopList checkStopList(String phone) throws StopListException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", phone);

        try {
            String content = getContent("find_on_stop", parameters);

            StopList stopList = new StopList();
            ObjectMapper mapper = new ObjectMapper();
            Map<Long, StopList> map = mapper.readValue(content, new TypeReference<HashMap<Long, StopList>>() {
            });

            for (Map.Entry<Long, StopList> entry : map.entrySet()) {
                stopList = entry.getValue();
                stopList.setId(entry.getKey());
            }

            return stopList;
        } catch (Exception ex) {
            throw new StopListException(parameters, ex);
        }
    }

    /**
     * Adding number to stop list
     *
     * @param phone phone number
     *
     * @throws AddToStopListException
     * @return  ID in stop list
     */
    public Long addToStopList(String phone) throws AddToStopListException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", phone);

        try {
            String content = getContent("add2stop", parameters);

            ObjectMapper mapper = new ObjectMapper();

            Map<String, Long> map = mapper.readValue(content, new TypeReference<HashMap<String, Long>>() {
            });

            Map.Entry<String, Long> entry = map.entrySet().iterator().next();

            return entry.getValue();
        } catch (Exception ex) {
            throw new AddToStopListException(parameters, ex);
        }
    }

    /**
     * Getting user templates
     *
     * @throws TemplateException
     * @return list of templates
     */
    public List<Template> getTemplates() throws TemplateException {
        Map<String, String> parameters = new HashMap<String, String>();

        try {
            String content = getContent("template", parameters);

            List<Template> list = new ArrayList<Template>();

            Map<Long, Template> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<Long, Template>>() {
            });

            for (Map.Entry<Long, Template> entry : map.entrySet()) {
                Template item = entry.getValue();
                item.setId(entry.getKey());

                list.add(item);
            }

            return list;
        } catch (Exception ex) {
            throw new TemplateException(parameters, ex);
        }
    }

    /**
     * Adding user template
     *
     * @param title template name
     * @param template text of template
     *
     * @throws AddTemplateException
     * @return ID in the template list
     */
    public Long addTemplate(String title, String template) throws AddTemplateException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("name", title);
        parameters.put("text", template);

        return queryAddTemplate(parameters);
    }

    /**
     * Edit user template
     *
     * @param title template name
     * @param template text of template
     *
     * @throws AddTemplateException
     * @return ID in the template list
     */
    public Long editTemplate(String title, String template) throws AddTemplateException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("name", title);
        parameters.put("text", template);
        parameters.put("override", "1");

        return queryAddTemplate(parameters);
    }

    private Long queryAddTemplate(Map<String, String> parameters) throws AddTemplateException {
        try {
            String content = getContent("add_template", parameters);

            ObjectMapper mapper = new ObjectMapper();

            Map<String, Long> map = mapper.readValue(content, new TypeReference<HashMap<String, Long>>() {
            });

            Map.Entry<String, Long> entry = map.entrySet().iterator().next();

            return entry.getValue();
        } catch (Exception ex) {
            throw new AddTemplateException(parameters, ex);
        }
    }

    /**
     * Remove user template
     *
     * @param name template name
     *
     * @throws RemoveTemplateException
     * @return RemoveTemplateResponse
     */
    public RemoveTemplateResponse removeTemplate(String name) throws RemoveTemplateException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("name", name);
        try {
            String content = getContent("del_template", parameters);

            ObjectMapper mapper = new ObjectMapper();

            RemoveTemplateResponse response = mapper.readValue(content, RemoveTemplateResponse.class);

            return response;
        } catch (Exception ex) {
            throw new RemoveTemplateException(parameters, ex);
        }
    }

    /**
     * Getting statistics for the certain month
     *
     * @param year year
     * @param month month
     *
     * @throws DailyStatsException
     * @return statistics
     */
    public List<DailyStats> getDailyStatsByMonth(Integer year, Integer month) throws DailyStatsException
    {
        Map<String, String> parameters = new HashMap<String, String>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDate date;
        try {
            date = LocalDate.of(year, month, 1);
            parameters.put("month", date.format(formatter));

            String content = getContent("stat_by_month", parameters);

            ObjectMapper mapper = new ObjectMapper();

            List<DailyStats> list = mapper.readValue(content, new TypeReference<List<DailyStats>>(){});

            return list;
        }
        catch (Exception e){
            parameters.put("month", year + "-" + month);
            throw new DailyStatsException(parameters, e);
        }
    }

    /**
     * Sending HLR request for number
     *
     * @param phone phone number
     *
     * @throws HLRResponseException
     * @return results list
     */
    public List<HLRResponse> makeHlrRequest(String[] phone) throws HLRResponseException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", join(",", phone));

        try {
            String content = getContent("hlr", parameters);

            ObjectMapper mapper = new ObjectMapper();

            List<HLRResponse> items = mapper.readValue(content, new TypeReference<List<HLRResponse>>() {});

            return items;
        } catch (Exception ex) {
            throw new HLRResponseException(parameters, ex);
        }
    }

    /**
     * Getting statuses of HLR request
     *
     * @param from
     * @param to
     *
     * @throws HLRStatItemException
     * @return statuses
     */
    public List<HLRStatItem> getHlrStats(String from, String to) throws HLRStatItemException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("from", from);
        parameters.put("to", to);

        try {
            String content = getContent("hlr_stat", parameters);

            List<HLRStatItem> items = new ArrayList<HLRStatItem>();

            ObjectMapper mapper = new ObjectMapper();

            Map<Long, HLRStatItem> map = mapper.readValue(content, new TypeReference<HashMap<Long, HLRStatItem>>() {
            });
            for (Map.Entry<Long, HLRStatItem> entry : map.entrySet()) {
                items.add(entry.getValue());
            }

            return items;
        } catch (Exception ex) {
            throw new HLRStatItemException(parameters, ex);
        }
    }

    /**
     * Getting the operator of subscriber phone number
     *
     * @param phone phone number
     *
     * @throws NetworkException
     * @return operator
     */
    public Network getNetworkByPhone(String phone) throws NetworkException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", phone);

        try {
            String content = getContent("operator", parameters);

            ObjectMapper mapper = new ObjectMapper();
            Network network = mapper.readValue(content, Network.class);

            return network;
        } catch (Exception ex) {
            throw new NetworkException(parameters, ex);
        }
    }

    /**
     * Getting incoming messages of certain date
     *
     * @param date date
     *
     * @throws IncomingMessageException
     * @return list of incoming messages
     */
    public List<IncomingMessage> getIncomingMessages(String date) throws IncomingMessageException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("date", date);

        return queryIncomingMessages(parameters);
    }

    /**
     * Get incoming SMS for the period
     *
     * @param from - Initial date in the format YYYY-MM-DD HH:II:SS
     * @param to - Finel date in the format YYYY-MM-DD HH:II:SS
     *
     * @throws IncomingMessageException
     * @return list of incoming messages
     */
    public List<IncomingMessage> getIncomingMessages(String from, String to) throws IncomingMessageException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("from", from);
        parameters.put("to", to);

        return queryIncomingMessages(parameters);
    }

    private List<IncomingMessage> queryIncomingMessages(Map<String, String> parameters) throws IncomingMessageException{
        try {
            String content = getContent("incoming", parameters);

            List<IncomingMessage> list = new ArrayList<IncomingMessage>();

            ObjectMapper mapper = new ObjectMapper();

            Map<String, IncomingMessage> map = mapper.readValue(content, new TypeReference<HashMap<String, IncomingMessage>>() {
            });
            for (Map.Entry<String, IncomingMessage> entry : map.entrySet()) {
                IncomingMessage item = entry.getValue();
                item.setMessageId(entry.getKey());
                list.add(entry.getValue());
            }

            return list;
        } catch (Exception ex) {
            throw new IncomingMessageException(parameters, ex);
        }
    }
}
