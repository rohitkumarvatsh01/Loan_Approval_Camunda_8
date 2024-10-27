# Loan Approval Application Camunda 8

## Overview
This project implements a loan application system that checks the eligibility of applicants and initiates a loan approval process using Camunda Zeebe for workflow management.

## Diagram of BPMN
![Screenshot 2024-10-28 004353](https://github.com/user-attachments/assets/b25575a8-f49b-4940-abc5-aea3a2dc6e83)

## Technologies Used
- **Spring Boot**: For building the RESTful web service.
- **Camunda Zeebe**: For orchestrating workflows.
- **JPA**: For database interactions.
- **Maven**: For dependency management.

## Project Structure
- `com.loan`: Main package containing the application logic.
  - `LoanApplication`: Main entry point for the Spring Boot application.
  - `controller`: Contains the REST controllers.
  - `service`: Contains the business logic and service classes.
  - `entity`: Contains the entity classes.
  - `repository`: Contains the repository interfaces.

### Prerequisites
- Java 17 or higher
- Maven
- Camunda Zeebe broker
