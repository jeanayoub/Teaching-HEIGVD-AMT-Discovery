# Teaching-HEIGVD-AMT-2016-Discovery

## Introduction 

This repo is a java EE technologie combined with Docker and deployed on a Glassfish server to provide a Web Application.  

* **User-Friendly interface:** our application have a very simple, pleasant and light interactive user interface with actual standards. 
* **HTTP requests integrated:** It is also able to respond to HTTP requests (Post, Get, Delete and Put).  

## Quick start

Assuming that you have installed **docker** and **docker-compose** on your machine, download the file "WebProject" on your machine and then move to the folder "topology-amt" using :

```
cd topology-amt 
```
and then type the following command :

```
docker-compose up --build
```


When the process is done, you should be able to access the app via this link :

```
http://192.168.99.100:8080/appwar
```
If you want to access to the database you can login via the phpmyadmin page using the following link :

```
http://192.168.99.100:6060 (Username = root / Password = adminpw)
```

**PS:** We assume that your docker default ip address is **192.168.99.100**.


## Using our application
In our DataBase we already have registered users for example (username = jean.ayoub, password = jeanayoub).
You can have a look into the file WebProject/images/mysql/data/b_amtData



## Remark

Because of a missing library in the jackson configuration, when you try to send a http request to the glassfish server, only the first response for each request type will be : **HTTP Status 500 - Internal Server Error**. 



## Additional information

The application code source is included is this repo in the **src** folder.


