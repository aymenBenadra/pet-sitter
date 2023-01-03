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

## Modules

### Backend (Spring Boot)
 
    pet-sitter (parent)
    ├──  pet-sitter-api-gateway: Handle all requests and redirect to the right module (reactive, cercuit breaker, ...)
    ├──  pet-sitter-configuration: Handle configuration (database, security, ...)
    ├──  pet-sitter-persistence: Handle database access and domain objects (entities)
    ├──  pet-sitter-authentication: Handle authentication and authorization (login, register)
    ├──  pet-sitter-pets: Handle pet management (add, update, delete, ...)
    ├──  pet-sitter-feed: Handle posts management (add, update, delete, ...)
    ├──  pet-sitter-leaderboard: Handle leaderboard (most active users)
    └──  pet-sitter-adoption: Handle adoption requests (accept, reject)

### Frontend (Angular)

[//]: # (TODO: Add frontend architecture)

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

### Frontend

[//]: # (TODO: Add frontend technologies)

### Database

- MySQL
- PHPMyAdmin (for development)

### Tools

- IntelliJ IDEA
- Visual Studio Code
- Postman
- Git
- GitHub

### Deployment

- Spring Boot Cloud Native buildpacks (for building docker images)
- Docker
- Docker Compose