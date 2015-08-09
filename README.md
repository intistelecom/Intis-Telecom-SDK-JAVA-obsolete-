Intis-Telecom-SDK-JAVA
=====================

Компания Интис Телеком позволяет отправлять СМС по всему миру, используя API. Он основан на отправке HTTP(s) запросов и получения ответной информации в JSON или XML. Основной функционал, поддерживаемый API:

* отправка СМС, в том числе, в назначенное время
* получение отчета о доставке ранее отправленной СМС
* запрос списка разрешенных отправителей
* запрос списка входящих СМС
* запрос баланса
* запрос списка баз
* запрос номеров из базы
* поиск номера в стоп-листе
* добавление номера в стоп-лист
* запрос списка шаблонов
* добавление шаблона
* общая статистика за месяц
* HLR запрос
* статистика HLR запросов
* запрос оператора по номеру телефона

Для начала работы с сервисом, Вам необходимо зарегестрироваться на сайте https://go.intistele.com/external/client/register/. Получить login и API ключ


Usage
---------------------------

class IntisClient - The main class for SMS sending and getting API information

Для инициализации необходимо передать в конструктор три обязательных параметра
login - user login
apiKey - user API key
apiHost - API address

```java

import com.intis.sdk.IntisClient;

IntisClient client = new IntisClient(login, apiKey, apiHost);
```

Класс содержит следующие методы:
--------------------------------

Для запроса баланса Вашего лицевого счета в сервисе используется метод `getBalance()`
```java
Balance balance = client.getBalance();

String amount = balance.getAmount(); // Getting amount of money
String currency = balance.getCurrency(); // Getting name of currency
```

Запросить список всех имеющихся в Вашей системе телефонных баз `getPhoneBases()`
```java
List<PhoneBase> bases = client.getPhoneBases();

for (PhoneBase item : bases) {
    item.getBaseId(); // Getting list ID
    item.getTitle(); // Getting list name
    item.getCount(); // Getting number of contacts in list
    item.getPages(); // Getting number of pages in list

    BirthdayGreetingSettings s = item.getBirthdayGreetingSettings(); // Getting settings of birthday greetings
    s.getEnabled(); // Getting key that is responsible for sending greetings, 0 - do not send, 1 - send
    s.getDaysBefore(); // Getting the number of days to send greetings before
    s.getOriginator(); // Getting name of sender for greeting SMS
    s.getTimeToSend(); // Getting time for sending greetings. All SMS will be sent at this time.
    s.getUseLocalTime(); // Getting variable that indicates using of local time while SMS sending.
    s.getTemplate(); // Getting text template that will be used in the messages.
}
```

В системе предусмотрена возможность создать неограниченное количество имен отправителей СМС.
Для получения списка отправителей используется метод `getOriginators()`
```java
List<Originator> bases = client.getOriginators();

for (Originator item : bases) {
    item.getOriginator(); // Getting sender name
    item.getState(); // Getting sender status
}
```

Для получения списка номеров телефонов из определенной базы абонентов в личном кабинете используется метод `getPhoneBaseItems(baseId, page)`. Для удобства весь список разбит на страницы.
Параметры: baseId - ID телефонной базы в системе (обязательный параметр), page - Номер страницы в базе (необязательный параметр)
```java
List<PhoneBaseItem> bases = client.getPhoneBaseItems(baseId, page);

for (PhoneBaseItem item : bases) {
    item.getPhone(); // Getting subscriber number
    item.getFirstName(); // Getting subscriber first name
    item.getMiddleName(); // Getting subscriber middle name
    item.getLastName(); // Getting subscriber last name
    item.getBirthDay(); // Getting subscriber birthday
    item.getGender(); // Getting gender of subscriber
    item.getNetwork(); // Getting operator of subscriber
    item.getArea(); // Getting region of subscriber
    item.getNote1(); // Getting subscriber note 1
    item.getNote2(); // Getting subscriber note 2
}
```

