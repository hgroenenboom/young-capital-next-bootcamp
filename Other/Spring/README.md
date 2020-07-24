### Short notes for fullstack dev using Spring:
Example repository by FelixvL: https://github.com/FelixvL/GSWPresentatie

## About the Tools and Techniques

##### For hosting and database creation we use:
> XAMPP
> -> always turn on apache and SQL. (web connection and database connection)

### Spring
Spring is a Java Framework providing a programming and configuration model for modern Java-based applications. A key element of Spring is infrastructural support at the application level.

#### HTTP Requests / @Controller 
HTTP Requests are handled by a controller. Controllers can be identified by the @Controller annotation
- **@GetMapping**: Ensures HTTP GET requests are mappend to the corresponding function.
- **@RequestParam**: Binds the value of the querystring par to the parameter of the corresponding method. The value of this par is added to a *Model* object making it visible to the *view* template.

#### @SpringBootApplication 
SpringBootApplication is a convenience annotation that adds all of the following:
- @Configuration: Tags the class as a source of bean definitions for the application context.
- @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.
- @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.

#### HTML/CSS/JS 
These static resources must be dropped into the right place in the source code. By default Spring serves static content from resources in the classpath at /static (or /public). Only the index.html is created at src/main/resources/static/index.html.

#### Maven
Sprint uses either Graddle or Maven

Maven is a Project Management and Comprehension tool created by Apache based on the concept of a project object model (POM). Maven adresses how the software is build and maven adresses it's dependencies. The XML POM describes all of this. Maven also directly adresses the several different phases in a Build Lifecycle with for example Maven's default lifecycle. Maven plugin goals can be associated with different Maven lifecycle phases. For instance the "compile:compile" goal is associated with the compile phase
- [wikipedia](https://en.wikipedia.org/wiki/Apache_Maven)
- [apache](https://maven.apache.org/guides/getting-started/index.html)

#### REST with Spring
REST is the defacto *standard* for building web services. The web and tis protocol HTTP provide a lot of features, but aside from these features the web is build out of lots of tiny non-standardized specs. REST APIs provide these extra functionalities on top of HTTP. REST embraces al the precepts of the web, including its architecture, benefits and much more. Developers use these RESTfull 3rd party toolkits to implement these diverse specs. 

## Creating a Fullstack Spring Website

### 1. We'll create the backend server with the Spring framework:
    -> start.spring.io
    -> generate project
    
    Import dependencies such as Felix's existing pom.xml
    - MySQL Driver
    - Spring Data JPA
    - Spring Web
    - JDBC API

### 2. Connect database with framework
> Using instructions from the by Spring generated HELP.MD.

1. Create database via localhost/phpmyadmin
2. Link database in application.properties

### 3. Create our first http request
1. Create simple Resource Representation and Resource Controller classes
   > Greeting class as instructed in Spring docs.
   > [See spring guide](https://spring.io/guides/gs/rest-service/)
2. Test frontend backend connection
   > Launch Apache and SQL (check ports)
   > Build & Run Spring Java backend server
   > Test webconnection via http://localhost:<port>/greeting
   
> The implementation of the method body relies on a view technology (Thymeleaf) to perform server-side HTML rendering.

> I'm now able to access backend via http://localhost:8082/greeting

### 4. Serving web content
> [Spring Guide](https://spring.io/guides/gs/serving-web-content)

1. Create an index.html file at src/main/resources/static/index.html.
2. Restart the Spring server and go to localhost:<port> to test your homepage
