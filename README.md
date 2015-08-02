Intis-Telecom-SDK-PHP
=====================

Installation using Composer
---------------------------

$ composer require intis/sdk

Usage
---------------------------

class IntisClient - The main class for SMS sending and getting API information

Для инициализации необходимо передать в конструктор три обязательных параметра
$login - user login
$apiKey - user API key
$apiHost - API address

```php
<?php

require __DIR__ . '/vendor/autoload.php';

use Intis\SDK\IntisClient;

$client = new IntisClient($login, $apiKey, $apiHost);
```

Класс содержит следующие методы:
--------------------------------

Getting user balance
`$client->getBalance()`

Getting all user lists `getPhoneBases()`
```php
$balance = $client->getBalance();

$amount = $balance->getAmount();
$currency = $balance->getCurrency();
```

Getting all user sender names
`$client->getOriginators()`

Getting subscribers of list
`$client->getPhoneBaseItems($baseId, $page)` $baseId - List ID (обязательный параметр), $page - Page of list (необязательный параметр)

Getting message status
`$client->getDeliveryStatus($messageId)` $messageId - Message ID

SMS sending
`$client->sendMessage($phone, $originator, $text)`  $phone - phone number(s) (array|string), $originator - sender name, $text sms text

Testing phone number for stop list
`$client->checkStopList($phone)` $phone - phone number

Adding number to stop list
`$client->addToStopList($phone)` $phone - phone number

Getting user templates
`$client->getTemplates()`

Adding user template
`$client->addTemplate($title, $template)` $title - template name, $template - text of template

Getting statistics for the certain month
`$client->getDailyStatsByMonth($year, $month)` $year - year, $month - month (format date YYYY-mm-dd)

Sending HLR request for number
`$client->makeHLRRequest($phone)` $phone - phone number

Getting statuses of HLR request
`$client->getHlrStats($from, $to)` $from - дата начала периода, $to - дата конца периода

Getting the operator of subscriber phone number
`$client->getNetworkByPhone($phone)` $phone - phone number

Getting incoming messages of certain date
`$client->getIncomingMessages($date)` $date - date (format date YYYY-mm-dd)