Для получения информации по статусам отправленных СМС используется функция `getDeliveryStatus(messageId)` messageId - массив ID отправленных сообщений.
```java
List<DeliveryStatus> bases = client.getDeliveryStatus(messages);

for (DeliveryStatus item : bases) {
    item.getMessageId(); // Getting message ID
    item.getMessageStatus(); // Getting a message status
    item.getCreatedAt(); // Getting a time of message
}
```

Для отправки СМС (в том числе и нескольким абонентам) используется функция `sendMessage(phone, originator, text)`
phone - номер телефона на который необходимо отправить сообщение. Где phone - массив телефонных номеров,
originator - имя отправителя от имени которого идет рассылка, text - текст смс.
Массив содержит `MessageSendingSuccess` если сообщение успешно отправлено или `MessageSendingError` если возникла ошибка
```java
List<MessageSendingResult> bases = client.sendMessage(phone, originator, text);

for (MessageSendingResult item : bases) {
    if(item.isOk()) { // флаг успешной отправки сообщения
        item.getPhone(); // Getting phone number
        item.getMessageId(); // Getting message ID
        item.getCost(); // Getting price for message
        item.getCurrency(); // Getting name of currency
        item.getMessagesCount(); // Getting number of message parts
    }
    else{
        item.getPhone(); // Getting phone number
        item.getMessage(); // Getting error message
        item.getCode(); // Getting code error in SMS sending
    }

}
```

Добавить номер в СТОП-лист `addToStopList(phone)` phone - phone number
```java
Long id = client.addToStopList(phone); // return ID in stop list
```

Для проверки наличия телефонного номера в СТОП-листе необходимо воспользоваться функцией `checkStopList(phone)`. Где phone - phone number
```java
StopList check = client.checkStopList(phone);

check.getId(); // Getting ID in stop list
check.getDescription(); // Getting reason of adding to stop list
check.getTimeAddedAt(); // Getting time of adding to stop list
```

В системе предусмотрена возможность создания множества шаблонов СМС сообщений. Для получения списка таких шаблонов используется функция `getTemplates()`.
В ответ возвращается список всех имеющихся в данной учетной записи шаблонов.
```java
List<Template> templates = client.getTemplates();
for (Template item : templates) {
    item.getId(); // Getting template ID
    item.getTitle(); // Getting template name
    item.getTemplate(); // Getting text of template
    item.getCreatedAt(); // Получение времени создания шаблона
}
```

Для добавления нового шаблона в систему используется функция `addTemplate(title, template)`. Где title - template name, template - text of template
```java
Long id = client.addTemplate(title, text); // return ID user template
```

Для получения статистики отправки сообщения за определенный месяц используется функция `getDailyStatsByMonth(year, month)`.
Где year - год и month - месяц за который необходимо получить статистику.
```java
List<DailyStats> bases = client.getDailyStatsByMonth(year, month);

for (DailyStats item : bases) {
    item.getDay(); // Getting day of month

    List<Stats> stats = item.getStats(); // Getting daily statistics
    for(Stats entry: stats){
        entry.getState(); // Getting status of message
        entry.getCost(); // Getting prices of message
        entry.getCurrency(); // Getting name of currency
        entry.getCount(); // Getting number of message parts
    }
}
```

