# Journaling App

A RESTful backend application built using **Spring Boot** that allows users to create, manage, and organize personal journal entries securely. The project follows a layered architecture and demonstrates backend development concepts such as authentication, database integration, REST APIs, and role-based access control.

---

## Features

- User registration and authentication
- Create, read, update, and delete journal entries
- Secure password storage using BCrypt
- Role-based authorization (User/Admin)
- MongoDB database integration
- Weather API integration
- Email service support
- Clean layered architecture (Controller → Service → Repository)
- RESTful API design

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data MongoDB
- MongoDB
- Maven
- REST APIs
- BCrypt Password Encoder

---

## Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── config
├── scheduler
├── cache
├── utils
└── JournalApplication
```

The application follows a layered architecture:

- **Controller** – Handles HTTP requests and responses.
- **Service** – Contains business logic.
- **Repository** – Communicates with MongoDB.
- **Entity** – Represents database models.
- **Configuration** – Security and application configuration.

---

## API Overview

### Authentication

- Register a new user
- Login using Spring Security authentication

### Journal APIs

- Create a journal entry
- Get all journal entries
- Get journal entry by ID
- Update a journal entry
- Delete a journal entry

### User APIs

- Update user information
- Delete user account

### Admin APIs

- View all users
- Create admin users

---

## Security

The application uses **Spring Security** for securing REST endpoints.

- HTTP Basic Authentication
- BCrypt password hashing
- Role-based authorization
- Protected user and admin endpoints

---

## External Services

The project integrates with:

- Weather API for fetching weather information
- Email service for notifications

---

## Getting Started

### Prerequisites

- Java 21+
- Maven
- MongoDB

### Clone the repository

```bash
git clone https://github.com/tripathiShivendra/Journaling-App.git
```

### Navigate to the project

```bash
cd Journaling-App
```

### Configure application properties

Update your MongoDB connection string and other required properties in:

```
src/main/resources/application.properties
```

### Run the application

```bash
mvn spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

---

## Future Improvements

Some planned enhancements include:

- JWT Authentication
- Redis Caching
- Apache Kafka Integration
- Docker Support
- Unit & Integration Testing
- API Documentation with Swagger/OpenAPI
- CI/CD Pipeline

---

## Learning Outcomes

This project helped me gain hands-on experience with:

- Spring Boot application development
- REST API design
- Spring Security
- MongoDB integration
- Layered software architecture
- Dependency Injection
- Authentication & Authorization
- External API integration

---

## Author

**Shivendra Tripathi**

GitHub: https://github.com/tripathiShivendra

---

## License

This project is open-source and available under the MIT License.
