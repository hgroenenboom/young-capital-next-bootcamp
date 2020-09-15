### Short notes for fullstack dev using Spring:
Example repository by FelixvL: https://github.com/FelixvL/GSWPresentatie

## About the Tools and Techniques

### Terms
**CRUD**:   Create, Read, Update, Delete
**LAMP**
**REST**

### XAMPP
For hosting and database creation we the LAMP service use XAMPP
> -> always turn on apache and SQL. (web connection and database connection)

### Spring
Spring is a Java Framework providing a programming and configuration model for modern Java-based applications. A key element of Spring is infrastructural support at the application level. Spring Boot gives you defaults on all things, so if you want to use specific librarys/API/tools you must explicitly specify it.

#### @Controller: Http Requests 
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

#### Databases
Create the application.properties File. The default database used by Spring is H2.
Define the application.properties file
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
spring.datasource.username=springuser
spring.datasource.password=ThePasswordCOPY
```
Here, spring.jpa.hibernate.ddl-auto can be none, update, create, or create-drop. See the Hibernate documentation for details.
- **none**: The default for MySQL. No change is made to the database structure.
- **update**: Hibernate changes the database according to the given entity structures.
- **create**: Creates the database every time but does not drop it on close.
- **create-drop**: Creates the database and drops it when SessionFactory closes.

#### Bean???????

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
   > Test webconnection via http://localhost:$(port)/greeting
   
> The implementation of the method body relies on a view technology (Thymeleaf) to perform server-side HTML rendering.

> I'm now able to access backend via http://localhost:8082/greeting

### 4. Serving web content
> [Spring Guide](https://spring.io/guides/gs/serving-web-content)

1. Create an index.html file at src/main/resources/static/index.html.
2. Restart the Spring server and go to localhost:$(port) to test your homepage

### 5. Database
> [Spring guide](https://spring.io/guides/gs/accessing-data-mysql/#initial)

1. Create application.properties linking to your database
    > You must begin with either create or update, because you do not yet have the database structure. After the first run, you can switch it to update or none, according to program requirements. Use update when you want to make some change to the database structure.
2. Create An Entity Model 
    Annotated by @Entity
    > @Entity tells Hibernate to make a table out of this class
    
    > class UserEntity
3. Create a Repository
    This repository will hold the entitys
4. Run application
5. Test Database
    > GET localhost:8080/demo/all: Gets all data. 
    > POST localhost:8080/demo/add: Adds one user to the data.

    Powershell: [Invoke-WebRequest](https://docs.microsoft.com/nl-nl/powershell/module/microsoft.powershell.utility/invoke-webrequest?view=powershell-5.1&redirectedfrom=MSDN)[Invoke-RestMethod](https://discoposse.com/2012/06/30/powershell-invoke-restmethod-putting-the-curl-in-your-shell/)
    ```
    Invoke-WebRequest -URI "http://localhost:<port>"
    ```
    
    Get all data:
    ```
    Invoke-RestMethod -Method Post/Get -Uri $(URL)
    ```
    
    