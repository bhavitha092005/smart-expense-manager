# 🧾 Smart Expense & Budget Manager

👩‍💻 Developed by: **Pala Bhavitha**  
🚀 Role: Full Stack Developer  

---

## 📌 Project Overview

Smart Expense & Budget Manager is a secure full-stack web application built using Java and Spring Boot that enables users to manage daily expenses and monthly budgets efficiently.

The application implements JWT-based authentication, role-based access control, secure REST APIs, and a clean layered backend architecture. A lightweight frontend built with HTML, CSS, and JavaScript integrates seamlessly with the backend.

This project demonstrates real-world backend security, API design, and full-stack integration.

---

## 💻 Tech Stack

### 🔹 Backend
- Java
- Spring Boot 3
- Spring Security
- JWT (Stateless Authentication)
- REST APIs
- Spring Data JPA
- MySQL
- BCrypt Password Encryption

### 🔹 Frontend
- HTML5
- CSS3
- JavaScript (Vanilla JS)
- Fetch API

---

## 🔐 Security Features

- Stateless Authentication using JWT
- Password encryption using BCrypt
- Role-Based Access Control (USER / ADMIN)
- Custom JWT Authentication Filter
- Protected REST Endpoints
- Global Exception Handling

---

## ✨ Core Features

### 👤 User Management
- User Registration
- User Login
- JWT Token Generation & Validation
- Role Handling (USER / ADMIN)

### 💸 Expense Management
- Add Expense
- View User Expenses
- Category-based tracking
- Date-wise tracking
- Description support

### 📅 Budget Management
- Set Monthly Budget
- Update Budget
- Retrieve Budget per month/year

### 📊 Dashboard Summary
- Monthly Total Expenses
- Budget Amount
- Remaining Budget
- Category-wise Expense Breakdown

### 🛠 Admin Features
- View all registered users
- View all expenses in the system

---

## 🏗 Architecture

This project follows a clean **Layered Architecture**:

controller → service → repository → entity


Additional supporting layers:
- dto
- config
- security
- exception

This ensures:
- Separation of concerns
- Maintainable business logic
- Scalable and production-ready structure
- Clean code practices

---

## 📂 Backend Project Structure

smart-expense-manager-backend
│
├── controller
│ ├── AuthController
│ ├── ExpenseController
│ ├── BudgetController
│ ├── DashboardController
│ └── AdminController
│
├── service
│ ├── AuthService
│ ├── ExpenseService
│ ├── BudgetService
│ └── DashboardService
│
├── repository
│ ├── UserRepository
│ ├── ExpenseRepository
│ └── BudgetRepository
│
├── entity
│ ├── User
│ ├── Expense
│ └── Budget
│
├── dto
│ ├── AuthRequest
│ ├── AuthResponse
│ ├── RegisterRequest
│ ├── ExpenseRequest
│ ├── BudgetRequest
│ └── DashboardResponse
│
├── security
│ ├── JwtUtil
│ ├── JwtAuthenticationFilter
│ └── CustomUserDetailsService
│
├── config
│ ├── SecurityConfig
│ └── CorsConfig
│
├── exception
│ ├── GlobalExceptionHandler
│ ├── ResourceNotFoundException
│ └── UnauthorizedException
│
└── ExpenseManagerApplication


---

## 📂 Frontend Project Structure

smart-expense-manager-frontend
│
├── index.html (Welcome Page)
├── login.html
├── register.html
├── dashboard.html
│
├── css
│ └── style.css
│
├── js
│ ├── auth.js
│ ├── dashboard.js
│ ├── expense.js
│ └── budget.js


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

### 🔹 Backend Setup

1. Install MySQL
2. Create database:

```sql
CREATE DATABASE expense_manager_db;
Update application.properties:

spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
Run:

ExpenseManagerApplication.java
Backend runs at:

http://localhost:8080
🔹 Frontend Setup
If served via Spring Boot:

http://localhost:8080/
If separated:
Open index.html directly in browser.

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

🎯 What This Project Demonstrates
Secure full-stack development

JWT-based authentication

Role-based authorization

Clean REST API design

Backend architecture best practices

Frontend-backend integration

Real-world debugging and security handling

Production-ready full-stack application design

🚀 Future Enhancements
Update & delete expenses

Data visualization charts

Export reports (CSV/PDF)

Refresh token implementation

Cloud deployment

👩‍💻 About Me
Pala Bhavitha
Full Stack Developer

Backend: Java | Spring Boot | Spring Security | REST APIs | MySQL
Frontend: HTML | CSS | JavaScript

Passionate about building secure, scalable, and production-ready web applications.

⭐ If you found this project helpful, consider giving it a star!


---

This is now:
- Complete
- Structured
- Professional
- Clean
- Internship-level
- Recruiter-ready

If you want next, I can create:

- 🔥 Your **GitHub Profile README (main profile page)**
- 🎨 Add badges & GitHub stats
- 📄 Resume project explanation
- 🎤 Interview Q&A based on this project

You’ve built something solid. Now we position it strategically.
