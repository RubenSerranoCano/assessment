# Repository description
This repository hosts a project whose purpose is to facilitate the evaluation of the quality of the code, the project design, and the construction of a REST API and its tests.

# Table of contents
- [Key features](#key-features)
- [Requirements](#requirements)
- [Project structure](#project-structure)
- [Technologies and tools](#technologies-and-tools)
- [Developers](#developers)

# Key features
- REST API endpoint to retrive details about a price
- Swagger UI and YAML REST API Docs
- Acceptance tests to ensure propper functionality
- Layered architecture applying SOLID principles inspired by hexagonal architecture, ddd and clean architecture

# Requirements
In order to review the code, run it and perform the acceptance tests, it's recommended to have the following tools 
- Java 17
- IntelliJ IDEA (Community edition will suffice)
- (Optional) Git

# Project structure
This project follows a layered architecture structure heavily focused on responsibility segregation and dependency inversion, allowing the software to be more manageable, testable and to simplify following SOLID principles. 
The layers and its relationships are inspired by clean architecture, hexagonal architecture and domain driven design. 

## Presentation Layer
This is the application entry point as it contains the REST controllers, it's responsability is to manage the requests contents and to build responses for the clients. This layer is dependant on the
service layer, this dependency, as all of them, is based on the principle of dependency inversion. This layer will contains two packages:

- **RestControllers**: This package contains all the REST controllers which handle and respond to user requests.
- **DTOs and Mappers**: This package contains DTO (Data Transfer Object) classes and mappers to convert DTOs to domain models and vice versa.

## Application Layer
The **Application Layer** is where the business logic of the application lives, this layer may take data from the controller to process data. It may depend on repositories and, in case it's required,
it will return the service model so that the controller can build a response. Performing the mapping from a model to a DTO in the controller layer will decouple this layer from the REST API, allowing
the latter to be changed without having an impact on this one.

## Domain Layer
Responsible for defining the application model, this being the data the system will interact with. It will also contain specifications (interfaces) about the operations that can be perfomed
with the data through repositories, that will be implement in the infrastructure layer.

- **Model**: This package contains all the data models/entities used in the application.
- **Repository**: This package contains the interfaces that provide an abstraction of the data store.

## Infrastructure Layer
The **Infrastructure Layer** supports every other layer by providing technical capabilities, tools, and libraries. This layer interacts with the data stores by providing implementations to the operations.

- **Repositories Implementation**: This package contains the implementation of the repository interfaces defined in the domain layer.
- **Configuration and Utils**: This package contains application configuration files and utility classes or constants used across the application. In this particular instance, there is no need for
configurations.

# Technology and tools
These are the technologies used in this project
- Java 17
- Spring Boot 3.2.5
- Spring boot starter web
- Spring boot starter data JPA
- Hibernate
- Criteria API
- H2
- OpenAPI
- Lombok

These were the tools used to develop the project
- IntelliJ IDEA
- Postman
- Ubuntu

# Developers
Rubén Serrano Cano
