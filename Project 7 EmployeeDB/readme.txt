# Employee Database App (Java + JDBC + MySQL)

A simple **Java JDBC CRUD application** that connects to a MySQL database and allows you to **Add, View, Update, and Delete employees**.  
The project is built with **Java**, **MySQL**, and the **MySQL Connector/J 9.4.0** driver.

---

## 📌 Features
- Connects to MySQL using JDBC
- Uses `PreparedStatement` for SQL queries
- CRUD Operations:
  - Add new employee
  - View all employees
  - Update employee salary
  - Delete employee
- Clean multi-file structure for maintainability

---

## 📂 Folder Structure
EmployeeDBApp/
│── lib/
│ └── mysql-connector-j-9.4.0.jar # MySQL JDBC Driver
│── src/
│ ├── DBConnection.java # Database connection setup
│ ├── Employee.java # Employee model class
│ ├── EmployeeDAO.java # Data Access Object for CRUD
│ ├── Main.java # User menu + interaction
│── db.sql # SQL script for database & table
│── README.md


---

## 🛠 Requirements
- **Java 8+**
- **MySQL Server** installed and running
- MySQL Connector/J 9.4.0 JAR file

---

## 🔗 MySQL JDBC Driver
Download from: [MySQL Connector/J 9.4.0](https://dev.mysql.com/downloads/connector/j/)

---

## ⚙️ Setup Instructions

### **1. Create MySQL Database**
Run in MySQL terminal:
```sql
CREATE DATABASE employeedb;
USE employeedb;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DOUBLE
);

2. Add MySQL Driver to VS Code

Create a lib folder in your project

Place mysql-connector-j-9.4.0.jar inside it

In .vscode/settings.json add:

{
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}

3. Update DB Credentials

Edit DBConnection.java:

private static final String USER = "root";
private static final String PASSWORD = "your_password";

4. Run the App

In VS Code:

Open Command Palette → Java: Clean Workspace

Press Ctrl+F5 to run Main.java

Follow the menu to perform CRUD operations