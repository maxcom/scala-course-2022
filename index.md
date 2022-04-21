---
# Feel free to add content and custom Front Matter to this file.
# To modify the layout, see https://jekyllrb.com/docs/themes/#overriding-theme-defaults

layout: default
---

# Курс программирования на языке Scala

Темы курса:

* Основы функционального программирования. Разберем принципы работы с неизменяемыми и персистентными структурами данных и устройство этих структур. Принципы моделирования данных - case-классы, алгебраические типы и pattern matching.
* Рассмотрим более сложные техники функционального программирования: ленивые вычисления; часто используемые абстракции, такие как функтор, аппликатив и монада.
* Научим использовать неявные значения и преобразования - будем создавать тайпклассы, а потом рассмотрим другие применения этого механизма. В качестве примера поговорим о том, как работать с JSON и как обрабатывать ошибки парсинга.
* Расскажем о многопоточности - сначала разберем инструменты, которые нам дает виртуальная машина Java. Потом перейдем к высокоуровневым примитивам - поговорим о разных подходах к написанию конкурентного и параллельного кода. Подробно рассмотрим устройство Future/Promise, а потом перейдем к акторам Akka.
* Изучим базовые примитивы функционального программирования из библиотеки Cats. Многопоточность и управление эффектами Cats Effect.
* Расскажем об устройстве ввода вывода, о том, как построены асинхронные клиенты к веб-сервисам и базам данных, и о том, как совмещать ввод-вывод и асинхронный код.
* Расскажем о том, как организовывать асинхронную обработку потоков данных на примере библиотеки Akka Streams.
* Покажем как разрабатывать веб-сервисы с использованием Akka HTTP 

Курс будет состоять из лекций, семинаров и домашних заданий. На семинаре будем совместно решать задачи по пройденной на лекции теме.

# Лекции

