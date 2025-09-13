# 📚 Bookstore Management API

A **Spring Boot RESTful CRUD application** for managing books, customers, and orders in a bookstore.  
This project demonstrates **backend fundamentals** using **Spring Boot auto-configuration, Profiles, global exception handling, and Actuator monitoring**.

---

## 🚀 Features
- Manage **Books** (CRUD: create, read, update, delete)
- Manage **Customers** (CRUD)
- Manage **Orders**
    - Place orders for books
    - Validate stock availability
    - Reduce stock when an order is placed
    - Retrieve orders by ID or Customer
- **Profiles** → Run using `dev` (H2 in-memory DB) or `prod` (PostgreSQL DB) without changing code
- **Auto-Configuration** → Spring Boot automatically configures DataSource, JPA, Hibernate, and embedded Tomcat
- **Exception Handling** → Centralized handling for errors like
    - Book not found (404)
    - Customer not found (404)
    - Out of stock (400)
- **Actuator Endpoints** for Production Monitoring
    - `/actuator/health` → Health status
    - `/actuator/metrics` → Metrics (JVM, requests, DB pools, etc.)
    - `/actuator/info` → Application info

---

## 🗄️ Database Design

**Entities:**
- **Book** → `id`, `title`, `author`, `price`, `stock`
- **Customer** → `id`, `name`, `email`
- **Order** → `id`, `customer_id`, `order_date`
- **OrderItem** → `id`, `order_id`, `book_id`, `quantity`

**Relationships:**
- A **Customer** can place many **Orders**
- An **Order** can have many **OrderItems**
- An **OrderItem** is associated with a **Book**

---

## 🔗 API Endpoints

### Books 📚
- **POST** `/api/books` → Create book
- **GET** `/api/books` → Get all books
- **GET** `/api/books/{id}` → Get book by ID
- **PUT** `/api/books/{id}` → Update book
- **DELETE** `/api/books/{id}` → Delete book

### Customers 👤
- **POST** `/api/customers` → Register customer
- **GET** `/api/customers` → Get all customers
- **GET** `/api/customers/{id}` → Get customer by ID
- **PUT** `/api/customers/{id}` → Update customer
- **DELETE** `/api/customers/{id}` → Delete customer

### Orders 🛒
- **POST** `/api/orders` → Place order
    - Request body:
      ```json
      {
        "customerId": 1,
        "items": [
          {"bookId": 2, "quantity": 3},
          {"bookId": 5, "quantity": 1}
        ]
      }
      ```
- **GET** `/api/orders/{id}` → Get order by ID
- **GET** `/api/orders/customer/{customerId}` → Get all orders for a customer

### Actuator
- **GET** `/actuator/health`
- **GET** `/actuator/metrics`
- **GET** `/actuator/info`

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA (Hibernate)**
- **H2 (dev) / PostgreSQL (prod)**
- **Spring Boot Actuator** (monitoring)
- **Maven**

---

## ⚙️ Profiles
- **Dev** → H2 in-memory database
  ```properties
  spring.profiles.active=dev
  ```

- **Prod** → PostgreSQL database
    ```properties
    spring.profiles.active=prod
    ```
 **Switch profiles by setting:**
    ```properties
    ./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
    ```

## 📦 How to Run

### Prerequisites
- Java 17+
- Maven
- PostgreSQL (only for prod profile)

### Steps
```bash
# Clone repo
git clone https://github.com/your-username/bookstore-api.git

# Navigate to project
cd bookstore-api

# Run with dev profile (H2)
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Run with prod profile (PostgreSQL)
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```
### ✅ Future Improvements
Add authentication (e.g. JWT with Spring Security)
Add caching for commonly requested endpoints
Add pagination & filtering for book listings
Add Docker Compose for running app + Postgres locally
### 🤝 Contributing
PRs are welcome! Feel free to fork this repo, open issues, and submit enhancements.

📄 License
This project is MIT Licensed.


