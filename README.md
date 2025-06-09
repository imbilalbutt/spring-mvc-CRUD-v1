# Java CRUD operations using Spring boot 🎫

CRUD operations implemented and well decorated as per professional practices having REST API.

## 🚀 Overview

This project implements a CRUD operations backend exposing secure, RESTful endpoints. It demonstrates real-world enterprise techniques, including:

* **Spring Boot** for streamlined application setup
* **Spring MVC** for REST controller routing
* **Dependency Injection** using Spring IoC
* **Aspect-Oriented Programming (AOP)** for cross-cutting concerns like logging and audit
* Solid architecture: Controllers → Services → Repositories

---

## 📌 Features

* ** CRUD operations for:

  * Users
* Global exception handling with meaningful HTTP responses
* Detailed DTO mapping, separating API models from entity models
* Logging and performance aspects using AOP

---

## 💻 Tech Stack

* Java 17+
* Spring Boot
* Spring MVC
* Spring Data JPA (with PostgreSQL Database)
* Gradle build system
* JUnit tests (testing basic assertion i.e., assertThat)

---

## 📥 Getting Started

### Prerequisites

* JDK 17+ installed
* Maven

### Environment Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/imbilalbutt/spring-mvc-CRUD-v1.git
   cd spring-mvc-CRUD-v1
   ```

2. Configure application settings in `application.properties` (or `application.yml`), including:

   * Database connection (default: PostgreSQL)
   * Customizable server port

3. Build and run:

   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

   The API will be available at `http://localhost:8080/api`.

---

## 📘 API Endpoints

| Resource        | Endpoint                         | Methods                        | Roles           |
| --------------- | -------------------------------- | ------------------------------ | --------------- |
| `Auth`          | `/api/auth/signup`               | `POST` (register new users)    | —               |
|                 | `/api/auth/signin`               | `POST` (login & token)         | —               |
| `User`          | `/api/users`                     | `GET`, `PUT`, `DELETE`         | `ADMIN`         |


---

## 🛡 Cross-Cutting & Security

* **AOP Logging** — Logs execution times of service methods (TODO)
* **Security Config** — Roles, password encoder (TODO)
* **Exception Aspect** — Handles and formats exceptions consistently

---

## 🔄 Model ↔️ DTO Conversion

Leverages Java Functional interfaces for clean mapping:

```java
Function<User, UserDto> userToDto = user -> new UserDto(...);
Function<UserDto, User> dtoToUser = dto -> new User(...);
```

This approach enhances readability and testability by decoupling conversion logic from controllers and services.

---

## 🧪 Testing

* Unit tests: JUnit for services, controllers, and AOP aspects
* Integration tests: Load full context, mock security, validate end-to-end behavior

To run tests:

```bash
./mvnw test
```

---

## 🛠️ Contributing

Contributions are welcome! Please:

1. Fork and create a feature branch
2. Write meaningful tests
3. Submit a PR with descriptions of changes

✔️ Ensure all tests pass before submitting.

---

## 📄 License

This project is open source — MIT License.

Copyright (c) 2023 Bilal Ahmad Butt

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

---

## 🧭 Roadmap & Improvements

Potential enhancements:

* Frontend client (Angular/React)
* Spring security & JWT tokens
* Pagination and filtering support
* Full Swagger/OpenAPI documentation


---

## 🙋‍♂️ Contact

For issues or contributions, please open a GitHub issue or reach out to [`@imbilalbutt`](https://github.com/imbilalbutt).

---

*Made with ❤️ using Spring Boot*

---

### ⭐ Tips for polishing further

1. Add badges for build status, coverage, license.
2. Include example `curl` or Postman requests.
3. Add UML/architecture diagrams or API specs (e.g., Swagger UI screenshots).
4. Include a "Known Issues" or "FAQ" section.
