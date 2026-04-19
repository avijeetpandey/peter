# Peter :tada: :rocket:

A lightweight, robust backend service designed to manage the daily lives, health logs, and routines of pets. 

This project demonstrates the power of **GraphQL** paired with **Spring Boot** and **MongoDB**. It showcases how to solve classic REST API over-fetching by allowing clients to query exact hierarchical data (like fetching a Pet and specifically requesting only their daily routines) in a single request.

## 🛠 Tech Stack

* **Java 17+**
* **Spring Boot 3.x** (Web, GraphQL, Data MongoDB, Validation)
* **GraphQL** (Spring for GraphQL)
* **MongoDB** (NoSQL Database)
* **Docker & Docker Compose** (Containerized database)
* **Maven** (Dependency management)
* **Lombok** (Boilerplate reduction)

---

## 📂 Project Structure

The application follows a standard layered architecture to separate concerns between the API layer, business logic, and database interactions.

```text
pet-tracker/
├── docker-compose.yml          # MongoDB container configuration
├── pom.xml                     # Maven dependencies
└── src/main/
    ├── resources/
    │   ├── application.yml     # App config & DB connection
    │   └── graphql/
    │       └── schema.graphqls # The GraphQL Schema contract
    └── java/com/avijeet/peter/
        ├── PetTrackerApplication.java
        ├── config/             # DataSeeder for initial DB population
        ├── controller/         # GraphQL Query/Mutation Mappings
        ├── dto/                # Input objects with Jakarta Validation
        ├── exception/          # Custom GraphQL Error Resolvers
        ├── enums/              # e.g., TaskType (FEEDING, WALK)
        ├── model/              # MongoDB Document Entities (@Document)
        ├── repository/         # Spring Data MongoRepositories
        └── service/            # Core business logic layer
