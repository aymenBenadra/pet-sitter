# Pet Sitter

A multimodule Spring boot and Angular project to find Pet Sitters for busy people.

## Features

* Login and Registration
* Manage Pets
* Find Pet Sitters
* Manage Pet sitting requests
* Leaderboard of Pet Sitters

## Architecture

I'm using a Multi-module architecture with the Hexagonal Architecture pattern for the best separation of concerns.

![Hexagonal Architecture](https://reflectoring.io/images/posts/spring-hexagonal/hexagonal-architecture_hu6764515d7030d45af6f7f498c79e292b_50897_956x0_resize_box_3.png)

### Modules
 
    pet-sitter-api (parent)
    ├──  pet-sitter-api-gateway: Redirect requests to the right module (reactive, cercuit breaker, rate limiter, retry, authorization (JWT), and routes registry)
    ├──  pet-sitter-api-persistence: Handle database access and entities (JPA, mapping)
    ├──  pet-sitter-api-authentication: Handle authentication (login, register)
    ├──  pet-sitter-api-pets: Handle pet management (add, update, delete, ...)
    ├──  pet-sitter-api-feed: Handle posts management (add, update, delete, ...)
    ├──  pet-sitter-api-leaderboard: Handle leaderboard (get most active users)
    └──  pet-sitter-api-adoption: Handle adoption requests (get requests, accept, reject)

## Technologies

### Backend

- Java 17
- Gradle
- Spring Boot
- Spring Data JPA
- Spring Data REST
- Spring Boot Actuator
- Spring Security
- Spring HATEOAS
- Spring Web MVC
- Spring Web Flux (for reverse proxy)
- Spring Functional Web Framework
- Resilience4j (for circuit breaker)
- Lombok
- ModelMapper

### Database

- MySQL
- PHPMyAdmin (for development)

### Tools

- IntelliJ IDEA
- Postman
- Git
- GitHub

### Deployment

- Spring Boot Cloud Native buildpacks (for building docker images)
- Docker
- Docker Compose