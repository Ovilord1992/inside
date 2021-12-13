## Для развертывания сервиса на целевой машине необходим только Docker, т.к. img содержит в себе весь инструментарий для развертывания и начала работы, без надобности установки maven или jdk, jre

#### Для развертывания образа скачать и запустить из под командной строки, находясь в директории с файлом 
```
docker load < demo.tar
```

#### Для старта контейнера 
``` 
docker run -d -p 8080:8080 docker-normal-demo:1.0-SNAPSHOT
```
#### при необходимости сменить целевой порт запуска

[Ссылка на архив с образом с образом](https://disk.yandex.by/d/QuSQqVgBWWAZQg)

##### Получение пользовательского токена. БД h2 im memory. Запись пользоваттей происходи при выполнении сервиса автоматически, в классе старта "DemoApplication.java"
```
host:port/api/user/authenticate
{
    "userName":"user1",
    "password":"pwd1"
}
```
##### Для отправки сообщения
```
host:port/api/user/message
{
    "username":"user1",
    "message":"message"
}
```
или получение последних 10 сообщений пользователя
```
host:port/api/user/message
{
    "username":"user1",
    "message":"history 10"
}
```