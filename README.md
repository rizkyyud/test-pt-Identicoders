# test-pt-Identicoders
Testing Untuk Penerimaan Di PT Identicoders


**Requirements**
Java, Spring, and Maven.
Jdk 17, Springboot 3.3.0, Maven 3.9.7

Dependency:
Spring Web
Lombok
Spring Data JPA
H2 Database

The application should be able to be compiled as a JAR or WAR file.
Ensure to configure the application.properties file to provide database connection information if opting for database storage.

**Project Structure**
src/main/java: Contains the application source code.
src/main/resources: Contains application configuration files.
src/test/java: Contains unit tests for the application.
src/test/resources: Contains configuration files for testing.

**How to Run the Project**
Make sure you have Java, Maven, and Spring installed on your computer.
Download or clone this project from the Git repository.
Open a terminal or command prompt and navigate to the project directory.
Run the command mvn clean install to compile and package the project.
Once successfully compiled, run the command java -jar target/jar_file_name.jar to run the application.

**API Endpoints**

Using localhost:8080/

GET /api/testing/asteroid/top10: This endpoint is used to get the top 10 asteroids closest to Earth within a specific date range.
Parameters:
startDate (Start date range)
endDate (End date range)

GET /api/testing/asteroid/getByDistence: This endpoint is used to search for asteroids based on a specific distance from Earth.
Parameters:
distance (Distance from Earth)
