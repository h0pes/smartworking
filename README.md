# **Smart Working application**
This is a test application made for learning JSP and servlet purpose.
Don't use it in production environment.

## **Main features**

The core Smart Working application functionality is submit working from home requests to the manager who will evaluate them either approving or rejecting.

For this pupose there are two different profiles built in the application: the user and manager ones.

Users can also submit a modification request but only if the manager has not yet approved or rejected his pending request.

A couple of available additional features are:
- look at the office employees holidays caldendar, exporting such list in Excel
- send an email where the user can report on the activities performed during his smart working days.

## **Dev environment**

The application has been built and tested in the following environment:

- Java™ SE Development Kit 8, Update 65 (JDK 8u65)
- Apache Tomcat 8.0.33
- MySQL 5.7.11-log

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

## **Screenshots**
![smartworking_userhome](https://cloud.githubusercontent.com/assets/25418553/22620864/10dc15ec-eb15-11e6-9ac9-8eb64a1710db.JPG)
![smartworking_useraddplanning](https://cloud.githubusercontent.com/assets/25418553/22620865/10dd19ba-eb15-11e6-87d5-941bf7c9efd3.JPG)
![smartworking_userviewplanning](https://cloud.githubusercontent.com/assets/25418553/22620869/10f23070-eb15-11e6-9155-09d28811b244.JPG)
![smartworking_sendemail](https://cloud.githubusercontent.com/assets/25418553/22620867/10e0fd50-eb15-11e6-827c-8f1ad0b0b7fc.JPG)
![smartworking_useraddplanningrequested](https://cloud.githubusercontent.com/assets/25418553/22620866/10de182e-eb15-11e6-876f-fe5f1e98bcf9.JPG)
![smartworking_approvereject](https://cloud.githubusercontent.com/assets/25418553/22620868/10e1cdf2-eb15-11e6-8d1e-831005a16bb0.JPG)
![smartworking_approverejectoverview](https://cloud.githubusercontent.com/assets/25418553/22620870/110ad4e0-eb15-11e6-88bc-bc87c23cdf98.JPG)
