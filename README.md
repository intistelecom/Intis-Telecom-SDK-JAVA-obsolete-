Intis-Telecom-SDK-JAVA
=====================

The Intis telecom gateway lets you send SMS messages worldwide via its API. This program sends HTTP(s) requests and receives information as a response in JSON and/or XML. The main functions of our API include:

* sending SMS messages (including scheduling options);
* receiving status reports about messages that have been sent previously;
* requesting lists of authorised sender names;
* requesting lists of incoming SMS messages;
* requesting current balance status;
* requesting lists of databases;
* requesting lists of numbers within particular contact list;
* searching for a particular number in a stop list;
* requesting lists of templates;
* adding new templates;
* requesting monthly statistics;
* making HLR request;
* HLR запрос
* receiving HLR request statistics;
* requesting an operator’s name by phone number;

To begin using our API please [apply](https://go.intistele.com/external/client/register/) for your account at our website where you can get your login and API key.

Maven dependency
---------------------------
```
<dependency>
    <groupId>com.intistele</groupId>
    <artifactId>sdk</artifactId>
    <version>1.7</version>
</dependency>
```

Usage
---------------------------

class IntisClient - The main class for SMS sending and getting API information

There are three mandatory parameters that you have to provide the constructor in order to initialize. They are:
* login - user login
* apiKey - user API key
* apiHost - API address

```java

import com.intis.sdk.IntisClient;

IntisClient client = new IntisClient(login, apiKey, apiHost);
```

This class includes the following methods:
------------------------------------------

Use the `getBalance()` method to request your balance status
```java
Balance balance = client.getBalance();

String amount = balance.getAmount();     // Getting amount of money
String currency = balance.getCurrency(); // Getting name of currency
```

To get a list of all the contact databases you have use the function `getPhoneBases()`
```java
List<PhoneBase> bases = client.getPhoneBases();

for (PhoneBase item : bases) {
    item.getBaseId();                                                // Getting list ID
    item.getTitle();                                                 // Getting list name
    item.getCount();                                                 // Getting number of contacts in list
    item.getPages();                                                 // Getting number of pages in list

    BirthdayGreetingSettings s = item.getBirthdayGreetingSettings(); // Getting settings of birthday greetings
    s.getEnabled();                                                  // Getting key that is responsible for sending greetings, 0 - do not send, 1 - send
    s.getDaysBefore();                                               // Getting the number of days to send greetings before
    s.getOriginator();                                               // Getting name of sender for greeting SMS
    s.getTimeToSend();                                               // Getting time for sending greetings. All SMS will be sent at this time.
    s.getUseLocalTime();                                             // Getting variable that indicates using of local time while SMS sending.
    s.getTemplate();                                                 // Getting text template that will be used in the messages.
}
```

Our gateway supports the option of having unlimited sender’s names. To see a list of all senders’ names use the method `getOriginators()`
```java
List<Originator> bases = client.getOriginators();

for (Originator item : bases) {
    item.getOriginator();      // Getting sender name
    item.getState();           // Getting sender status
}
```
To get a list of phone numbers from a certain contact list you need the `getPhoneBaseItems(baseId, page)` method. For your convenience, the entire list is split into separate pages.
The parameters are: `baseId` - the ID of a particular database (mandator), and `page` - a page number in a particular database (optional).
```java
List<PhoneBaseItem> bases = client.getPhoneBaseItems(baseId, page);

for (PhoneBaseItem item : bases) {
    item.getPhone();               // Getting subscriber number
    item.getFirstName();           // Getting subscriber first name
    item.getMiddleName();          // Getting subscriber middle name
    item.getLastName();            // Getting subscriber last name
    item.getBirthDay();            // Getting subscriber birthday
    item.getGender();              // Getting gender of subscriber
    item.getNetwork();             // Getting operator of subscriber
    item.getArea();                // Getting region of subscriber
    item.getNote1();               // Getting subscriber note 1
    item.getNote2();               // Getting subscriber note 2
}
```

To receive status info for an SMS you have already sent, use the function `getDeliveryStatus(messageId)` where `messageId` - is an array of sent message IDs.
```java
List<DeliveryStatus> bases = client.getDeliveryStatus(messages);

for (DeliveryStatus item : bases) {
    item.getMessageId();           // Getting message ID
    item.getMessageStatus();       // Getting a message status
    item.getCreatedAt();           // Getting a time of message
}
```

To send a message (to one or several recipients), use the function `sendMessage(phone, originator, text)`,
where `phone` - is a set of numbers you send your messages to,
`originator` is a sender’s name and `text` stands for the content of the message and
sendingTime - Example: 2014-05-30 14:06 (an optional parameter, it is used when it is necessary to schedule SMS messages).
An array includes `MessageSendingSuccess` if the message was successfully sent or `MessageSendingError` in case of failure.
```java
List<MessageSendingResult> bases = client.sendMessage(phone, originator, text);

for (MessageSendingResult item : bases) {
    if(item.isOk()) {                      // А flag of successful dispatch of a message
        item.getPhone();                   // Getting phone number
        item.getMessageId();               // Getting message ID
        item.getCost();                    // Getting price for message
        item.getCurrency();                // Getting name of currency
        item.getMessagesCount();           // Getting number of message parts
    }
    else{
        item.getPhone();                   // Getting phone number
        item.getMessage();                 // Getting error message
        item.getCode();                    // Getting code error in SMS sending
    }
}
```

To add a number to a stoplist run `addToStopList(phone)` where `phone` is an individual phone number
```java
Long id = client.addToStopList(phone); // return ID in stop list
```

To check if a particular phone number is listed within a stop list use the function `checkStopList(phone)`, where `phone` is an individual phone number.
```java
StopList check = client.checkStopList(phone);

check.getId();          // Getting ID in stop list
check.getDescription(); // Getting reason of adding to stop list
check.getTimeAddedAt(); // Getting time of adding to stop list
```

Our gateway supports the option of creating multiple templates of SMS messages. To get a list of templates use the function `getTemplates()`.
As a response you will get a list of all the messages that a certain login has set up.
```java
List<Template> templates = client.getTemplates();
for (Template item : templates) {
    item.getId();                 // Getting template ID
    item.getTitle();              // Getting template name
    item.getTemplate();           // Getting text of template
    item.getCreatedAt();          // Getting the date and time when a particular template was created
}
```

To add a new template to a system run the function `addTemplate(title, template)` where `title` is a name of a template, and `template` is the text content of a template
```java
Long id = client.addTemplate(title, text); // return ID user template
```

To Edit a template to a system run the function `editTemplate(title, template)` where `title` is a name of a template, and `template` is the text content of a template
```java
var template = client.editTemplate(title, text); // return ID user template
```

To get stats about messages you have sent during a particular month use the function `getDailyStatsByMonth(year, month)` where `year` and `month` - are the particular date you need statistics for.
```java
List<DailyStats> bases = client.getDailyStatsByMonth(year, month);

for (DailyStats item : bases) {
    item.getDay();                       // Getting day of month

    List<Stats> stats = item.getStats(); // Getting daily statistics
    for(Stats entry: stats){
        entry.getState();                // Getting status of message
        entry.getCost();                 // Getting prices of message
        entry.getCurrency();             // Getting name of currency
        entry.getCount();                // Getting number of message parts
    }
}
```

HLR (Home Location Register) - is the centralised databas that provides detailed information regarding the GSM mobile network of every mobile user.
HLR requests let you check the availability of a single phone number or a list of numbers for further clean up of unavailable numbers from a contact list.
To perform an HLR request, our system supports the function `makeHLRRequest(phone)` where `phone` is the array of phone numbers.
```java
List<HLRResponse> bases = client.makeHlrRequest(phones);

for (HLRResponse item : bases) {
    item.getId();                    // Getting ID
    item.getDestination();           // Getting recipient
    item.getIMSI();                  // Getting IMSI
    item.getMCC();                   // Getting MCC of subscriber
    item.getMNC();                   // Getting MNC of subscriber
    item.getOriginalCountryName();   // Getting the original name of the subscriber's country
    item.getOriginalCountryCode();   // Getting the original code of the subscriber's country
    item.getOriginalNetworkName();   // Getting the original name of the subscriber's operator
    item.getOriginalNetworkPrefix(); // Getting the original prefix of the subscriber's operator
    item.getPortedCountryName();     // Getting name of country if subscriber's phone number is ported
    item.getPortedCountryPrefix();   // Getting prefix of country if subscriber's phone number is ported
    item.getPortedNetworkName();     // Getting name of operator if subscriber's phone number is ported
    item.getPortedNetworkPrefix();   // Getting prefix of operator if subscriber's phone number is ported
    item.getRoamingCountryName();    // Getting name of country if the subscriber is in roaming
    item.getRoamingCountryPrefix();  // Getting prefix of country if the subscriber is in roaming
    item.getRoamingNetworkName();    // Getting name of operator if the subscriber is in roaming
    item.getRoamingNetworkPrefix();  // Getting prefix of operator if the subscriber is in roaming
    item.getStatus();                // Getting status of subscriber
    item.getPricePerMessage();       // Getting price for message
    item.isInRoaming();              // Determining if the subscriber is in roaming
    item.isPorted();                 // Identification of ported number
}
```

Besides, you can can get HLR requests statistics regarding a certain time range. To do that,  use the function `getHlrStats(from, to)` where `from` and `to` are the beginning and end of a time period.
```java
List<HLRStatItem> bases = client.getHlrStats(from, to);

for (HLRResponse item : bases) {
        item.getId();                    // Getting ID
        item.getPhone();                 // Getting phone number
        item.getMessageId();             // Getting message ID
        item.getTotalPrice();            // Getting final price of request
        item.getDestination();           // Getting recipient
        item.getIMSI();                  // Getting IMSI
        item.getMCC();                   // Getting MCC of subscriber
        item.getMNC();                   // Getting MNC of subscriber
        item.getOriginalCountryName();   // Getting the original name of the subscriber's country
        item.getOriginalCountryCode();   // Getting the original code of the subscriber's country
        item.getOriginalNetworkName();   // Getting the original name of the subscriber's operator
        item.getOriginalNetworkPrefix(); // Getting the original prefix of the subscriber's operator
        item.getPortedCountryName();     // Getting name of country if subscriber's phone number is ported
        item.getPortedCountryPrefix();   // Getting prefix of country if subscriber's phone number is ported
        item.getPortedNetworkName();     // Getting name of operator if subscriber's phone number is ported
        item.getPortedNetworkPrefix();   // Getting prefix of operator if subscriber's phone number is ported
        item.getRoamingCountryName();    // Getting name of country if the subscriber is in roaming
        item.getRoamingCountryPrefix();  // Getting prefix of country if the subscriber is in roaming
        item.getRoamingNetworkName();    // Getting name of operator if the subscriber is in roaming
        item.getRoamingNetworkPrefix();  // Getting prefix of operator if the subscriber is in roaming
        item.getStatus();                // Getting status of subscriber
        item.getPricePerMessage();       // Getting price for message
        item.isInRoaming();              // Determining if the subscriber is in roaming
        item.isPorted();                 // Identification of ported number
        item.getRequestId();             // Getting request ID
        item.getRequestTime();           // Getting time of request
    }
```

To get information regarding which mobile network a certain phone number belongs to, use the function `getNetworkByPhone(phone)`, where `phone` is a phone number.
```java
Network network = client.getNetworkByPhone(phone);

network.getTitle(); // Getting operator of subscriber
```

Please bear in mind that this method has less accuracy than HLR requests as it uses our internal database to check which mobile operator a phone numbers belongs to.

To get a list of incoming messages please use the function `getIncomingMessages(date)`, where `date` stands for a particular day in YYYY-mm-dd format.
Or use the function `getIncomingMessages(from, to)`, where 
from - date of start in the format YYYY-MM-DD HH:II:SS (Example: 2014-05-01 14:06:00) and
to - date of end in the format YYYY-MM-DD HH:II:SS (Example: 2014-05-30 23:59:59)
```java
List<IncomingMessage> messages = client.getIncomingMessages(data);

for (IncomingMessage item : messages) {
    item.getMessageId();                // Getting message ID
    item.getOriginator();               // Getting sender name of the incoming message
    item.getPrefix();                   // Getting prefix of the incoming message
    item.getReceivedAt();               // Getting date of the incoming message
    item.getText();                     // Getting text of the incoming message
}
```
