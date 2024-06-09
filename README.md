# FeedingMonitor

Webanwendungen um einzelne Fütterungen in eine Datenbank einzutragen und die dazu gehörigen Stammdaten zu pflegen


## Vorbereitung

1. Welches JDK ist installiert?

```
java -version
=> OpenJDK 1.8
whereis java
```

## Spring Initialisieren auf https://start.spring.io/

=> für Ubuntu 18 kommt nur Java 11 in Frage! Nicht mekr kompatibel mit v17

=> Spring Boot 3.x würde Java 17 benötigen, daher mit v2.7.14 weiter!

Installierte Abhängigkeiten: Spring Boot DevTools, Spring Web, Thymeleaf, Spring Data JPA (u.a. Hibernate ORM), Flyway Migration


Templating + ORM


Alternative zu Thymeleaf ist JSP (Java Server Pages), ist schon in Spring dabei



Aufruf: 

```
http://localhost:8080/
```


## Flyway Tutorial (Flyway von redgate)

Die Migrationsskripte müssen selbst erstellt werden!

spring.flyway.locations=/home/stephan/Documents/FeedingMonitor/demo/src/main/resources/db/migration
=> Zugangsdaten DB nur flyway.xxx (ohne spring prefix)

```
mvn flyway:info -e -Dflyway.configFiles=/home/stephan/flyway.conf
```


https://www.baeldung.com/database-migrations-with-flyway

- maven plugin in pom.xml hinzufügen, kann auf unterschiedliche Arten konfiguriert werden (dort Name, Passwort, Datenbank hinterlegen)



### Migration ausführen:

```
mvn clean flyway:migrate -Dflyway.configFiles=myFlywayConfig.conf  (clean nur initial bei erstem Aufruf, leert die Datenbank!)
```

Java Pfad muss gesetzt sein: 

export JAVA_HOME="/home/stephan/openjdk/v13/jdk-13.0.2"

```
mvn flyway:migrate -Dflyway.configFiles=src/main/resources/flyway.conf
```


### Anmerkungen: 

Wenn Spaltennamen ohne `` dann wird CamelCase ignoriert: brandName => brandname

Versionierungsskript sehr DB-abhängig, z.B. was int auto_increment (MySQL) betrifft => serial (4 bytes) oder bigserial (8 bytes
) in Postgresql!

Although convenient, and even suggested in many PostgreSQL books, the SERIAL and BIGSERIAL column types are not a very good choice when using JPA and Hibernate. Using a SEQUENCE generator is a better alternative since the identifier can be generated prior to executing the INSERT statement.
