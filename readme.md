## Using MySQL in Spring Boot via Spring Data JPA and Hibernate
This boot project is based on a netlogo spring boot project:
http://blog.netlogo.com/2014/10/27/using-mysql-in-spring-boot-via-spring-data-jpa-and-hibernate/

### Build and run

#### Configurations

Open the `application.properties` file and set your own configurations.

This project

#### Maven Settings
- connect to Pure Peak VPN.
- Download settings.xml file from:
http://192.168.105.126:8081/artifactory/webapp/#/artifacts/browse/tree/General/central
(Set Me Up -> Generate Maven Settings -> Generate Settings-> Download Snippet)
- remove all contents of .m2/ directory.
- copy setting.xml on .m2/ directory.

### Prerequisites
- Java 8 (Build jdk in Jenkins, and parent build jdk)
- Java 7 (run jdk on production, and local jetty jdk)
- Language Level = 1.7
- Maven > 3.0


#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.

### From intellij
Import pom file.
To use auto compile, do as described here:
Auto compile: http://stackoverflow.com/questions/12744303/intellij-idea-java-classes-not-auto-compiling-on-save

### Usage

- Run the application and go on http://localhost:8081/backoffice-api
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
    * `/create?email=[email]&name=[name]`: create a new user with an auto-generated id and email and name as passed values.
    * `/delete?id=[id]`: delete the user with the passed id.
    * `/get-by-email?email=[email]`: retrieve the id for the user with the passed email address.
    * `/update?id=[id]&email=[email]&name=[name]`: update the email and the name for the user indentified by the passed id.
### Production
You should use different configuration on production.
Run the project this way:
`java -javaagent:/home/azureuser/apps/newrelic/newrelic-agent-3.37.0.jar -jar backoffice-api-0.0.1-SNAPSHOT.jar -Dnewrelic.config.file=/home/azureuser/apps/newrelic/newrelic.yml --spring.config.location=file:/home/azureuser/apps/backoffice-api/config/application.properties&`
#### make sure you the application doesn't die when you close the terminal:
`disown`
#### spring.config.location
That's the production configuration of the project. 
#### newrelic
  This is our monitoring service. 
  We use a jar which is installed on the server (and refer it's main class from pom.xml).
  Pay attention to the newrelic.yml file which contains the correct application name.