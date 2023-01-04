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
    ├──  pet-sitter-api-gateway: Redirect requests to the right module (cercuit breaker, rate limiter, authorization (JWT))
    ├──  pet-sitter-api-persistence: Handle database access and entities (JPA, mapping)
    ├──  pet-sitter-api-auth: Handle authentication (login, register)
    ├──  pet-sitter-api-pets: Handle pet management (add, update, delete, ...)
    ├──  pet-sitter-api-feed: Handle posts management (add, update, delete, ...)
    ├──  pet-sitter-api-leaderboard: Handle leaderboard (get most active users)
    └──  pet-sitter-api-adoption: Handle adoption requests (get requests, accept, reject)

### Routes

    /api/v1 (gateway)
    ├──  / (feed)
    │   ├──  /                      : [GET, POST]           : Get all posts or create a new one
    │   ├──  /{postId}              : [GET, PATCH, DELETE]  : Get a post, update it or delete it
    │   │   └──  /requests (adoption)
    │   │       ├──  /              : [GET, POST]           : Get all adoption requests or create a new one
    │   │       └──  /{requestId}   : [GET, PATCH, DELETE]  : Get an adoption request, accept or reject it, or delete it
    │   └──  /leaderboard (leaderboard)
    │       └──  /                  : [GET]                 : Get the leaderboard of the most active users
    ├──  /auth (auth)
    │   ├──  /login                 : [POST]                : Login
    │   └──  /register              : [POST]                : Register
    └──  /pets (pets)
        ├──  /{ownerId}             : [GET, POST]           : Get all pets of an owner or create a new one
        └──  /{ownerId}/{petId}     : [GET, PATCH, DELETE]  : Get a pet, update it or delete it

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