HLR (Home Location Register) — это централизованная база данных, которая содержит подробную информацию о каждом абоненте мобильных сетей GSM-операторов.
HLR запрос позволяет выполнить проверку телефонных номеров (в том числе и списком), определяя доступность абонентов для дальнейшей очистки базы данных от неактуальных номеров.
Для осуществления HLR запроса в системе предусмотрена функция `makeHLRRequest(phone)`.
Где phone - массив телефонов.
```java
List<HLRResponse> bases = client.makeHlrRequest(phones);

for (HLRResponse item : bases) {
    item.getId(); // Getting ID
    item.getDestination(); // Getting recipient
    item.getIMSI(); // Getting IMSI
    item.getMCC(); // Getting MCC of subscriber
    item.getMNC(); // Getting MNC of subscriber
    item.getOriginalCountryName(); // Getting the original name of the subscriber's country
    item.getOriginalCountryCode(); // Getting the original code of the subscriber's country
    item.getOriginalNetworkName(); // Getting the original name of the subscriber's operator
    item.getOriginalNetworkPrefix(); // Getting the original prefix of the subscriber's operator
    item.getPortedCountryName(); // Getting name of country if subscriber's phone number is ported
    item.getPortedCountryPrefix(); // Getting prefix of country if subscriber's phone number is ported
    item.getPortedNetworkName(); // Getting name of operator if subscriber's phone number is ported
    item.getPortedNetworkPrefix(); // Getting prefix of operator if subscriber's phone number is ported
    item.getRoamingCountryName(); // Getting name of country if the subscriber is in roaming
    item.getRoamingCountryPrefix(); // Getting prefix of country if the subscriber is in roaming
    item.getRoamingNetworkName(); // Getting name of operator if the subscriber is in roaming
    item.getRoamingNetworkPrefix(); // Getting prefix of operator if the subscriber is in roaming
    item.getStatus(); // Getting status of subscriber
    item.getPricePerMessage(); // Getting price for message
    item.isInRoaming(); // Determining if the subscriber is in roaming
    item.isPorted(); // Identification of ported number
}
```

Кроме того, возможно получить статистику HLR запросов за определенный период времени `getHlrStats(from, to)`.
Где from - дата начала периода, to - дата конца периода
```java
List<HLRStatItem> bases = client.getHlrStats(from, to);

for (HLRResponse item : bases) {
        item.getId(); // Getting ID
        item.getPhone(); // Getting phone number
        item.getMessageId(); // Getting message ID
        item.getTotalPrice(); // Getting final price of request
        item.getDestination(); // Getting recipient
        item.getIMSI(); // Getting IMSI
        item.getMCC(); // Getting MCC of subscriber
        item.getMNC(); // Getting MNC of subscriber
        item.getOriginalCountryName(); // Getting the original name of the subscriber's country
        item.getOriginalCountryCode(); // Getting the original code of the subscriber's country
        item.getOriginalNetworkName(); // Getting the original name of the subscriber's operator
        item.getOriginalNetworkPrefix(); // Getting the original prefix of the subscriber's operator
        item.getPortedCountryName(); // Getting name of country if subscriber's phone number is ported
        item.getPortedCountryPrefix(); // Getting prefix of country if subscriber's phone number is ported
        item.getPortedNetworkName(); // Getting name of operator if subscriber's phone number is ported
        item.getPortedNetworkPrefix(); // Getting prefix of operator if subscriber's phone number is ported
        item.getRoamingCountryName(); // Getting name of country if the subscriber is in roaming
        item.getRoamingCountryPrefix(); // Getting prefix of country if the subscriber is in roaming
        item.getRoamingNetworkName(); // Getting name of operator if the subscriber is in roaming
        item.getRoamingNetworkPrefix(); // Getting prefix of operator if the subscriber is in roaming
        item.getStatus(); // Getting status of subscriber
        item.getPricePerMessage(); // Getting price for message
        item.isInRoaming(); // Determining if the subscriber is in roaming
        item.isPorted(); // Identification of ported number
        item.getRequestId(); // Getting request ID
        item.getRequestTime(); // Getting time of request
    }
```

Для получения информации о пренадлежности определенного номера какому-либо оператору используется функция `getNetworkByPhone(phone)`. Где phone - номер телефона
```java
Network network = client.getNetworkByPhone(phone);

network.getTitle(); // Getting operator of subscriber
```
Следует отметить, что данный метод является менее точным, чем HLR запрос, т.к. использует внутреннюю базу данных компании Интис Телеком о пренадлежности абонентов определенному оператору.

Для получения списка входящих сообщений необходимо воспользоваться функцией `getIncomingMessages(date)`. Где date - интересующая Вас дата (format date YYYY-mm-dd)
```java
List<IncomingMessage> messages = client.getIncomingMessages(data);

for (IncomingMessage item : messages) {
    item.getMessageId(); // Getting message ID
    item.getOriginator(); // Getting sender name of the incoming message
    item.getPrefix(); // Getting prefix of the incoming message
    item.getReceivedAt(); // Getting date of the incoming message
    item.getText(); // Getting text of the incoming message
}
```