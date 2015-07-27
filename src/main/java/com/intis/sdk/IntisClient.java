package com.intis.sdk;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intis.sdk.entity.*;
import com.intis.sdk.exceptions.*;

import java.io.IOException;
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

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            Balance balance = mapper.readValue(content, Balance.class);

            return balance;
        }
        catch (Throwable ex) {
            throw new BalanceException(parameters, ex);
        }
    }

//    public List<PhoneBase> GetPhoneBases()
//    {
//        Map<String, String> parameters = new HashMap<String, String>();
//        String content = getContent("base", parameters);
//
//        List<PhoneBase> bases = new List<PhoneBase>();
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<Int64, PhoneBase>), settings);
//            var phoneBases = serializer.ReadObject(content) as Dictionary<Int64, PhoneBase>;
//            if (phoneBases == null)
//                return bases;
//
//            foreach (var one in phoneBases)
//            {
//                var oneBase = one.Value;
//                oneBase.BaseId = one.Key;
//                bases.Add(oneBase);
//            }
//
//            return bases;
//        }
//        catch (SerializationException ex)
//        {
//            throw new PhoneBasesException(parameters, ex);
//        }
//    }
//
//    public List<Originator> GetOriginators()
//    {
//        var parameters = new NameValueCollection();
//        var content = GetContent("senders", parameters);
//
//        var originators = new List<Originator>();
//        try
//        {
//            var serializer = new JavaScriptSerializer();
//            var list = serializer.Deserialize<Dictionary<string, string>>(content);
//
//            originators.AddRange(list.Select(one => new Originator(one.Key, one.Value)));
//
//            return originators;
//        }
//        catch (SerializationException ex)
//        {
//            throw new OriginatorException(parameters, ex);
//        }
//    }
//
//    public List<PhoneBaseItem> GetPhoneBaseItems(int baseId, int page = 1)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"base", baseId.ToString()},
//            {"page", page.ToString()}
//        };
//
//        var content = GetStreamContent("phone", parameters);
//        var phoneBaseItem = new List<PhoneBaseItem>();
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<Int64, PhoneBaseItem>), settings);
//            var items = serializer.ReadObject(content) as Dictionary<Int64, PhoneBaseItem>;
//
//            if (items == null)
//                return phoneBaseItem;
//
//            foreach (var one in items)
//            {
//                var item = one.Value;
//                item.Phone = one.Key;
//                phoneBaseItem.Add(item);
//            }
//
//            return phoneBaseItem;
//        }
//        catch (SerializationException ex)
//        {
//            throw new PhoneBaseItemException(parameters, ex);
//        }
//    }
//
//    public List<DeliveryStatus> GetDeliveryStatus(string[] messageId)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"state", String.Join(",", messageId)}
//        };
//
//        var content = GetStreamContent("status", parameters);
//
//        var deliveryStatus = new List<DeliveryStatus>();
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<string, DeliveryStatus>), settings);
//            var items = serializer.ReadObject(content) as Dictionary<string, DeliveryStatus>;
//
//            if (items == null)
//                return deliveryStatus;
//
//            foreach (var one in items)
//            {
//                var item = one.Value;
//                item.MessageId = one.Key;
//                deliveryStatus.Add(item);
//            }
//
//            return deliveryStatus;
//        }
//        catch (SerializationException ex)
//        {
//            throw new DeliveryStatusException(parameters, ex);
//        }
//    }
//
//    public List<MessageSendingResult> SendMessage(Int64[] phone, string originator, string text)
//    {
//        var parameters = new NameValueCollection()
//        {
//            {"phone", String.Join(",", phone.Select(p => p.ToString()))},
//            {"sender", originator},
//            {"text", text}
//        };
//
//        var content = GetStreamContent("send", parameters);
//
//        var settings = new DataContractJsonSerializerSettings
//        {
//            UseSimpleDictionaryFormat = true
//        };
//
//        var messages = new List<MessageSendingResult>();
//
//        try
//        {
//            var serializer = new DataContractJsonSerializer(typeof(Dictionary<Int64, MessageSending>[]), settings);
//            var items = serializer.ReadObject(content) as Dictionary<Int64, MessageSending>[];
//
//            if (items == null)
//                return messages;
//
//            foreach (var one in items)
//            {
//                var item = one.First().Value;
//                item.Phone = one.First().Key;
//                if(item.Error == 0)
//                {
//                    var success = new MessageSendingSuccess{
//                    Phone = item.Phone,
//                            MessageId = item.MessageId,
//                            MessagesCount = item.MessagesCount,
//                            Cost = item.Cost,
//                            Currency = item.Currency
//                };
//                    messages.Add(success);
//                }
//                else
//                {
//                    var error = new MessageSendingError{
//                    Phone = item.Phone,
//                            Code = item.Error
//                };
//                    messages.Add(error);
//                }
//            }
//
//            return messages;
//        }
//        catch (SerializationException ex)
//        {
//            throw new MessageSendingResultException(parameters, ex);
//        }
//    }
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
