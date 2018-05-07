# wePro Web Application

The idea behind this project is to give chance to developers, who desire to work on different and challenging projects and on different technologies in the available time. It has many advantages which are stated below:
* The user can work on different technologies.
* The user can find people to work on his/her project.
* The user can build his/her technology profile based on ratings.
* The user can work on multiple projects at the same time.
* Easy knowledge transfer within a group of people.
* The user can work remotely and in the available time.
* The user gets paid well, based on his/her skills.
* The user can get a group of people in his/her budget.


## Getting Started

Below are the instruction on how to install this project. You can go through the code and also contribute to it.

### Prerequisites 

* MySQL should be installed. For development we have used v5.7.21 version. [MySQL Download](https://dev.mysql.com/downloads/mysql/)
* [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
* [IntelliJ](https://www.jetbrains.com/idea/download/) IDE for development and testing.
* Fork and clone the project from [GitHub](https://github.com/sjhingan/wePro).
* [Apache Maven v3.5.2](http://maven.apache.org/download.cgi) dependency manager (Optional since IntelliJ have maven as inbuilt tool).

### Installation

```
Once you clone the project to your local system, import it as maven project in IntelliJ.
Since we are using maven as a dependency all the dependency should be downloaded from the central repository to local system and add them to the classpath.
To automatically add the dependencies to the classpath, enable below option.
Settings -> Maven -> Importing -> Import Maven projects automatically. 
```

## Verification

```
1. Make sure all the dependencies mentioned in the pom.xml are downloaded and configured in the class path.
2. Check the mysql version in the terminal bt executing below command.
   mysql --version
3. Verify the Java verion by executing below command in the terminal.
   java -version
4. Check the maven version using below command.
   mvn --version
```

## Configuration

1. Import Database Schema from DB_Structure file using below command and type the password when it prompted.
   ```mysql
   mysql -u <USER_NAME> -p < <DB_STRUCTURE_FILE_PATH>
   ```
2. Modify the application variables (Server information, Database connection details etc.) values as per your system.
   Modify the value in the application.properties(wePro/src/main/resources/) file.
   

## Starting the Application

Make sure the MySQL database is started.

You can start the application in two ways.
1. Start in IntelliJ.
   Just click on the "Run" button, and you can see the application getting started in the console.

2. Start using Maven.
   Execute below command from the command line.
   ```java
   mvn clean spring-boot:run
   ```

## Accessing the Application

To access the application, open any browser and execute below URL.

http://localhost:<SERVER_PORT>/

SERVER_PORT: It is the port number configured in the application.properties file.

## Work Flow

When you enter the above URL, index.html(webapp/index.html) is the page that is always sent from the server.This page will
load all the angular controllers, services, config.js and app.js. The file config.js(webapp/config.js) will manage the routing
and mapping information for each page and its controller.

All the services files under services directory will act as a bridge between client and the server. These files invoke the
rest URL which are defined in the server controller.

At the server side, the controllers will host the rest URL's. When the mapping URL is invoked, the controller will invoke the
business service and it will perform the JPA operation and send back the result.

config.html -> load respective html file (project.assessmentStatus.view.client.html) -> respective controller(project.assessmentstatus.controller.client.js) -> service(project.assesmentstatus.service.client.js) -> Assessment_statusController.java(invoke mapping url method) -> call respective method in Assessment_statusService.java -> Assessment_statusRepository.java. The repository will query data from database and send back the result to its caller. The response will be sent as per the call stack.

The Server will send only the JSON data, the UI design will be handled by the client.

#### Questions

Kindly contact any of the contributors if you have any queries or if you find any issues.