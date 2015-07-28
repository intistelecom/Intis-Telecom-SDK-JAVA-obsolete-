package com.intis.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IntisClient extends AClient {

    public IntisClient(String login, String apiKey, String apiHost)
    {
        mLogin = login;
        mApiKey = apiKey;
        mApiHost = apiHost;
    }

    public Balance getBalance() throws BalanceException
    {
        Map<String, String> parameters = new HashMap<String, String>();
        String content = getContent("balance", parameters);

        try {
            ObjectMapper mapper = new ObjectMapper();
            Balance balance = mapper.readValue(content, Balance.class);

            return balance;
        }
        catch (Throwable ex) {
            throw new BalanceException(parameters, ex);
        }
    }

    public List<PhoneBase> getPhoneBases() throws PhoneBasesException
    {
        Map<String, String> parameters = new HashMap<String, String>();
        String content = getContent("base", parameters);

        List<PhoneBase> bases = new ArrayList<PhoneBase>();

        try {
            Map<Long, PhoneBase> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<Long, PhoneBase>>() {});

            for(Map.Entry<Long, PhoneBase> entry : map.entrySet()) {
                Long baseId = entry.getKey();
                PhoneBase phoneBase = entry.getValue();
                phoneBase.setBaseId(baseId);
                bases.add(phoneBase);
            }

            return bases;
        }catch (Exception e) {
            throw new PhoneBasesException(parameters, e);
        }
    }

    public List<Originator> getOriginators() throws OriginatorException
    {
        Map<String, String> parameters = new HashMap<String, String>();
        String content = getContent("senders", parameters);

        List<Originator> originators = new ArrayList<Originator>();

        try {
            Map<String, String> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<String, String>>() {});

            for(Map.Entry<String, String> entry : map.entrySet()) {
                originators.add(new Originator(entry.getKey(), entry.getValue()));
            }

            return originators;
        }
        catch (Exception e) {
            throw new OriginatorException(parameters, e);
        }
    }

    public List<PhoneBaseItem> GetPhoneBaseItems(Integer baseId, Integer page) throws PhoneBaseItemException
    {
        if(page.equals(null))
            page = 1;

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("base", baseId.toString());
        parameters.put("page", page.toString());
        String content = getContent("phone", parameters);

        List<PhoneBaseItem> phoneBaseItems = new ArrayList<PhoneBaseItem>();

        try {
            Map<Long, PhoneBaseItem> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<Long, PhoneBaseItem>>() {});

            for(Map.Entry<Long, PhoneBaseItem> entry : map.entrySet()) {
                Long phone = entry.getKey();
                PhoneBaseItem phoneBase = entry.getValue();
                phoneBase.setPhone(phone);
                phoneBaseItems.add(phoneBase);
            }

            return phoneBaseItems;
        }
        catch (Exception ex) {
            throw new PhoneBaseItemException(parameters, ex);
        }
    }

    public List<DeliveryStatus> GetDeliveryStatus(String[] messageId) throws DeliveryStatusException
    {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("state", String.join(",", messageId));
        String content = getContent("status", parameters);

        List<DeliveryStatus> deliveryStatus = new ArrayList<DeliveryStatus>();

        try {
            Map<String, DeliveryStatus> map;
            ObjectMapper mapper = new ObjectMapper();

            map = mapper.readValue(content, new TypeReference<HashMap<String, DeliveryStatus>>() {});

            for(Map.Entry<String, DeliveryStatus> entry : map.entrySet()) {
                String MessageId = entry.getKey();
                DeliveryStatus item = entry.getValue();
                item.setMessageId(MessageId);
                deliveryStatus.add(item);
            }

            return deliveryStatus;
        }
        catch (Exception ex) {
            throw new DeliveryStatusException(parameters, ex);
        }
    }

    public List<MessageSendingResult> SendMessage(Long[] phone, String originator, String text) throws MessageSendingResultException
    {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("phone", String.join(",", phone.toString()));
        parameters.put("sender", originator);
        parameters.put("text", text);
        String content = getContent("send", parameters);

        List<MessageSendingResult> messages = new ArrayList<MessageSendingResult>();

        try
        {
            var serializer = new DataContractJsonSerializer(typeof(Dictionary<Int64, MessageSending>[]), settings);
            var items = serializer.ReadObject(content) as Dictionary<Int64, MessageSending>[];

            if (items == null)
                return messages;

            foreach (var one in items)
            {
                var item = one.First().Value;
                item.Phone = one.First().Key;
                if(item.Error == 0)
                {
                    var success = new MessageSendingSuccess{
                    Phone = item.Phone,
                            MessageId = item.MessageId,
                            MessagesCount = item.MessagesCount,
                            Cost = item.Cost,
                            Currency = item.Currency
                };
                    messages.Add(success);
                }
                else
                {
                    var error = new MessageSendingError{
                    Phone = item.Phone,
                            Code = item.Error
                };
                    messages.Add(error);
                }
            }

            return messages;
        }
        catch (Exception ex) {
            throw new MessageSendingResultException(parameters, ex);
        }
    }