0. Орг вопросы. 
  * Семинар: 3 марта
  * Семинар: Орг вопросы. Проверяем звук в Discord. Проверка IDEA Code With Me (ведущий - Максим)
  * Видео: [Ставим JDK и Intellij IDEA](https://www.youtube.com/watch?v=Z6Dgqc3EdXc)
1. Введение в Scala. Case классы и pattern matching. 
  * Лекция: 9 марта. Семинар 16 марта.
  * Видео: [Часть 1. Введение в Scala](https://www.youtube.com/watch?v=HBvd9PjYBcs)
  * Видео: [Часть 2. Case-классы и pattern matching](https://www.youtube.com/watch?v=qF_ARyjz1oU)
  * Видео: [Домашнее задание](https://youtu.be/6h3c6FY6Q9w)
  * Слайды: [Введение в Scala. Case классы и pattern matching](slides/day1.html).
  * Слайды домашнего задания: [Часть 1. Домашнее задание](slides/day1-task.html).
  * Семинар: Создаем первый проект. Юнит тесты на Specs2 и ScalaCheck. (ведущий - Саша)
  * Семинар: [Стартовый проект и слайды](https://gitlab.com/djattah/lesson1). Сохраненная копия: [https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson1](https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson1)
2. Иммутабельность и базовые структуры данных. Работа со списками. 
  * Лекция: 16 марта. Семинар: 23 марта.
  * Видео: [Работа со списками](https://www.youtube.com/watch?v=zxYTkN55bUk)
  * Видео: [Домашнее задание](https://www.youtube.com/watch?v=OOVnWazLM9c)
  * Слайды: [Работа со списками](slides/day2.html)
  * Слайды домашнего задания: [Часть 2. Домашнее задание](slides/day2-task.html).
  * Семинар: Измеряем скорость операций над коллекциями при помощи JMH. (ведущий - Никита)
  * Семинар: [Стартовый проект и README](https://gitlab.com/StyopinN/scala-course-2022-lesson2). Сохраненная копия: [https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson2](https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson2)
3. Vector. Ленивые вычисления. LazyList и View. Монады. 
  * Лекция: 23 марта. Семинар: 30 марта.
  * Видео: [Часть 1. Vector, Map и View](https://www.youtube.com/watch?v=e-2Td91B7gw).
  * Видео: [Часть 2. Ленивые вычисления и монады](https://youtu.be/PYvtV4AapgM).
  * Слайды: [Vector. Ленивые вычисления. LazyList и View. Монады.](slides/day3.html)
  * Семинар: Решаем задачи с использованием LazyList. (ведущий - Роман)
  * Семинар: [Стартовый проект](https://gitlab.com/llgruff/solar-seminar-lazylist). Сохраненная копия: [https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson3](https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson3)
4. Implicit значения и преобразования. Тайпклассы. Чтение и запись JSON в play-json. 
  * Лекция: 30 марта. Семинар: 6 апреля.
  * Видео: [Часть 1. Implicit значения и преобразования. Тайпклассы.](https://www.youtube.com/watch?v=pagteHi4pp8)
  * Видео: [Часть 2. Тайпклассы и работа с JSON. Обзор play-json](https://www.youtube.com/watch?v=_IBWPKVZ6ug)
  * Видео: [Стартуем большой проект](https://youtu.be/IWcX4ke4G4w) (домашнее задание)
  * Слайды: [Implicit значения и преобразования. Тайпклассы. Чтение и запись JSON в play-json](slides/day4.html)
  * Семинар: Практика по использованию play-json. (ведущие - Саша и Наташа)
  * Семинар: [Стартовый проект](https://gitlab.com/djattah/lessonjson). Сохраненная копия: [https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson4](https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson4)
  * Слайды домашнего задания: [Пишем классификатор](slides/classifier-1.html)
5. Базовые примитивы многопоточности. 
  * Лекция: 6 апреля. Семинар: 13 апреля.
  * Видео: [Введение в многопоточное и асинхронное программирование.](https://www.youtube.com/watch?v=BQ0KxwA1HFM)
  * Видео: [Future и Promise](https://youtu.be/OTq-S78RbTk)
  * Слайды: [Базовые примитивы многопоточности](slides/day5.html)
  * Семинар: Практика по использованию Future/Promise. Планировщик. (ведущий - Роман)
  * Семинар: [Стартовый проект](https://gitlab.com/llgruff/solar-seminar-future). Сохраненная копия: [https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson5](https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson5) 
6. Cats и Circe. 
  * Лекция: 13 апреля. Семинар: 21 апреля (*Внимание!* семинар перенесен на четверг!).
  * Видео: [Cats и Circe.](https://youtu.be/XxEwkF-RKcE)
  * Видео: [Классификатор часть 2](https://youtu.be/ChCGzx8Xxi8) (домашнее задание).
  * Слайды: [Cats и Circe](slides/day6.html)
  * Семинар: Практика по извлечению данных JSON/HTML и валидации. (ведущий - Никита)
  * Семинар: [Стартовый проект](https://gitlab.com/StyopinN/scala-course-2022-lesson6). Сохраненная копия: [https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson6](https://github.com/maxcom/scala-course-2022/tree/gh-pages/seminar/lesson6) 
  * Слайды домашнего задания: [Классификатор: морфология и диагностика](slides/classifier-2.html)
7. Архитектура обработки запросов. HTTP Протокол. REST и Akka HTTP.
  * Лекция: 20 апреля. Семинар: 27 апреля.
  * Видео: [Часть 1. Архитектура обработки запросов. Протокол HTTP.](https://youtu.be/QnqPX2cRdWA)
  * Видео (в работе): REST и Akka HTTP.
  * Слайды: [Часть 1. Архитектура обработки запросов. Протокол HTTP.](slides/day7-part1.html)
  * Слайды (в работе): [Часть 2. REST и Akka HTTP.](slides/day7-part2.html)
  * Слайды домашнего задания (в работе): Сервис классификации.
  * Семинар: Практика по Akka Http.
8. Акторы Akka, часть 1.
  * Лекция: 27 апреля. Семинар: 4 мая.
  * Семинар: Практика использования акторов Akka.
9. Акторы Akka, часть 2.
  * Лекция: 4 мая. Семинар: 11 мая.
  * Семинар: Akka Patterns.
10. Akka Streams и реактивные потоки.
  * Лекция: 11 мая. Семинар: 18 мая.
  * Семинар: Akka Streams.
11. Cats Effect и Http4s.
  * Лекция: 18 мая. Семинар: 25 мая.
  * Семинар: Практика по Cats Effect.
12. Подведение итогов.
  * Семинар: 1 июня.

# Материалы для большого практического задания

Начинаем после 3-й лекции.

* Денис Баженов: [Наивный байесовский классификатор](http://bazhenov.me/blog/2012/06/11/naive-bayes.html) ([сохраненная копия сайта](https://github.com/maxcom/bazhenov.github.com))
* [Корпус коротких текстов для настройки классификатора](http://study.mokoron.com/). При использовании корпуса, просьба ссылаться на 
  следующую работу: [Автоматическое построение и анализ корпуса коротких текстов (постов микроблогов) для задачи разработки и тренировки тонового классификатора](https://elibrary.ru/item.asp?id=20399632)

# Предыдущие курсы

* [Курс программирования на языке Scala, 2020](https://maxcom.github.io/scala-course-2020/)
  * Видео: [Плейлист на YouTube](https://youtube.com/playlist?list=PLr3MOSSJVvAFDW8sY3qbowgMa-eFplLcG) 
* [Scala-лазание, 2018](https://maxcom.github.io/scala-course-2018/)
  * Видео: [Плейлист на YouTube](https://youtube.com/playlist?list=PLr3MOSSJVvAF55813OARE-338kx7w-Ebl)
