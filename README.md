# Devotel SOAP-based Microservices Integration Assessment!
This project contains two independent Spring Boot microservices:

- `user-service`: Handles user registration and exposes user details via SOAP
- `profile-service`: Handles profile creation and retrieves user info from `user-service` using SOAP

---

## Technologies Used

- Java 21+
- Spring Boot 3.5.4
- Gradle
- Spring Web (REST)
- Spring Web Services (SOAP)
- PostgreSQL
- Spring Data JPA
- SpringDoc OpenAPI (Swagger)
- Docker & Docker Compose

---

## How to Run Locally

### Prerequisites

- Java 21+
- Docker & Docker Compose
- Gradle (or use the included `./gradlew`)

---

### Step-by-Step Setup

#### 1. Clone the Repository

```bash
git clone https://github.com/m-tilab/devotel-microservices.git
cd devotel-microservices
```

#### 2. Start PostgreSQL Database

```bash
docker-compose up -d
```

This starts a Postgres containers for both services.

#### 3. Build and Run the Services

##### User Service

```bash
cd user-service
./gradlew bootRun
```

Runs on: http://localhost:8081

##### Profile Service
In another terminal:
```bash
cd ../profile-service
./gradlew bootRun
```

Runs on: http://localhost:8080

### Service Interfaces
#### User Service
POST /users — create new user

GET /users/{id} — get user by ID

GET /users — list all users

SOAP /ws — exposes getUserById(id) for internal access

#### Profile Service
POST /profiles — creates a profile (validates user exists via SOAP)

GET /profiles/{id} — returns profile info + user info

### API Documentation
Swagger UI:

http://localhost:8081/swagger-ui.html – User Service

http://localhost:8080/swagger-ui.html – Profile Service

### Folder Structure

```plaintext
devotel-microservices/
│
├── docker-compose.yml
├── user-service/
│   └── src/main/java/com/devotel/user/...
├── profile-service/
│   └── src/main/java/com/devotel/profile/...
```

### Postman Collection file
You can import the Postman collection to test the APIs:
```plaintext
./devotel.postman_collection.json