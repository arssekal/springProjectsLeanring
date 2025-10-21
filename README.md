# 🚀 Spring Boot Learning Projects

A collection of practical Spring Boot projects created to learn and master backend development, REST APIs, and database management using **Java** and **Spring Boot**.

---

## 📘 Project 1: LearnTransaction

This project demonstrates **Spring Boot CRUD operations** using relationships between entities (`Author`, `Book`, and `Category`).  
It focuses on applying **Spring Data JPA**, **Entity Relationships**, and **Service-Layer Logic**.

---

### 🧩 Features

- **Author Management**
  - Create, update, delete, and fetch authors.
  - One-to-Many relationship with books.

- **Book Management**
  - CRUD operations on books.
  - Each book is linked to an author and can belong to multiple categories.
  - Demonstrates `@ManyToOne` and `@ManyToMany` mappings.

- **Category Management**
  - CRUD operations on categories.
  - Many-to-Many relationship with books.

---

### 🧠 Tech Stack

| Technology | Purpose |
|-------------|----------|
| **Java 17+** | Programming language |
| **Spring Boot 3** | Main framework |
| **Spring Data JPA** | ORM for database interaction |
| **MySQL** | Database (configurable) |
| **Lombok** | Reduces boilerplate code |
| **Postman** | API testing |

---

### 🏗️ Project Structure

```
learnTransaction/
├── controller/
│ ├── AuthorController.java
│ ├── BookController.java
│ └── CategoryController.java
├── model/
│ ├── Author.java
│ ├── Book.java
│ └── Category.java
├── repo/
│ ├── AuthorRepository.java
│ ├── BookRepository.java
│ └── CategoryRepository.java
├── service/
│ ├── AuthorService.java
│ ├── BookService.java
│ └── CategoryService.java
└── LearnTransactionApplication.java
```
---

## ⚙️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/<your-repo-name>.git
   cd learnTransaction
2. Build and run:

3. mvn spring-boot:run


4. Access the application:

http://localhost:8080

📡 API Endpoints
📖 Books
Method	Endpoint	Description
| Method   | Endpoint                   | Description                          |
| -------- | -------------------------- | ------------------------------------ |
| `POST`   | `/books/{authorId}`        | Add a new book for a specific author |
| `GET`    | `/books`                   | Get all books                        |
| `GET`    | `/books/{id}`              | Get a book by ID                     |
| `PUT`    | `/books/{id}`              | Update a book                        |
| `DELETE` | `/books/{id}`              | Delete a book                        |
| `GET`    | `/books/author/{authorId}` | Get all books by author ID           |






