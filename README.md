[![Build Status](https://travis-ci.org/MorozoffM4x/gitlab1.svg?branch=main)](https://travis-ci.org/MorozoffM4x/gitlab1)
# Технология разработки программного обеспечения
# Лабораторная работа №1: создание микросервиса на Spring Boot с базой данных
## Морозов Максим Евгеньевич, Группа 3МБД2001
## Цель лабораторной работы: 
Целью лабораторной работы является знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).

Приложение представляет из себя микросервис, реализующий CRUD на примере системы спортивного электронного хронометража для любительских велозаездов на дальние и сверх-дальние расстояния.
Для работы приложения требуется запущенная база данных PostgreSQL. 
#### Подготовка и настройка сервера баз данных  
Для установки и запуска postgresql с помощью docker надо выполнить комманды <code>docker pull postgres</code> для скачивания и <code>docker run -e POSTGRES_PASSWORD=root -p 5432:5432 postgres</code> для запуска.
В файле <code>./src/main/resources/application.properties</code> указываются настройки подключения к базе данных и учётные данные:
  * в параметре <code>spring.datasource.username = </code> надо указать имя пользователя для доступа к базе данных (postgres).
  * в параметре <code>spring.datasource.password = </code> пароль для доступа к базе данных (root). 
  * В параметре <code>spring.datasource.url = </code> необходимо указать адрес для доступа к базе данных, например для доступа к базе данных запущенной на локальном компьютере значение будет <code>jdbc:postgresql://localhost:5432/postgres</code>, для базы данных запущенной в docker на локальной машине IP адрес требуется изменить.   

Настройка базы данных осуществляется с помощью файла <code>./src/main/resources/schema.sql</code>. Для этого необходимо выполнить команду <code>psql -h <адрес_БД> -p <порт_БД> -U <имя_пользователя> -d public -f "schema.sql"</code> .  
Тестовые данные для БД находятся в <code> ./src/main/resources/data.sql </code> . Для этого необходимо выполнить команду <code>psql -h <адрес_БД> -p <порт_БД> -U <имя_пользователя> -d public -f "data.sql"</code>.    
#### Клонирование репозитария и сборка проекта с помощью Maven
Для клонирования репозитория надо выполнить команду <code>git clone https://github.com/MorozoffM4x/gitlab1.git</code>.
Для запуска сборки из консоли потребуется установка Maven и настройка операционной системы.
Сборка приложения осуществляется при помощи автоматической системы сборки проектов Maven. Для сборки необходимо выполнить команду  <code>mvn package -Dmaven.test.skip=true</code>(с пропуском тестирования) находясь в директории проекта. После окончания выполнения команды появится папка <code>target</code> в которой находится скомпилированный код и файл <code>simpleapi-1.0.jar</code>.
#### Сборка и запуск Docker-образа 
Для сборки Docker образа следует выполнить команду <code> docker build -t simpleapi:latest . </code> находясь в директории с <code>Dockerfile</code> и собранным <code>simpleapi-1.0.jar</code> .  
Запуск осуществляется командой <code>docker run -p 8080:8080 simpleapi:v1 </code>, в формате {порт внешний}:{порт в Docker}.  
#### Примеры запросов к simpleapi. 
Формат JSON:
<code>{fname: "string", lname: "string", date: "date", event: "string", distance: integer, time: time}</code>

##### Получить список всех результатов: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/results</code>
В ответ будет получен JSON со всеми записями. 
##### Получить запись по id: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/results/{id}</code> 
В ответ будет получен JSON с результатом. 
##### Добавить запись: 
<code>curl -X POST http://127.0.0.1:8080/api/v1/results -d ‘{"fname": "Максим", "lname": "Морозов", "date": "2020-06-13", "event": "Краски осени", "distance": 400, "time": "19:30:00"}’ -H «Content-Type:application/json»</code>
В ответ будет получен статус <code>200 ОК</code>.
##### Удалить запись: 
<code>curl -X POST http://127.0.0.1:8080/api/v1/results/{id}</code>
В ответ будет получен статус <code>204 No Content</code>.
##### Также приложение возвращает значение hostname: 
<code>curl -X GET http://127.0.0.1:8080/api/v1/status</code>
В ответ будет получен JSON в виде <code>{hostname: "hostname"}</code>. 

# Лабораторная работа №3: CI/CD и деплой приложения в Heroku
# Цель работы: 
## Целью лабораторной работы является знакомство с CI/CD и его реализацией на примере Travis CI и Heroku.

## Ссылка на развернутое приложение: 
[Ссылка на развернутое приложение](https://morozoff-lab1.herokuapp.com/api/v1/status "Ссылка на развернутое приложение")
