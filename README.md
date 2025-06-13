# Spring E-Commerce Backend

> **Note:** This project is created for educational purposes and is intended to demonstrate Spring Boot best practices for learning and training.

This project is a simple e-commerce backend built with Spring Boot. It provides RESTful APIs for managing products, categories, and other core e-commerce functionalities. The backend is designed using Spring Boot best practices, leveraging Spring Data JPA for database operations and supporting file uploads for product images.

## Project Overview Video

*A project overview video will be added here soon.*

## Features
- Product management (CRUD operations)
- Category management
- Image upload and storage for products
- Search functionality for products
- RESTful API design
- Spring Data JPA integration
- Exception handling and validation

## Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Maven
- H2/MySQL (configurable)

## Getting Started

### Prerequisites
- Java 17 or later
- Maven

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/MU-N/spring-boot-e-commerce-rest.git
   cd spring-boot-e-commerce-rest
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the API at `http://localhost:8080/api/products` (or your configured endpoint).

## API Documentation
API documentation is available via Springdoc OpenAPI/Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

## Repository
[https://github.com/MU-N/spring-boot-e-commerce-rest](https://github.com/MU-N/spring-boot-e-commerce-rest)

## License
This project is licensed under the MIT License.

> **Disclaimer:** This project is for educational and demonstration purposes only. 