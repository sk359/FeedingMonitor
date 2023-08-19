# FeedingMonitor
Übersicht einzelne Fütterungen

Java Spring FeedingMonitor
#################################


1. Welches JDK ist installiert?

> java -version
OpenJDK 1.8

> whereis java
=> wohl auch v17 installiert

Auch v13 installiert:

/home/stephan/openjdk/v13


2. Projekt in Github anlegen

Lokal auschecken:

=> vorher Deploy Key im Repository hinterlegen! Früher ging auch Nutzername + Passwort, jetzt nicht mehr

>git clone git@github.com:sk359/FeedingMonitor.git


3. Spring Initialisieren auf https://start.spring.io/

=> für Ubuntu 18 kommt nur Java 11 in Frage! Nicht mekr kompatibel mit v17

=> Spring Boot 3.x würde Java 17 benötigen, daher mit v2.7.14 weiter!

Installierte Abhängigkeiten: Spring Boot DevTools, Spring Web, Thymeleaf, Spring Data JPA (u.a. Hibernate ORM), Flyway Migration


Templating + ORM












4. Erster Aufruf: http://localhost:8080/








####################################
Flyway Tutorial (Flyway von redgate)
####################################

spring.flyway.locations=/home/stephan/Documents/FeedingMonitor/demo/src/main/resources/db/migration
=> Zugangsdaten DB nur flyway.xxx (ohne spring prefix)

mvn flyway:info -e -Dflyway.configFiles=/home/stephan/flyway.conf

https://www.baeldung.com/database-migrations-with-flyway

- maven plugin in pom.xml hinzufügen, kann auf unterschiedliche Arten konfiguriert werden (dort Name, Passwort, Datenbank hinterlegen)



Migration ausführen:

> mvn clean flyway:migrate -Dflyway.configFiles=myFlywayConfig.conf  (clean nur initial bei erstem Aufruf, leert die Datenbank!)


export JAVA_HOME="/home/stephan/openjdk/v13/jdk-13.0.2"

> mvn flyway:migrate -Dflyway.configFiles=application.properties


Anmerkung: wenn Spaltennamen ohne `` dann wird CamelCase ignoriert: brandName => brandname

Versionierungsskript sehr DB-abhängig, z.B. was int auto_increment (MySQL) betrifft => serial (4 bytes) oder bigserial (8 bytes
) in Postgresql!

Although convenient, and even suggested in many PostgreSQL books, the SERIAL and BIGSERIAL column types are not a very good choice when using JPA and Hibernate. Using a SEQUENCE generator is a better alternative since the identifier can be generated prior to executing the INSERT statement.
