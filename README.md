# E-commerce Backend API

## Overview

This project involves creating a Spring Boot backend API to connect an existing Angular frontend with a MySQL database for an e-commerce website. The backend will handle data retrieval, updates, and the creation of tracking numbers.

## Technologies Used

### Backend

* Java
* Spring Boot
* Maven
* Spring Data JPA
* RESTful APIs
* Lombok

### Frontend

* Angular
* TypeScript
* HTML
* CSS
* Node.js
* npm

### Database

* MySQL

### Development Environment & Tools

* IntelliJ IDEA
* Git

## Feature Implementation

### Initial Setup and Environment (Tasks A & B)

* Configured the development environment (local machine or lab).
* Set up the GitLab repository and IntelliJ project.
* Installed necessary project dependencies (as per linked guide).

### Backend and Frontend Linking (Tasks C, D, & E)

* Created necessary Java packages (`com.your.groupname.*`, `config`).
* Imported `RestDataConfig.java` and `application.properties` from lab files.
* Created Java entity classes mapping to the MySQL database tables, using `@Getter` and `@Setter`.
* Ensured entity field names match the corresponding variables in the Angular frontend `.ts` model files.
* Configured OneToMany and ManyToMany relationships between entities based on the provided UML/ERD diagrams.
* Created an enumeration for the `Cart` status.
* Created repository interfaces for each entity using Spring Data JPA's `JpaRepository` and added `@CrossOrigin` annotation.

## Setup

1. Ensure IntelliJ IDEA, Java (JDK), and Maven are installed.
2. Set up the GitLab repository and clone the project into IntelliJ.
3. Configure project dependencies in `pom.xml` (including specific Spring Boot and Lombok versions if necessary).
4. The Angular frontend is provided and assumed to be running separately (typically via `ng serve` in its own directory).
5. The Spring Boot backend can be run within IntelliJ or via Maven (`mvn spring-boot:run`).

## Git Repository

* **Repository URL:** https://github.com/cbaguley3/BackEndProgramming_Spring-MySQL-Angular/edit/working_branch
* **Branch:** working_branch

## Commit History (Relevant to described features)

* Completed Task B (initial environment setup).
* Implemented package structure (Task C).
* Created and mapped entity classes and relationships (Task D).
* Created repository interfaces (Task E).
