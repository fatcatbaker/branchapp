## Github User Info Demo Project

### Overview
This demo project has been created to show how to use the Github API to retrieve user information.  


### 
| Framework                                                      | Description                                                 | Why It's Used                                                                                                                                                                                                                                                                                                                                            |
|----------------------------------------------------------------|-------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Caffeine](https://github.com/ben-manes/caffeine)              | High performance cache                                      | For creating stand-alone, production-grade Spring-based applications easily.                                                                                                                                                                                                                                                                             |
| [OpenFeign](https://spring.io/projects/spring-cloud-openfeign) | Declarative web service client                              | Easy to call RESTful web services.  Easy to add custom encoding/decoding, headers, logging.                                                                                                                                                                                                                                                              |
| [Lombok](https://projectlombok.org/)                           | Library used to minimizee boiler plate code                 | Used to generate getters, setters, construtors.  Code is easier to read and maintain                                                                                                                                                                                                                                                                     |
| [Mapstruct](https://mapstruct.org/)                            | Code generator used to simplify mappings between Java beans | Mapstruct has been used to convert the beans from the GithubAPI to the User response.  Using the mapper makes it really easy to convert one bean to another. Mapstruct was chosen because [real-life model testing](https://www.baeldung.com/java-performance-mapping-frameworks) shows that Mapstruct performs really well compared to other libraries. |
| [Jackson](https://github.com/FasterXML/jackson-docs)           | JSON processing library                                     | Jackson is used to provide a fast and efficient way to deserialize and serialize objects.  Jackson is highly performant with a low memory footprint.                                                                                                                                                                                                     |




### Installation
1. Clone the repository: `git clone https://github.com/fatcatbaker/branchapp.git`
2. Navigate to the project directory: `cd branchapp`
3. Install dependencies: `mvn install` 


### Running the Application
This project is set up to run on port 8080.  If you'd like to specify a different port you can do so in `application.yaml`
1. Run the application: `mvn spring-boot:run`
2. Access the application at `http://localhost:8080`
3. You can also run the application from your IDE.  Import the project as a Maven project and run the DemoApplication configuration.

### Testing the Application
This is a GET endpoint that takes a username as a path parameter.  The endpoint will return a JSON response with the user information.
<br>`GET http://localhost:8080/api/v1/user/{username}` </br>
<br>The response will be cached for 1 minute.  If the same username is requested within 1 minutes, the response will be returned from the cache.</br>

To test the endpoint, use Postman, cURL or use the rest client of your choice.

- Example request:  http://localhost:8080/api/v1/user/octocat 
- Response:  A 200 response and JSON payload containing the user information and their Github repositories
- Example request: http://localhost:8080/api/v1/user/octocat-is-gone 
- Response:  A 404 response indicating that the resource is not found.

Note that these endpoints are not protected.   spring-boot-security-starter would need to be added to add Spring Security features.

## Testing
Explain how to run tests for your application. For example:
- Run `mvn test` or `gradle test`

## Contribution
If you're open to contributions, provide guidelines on how others can contribute to your project.

## License
Specify the license under which your project is released.

## Contact
Provide your contact information or any other relevant links for users to reach out.

---

Remember to replace placeholders (like `[repository link]` or `[project name]`) with actual values relevant to your project. Also, feel free to add or remove sections based on the specifics of your project and what you think is important for users to know.