//
//    public StopList CheckStopList(Int64 phone)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"phone", phone.ToString()}
//        };
//
//        var content = GetStreamContent("find_on_stop", parameters);
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<Int64, StopList>), settings);
//            var check = serializer.ReadObject(content) as Dictionary<Int64, StopList>;
//
//            if (check == null || check.Count <= 0)
//                return null;
//
//            var one = check.First();
//            var stopList = one.Value;
//            stopList.Id = one.Key;
//
//            return stopList;
//        }
//        catch (SerializationException ex)
//        {
//            throw new StopListException(parameters, ex);
//        }
//    }
//
//    public Int64 AddToStopList(Int64 phone)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"phone", phone.ToString()}
//        };
//
//        var content = GetContent("add2stop", parameters);
//
//        try
//        {
//            var serializer = new JavaScriptSerializer();
//            var list = serializer.Deserialize<Dictionary<string, Int64>>(content);
//
//            return list.First().Value;
//        }
//        catch (SerializationException ex)
//        {
//            throw new AddToStopListException(parameters, ex);
//        }
//    }
//
//    public List<Template> GetTemplates()
//    {
//        var parameters = new NameValueCollection();
//
//        var content = GetStreamContent("template", parameters);
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<Int64, Template>), settings);
//            var items = serializer.ReadObject(content) as Dictionary<Int64, Template>;
//
//            var list = new List<Template>();
//
//            if (items == null)
//                return list;
//
//            foreach (var one in items)
//            {
//                var item = one.Value;
//                item.Id = one.Key;
//                list.Add(item);
//            }
//
//            return list;
//        }
//        catch (SerializationException ex)
//        {
//            throw new TemplateException(parameters, ex);
//        }
//    }
//
//    public Int64 AddTemplate(string title, string template)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"name", title},
//            {"text", template}
//        };
//
//        var content = GetContent("add_template", parameters);
//
//        try
//        {
//            var serializer = new JavaScriptSerializer();
//            var list = serializer.Deserialize<Dictionary<string, Int64>>(content);
//
//            return list.First().Value;
//        }
//        catch (SerializationException ex)
//        {
//            throw new AddTemplateException(parameters, ex);
//        }
//    }
//
//    public List<DailyStats> GetDailyStatsByMonth(int year, int month)
//    {
//        var date = new DateTime(year, month, 1, 0, 0, 0);
//
//        var parameters = new NameValueCollection()
//        {
//            {"month", date.ToString("yyyy-MM")}
//        };
//
//        var content = GetStreamContent("stat_by_month", parameters);
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<string, Dictionary<string, Stats[]>[]>[]), settings);
//            var items = serializer.ReadObject(content) as Dictionary<string, Dictionary<string, Stats[]>[]>[];
//
//            var list = new List<DailyStats>();
//
//            if (items == null)
//                return list;
//
//            list.AddRange(items.Select(one => one.First()).Select(stateDate => new DailyStats(stateDate)));
//
//            return list;
//        }
//        catch (SerializationException ex)
//        {
//            throw new DailyStatsException(parameters, ex);
//        }
//    }
//
//    public List<HlrResponse> MakeHlrRequest(Int64[] phone)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"phone", String.Join(",", phone.Select(p => p.ToString()))}
//        };
//
//        var content = GetStreamContent("hlr", parameters);
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<Int64, HlrResponse>), settings);
//            var items = serializer.ReadObject(content) as List<HlrResponse>;
//
//            return items;
//        }
//        catch (SerializationException ex)
//        {
//            throw new HlrResponseException(parameters, ex);
//        }
//    }
//
//    public List<HlrStatItem> GetHlrStats(string from, string to)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"from", from},
//            {"to", to}
//        };
//
//        var content = GetStreamContent("hlr_stat", parameters);
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var list = new List<HlrStatItem>();
//
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<Int64, HlrStatItem>), settings);
//            var items = serializer.ReadObject(content) as Dictionary<Int64, HlrStatItem>;
//
//            if (items == null)
//                return list;
//
//            list.AddRange(items.Select(one => one.Value));
//
//            return list;
//        }
//        catch (SerializationException ex)
//        {
//            throw new HlrStatItemException(parameters, ex);
//        }
//    }
//
//    public Network GetNetworkByPhone(Int64 phone)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"phone", phone.ToString()}
//        };
//
//        var content = GetStreamContent("operator", parameters);
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Network));
//            var network = serializer.ReadObject(content) as Network;
//
//            return network;
//        }
//        catch (SerializationException ex)
//        {
//            throw new NetworkException(parameters, ex);
//        }
//    }
//
//    public List<IncomingMessage> GetIncomingMessages(string date)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"date", date}
//        };
//
//        var content = GetStreamContent("incoming", parameters);
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var list = new List<IncomingMessage>();
//
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<string, IncomingMessage>), settings);
//            var items = serializer.ReadObject(content) as Dictionary<string, IncomingMessage>;
//
//            if (items == null)
//                return list;
//
//            foreach (var one in items)
//            {
//                var message = one.Value;
//                message.MessageId = one.Key;
//                list.Add(one.Value);
//            }
//
//            return list;
//        }
//        catch (SerializationException ex)
//        {
//            throw new IncomingMessageException(parameters, ex);
//        }
//    }
}
