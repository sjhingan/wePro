# wePro

Spring-boot web application.

## Getting Started

Instruction on how to install this project.

### Prerequisites

```
Maven should be installed.
```

### Installing

```
Import it as a maven project.
```

## Verification

```
Make sure all the dependencies mentioned in the pom.xml are downloaded and configured in the class path.
```

## Running

```
Make sure database is running.
Execute below command from the command line.
mvn spring-boot:run

Enter the URL http://localhost:8080/ to access the application.
```

## Work Flow

```
When you enter the above URL, index.html(webapp/index.html) is the page that is always sent from the server.
This page will load all the angular controllers, services, config.js and app.js.
The file config.js(webapp/config.js) will manage the routing and mapping information for each page and its controller.

All the services files under services directory will act as a bridge between client and the server.
These files invoke the rest URL which are defined in the server controller.


In the server side, the controllers will host the rest URL's.
When the mapping URL is invoked, the controller will invoke the business service and it will perform the JPA operation and send back the result.

config.html -> load respective html file (topic.view.client.html) -> respective controller(topic.controller.client.js) -> service(topic.service.client.js) -> TopicController.java(invoke mapping url method) -> call respective method in TopicService.java -> TopicRepository.java.

The Server will send only the JSON data, the UI design will be handled by the client.
```

## Important files

```
application.properties : This file holds configuration information like database URL, username, password.
```

