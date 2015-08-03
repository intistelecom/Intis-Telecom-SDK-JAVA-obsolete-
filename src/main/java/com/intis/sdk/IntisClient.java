package com.intis.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class IntisClient extends AClient implements IClient {

    public IntisClient(String login, String apiKey, String apiHost, IApiConnector apiConnector) {
        super(apiConnector);
        mLogin = login;
        mApiKey = apiKey;
        mApiHost = apiHost;
    }

    public IntisClient(String login, String apiKey, String apiHost) {
        this(login, apiKey, apiHost, null);
    }

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

    public List<DeliveryStatus> getDeliveryStatus(String[] messageId) throws DeliveryStatusException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("state", String.join(",", messageId));

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

    public List<MessageSendingResult> sendMessage(String[] phone, String originator, String text) throws MessageSendingResultException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", String.join(",", phone));
        parameters.put("sender", originator);
        parameters.put("text", text);

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

    public Long addTemplate(String title, String template) throws AddTemplateException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("name", title);
        parameters.put("text", template);
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

    public List<HLRResponse> makeHlrRequest(String[] phone) throws HLRResponseException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", String.join(",", phone));

        try {
            String content = getContent("hlr", parameters);

            ObjectMapper mapper = new ObjectMapper();

            List<HLRResponse> items = mapper.readValue(content, new TypeReference<List<HLRResponse>>() {});

            return items;
        } catch (Exception ex) {
            throw new HLRResponseException(parameters, ex);
        }
    }

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

    public List<IncomingMessage> getIncomingMessages(String date) throws IncomingMessageException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("date", date);

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
