# 🐾 Pet Daycare Microservices Platform

A backend system for managing pet daycare operations, built with Java, Spring Boot, and PostgreSQL. This project follows a microservice architecture with service discovery and is currently evolving to use RabbitMQ for asynchronous communication between services.

---

## 🧩 Architecture Overview

This project is composed of the following microservices:

- **Pets Service**: Handles CRUD operations related to pets.
- **Owner Service**: Manages pet owners and their preferences.
- **Discovery Service**: A Eureka server used for service registration and discovery.
- **Message Broker**: RabbitMQ (currently being integrated) to support decoupled event-driven communication.

All services are containerized using Docker and orchestrated with Docker Compose.

---

## 🚀 Features

- ✅ Microservice architecture with Spring Boot
- ✅ PostgreSQL for data persistence
- ✅ Eureka Discovery Service for dynamic service registration
- ✅ RESTful APIs for inter-service communication
- 🔄 In-progress: RabbitMQ integration for async messaging between services
- 🐳 Dockerized setup for easy local development

---

## 🛠️ Tech Stack

- **Languages**: Java
- **Frameworks**: Spring Boot, Spring Web, Spring Data JPA, Spring Cloud Eureka
- **Messaging**: RabbitMQ (work in progress)
- **Database**: PostgreSQL
- **Infrastructure**: Docker, Docker Compose
- **Service Discovery**: Eureka

---

