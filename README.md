# 🧾 Smart Expense & Budget Manager

👩‍💻 Developed by: **Pala Bhavitha**  
🚀 Full Stack Developer  

---

## 📌 Project Overview

Smart Expense & Budget Manager is a secure full-stack web application that allows users to manage daily expenses, set monthly budgets, and track financial insights through a real-time dashboard.

The system is built using **Spring Boot 3** with **JWT-based authentication** for secure, stateless API access and a clean frontend built using **HTML, CSS, and JavaScript**.

This project demonstrates backend security, REST API design, database integration, and frontend-backend communication.

---

## 🎯 Key Features

### 🔐 Authentication & Security
- User Registration & Login
- Password encryption using BCrypt
- Stateless authentication using JWT
- Role-based access control (USER / ADMIN)
- Secured REST endpoints
- Custom JWT authentication filter
- Global exception handling

### 💸 Expense Management
- Add expenses
- View user-specific expenses
- Category-based tracking
- Date-based filtering (monthly)
- Expense summary calculation

### 📅 Budget Management
- Set monthly budget per user
- Update budget
- Fetch budget for selected month/year

### 📊 Dashboard Summary
- Monthly total expenses
- Budget amount
- Remaining budget
- Category-wise expense breakdown
- Dynamic progress indicator

### 🛠 Admin Capabilities
- View all users
- View all expenses

---

## 🏗 System Architecture

The project follows a clean **Layered Architecture**:



Controller → Service → Repository → Entity


Supporting Layers:
- DTO (Data Transfer Objects)
- Security (JWT, Filters)
- Configuration
- Exception Handling

This ensures:
- Separation of concerns
- Maintainable business logic
- Scalable and production-ready design

---

## 💻 Tech Stack

### 🔹 Backend
- Java 17
- Spring Boot 3
- Spring Security
- JWT (io.jsonwebtoken)
- REST APIs
- Spring Data JPA
- Hibernate
- MySQL
- BCrypt Password Encoder

### 🔹 Frontend
- HTML5
- CSS3
- JavaScript (Vanilla JS)
- Fetch API
- LocalStorage (JWT storage)

### 🔹 Tools
- Spring Tool Suite (STS)
- Postman (API testing)
- MySQL Workbench

---

## 📂 Backend Project Structure



src/main/java/com/example/expensemanager
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── ExpenseManagerApplication.java


---

## 📂 Frontend Structure



static/
│
├── index.html (Welcome Page)
├── login.html
├── register.html
├── dashboard.html
│
├── css/
│ └── style.css
│
└── js/
├── auth.js
├── dashboard.js
├── expense.js
└── budget.js


---

## 🗄 Database Schema

### users
- id (Primary Key)
- username (Unique)
- password
- role

### expenses
- id (Primary Key)
- category
- amount
- date
- description
- user_id (Foreign Key)

### budgets
- id (Primary Key)
- month
- year
- amount
- user_id (Foreign Key)

---

## ⚙️ How to Run the Project

### 1️⃣ Database Setup

Create database:

```sql
CREATE DATABASE expense_manager_db;


Update application.properties:

spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

2️⃣ Run Backend

Run:

ExpenseManagerApplication.java


Application runs on:

http://localhost:8080

3️⃣ Access Application

Open in browser:

http://localhost:8080/

🔌 API Endpoints
Authentication

POST /api/auth/register

POST /api/auth/login

Expenses

POST /api/expenses

GET /api/expenses

Budget

POST /api/budget

GET /api/budget

Dashboard

GET /api/dashboard?month=&year=

Admin

GET /api/admin/users

GET /api/admin/expenses

🧠 What This Project Demonstrates

Secure backend development with JWT

Role-based access control

REST API design best practices

Clean layered architecture

Frontend-backend integration

Real-world debugging and security configuration

Database relationship handling

Stateless authentication system

🚀 Future Enhancements

Update & delete expenses

Data visualization charts

Export reports (CSV/PDF)

Refresh token implementation

Deployment to cloud platform

User profile management

👩‍💻 About the Developer

Pala Bhavitha
Full Stack Developer

Backend Expertise:
Java | Spring Boot | Spring Security | REST APIs | MySQL

Frontend:
HTML | CSS | JavaScript

Passionate about building secure, scalable, and production-ready web applications.
