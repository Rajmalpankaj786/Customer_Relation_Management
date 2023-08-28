# Customer_Relation_Management

![ER (1)](https://github.com/Rajmalpankaj786/Customer_Relation_Management/assets/112754581/89d66059-9236-4268-aba0-2ba0a79e8b5a)
The Console-based Customer Relationship Management (CRM) System is a software solution designed to enhance customer interactions, improve issue resolution, and overall customer satisfaction. The system aims to provide businesses with tools to efficiently manage customer issues and provide effective customer support. The CRM system will be developed using Java programming language, MySQL as the database management system.

Types of Users
1.Hod
2.Engineer
3.Employee


Role of Customer Support Representative
Register for a Engineer support representative account by providing the necessary information.
Log in to the Engineer support representative account using registered credentials.
View and manage the issues raised by Engineer.
Reply to Engineer issues, providing necessary assistance and information.
Close the Engineer issues after resolution.
View feedback given by Engineer on closed issues.
Log out from the Employee support representative account.

Role of Employee
Register for a Employee account by providing necessary information.
Log in to the Employee account using registered credentials.
Raise an issue by providing a description of the problem.
View the status of the raised issue, whether it is open or closed.
Provide feedback once the issue is closed.
Log out from the Employee account.




# all SQl Query used in project
create table Hod(
    ->  HodId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ->   name VARCHAR(30) NOT NULL,
    ->  username VARCHAR(30) NOT NULL,
    ->   password VARCHAR(30) NOT NULL
    -> );

mysql> desc hod;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| HodId    | int         | NO   | PRI | NULL    | auto_increment |
| name     | varchar(30) | NO   |     | NULL    |                |
| username | varchar(30) | NO   |     | NULL    |                |
| password | varchar(30) | NO   |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+


mysql> create table employee(
    -> empId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ->  depId int ,
    ->  name VARCHAR(30) NOT NULL,
    ->  username VARCHAR(30) NOT NULL,
    ->  password VARCHAR(30) NOT NULL
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> desc employee;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| empId | int         | NO   | PRI | NULL    | auto_increment |
| deptId  | int         | YES  |     | NULL    |                |
| name       | varchar(30) | NO   |     | NULL    |                |
| username   | varchar(30) | NO   |     | NULL    |                |
| password   | varchar(30) | NO   |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+

mysql>  create table Engineer(
    -> engID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -> name VARCHAR(30) NOT NULL,
    ->  username VARCHAR(30) NOT NULL,
    ->  password VARCHAR(30) NOT NULL,
    -> type VARCHAR(30),
    ->  location VARCHAR(30) NOT NULL
    -> );


mysql> desc Engineer;
+-------------------+-------------+------+-----+---------+----------------+
| Field             | Type        | Null | Key | Default | Extra          |
+-------------------+-------------+------+-----+---------+----------------+
| engID | int         | NO   | PRI | NULL    | auto_increment |
| name              | varchar(30) | NO   |     | NULL    |                |
| username          | varchar(30) | NO   |     | NULL    |                |
| password          | varchar(30) | NO   |     | NULL    |                |
| type              | varchar(30) | YES  |     | NULL    |                |
| location          | varchar(30) | NO   |     | NULL    |                |
+-------------------+-------------+------+-----+---------+----------------+

mysql> CREATE TABLE Complaint (
    ->     complaintId INT NOT NULL PRIMARY KEY,
    -> empId int ,
    -> complaintType VARCHAR(30),
    -> engId int,
    ->  status VARCHAR(20),
    ->     dateRaised DATE,
    ->     dateResolved DATE
    -> );
Query OK, 0 rows affected (0.04 sec)

mysql> desc  Complaint;
+-------------------+-------------+------+-----+---------+-------+
| Field             | Type        | Null | Key | Default | Extra |
+-------------------+-------------+------+-----+---------+-------+
| complaintId       | int         | NO   | PRI | NULL    |       |
| empId        | int         | YES  |     | NULL    |       |
| complaintType     | varchar(30) | YES  |     | NULL    |       |
| ServiceProviderId | int         | YES  |     | NULL    |       |
| status            | varchar(20) | YES  |     | NULL    |       |
| dateRaised        | date        | YES  |     | NULL    |       |
| dateResolved      | date        | YES  |     | NULL    |       |
+-------------------+-------------+------+-----+---------+-------+



mysql> CREATE TABLE Department (
    -> deptId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ->     dname VARCHAR(30) NOT NULL UNIQUE,
    ->     location VARCHAR(30) NOT NULL
    -> );


mysql> desc Department;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| deptId    | int         | NO   | PRI | NULL    | auto_increment |
| dname     | varchar(30) | NO   | UNI | NULL    |                |
| location  | varchar(30) | NO   |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+


mysql> use  hardware_software_support;
Database changed
mysql> show tables;
+--------------------------------------------+
| Tables_in_hardware_software_support |
+--------------------------------------------+
| complaint                                  |
| employee                                   |
| hod                                        |
| department                                 |
| engineer                                   |
+--------------------------------------------+
5 rows in set (0.00 sec)

mysql> insert into  Hod (HodId, name, username, password) VALUES (12345, 'admin', 'admin', 'Admin');
Query OK, 1 row affected (0.01 sec)

mysql> select * from Hod;
+-------+-------+----------+----------+
| hodId | name  | username | password |
+-------+-------+----------+----------+
| 12345 | admin | admin    | Admin    |
+-------+-------+----------+----------+

