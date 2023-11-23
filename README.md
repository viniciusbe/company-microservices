# Spring Cloud Application Architecture

This document provides an overview of the architecture of a Spring Cloud application. The system is composed of several components to ensure scalability, resilience, and modularity.

## Architecture Overview

![Application Architecture](https://github.com/viniciusbe/springboot-microservices/tree/master/docs/architecture_diagram.jpg)

The application is divided into various microservices, each responsible for a specific domain. The diagram above illustrates the high-level architecture.

## Key Components

### Spring Cloud Gateway

Spring Cloud Gateway serves as the entry point for routing traffic to the appropriate microservices.

### Netflix Eureka

Eureka facilitates service discovery, allowing microservices to find and communicate with each other dynamically.

### Spring Cloud Config

Centralized configuration management provided by Spring Cloud Config enables efficient modification of application settings.

### Resilience4j

Resilience4j acts as a circuit breaker, enhancing the application's ability to handle failures gracefully.

## Microservices

### Employee

The Employee microservice manages information related to employees.

### Organization

The Organization microservice handles information related to organizations.

### Department

The Department microservice is responsible for managing department-related information.

## Database

All microservices utilize MySQL as the database for storing and retrieving data.
