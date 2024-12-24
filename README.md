# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.1/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.1/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.1/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.1/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/3.4.1/reference/io/validation.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

Application for searching cars and exports as XML

Implementation Plan 1. Domain Object (Car) 2. Attributes: length, weight, velocity, color. 3. Stored in an PostgreSQL database with proper schema definition. 4. Develop an endpoint (e.g., /search-cars) using Spring Boot. 6. Query the database using criteria passed via request parameters (e.g., length, weight, etc.). 7. Result Download 8. Allow users to download search results as an XML file.

Endpoint available :

INSERT : POST http://localhost:8080/api/cars/insert BODY : { "length": 12.5, "weight": 1500, "velocity": 180, "color": "blue" }

GET SPECIFIC: http://localhost:8080/api/cars/all

GET ALL : http://localhost:8080/api/cars/all

DOWNLOAD ALL : http://localhost:8080/api/cars/export

DOWNLOAD SPECIFIC : http://localhost:8080/api/cars/download?length=12.5&weight=1500.0&velocity=180.0&color=blue
