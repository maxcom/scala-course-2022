
# Семинар 11: Cats Effect и Http4s

<hr>

## Перед началом 
Рассказать про ошибку в лекции:
```
Future тоже стекобезопасен
Это вот Option например не безопасен
У Future каждый flatMap это свой callback, который по сути тот же continuation
Стек не накапливается
Все что он утягивает в замыкании оказывается в куче
```

<hr>

## Введение

Рассказать, что через sbt-консоль есть проблема с прерыванием работы сервера:
```
To shut down your server, simply press ^C in your console.
Note that when running interactive SBT, ^C will kill the SBT process.
For rapid application development, you may wish to add the sbt-revolver plugin to your project
and starting the server from the SBT prompt with reStart.
```
Можно либо использовать плагин;
либо убивать процесс через `lsof -i :port` и `kill -9 pid`;
либо запускать в терминале, а не sbt-консоли.

Показываем как запускать пустой сервис без роутов.

Пробуем курлом отправлять запрос.
```
curl -w "\n%{http_code}\n" -X GET http://localhost:8080/       // Not Found
```

<hr>

## Часть 1: Простой сервер http4s. Пишем роуты, комбинируем их, разбиваем на группы (router)

#### Задание 1.1:
Пишем простой роут без параметров. Возвращаем "Hello".
Подключаем его к серверу с префиксом "task1".
Проверяем курлом.
```
curl -X GET http://localhost:8080/hello         //может работать в первом варианте, но не должен работать, если верно подключили с префиксом
curl -X GET http://localhost:8080/task1/hello
```

#### Задание 1.2:
Пишем роут с параметром, извлечённым из path.
```
curl -X GET http://localhost:8080/task1/hello/Nikita            // Hello, Nikita
curl -X GET http://localhost:8080/task1/hello/Nikita/Styopin    // Not Found
```

#### Задание 1.3:
Пишем роут с параметром, извлечённым из path. Кастомный тип (sealed trait Animal).
```
curl -X GET http://localhost:8080/task1/love/dog      // I love dogs
curl -X GET http://localhost:8080/task1/love/cat      // I love cats
curl -X GET http://localhost:8080/task1/love/eagle    // Not Found
```

#### Задание 2.1:
Извлекаем параметр из url-param. Single, стандартный тип (Boolean)
Подключаем его к серверу с префиксом "task2".
Проверяем курлом.
```
curl -X GET http://localhost:8080/task2/boolean?inverted=true      // true
curl -X GET http://localhost:8080/task2/boolean?inverted=false     // false
curl -X GET http://localhost:8080/task2/boolean?inverted=other     // Not found
curl -X GET http://localhost:8080/task2/boolean?inverted           // Not found
curl -X GET http://localhost:8080/task2/boolean                    // Not found
```

#### Задание 2.2:
Извлекаем параметр из url-param. Flag
```
curl -X GET http://localhost:8080/task2/flag?flag=true      // true
curl -X GET http://localhost:8080/task2/flag?flag=false     // true
curl -X GET http://localhost:8080/task2/flag?flag=other     // true
curl -X GET http://localhost:8080/task2/flag?flag           // true
curl -X GET http://localhost:8080/task2/flag                // false
```

#### Задание 2.3:
Извлекаем параметр из url-param. Single, кастомный тип (Animal)
```
curl -X GET http://localhost:8080/task2/love?animal=dog     // I love dogs
curl -X GET http://localhost:8080/task2/love?animal=cat     // I love cats
curl -X GET http://localhost:8080/task2/love?animal=eagle   // Not found
curl -X GET http://localhost:8080/task2/love?animal         // Not found
curl -X GET http://localhost:8080/task2/love                // Not found
```

#### Задание 2.4:
Извлекаем параметр из url-param. Optional, WithDefault
```
curl -X GET http://localhost:8080/task2/default-love?animal=dog     // I love dogs
curl -X GET http://localhost:8080/task2/default-love?animal=cat     // I love cats
curl -X GET http://localhost:8080/task2/default-love?animal=eagle   // Not found
curl -X GET http://localhost:8080/task2/default-love?animal         // I love dogs
curl -X GET http://localhost:8080/task2/default-love                // I love dogs
```

