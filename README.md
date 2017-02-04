## **Dev environment**

The application has been built and tested in the following environment:

- Java™ SE Development Kit 8, Update 65 (JDK 8u65)
- Apache Tomcat 8.0.33
- MySQL 5.7.11-log

## **Main features**

The core Smart Working application functionality is submit working from home requests to the manager who will evaluate them either approving or rejecting.

For this pupose there are two different profiles built in the application: the user and manager ones.

Users can also submit a modification request but only if the manager has not yet approved or rejected his pending request.

A couple of available additional features are:
- look at the office employees holidays caldendar, exporting such list in Excel
- send an email where the user can report on the activities performed during his smart working days.

## **Requisites**

In order to run this application, the following components are required:

- Java Runtime Environment (min. 1.8.0_65)
- Apache Tomcat (min. 8.0.33)
- MySQL (min. 5.7.11-log)

## **Installation**

You can deploy the Smart Working in a test environment following either of these three ways:

1. build the web app archive (.war) and then copy it to the *$CATALINA_HOME\webapps* directory on the target system
2. copy the unpacked web application directory to the *$CATALINA_HOME\webapps* directory on the target system
3. using Tomcat's manager application

## **Important notes**

This is a test application and by no means it should be run in a production environment.
Smart Working is a test application made by me for learning purposes. It is freely usable by everyone who accepts such poor coding styles.
No copyrights or any of that nonsense.
I don't assume ANY responsibility for how anyone uses it.
Always ski in control. Comments and questions on github.

