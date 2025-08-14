CREATE DATABASE IF NOT EXISTS employeedb;
USE employeedb;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50),
    salary DOUBLE
);
select * from employee;
