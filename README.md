## Github User Info Demo Project

### Overview
This demo project is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/)

---
### Libraries Used
### 
| Framework                                                      | Description                                                | Why It's Used                                                                                                                                                                                                                                                                                                                                            |
|----------------------------------------------------------------|------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Caffeine](https://github.com/ben-manes/caffeine)              | High performance cache                                     | For creating stand-alone, production-grade Spring-based applications easily.                                                                                                                                                                                                                                                                             |
| [OpenFeign](https://spring.io/projects/spring-cloud-openfeign) | Declarative web service client                             | Easy to call RESTful web services.  Easy to add custom encoding/decoding, headers, logging.                                                                                                                                                                                                                                                              |
| [Lombok](https://projectlombok.org/)                           | Library used to minimize boiler plate code                 | Used to generate getters, setters, construtors.  Code is easier to read and maintain.                                                                                                                                                                                                                                                                    |
| [Mapstruct](https://mapstruct.org/)                            | Code generator used to simplify mappings between Java beans | Mapstruct has been used to convert the beans from the GithubAPI to the User response.  Using the mapper makes it really easy to convert one bean to another. Mapstruct was chosen because [real-life model testing](https://www.baeldung.com/java-performance-mapping-frameworks) shows that Mapstruct performs really well compared to other libraries. |
| [Jackson](https://github.com/FasterXML/jackson-docs)           | JSON processing library                                    | Jackson is used to provide a fast and efficient way to deserialize and serialize objects.  Jackson is highly performant with a low memory footprint.                                                                                                                                                                                                     |
### Requirements
Before building and running this application, please ensure that you have the following installed:
- JDK 17
- Maven 3.x.x 
- Git
---
### Installation
1. Clone the repository: `git clone https://github.com/fatcatbaker/branchapp.git`
2. Navigate to the project directory: `cd branchapp`
3. Install dependencies: `mvn install` 
---

### Running the Application
This project is set up to run on port 8080.  If you'd like to specify a different port you can do so in `application.yaml`
1. Run the application: `mvn spring-boot:run`
2. Access the application at `http://localhost:8080`
3. You can also run the application from your IDE.  Import the project as a Maven project and run the DemoApplication configuration.

---
### Testing the Application
This is a GET endpoint that takes a username as a path parameter.  The endpoint will return a JSON response with the user information.
<br>`GET http://localhost:8080/api/v1/user/{username}` </br>
<br>The response will be cached for 1 minute.  If the same username is requested within 1 minutes, the response will be returned from the cache. </br>
<br>Note: Trace logging has been turned on in`application.properties` to show when the cache is used.</br>

To test the endpoint, use Postman, cURL or use the rest client of your choice.

- <b>Example request:</b>  http://localhost:8080/api/v1/user/octocat 
- <b>Response:</b>  A 200 response and JSON payload containing the user's GitHub user information and their Github repositories
- <b>Example request:</b> http://localhost:8080/api/v1/user/octocat-is-gone 
- <b>Response:</b>  A 404 response indicating that the resource is not found.

<br>Note: these endpoints are not protected.   spring-boot-security-starter would need to be added to add Spring Security features.</br>

---
## Testing
A simple unit test has been created to test the UserService.  With additional time, I would have added more unit tests and integration tests.
- Run `mvn test` to run the unit tests
---

## Contact
Created by [fatcatbaker](https://github.com/fatcatbaker) 

---