#### Задание 2.5:
Извлекаем параметр из url-param. Multi
```
curl -X GET 'http://localhost:8080/task2/love?animal=cat&animal=dog'               // Предыдущий запрос вернёт только первое значение
curl -X GET 'http://localhost:8080/task2/multi-love?animals=cat&animals=dog'       // I love all animals: Cat, Dog
curl -X GET 'http://localhost:8080/task2/multi-love?animals=cat'                   // I love all animals: Cat
curl -X GET 'http://localhost:8080/task2/multi-love?animals=eagle'                 // [BadRequest] incorrect animal type: found eagle
curl -X GET 'http://localhost:8080/task2/multi-love?animals=cat&animals=eagle'     // [BadRequest] incorrect animal type: found eagle
curl -X GET 'http://localhost:8080/task2/multi-love?animals=ostrich&animals=eagle' // [BadRequest] incorrect animal type: found ostrich; incorrect animal type: found eagle
```


#### Задание 3:
В ответе json из case-class с помощью кодеков circe.
```
curl -X GET http://localhost:8080/task3/user-data
```
Делаем курл с флагом `-v` и смотрим, что `Content-Type: application/json`


#### Задание 4:
Парсим тело как json в case-class с помощью кодеков circe.
```
curl -X POST http://localhost:8080/task4/signup           // Malformed message body: Invalid JSON: empty body
curl -X POST http://localhost:8080/task4/signup -d '{}'   // Invalid message body: Could not decode JSON: {}
curl -X POST http://localhost:8080/task4/signup -d '{
  "login": "mylogin",
  "password": "passW0rd"
}'                                                        // Registered: RegistrationData(mylogin,passW0rd,None,None,None)
```



<hr>

## Часть 2: IO-монады. Пробуем писать разную логику в роутах.

#### Задание 5.1:
Пишем фейковый DB-сервис с использованием Resource и IO-монад.

#### Задание 5.2:
Собираем бизнес-логику из последовательности действий (несколько IO-шек) через for
1) Находим пользователя в базе по login (получить id)
2) Проверяем пароль пользователя
3) Получаем данные о пользователе
4) Возвращаем найденные данные
В случае ошибки на том или ином этапе бизнес-логики нужно вернуть соответствующий статус ошибки и прервать действия.

```
curl -X POST http://localhost:8080/task5/business-logic           // Malformed message body: Invalid JSON: empty body
curl -X POST http://localhost:8080/task5/business-logic -d '{}'   // Invalid message body: Could not decode JSON: {}
curl -X POST http://localhost:8080/task5/business-logic -d '{
  "login": "mylogin",
  "password": "passW0rd"
}'                                                                // User login not found
curl -X POST http://localhost:8080/task5/business-logic -d '{
  "login": "superuser",
  "password": "Qwe12345"
}'                                                                // Incorrect password"
curl -X POST http://localhost:8080/task5/business-logic -d '{
  "login": "user",
  "password": "Qwe12345"
}'                                                                // Incorrect password 
```
Выясняем, почему не работает успешный кейс по id и исправляем ошибку в фейковой базе.


#### Задание 6.1:
Запрос создаёт счётчик до указанного N, который инкрементится и печатается раз в секунду.
По окончании возвращаем 201 Created.
```
curl -w "%{http_code}\n" -X PUT http://localhost:8080/task6/count/5
curl -w "%{http_code}\n" -X PUT http://localhost:8080/task6/count/-5
curl -w "%{http_code}\n" -X PUT http://localhost:8080/task6/count/0
```

#### Задание 6.2:
Тоже самое, но запускаем параллельно с таймером (10 секунд).
Если таймер закончится раньше, то счётчик должен остановиться
```
curl -w "%{http_code}\n" -X PUT http://localhost:8080/task6/count-with-timeout/5
curl -w "%{http_code}\n" -X PUT http://localhost:8080/task6/count-with-timeout/15
```

#### Задание 6.3:
Запускаем асинхронно и сразу возвращаем 201 Created.
Защиту в виде таймаута нужно сохранить.
```
curl -w "%{http_code}\n" -X PUT http://localhost:8080/task6/start-counter/5
curl -w "%{http_code}\n" -X PUT http://localhost:8080/task6/start-counter/15
```


